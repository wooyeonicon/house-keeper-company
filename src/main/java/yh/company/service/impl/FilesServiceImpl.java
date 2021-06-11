package yh.company.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yh.company.dao.FilesDao;
import yh.company.service.FilesService;

@Service
public class FilesServiceImpl implements FilesService {

    @Autowired
    private FilesDao filesDao;

    @Override
    public int updateFileName(long fuid, String file_name) {
        return filesDao.updateFileName(fuid,file_name);
    }
}
