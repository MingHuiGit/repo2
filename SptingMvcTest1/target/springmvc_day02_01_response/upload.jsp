<%--
  Created by IntelliJ IDEA.
  User: li
  Date: 2022/5/4
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传 </title>
</head>
<body>
<h3>传统文件上传</h3>
<form action="file/FileUpload1" method="post" enctype="multipart/form-data">
    选择文件:<input type="file"  name="upload"><br/>
    <input type="submit"value="上传">
</form>

<h3>mvc文件上传</h3>
<form action="file/FileUpload2" method="post" enctype="multipart/form-data">
    选择文件:<input type="file"  name="upload"><br/>
    <input type="submit"value="上传">
</form>
</body>
</html>
