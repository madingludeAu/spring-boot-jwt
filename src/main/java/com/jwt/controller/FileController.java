package com.jwt.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@RestController
@RequestMapping("/file")

public class FileController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());


    //服务器文件存放路径
    private String filepath = "D:/file/";


    /**
     * 处理文件上传
     */
    @PostMapping(value = "/upload")
    public String uploading(@RequestParam("file") MultipartFile file) {
        //文件流，filepath为服务器磁盘地址（如果再自己电脑运行此程序  服务器就是本机）
        File targetFile = new File(filepath);
        //exists()方法 判断filepath目录是否存在
        if (!targetFile.exists()) {
            // 不存在 则创建目录 mkdirs() 创建目录
            targetFile.mkdirs();
        }
        try {
            //文件输出流  目的：将从内存文件输出到系统磁盘中
            FileOutputStream out = new FileOutputStream(filepath + file.getOriginalFilename());
            //写入磁盘
            out.write(file.getBytes());
            //开发工作中 在将文件写入磁盘后 同时将文件名称记录进数据库中（目的： 在文件下载的时候 文件名称就可以作为变量存在，同时 也做文件的回显）
            // 自己写一下啊
        } catch (Exception e) {
            e.printStackTrace();
            log.error("文件上传失败!");
            return "uploading failure";
        }
        log.info("文件上传成功!");
        return "uploading success";
    }

    @RequestMapping("/download")
    public void downLoad(HttpServletResponse response) throws Exception {
        //开发工作中 filename 一般是从数据库获取
        String filename="长城用户.txt";

        File file = new File(filepath + "/" + filename);
        //判断文件是否存在
        if(file.exists()){
            //设置响应类型与响应头 （目的：返回流到请求中，提供用户下载） （一般格式是固定的，不必纠结为啥这样写）
            response.setContentType("application/octet-stream");
            response.setHeader("content-type", "application/octet-stream");
            response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(filename,"utf8"));
            byte[] buffer = new byte[1024];
            //输出流
            OutputStream os = null;
            try{
                //输入流 ： 根据file（里的filepath+filename） 讲文件从磁盘中获取到
                FileInputStream fis= new FileInputStream(file);
                BufferedInputStream bis = new BufferedInputStream(fis);
                os = response.getOutputStream();
                int i = bis.read(buffer);
                //循环读取文件内容并写入
                while(i != -1){
                    os.write(buffer);
                    i = bis.read(buffer);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            response.setContentType("text/html;charset=utf-8");

            response.getWriter().print("file not find");
        }
    }

/**
 * 涉及内容：File  FileOutputStream  OutputStream FileInputStream BufferedInputStream   皆由jdk下内置jar包： java.io包下提供 无须引入新jar包  相关知识自行百度
 */

}
