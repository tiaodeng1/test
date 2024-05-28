package com.cjh.mqtt.BO.get;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.sf.jsqlparser.statement.insert.Insert;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("soil")
public class SoilGetDO {

    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField(value = "SoilHumi")
    private  Float SoilHumi;

    @TableField(value = "Pump_Status")
    private Integer PumpStatus;
    @TableField(value = "Pump_Permission")
    private Integer PumpPermission;
    @TableField(value = "Pump_Level")
    private Integer PumpLevel;
    @TableField(value = "SoilHumi_Threshold")
    private Float SoilHumiThreshold;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime time;

}
