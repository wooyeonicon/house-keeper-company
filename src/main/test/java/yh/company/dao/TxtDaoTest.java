package yh.company.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import yh.company.entity.Txt;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class TxtDaoTest {
    @Resource
    private TxtDao txtDao;
    @Test
    public void insertTxt(){
        long userId = 100002;
        String time = "1";
        String title = "aghsga";
        String message = "dhhjsahdjsj";
        String content = "我们组是管家婆，特别厉害，很厉害，恒强";
        System.out.println("_________________________");
        System.out.println(txtDao.addTxt(userId,time,title,message,content));
        System.out.println("__________________________");

    }
    @Test
    public void queryTxtById(){
        long txtId = 1;
        System.out.println("_____________________________1");
        System.out.println(txtDao.queryTxtById(txtId));
        System.out.println("_____________________________");
    }

}
