package yh.company.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yh.company.dao.CheckWorkDao;
import yh.company.entity.CheckWork;
import yh.company.service.CheckWorkService;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
@Service
public class CheckWorkServiceImpl implements CheckWorkService {
    @Autowired
    private CheckWorkDao checkWorkDao;
    @Override
    public int insertCheck(long cuid, String username, String signin,int stat) {

        return (checkWorkDao.insertCheck(cuid,username,signin,stat));
    }

    @Override
    public CheckWork check(long cuid) {
        return (checkWorkDao.check(cuid));
    }

    @Override
    public List<CheckWork> findById(long cuid) {
        return (checkWorkDao.findById(cuid));
    }

    @Override
    public int updateType(String signin,long cuid) {
        return checkWorkDao.updateType(signin,cuid);
    }

//    @Override
//    public int getId(long cuid, String signin) {
//        return checkWorkDao.getId(cuid,signin);
//    }

    @Override
    public int updateOut(String signout, long cuid,String signin) {
        return checkWorkDao.updateOut(signout,cuid,signin);
    }

    @Override
    public CheckWork getCheckType(String signin, long cuid) {
        return checkWorkDao.getCheckType(signin,cuid);
    }

    //    @Override
//    public List<CheckWork> findAllByDay(String date) {
//        return (checkWorkDao.findAllByDay(date));
//    }
//
//    @Override
//    public int deleteCheck(String date) {
//        return (checkWorkDao.deleteCheck(date));
//    }
}
