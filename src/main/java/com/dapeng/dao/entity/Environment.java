package com.dapeng.dao.entity;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("environment")
public class Environment {

    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField(value = "temperature")
    private  Float temperature;
    @TableField(value = "humidity")
    private Float humidity;

    @TableField(value = "SoilHumi")
    private Float SoilHumi;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime time;

    @TableField(value = "Pump_Status")
    private Integer PumpStatus;


    @TableField(value = "Pump_Permission")
    private Integer PumpPermission;

    @TableField(value = "Fan_Status")
    private Integer FanStatus;
    @TableField(value = "Fan_Permission")
    private Integer FanPermission;
}
