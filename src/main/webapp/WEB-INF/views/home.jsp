
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>主页</title>
    <script src="/js/jquery-3.3.1.js"></script>
</head>
<body>
<script>
    function deleteUser() {
        if(confirm("用户一旦删除需要重新注册，确定删除用户？")){
            jQuery.ajax({url:"/user/delete",async:false,type:"DELETE",
            success:function (restult) {
                if(restult == 1){
                    alert("用户注销成功");
                    location.href="/user/login";
                }else{
                    alert("用户注销失败");
                }
            }
            });
        }
    }
</script>
<p style="margin-top:100px;text-align: center">欢迎<span style="font-weight: bolder">${user.name}</span>登录</p>
<a href="/user/detail">修改个人信息</a>
<a href="/user/logout">退出</a>
<a href="JavaScript:void(0)" onclick="deleteUser()">注销</a>
</body>
<script>

</script>
</html>
