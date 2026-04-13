package com.kunkun.springwebone.dao.impl;

import com.kunkun.springwebone.dao.UserDao;
import com.kunkun.springwebone.entity.User;
import com.kunkun.springwebone.mapper.UserQueryMapper;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

// 数据访问类，返回获取到的数据
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    UserQueryMapper userQueryMapper;

    @Override
    public List<User> findAll() {
        return userQueryMapper.findAll();
    }

    @Override
    public User findByUsername(String userName) {
        return userQueryMapper.findByUsername(userName);
    }

    @Override
    public Boolean registerUser(String userName, String password) {
        return userQueryMapper.registerUser(userName, password) != 0;
    }
}
