package yh.company.dao;

import org.apache.ibatis.annotations.Param;
import yh.company.entity.Leave;

import java.util.List;

public interface LeaveDao {
    //离职申请
    int insertLeave(@Param("userId") long userId,@Param("username") String username,
                    @Param("departmentId") int departmentId,@Param("post") String post,
                    @Param("type") String type,@Param("cause") String cause);
    //批阅离职
    int updateLeave(@Param("leaveId") int leaveId,@Param("state") int state);


    //查询所有离职信息
    List<Leave> queryAllLeave();
    //拒绝离职
    int deleteLeave(@Param("userId") long userId);
    //同意离职
    int deleteUser(@Param("userId") long userId);

    //通过userId查询
    List<Leave> queryLeaveByUserId(@Param("userId") long userId);

}
