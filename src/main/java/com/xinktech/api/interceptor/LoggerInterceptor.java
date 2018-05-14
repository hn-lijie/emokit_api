package com.xinktech.api.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zhaoy on 2017/7/18.
 */
public class LoggerInterceptor implements HandlerInterceptor {

    private ThreadLocal<Long> beginTime = new ThreadLocal<>();

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        beginTime.set(System.currentTimeMillis());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        Long time = System.currentTimeMillis() - beginTime.get();
        logger.info("\n--- Request finished --- [Host]{}, [url]{}, [response status]{}, [time cost]{} ms.",
                request.getRemoteHost(), request.getRequestURI(), response.getStatus(), time);
    }
}
