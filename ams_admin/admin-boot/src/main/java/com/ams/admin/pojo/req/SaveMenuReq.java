package com.ams.admin.pojo.req;

import com.ams.admin.pojo.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@ApiModel(value = "SaveMenuReq",description = "菜单接收类")
public class SaveMenuReq extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * id
    */
    @ApiModelProperty(value = "主键",name = "id")
    private Long id;

    /**
    * 菜单名称
    */
    @ApiModelProperty(value = "菜单名称",name = "name")
    @NotBlank(message = "name 不能为空")
    private String name;

    /**
    * 父菜单id
    */
    @ApiModelProperty(value = "父菜单id",name = "parentId")
    @NotNull(message = "parentId 不能为空")
    private Long parentId;

    /**
    * 路由路径
    */
    @ApiModelProperty(value = "路由路径",name = "path")
    @NotBlank(message = "path 不能为空")
    private String path;

    /**
    * 组件路径
    */
    @ApiModelProperty(value = "组件路径",name = "component")
    @NotBlank(message = "component 不能为空")
    private String component;

    /**
    * 菜单图标
    */
    @ApiModelProperty(value = "菜单图标",name = "icon")
    private String icon;

    /**
    * 排序
    */
    @ApiModelProperty(value = "排序",name = "sort")
    @NotNull(message = "sort 不能为空")
    private Integer sort;

    /**
    * 状态：0-禁用 1-开启
    */
    @ApiModelProperty(value = "状态",name = "visible")
    private int visible;

    /**
    * 跳转路径
    */
    @ApiModelProperty(value = "跳转路径",name = "redirect")
    private String redirect;


    public SaveMenuReq() {}
}