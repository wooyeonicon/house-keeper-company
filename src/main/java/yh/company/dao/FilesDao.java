package yh.company.dao;

import org.apache.ibatis.annotations.Param;

public interface FilesDao {

    int updateFileName(@Param("fuid") long fuid,@Param("file_name") String file_name);


}
