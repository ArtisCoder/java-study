package com.wjg.shirot2.service;


import com.wjg.entity.UserInfo;

/**
 * Created by archerlj on 2017/6/30.
 */
public interface UserInfoService {

    UserInfo findByUsername(String username);
}
