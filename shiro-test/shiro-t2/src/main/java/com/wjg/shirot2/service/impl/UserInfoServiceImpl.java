package com.wjg.shirot2.service.impl;

import com.wjg.entity.UserInfo;
import com.wjg.repository.UserInfoRepository;
import com.wjg.shirot2.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by archerlj on 2017/6/30.
 */

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoRepository userInfoRepository;

    @Override
    public UserInfo findByUsername(String username) {

        System.out.println("UserInfoServiceImpl.findByUsername");
        return userInfoRepository.findByUsername(username);
    }
}
