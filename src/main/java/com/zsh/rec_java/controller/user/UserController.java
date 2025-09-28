package com.zsh.rec_java.controller.user;

import com.zsh.rec_java.constant.JwtClaimsConstant;
import com.zsh.rec_java.pojo.dto.UserLoginDTO;
import com.zsh.rec_java.pojo.entity.User;
import com.zsh.rec_java.pojo.vol.EmployeeLoginVO;
import com.zsh.rec_java.service.UserService;
import com.zsh.rec_java.utils.JWTUtils;
import com.zsh.rec_java.utils.Result;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user/user")
@Slf4j
public class UserController {
    @Autowired
    UserService userService;

    @Resource
    JWTUtils jwtUtils=new JWTUtils();

    @PostMapping("/login")
    public Result<User> login(@RequestBody UserLoginDTO userLoginDTO){
        log.info("用户登录:{}",userLoginDTO);
        User user=userService.login(userLoginDTO);

        //登录成功 token验证
        Map<String,String> claims=new HashMap<>();
        claims.put(JwtClaimsConstant.EMP_ID, String.valueOf(user.getId()));
        String token= jwtUtils.generateToken(claims);

        EmployeeLoginVO employeeLoginVO=EmployeeLoginVO.builder()
                .id(user.getId())
                .token(token)
                .build();

        return Result.sucess(user);
    }
}
