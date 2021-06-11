package yh.company.service;

import org.apache.ibatis.annotations.Param;
import yh.company.entity.User;

import java.util.List;

public interface UserService {
    //添加用户
    int insertUser(String username, String sex, long idCard, long phone, String email,
                 int departmentId, long card, String password,int authority);

    //通过email查询
    int findUser(String email);

    //登录
    User login(long userId,String password);

    //通过工号查询用户
    User queryById(long userId);

    //查询所有用户
    List<User> queryAll();
    //通过工号和电话，修改密码
    int updatePassword(String password,long userId,long phone);
    //删除用户
    int deleteUser(long userId);

    //根据工号查询工资的有关情况
    Integer getAllMoney(long userId);
    //添加各项工资
    int updatePay(long userId,int basepay,int reward,int allowance);
    //改变权限
    int updateAuthority(long userId,int authority);

}
