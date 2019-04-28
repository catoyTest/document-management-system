package top.catoy.docmanagement.controller;


import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import top.catoy.docmanagement.domain.ResponseBean;

import java.io.File;

@RestController
public class FileController {

    @Value("${com.sxito.custom.windows-path}")
    private String windowsuploadPath;

    @Value("${com.sxito.custom.linux-path}")
    private String linuxuploadPath;

    @RequestMapping(value = "/uploadFile",method = RequestMethod.POST)
    public ResponseBean uploadFile(@Param("file")MultipartFile file) {

        String upload = null;
        if(System.getProperty("os.name").equals("Windows 10")){
            upload = windowsuploadPath;

        }else if (System.getProperty("os.name").equals("Linux")){
            upload = linuxuploadPath;
        }
        System.out.println(System.getProperty("os.name"));
        System.out.println(upload+file.getOriginalFilename());
        return null;
    }
}
