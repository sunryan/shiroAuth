package com.ryan.shiroauth;

import org.apache.shiro.crypto.hash.SimpleHash;

/**
 *
 * 加密密码
 * @author lr
 * @date 2018/1/25
 */
public class HashedCredentialsMatcherTest {
    
    public static void main(String[] args) {
        String hashAlgorithmName = "md5";
        String credentials = "admin";
        String salt = "8d78869f470951332959580424d4bf4f";
        int hashIterations = 2;
        Object obj = new SimpleHash(hashAlgorithmName, credentials, credentials + salt, hashIterations);
        System.out.println(obj);
    }
}
