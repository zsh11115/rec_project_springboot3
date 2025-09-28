package com.zsh.rec_java.utils.exception;

public class exception extends RuntimeException{

    private int errorCode;
    private String errorMsg;

    public exception(int errorCode,String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}

