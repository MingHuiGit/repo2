package cn.itcast.controler;

import cn.itcast.domain.paramodel;
import cn.itcast.domain.User;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;

@Controller
public class HelloController {
    @RequestMapping(path = "/control/hello")
    public  String sayHello(String username)
    {
        System.out.println("45");

        return "success";
    }
    @RequestMapping(path = "control/para")
    public String paraMethod(paramodel para)
    {
        System.out.println("SessionAttr");

        return "success";
    }
    @RequestMapping(value = "testSessionAttributes")
    public String testSessionAttributes(Model model)
    {
        System.out.println("testSessionAttributes");
        model.addAttribute("msg","美美");
        return "success";
    }
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        System.out.println("testVoid方法执行了....");
        String age = request.getParameter("username");
        System.out.println(age);
        /*编写转发的程序*/
      /*  request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);*/
        /*重定向*/
        response.sendRedirect(request.getContextPath()+"/user.jsp");
/*        *//*设置中文乱码*//*
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print("你好");*/
        return;
    }
    /**
     * 模拟异步请求响应
     */
    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user){
        System.out.println("testAjax方法执行了...");
        // 客户端发送ajax的请求，传的是json字符串，后端把json字符串封装到user对象中
        System.out.println(user);
        // 做响应，模拟查询数据库
        user.setUsername("haha");
        user.setAge(40);
        // 做响应
        return user;
    }




}
