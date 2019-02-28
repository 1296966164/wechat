<%--
  Created by IntelliJ IDEA.
  User: 10232
  Date: 2019/2/28 0028
  Time: 21:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
    <title>Servlet3.0实现文件上传</title>
</head>

<body>
<fieldset>
    <legend>
        上传单个文件
    </legend>
    <!-- 文件上传时必须要设置表单的enctype="multipart/form-data"-->
    <form action="Service/Upload"
          method="post" enctype="multipart/form-data">
        上传文件：
        <input type="file" name="file">
        <br>
        <input type="submit" value="上传">
    </form>
</fieldset>
<hr />
<fieldset>
    <legend>
        上传多个文件
    </legend>
    <!-- 文件上传时必须要设置表单的enctype="multipart/form-data"-->
    <form action="Service/Upload"
          method="post" enctype="multipart/form-data">
        上传文件：
        <input type="file" name="file1">
        <br>
        上传文件：
        <input type="file" name="file2">
        <br>
        <input type="submit" value="上传">
    </form>
</fieldset>
</body>
</html>