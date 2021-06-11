package yh.company.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import yh.company.utils.Result;
import yh.company.entity.CheckWork;
import yh.company.service.CheckWorkService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
public class CheckWorkController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    //统计一个用户的所有签到情况findById
    @Autowired
    private CheckWorkService checkWorkService;
    @RequestMapping(value = {"/home/personal/findCheckById"},method = RequestMethod.POST)
    @ResponseBody
    public Result findCheckById(HttpServletRequest request){
        long userId = Long.parseLong(request.getHeader("Authorization"));
        List<CheckWork> lists = checkWorkService.findById(userId);
        List<CheckWork> listss = new ArrayList<>();
        if(lists.isEmpty()){
            return new Result(null,"查询失败",0);
        }else{
            if(lists.size()<=7){
                for(int i=0;i<lists.size();i++){
                    CheckWork list = lists.get(i);
                    listss.add(list);
                }
            }else{
                for(int i=0;i<7;i++){
                    CheckWork list = lists.get(i);
                    listss.add(list);
                }
            }
            return new Result(listss,"查询成功",1);
        }
    }
    //签退(退出)
    @RequestMapping(value = {"/home/personal/unLogin"},method = RequestMethod.POST)
    @ResponseBody
    //@RequestBody Map<String,Object> map,
    public Result unLogin( HttpServletRequest request){
        long userId = Long.parseLong(request.getHeader("Authorization"));
        Date time = new Date();
        CheckWork c = checkWorkService.check(userId);
        int i = checkWorkService.updateOut(time.getTime()+"",c.getCuid(),c.getSignin());
        if(i>0){
            return new Result("签退成功",1);
        }else{
            return new Result("签退失败",0);
        }
//        if(c.getSignout() == null){
//            int i = checkWorkService.insertSignout(c.getCuid(), c.getSignin(),time.getTime()+"");
//            if(i>0){
//                return new Result("签退成功",1);
//            }else{
//                return new Result("签退失败",0);
//            }
//        }else{
//            int i = checkWorkService.updateOut(time.getTime()+"",c.getCuid(),c.getSignin());
//            if(i>0){
//                return new Result("签退成功",1);
//            }else{
//                return new Result("签退失败",0);
//            }
//        }

        //String signin = map.get("signin").toString();
//        String signout =map.get("time").toString();
//        int i = checkWorkService.updateOut(signout,userId,signin);
//        if(i<=0){
//            return new Result("签退失败",0);
//        }else{
//            return new Result("签退成功",1);
//        }
    }

}
