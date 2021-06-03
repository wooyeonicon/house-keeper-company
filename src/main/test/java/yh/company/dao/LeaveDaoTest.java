package yh.company.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import yh.company.entity.Leave;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class LeaveDaoTest {
    @Resource
    private LeaveDao leaveDao;
    //long userId,String username,int departmentId,String post,
    //                    String type,String cause
    @Test
    public void insertLeave(){
        long userId = 100004;
        String username = "王洋";
        int departmentId = 2;
        String post = "前端工程师";
        String type = "个人原因";
        String cause = "不想干了";
        System.out.println(leaveDao.insertLeave(userId,username,departmentId,post,type,cause));
    }
    //  List<Leave> queryAllLeave();
    //    //拒绝离职
    //    int deleteLeave(@Param("userId") long userId);
    //    //同意离职
    //    int deleteUser(@Param("userId") long userId);
    @Test
    public void queryAllLeave(){
        List<Leave> leaves = leaveDao.queryAllLeave();
        for(Leave leavess : leaves){
            System.out.println(leavess);
        }
    }

    @Test
    public void deleteLeave(){
        long userId = 100004;
        System.out.println(leaveDao.deleteLeave(userId));
    }
    @Test
    public void deleteUser(){
        long userId = 100004;
        System.out.println(leaveDao.deleteUser(userId));
    }

}
