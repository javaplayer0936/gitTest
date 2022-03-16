package com.infosec.txw.springboot_Demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value="/th")
public class demo {
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
