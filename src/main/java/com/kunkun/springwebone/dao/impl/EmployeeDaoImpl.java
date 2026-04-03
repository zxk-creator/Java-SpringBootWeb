package com.kunkun.springwebone.dao.impl;

import com.kunkun.springwebone.dao.EmployeeDao;
import com.kunkun.springwebone.entity.Employee;
import com.kunkun.springwebone.utils.DatabaseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    @Autowired
    private DatabaseUtils dbUtils;
    private final String getAllEmployeeSql = "SELECT * FROM employees";

    // JDBC用的，直接返回所有Employee成员
    public List<Employee> GetAllEmployees() {
        return dbUtils.GetEmployeeList(getAllEmployeeSql);
    }
}
