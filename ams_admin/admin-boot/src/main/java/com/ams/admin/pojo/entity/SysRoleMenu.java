package com.ams.admin.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @description 角色和菜单关联表
 * @author xr
 * @date 2022-07-23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysRoleMenu implements Serializable {

    /**
    * 角色id
    */
    private Long roleId;

    /**
    * 菜单id
    */
    private Long menuId;

}