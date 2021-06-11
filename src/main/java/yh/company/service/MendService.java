package yh.company.service;

import org.apache.ibatis.annotations.Param;
import yh.company.entity.Mend;

import java.util.List;

public interface MendService {

    //申请补签
    int insertMend(long userId, String username, String csignin,String cause);

    //批阅补签
    int updateMend(long witnessId,String witnessName, int mendId,int type);

    //通过单号，查询信息
    Mend getMendById(int mendId);

    //查看所有同意补签的记录
    List<Mend> queryAllMendSuccess();

    //查看所有没有同意补签的记录
    List<Mend> queryAllNoMend();

    //通过用户id查看所有补签记录
    List<Mend> queryByIdAllMend(long userId);

    //通过userId和签到时间查询
    List<Mend> queryMendByUserId(long userId,String csignin);
}
