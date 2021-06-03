package yh.company.dao;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import yh.company.entity.Vacation;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class VacationDaoTest {
    @Resource
    private VacationDao vacationDao;
    @Test
    public void insertVacation(){
        String username = "白子煜";
        long vuid = 100002;
        String starttime = "2020-10-01 07:25";
        String endtime = "2020-10-02 08:25";
        String type = "产假";
        String cause = "由于身体原因，请假";
        System.out.println(vacationDao.insertVacation(username,vuid,starttime,endtime,type,cause));
    }
//    @Test
//    public void updateState(){
//        long vuid = 100001;
//        String starttime = "1";
//        int state = 1;
//        System.out.println(vacationDao.updateState(vuid,starttime,1));
//    }
    @Test
    public void queryAllPass(){
        List<Vacation> vacations = vacationDao.queryAllPass();
        for(Vacation vacationss : vacations){
            System.out.println(vacationss);
        }
    }
    @Test
    public void queryAllReady(){
        List<Vacation> vacations = vacationDao.queryAllReady();
        for(Vacation vacationss : vacations){
            System.out.println(vacationss);
        }
    }
    @Test
    public void deleteVacation(){
        long vuid = 100004;
        System.out.println(vacationDao.deleteVacation(vuid));
    }
    // public Vacation queryVacationByVuid(long vuid, String starttime) {
    //        return vacationDao.queryVacationByVuid(vuid,starttime);
    //    }
    @Test
    public void queryVacationByVuid(){
        long vuid = 100001;
        String starttime = "1";
        System.out.println("***************************");
        System.out.println(vacationDao.queryVacationByVuid(vuid,starttime));
    }

    @Test
    public void askleave(){
        long userId = 100002;
        String username = "白zi";
        String starttime = "3276327322222";
        String endtime = "65478384322233";
        String type = "产假";
        String cause = "dhsjhdsj";
        List<Vacation> list = vacationDao.queryVacationByVuid(userId,starttime);
        System.out.println("++++++++++++++++");
        System.out.println(list);
        if(list.isEmpty()){
            System.out.println("----------------");
            int i = vacationDao.insertVacation(username,userId,starttime,endtime,type,cause);
            System.out.println(i);
            System.out.println("________________________________");
        }else{
            System.out.println("----------------------1");
        }
    }
    @Test
    public void dayMap(){
        long userId = 100002;
        long sum1 = 0,sum2 = 0,sum3 = 0,sum4 = 0;
        String time1 = null,time2 = null,time3 = null,time4 = null;
        List<Vacation> lists = vacationDao.queryVacationByState(userId,1);
        System.out.println("+++++++"+lists+"+++++++++++");
        for(int i=0;i<lists.size();i++){
            Vacation list =  lists.get(i);
            System.out.println("______"+i+"_________________");
            if(list.getType().equals("事假")){
                sum1 = sum1+Long.valueOf(list.getEndtime())-Long.valueOf(list.getStarttime());
                time1 = String.valueOf(sum1);
                System.out.println("_______________"+time1+"__________");
            }else if(list.getType().equals("病假")){
                sum2 = Long.valueOf(list.getEndtime())-Long.valueOf(list.getStarttime())+sum2;
                time2 = String.valueOf(sum2);
                System.out.println("_______________"+time2+"__________");
            }else if(list.getType().equals("产假")){
                sum3 = Long.valueOf(list.getEndtime())-Long.valueOf(list.getStarttime())+sum3;
                time3 = String.valueOf(sum3);
                System.out.println("_______________"+time3+"__________");
            }else {
                sum4 = Long.valueOf(list.getEndtime())-Long.valueOf(list.getStarttime())+sum4;
                time4 = String.valueOf(sum4);
                System.out.println("_______________"+time4+"__________");
            }
        }
    }
    @Test
    public void sli(){
        String s = "1609257960922";
        String w = "1609257960921";
        long i = Long.valueOf(s)-Long.valueOf(w);
        String a = String.valueOf(i);
        //Integer  i = Integer.valueOf(s)-Integer.valueOf(w);
        System.out.println(i);
        System.out.println("______________");
    }
}
