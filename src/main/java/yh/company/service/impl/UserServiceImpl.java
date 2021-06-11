package yh.company.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yh.company.dao.UserDao;
import yh.company.entity.User;
import yh.company.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserDao userDao;

    //注册
    @Override
    public int insertUser(String username, String sex, long idCard, long phone,String email, int departmentId, long card, String password,int authority) {
        return(userDao.insertUser(username,sex,idCard,phone,email,departmentId,card,password,authority));

    }
    //通过email查询
    @Override
    public int findUser(String email) {
        if(userDao.findUser(email) == 0){
            return 0;
        }
        return 1;
    }
    //登录
    @Override
    public User login(long userId, String password) {
        User user = userDao.login(userId,password);
        if(user!=null && user.getPassword().equals(password) && userId==user.getUserId()){
            return user;
        }
        return null;
    }

    @Override
    public User queryById(long userId) {
        return userDao.queryById(userId);
    }

    public List<User> queryAll(){
        return userDao.queryAll();
    }

    public int updatePassword(String password,long userId,long phone){
        return(userDao.updatePassword(password,userId,phone));
    }

    public int deleteUser(long userId){
        return (userDao.deleteUser(userId));
    }

    public Integer getAllMoney(long userId){
        return userDao.getAllMoney(userId);
    }

    public int updatePay(long userId,int basepay,int reward,int allowance){
        return(userDao.updatePay(userId,basepay,reward,allowance));
    }

    public int updateAuthority(long userId,int authority){
        return (userDao.updateAuthority(userId,authority));
    }
}
