package com.ams.admin.pojo.vo;

import lombok.Data;

/**
 * @Author: xr
 * @Date: 2022-07-10-13:53
 * @Description:
 */
@Data
public class SysRoleVO {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色编码
     */
    private String code;

    /**
     * 显示顺序
     */
    private Integer sort;

    /**
     * 角色状态：0-正常；1-停用
     */
    private int status;

    /**
     * 逻辑删除标识：0-未删除；1-已删除
     */
    private int deleted;
}
