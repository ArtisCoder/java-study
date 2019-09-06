package com.wjg.shirot2.conf;

import com.wjg.shirot2.entity.SysPermission;
import com.wjg.shirot2.entity.SysRole;
import com.wjg.shirot2.entity.UserInfo;
import com.wjg.shirot2.service.UserInfoService;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;

/**
 * Created by archerlj on 2017/6/30.
 */


public class MyShiroRealm extends AuthorizingRealm {

    @Resource
    private UserInfoService userInfoService;



    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) {

        System.out.println("开始身份验证");
        String username = (String) token.getPrincipal();

        UserInfo userInfo = userInfoService.findByUsername(username);
//        String passworaaa= new Md5Hash("123456",userInfo.getCredentialsSalt(),2).toHex();
//        System.out.println(passworaaa);

        if (userInfo == null) {
            //没有返回登录用户名对应的SimpleAuthenticationInfo对象时,就会在LoginController中抛出UnknownAccountException异常
            return null;
        }

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                userInfo, //用户信息
                userInfo.getPassword(), //密码
                getName() //realm name
        );
        authenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(userInfo.getCredentialsSalt())); //设置盐

        return authenticationInfo;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        System.out.println("开始权限配置");

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        UserInfo userInfo = (UserInfo) principals.getPrimaryPrincipal();

        for (SysRole role: userInfo.getRoleList()) {
            authorizationInfo.addRole(role.getRole());
            for (SysPermission p: role.getPermissions()) {
                authorizationInfo.addStringPermission(p.getPermission());
            }
        }

        return authorizationInfo;
    }
}
