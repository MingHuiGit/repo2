<%--
  Created by IntelliJ IDEA.
  User: li
  Date: 2022/4/30
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>入门程序</title>
    <script src="js/jquery.min.js"></script>
    <script>
        // 页面加载，绑定单击事件
        $(function(){
            $("#btn").click(function(){
                // alert("hello btn");
                // 发送ajax请求
                $.ajax({
                    // 编写json格式，设置属性和值
                    url:"testVoid",
                    contentType:"application/json;charset=UTF-8",
                    data:'{"username":"hehe","password":"123","age":30}',
                    dataType:"json",
                    type:"post",
                    success:function(data){
                        // data服务器端响应的json的数据，进行解析
                        alert(data);
                        alert(data.username);
                        alert(data.password);
                        alert(data.age);
                    }
                });

            });
        });

    </script>
</head>
<body>
<h1>首页面</h1>
<a href="control/hello/username=heh">入门程序</a>
<a href="control/hello/username=heh">实体参数</a>
<a href="testSessionAttributes">testSessionAttributes</a>
<a href="testVoid">testVoid</a>
<button id="btn">发送ajax的请求</button>
</body>

</html>
