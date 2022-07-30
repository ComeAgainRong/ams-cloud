package com.ams.admin.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @description 角色权限表
 * @author xr
 * @date 2022-07-23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysRolePermission implements Serializable {


    /**
    * 角色id
    */
    private Long roleId;

    /**
    * 资源id
    */
    private Long permissionId;


}