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
        List<Login> loginList = loginMapper.login(loginDo);
        List<Login> bind_loginList = null;
        if(loginList.isEmpty()){
            userAdd(loginDo);
        }
        loginList = loginMapper.login(loginDo);
        if(loginList.get(0).getBind_id()!=null) {
            bind_loginList = userInfo(Integer.parseInt(loginList.get(0).getBind_id()));
        }
        if(bind_loginList!=null&&!bind_loginList.isEmpty()){
            loginList.get(0).setBind_username(bind_loginList.get(0).getUsername());
        }

        return loginList;
    }

    @Override
    public void userAdd(Login loginDo) {
        Date date = new Date();
        loginDo.setCreateAt(date);
        int user_id = loginMapper.loginMaxId().isEmpty()?1:loginMapper.loginMaxId().get(0).getId()+1;
        loginDo.setUsername("wechat_user_"+user_id);
        loginDo.setNickname("微信用户"+user_id);
        loginMapper.loginAdd(loginDo);
    }

    @Override
    public List<Login> userInfo(int id) {
        return loginMapper.userInfo(id);
    }

    @Override
    public void updateUserInfo(Login loginDo) {
        loginMapper.updateUserInfo(loginDo);
    }

    @Override
    public boolean updateBindUserInfo(Login loginDot) {
        System.out.println(loginDot.getBind_username());
        if(loginMapper.userInfoByUsername(loginDot.getBind_username()).isEmpty()
                ||loginMapper.userInfoById(loginDot.getId()).isEmpty()){
            return false;
        }
        Login loginDo = new Login();
        Login getLoginDo = loginMapper.userInfoByUsername(loginDot.getBind_username()).get(0);
        loginDo.setBind_username(loginDot.getBind_username());
        loginDo.setBind_id(getLoginDo.getId()+"");
        loginDo.setId(loginDot.getId());
        loginMapper.updateUserInfo(loginDo);


        getLoginDo.setBind_id(loginDot.getId()+"");
        getLoginDo.setBind_username(loginDot.getUsername());
//        loginDo.setId(loginMapper.userInfoByUsername(username).get(0).getId());
        loginMapper.updateUserInfo(getLoginDo);

        return true;
    }
}
