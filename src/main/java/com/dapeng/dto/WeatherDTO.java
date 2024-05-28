package com.dapeng.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("weather")
public class WeatherDTO {

    private String Weather;

    private Double Temperature;

    private Integer Humidity;
}
