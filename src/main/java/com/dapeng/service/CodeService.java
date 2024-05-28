package com.dapeng.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dapeng.dao.entity.Code;

public interface CodeService extends IService<Code> {

    boolean has(String code);
}
