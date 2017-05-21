package com.baizhi.service.impl;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by gjp06 on 17.5.21.
 */
@Service("userService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl implements UserService {
    @Resource(name = "userDao")
    private UserDao dao;

    @Override
    public User login(User user) {
        if (user == null) throw new RuntimeException("234");
        List<User> users = dao.selectUser(user);
        if (users == null || users.size() != 1) throw new RuntimeException("没有这个用户");
        if (users.get(0).getPassword().equals(user.getPassword())) return users.get(0);
        else throw new RuntimeException("密码错误");
    }
}
