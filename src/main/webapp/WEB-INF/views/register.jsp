
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>用户注册</h2>
<form action="/user/register" method="post">
    用户名：<input type="text" name="name">
    密码：<input type="password" name="password">
    年龄：<input type="text" name="age">

    描述：<input type="text" name="description">
    <input type="submit"  value="保存">
</form>
</body>
<script>
        if(${status} == 0){
            alert("注册成功")
            location.href="/";
    }
</script>
</html>
