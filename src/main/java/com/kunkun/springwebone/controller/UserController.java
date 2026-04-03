package com.kunkun.springwebone.controller;

import com.kunkun.springwebone.entity.User;
import com.kunkun.springwebone.service.UserService;
import com.kunkun.springwebone.service.impl.UserServiceImpl;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    // 当浏览器输入../list的时候，请执行这个方法
    @RequestMapping("/list")
    // 允许跨接口访问
    @CrossOrigin(origins = "*")
    public List<User> list()
    {
        return userService.findAll();
    }
}
