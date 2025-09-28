package com.zsh.rec_java.utils;


import com.zsh.rec_java.utils.enumData.ResultEnum;
import com.zsh.rec_java.utils.exception.AccountNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    // 账号不存在异常
    @ExceptionHandler(AccountNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result<String> handleAccountNotFoundException(AccountNotFoundException ex) {
        return Result.error(ex.getResultEnum());
    }

    /**
     *
     * 通用异常处理
     */
    @ExceptionHandler(Exception.class)
    public Result<String> exceptionHandler(Exception ex) {
        log.error(ex.getMessage());
        return Result.error(ResultEnum.FAIL);
    }

}
