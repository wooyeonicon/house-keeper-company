package yh.company.dao;

import org.apache.ibatis.annotations.Param;
import yh.company.entity.Txt;

import java.util.List;

public interface TxtDao {
    //添加文章
    int addTxt(@Param("userId") long userId,@Param("time") String time,
               @Param("title") String title,@Param("message") String message,
               @Param("content") String content);
    int deleteTxt(@Param("userId") long userId);

    Txt queryTxtById(@Param("txtId") long txtId);

    List<Txt> queryTxtAll();
}
