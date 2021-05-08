package com.hxscpro.service;

import com.hxscpro.bean.User;

import java.util.List;

public interface UserService {

    public User queryById(Integer id);

    public void deleteById(Integer id);

    public List<User> queryUsers();
}
