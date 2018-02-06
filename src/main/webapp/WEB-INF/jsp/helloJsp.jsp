<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Title</title>
</head>
<body>
helloJsp
<hr/>
<h1 th:text="${hello}"/>
<h2 th:text="${date}"></h2>
<p>这是一段测试文本，区分jsp文件</p>
</body>
</html>
