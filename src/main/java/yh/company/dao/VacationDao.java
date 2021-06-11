package yh.company.dao;

import org.apache.ibatis.annotations.Param;
import yh.company.entity.Vacation;

import java.util.List;

public interface VacationDao {
    //请假username,vuid,starttime,endtime,type,cause
    int insertVacation(@Param("username") String username,@Param("vuid") long vuid,
                       @Param("starttime") String starttime,@Param("endtime") String endtime,
                       @Param("type") String type,@Param("cause") String cause);

    //批准请假
    int updateState(@Param("vacationId") int vacationId,@Param("state") int state);
    //查看所有请假通过的
    List<Vacation> queryAllPass();
    //查看所有需要请假的
    List<Vacation> queryAllReady();
    //拒绝请假
    int deleteVacation(@Param("vuid") long vuid);
    //通过id查询请假信息
    Vacation queryVacationById(@Param("vuid") long vuid);
    //通过vuid和请假开始时间查询
    List<Vacation> queryVacationByVuid(@Param("vuid") long vuid,@Param("starttime") String starttime);
    //通过Id和状态（state）查询所有通过请假的时间
    List<Vacation> queryVacationByState(@Param("vuid") long vuid,@Param("state") Integer state);
}
