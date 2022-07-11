package com.ams.admin.controller;

import com.ams.admin.dto.UserAuthDTO;
import com.ams.admin.pojo.vo.SysRoleVO;
import com.ams.admin.service.ISysRoleService;
import com.ams.admin.service.ISysUserService;
import com.ams.common.result.R;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName : { UserController }
 * @Author : {whisper}
 * @Date : {Created in 15:03 2022/2/2}
 */
@RestController
@RequestMapping("/role")
@Slf4j
@RequiredArgsConstructor
public class RoleController {

    private  final ISysRoleService roleService;

    /**
     * 角色列表select
     */
    @GetMapping("/select")
    public R<List<SysRoleVO>> roleSelect(){
        List<SysRoleVO> roles =roleService.roleSelect();
        return  R.ok(roles);
    }


}
