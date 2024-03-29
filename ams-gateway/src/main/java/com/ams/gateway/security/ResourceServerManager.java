package com.ams.gateway.security;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import com.ams.common.constan.GlobalConstants;
import com.ams.common.constan.SecurityConstants;
import com.ams.gateway.util.UrlPatternUtils;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.ReactiveAuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.server.authorization.AuthorizationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName : { ResourceServerManager }
 * @Author : {whisper}
 * @Date : {Created in 17:03 2022/2/26}
 */
@Component
@RequiredArgsConstructor
@Slf4j
@ConfigurationProperties(prefix = "security")
public class ResourceServerManager implements ReactiveAuthorizationManager<AuthorizationContext> {
    private final RedisTemplate redisTemplate;
    @Setter
    private List<String> ignoreUrls;

    @Override
    public Mono<AuthorizationDecision> check(Mono<Authentication> mono, AuthorizationContext authorizationContext) {
        ServerHttpRequest request = authorizationContext.getExchange().getRequest();
        // 预检请求放行
        if (request.getMethod() == HttpMethod.OPTIONS) {
            return Mono.just(new AuthorizationDecision(true));
        }
        PathMatcher pathMatcher = new AntPathMatcher();
        String method = request.getMethodValue();
        String path = request.getURI().getPath();

        // 跳过token校验，放在这里去做是为了能够动态刷新
        if (skipValid(path)) {
            return Mono.just(new AuthorizationDecision(true));
        }

        // 如果token为空 或者token不合法 则进行拦截
        // RESTFul接口权限设计 @link https://www.cnblogs.com/haoxianrui/p/14961707.html
        String restfulPath = method + ":" + path;
        log.info("gateway restfulPath:{}",restfulPath);
        String token = request.getHeaders().getFirst(SecurityConstants.AUTHORIZATION_KEY);
        if (StrUtil.isBlank(token) || !StrUtil.startWithIgnoreCase(token, SecurityConstants.JWT_PREFIX)) {
            return Mono.just(new AuthorizationDecision(false));
        }

        // 从redis中获取资源权限
        Map<String, Object> urlPermRolesRules = redisTemplate.opsForHash().entries(GlobalConstants.URL_PERM_ROLES_KEY);
        // 拥有访问权限的角色
        List<String> authorizedRoles = new ArrayList<>();
        // 是否需要鉴权，默认未设置拦截规则不需鉴权
        boolean requireCheck = false;

        // 获取当前资源 所需要的角色
        for (Map.Entry<String, Object> permRoles : urlPermRolesRules.entrySet()) {
            String perm = permRoles.getKey();
            log.info("perm the log => {}::",perm);
            if (pathMatcher.match(perm, restfulPath)) {
                log.info(restfulPath);
                List<String> roles = Convert.toList(String.class, permRoles.getValue());
                authorizedRoles.addAll(Convert.toList(String.class, roles));
                if (requireCheck ==false){
                    requireCheck = true;
                }
                log.info("roleList the log => {}:",authorizedRoles);
            }
        }

        // 如果资源不需要权限 则直接返回授权成功
        if (requireCheck==false){
            return Mono.just(new AuthorizationDecision(false));
        }

        // 判断JWT中携带的用户角色是否有权限访问
        Mono<AuthorizationDecision> authorizationDecisionMono = mono
                .filter(Authentication::isAuthenticated)
                .flatMapIterable(Authentication::getAuthorities)
                .map(GrantedAuthority::getAuthority)
                .any(authority -> {
                    String roleCode = authority.substring(SecurityConstants.AUTHORITY_PREFIX.length()); // 用户的角色
                    boolean hasAuthorized = CollectionUtil.isNotEmpty(authorizedRoles) && authorizedRoles.contains(roleCode);

                    //当前用户角色
                    log.info("The current user role the log => {}:",roleCode);
                    //判断是否有这个角色
                    log.info("Determine whether there is the role the log => {}:",hasAuthorized);
                    //获取出的角色
                    log.info("Get out of the role the log => {}:",authorizedRoles);
                    if (hasAuthorized) {
                        System.out.println(hasAuthorized+"hasAuthorizedhasAuthorized");
                    }
                    return hasAuthorized;
                })
                .map(AuthorizationDecision::new)
                .defaultIfEmpty(new AuthorizationDecision(false));
        return authorizationDecisionMono;
    }

    /**
     * 跳过校验
     *
     * @param path
     * @return
     */
    private boolean skipValid(String path) {
        for (String skipPath : ignoreUrls) {
            if (UrlPatternUtils.match(skipPath, path)) {
                return true;
            }
        }
        return false;
    }
}
