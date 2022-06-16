package cn.itcast.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SysExceptionResolver implements HandlerExceptionResolver {
    /**
     * 处理异常业务逻辑
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param ex
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception ex) {
        //获获取到异常对象
        SysException e=null;
        if(e instanceof SysException){
            e=(SysException) e;
        }
        else
        {
            e=new SysException("系统正在维护...");
            ModelAndView mv= new ModelAndView();
            mv.addObject("errorMsg",e.getMessage());
            mv.setViewName("error");
            return  mv;
        }
        return null;
    }
}
