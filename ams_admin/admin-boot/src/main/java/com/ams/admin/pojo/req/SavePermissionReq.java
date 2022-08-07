package com.ams.admin.pojo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @author： 
 * @date： 2021/11/24
 * @description：
 * @modifiedBy：
 * @version: 1.0
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "SavePermissionReq",description = "权限接收类")
public class SavePermissionReq implements Serializable {

    @ApiModelProperty(value = "主键",name = "id")
    private Long id;

    @ApiModelProperty(value = "名称",name = "name")
    @NotBlank(message = "name 不能为空")
    private String name;

    @ApiModelProperty(value = "菜单id",name = "menuId")
    @NotNull(message = "menuId 不能为空")
    private Long menuId;

    @ApiModelProperty(value = "访问类型",name = "method")
    @NotBlank(message = "method 不能为空")
    private String method;

    @ApiModelProperty(value = "服务名",name = "serviceName")
    @NotBlank(message = "serviceName 不能为空")
    private String serviceName;

    @ApiModelProperty(value = "url",name = "url")
    @NotBlank(message = "url 不能为空")
    private String url;

    @ApiModelProperty(value = "按钮标识",name = "btnSign")
    @NotBlank(message = "btnSign 不能为空")
    private String btnSign;


}
