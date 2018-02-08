package com.aceyan.framework.util;

import com.alibaba.fastjson.JSON;
import com.boot.entity.UserInfo;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class PasswordHelper {

    private String algorithmName = "md5";
    private int hashIterations = 2;

    public void encryptPassword(UserInfo user) {
        /*入参规则*/
        String newPassword = new SimpleHash(algorithmName, user.getPassword(), ByteSource.Util.bytes(user.getCredentialsSalt()), hashIterations).toHex();
        user.setPassword(newPassword);

    }

    public static void main(String[] args) {
        PasswordHelper passwordHelper = new PasswordHelper();
        UserInfo user = new UserInfo();
        user.setUid(1L);
        user.setUsername("admin");
        user.setPassword("admin");
        user.setSalt("8d78869f470951332959580424d4bf4f");
        user.setState((byte) 0);
        user.setName("管理员");
        passwordHelper.encryptPassword(user);
        System.out.println(user);
    }
}