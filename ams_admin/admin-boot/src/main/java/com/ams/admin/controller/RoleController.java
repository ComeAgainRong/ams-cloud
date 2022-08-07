package com.ams.admin.controller;

import com.ams.admin.dto.UserAuthDTO;
import com.ams.admin.pojo.req.RoleListPageReq;
import com.ams.admin.pojo.req.SaveSysRoleReq;
import com.ams.admin.pojo.vo.SysRoleSelectVO;
import com.ams.admin.pojo.vo.SysRoleVO;
import com.ams.admin.pojo.vo.SysUserVO;
import com.ams.admin.service.ISysRoleService;
import com.ams.admin.service.ISysUserService;
import com.ams.common.entity.APage;
import com.ams.common.result.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName : { UserController }
 * @Author : {whisper}
 * @Date : {Created in 15:03 2022/2/2}
 */
@Api(tags = "角色管理")
@RestController
@RequestMapping("/role")
@Slf4j
@RequiredArgsConstructor
public class RoleController {

    private  final ISysRoleService roleService;

    /**
     * 角色列表select
     */
    @ApiOperation("角色列表select")
    @GetMapping("/select")
    public R<List<SysRoleSelectVO>> roleSelect(){
        List<SysRoleSelectVO> roles =roleService.roleSelect();
        return  R.ok(roles);
    }

    /**
     * 列表分页
     */
    @ApiOperation("列表分页")
    @PostMapping("/listPage")
    public R<List<SysRoleVO>> listPage(@RequestBody RoleListPageReq req){
        APage<SysRoleVO>  sysRoleVOAPage=roleService.listPage(req);
        return  R.page(sysRoleVOAPage);
    }

    /**
     * 新增角色
     * @param req
     * @return
     */
    @ApiOperation("新增角色")
    @PostMapping
    public R createRole(@RequestBody SaveSysRoleReq req){
       roleService.createRole(req);
       return  R.ok();
    }

    /**
     * 更新角色
     */
    @ApiOperation("更新角色")
    @PutMapping
    public R updateRole(@RequestBody SaveSysRoleReq req){
        roleService.updateRole(req);
        return R.ok();
    }
    /**
     * 更新角色状态
     */
    @ApiOperation("更新角色状态")
    @PatchMapping("/updateStatus/{id}/{status}")
    public  R updateRoleStatus(@PathVariable Long id,@PathVariable Long status){
        roleService.updateRoleStatus(id,status);
        return R.ok();
    }
    /**
     * 删除角色
     */
    @ApiOperation("删除角色")
    @DeleteMapping("/{ids}")
    public R deleteRole(@PathVariable List<Long> ids){
        roleService.deleteRole(ids);
        return R.ok();
    }



}
