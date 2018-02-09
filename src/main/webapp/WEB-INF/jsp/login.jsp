<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Title</title>
</head>
<body>
错误信息：<h4 th:text="${msg}"></h4>
<form action="" method="post">
    <p>账号：<input type="text" name="username" value="admin"/></p>
    <p>密码：<input type="password" name="password" value="admin"/></p>
    <P><input type="checkbox" name="rememberMe" />记住我</P>
    <p><input type="submit" value="登录"/></p>
</form>
</body>
</html>
