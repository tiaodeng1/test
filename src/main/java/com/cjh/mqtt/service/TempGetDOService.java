package com.cjh.mqtt.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cjh.mqtt.BO.get.TempGetDO;
import com.cjh.mqtt.api.toqian.FanDTO;
import com.dapeng.dto.resp.ShujuDTO;

import java.util.List;

public interface TempGetDOService extends IService<TempGetDO> {

    List<TempGetDO> gets();

    ShujuDTO getJinQiTem();

    ShujuDTO getJinQiHum();

    ShujuDTO getLiShiTem();

    ShujuDTO getLiShiHum();

    FanDTO getFanStatus();
}
