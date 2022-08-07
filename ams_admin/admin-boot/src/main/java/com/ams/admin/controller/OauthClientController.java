package com.ams.admin.controller;

import cn.hutool.core.bean.BeanUtil;
import com.ams.admin.dto.OAuth2ClientDTO;
import com.ams.admin.pojo.entity.SysOauthClient;
import com.ams.admin.service.ISysOauthClientService;
import com.ams.common.result.R;
import cn.hutool.core.lang.Assert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName  : { OauthClientController }
 * @Author : {whisper}
 * @Date : {Created in 14:57 2022/2/2}
 */
@RequestMapping("/api/oauth-clients")
@RestController
@Slf4j
@AllArgsConstructor
@Api(tags = "客户端管理")
public class OauthClientController {
    private ISysOauthClientService iSysOauthClientService;

    @ApiOperation("客户端验证")
    @GetMapping("/getOAuth2ClientById")
    public R<OAuth2ClientDTO> getOAuth2ClientById(@RequestParam String clientId) {
        SysOauthClient client = iSysOauthClientService.getById(clientId);
        Assert.notNull(client, "OAuth2 客户端不存在");
        OAuth2ClientDTO oAuth2ClientDTO = new OAuth2ClientDTO();
        BeanUtil.copyProperties(client, oAuth2ClientDTO);
        return R.ok(oAuth2ClientDTO);
    }
}
