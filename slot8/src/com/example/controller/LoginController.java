package com.example.controller;

import com.example.entity.Users;
import com.example.model.LoginDaoImpl;

public class LoginController {
    LoginDaoImpl loginDao = new LoginDaoImpl();
    public String loginStatementController(Users user){
        return loginDao.checkLoginStatement(user);
    }
    public String loginPrepareStatementController(Users user){
        return loginDao.checkLoginPrepareStatement(user);
    }
}
