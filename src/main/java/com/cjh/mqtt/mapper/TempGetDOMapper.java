package com.cjh.mqtt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cjh.mqtt.BO.get.TempGetDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TempGetDOMapper extends BaseMapper<TempGetDO> {
    List<TempGetDO> getLi();
}
