package yh.company.service;

import org.apache.ibatis.annotations.Param;
import yh.company.entity.Vacation;

import java.util.List;

public interface VacationService {

    //请假username,vuid,starttime,endtime,type,cause
    int insertVacation(String username,long vuid,String starttime,
                       String endtime,String type,String cause);

    //批准请假
    int updateState(int vacationId,int state);
    //查看所有请假通过的
    List<Vacation> queryAllPass();
    //查看所有需要请假的
    List<Vacation> queryAllReady();
    //拒绝请假
    int deleteVacation(long vuid);
    //查询
    Vacation queryVacationById(long vuid);

    //通过vuid和starttime查询queryVacationByVuid
    List<Vacation> queryVacationByVuid(long vuid,String starttime);
    List<Vacation> queryVacationByState(long vuid,Integer state);
}
