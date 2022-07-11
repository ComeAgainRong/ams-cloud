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
    private Long total;
    private Long pageNo;
    private Long pageSize;
    private List<T> list;
}