package com.ams.admin.pojo.req;

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
public class SavePermissionReq implements Serializable {


    private Long id;

    @NotBlank(message = "name 不能为空")
    private String name;

    @NotNull(message = "menuId 不能为空")
    private Long menuId;

    @NotBlank(message = "method 不能为空")
    private String method;

    @NotBlank(message = "serviceName 不能为空")
    private String serviceName;

    @NotBlank(message = "url 不能为空")
    private String url;


}
