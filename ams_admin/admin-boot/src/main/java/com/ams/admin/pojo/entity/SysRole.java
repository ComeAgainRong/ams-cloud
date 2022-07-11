package com.ams.admin.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @description 角色表
 * @author whisper
 * @date 2022-07-10
 */
@Data
public class SysRole implements Serializable {

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

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 更新时间
    */
    private Date updateTime;

    /**
    * 更新者
    */
    private String updateBy;

    /**
    * 创建者
    */
    private String createBy;

    public SysRole() {}
}