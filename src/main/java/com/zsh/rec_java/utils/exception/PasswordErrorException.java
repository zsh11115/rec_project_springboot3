package com.zsh.rec_java.utils.exception;
import com.zsh.rec_java.utils.enumData.ResultEnum;
import lombok.Getter;

@Getter
public class PasswordErrorException extends RuntimeException {
    private final ResultEnum resultEnum;

    public PasswordErrorException(ResultEnum resultEnum) {
        this.resultEnum = resultEnum;
    }
}
