package com.ams.admin.pojo.vo;

import lombok.Data;

import java.util.List;

/**
 * @Author: xr
 * @Date: 2022-07-22-10:26
 * @Description:
 */
@Data
public class SysMenuSelectVO {
    private Long id;
    private String label;
    private List<SysMenuSelectVO> children;
}
