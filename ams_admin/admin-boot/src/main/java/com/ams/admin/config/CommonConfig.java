package com.ams.admin.config;

import com.ams.admin.hander.MyMetaObjectHandler;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: xr
 * @Date: 2022-07-15-10:13
 * @Description:
 */
@Configuration
public class CommonConfig {
    /**
     * 自动填充数据库创建人、创建时间、更新人、更新时间
     */
    @Bean
    public GlobalConfig globalConfig() {
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setMetaObjectHandler(new MyMetaObjectHandler());
        return globalConfig;
    }
}
