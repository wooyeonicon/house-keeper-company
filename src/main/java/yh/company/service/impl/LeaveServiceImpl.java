package yh.company.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yh.company.dao.LeaveDao;
import yh.company.entity.Leave;
import yh.company.service.LeaveService;

import java.util.List;

@Service
public class LeaveServiceImpl implements LeaveService {
    @Autowired
    private LeaveDao leaveDao;
    public int insertLeave(long userId,String username,int departmentId,String post,
                           String type,String cause){
        return (leaveDao.insertLeave(userId,username,departmentId,post,type,cause));
    }

    @Override
    public int updateLeave(int leaveId, int state) {
        return leaveDao.updateLeave(leaveId,state);
    }

    @Override
    public List<Leave> queryAllLeave() {
        return (leaveDao.queryAllLeave());
    }

    @Override
    public int deleteLeave(long userId) {
        return (leaveDao.deleteLeave(userId));
    }

    @Override
    public int deleteUser(long userId) {
        return (leaveDao.deleteUser(userId));
    }

    @Override
    public List<Leave> queryLeaveByUserId(long userId) {
        return leaveDao.queryLeaveByUserId(userId);
    }

}
