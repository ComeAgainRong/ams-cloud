package com.ams.admin.pojo.req;

import com.ams.admin.pojo.entity.BaseEntity;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author： 乐哥聊编程(全平台同号)
 */
@Data
public class SaveSysRoleReq extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * id
    */

    private Long id;

    /**
    * 角色名称
    */
    @NotBlank(message = "name 不能为空")
    private String name;

    /**
    * 角色编码
    */
    @NotBlank(message = "code 不能为空")
    private String code;

    /**
    * 显示顺序
    */
    @NotNull(message = "sort 不能为空")
    private Integer sort;

    /**
    * 角色状态：0-正常；1-停用
    */
    private int status;

    /**
    * 逻辑删除标识：0-未删除；1-已删除
    */
    private int deleted;

    public SaveSysRoleReq() {}
}