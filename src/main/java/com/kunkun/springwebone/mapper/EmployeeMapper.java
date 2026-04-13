package com.kunkun.springwebone.mapper;

import com.kunkun.springwebone.entity.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

// 有了这个注解，Mybatis就会自动生成实现类，我们只需要负责定义接口
@Mapper
public interface EmployeeMapper {
    public List<Employee> getRequiredEmployees(@Param("name") String name,
                                               @Param("gender") Integer gender,
                                               @Param("startDate") LocalDate startDate,
                                               @Param("endDate") LocalDate endDate);

    /**
     * 调用即可获得所有数据库里面的员工
     * @return 所有员工集合
     */
    public List<Employee> getAllEmployees();

    /**
     * 新增指定员工
     * @param employee 新的员工对象
     * @return 受影响行数
     */
    public int insertEmployee(Employee employee);

    /**
     * 根据主键（id）删除指定数据库字段
     * @param id 员工id
     * @return 受影响行数
     */
    public int deleteById(Integer id);

    /**
     * 根据主键（id）删除指定数据库字段
     * @param ids 员工id列表
     * @return 受影响行数
     */
    public int batchDeleteById(@Param("ids") List<Integer> ids);

    /**
     * 根据主键（id）删除指定数据库字段
     * @param employee 员工对象
     * @return 受影响行数
     */
    public int updateEmployee(Employee employee);
}
