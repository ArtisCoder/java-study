package com.wjg.repository;

import com.wjg.entity.UserInfo;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by archerlj on 2017/6/30.
 */
public interface UserInfoRepository extends CrudRepository<UserInfo, Long> {

    UserInfo findByUsername(String username);

    UserInfo save(UserInfo userInfo);
}
