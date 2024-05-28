package com.cjh.mqtt.api;


import cn.hutool.db.Db;
import cn.hutool.db.ds.simple.SimpleDataSource;
import com.cjh.mqtt.BO.TempSendDO;
import com.cjh.mqtt.common.Result;
import com.cjh.mqtt.sendclient.Send_Client1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Map;


@RestController
@CrossOrigin
@RequestMapping("/mqtt")
public class MqttApi {

	/**
	 *  http:/host:9096/mqtt/sendmsg
	 */
    @Autowired
    private Send_Client1  client1;
    Result result;


    @GetMapping(value = "/sendmsg")
    public Object publishTopic(@RequestBody Map envirIfo) throws JSONException, SQLException {
        int fanPermission= (int) envirIfo.get("Fan_Permission");
        int pumpPermission= (int) envirIfo.get("Pump_Permission");
        JSONObject result = new JSONObject();
        result.put("fanPermission", fanPermission);
        result.put("pumpPermission", pumpPermission);
        client1.publish(false ,"TopicA", result.toString());
        return null;
    }
    @GetMapping(value = "/sendmsg2")
    public Object publishTopic2(@RequestBody Map dateIfo) {
        client1.publish(false ,"TopicB",dateIfo.toString());
        return null;
    }

    @GetMapping(value = "/sendmsg3")
    public Object publishTopic3(@RequestBody TempSendDO en) {
        System.out.println(1);
        client1.publish2(false ,"TopicA",en);
        return null;
    }
    @GetMapping(value = "/sendmsgToC")
    public Result publishTopicToC() {
        String sendMessage= "ON";
        client1.publish(false ,"TopicA",sendMessage);
        return result.success();
    }
    @GetMapping(value = "/sendmsgToD")
    public Result publishTopicToD() {
        String sendMessage= "OFF";
        client1.publish(false ,"TopicB",sendMessage);
        return result.success();
    }


}

