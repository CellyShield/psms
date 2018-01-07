package com.itheima.service.impl;
import com.itheima.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.itheima.dao.userDao;
import com.itheima.po.user;
/**
 * 用户Service接口实现类
 */
@Service("userService")
@Transactional
public class userServiceImpl implements userService {
    @Autowired
    private userDao userDao;
    //通过用户名和密码查询用户
    @Override
    public user finduser(String username,String password){
        user user = this.userDao.finduser(username,password);
        return user;
    }
}
