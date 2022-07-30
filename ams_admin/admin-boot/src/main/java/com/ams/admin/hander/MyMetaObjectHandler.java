package com.ams.admin.hander;

import com.ams.common.web.utils.UserContext;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @ClassName : { MyMetaObjectHandler }
 * @Author : {whisper}
 * @Date : {Created in 15:56 2022/1/19}
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    /**
     * 新增填充创建时间
     *
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "createTime", () -> new Date(), Date.class);
        this.strictUpdateFill(metaObject, "updateTime", () -> new Date(), Date.class);
        this.strictInsertFill(metaObject, "createBy", () -> UserContext.getCurrentUserId(), Long.class);
        this.strictUpdateFill(metaObject, "updateBy", () -> UserContext.getCurrentUserId(), Long.class);
    }

    /**
     * 更新填充更新时间 操作人
     *
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "updateTime", () -> new Date(), Date.class);
        this.strictUpdateFill(metaObject, "updateBy", () -> UserContext.getCurrentUserId(), Long.class);
    }
}
