package com.kunkun.springwebone.service;

import com.kunkun.springwebone.dto.EmployeeQuery;
import com.kunkun.springwebone.entity.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployees();
    public List<Employee> getRequiredEmployees(EmployeeQuery query);
    public int insertEmployee(Employee employee);
    public int deleteById(Integer id);
    public int batchDeleteById(List<Integer> ids);
    public int updateEmployee(Employee employee);
}
