package com.kunkun.springwebone.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import com.kunkun.springwebone.enumeration.Gender;

@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Employee {
    private Integer id;
    private String userName;
    private String name;
    private String phone;
    private Integer gender; // 1:男, 2:女, 其他:未知
    private String avatarUrl;
    // 比如“学工部”
    private String department;
    // 比如“班主任”
    private String jobTitle;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate entryDate;
    private LocalDateTime lastUpdateTime;

    public String getGenderString()
    {
        return switch (gender) {
            case 1 -> "男";
            case 2 -> "女";
            default -> "未知";
        };
    }

    @Override
    public String toString()
    {
        return "id: " + id + "，用户名: " + userName + "，姓名: " + name + "，性别：" + getGenderString() + "，手机号: " + phone + "，职位类型：" + department + "，入职时间：" + entryDate + "，最后操作时间：" + lastUpdateTime;
    }
}