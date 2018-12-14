package com.fugf.core.service.impl;

import com.fugf.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private JedisConnectionFactory jedisConnectionFactory;
    @Override
    public List<String> listUserName() {
        return Arrays.asList("123","456","789");
    }
}
