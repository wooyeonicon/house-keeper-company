package yh.company.service;

import yh.company.entity.Wages;

import java.util.List;

public interface WagesService {
    //添加
    int insertWages(long wuid,double money,double basepay,double reward,double allowance,String time);

    List<Wages> queryWagesById(long wuid);
}
