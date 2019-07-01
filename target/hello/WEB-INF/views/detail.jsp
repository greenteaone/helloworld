
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户信息</title>
</head>
<h2>用户信息修改</h2>
<form action="/user/detail" method="post">
    用户名：<input type="text" name="name" value="${user.name}" disabled>
    年龄：<input type="text" name="age" value="${user.age}">

    描述：<input type="text" name="description" value="${user.description}">
    <input type="submit"  value="保存">
</form>
</body>
<script>
    if(${status} == 0){
        alert("修改成功")
        location.href="/home";
    }
</script>
</html>
