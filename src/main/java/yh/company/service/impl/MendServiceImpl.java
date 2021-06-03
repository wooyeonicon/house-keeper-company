package yh.company.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yh.company.dao.MendDao;
import yh.company.entity.Mend;
import yh.company.service.MendService;

import java.util.List;

@Service
public class MendServiceImpl implements MendService {
    @Autowired
    private MendDao mendDao;
    @Override
    public int insertMend(long userId, String username, String csignin, String cause) {
        return mendDao.insertMend(userId,username,csignin,cause);
    }

    @Override
    public int updateMend(long witnessId, String witnessName, int mendId, int type) {
        return mendDao.updateMend(witnessId,witnessName,mendId,type);
    }

    @Override
    public Mend getMendById(int mendId) {
        return mendDao.getMendById(mendId);
    }

    @Override
    public List<Mend> queryAllMendSuccess() {
        return mendDao.queryAllMendSuccess();
    }

    @Override
    public List<Mend> queryAllNoMend() {
        return mendDao.queryAllNoMend();
    }

    @Override
    public List<Mend> queryByIdAllMend(long userId) {
        return mendDao.queryByIdAllMend(userId);
    }

    @Override
    public List<Mend> queryMendByUserId(long userId, String csignin) {
        return mendDao.queryMendByUserId(userId,csignin);
    }
}
