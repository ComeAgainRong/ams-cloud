package com.ams.common.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: xr
 * @Date: 2022-07-10-23:36
 * @Description:
 */
@Data
public class PageReq implements Serializable {

    private Long pageNo;
    private Long PageSize;
}
