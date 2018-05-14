package com.xinktech.api.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xinktech.api.commom.ApiResult;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by zhaoy on 2017/7/18.
 */
public class UserAuthorizationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURL().toString();
        String origin=request.getHeader("Origin") == null ? "*" : request.getHeader("Origin");
        HttpSession session = request.getSession();
        response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, origin.substring(0,origin.length()));
        response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS, "true");
        response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, "Origin, X-Requested-With, Content-Type, Accept, If-Modified-Since");
        response.setHeader(HttpHeaders.CONTENT_TYPE, "application/json;charset=UTF-8");
        response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, "GET, POST, OPTIONS, PUT, DELETE");

        //api/开头的url请求均要走session控制
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}