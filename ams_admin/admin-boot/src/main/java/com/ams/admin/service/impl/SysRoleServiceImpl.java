package com.ams.admin.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.ams.admin.config.AdminMapStruct;
import com.ams.admin.dto.UserAuthDTO;
import com.ams.admin.mapper.SysRoleMapper;
import com.ams.admin.mapper.SysUserMapper;
import com.ams.admin.pojo.entity.SysRole;
import com.ams.admin.pojo.entity.SysUser;
import com.ams.admin.pojo.vo.SysRoleVO;
import com.ams.admin.service.ISysRoleService;
import com.ams.admin.service.ISysUserService;
import com.ams.common.constan.GlobalConstants;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

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
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole > implements ISysRoleService {

    private final AdminMapStruct adminMapStruct;
    @Override
    public List<SysRoleVO> roleSelect() {
        List<SysRole> list = lambdaQuery().eq(SysRole::getStatus, GlobalConstants.STATUS_ON).select(SysRole::getId, SysRole::getName).list();
        if(CollectionUtil.isNotEmpty(list)){
            return  adminMapStruct.sysRoleToSysRoleVO(list);
        }
        return Collections.EMPTY_LIST;
    }
}
