package com.zsh.rec_java.utils.exception;

import com.zsh.rec_java.utils.enumData.ResultEnum;

public class TokenInvalidException extends RuntimeException {
    private final ResultEnum resultEnum;

    public TokenInvalidException(ResultEnum resultEnum) {
        this.resultEnum = resultEnum;
    }
}
