package com.xkcoding.spring.security.componet;

import com.xkcoding.spring.security.mapper.UserMappre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserDetailServiceImpl
 * @Description TODO
 * @Author 钱进
 * @Date 2020/6/19 11:10
 * @Version 1.0
 **/
@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserMappre userMappre;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 从数据库获取该用户信息
        User user = userMappre.findByUserName(username);
        // 用户不存在，抛出异常
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        // 设置权限，把数据库的权限解析为UserDetails的权限集 commaSeparatedStringToAuthorityList()格式必须是逗号分开的权限，或者自己实现转换
        user.setAuthorities(AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRoles()));

        return user;
    }
}
