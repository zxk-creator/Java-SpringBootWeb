package com.kunkun.springwebone.controller;

import com.kunkun.springwebone.dto.LoginDTO;
import com.kunkun.springwebone.entity.Result;
import com.kunkun.springwebone.entity.User;
import com.kunkun.springwebone.enumeration.StatusCode;
import com.kunkun.springwebone.service.UserService;
import com.kunkun.springwebone.service.impl.UserServiceImpl;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
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
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserService userService;
    // 当浏览器输入../list的时候，请执行这个方法
    @RequestMapping("/list")
    // 允许跨接口访问
    public Result<List<User>> list()
    {
        return Result.success(userService.findAll());
    }

    @RequestMapping("/api/login")
    public Result<User> findUserByUsername(@RequestBody LoginDTO loginDTO){
        if (loginDTO.getUserName() == null || loginDTO.getPassword() == null) return Result.error(StatusCode.EMPTY_USERNAME_OR_PASSWORD);
        User user = userService.findByName(loginDTO.getUserName(),loginDTO.getPassword());
        if (user == null) return Result.error(StatusCode.INVALID_USERNAME_OR_PASSWORD);

        return Result.success(user);
    }

    // 返回boolean代表注册是否成功
    @RequestMapping("/api/register")
    public Result<Void> registerUser(@RequestBody LoginDTO loginDTO){
        if (loginDTO.getUserName() == null || loginDTO.getPassword() == null) return Result.error(StatusCode.EMPTY_USERNAME_OR_PASSWORD);

        if (!userService.registerUser(loginDTO.getUserName(),loginDTO.getPassword())){
            return Result.error(StatusCode.OPERATION_FAILED);
        }

        return Result.success(null);
    }
}
