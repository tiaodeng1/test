package com.cjh.mqtt.BO;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("threshold")
public class Threshold {
    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField(value = "Pump_Level")
    private Float PumpLevel;

    @TableField(value = "SoilHumi_Threshold")
    private Float SoilHumiThreshold;

    @TableField(value = "Fan_Level")
    private Float FanLevel;
    @TableField(value = "Temp_Threshold")
    private Float TempThreshold;

    @TableField
    private Date time;


}
