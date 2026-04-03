package com.kunkun.springwebone.controller;

import com.kunkun.springwebone.dto.EmployeeQuery;
import com.kunkun.springwebone.entity.Employee;
import com.kunkun.springwebone.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    // 虽然我们并非打开新的页面，但是就是这样规定的，必须访问这个才能发过去数据
    // 这个方法是直接一次性返回所有的员工列表进行查操作
    @PostMapping("/getAll")
    public List<Employee> GetAllEmployeeList()
    {
        return employeeService.getAllEmployees();
    }
    // 这个方法是根据Param返回指定的员工列表进行查操作
    @PostMapping("/search")
    public List<Employee> GetRequiredEmployeeList(@RequestBody EmployeeQuery query)
    {
        return employeeService.getRequiredEmployees(query);
    }
    // 这个方法是根据传入的数据进行增操作
    @PostMapping("/add")
    public void addSpecificEmployee(@RequestBody Employee employee)
    {
        System.out.println(employee);
    }
}
