package com.ams.admin.pojo.req;

import com.ams.admin.pojo.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author： 乐哥聊编程(全平台同号)
 */
@Data
@ApiModel(value = "SaveSysRoleReq",description = "角色接收类")
public class SaveSysRoleReq extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * id
    */
    @ApiModelProperty(value = "主键",name = "id")
    private Long id;

    /**
    * 角色名称
    */
    @ApiModelProperty(value = "角色名称",name = "name")
    @NotBlank(message = "name 不能为空")
    private String name;

    /**
    * 角色编码
    */
    @ApiModelProperty(value = "角色编码",name = "code")
    @NotBlank(message = "code 不能为空")
    private String code;

    /**
    * 显示顺序
    */
    @ApiModelProperty(value = "显示顺序",name = "sort")
    @NotNull(message = "sort 不能为空")
    private Integer sort;

    /**
    * 角色状态：0-正常；1-停用
    */
    @ApiModelProperty(value = "角色状态",name = "status")
    private int status;

    /**
    * 逻辑删除标识：0-未删除；1-已删除
    */
    @ApiModelProperty(value = "逻辑删除标识",name = "deleted")
    private int deleted;

    public SaveSysRoleReq() {}
}