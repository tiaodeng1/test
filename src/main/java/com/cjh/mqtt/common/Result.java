package com.cjh.mqtt.common;

public class Result<T> {
    private int code;
    private String msg;
    private T data;
    private String Status;
    private static final int RESULT_CODE_SUCCESS = 200;
    private static final int RESULT_CODE_SERVER_ERROR = 500;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public Result() {
    }

    public Result(T data) {
        this.data = data;
    }

    public static Result success() {
        Result result = new Result<>();
        result.setCode(RESULT_CODE_SUCCESS);
        result.setMsg("成功");
        result.setStatus("OK");
        return result;
    }

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>(data);
        result.setCode(RESULT_CODE_SUCCESS);
        result.setMsg("成功");
        result.setStatus("OK");
        return result;
    }
    public static <T> Result<T> success(T data,String msg) {
        Result<T> result = new Result<>(data);
        result.setCode(RESULT_CODE_SUCCESS);
        result.setMsg(msg);
        result.setStatus("OK");
        return result;
    }

    public static Result error(String msg) {
        Result result = new Result();
        result.setCode(RESULT_CODE_SERVER_ERROR);
        result.setMsg(msg);
        return result;
    }

}
