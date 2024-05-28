package com.dapeng.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dapeng.dao.entity.Environment;
import com.dapeng.dao.mapper.EnvironmentMapper;
import com.dapeng.dto.resp.ShujuDTO;
import com.dapeng.service.EnvironmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EnvironmenrServiceImpl extends ServiceImpl<EnvironmentMapper, Environment> implements EnvironmentService {

    @Resource
    private EnvironmentMapper environmenrMapper;



    @Override
    public ShujuDTO getJinQiTem() {
        List<Environment> environments = gets();
        double[] shuju=new double[6];
        String[] time=new String[6];
        int index=5;
        for(Environment e:environments){
            shuju[index]=e.getTemperature();
            time[index]=e.getTime().toString();
            index--;
        }
        ShujuDTO shujuDTO = new ShujuDTO(shuju, time);
        return shujuDTO;
    }

    @Override
    public ShujuDTO getJinQiHum() {
        List<Environment> environments = gets();
        double[] shuju=new double[6];
        String[] time=new String[6];
        int index=5;
        for(Environment e:environments){
            shuju[index]=e.getHumidity();
            time[index]=e.getTime().toString();
            index--;
        }
        ShujuDTO shujuDTO = new ShujuDTO(shuju, time);
        return shujuDTO;
    }

    @Override
    public ShujuDTO getJinQiSoil(){
        List<Environment> environments = gets();
        double[] shuju=new double[6];
        String[] time=new String[6];
        int index=5;
        for(Environment e:environments){
            shuju[index]=e.getSoilHumi();
            time[index]=e.getTime().toString();
            index--;
        }
        ShujuDTO shujuDTO = new ShujuDTO(shuju, time);
        return shujuDTO;
    }

    public List<Environment> gets(){
        LambdaQueryWrapper<Environment> queryWrapper = Wrappers.lambdaQuery(Environment.class)
                .orderByDesc(Environment::getTime)
                .last("limit 6");
        return baseMapper.selectList(queryWrapper);
    }

}
