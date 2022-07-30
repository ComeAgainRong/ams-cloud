package com.ams.admin.pojo.req;

import com.ams.admin.pojo.entity.BaseEntity;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class SaveMenuReq extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * id
    */
    private Long id;

    /**
    * 菜单名称
    */
    @NotBlank(message = "name 不能为空")
    private String name;

    /**
    * 父菜单id
    */
    @NotNull(message = "parentId 不能为空")
    private Long parentId;

    /**
    * 路由路径
    */
    @NotBlank(message = "path 不能为空")
    private String path;

    /**
    * 组件路径
    */
    @NotBlank(message = "component 不能为空")
    private String component;

    /**
    * 菜单图标
    */
    private String icon;

    /**
    * 排序
    */
    @NotNull(message = "sort 不能为空")
    private Integer sort;

    /**
    * 状态：0-禁用 1-开启
    */
    private int visible;

    /**
    * 跳转路径
    */
    private String redirect;


    public SaveMenuReq() {}
}