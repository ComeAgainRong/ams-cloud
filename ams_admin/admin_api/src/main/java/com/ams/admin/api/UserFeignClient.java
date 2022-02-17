package com.ams.admin.api;

import com.ams.admin.dto.UserAuthDTO;
import com.ams.common.result.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName : { UserFeignClient }
 * @Author : {whisper}
 * @Date : {Created in 16:51 2022/1/30}
 */
@FeignClient(value = "ams-admin")
public interface UserFeignClient {
    /**
     * 根据用户名获取用户信息的feign
     * @param username
     * @return
     */
    @GetMapping("/api/v1/users/username/{username}")
    R<UserAuthDTO> getUserByUsername(@PathVariable String username);
}
