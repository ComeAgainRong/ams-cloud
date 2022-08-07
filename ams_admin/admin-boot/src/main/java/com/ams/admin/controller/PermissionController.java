package com.ams.admin.controller;

import com.ams.admin.pojo.req.CommonReq;
import com.ams.admin.pojo.req.SavePermissionReq;
import com.ams.admin.pojo.vo.SysPermissionVO;
import com.ams.admin.pojo.vo.SysServiceVO;
import com.ams.admin.service.ISysPermissionService;
import com.ams.admin.service.ISysRolePermissionService;
import com.ams.common.result.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName : { UserController }
 * @Author : {whisper}
 * @Date : {Created in 15:03 2022/2/2}
 */
@Api(tags = "权限管理")
@RestController
@RequestMapping("/permission")
@Slf4j
@RequiredArgsConstructor
public class PermissionController {

    private final ISysPermissionService permissionService;

    private final ISysRolePermissionService rolePermissionService;

    /**
     * 权限列表
     */
    @ApiOperation("权限列表")
    @GetMapping("/list/{menuId}")
    public R<List<SysPermissionVO>> list(@PathVariable Long menuId) {
        List<SysPermissionVO> permissionVOS = permissionService.listByMenuId(menuId);
        return R.ok(permissionVOS);
    }

    /**
     * 新增权限
     */
    @ApiOperation("新增权限")
    @PostMapping()
    public R createPermission(@Validated @RequestBody SavePermissionReq req) {
        permissionService.createPermission(req);
        return R.ok();
    }


    /**
     * 更新权限信息
     */
    @ApiOperation("更新权限信息")
    @PutMapping()
    public R updatePermission(@Validated @RequestBody SavePermissionReq req) {
        permissionService.updatePermission(req);
        return R.ok();
    }

    /**
     * 获取服务列表
     */
    @ApiOperation("获取服务列表")
    @GetMapping("/services")
    public R<List<SysServiceVO>> getServices() {
        List<SysServiceVO> sysServiceVOS = permissionService.getService();
        return R.ok(sysServiceVOS);

    }

    /**
     * 删除权限
     */
    @ApiOperation("删除权限")
    @DeleteMapping("/{ids}")
    public R detelePermission(@PathVariable List<Long> ids) {
        permissionService.detelePermission(ids);
        return R.ok();
    }

    /**
     * 查询角色绑定的权限
     */
    @ApiOperation("查询角色绑定的权限")
    @GetMapping("/role/{roleId}")
    public R<List<Long>> listRolePermission(@PathVariable Long roleId) {
        List<Long> permissions = permissionService.listRolePermission(roleId);
        return R.ok(permissions);
    }
    /**
     * 更新角色绑定的权限
     */
    @ApiOperation("更新角色绑定的权限")
    @PutMapping("/role/{roleId}")
    public R<List<Long>> updateRolePermission(@PathVariable Long roleId,@RequestBody CommonReq req){
        rolePermissionService.updateRolePermission(roleId,req);
        return R.ok();
    }
}
