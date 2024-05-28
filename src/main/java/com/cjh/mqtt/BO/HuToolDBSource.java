package com.cjh.mqtt.BO;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Data
@Configuration
@ConfigurationProperties(prefix = "hutool-db")
public class HuToolDBSource {
    public static Map dbPool;

    public static Map getDbPool() {
        return dbPool;
    }

    public static void setDbPool(Map dbPool) {
        HuToolDBSource.dbPool = dbPool;
    }
}
