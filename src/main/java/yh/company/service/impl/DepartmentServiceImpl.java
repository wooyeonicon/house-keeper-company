package yh.company.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yh.company.dao.DepartmentDao;
import yh.company.entity.Department;
import yh.company.service.DepartmentService;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public Department selectById(int departmentid) {
        return (departmentDao.selectById(departmentid));
    }
}
