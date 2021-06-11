package yh.company.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yh.company.dao.TxtDao;
import yh.company.entity.Txt;
import yh.company.service.TxtService;

import java.util.List;

@Service
public class TxtServiceImpl implements TxtService {
    @Autowired
    private TxtDao txtDao;
    @Override
    public int addTxt(long userId, String time, String title, String message, String content) {
        return txtDao.addTxt(userId,time,title,message,content);
    }

    @Override
    public int deleteTxt(long userId) {
        return txtDao.deleteTxt(userId);
    }

    @Override
    public Txt queryTxtById(long txtId) {
        return txtDao.queryTxtById(txtId);
    }

    @Override
    public List<Txt> queryTxtAll() {
        return txtDao.queryTxtAll();
    }
}
