package com.itheima.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.itheima.po.user;
/**
 * 登陆拦截器
 */
public class LoginInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取请求的URL
        String url = request.getRequestURI();
        //URL:除了登录请求外，其他的URL都进行拦截控制
        if(url.indexOf("/login.action") >=0){
            return true;
        }
        //获取Session
        HttpSession session = request.getSession();
        user user = (user) session.getAttribute("user_SESSION");
        if(user != null){
            return true;
        }
        request.setAttribute("msg","您还没有登录，请先登录!");
        request.getRequestDispatcher("/jsp/login.jsp").forward(request,response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
