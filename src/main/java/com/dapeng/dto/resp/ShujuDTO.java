package com.dapeng.dto.resp;

import lombok.Data;

@Data
public class ShujuDTO {
    private double[] shuju;

    private String[] time;

    public ShujuDTO(double[] shuju,String[] time){
        this.shuju=shuju;
        this.time=time;
    }
}
