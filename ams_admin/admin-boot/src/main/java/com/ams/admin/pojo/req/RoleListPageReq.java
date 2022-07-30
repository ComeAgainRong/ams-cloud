package com.ams.admin.pojo.req;

import com.ams.common.entity.PageReq;
import lombok.Data;

/**
 * @Author: xr
 * @Date: 2022-07-10-23:38
 * @Description:
 */
@Data
public class RoleListPageReq extends PageReq {

    private String keyword;

}
