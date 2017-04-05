<%--
  Created by IntelliJ IDEA.
  User: lonecloud
  Date: 17/4/5
  Time: 上午7:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>登录界面</title>
    <link href="//cdn.bootcss.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" rel="stylesheet">
    <script src="//cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
    <script src="//cdn.bootcss.com/bootstrap/4.0.0-alpha.5/js/bootstrap.min.js"></script>
</head>

<style>
    .col-center-block {
        float: none;
        display: block;
        margin-left: auto;
        margin-right: auto;
        margin-top: 10%;
    }
</style>
</head>

<body>
<div class="container">
    <div class="row myCenter">
        <div class="col-xs-6 col-md-4 col-center-block">
            <form class="form-signin" method="post" action="${pageContext.request.contextPath}/doLogin">
                <h2 class="form-signin-heading ">请登录${msg}</h2>
                <input type="hidden" name="location" id="location">
                <label for="username" class="sr-only">用户名</label>
                <input type="text" id="username" class="form-control" placeholder="用户名" required autofocus>
                <label for="inputPassword" class="sr-only">密码</label>
                <input type="password" id="inputPassword" class="form-control" placeholder="密码" required>
                <div class="checkbox">
                    <label>
                        <input type="checkbox" value="remember-me">
                        记住我 </label>
                </div>
                <button class="btn btn-lg btn-primary btn-block" type="submit" id="submitForm">登录</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>