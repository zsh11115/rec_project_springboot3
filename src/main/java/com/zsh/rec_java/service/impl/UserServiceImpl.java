package com.zsh.rec_java.service.impl;

import com.zsh.rec_java.mapper.UserMapper;
import com.zsh.rec_java.pojo.dto.UserLoginDTO;
import com.zsh.rec_java.pojo.entity.User;
import com.zsh.rec_java.service.UserService;
import com.zsh.rec_java.utils.enumData.ResultEnum;
import com.zsh.rec_java.utils.exception.AccountNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(UserLoginDTO userLoginDTO) {

        String username=userLoginDTO.getUsername();
        String password=userLoginDTO.getPassword();

        User user=userMapper.getByUsername(username);

        //账户不存在
        if(user==null){
            throw new AccountNotFoundException(ResultEnum.USER_LOGIN_ERROR);
        }


        return null;
    }
}
