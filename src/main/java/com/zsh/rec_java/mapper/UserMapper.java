package com.zsh.rec_java.mapper;

import com.zsh.rec_java.pojo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from user where username=#{username}")
    User getByUsername(String username);

}
