package com.kunkun.springwebone.mapper;

import com.kunkun.springwebone.entity.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmployeeMapper {
    public List<Employee> getRequiredEmployees(@Param("name") String name,
                                               @Param("gender") Integer gender,
                                               @Param("startDate") LocalDate startDate,
                                               @Param("endDate") LocalDate endDate);
    public List<Employee> getAllEmployees();
}
