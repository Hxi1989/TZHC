package com.hxscpro.mapper;

import com.hxscpro.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    public User queryById(Integer id);

    public void deleteById(Integer id);

    public List<User> queryUsers();
}
