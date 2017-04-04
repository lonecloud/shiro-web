<%--
  Created by IntelliJ IDEA.
  User: lonecloud
  Date: 17/4/3
  Time: 下午11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set scope="page" var="ctx" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
    <title>登录界面</title>
</head>
<body>
<p>登录界面</p>
<form action="${ctx}/dologin">
    <input type="text" name="username">
    <input type="password" name="password">
    <button type="submit">登录</button>
</form>
</body>
</html>
