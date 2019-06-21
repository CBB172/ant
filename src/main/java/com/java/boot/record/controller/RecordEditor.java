package com.java.boot.record.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: Summer
 * @Date: 2019/6/21 14:45
 * @Description: No Description
 */
@RequestMapping("/record")
@Controller
public class RecordEditor {


    @RequestMapping("recordEditor")
    public String recordEditor(Model model){

        return "common/TextEditor::editor";
    }
}
