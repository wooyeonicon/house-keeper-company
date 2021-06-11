package yh.company.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yh.company.dao.VacationDao;
import yh.company.entity.Vacation;
import yh.company.service.VacationService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class VacationServiceImpl implements VacationService {

    @Autowired
    private VacationDao vacationDao;
    @Override
    public int insertVacation(String username, long vuid, String starttime, String endtime, String type, String cause) {
        return (vacationDao.insertVacation(username,vuid,starttime,endtime,type,cause));
    }

    @Override
    public int updateState(int vacationId,int state) {
        return (vacationDao.updateState(vacationId,state));
    }

    @Override
    public List<Vacation> queryAllPass() {
        return vacationDao.queryAllPass();
    }

    @Override
    public List<Vacation> queryAllReady() {
        return vacationDao.queryAllReady();
    }

    @Override
    public int deleteVacation(long vuid) {
        return (vacationDao.deleteVacation(vuid));
    }

    public Vacation queryVacationById(long vuid){
        return (vacationDao.queryVacationById(vuid));
    }
//queryVacationByVuid
    @Override
    public List<Vacation> queryVacationByVuid(long vuid, String starttime) {
        return vacationDao.queryVacationByVuid(vuid,starttime);
    }

    @Override
    public List<Vacation> queryVacationByState(long vuid, Integer state) {
        return vacationDao.queryVacationByState(vuid,state);
    }
}
