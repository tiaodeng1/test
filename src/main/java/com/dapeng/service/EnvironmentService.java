package com.dapeng.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dapeng.dao.entity.Environment;
import com.dapeng.dto.resp.ShujuDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EnvironmentService extends IService<Environment> {



    ShujuDTO getJinQiTem();

    ShujuDTO getJinQiHum();

    ShujuDTO getJinQiSoil();
}
