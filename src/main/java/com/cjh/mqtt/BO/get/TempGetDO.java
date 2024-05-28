package com.cjh.mqtt.BO.get;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("temp")
public class TempGetDO {

    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField(value = "temperature")
    private Float temperature;
    @TableField(value = "humidity")
    private Float humidity;
    @TableField(value = "Fan_Status")
    private Integer FanStatus;
    @TableField(value = "Fan_Permission")
    private Integer FanPermission;
    @TableField(value = "Fan_Level")
    private Integer FanLevel;
    @TableField(value = "Temp_Threshold")
    private Float TempThreshold;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime time;


}
