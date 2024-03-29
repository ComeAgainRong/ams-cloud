package com.ams.admin.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;
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
public class SysPermission  extends BaseEntity{

    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;

    private Long menuId;

    private String urlPerm;

    private String  btnSign;


    // 有权限的角色编号集合
    @TableField(exist = false)
    private List<String> roles;



}
