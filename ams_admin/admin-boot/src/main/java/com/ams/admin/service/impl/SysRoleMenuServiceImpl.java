package com.ams.admin.service.impl;


import cn.hutool.core.collection.CollectionUtil;
import com.ams.admin.mapper.SysRoleMenuMapper;
import com.ams.admin.mapper.SysUserRoleMapper;
import com.ams.admin.pojo.entity.SysRoleMenu;
import com.ams.admin.pojo.entity.SysUserRole;
import com.ams.admin.service.ISysRoleMenuService;
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
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu> implements ISysRoleMenuService {



}
