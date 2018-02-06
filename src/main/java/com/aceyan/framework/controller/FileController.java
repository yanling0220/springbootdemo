package com.aceyan.framework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * 文件处理类
 *
 * @author yanling
 * @time 2018-01-29-16:03
 */
@Controller
public class FileController {

    @RequestMapping("/file")
    public String file(){
        return "/file";
    }

    @RequestMapping("/upload")
    @ResponseBody
    public String uploadFile(@RequestParam("file") MultipartFile file){
        BufferedOutputStream out=null;
        uploadFile(file, out);
        return "上传成功！";
    }

    private void uploadFile(@RequestParam("file") MultipartFile file, BufferedOutputStream out) {
        if (!file.isEmpty()){
              /*
             *这段代码执行完毕之后，图片上传到了工程的跟路径；
             *大家自己扩散下思维，如果我们想把图片上传到 d:/files大家是否能实现呢？
             *等等;
             *这里只是简单一个例子,请自行参考，融入到实际中可能需要大家自己做一些思考，比如：
             * 1、文件路径；
             * 2、文件名；
             * 3、文件格式;
             * 4、文件大小的限制;
             *
             */
            String path = "D:/yanlingTestFile/";
            String fileName = file.getOriginalFilename();
            File loadFile = new File(fileName);
            try {
                /*获得*/
                out = new BufferedOutputStream(new FileOutputStream(path+loadFile));
                out.write(file.getBytes());
                out.flush();
            } catch (Exception e) {
                System.err.println("上传失败 errMsg =  "+e.getMessage());
            }finally {
                if (null != out){
                    try {
                        out.close();
                    } catch (IOException e) {
                        System.err.println("关闭流失败 ， errorMsg = " +e.getMessage());
                    }
                }
            }
        }
    }

    @RequestMapping(value = "/batch/upload" ,method = RequestMethod.POST)
    @ResponseBody
    public String batchUpload(HttpServletRequest request){
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        MultipartFile multipartFile = null;
        BufferedOutputStream out=null;
        for (int i = 0 ; i < files.size();i++){
            multipartFile = files.get(i);
            this.uploadFile(multipartFile,out);
        }
        return "上传成功";
    }


}
