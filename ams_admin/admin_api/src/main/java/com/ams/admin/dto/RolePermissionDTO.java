package com.ams.admin.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @ClassName : { RolePermissionDTO }
 * @Author : {whisper}
 * @Date : {Created in 16:47 2022/1/30}
 */
@Data
@Accessors(chain = true)
public class RolePermissionDTO {

    private Long roleId;
    private List<Long> permissionIds;
    private  Long menuId;

}
