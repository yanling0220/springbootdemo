<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Title</title>
</head>
<body>
<form method="POST" enctype="multipart/form-data" action="/batch/upload">
    <p>文件：<input type="file" name="file"/></p>
    <p>文件1：<input type="file" name="file"/></p>
    <p>文件2：<input type="file" name="file"/></p>
    <p><input type="submit" value="上传" /></p>
</form>
</body>
</html>
