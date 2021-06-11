package yh.company.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import yh.company.utils.Result;
import yh.company.entity.Result1;
import yh.company.entity.User;
import yh.company.entity.Vacation;
import yh.company.service.UserService;
import yh.company.service.VacationService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@CrossOrigin
@Controller
public class VacationController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private VacationService vacationService;
    @Autowired
    private UserService userService;
    /**
     * //请假username,vuid,starttime,endtime,type,cause
     *     int insertVacation(String username,long vuid,String starttime,
     *                        String endtime,String type,String cause);
     *
     *     //批准请假
     *     int updateState(long vuid);
     *     //查看所有请假通过的
     *     List<Vacation> queryAllPass();
     *     //查看所有需要请假的
     *     List<Vacation> queryAllReady();
     *     //拒绝请假
     *     int deleteVacation(long vuid);
     * @param
     * @return
     */
//queryVacationByVuid
    //请假(所有人)
    @RequestMapping(value = {"/home/personal/askleave"},method = RequestMethod.POST)
    @ResponseBody
    public Result askleave(@RequestBody Map<String,Object> map,HttpServletRequest request) {
        long userId = Long.parseLong(request.getHeader("Authorization"));
        User user = userService.queryById(userId);
        List<Vacation> lists = vacationService.queryVacationByVuid(userId,map.get("starttime").toString());
        if(lists.isEmpty()){
            int i = vacationService.insertVacation(user.getUsername(), userId,
                    map.get("starttime").toString(), map.get("endtime").toString(),
                    map.get("type").toString(), map.get("cause").toString());
            if (i <= 0) {
                return new Result( "请假失败1", 0);
            } else{
                return new Result( "请假成功", 1);
            }
        }else{
            return new Result("请假失败2",0);
        }
    }
    //批阅假条(管理员)
    @RequestMapping(value = {"/home/personal/review"},method = RequestMethod.POST)
    @ResponseBody
    public Result review(@RequestBody Map<String,Object> map,HttpServletRequest request){
        long userId1 = Long.parseLong(request.getHeader("Authorization"));
        User user = userService.queryById(userId1);
        if(user.getAuthority() == 0){
            return new Result(null,"批阅失败",0);
        }else{
            int i = vacationService.updateState(Integer.parseInt(map.get("vacationId").toString()),Integer.parseInt(map.get("code").toString()));
            if(i<=0){
                return new Result("批阅失败",0);
            }else{
//                List<Vacation> vacation = vacationService.queryVacationByVuid(Long.valueOf(String.valueOf(map.get("userId"))),map.get("starttime").toString());
                return new Result("批阅成功",1);
            }
        }
    }

    //查询所有请假成功的假条(管理员)
    @RequestMapping(value = {"/home/personal/queryAllPass"},method = RequestMethod.POST)
    @ResponseBody
    public Result queryAllPass(HttpServletRequest request){
        long userId1 = Long.parseLong(request.getHeader("Authorization"));
        User user = userService.queryById(userId1);
        if(user.getAuthority() == 0){
            return new Result(null,"查询失败",0);
        }else{
            List<Vacation> lists = vacationService.queryAllPass();
            if(lists == null){
                return new Result(null,"查询失败",0);
            }else{
                return new Result(lists,"查询成功",1);
            }
        }
    }

    //查询所有准备请假的假条（管理员）
    @RequestMapping(value = {"/home/personal/queryAllReady"},method = RequestMethod.POST)
    @ResponseBody
    public Result queryAllReady(HttpServletRequest request){
        long userId1 = Long.parseLong(request.getHeader("Authorization"));
        User user = userService.queryById(userId1);
        if(user.getAuthority() == 0){
            return new Result(null,"查询失败",0);
        }else{
            List<Vacation> lists = vacationService.queryAllReady();
            if(lists.isEmpty()){
                return new Result(null,"查询失败",0);
            }else{
                return new Result(lists,"查询成功",1);
            }
        }
    }
    //删除不同意给请假的假条  （管理员）
    @RequestMapping(value = {"/home/personal/deleteVacation"},method = RequestMethod.POST)
    @ResponseBody
    public Result deleteVacation(@RequestBody Map<String,Object> map,HttpServletRequest request){
        long userId1 = Long.parseLong(request.getHeader("Authorization"));
        User user = userService.queryById(userId1);
        if(user.getAuthority() == 0){
            return new Result("删除失败",0);
        }else{
            int i = vacationService.deleteVacation(Long.valueOf(String.valueOf(map.get("userId"))));
            if(i<=0){
                return new Result("删除失败",0);
            }else{
                return new Result("删除成功",1);
            }
        }
    }
    //请假所剩余时间的状态
    @RequestMapping(value = {"/home/personal/dayMap"},method = RequestMethod.POST)
    @ResponseBody
    public Result dayMap(HttpServletRequest request){
        long sum1 = 0,sum2 = 0,sum3 = 0,sum4 = 0;
        String time1 = null,time2 = null,time3 = null,time4 = null;
        long userId = Long.parseLong(request.getHeader("Authorization"));
        List<Vacation> lists = vacationService.queryVacationByState(userId,1);
        List<Result1> l = new ArrayList<>();
        for(int i=0;i<lists.size();i++){
            Result1 result1 = new Result1();
            Vacation list =  lists.get(i);
            //System.out.println("========================================2");
            if(list.getType().equals("事假")){
                sum1 = Long.valueOf(list.getEndtime())-Long.valueOf(list.getStarttime())+sum1;
                time1 = String.valueOf(sum1);
                result1.setTime(time1);
                result1.setType("事假");
                //System.out.println("_______________"+time1+"__________");
            }else if(list.getType().equals("病假")){
                sum2 = Long.valueOf(list.getEndtime())-Long.valueOf(list.getStarttime())+sum2;
                time2 = String.valueOf(sum2);
                result1.setTime(time2);
                result1.setType("病假");
                //System.out.println("_______________"+time2+"__________");
            }else if(list.getType().equals("产假")){
                sum3 = Long.valueOf(list.getEndtime())-Long.valueOf(list.getStarttime())+sum3;
                time3 = String.valueOf(sum3);
                result1.setTime(time3);
                result1.setType("产假");
                //System.out.println("_______________"+time3+"__________");
            }else {
                sum4 = Long.valueOf(list.getEndtime())-Long.valueOf(list.getStarttime())+sum4;
                time4 = String.valueOf(sum4);
                result1.setTime(time4);
                result1.setType("公司外派假期");
                //System.out.println("_______________"+time4+"__________");
            }
            l.add(result1);
        }
        System.out.println("==============================3");
        return new Result(l,"成功",1);
    }
}
