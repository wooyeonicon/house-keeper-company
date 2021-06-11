package yh.company.service;

import yh.company.dao.DepartmentDao;
import yh.company.entity.Department;

import java.util.List;

public interface DepartmentService {
    Department selectById(int departmentid);
}
