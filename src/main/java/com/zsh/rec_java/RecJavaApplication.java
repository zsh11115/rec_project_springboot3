package com.zsh.rec_java;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@Slf4j
@EnableCaching //开启缓存注解
public class RecJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecJavaApplication.class, args);
    }

}
