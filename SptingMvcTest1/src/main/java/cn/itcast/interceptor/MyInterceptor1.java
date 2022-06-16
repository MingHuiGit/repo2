package cn.itcast.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor1 implements HandlerInterceptor {
    /**
     * 拦截器预处理，控制器方法执行前执行
     * return true 放行，执行下一个拦截器，如果没有，执行Control中的方法
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyInterceptor1拦截器方法执行了。。。。");
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
