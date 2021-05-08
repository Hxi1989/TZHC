package com.hxscpro.service.impl;

import com.hxscpro.bean.User;
import com.hxscpro.mapper.UserMapper;
import com.hxscpro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hx
 * @create 2021-01-04
 * @description
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public User queryById(Integer id) {
        return userMapper.queryById(id);
    }

    @Override
    public void deleteById(Integer id) {
        userMapper.deleteById(id);
    }

    @Override
    public List<User> queryUsers() {
        return userMapper.queryUsers();
    }
}
