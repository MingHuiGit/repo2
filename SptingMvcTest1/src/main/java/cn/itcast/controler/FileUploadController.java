package cn.itcast.controler;

import cn.itcast.exception.SysException;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
public class FileUploadController {
    @RequestMapping("file/FileUpload1")
    public  String FileUpload(HttpServletRequest request) throws Exception {
        System.out.println("文件上传");
        //使用fileupload组件完成文件上传
        String realPath = request.getSession().getServletContext().getRealPath("/uploads/");
        //判断路径是否存在
        File file=new File(realPath);
        if(!file.exists())
        {
            file.mkdirs();
        }
        //解析request获取上传文件
        DiskFileItemFactory factory=new DiskFileItemFactory();
        ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
        //解析request
        List<FileItem> fileItems = servletFileUpload.parseRequest(request);
        //遍历
        for (FileItem fileItem : fileItems) {
            if(fileItem.isFormField())
            {
                //说明普通表单项
            }
            else
            {
                //说明上传文件项
                //获取文件名称
                String fieldName = fileItem.getName();
                //完成文件上传
                fileItem.write(new File(realPath,fieldName));
                //删除临时文件
                fileItem.delete();
            }
        }
        return "success";
    }

    @RequestMapping("file/FileUpload2")
    public  String FileUpload2(HttpServletRequest request, MultipartFile upload) throws Exception {
        System.out.println("文件上传");
        //使用fileupload组件完成文件上传
        String realPath = request.getSession().getServletContext().getRealPath("/uploads/");
        //判断路径是否存在
        File file = new File(realPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        String originalFilename = upload.getOriginalFilename();
        //说明上传文件项

        //完成文件上传
        upload.transferTo(new File(realPath, originalFilename));
        return "success";
    }
    /*跨服务器上传*/
    @RequestMapping("file/FileUpload3")
    public  String FileUpload3(MultipartFile upload) throws Exception {
        System.out.println("跨服务器文件上传");
        String path="localhost:9090/uploads/";
        //设置文件名
        String filename=upload.getOriginalFilename();
        //文件的名称设置唯一值
        String uuid= UUID.randomUUID().toString().replace("-","");
        filename=uuid+"_"+filename;
        //创建客户端的对象
        Client client = Client.create();
        //和图片服务器进行链接
         WebResource webResource= client.resource(path+filename);
         //文件上传
        webResource.put(upload.getBytes());
        return "success";
    }
    @RequestMapping("test/ExcepTest1")
     public  String ExcepTest1() throws SysException
    {
        System.out.println("异常处理");
        try
        {
            int a=10/0;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            //抛出自定义异常信息
            throw new SysException("查询所有用户异常");
        }

        return "success";
    }
}
