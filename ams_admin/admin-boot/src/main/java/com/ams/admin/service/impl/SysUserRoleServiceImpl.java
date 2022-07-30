package com.ams.admin.service.impl;


import cn.hutool.core.collection.CollectionUtil;
import com.ams.admin.mapper.SysUserRoleMapper;
import com.ams.admin.pojo.entity.SysUserRole;
import com.ams.admin.service.ISysUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
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
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements ISysUserRoleService {


    @Override
    public List<Long> selectRoleIds(Long userId) {
        List<SysUserRole> userRoles = lambdaQuery().eq(SysUserRole::getUserId, userId).list();
        if(CollectionUtil.isNotEmpty(userRoles)){
            return userRoles.stream().map(SysUserRole::getRoleId).collect(Collectors.toList());
        }
        return Collections.EMPTY_LIST;
    }

    @Override
    public void deleteByUserId(Long userId) {
        this.baseMapper.delete(lambdaQuery().eq(SysUserRole::getUserId,userId).getWrapper());
    }
}
