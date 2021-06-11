package yh.company.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import yh.company.utils.Result;
import yh.company.entity.Mend;
import yh.company.entity.User;
import yh.company.service.CheckWorkService;
import yh.company.service.MendService;
import yh.company.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@CrossOrigin
public class MendController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private MendService mendService;
    @Autowired
    private CheckWorkService checkWorkService;
    @Autowired
    private UserService userService;

    //申请补签（所有人）
    @RequestMapping(value = {"/home/personal/insertMend"},method = RequestMethod.POST)
    @ResponseBody
    public Result insertMend(@RequestBody Map<String,Object> map, HttpServletRequest request){
        long userId1 = Long.parseLong(request.getHeader("Authorization"));
        User user = userService.queryById(userId1);
        String csignin = map.get("time").toString();
        String cause = map.get("cause").toString();
        List<Mend> lists = mendService.queryMendByUserId(userId1,csignin);
        if( lists.isEmpty()){
            int i = mendService.insertMend(userId1,user.getUsername(),csignin,cause);
            if(i<=0){
                return new Result("申请失败",0);
            }else{
                return new Result("申请成功",1);
            }
        }else{
            return new Result("申请失败",0);
        }
    }
    //批阅补签（管理员）
    @RequestMapping(value = {"/home/personal/updateMend"},method = RequestMethod.POST)
    @ResponseBody
    public Result updateMend(@RequestBody Map<String,Object> map, HttpServletRequest request) {
        String arrs = map.get("arr").toString();
        long userId1 = Long.parseLong(request.getHeader("Authorization"));
        User user1 = userService.queryById(userId1);
        int type = Integer.parseInt(map.get("code").toString());
        String[] arrss = arrs.split(",");
        int w = 0,s = 0,flag=0;
        for(int i=0;i<arrss.length;i++){
            System.out.println(arrss[i]+"====================================");
            Mend mendById = mendService.getMendById(Integer.parseInt(arrss[i]));
            long userId = mendById.getUserId();
            User user = userService.queryById(userId);
            if(user1.getAuthority() == 1){
                if(user1.getDepartmentId() == user.getDepartmentId()){
                    if (type == 1) {
                        w = mendService.updateMend(userId1, user1.getUsername(), Integer.parseInt(arrss[i]), type);
                        checkWorkService.updateType(mendById.getCsignin(), mendById.getUserId());
//                        return new Result("批阅同意", 1);
                    } else if (type == 2) {
                        s = mendService.updateMend(userId1, user1.getUsername(),Integer.parseInt(arrss[i]), type);
//                        return new Result("批阅拒绝", 2);
                    } else{
//                        return new Result("批阅失败",0);
                        flag = 1;
                    }
                }
            }
        }
        if(w>0){
            return new Result("批阅成功",1);
        }else if(s>0){
            return new Result("批阅拒绝",2);
        }else{
            return new Result("批阅失败",0);
        }



        //        //得到管理员的id
//        long userId1 = Long.parseLong(request.getHeader("Authorization"));
//        //得到管理员所有信息
//        User user1 = userService.queryById(userId1);
        //得到表单id
//        int mendId = Integer.parseInt(map.get("mendId").toString());
//        int type = Integer.parseInt(map.get("type").toString());
//        Mend mendById = mendService.getMendById(mendId);
        //通过单号查询到用户名，通过用户名查询到所在部门，判断申请人部门是否与批阅人在同一个部门

    }
    //查看所有同意补签的记录
    @RequestMapping(value = {"/home/personal/queryAllMendSuccess"},method = RequestMethod.POST)
    @ResponseBody
    public Result queryAllMendSuccess( HttpServletRequest request){
        long userId1 = Long.parseLong(request.getHeader("Authorization"));
        User user1 = userService.queryById(userId1);
        if(user1.getAuthority() == 0){
            return new Result(null,"查看失败",0);
        }else{
            List<Mend> mends = mendService.queryAllMendSuccess();
            if(mends.isEmpty()){
                return new Result(null,"查看失败",0);
            }else{
                return new Result(mends,"查看成功",1);
            }
        }
    }
    //查看所有没有同意补签的记录
    @RequestMapping(value = {"/home/personal/queryAllNoMend"},method = RequestMethod.POST)
    @ResponseBody
    public Result queryAllNoMend( HttpServletRequest request){
        long userId1 = Long.parseLong(request.getHeader("Authorization"));
        User user1 = userService.queryById(userId1);
        if(user1.getAuthority() == 0){
            return new Result(null,"查看失败1",0);
        }else{
            List<Mend> mends = mendService.queryAllNoMend();
            if(mends.isEmpty()){
                return new Result(null,"查看失败2",0);
            }else{
                return new Result(mends,"查看成功",1);
            }
        }
    }
    //通过用户id查看所有补签记录
    @RequestMapping(value = {"/home/personal/queryByIdAllMend"},method = RequestMethod.POST)
    @ResponseBody
    public Result queryByIdAllMend( HttpServletRequest request){
        long userId1 = Long.parseLong(request.getHeader("Authorization"));
        List<Mend> mends = mendService.queryByIdAllMend(userId1);
        List<Mend> mendss = new ArrayList<>();
        if(mends.size()<=7){
            for(int i=0;i<mends.size();i++){
                Mend mend = mends.get(i);
                mendss.add(mend);
            }
        }else{
            for(int i=0;i<7;i++){
                Mend mend = mends.get(i);
                mendss.add(mend);
            }
        }
        if(mendss.isEmpty()){
            return new Result(null,"查看失败",0);
        }else{
            return new Result(mendss,"查看成功",1);
        }
    }
}
