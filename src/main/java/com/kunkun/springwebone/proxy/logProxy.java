package com.kunkun.springwebone.proxy;

import com.kunkun.springwebone.entity.Employee;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

// 代理类，我们先用他来打印调试日志
@Aspect
@Component
@Profile("dev")
public class logProxy {
    @AfterReturning(pointcut = "execution(* com.kunkun.springwebone.service.EmployeeService.getAllEmployees(..))", returning = "result")
    public void logEmployeeDetails(Object result)
    {
        /*
        if (result instanceof List<?>) {
            List<?> employees = (List<?>) result;

            for (Object obj : employees) {
                // 2. 类型转换
                if (obj instanceof Employee emp) {
                    System.out.println(emp);
                }
            }
        }
        */
    }
}
