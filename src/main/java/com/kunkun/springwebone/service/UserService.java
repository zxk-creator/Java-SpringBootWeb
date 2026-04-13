package com.kunkun.springwebone.service;

import com.kunkun.springwebone.entity.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();
    public User findByName(String userName,String passowrd);
    // 默认权限为访客
    public Boolean registerUser(String userName,String passowrd);
}
