package com.cjh.mqtt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cjh.mqtt.BO.get.SoilGetDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SoilGetDOMapper extends BaseMapper<SoilGetDO> {

    List<SoilGetDO> getLi();
}
