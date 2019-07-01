<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/28 0028
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<h2>登录</h2>
<form action="/user/login" method="post">
    用户名：<input type="text" name="name">
    密码：<input type="password" name="password">
    <input type="submit"  value="登录">
    <a href="/user/register">注册</a>
</form>
</body>
<script>
    if(${status} == 0){
        alert("登录成功");
        location.href="/home";
    }else{
        alert("登录失败，用户名或密码错误");
    }
</script>
</html>
