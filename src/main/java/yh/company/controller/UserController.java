package yh.company.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import yh.company.entity.CheckWork;
import yh.company.utils.Result;
import yh.company.entity.User;
import yh.company.service.CheckWorkService;
import yh.company.service.UserService;
import yh.company.utils.Time;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
@Controller
@CrossOrigin
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private CheckWorkService checkWorkService;

    // {"username":"王洋",
    //"sex":"男",
    //"idCard":"11121212",
    //"phone":"12121212",
    //"email":"12333@qq.com",
    //"departmentId":"2",
    //"card":"1213231324",
    //"password":"wangYANG22323"}
    //注册（管理员为员工注册）
    @RequestMapping(value = {"/home/personal/register"}, method = RequestMethod.POST)
    @ResponseBody
    public Result register(@RequestBody Map<String, Object> map, HttpServletRequest request) {
        long userId1 = Long.parseLong(request.getHeader("Authorization"));
        User user = userService.queryById(userId1);
        if (user.getAuthority() == 0) {
            return new Result("注册失败", 0);
        } else {
            int findUser = userService.findUser(map.get("email").toString());
            if (findUser == 0) {
                int i = userService.insertUser(
                        map.get("username").toString(),
                        map.get("sex").toString(),
                        Long.valueOf(String.valueOf(map.get("idCard"))),
                        Long.valueOf(String.valueOf(map.get("phone"))),
                        map.get("email").toString(),
                        Integer.parseInt(map.get("departmentId").toString()),
                        Long.valueOf(String.valueOf(map.get("card"))),
                        map.get("password").toString(),
                        Integer.parseInt(map.get("authority").toString()));
                if (i <= 0) {
                    return new Result("注册失败", 0);
                } else {
                    return new Result("注册成功", 1);
                }
            } else {
                return new Result("注册失败", 0);
            }
        }
    }

    //登录（所有人）
    @RequestMapping(value = {"/home/personal/login"}, method = RequestMethod.POST)
    @ResponseBody
    public Result login(@RequestBody Map<String, Object> map) {
        System.out.println("========================================");
        //生成令牌
        String token = UUID.randomUUID() + "";
        //存放到redis中
        System.out.println(token);
        System.out.println("=====================" + token + "======================");

        User user = userService.login(Long.valueOf(String.valueOf(map.get("userId"))),
                map.get("password").toString());
        System.out.println("=================" + user + "========================");
        //if(user != null){
//        if(!user.equals(null)&& new Time().Compare()==true){
//            Date date = new Date();
//            long time1 = date.getTime();
//
//            //签到
//            //int i = checkWorkService.insertCheck(user.getUserId(),user.getUsername(),map.get("time").toString());
//            int i = checkWorkService.insertCheck(user.getUserId(),user.getUsername(),time1+"");
//
//            if(i<=0){
//                return new Result(null,"登录失败",0);
//            }else{
//                return new Result(user,"登录成功",1);
//            }
//        }else{
//            return new Result(null,"登录失败",0);
//        }
        if (user != null) {
            if (new Time().Compare() == true) {
                int stat = 1;
                //long today = new Time().isToday();
                Date date = new Date();
                //String time = String.valueOf(date.getTime());
                //System.out.println("============================"+time);
                CheckWork c = checkWorkService.check(user.getUserId());
                int x = (int) (date.getTime()-Integer.parseInt(c.getSignin()));
                if (x>43200000) {
                    //System.out.println("============================"+time);
                    int j = checkWorkService.insertCheck(user.getUserId(), user.getUsername(), date.getTime()+"", stat);

                    if (j > 0) {
                        return new Result(user, "登录成功，签到成功", 1);
                    }
                } else {
                    return new Result(user, "登录成功，已签到", 1);
                }
            } else {
                int stat = 0;
                Date time = new Date();
                //String time1 = String.valueOf(time.getTime());
                //System.out.println("===================="+time1);
                CheckWork c = checkWorkService.check(user.getUserId());
                //System.out.println("==========ssss==========122321--->" +(1+Integer.parseInt((s))));
                String s = c.getSignin();
                System.out.println("====================122321--->" +(Long.parseLong((s))));
                int x = (int) (time.getTime()-Long.parseLong(s));
                if(x>43200000){
                    int i = checkWorkService.insertCheck(user.getUserId(), user.getUsername(), time.getTime()+"", stat);
                    if(i>0){
                        return new Result(user, "登录成功,迟到了", 1);
                    }else{
                        return new Result(user, "登录成功,你没有签到", 1);
                    }
                }else{
                    return new Result(user,"登录成功，已经签过到了",1);
                }
            }
        }
        return new Result(null, "登录失败", 0);
    }

    //通过工号查询（所有人）
    @RequestMapping(value = {"/home/personal/queryById"},method = RequestMethod.POST)
    @ResponseBody
    public Result  queryById(@RequestBody Map<String,Object> map,HttpServletRequest request){
        //从请求头中传过来userId，通过userId,得到对象中的所有数据，然后前端就不用多写什么，只需要操作的时候
       // 写一些必要数据。其中权限值，是通过userId,得到的，得到以后，再根据业务，判断，是否可以执行此操作。
        //long userId = Long.parseLong(request.getHeader("userId"));
        //System.out.println("-------"+request.getHeader("Content-Type"));
        long userId = Long.parseLong(request.getHeader("Authorization"));
       // User user = userService.queryById(userId1);
        if(userId <= 100000){
            return new Result(null,"查询失败",0);
        }else{
            User user = userService.queryById(userId);
            if(user != null){
                return new Result(user,"查询成功",1);
            }else{
                return new Result(null,"查询失败",0);
            }
        }
    }
    //查询所有（管理员）
    @RequestMapping(value = {"/home/personal/queryAll"},method = RequestMethod.POST)
    @ResponseBody
    public Result queryAll(HttpServletRequest request){
        long userId1 = Long.parseLong(request.getHeader("Authorization"));
        User user = userService.queryById(userId1);
        if(user.getAuthority() == 0){
            return new Result(null,"查询失败",0);
        }else{
            List<User> users = userService.queryAll();
            if(users != null){
                return new Result(users,"查询成功",1);
            }else{
                return new Result(null,"查询失败",0);
            }
        }
    }
    //修改密码,通过电话和工号（所有人）
    @RequestMapping(value = {"/home/personal/updatePassword"},method = RequestMethod.POST)
    @ResponseBody
    public Result updatePassword(@RequestBody Map<String,Object> map,HttpServletRequest request){
        //String password,long userId,long phone
        long userId = Long.parseLong(request.getHeader("Authorization"));
        System.out.println("----------"+userId);
        //User user = userService.queryById(userId);
        int i = userService.updatePassword(map.get("password").toString(),userId,
                Long.valueOf(String.valueOf(map.get("phone"))));
        if(i<=0){
            return new Result("修改失败",0);
        }else{
            return new Result("修改成功",1);
        }
    }
    //删除用户（管理员）
    @RequestMapping(value = {"/home/personal/deleteUser"},method = RequestMethod.POST)
    @ResponseBody
    public Result deleteUser(@RequestBody Map<String,Object> map,HttpServletRequest request){
        long userId1 = Long.parseLong(request.getHeader("Authorization"));
         User user = userService.queryById(userId1);
         if(user.getAuthority() == 0){
             return new Result("删除失败",0);
         }else{
             int i = userService.deleteUser(Long.valueOf(String.valueOf(map.get("userId"))));
             if(i<=0){
                 return new Result("删除失败",0);
             }else{
                 return new Result("删除成功",1);
             }
         }
    }
    //根据用户工号查询工资有关信息（所有人）
    @RequestMapping(value = {"/home/personal/getAllMoney"},method = RequestMethod.POST)
    @ResponseBody
    public Result getAllMoney(@RequestBody Map<String,Object> map,HttpServletRequest request){
        long userId = Long.parseLong(request.getHeader("Authorization"));
       // User user = userService.queryById(userId);
        Integer i = userService.getAllMoney(userId);
        if(i<=0){
            return new Result(null,"查询工资失败",0);
        }else{
            return new Result(i,"查询工资成功",1);
        }
    }
    //添加各项工资（管理员）
