package com.ams.admin.service.impl;


import cn.hutool.core.collection.CollectionUtil;
import com.ams.admin.mapper.SysRoleMenuMapper;
import com.ams.admin.mapper.SysRolePermissionMapper;
import com.ams.admin.pojo.entity.SysRoleMenu;
import com.ams.admin.pojo.entity.SysRolePermission;
import com.ams.admin.pojo.req.CommonReq;
import com.ams.admin.service.ISysRoleMenuService;
import com.ams.admin.service.ISysRolePermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 *
 * @author： whisper
 * @date： 2021/11/24
 * @description：
 * @modifiedBy：
 * @version: 1.0
 */
@Service
@RequiredArgsConstructor
public class SysRolePermissionServiceImpl extends ServiceImpl<SysRolePermissionMapper, SysRolePermission> implements ISysRolePermissionService {


    @Override
    public void updateRolePermission(Long roleId, CommonReq req) {
        if(CollectionUtil.isNotEmpty(req.getIds())){
            //删除之前绑定的信息
            this.getBaseMapper().delete(lambdaQuery().eq(SysRolePermission::getRoleId,roleId).getWrapper());
            //添加新的绑定信息
            List<SysRolePermission> rolePermissions = req.getIds().stream().map(permissionId -> new SysRolePermission(roleId, permissionId)).collect(Collectors.toList());
            this.saveBatch(rolePermissions);
        }
    }
}
