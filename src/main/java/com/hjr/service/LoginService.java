package com.hjr.service;

import com.hjr.domain.ResponseResult;
import com.hjr.domain.User;

public interface LoginService {

    ResponseResult login(User user);

    ResponseResult logout();
}
