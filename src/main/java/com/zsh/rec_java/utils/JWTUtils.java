package com.zsh.rec_java.utils;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.zsh.rec_java.utils.enumData.ResultEnum;
import com.zsh.rec_java.utils.exception.TokenInvalidException;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Map;


@Component
public class JWTUtils {


    private static final String SECRET = "qingcheng";


    @Resource
    private RedisTemplate<String, String> redisTemplate;


    /**
     * 生成JWT token
     */
    public String generateToken(Map<String, String> map) {

        Calendar instance = Calendar.getInstance();
        // 默认7天过期
        instance.add(Calendar.DATE, 7);

        //创建jwt builder
        JWTCreator.Builder builder = JWT.create();

        // payload
        map.forEach(builder::withClaim);

        return builder.withExpiresAt(instance.getTime())  //指定令牌过期时间
                .sign(Algorithm.HMAC256(SECRET));
    }


    /**
     * 解析JWT token
     */
    public DecodedJWT verify(String token) {
        // 检查 token 是否在黑名单中
        String tokenFromBlacklist = redisTemplate.opsForValue().get(token);
        if(tokenFromBlacklist == null) {
            throw new TokenInvalidException(ResultEnum.PERMISSION_TOKEN_INVALID);
        }
        return JWT.require(Algorithm.HMAC256(SECRET)).build().verify(token);
    }
}