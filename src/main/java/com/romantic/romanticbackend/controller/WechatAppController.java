package com.romantic.romanticbackend.controller;

import com.romantic.romanticbackend.domain.Login;
import com.romantic.romanticbackend.domain.Records;
import com.romantic.romanticbackend.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
