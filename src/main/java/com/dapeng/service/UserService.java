package com.dapeng.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dapeng.convention.result.Result;
import com.dapeng.dao.entity.User;
import com.dapeng.dto.UserDTO;
import com.dapeng.dto.req.HuiyuanDTO;
import com.dapeng.dto.req.LoginDTOReqDTO;
import com.dapeng.dto.req.RegisterReqDTO;
import com.dapeng.dto.req.UpdateReqDTO;
import com.dapeng.dto.resp.LoginDTORespDTO;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserService extends IService<User> {

    UserDTO login(LoginDTOReqDTO requestParam);

    void register(RegisterReqDTO requestParam);

    Result<Void> update(UpdateReqDTO updateReqDTO);

    Result<Void> huiyuan(HuiyuanDTO huiyuanDTO);
}
