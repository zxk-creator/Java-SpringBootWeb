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
    @Setter(AccessLevel.NONE)
    private Gender gender;
    private String avatarUrl;
    // 比如“学工部”
    private String department;
    // 比如“班主任”
    private String jobTitle;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate entryDate;
    private LocalDate endDate;
    private LocalDate lastUpdateDate;

    public void setGender(Integer gender)
    {
        if (gender == null)
        {
            this.gender = Gender.Unknown;
            return;
        }

        try
        {
            switch (gender) {
                case 1:
                    this.gender = Gender.Boy;
                    break;
                case 2:
                    this.gender = Gender.Girl;
                    break;
                default:
                    this.gender = Gender.Unknown;
                    break;
            }
        } catch (Exception e)
        {
            this.gender = Gender.Unknown;
        }

        // 我们随便塞入一个方法，用来赋值当前系统时间，以便传给数据库
        this.lastUpdateDate = LocalDate.now();
    }

    @Override
    public String toString()
    {
        return "id: " + id + "，用户名: " + userName + "，姓名: " + name + "，手机号: " + phone + "，职位类型：" + department + "，入职时间：" + entryDate + "，最后操作时间：" + lastUpdateDate;
    }
}