package top.catoy.docmanagement.controller;


import jdk.nashorn.internal.ir.ReturnNode;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import top.catoy.docmanagement.domain.ResponseBean;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@RestController
public class FileController {

    @Value("${com.sxito.custom.windows-path}")
    private String windowsuploadPath;

    @Value("${com.sxito.custom.linux-path}")
    private String linuxuploadPath;


    /***
     * 单文件上传
     * @param file
     * @return
     */
    @RequestMapping(value = "/uploadFile",method = RequestMethod.POST)
    public ResponseBean uploadFile(@Param("file")MultipartFile file) {
        String upload = null;
        if(System.getProperty("os.name").equals("Windows 10")){
            upload = windowsuploadPath;
        }else if (System.getProperty("os.name").equals("Linux")){
            upload = linuxuploadPath;
        }
        if(Objects.isNull(file) || file.isEmpty()){
            return new ResponseBean(ResponseBean.FAILURE,"文件为空,请重新上传",null);
        }
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(upload+file.getOriginalFilename());
            if(!Files.isWritable(path)){
                Files.createDirectories(Paths.get(upload));
            }
            Files.write(path,bytes);
            return new ResponseBean(ResponseBean.SUCCESS,"上传成功",null);
        }catch (Exception e) {
            return new ResponseBean(ResponseBean.FAILURE,"上传失败",null);
        }
    }


    /***
     *
     * @return
     */
    @RequestMapping(value = "/downLoadFile",method = RequestMethod.POST)
    public ResponseBean downLoadFife(){
        return null;
    }



}
