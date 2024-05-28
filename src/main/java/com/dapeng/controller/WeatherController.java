package com.dapeng.controller;

import com.dapeng.convention.result.Result;
import com.dapeng.convention.result.Results;
import com.dapeng.dto.WeatherDTO;
import com.dapeng.service.impl.WeatherServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
@RestController
@CrossOrigin
public class WeatherController {


    @Resource
    private WeatherServiceImpl weatherService;

    @GetMapping("/getWeather")
    public Result<WeatherDTO> get(){
        System.out.println(1);
        WeatherDTO beiJing = weatherService.getWeather("BeiJing");
        System.out.println(beiJing);
        return Results.success(beiJing);
    }




}
