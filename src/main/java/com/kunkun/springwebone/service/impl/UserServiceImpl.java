package com.kunkun.springwebone.service.impl;

import com.kunkun.springwebone.dao.UserDao;
import com.kunkun.springwebone.entity.User;
import com.kunkun.springwebone.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserDao userDao;
    @Autowired
    private BCryptPasswordEncoder encoder;
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findByName(String userName, String passowrd) {
        System.out.println("开始查找用户，查询数据库");
        User foundedUser = userDao.findByUsername(userName);
        if (foundedUser == null) {
            log.warn("密码不正确。");
            return null;
        }

        if (!encoder.matches(passowrd,foundedUser.getPasswordHash())){
            log.warn("密码错误");
            return null;
        }

        System.out.println("执行完毕，返回");

        return foundedUser;
    }
    @Override
    public Boolean registerUser(String userName, String passowrd) {
        String encodedPassword = encoder.encode(passowrd);

        return userDao.registerUser(userName,encodedPassword);
    }
}
