package com.zsh.rec_java.controller.user;

import com.zsh.rec_java.pojo.entity.User;
import com.zsh.rec_java.service.UserService;
import com.zsh.rec_java.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestBody()
    public Result<User> login(){

    }
}
