package com.cjh.mqtt.api;


import cn.hutool.json.JSONUtil;
import com.cjh.mqtt.BO.send.fan.FanLevelDTO;
import com.cjh.mqtt.BO.send.fan.FanPermissionDTO;
import com.cjh.mqtt.BO.send.fan.FanStatusDTO;
import com.cjh.mqtt.BO.send.fan.TempThresholdDTO;
import com.cjh.mqtt.BO.send.pump.PumpLevelDTO;
import com.cjh.mqtt.BO.send.pump.PumpPermissionDTO;
import com.cjh.mqtt.BO.send.pump.PumpStatus;
import com.cjh.mqtt.BO.send.pump.SoilHumiThresholdDTO;
import com.cjh.mqtt.sendclient.Send_Client1;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import java.util.Map;

import static java.lang.Thread.sleep;
@RestController
@CrossOrigin
public class SendApi {

    @Resource
    private Send_Client1 client1;



    @GetMapping(value = "/sendmsgFanLevelToA")
    public void publishTopic1(Integer i) throws JSONException, InterruptedException {
        FanLevelDTO fanLevelDTO = new FanLevelDTO(i);
        client1.publish3(false ,"TopicA",JSONUtil.toJsonStr(fanLevelDTO));
    }

    @GetMapping(value = "/sendmsgFanPermissionToA")
    public void publishTopic2( Integer i) throws InterruptedException, JSONException {
        FanPermissionDTO fanPermissionDTO = new FanPermissionDTO(i);
        client1.publish3(false ,"TopicA",JSONUtil.toJsonStr(fanPermissionDTO));
    }

    @GetMapping(value = "/sendmsgFanStatusToA")
    public void publishTopic5(Integer i) throws InterruptedException, JSONException {
        FanStatusDTO fanStatusDTO = new FanStatusDTO(i);
        client1.publish3(false ,"TopicA",JSONUtil.toJsonStr(fanStatusDTO));
    }

    @GetMapping(value = "/sendmsgTempThresholdToA")
    public void publishTopic6(Float i) throws InterruptedException, JSONException {
        TempThresholdDTO tempThresholdDTO = new TempThresholdDTO(i);
        client1.publish3(false ,"TopicA",JSONUtil.toJsonStr(tempThresholdDTO));
    }


    @GetMapping(value = "/sendmsgPumpLevelDTOToC")
    public void publishTopic7( Integer i) throws InterruptedException, JSONException {
        PumpLevelDTO pumpLevelDTO = new PumpLevelDTO(i);
        client1.publish3(false ,"TopicC",JSONUtil.toJsonStr(pumpLevelDTO));
    }

    @GetMapping(value = "/sendmsgPumpPermissionDTOToC")
    public void publishTopic8(Integer i) throws InterruptedException, JSONException {
            PumpPermissionDTO pumpPermissionDTO = new PumpPermissionDTO(i);
            client1.publish3(false ,"TopicC", JSONUtil.toJsonStr(pumpPermissionDTO));
    }

    @GetMapping(value = "/sendmsgPumpStatusToC")
    public void publishTopic9(Integer i) throws InterruptedException, JSONException {
        PumpStatus pumpStatus = new PumpStatus(i);
        client1.publish3(false ,"TopicC", JSONUtil.toJsonStr(pumpStatus));
    }

    @GetMapping(value = "/sendmsgSoilHumiThresholdDTOToC")
    public void publishTopic10( Float i) throws InterruptedException, JSONException {
        SoilHumiThresholdDTO soilHumiThresholdDTO = new SoilHumiThresholdDTO(i);
        client1.publish3(false ,"TopicC", JSONUtil.toJsonStr(soilHumiThresholdDTO));
    }
}
