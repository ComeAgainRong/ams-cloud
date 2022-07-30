package com.ams.admin.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
/**
 * @author： xr
 */
@Configuration
@ConfigurationProperties(prefix ="admin")
@Data
public class AdminConfig {
    private List<String> services;
}
