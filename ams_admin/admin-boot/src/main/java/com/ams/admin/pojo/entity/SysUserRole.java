package com.ams.admin.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * @description 用户和角色关联表
 * @author whisper
 * @date 2022-07-10
 */
@Data
public class SysUserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * 用户id
    */
    private Long userId;

    /**
    * 角色id
    */
    private Long roleId;

    public SysUserRole() {}

    public SysUserRole(Long userId, Long roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }
}