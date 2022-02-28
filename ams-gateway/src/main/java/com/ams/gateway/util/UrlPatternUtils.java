package com.ams.gateway.util;

import cn.hutool.core.util.StrUtil;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

/**
 * Created with IntelliJ IDEA.
 *
 * @author： xr
 * @date： 2021/11/29
 * @description：
 * @modifiedBy：
 * @version: 1.0
 */
public class UrlPatternUtils {
    public static boolean match(String patternUrl, String requestUrl) {
        if (StrUtil.isBlank(patternUrl) || StrUtil.isBlank(requestUrl)) {
            return false;
        }
        PathMatcher matcher = new AntPathMatcher();
        return matcher.match(patternUrl, requestUrl);
    }

    public static void main(String[] args) {
        System.out.println(match("/a/b/c/**","/a/b/c/d/e"));
    }
}
