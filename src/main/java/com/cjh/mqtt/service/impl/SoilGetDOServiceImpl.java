package com.cjh.mqtt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cjh.mqtt.BO.get.SoilGetDO;
import com.cjh.mqtt.BO.get.TempGetDO;
import com.cjh.mqtt.api.toqian.PumpDTO;
import com.cjh.mqtt.mapper.SoilGetDOMapper;
import com.cjh.mqtt.service.SoilGetDOService;
import com.dapeng.dao.entity.Environment;
import com.dapeng.dto.resp.ShujuDTO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class SoilGetDOServiceImpl extends ServiceImpl<SoilGetDOMapper, SoilGetDO> implements SoilGetDOService {

    @Resource
    private SoilGetDOMapper soilGetDOMapper;

    @Override
    public List<SoilGetDO> gets() {
        LambdaQueryWrapper<SoilGetDO> queryWrapper = Wrappers.lambdaQuery(SoilGetDO.class)
                .orderByDesc(SoilGetDO::getTime)
                .last("limit 6");
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public ShujuDTO getJinQiSoil(){
        List<SoilGetDO> environments = gets();
        double[] shuju=new double[6];
        String[] time=new String[6];
        int index=5;
        for(SoilGetDO e:environments){
            shuju[index]=e.getSoilHumi();
            time[index]=e.getTime().toString();
            index--;
        }
        ShujuDTO shujuDTO = new ShujuDTO(shuju, time);
        return shujuDTO;
    }

    @Override
    public PumpDTO getPumpStatus() {
            LambdaQueryWrapper<SoilGetDO> one = Wrappers.lambdaQuery(SoilGetDO.class)
                    .orderByDesc(SoilGetDO::getTime)
                    .last("limit 1");

        List<SoilGetDO> soilGetDOS1 = soilGetDOMapper.selectList(one);

        PumpDTO pumpDTO = new PumpDTO(soilGetDOS1.get(0).getPumpStatus());
        return pumpDTO;
    }

    @Override
    public ShujuDTO getLiShiSoil() {
        List<SoilGetDO> li = soilGetDOMapper.getLi();
        double[] shuju=new double[6];
        String[] time=new String[6];
        int index=0;
        for(SoilGetDO e:li){
            shuju[index]=e.getSoilHumi();
            time[index]=e.getTime().toString();
            index++;
        }
        ShujuDTO shujuDTO = new ShujuDTO(shuju, time);
        return shujuDTO;
    }
}
