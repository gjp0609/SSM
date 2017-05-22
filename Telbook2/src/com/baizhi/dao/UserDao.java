package com.baizhi.dao;

import com.baizhi.entity.User;

import java.util.List;

/**
 * Created by gjp06 on 17.5.21.
 */
public interface UserDao {
    public List<User> selectUser(User user);
}
