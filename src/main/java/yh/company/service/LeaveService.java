package yh.company.service;

import org.apache.ibatis.annotations.Param;
import yh.company.entity.Leave;

import java.util.List;

public interface LeaveService {
    //@Param("userId") long userId,@Param("username") String usernaem,
    //                    @Param("departmentId") int departmentId,@Param("post") String post,
    //                    @Param("type") String type,@Param("cause") String cause
    int insertLeave(long userId,String username,int departmentId,String post,
                    String type,String cause);
    List<Leave> queryAllLeave();
    //批阅请假
    int updateLeave(int leaveId, int state);

    //拒绝离职
    int deleteLeave(@Param("userId") long userId);
    //同意离职
    int deleteUser(@Param("userId") long userId);
    //通过userId查询
    List<Leave> queryLeaveByUserId(long userId);

}
