package com.dapeng.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dapeng.dao.entity.Code;
import com.dapeng.dao.mapper.CodeMapper;
import com.dapeng.service.CodeService;
import org.springframework.stereotype.Service;

@Service
public class CodeServiceImpl extends ServiceImpl<CodeMapper, Code> implements CodeService {

    @Override
    public boolean has(String code) {
        LambdaQueryWrapper<Code> wrapper = Wrappers.lambdaQuery(Code.class)
                .eq(Code::getCode, code)
        .eq(Code::getStatus,0);
        Code one = baseMapper.selectOne(wrapper);
        return one!=null;
    }
}
