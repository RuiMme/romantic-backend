package com.romantic.romanticbackend.mapper;

import com.romantic.romanticbackend.domain.Login;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LoginMapper {
    public List<Login> login(Login loginDo);

    public List<Login> loginMaxId();

    public void loginAdd(Login loginDo);

    public List<Login> userInfo(int id);

    public void updateUserInfo(Login loginDo);

    public List<Login> userInfoByUsername(String username);

    public List<Login> userInfoById(int id);
}
