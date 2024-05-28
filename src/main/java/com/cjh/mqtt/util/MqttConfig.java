package com.cjh.mqtt.util;

import com.cjh.mqtt.receiveclient.MqttAcceptClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqttConfig {

    @Autowired
    private MqttAcceptClient mqttAcceptClient;


    /**
     * 订阅mqtt
     *
     * @return
     */
   @Conditional(MqttCondition.class)
    @Bean
    public MqttAcceptClient getMqttPushClient() {
        mqttAcceptClient.connect();
        return mqttAcceptClient;
    }
//    @Conditional(MqttCondition.class)
//    @Bean
//    public MqttAcceptClient2 getMqttPushClient2() {
//        mqttAcceptClient2.connect();
//        return mqttAcceptClient2;
//    }




}

