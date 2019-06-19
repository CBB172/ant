package com.java.boot.util.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: Summer
 * @Date: 2019/6/18 19:52
 * @Description: No Description
 */
@RequestMapping("/common")
@Controller
public class TextEditor {

    @RequestMapping("texteditor")
    public String textEditor(){
        return "common/TextEditor::editor";
    }
}
