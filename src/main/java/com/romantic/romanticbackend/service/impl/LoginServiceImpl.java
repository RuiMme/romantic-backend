package com.romantic.romanticbackend.service.impl;

import com.romantic.romanticbackend.domain.Login;
import com.romantic.romanticbackend.mapper.LoginMapper;
import com.romantic.romanticbackend.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public List<Login> login(Login loginDo) {
//        System.out.println(loginMapper.login(loginDo));
        if(loginMapper.login(loginDo).isEmpty()){
            userAdd(loginDo);
        }
        return loginMapper.login(loginDo);
    }

    @Override
    public void userAdd(Login loginDo) {
        Date date = new Date();
        loginDo.setCreateAt(date);
        loginDo.setUsername("wechat_user_"+(loginMapper.loginMaxId().get(0).getId()+1));
        loginDo.setNickname("微信用户"+(loginMapper.loginMaxId().get(0).getId()+1));
        loginMapper.loginAdd(loginDo);
    }

    @Override
    public List<Login> userInfo(int id) {
        return loginMapper.userInfo(id);
    }
}
