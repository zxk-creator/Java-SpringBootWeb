package com.kunkun.springwebone.controller;

import com.kunkun.springwebone.dto.EmployeeQuery;
import com.kunkun.springwebone.entity.Employee;
import com.kunkun.springwebone.entity.Result;
import com.kunkun.springwebone.enumeration.StatusCode;
import com.kunkun.springwebone.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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
    public Result<List<Employee>> GetAllEmployeeList() {
        List<Employee> res = employeeService.getAllEmployees();
        return Result.success(res);
    }
    // 这个方法是根据Param返回指定的员工列表进行查操作
    @PostMapping("/search")
    public Result<List<Employee>>  GetRequiredEmployeeList(@RequestBody EmployeeQuery query) {
        List<Employee> res = employeeService.getRequiredEmployees(query);
        return Result.success(res);
    }
    // 这个方法是根据传入的数据进行增操作（唯一赋值操作时间的地方）
    @PostMapping("/add")
    public Result<Void> addSpecificEmployee(@RequestBody Employee employee) {
        // 我们的AOP已经能够接住所有方法，所以我就不要写try-catch了
        employee.setLastUpdateTime(LocalDateTime.now());
        if (employeeService.insertEmployee(employee) == 0) return Result.error(StatusCode.OPERATION_FAILED);

        return Result.success(null);
    }
    // 删（根据指定参数进行删，只会挑选其中一些字段）
    @PostMapping("/deleteById")
    public Result<Void> deleteEmployeeById(@RequestBody Integer id) {
        if (id == null || id <= 0) return Result.error(StatusCode.INVALID_PARAM);
        if (employeeService.deleteById(id) == 0) return Result.error(StatusCode.OPERATION_FAILED);

        return Result.success(null);
    }
    // 批量删除
    @PostMapping("/batchDelete")
    public Result<Void> batchDeleteEmploy(@RequestBody List<Integer> ids){
        if (ids == null || ids.isEmpty())
            return Result.error(StatusCode.INVALID_PARAM);
        if (employeeService.batchDeleteById(ids) == 0)
            return Result.error(StatusCode.OPERATION_FAILED);

        return Result.success(null);
    }
    // 改
    @PostMapping("/update")
    public Result<Void> updateEmployee(@RequestBody Employee employee){
        if (employee == null) return Result.error(StatusCode.INVALID_PARAM);
        if (employeeService.updateEmployee(employee) == 0)
            return Result.error(StatusCode.INVALID_PARAM);

        return Result.success(null);
    }
}
