package com.ams.admin.utils;

import com.ams.common.entity.APage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * @Author: xr
 * @Date: 2022-07-11-0:08
 * @Description:
 */
public class PageUtils {
    public static <T> APage<T> flush(Page page, List<T> list ) {
        APage<T> amsPage = new APage<>();
        amsPage.setPageNo(page.getPages());
        amsPage.setPageSize(page.getSize());
        amsPage.setTotal(page.getTotal());
        amsPage.setList(list);
        return amsPage;
    }
}
