package com.ams.admin.pojo.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
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
public class SysPermissionVO implements Serializable {


    private Long id;

    private String name;

    private Long menuId;

    private String urlPerm;

    private String  btnSign;

}
