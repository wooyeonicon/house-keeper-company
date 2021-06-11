package yh.company.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import yh.company.utils.Result;
import yh.company.entity.Txt;
import yh.company.service.TxtService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
public class TxtController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TxtService txtService;
    //添加文章（所有人）
    @RequestMapping(value = {"/home/personal/addTxt"},method = RequestMethod.POST)
    @ResponseBody
    public Result addTxt(@RequestBody Map<String,Object> map,HttpServletRequest request){
        long userId = Long.parseLong(request.getHeader("Authorization"));
        int i = txtService.addTxt(userId, map.get("time").toString(),map.get("title").toString(),
                map.get("message").toString(),map.get("content").toString());
        if(i<=0){
            return new Result("添加失败",0);
        }else{
            return new Result("添加成功",1);
        }
    }
    //删除文章
    @RequestMapping(value = {"/home/personal/deleteTxt"},method = RequestMethod.POST)
    @ResponseBody
    public Result deleteTxt(@RequestBody Map<String,Object> map, HttpServletRequest request){
        long userId = Long.parseLong(request.getHeader("Authorization"));
        if(userId == Long.valueOf(String.valueOf(map.get("idCard")))){
            int i = txtService.deleteTxt(userId);
            if(i>0){
                return new Result("删除成功",1);
            }else{
                return new Result("删除失败",0);
            }
        }else{
            return new Result("删除失败",0);
        }
    }
    //查看文章（所有人）
    @RequestMapping(value = {"/home/personal/queryTxtById"},method = RequestMethod.POST)
    @ResponseBody
    public Result queryById(@RequestBody Map<String,Object> map,HttpServletRequest request){
        long userId = Long.parseLong(request.getHeader("Authorization"));
        long txtId = Long.valueOf(String.valueOf(map.get("txtId")));
        Txt txt = txtService.queryTxtById(txtId);
        if(txt == null){
            return new Result(null,"查看失败",0);
        }else{
            return new Result(txt,"查看成功",1);
        }
    }
    //查看所有文章
    @RequestMapping(value = {"/home/personal/queryTxtAll"},method = RequestMethod.POST)
    @ResponseBody
    public Result queryTxtAll(HttpServletRequest request){
        //long userId = Long.parseLong(request.getHeader("Authorization"));
        List<Txt> lists = txtService.queryTxtAll();
        if(lists.isEmpty()){
            return new Result(null,"查看失败",0);
        }else{
            return new Result(lists,"查看成功",1);
        }
    }
}
