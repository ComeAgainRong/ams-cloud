package com.ams.common.entity;

import lombok.Data;

import java.util.List;

/**
 * @Author: xr
 * @Date: 2022-07-11-0:09
 * @Description:
 */
@Data
public class APage<T> {
    /**
     * 条数
     */
    private Long total;
    /**
     * 页数
     */
    private Long pageNo;
    /**
     * 页面条数
     */
    private Long pageSize;
    /**
     * 数据
     */
    private List<T> list;
}