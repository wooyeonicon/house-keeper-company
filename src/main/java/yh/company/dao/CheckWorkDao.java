package yh.company.dao;

import org.apache.ibatis.annotations.Param;
import yh.company.entity.CheckWork;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public interface CheckWorkDao {
    //签到
    // private long checkworkId;
    //    private long cuid;
    //    private String username;
    //    private Time signin;
    //    private Time signout;
    //    private Date date;
    CheckWork selectMax();

    int insertSignout(@Param("cuid") long cuid,@Param("signin") String signin,@Param("signout") String signout);

    CheckWork check(@Param("cuid") long cuid);

    //签到 默认为1，签上
    int insertCheck(@Param("cuid") long cuid, @Param("username") String username,
                    @Param("signin") String signin,@Param("stat") int stat);
    //统计一个用户的所有签到情况
    List<CheckWork> findById(@Param("cuid") long cuid);

    //改变签到状态（如果没签到成功，补签，需要改变类型为2，2为补签）
    //在补签成功后，自动改变
    int updateType(@Param("signin") String signin,@Param("cuid") long cuid);

    //得到签到表
    CheckWork getCheckType(@Param("signin") String signin,@Param("cuid") long cuid);

    //得到签到表订单号
    //int getId(@Param("cuid") long cuid,@Param("signin") String signin);

    //签退
    int updateOut(@Param("signout") String signout,@Param("cuid") long cuid,@Param("signin") String signin);


    //统计所有用户同一天签到情况
    //List<CheckWork> findAllByDay(@Param("date") String date);

    //删除上一个月所有的签到
   // int deleteCheck(@Param("date") String date);

}
