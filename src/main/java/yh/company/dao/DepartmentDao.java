package yh.company.dao;

import org.apache.ibatis.annotations.Param;
import yh.company.entity.Department;

import java.util.List;

public interface DepartmentDao {
    Department selectById(@Param("departmentid") int departmentid);
}
