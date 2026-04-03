package com.kunkun.springwebone.service.impl;

import com.kunkun.springwebone.dto.EmployeeQuery;
import com.kunkun.springwebone.entity.Employee;
import com.kunkun.springwebone.mapper.EmployeeMapper;
import com.kunkun.springwebone.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// 请求数据类，通过Dao返回的数据实例化对象并交给相应的Controller
@Service
public class EmployeeServiceImpl implements EmployeeService
{
    // 接口实现类已经由mybatis自动实现了，所以您无需手动实现，只需要定义XML，然后这将会返回有效Employee对象
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeMapper.getAllEmployees();
    }

    @Override
    public List<Employee> getRequiredEmployees(EmployeeQuery query) {
        return employeeMapper.getRequiredEmployees(query.getName(),query.getGender(),query.getStartDate(),query.getEndDate());
    }
}
