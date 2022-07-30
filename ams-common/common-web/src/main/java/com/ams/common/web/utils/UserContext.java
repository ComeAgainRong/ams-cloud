package com.ams.common.web.utils;



import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ams.common.constan.SecurityConstants;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Objects;

/**
 * @Author: xr
 * @Date: 2022-07-11-10:28
 * @Description:
 */
public class UserContext {

    public static Long getCurrentUserId(){
        String token = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader(SecurityConstants.JWT_PAYLOAD_KEY);
        if(StringUtils.isEmpty(token)){
            return  null;
        }
        try {
            JSONObject jsonObject= JSON.parseObject(URLDecoder.decode(token,"UTF-8"));
            if(Objects.isNull(jsonObject)){
                return null;
            }
            return jsonObject.getLong("userId");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return null;

    }
}
