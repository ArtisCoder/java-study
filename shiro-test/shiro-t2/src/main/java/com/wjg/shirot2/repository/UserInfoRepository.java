package com.wjg.shirot2.repository;

import com.wjg.shirot2.entity.UserInfo;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by archerlj on 2017/6/30.
 */
public interface UserInfoRepository extends CrudRepository<UserInfo, Long> {

    UserInfo findByUsername(String username);

    UserInfo save(UserInfo userInfo);
}
