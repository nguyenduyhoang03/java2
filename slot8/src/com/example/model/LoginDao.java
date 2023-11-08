package com.example.model;

import com.example.entity.Users;

public interface LoginDao {
    public String checkLoginStatement(Users user);
    public String checkLoginPrepareStatement(Users user);
}
