package yh.company.dao;

import org.apache.ibatis.annotations.Param;
import yh.company.entity.Mend;

import java.util.List;

public interface MendDao {

    //申请补签
    int insertMend(@Param("userId") long userId,@Param("username") String username,
                   @Param("csignin") String csignin,@Param("cause") String cause);

    //批阅补签
    int updateMend(@Param("witnessId") long witnessId,@Param("witnessName") String witnessName,
                   @Param("mendId") int mendId,@Param("type") int type);
    //通过单号，查询信息
    Mend getMendById(@Param("mendId") int mendId);

    //查看所有同意补签的记录
    List<Mend> queryAllMendSuccess();

    //查看所有没有同意补签的记录
    List<Mend> queryAllNoMend();

    //通过用户id查看所有补签记录
    List<Mend> queryByIdAllMend(@Param("userId") long userId);

    //通过userId和csignin签到时间查看
    List<Mend> queryMendByUserId(@Param("userId") long userId,@Param("csignin") String csignin);
}
