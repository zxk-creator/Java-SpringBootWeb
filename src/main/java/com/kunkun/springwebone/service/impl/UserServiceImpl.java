package com.kunkun.springwebone.service.impl;

import com.kunkun.springwebone.dao.UserDao;
import com.kunkun.springwebone.dao.impl.UserDaoImpl;
import com.kunkun.springwebone.entity.User;
import com.kunkun.springwebone.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();
    @Override
    public List<User> findAll() {
        // 调用Dao获取数据
        var Lines = userDao.findAll();

        // 代替了罗嗦的for循环转换成List类型
        List<User> userList = Lines.stream().map(Line -> {
            String[] parts = Line.split(",");
            Integer id = Integer.parseInt(parts[0]);
            String username = parts[1];
            String password = parts[2];
            String name = parts[3];
            Integer age = Integer.parseInt(parts[4]);
            LocalDateTime updateTime = LocalDateTime.parse(parts[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            return new User(id,username,password,name,age,updateTime);
        }).collect(Collectors.toList());
        // 或者toList();

        return userList;
    }
}
