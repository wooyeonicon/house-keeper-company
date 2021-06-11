package yh.company.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import yh.company.entity.Mend;
import yh.company.entity.User;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class MendDaoTest {
    @Resource
    private MendDao mendDao;

    @Resource
    private UserDao userDao;

    @Test
    public void insertMend(){
        long userId = 100002;
        User user = userDao.queryById(100002);

        String time = "1608127212718";
        String cause = "华云";
        int i = mendDao.insertMend(userId,user.getUsername(),time,cause);
        System.out.println("*********************************");
        System.out.println(i);
        System.out.println("*********************************");
    }
    @Test
    public void updateMend(){
        long userId1 = 100001;
        User user1 = userDao.queryById(userId1);
        int mendId = 1;
        int type = 1;
        int i = mendDao.updateMend(userId1,user1.getUsername(),mendId,type);
        System.out.println("*********************************");
        System.out.println(i);
    }

    @Test
    public void s(){
        long userId = 100002;
        String csignin = "21323232";
        List<Mend> lists = mendDao.queryMendByUserId(userId,csignin);
        if(lists.isEmpty()){
            System.out.println("正确");
        }else{
            System.out.println("失败");
        }
        System.out.println("___________________________");
        System.out.println(lists);
        System.out.println("________________________");
    }
    @Test
    public void queryMendById(){
        long userId = 100002;
        List<Mend> lists = mendDao.queryByIdAllMend(userId);
        List<Mend> listss = new ArrayList<>();
        for(int i=0;i<4;i++){
            Mend list = lists.get(i);
            listss.add(list);
        }
        System.out.println(listss);
    }
}
