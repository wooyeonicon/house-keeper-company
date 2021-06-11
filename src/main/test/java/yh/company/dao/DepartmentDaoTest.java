package yh.company.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import yh.company.entity.Department;
import yh.company.entity.User;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class DepartmentDaoTest {
    @Resource
    private DepartmentDao departmentDao;
    @Resource
    private UserDao userDao;
    @Test
    public void test(){
        long userid = 100001;
        User user = userDao.queryById(userid);
        Department department = departmentDao.selectById(user.getDepartmentId());
        System.out.println("======================="+department.getDepartmentname());
    }

}
