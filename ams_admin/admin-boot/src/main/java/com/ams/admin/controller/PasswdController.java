package com.ams.admin.controller;

import com.ams.common.result.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author whisper
 */
@Api(tags = "密码管理")
@RestController
@RequestMapping("/passwd")
@RequiredArgsConstructor
public class PasswdController {
    private final PasswordEncoder passwordEncoder;

    @ApiOperation("生成密码")
    @GetMapping("/genPasswd/{passwd}")
    public R<String> genPasswd(@PathVariable("passwd") String passwd){
        return R.ok(passwordEncoder.encode(passwd));
    }
}