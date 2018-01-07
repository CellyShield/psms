package com.itheima.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.itheima.service.userService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;
import com.itheima.po.user;
/**
 * 用户控制器类
 */
@Controller
public class userController {
    @Autowired
    private userService userService;
    /**
     * 用户登录
     */
    @RequestMapping(value = "/login.action", method = RequestMethod.POST)
    public String login(String username, String password, Model model, HttpSession session){
        //通过用户名和密码查询用户
        user user = userService.finduser(username,password);
        if(user!=null){
            //将用户对象添加到Session
            session.setAttribute("user_SESSION", user);
            if(user.getPower().equals("主管"))
            {
                return "director";
            }
            else
            {
                return "salesman";
            }
        }
        model.addAttribute("msg", "账号或密码错误，请重新输入!");
        return "login";

    }
    /**
     * 退出登录
     */
    @RequestMapping(value="/logout.action")
    public String logout(HttpSession session){
        //清除Session
        session.invalidate();
        //重定向到登录页面的跳转方法
        return "redirect:login.action";
    }
    /**
     * 向用户登录页面跳转
     */
    @RequestMapping(value = "/login.action", method = RequestMethod.GET)
    public String toLogin(){
        return "login";
    }
}
