package com.cjh.mqtt.api.toqian;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.cjh.mqtt.BO.get.SoilGetDO;
import com.cjh.mqtt.BO.get.TempGetDO;
import com.cjh.mqtt.service.SoilGetDOService;
import com.cjh.mqtt.service.TempGetDOService;
import com.dapeng.dto.EnvironmentDTO;
import com.dapeng.dto.resp.ShujuDTO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
public class environmentApi {
    @Resource
    private SoilGetDOService soilGetDOService;

    @Resource
    private TempGetDOService tempGetDOService;

    @GetMapping("/jinqiTem")
    public ShujuDTO getJinQiTem(){
        System.out.println(1);
        return tempGetDOService.getJinQiTem();
    }

    @GetMapping("/jinqiHum")
    public ShujuDTO getJinQiHum(){
        return tempGetDOService.getJinQiHum();
    }

    @GetMapping("/jinqiSoil")
    public ShujuDTO getJinQiSoil(){
        return soilGetDOService.getJinQiSoil();
    }

    @GetMapping("/fanStatus")
    public FanDTO fan(){
        return tempGetDOService.getFanStatus();
    }

    @GetMapping("/pumpStatus")
    public PumpDTO pump(){
        return soilGetDOService.getPumpStatus();
    }

    @GetMapping("/environment/get")
    public EnvironmentDTO get(){


        LambdaQueryWrapper<TempGetDO> last = Wrappers.lambdaQuery(TempGetDO.class)
                .orderByDesc(TempGetDO::getTime)
                .last("limit 1");

        LambdaQueryWrapper<SoilGetDO> last1 = Wrappers.lambdaQuery(SoilGetDO.class)
                .orderByDesc(SoilGetDO::getTime)
                .last("limit 1");

        List<TempGetDO> tempGetDOS = tempGetDOService.getBaseMapper().selectList(last);

        List<SoilGetDO> soilGetDOS = soilGetDOService.getBaseMapper().selectList((last1));

        EnvironmentDTO build = EnvironmentDTO.builder()
                .temperature(tempGetDOS.get(0).getTemperature())
                .humidity(tempGetDOS.get(0).getHumidity())
                .SoilHumi(soilGetDOS.get(0).getSoilHumi())
                .time(tempGetDOS.get(0).getTime())
                .build();
        return build;
    }

    @GetMapping("/LiShiTem")
    public ShujuDTO LiShiTem(){
        return tempGetDOService.getLiShiTem();
    }

    @GetMapping("/LiShiHum")
    public ShujuDTO LiShiHum(){
        return tempGetDOService.getLiShiHum();
    }

    @GetMapping("/LiShiSoil")
    public ShujuDTO LiShiSoil(){
        return soilGetDOService.getLiShiSoil();
    }



}
