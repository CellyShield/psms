package com.itheima.dao;
import com.itheima.po.user;
import org.apache.ibatis.annotations.Param;

/**
 * 用户DAO层接口
 */
public interface userDao {
    /**
     * 通过用户名和密码来查询用户
     */
    public user finduser(@Param("username") String username, @Param("password") String password);
}
