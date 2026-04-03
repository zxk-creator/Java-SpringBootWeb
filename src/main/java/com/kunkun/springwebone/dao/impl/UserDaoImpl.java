package com.kunkun.springwebone.dao.impl;

import com.kunkun.springwebone.dao.UserDao;
import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

// 数据访问类，返回获取到的数据
public class UserDaoImpl implements UserDao {
    @Override
    public List<String> findAll() {
        InputStream in = getClass().getClassLoader().getResourceAsStream("users.txt");
        return IOUtils.readLines(in, StandardCharsets.UTF_8);
    }
}
