package com.cjh.mqtt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cjh.mqtt.BO.get.SoilGetDO;
import com.cjh.mqtt.BO.get.TempGetDO;
import com.cjh.mqtt.api.toqian.FanDTO;
import com.cjh.mqtt.mapper.TempGetDOMapper;
import com.cjh.mqtt.service.TempGetDOService;
import com.dapeng.dao.entity.Environment;
import com.dapeng.dto.resp.ShujuDTO;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

@Service
public class TempGetDOServiceImpl extends ServiceImpl<TempGetDOMapper, TempGetDO> implements TempGetDOService {

    @Resource
    private TempGetDOMapper tempGetDOMapper;
    @Override
    public List<TempGetDO> gets() {
        LambdaQueryWrapper<TempGetDO> queryWrapper = Wrappers.lambdaQuery(TempGetDO.class)
                .orderByDesc(TempGetDO::getTime)
                .last("limit 6");
        return baseMapper.selectList(queryWrapper);
    }


    @Override
    public ShujuDTO getJinQiTem() {
        List<TempGetDO> environments = gets();
        double[] shuju=new double[6];
        String[] time=new String[6];
        int index=5;
        for(TempGetDO e:environments){
            shuju[index]=e.getTemperature();
            time[index]=e.getTime().toString();
            index--;
        }
        ShujuDTO shujuDTO = new ShujuDTO(shuju, time);
        return shujuDTO;
    }

    @Override
    public ShujuDTO getJinQiHum() {
        List<TempGetDO> environments = gets();
        double[] shuju=new double[6];
        String[] time=new String[6];
        int index=5;
        for(TempGetDO e:environments){
            shuju[index]=e.getHumidity();
            time[index]=e.getTime().toString();
            index--;
        }
        ShujuDTO shujuDTO = new ShujuDTO(shuju, time);
        return shujuDTO;
    }

    @Override
    public ShujuDTO getLiShiTem() {
        List<TempGetDO> li = tempGetDOMapper.getLi();
        double[] shuju=new double[6];
        String[] time=new String[6];
        int index=0;
        for(TempGetDO e:li){
            shuju[index]=e.getTemperature();
            time[index]=e.getTime().toString();
            index++;
        }
        ShujuDTO shujuDTO = new ShujuDTO(shuju, time);
        return shujuDTO;
    }


    @Override
    public ShujuDTO getLiShiHum() {
        List<TempGetDO> li = tempGetDOMapper.getLi();

        double[] shuju=new double[6];
        String[] time=new String[6];
        int index=0;
        for(TempGetDO e:li){
            shuju[index]=e.getHumidity();
            time[index]=e.getTime().toString();
            index++;
        }
        ShujuDTO shujuDTO = new ShujuDTO(shuju, time);
        return shujuDTO;
    }

    @Override
    public FanDTO getFanStatus() {
        LambdaQueryWrapper<TempGetDO> one = Wrappers.lambdaQuery(TempGetDO.class)
                .orderByDesc(TempGetDO::getTime)
                .last("limit 1");

        List<TempGetDO> tempGetDOS = baseMapper.selectList(one);
        FanDTO fanDTO = new FanDTO(tempGetDOS.get(0).getFanStatus());
        return fanDTO;
    }
}
