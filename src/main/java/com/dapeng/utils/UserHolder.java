package com.dapeng.utils;

import com.dapeng.dto.UserDTO;

public class UserHolder {

    private static ThreadLocal<UserDTO> threadLocal;

    public static void set(UserDTO userDTO){
        threadLocal.set(userDTO);
    }


    public static UserDTO get(){
        return threadLocal.get();
    }

    public static void remove(){
        threadLocal.remove();
    }
}
