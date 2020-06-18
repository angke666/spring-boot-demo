package com.xkcoding.spring.security.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName Users
 * @Description TODO
 * @Author 钱进
 * @Date 2020/6/18 18:18
 * @Version 1.0
 **/
@Data
@TableName("users")
public class Users implements Serializable {
    private static final long serialVersionUID = 7528654106392978089L;

    @TableId(type = IdType.AUTO)
    private Long id;
    private String username;
    private String password;
    private String roles;
    private Boolean disabled;

}
