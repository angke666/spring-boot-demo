package com.xkcoding.spring.security.mapper;

import com.xkcoding.spring.security.componet.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMappre {

    @Select("select * from users where username = #{username}")
    User findByUserName(@Param("username") String username);

}
