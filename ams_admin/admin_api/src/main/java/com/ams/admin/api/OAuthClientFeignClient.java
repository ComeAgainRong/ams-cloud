package com.ams.admin.api;

import com.ams.admin.dto.OAuth2ClientDTO;
import com.ams.common.result.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName : { OAuthClientFeignClient }
 * @Author : {whisper}
 * @Date : {Created in 16:50 2022/1/30}
 * 获取客户端信息的feign
 */
@FeignClient(value = "ams_admin",contextId = "oauth-client")
public interface OAuthClientFeignClient {

    /**
     * 获取客户端信息
     * @param clientId
     * @return
     */
    @GetMapping("/api/oauth-clients/getOAuth2ClientById")
    R<OAuth2ClientDTO> getOAuth2ClientById(@RequestParam String clientId);
}
