package com.romantic.romanticbackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/romatic/wechat")
public class WechatAppController {

    @GetMapping("/maLogin")
    public String maLogin(String appid, String code) {
        if(code.isEmpty()){
            return "error";
        }


        return null;
    }
}
