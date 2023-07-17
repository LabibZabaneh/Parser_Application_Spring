package com.progressoft.parserspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

import static com.progressoft.parserspring.utility.ParserUtility.parseData;

@Controller
public class Controllers {

    @GetMapping("/")
    public String hello(){
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(){
        return "upload";
    }

    @PostMapping("/upload")
    public String processUpload(@RequestParam("file") MultipartFile file, Model model){
        ArrayList<Object[]> data = parseData(file);
        model.addAttribute("parsedData", data);
        return "data";
    }

    @PostMapping("/back")
    public String goback(@RequestParam("fileName") String fileName){
        System.out.println(fileName);
        return fileName;
    }

    @PostMapping("/opColumn")
    public String opColumn(@RequestParam("columns") String column, Model model){
        model.addAttribute("result" , 1);
        return "opResult";
    }
}
