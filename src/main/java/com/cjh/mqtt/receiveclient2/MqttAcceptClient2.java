package com.cjh.mqtt.receiveclient2;

import com.cjh.mqtt.util.MqttProperties;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MqttAcceptClient2 {

    private static final Logger logger = LoggerFactory.getLogger(MqttAcceptClient2.class);

    @Autowired
    private MqttAcceptCallback2 mqttAcceptCallback2;

    @Autowired
    private MqttProperties mqttProperties1;

    public static MqttClient client1;

    private static MqttClient getClient() {
        return client1;
    }

    private static void setClient(MqttClient client) {
        MqttAcceptClient2.client1 = client;
    }

    /**
     * 客户端连接
     */
    public void connect() {
        MqttClient client1;
//        Date date3 = DateUtil.date(System.currentTimeMillis());
//        //时间
//        String formatDateTime = DateUtil.formatDateTime(date3);

        try {
            client1 = new MqttClient("tcp://localhost:1883",System.currentTimeMillis()+"c-002", new MemoryPersistence());
            MqttConnectOptions options = new MqttConnectOptions();
            options.setUserName(mqttProperties1.getUsername());
            //options.setPassword(mqttProperties1.getPassword().toCharArray());
            options.setConnectionTimeout(mqttProperties1.getTimeout());
            options.setKeepAliveInterval(mqttProperties1.getKeepAlive());
            options.setAutomaticReconnect(mqttProperties1.getReconnect());
            options.setCleanSession(mqttProperties1.getCleanSession());
            MqttAcceptClient2.setClient(client1);
            try {
                // 设置回调
                client1.setCallback(mqttAcceptCallback2);
                client1.connect(options);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 重新连接
     */
    public void reconnection() {
        try {
            client1.connect();
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    /**
     * 订阅某个主题
     *
     * @param topic 主题
     * @param qos   连接方式
     */
    public void subscribe(String topic, int qos) {
        logger.info("==============开始订阅主题==============" + topic);
        try {
            client1.subscribe(topic, qos);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    /**
     * 取消订阅某个主题
     *
     * @param topic
     */
    public void unsubscribe(String topic) {
        logger.info("==============开始取消订阅主题==============" + topic);
        try {
            client1.unsubscribe(topic);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}

