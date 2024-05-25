package com.qiaojingjing.bookDemo.Result;

import lombok.Data;

//统一响应结果类
@Data
public class Result {
    private int code;
    private String message;
    private Object data;
    public static Result success(){
        Result result = new Result();
        result.code = 1;
        result.message = "OK";
        result.data = null;
        return result;
    }
    public static Result success(Object data){
        Result result = new Result();
        result.code = 1;
        result.message = "OK";
        result.data = data;
        return result;
    }
    public static Result error(String message){
        Result result = new Result();
        result.code = 1;
        result.message = message;
        result.data = null;
        return result;
    }

}
