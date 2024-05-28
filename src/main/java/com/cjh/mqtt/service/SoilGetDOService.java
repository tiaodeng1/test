package com.cjh.mqtt.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cjh.mqtt.BO.get.SoilGetDO;
import com.cjh.mqtt.api.toqian.PumpDTO;
import com.dapeng.dto.resp.ShujuDTO;

import java.util.List;

public interface SoilGetDOService extends IService<SoilGetDO> {

    List<SoilGetDO> gets();

    ShujuDTO getJinQiSoil();

    ShujuDTO getLiShiSoil();


    PumpDTO getPumpStatus();
}
