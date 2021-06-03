package yh.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import yh.company.utils.Result;
import yh.company.entity.Files;
import yh.company.service.FilesService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
@CrossOrigin
public class FilesController {
    @Autowired
    private FilesService filesService;



    @RequestMapping(value = {"/home/personal/updateFileName"},method = RequestMethod.POST)
    @ResponseBody
    public Result updateFileName(@RequestParam(value = "file")MultipartFile file, HttpServletRequest request) throws IOException {

        uploadFile(file);
        System.out.println("+++++++++++++++++++++");
        System.out.println(file);
        System.out.println("+++++++++++++++++++++++");
        Files files = new Files();
        files.setFile_name(new String(file.getOriginalFilename().getBytes(),"UTF-8"));
        return new Result("上传成功",1);
    }

    private void uploadFile(MultipartFile file) throws IOException {
        if(file!=null){
            File newFile = new File(new String(file.getOriginalFilename().getBytes(),"UTF-8"));
            file.transferTo(newFile);
        }
    }



}
