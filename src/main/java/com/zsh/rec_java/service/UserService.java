package com.zsh.rec_java.service;

import com.zsh.rec_java.pojo.dto.UserLoginDTO;
import com.zsh.rec_java.pojo.entity.User;

public interface UserService {
    public User login(UserLoginDTO userLoginDTO);
}
