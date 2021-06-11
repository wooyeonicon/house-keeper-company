package yh.company.dao;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class WagesDaoTest {
    @Resource
    private WagesDao wagesDao;

//    @Test
//    public void queryWagesById(){
//        long userId = 100002;
//        List<Wages> lists = wagesDao.queryWagesById(userId);
//        List<Wages> listss
//        List<Wages> lists = wagesService.queryWagesById(userId);
//        List<Wages> listss = null;
//        if(lists.isEmpty()){
//            return new Result(null,"查询失败1",0);
//        }else{
//            if(lists.size()<=6){
//                for(int i=0;i<lists.size();i++){
//                    Wages list = lists.get(i);
//                    listss.add(list);
//                }
//            }else{
//                for(int i=0;i<6;i++){
//                    Wages list = lists.get(i);
//                    listss.add(list);
//                }
//            }
//    }
}
