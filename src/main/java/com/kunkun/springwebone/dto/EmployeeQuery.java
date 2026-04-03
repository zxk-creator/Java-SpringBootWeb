package com.kunkun.springwebone.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

// 用来接收前端发来的数据，转换成Java对象
public class EmployeeQuery {
    private String name;
    private Integer gender;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    public EmployeeQuery(){}

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getGender() { return gender; }
    public void setGender(Integer gender) { this.gender = gender; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public LocalDate getEndDate(){ return endDate;}
    public void setEndDate(LocalDate endDate) {this.endDate = endDate;}
}
