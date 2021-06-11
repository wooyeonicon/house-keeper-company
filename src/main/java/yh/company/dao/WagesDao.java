package yh.company.dao;

import org.apache.ibatis.annotations.Param;
import yh.company.entity.Wages;

import java.util.List;

public interface WagesDao {
    //添加工资（工资,wuid,time）
    //通过id，查询前几条数据（6个月）
    //通过Id，删除这个人的所有数据
    int insertWages(@Param("wuid") long wuid,@Param("money") double money,@Param("basepay") double basepay,@Param("reward") double reward,@Param("allowance") double allowance,@Param("time") String time);


    List<Wages> queryWagesById(@Param("wuid") long wuid);

}
