package com.romantic.romanticbackend.service;

import com.romantic.romanticbackend.domain.Login;
import org.springframework.stereotype.Service;

import java.util.List;


public interface LoginService {
    public List<Login> login(Login loginDo);

    public void userAdd(Login loginDo);

    public List<Login> userInfo(int id);

    public void updateUserInfo(Login loginDo);

    public boolean updateBindUserInfo(Login loginDo);
}
