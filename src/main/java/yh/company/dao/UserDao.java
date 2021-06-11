package yh.company.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;
import yh.company.entity.User;

import java.util.List;

/**
 *     private long userId;//用户工号
 *     private String username;//用户姓名
 *     private String sex;//用户性别
 *     private long idCard;//用户身份证
 *     private long phone;//用户电话
 *
 *     private int departmentId;//部门
 *     private long card;//银行卡
 *     private String password;//用户密码
 */
public interface UserDao {
    //注册（加入用户）返回插入行数 =1成功，=0失败
    int insertUser(@Param("username") String username,
                   @Param("sex") String sex,@Param("idCard") long idCard,@Param("phone") long phone,
                  @Param("email") String email, @Param("departmentId") int departmentId,@Param("card") long card,
                   @Param("password") String password,@Param("authority") int authority);
    //验证
    int findUser(String email);
    //登录
    User login(@Param("userId") long userId,@Param("password") String password);

    //通过工号查询
    User queryById(@Param("userId") long userId);
    //查询所有
    List<User> queryAll();

    //修改密码,通过电话和工号
    int updatePassword(@Param("password") String password,@Param("userId") long userId,@Param("phone") long phone);

    //删除用户
    int deleteUser(@Param("userId") long userId);

    //根据工号查询工资的有关情况
    Integer getAllMoney(@Param("userId") long userId);

    //添加各项工资
    int updatePay(@Param("userId") long userId,@Param("basepay") int basepay,@Param("reward") int reward,@Param("allowance") int allowance);

    //更改权限
    int updateAuthority(@Param("userId") long userId,@Param("authority") int authority);

}
