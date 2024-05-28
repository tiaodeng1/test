package com.dapeng.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dapeng.dto.WeatherDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WeatherDTOMapper extends BaseMapper<WeatherDTO> {
}
