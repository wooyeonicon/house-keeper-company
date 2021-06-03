package yh.company.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yh.company.dao.WagesDao;
import yh.company.entity.Wages;
import yh.company.service.WagesService;

import java.util.List;

@Service
public class WagesServiceImpl implements WagesService {
    @Autowired
    private WagesDao wagesDao;
    @Override
    public int insertWages(long wuid,double money, double basepay,double reward,double allowance, String time) {
        return wagesDao.insertWages(wuid,money,basepay,reward,allowance,time);
    }

    @Override
    public List<Wages> queryWagesById(long wuid) {
        return wagesDao.queryWagesById(wuid);
    }
}
