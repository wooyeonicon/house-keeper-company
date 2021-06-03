package yh.company.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import yh.company.utils.Result;
import yh.company.entity.User;
import yh.company.entity.Wages;
import yh.company.service.UserService;
import yh.company.service.WagesService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
public class WagesController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private WagesService wagesService;
    @Autowired
    private UserService userService;

    //添加工资（管理员）
    @RequestMapping(value = {"/home/personal/insertWages"},method = RequestMethod.POST)
    @ResponseBody
    public Result insertWages(@RequestBody Map<String,Object> map, HttpServletRequest request){
        long userId = Long.parseLong(request.getHeader("Authorization"));//管理员
        User user = userService.queryById(userId);
        long userId1 = Long.valueOf(String.valueOf(map.get("userId")));
        User user1 = userService.queryById(userId1);
        double money =
                Double.parseDouble(map.get("basepay").toString())+
                        Double.parseDouble(map.get("reward").toString())+
                                Double.parseDouble(map.get("allowance").toString());
        if(user.getAuthority() == 0){
            return new Result("添加失败1",0);
        }else{
            if(user.getDepartmentId() != user1.getDepartmentId()){//管理员必须和用户在同意部门
                return new Result("添加失败2",0);
            }else{
                int i = wagesService.insertWages(userId1,money,Double.parseDouble(map.get("basepay").toString())
                        ,Double.parseDouble(map.get("reward").toString()),
                        Double.parseDouble(map.get("allowance").toString()),map.get("time").toString());
                if(i<=0){
                    return new Result("添加失败3",0);
                }else{
                    return new Result("添加成功",1);
                }
            }
        }
    }
    //通过id查询前6个月的工资（所有人）
    @RequestMapping(value = {"/home/personal/queryWagesById"},method = RequestMethod.POST)
    @ResponseBody
    public Result queryWagesById(HttpServletRequest request){
        long userId = Long.parseLong(request.getHeader("Authorization"));
        List<Wages> lists = wagesService.queryWagesById(userId);
        List<Wages> listss = new ArrayList<>();
        if(lists.isEmpty()){
            return new Result(null,"查询失败1",0);
        }else{
            if(lists.size()<=6){
                for(int i=0;i<lists.size();i++){
                    Wages list = lists.get(i);
                    listss.add(list);
                }
            }else{
                for(int i=0;i<6;i++){
                    Wages list = lists.get(i);
                    listss.add(list);
                }
            }
            if(listss.isEmpty()){
                return new Result(null,"查询失败1",0);
            }else{
                return new Result(listss,"查询成功",1);
            }
        }
    }
}
