package yh.company.service;

import org.apache.ibatis.annotations.Param;
import yh.company.entity.CheckWork;

import java.util.List;

public interface CheckWorkService {
//    private long checkworkId;
//    private long cuid;
//    private String username;
//    private String signin;
//    private String signout;
//    private Date date;
    CheckWork selectMax();
    //签退
    int insertSignout(long cuid,String signin,String signout);
    //签到
    int insertCheck(long cuid,String username,String signin,int stat);
    //统计一个用户的所有签到情况
    List<CheckWork> findById(long cuid);

    //改变签到状态
    int updateType(String signin,long cuid);

    //得到签到表
    CheckWork getCheckType(String signin,long cuid);

    //签退
    int updateOut(String signout,long cuid,String signin);

    CheckWork check(long cuid);

//    统计所有用户同一天签到情况
//    List<CheckWork> findAllByDay(String date);
//
//    删除上一个月所有的签到
//    int deleteCheck(String date);
}
