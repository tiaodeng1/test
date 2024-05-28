package com.dapeng.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.dapeng.convention.result.Result;
import com.dapeng.convention.result.Results;
import com.dapeng.dao.entity.User;
import com.dapeng.dto.UserDTO;
import com.dapeng.dto.req.HuiyuanDTO;
import com.dapeng.dto.req.LoginDTOReqDTO;
import com.dapeng.dto.req.RegisterReqDTO;
import com.dapeng.dto.req.UpdateReqDTO;
import com.dapeng.dto.resp.LoginDTORespDTO;
import com.dapeng.service.UserService;
import com.dapeng.utils.UserHolder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@CrossOrigin
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/register")
    public Result<Void> register(@RequestBody RegisterReqDTO requestParam){
        System.out.println(1);
        userService.register(requestParam);
        return Results.success();
    }

    @PostMapping("/huiyuan")
    public Result<Void> huiyuan(@RequestBody HuiyuanDTO huiyuanDTO){
        return userService.huiyuan(huiyuanDTO);
    }


    @PostMapping("/update")
    public Result<Void> update(@RequestBody UpdateReqDTO updateReqDTO){
        return userService.update(updateReqDTO);
    }



    @PostMapping("/login")
    public Result<UserDTO> login(@RequestBody LoginDTOReqDTO requestParam){
        System.out.println(1);
        UserDTO user = userService.login(requestParam);
        return Results.success(user);
    }

    @GetMapping("/me")
    public Result<User> get(Integer id){
        User user1 = userService.getById(id);
        return Results.success(user1);
    }

}
