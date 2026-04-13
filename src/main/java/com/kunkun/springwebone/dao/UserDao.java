package com.kunkun.springwebone.dao;

import com.kunkun.springwebone.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

public interface UserDao {
    /*
     *  加载用户数据
     */
    public List<User> findAll();
    /**
     * 登录
     */
    public User findByUsername(String userName);

    public Boolean registerUser(String userName,String password);
}
