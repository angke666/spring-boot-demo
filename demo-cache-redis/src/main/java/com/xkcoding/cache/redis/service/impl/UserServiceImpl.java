package com.xkcoding.cache.redis.service.impl;

import com.google.common.collect.Maps;
import com.xkcoding.cache.redis.entity.User;
import com.xkcoding.cache.redis.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * UserService
 * </p>
 *
 * 下面用到的三个标签就是为了缓存，在redistributionConfig中配置了使用redis作为缓存
 * 就是为了方便查询，如果添加或者修改的时候已经存了缓存了，那查询的时候就不会调用查询数据库的方法，而是直接从缓存中取值
 * redis的key值格式就是（例如#user.id=1） user::1
 * https://blog.csdn.net/dreamhai/article/details/80642010
 * @CachePut 用于添加/修改方法
 * @Cacheable 用于查询方法
 * @CacheEvict 用于删除方法
 *
 * @package: com.xkcoding.cache.redis.service.impl
 * @description: UserService
 * @author: yangkai.shen
 * @date: Created in 2018/11/15 16:45
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    /**
     * 模拟数据库
     */
    private static final Map<Long, User> DATABASES = Maps.newConcurrentMap();

    /**
     * 初始化数据
     */
    static {
        DATABASES.put(1L, new User(1L, "user1"));
        DATABASES.put(2L, new User(2L, "user2"));
        DATABASES.put(3L, new User(3L, "user3"));
    }

    /**
     * 保存或修改用户
     *
     * @param user 用户对象
     * @return 操作结果
     */
    @CachePut(value = "user", key = "#user.id")
    @Override
    public User saveOrUpdate(User user) {
        DATABASES.put(user.getId(), user);
        log.info("保存用户【user】= {}", user);
        return user;
    }

    /**
     * 获取用户
     *
     * @param id key值
     * @return 返回结果
     */
    @Cacheable(value = "user", key = "#id")
    @Override
    public User get(Long id) {
        // 我们假设从数据库读取
        log.info("查询用户【id】= {}", id);
        return DATABASES.get(id);
    }

    /**
     * 删除
     *
     * @param id key值
     */
    @CacheEvict(value = "user", key = "#id")
    @Override
    public void delete(Long id) {
        DATABASES.remove(id);
        log.info("删除用户【id】= {}", id);
    }
}
