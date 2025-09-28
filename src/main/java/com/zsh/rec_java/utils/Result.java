package com.zsh.rec_java.utils;

import com.zsh.rec_java.utils.enumData.ResultEnum;
import jdk.jfr.DataAmount;
import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {
    private Integer code;
    private String msg;
    private T data;


    //构造
    public Result(ResultEnum resultCode){
        this.code=resultCode.code();
        this.msg=resultCode.msg();
    }

    public Result(ResultEnum resultCode,T data){
        this.code=resultCode.code();
        this.msg=resultCode.msg();
        this.data=data;
    }

    public Result(String msg){
        this.msg=msg;
    }

    //成功
    public static Result<String> sucess() {
        return new Result<String>(ResultEnum.SUCCESS);
    }

    public static <T> Result<T> sucess(T data) {
        return new Result<T>(ResultEnum.SUCCESS,data);
    }

    //失败
    public static Result<String> error() {
        return new Result<String>(ResultEnum.FAIL);
    }

    public static Result<String> error(ResultEnum resultCode) {
        return new Result<String>(resultCode);
    }

    public static Result<String> error(String msg){
        return new Result<String>(msg);
    }
}
