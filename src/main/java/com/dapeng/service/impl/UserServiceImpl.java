package com.dapeng.service.impl;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dapeng.convention.exception.ClientException;
import com.dapeng.convention.result.Result;
import com.dapeng.convention.result.Results;
import com.dapeng.dao.entity.User;
import com.dapeng.dao.mapper.UserMapper;
import com.dapeng.dto.UserDTO;
import com.dapeng.dto.req.HuiyuanDTO;
import com.dapeng.dto.req.LoginDTOReqDTO;
import com.dapeng.dto.req.RegisterReqDTO;
import com.dapeng.dto.req.UpdateReqDTO;
import com.dapeng.service.CodeService;
import com.dapeng.service.UserService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private CodeService codeService;
    @Override
    public UserDTO login(LoginDTOReqDTO requestParam) {
        LambdaQueryWrapper<User> wrapper = Wrappers.lambdaQuery(User.class)
                .eq(User::getUsername, requestParam.getUsername())
                .eq(User::getPassword,requestParam.getPassword());

        User user = baseMapper.selectOne(wrapper);
        if(user==null){
            throw new ClientException("用户名或密码输入错误");
        }

        UserDTO userDTO = BeanUtil.copyProperties(user, UserDTO.class);

        return userDTO;
    }

    @Override
    public void register(RegisterReqDTO requestParam) {
        if(!canRegister(requestParam)){
            throw new ClientException("该邮箱或电话已绑定");
        }

        User user = User.builder()
                .phone(requestParam.getPhone())
                .username(requestParam.getUsername())
                .email(requestParam.getEmail())
                .password(requestParam.getPassword())
                .build();

        int insert = baseMapper.insert(user);
        if(insert>1){
            throw new ClientException("注册失败");
        }
    }

    @Override
    public Result<Void> huiyuan( HuiyuanDTO huiyuanDTO) {
        Integer id=huiyuanDTO.getId();
        User user = baseMapper.selectById(id);
        String code=huiyuanDTO.getCode();
        if(user==null){
            throw new ClientException("该用户不可用");
        }
        boolean has = codeService.has(code);
        if(has){
            LambdaUpdateWrapper<User> updateWrapper = Wrappers.lambdaUpdate(User.class)
                    .eq(User::getId, id);
            User build = User.builder()
                    .status(1)
                    .build();

            int update = baseMapper.update(build, updateWrapper);
            if(update>0){
                return Results.success();
            }
        }
        return Results.failure();
    }

    @Override
    public Result<Void> update(UpdateReqDTO updateReqDTO) {
        LambdaUpdateWrapper<User> updateWrapper = Wrappers.lambdaUpdate(User.class)
                .eq(User::getId, updateReqDTO.getId());

        User build = User.builder()
                .phone(updateReqDTO.getPhone())
                .email(updateReqDTO.getEmail())
                .username(updateReqDTO.getUsername())
                .password(updateReqDTO.getPassword())
                .build();
        baseMapper.update(build, updateWrapper);
        return Results.success();
    }

    public boolean canRegister(RegisterReqDTO requestParam){
        List<User> phone = query()
                .eq("phone", requestParam.getPhone()).list();

        List<User> email = query()
                .eq("email", requestParam.getEmail()).list();
        if(phone.size()!=0 || email.size()!=0){
            return false;
        }
        return true;
    }
}
