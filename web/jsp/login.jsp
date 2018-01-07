<%--
  Created by IntelliJ IDEA.
  User: zhangzhen
  Date: 2018/1/6
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html"; charset="UTF-8" >
    <title>登陆</title>
</head>
<body>
<fieldset>
    <span style="color: red; ">
        <span id="message">${msg}</span>
    </span>
<form action="${pageContext.request.contextPath}/login.action" method="post">
    用户名:<input type="text" name="username" />
    密&nbsp;&nbsp;&nbsp;码:<input type="text" name="password" />
    <input type="submit" value="登陆" />
</form>
</fieldset>
</body>
</html>
