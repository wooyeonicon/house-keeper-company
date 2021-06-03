package yh.company.service;

import yh.company.entity.Txt;

import java.util.List;

public interface TxtService {
    //添加
    int addTxt(long userId,String time,String title,String message,String content);

    //删除
    int deleteTxt(long userId);

    //查看
    Txt queryTxtById(long txtId);

    List<Txt> queryTxtAll();
}
