package yh.company.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import yh.company.entity.CheckWork;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class CheckWorkDaoTest {
    @Resource
    private CheckWorkDao checkWorkDao;

//    private long cuid;
//    private String username;
//    private Time signin;
//    private Time signout;
//    private Date date;
//    @Test
//    public void insertCheck(){
//        long cuid = 100001;
//        String username = "杨航";
//        String signin = "2020-12-08 08:30:00";
//        String signout = "2020-12-08 19:30:00";
//        String date = "2020-12-08";
//        System.out.println(checkWorkDao.insertCheck(cuid,username,signin,signout));
//    }
//    //签到
//    int insertCheck(long cuid,String username,String signin,String signout,String date);
//    //统计一个用户的所有签到情况
//    List<CheckWork> findById(long cuid);
//    //统计所有用户同一天签到情况
//    List<CheckWork> findAllByDay(String date);
//    //删除上一个月所有的签到
//    int deleteCheck(String date);
    @Test
    public void findById(){
        long cuid = 100002;
        List<CheckWork> list = checkWorkDao.findById(cuid);
        System.out.println("___________________");
        System.out.println(list);
        System.out.println("___________________");
        for(CheckWork lists : list){
            System.out.println(lists);
        }
    }
    // long userId = Long.parseLong(request.getHeader("Authorization"));
    //        String signin = map.get("signin").toString();
    //        String signout =map.get("time").toString();
    //        int i = checkWorkService.updateOut(signout,userId,signin);
    //        if(i<=0){
    //            return new Result("签退失败",0);
    //        }else{
    //            return new Result("签退失败",1);
    //        }

    @Test
    public void unLogin(){
        long userId = 100001;
        String signin = "1608126338923";
        String signout = "1608126368164";
        int i = checkWorkDao.updateOut(signout,userId,signin);
        System.out.println("---------------------------------");
        System.out.println(i);
        System.out.println("*********************************");
    }

//    @Test
//    public void test(){
//        Map<String,Object> map = new HashMap<>();
//        {"arr":[4,5,6,7,8],"code":1,"username":"白子煜"};
//    }
//    @Test
//    public void findAllByDay(){
//        String date = "2020-12-08";
//        List<CheckWork> list = checkWorkDao.findAllByDay(date);
//        for(CheckWork lists : list){
//            System.out.println(lists);
//        }
//    }
//    @Test
//    public void deleteCheck(){
//
//    }
    @Test
    public void test2(){
        Date date = new Date();
        long cuid = 100001;
        String username = "杨航";
        String signin = date.getTime()+"";
        int stat = 0;
        int i = checkWorkDao.insertCheck(cuid,username,signin,stat);
        System.out.println("++++++++++++++++++++"+i);

    }
}
