package com.itheima.service;
import com.itheima.po.user;
/**
 * 用户Service层接口
 */
public interface userService {
    //通过用户名和密码查询用户
    public user finduser(String username,String password);
}
