package com.zsh.rec_java.service.impl;

import com.zsh.rec_java.mapper.UserMapper;
import com.zsh.rec_java.pojo.dto.UserLoginDTO;
import com.zsh.rec_java.pojo.entity.User;
import com.zsh.rec_java.service.UserService;
import com.zsh.rec_java.utils.enumData.ResultEnum;
import com.zsh.rec_java.utils.exception.AccountHasLockedException;
import com.zsh.rec_java.utils.exception.AccountNotFoundException;
import com.zsh.rec_java.utils.exception.PasswordErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;


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

        //加密验证
        String verifyPWD= DigestUtils.md5DigestAsHex(password.getBytes());
        if(!password.equals(verifyPWD)){
            throw new PasswordErrorException(ResultEnum.USER_LOGIN_ERROR);
        }

        //用户状态
        if(user.getStatus()==ResultEnum.USER_HAS_LOCKED.getCode()){
            throw new AccountHasLockedException(ResultEnum.USER_HAS_LOCKED);
        }

        return user;
    }
}
