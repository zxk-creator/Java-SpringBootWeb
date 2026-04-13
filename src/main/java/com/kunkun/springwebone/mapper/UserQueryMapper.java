package com.kunkun.springwebone.mapper;

import com.kunkun.springwebone.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserQueryMapper {
    // 直接获取所有人的类型
    public List<User> findAll();
    // 查人和密码是否正确
    public User findByUsername(String userName);

    /**
     * 注册账号，默认身份都是访客，除非后台手动设置
     * @param userName 用户名
     * @param password 密码
     * @return 是否成功，为1就成功了
     */
    public int registerUser(String userName,String password);
}
