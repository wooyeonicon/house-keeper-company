package yh.company.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import yh.company.entity.User;
import yh.company.util.MD5Utils;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class UserDaoTest {
//    @Resource
    private MD5Utils md5Utils;
    @Resource
    private UserDao userDao;



    @Test
    public void queryById(){
        long userId = 100001;
        User user = userDao.queryById(userId);
        System.out.println(user);
    }
    //String username, String sex, long idCard, long phone, long empNumber, String email,
    //                 int department, long card, String password
    //String username, String sex, long idCard, long phone,
    // long empNumber, String email, int department, long card, String password
//    @Test
//    public void insertUser(){
//
//        String username = "熊大";
//        String sex = "男";
//        long idcard = 333;
//        long phone = 333;
//        String email = "4444@qq.com";
//        int departmentId = 1;
//        long card = 333;
//        String password = "yangh1";
//        String pwd = null;
//        try {
//            pwd = md5Utils.getEncryptedPwd(password);
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        userDao.insertUser(username,sex, idcard, phone, email, departmentId, card, pwd);
//        System.out.println(1);
//    }

//    @Test
//    public void queryAll(){
//        Map<String,Object> map = new HashMap<>();
//        PageHelper.startPage(0,5);
//        List<User> users = userDao.queryAll();
//        PageInfo<User> pageInfo = new PageInfo<>(users);
//        map.put("pageInfo",pageInfo);
//        System.out.println("***********************************");
//        System.out.println(map);
//        System.out.println("***********************************");
//        System.out.println("____________________"+pageInfo);
//        System.out.println("************************************");
////        for(User userss : users){
////            System.out.println(userss);
////        }
//    }

    @Test
    public void updatePassword(){
        String password = "baiBAI123";
        long userId = 100002;
        long phone = 222;
        System.out.println(userDao.updatePassword(password,userId,phone));
        System.out.println("*******************************************");
    }

    @Test
    public void deleteUser(){
        long userId = 100003;
        System.out.println(userDao.deleteUser(userId));
    }

    @Test
    public void getAllMoney(){
        long userId = 100001;
        Integer i = userDao.getAllMoney(userId);
        System.out.println(i);
    }

    @Test
    public void updatePay(){
        long userId = 100002;
        int basePay = 2000;
        int reward = 500;
        int allowance = 500;
        userDao.updatePay(userId,basePay,reward,allowance);
        System.out.println(userDao.getAllMoney(userId));
    }
    @Test
    public void updateAuthority(){
        long userId = 100001;
        int authority = 1;
        userDao.updateAuthority(userId,authority);
        System.out.println("_________________"+userDao.queryById(userId));
    }
    @Test
    public void login1(){
        long id = 100001;
        String password = "YANGhang111";
        User user = userDao.login(id,password);
        System.out.println("============"+user+"===============");
    }
    @Test
    public void test8(){
        Date time = new Date();
        Date time2 = new Date();
        Calendar now = Calendar.getInstance();
        int i = now.get(Calendar.YEAR);
        System.out.println("==========="+i);
        int i1 = now.get(Calendar.MONTH)+1;
        System.out.println("==========="+i1);
        int i2 = now.get(Calendar.DAY_OF_MONTH);
        System.out.println("=============="+i2);
        now.set(i,i1-1,i2,9,0,0);
        long timeInMillis = now.getTimeInMillis();
        time2.setTime(timeInMillis);
        System.out.println("================"+new SimpleDateFormat().format(time2));
        System.out.println("==============="+timeInMillis);
        System.out.println("========================"+time.getTime());
    }
}
