package com.cjh.mqtt.util;

import com.cjh.mqtt.receiveclient2.MqttAcceptClient2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqttConfig2 {

    @Autowired
    private MqttAcceptClient2 mqttAcceptClient2;


    /**
     * 订阅mqtt
     *
     * @return
     */
   @Conditional(MqttCondition.class)
    @Bean
    public MqttAcceptClient2 getMqttPushClient2() {
        mqttAcceptClient2.connect();
        return mqttAcceptClient2;
    }
//    @Conditional(MqttCondition.class)
//    @Bean
//    public MqttAcceptClient2 getMqttPushClient2() {
//        mqttAcceptClient2.connect();
//        return mqttAcceptClient2;
//    }




}

