package com.kunkun.springwebone.utils;

import com.kunkun.springwebone.entity.Employee;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseUtils {
    private final String url = "jdbc:mysql://localhost:3306/company_db?useUnicode=true&characterEncoding=utf8";
    private final String user = "root";
    private final String password = "123456";

    public List<Employee> GetEmployeeList(String sql)
    {
        List<Employee> res = new ArrayList<>();
        // 多个嵌套try是为了能够正确关闭资源
        try(Connection conn = DriverManager.getConnection(url,user,password))
        {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            try (ResultSet rs = pstmt.executeQuery();)
            {
                /*
                while (rs.next()) {
                    Employee emp = new Employee();
                    emp.setUserName(rs.getString("username"));
                    emp.setDepartment(rs.getString("department"));
                    emp.setGender(rs.getInt("gender"));
                    emp.setAvatarUrl(rs.getString("avatar_url"));
                    emp.setEntryDate(rs.getObject("entry_date", LocalDate.class));
                    emp.setPhone(rs.getString("phone"));
                    emp.setName(rs.getString("name"));
                    emp.setJobTitle(rs.getString("job_title"));
                    emp.setId(rs.getInt("id"));
                    res.add(emp);
                }
                */
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return res;
    }
}
