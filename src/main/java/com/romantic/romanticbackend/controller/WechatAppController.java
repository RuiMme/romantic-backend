package com.romantic.romanticbackend.controller;

import com.romantic.romanticbackend.domain.Login;
import com.romantic.romanticbackend.domain.Records;
import com.romantic.romanticbackend.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app/romantic/wechat")
public class WechatAppController {

    @Autowired
    private LoginService loginService;
    @GetMapping("/login")
    public List<Login> login(String openid) {
        Login loginDo = new Login();
        loginDo.setWx_ma_openid(openid);
        return loginService.login(loginDo);
    }

    @GetMapping(value = "/{id}")
    public List<Login> userInfo(@PathVariable("id") int id) {
        return loginService.userInfo(id);
    }

    @PutMapping()
    public String updateUserInfo(@RequestBody Login loginDo) {
        loginService.updateUserInfo(loginDo);
        return "update success";
    }

    @PutMapping("/bindUser")
    public String updateBindUserInfo(@RequestBody Login loginDo){

        if(!loginService.updateBindUserInfo(loginDo)) {
            return "bind error";
        }
        return "bind success";
    }

}
