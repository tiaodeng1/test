package com.dapeng.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dapeng.dto.WeatherDTO;

public interface WeatherService extends IService<WeatherDTO> {

    WeatherDTO getWeather(String cityStr);
}
