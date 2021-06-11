package yh.company.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import yh.company.utils.Result;
import yh.company.entity.Leave;
import yh.company.entity.User;
import yh.company.service.LeaveService;
import yh.company.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
public class LeaveController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private LeaveService leaveService;
    @Autowired
    private UserService userService;

    //申请离职（所有人）
    @RequestMapping(value = {"/home/personal/insertLeave"},method = RequestMethod.POST)
    @ResponseBody
    public Result insertLeave(@RequestBody Map<String,Object> map, HttpServletRequest request){
        long userId1 = Long.parseLong(request.getHeader("Authorization"));
        User user = userService.queryById(userId1);
        if(leaveService.queryLeaveByUserId(userId1).isEmpty()){
            int i = leaveService.insertLeave(userId1,user.getUsername(),user.getDepartmentId(),map.get("post").toString(),map.get("type").toString(),map.get("cause").toString());
            if(i<=0){
                return new Result("申请失败1",0);
            }else{
                return new Result("申请成功",1);
            }
        }else{
            return new Result("申请失败2",0);
        }
    }
    //批阅离职(管理员)
    @RequestMapping(value = {"/home/personal/updateLeave"},method = RequestMethod.POST)
    @ResponseBody
    public Result updateLeave(@RequestBody Map<String,Object> map,HttpServletRequest request){
        long userId1 = Long.parseLong(request.getHeader("Authorization"));
        User user = userService.queryById(userId1);
        if(user.getAuthority() == 0){
            return new Result("批阅失败",0);
        }else{
            int i = leaveService.updateLeave(Integer.parseInt(map.get("leaveId").toString()),Integer.parseInt(map.get("state").toString()));
            if(i<=0){
                return new Result("批阅失败",0);
            }else{
                return new Result("批阅成功",1);
            }
           // return new Result("1",1);
        }

    }
    //查询所有离职信息（管理员）
    @RequestMapping(value = {"/home/personal/queryAllLeave"},method = RequestMethod.POST)
    @ResponseBody
    public Result queryAllLeave(HttpServletRequest request){
        long userId1 = Long.parseLong(request.getHeader("Authorization"));
        User user = userService.queryById(userId1);
        if(user.getAuthority() == 0){
            return new Result(null,"查询失败",0);
        }else{
            List<Leave> leaves = leaveService.queryAllLeave();
            if(leaves.isEmpty()){
                return new Result(null,"查询失败",0);
            }else{
                return new Result(leaves,"查询成功",1);
            }
        }
    }


    ////离职申请
    //    int insertLeave(@Param("userId") long userId,@Param("username") String usernaem,
    //                    @Param("departmentId") int departmentId,@Param("post") String post,
    //                    @Param("type") String type,@Param("cause") String cause);

    //     int updateLeave(@Param("userId") long userId,@Param("state") int state);

    // 查询所有离职信息
    //    List<Leave> queryAllLeave();
    //    //拒绝离职
    //    int deleteLeave(@Param("userId") long userId);
    //    //同意离职
    //    int deleteUser(@Param("userId") long userId);
}
