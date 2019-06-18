package com.java.boot.anttalk.handler;

import com.java.boot.anttalk.entity.AntTalk;
import com.java.boot.anttalk.service.talkImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/talk")
public class talkUser {
    @Autowired
    private talkImpl talk;
    @RequestMapping("userone")
    @ResponseBody
    public List<AntTalk> queryTalk(String userid){
        List<AntTalk> antTalks = talk.queryUserOne(userid);
        return antTalks;
    }

    @RequestMapping("/r{pageName}")
    public String gopage(@PathVariable("pageName")String pageName){
        return pageName;
    }

    @RequestMapping("fileupload")
    @ResponseBody
    public String addTalk(@RequestParam("picture") MultipartFile file){

        //判断文件是否存在
        if (file.isEmpty()) {
            return "上传失败";
        }
        //获得文件名
        String filename=file.getOriginalFilename();
        //获得文件大小
        int size= (int) file.getSize();
        //文件地址
        String path = "E:\\picture\\"+"1234";

        File dest = new File(path + "\\" + filename);

        if (!dest.getParentFile().exists()){
            dest.getParentFile().mkdir();
        }
        //写入本地
        try {
            file.transferTo(dest);

        } catch (IOException e) {
            return "上传失败";
        }
        return "上传成功";
    }
}