//    @RequestMapping(value = {"/home/personal/updatePay"},method = RequestMethod.POST)
//    @ResponseBody
//    public Result updatePay(@RequestBody  Map<String,Object> map,HttpServletRequest request){
//        long userId1 = Long.parseLong(request.getHeader("Authorization"));
//        User user = userService.queryById(userId1);
//        if(user.getAuthority() == 0){
//            return new Result("添加失败",0);
//        }else{
//            int i = userService.updatePay(Long.valueOf(String.valueOf(map.get("userId"))),
//                    Integer.parseInt(map.get("basepay").toString()),
//                    Integer.parseInt(map.get("reward").toString()),
//                    Integer.parseInt(map.get("allowance").toString()));
//            if(i<=0){
//                return new Result("添加失败",0);
//            }else{
//                return new Result("添加成功",1);
//            }
//        }
//    }
    //改变权限 1为管理员，0为普通用户（管理员）
    @RequestMapping(value = {"/home/personal/updateAuthority"},method = RequestMethod.POST)
    @ResponseBody
    public Result updateAuthority(@RequestBody Map<String,Object> map,HttpServletRequest request){
        long userId1 = Long.parseLong(request.getHeader("Authorization"));
        User user = userService.queryById(userId1);
        if(user.getAuthority() == 0){
            return new Result(null,"改变失败",0);
        }else{
            int i = userService.updateAuthority(Long.valueOf(String.valueOf(map.get("userId"))),
                    Integer.parseInt(map.get("authority").toString()));
            if(i<=0){
                return new Result(null,"修改失败",0);
            }else{
                User user1 = userService.queryById(Long.valueOf(String.valueOf(map.get("userId"))));
                return new Result(user1,"修改成功",1);
            }
        }
    }


    /**
     *  //通过工号查询
     *     User queryById(@Param("userId") long userId);
     *     //查询所有
     *     List<User> queryAll();
     *
     *     //修改密码,通过电话和工号
     *     int updatePassword(@Param("password") String password,
     *      @Param("userId") long userId,@Param("phone") long phone);
     *
     *     //删除用户
     *     int deleteUser(@Param("userId") long userId);
     *
     *     //根据工号查询工资的有关情况
     *     Integer getAllMoney(@Param("userId") long userId);
     *
     *     //添加各项工资
     *     int updatePay(@Param("userId") long userId,@Param("basepay")
     *              int basepay,@Param("reward") int reward,@Param("allowance")
     *                  int allowance);
     */

}

