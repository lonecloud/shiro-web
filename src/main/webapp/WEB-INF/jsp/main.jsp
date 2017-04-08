<%--
  Created by IntelliJ IDEA.
  User: lonecloud
  Date: 17/4/6
  Time: 上午7:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set value="${pageContext.request.contextPath}" var="ctx"/>
<html>
<head>
    <title>主页面</title>
</head>
<body>
我的主页面 <br>
<shiro:user><%--经过验证和记住我的用户--%>
    欢迎您:【<shiro:principal/>】进入本系统!<br>
</shiro:user>
<shiro:authenticated><%--经过验证和(不是记住我登录)--%>
    欢迎您:【<shiro:principal/>】进入本系统!<br>
</shiro:authenticated>
<shiro:notAuthenticated><%--未经过验证和(包括记住我登录)--%>
    未通过验证,包括记住我登录
</shiro:notAuthenticated>
<%--<shiro:principal property="username">--%>
<%--SimpleAuthenticationInfo(可以放入user对象)的username属性--%>
<%--</shiro:principal>--%>
<%--有权限的话--%>
<shiro:hasRole name="admin">
    <a href="${ctx}/admin">管理员页面</a><br>
</shiro:hasRole>
<%--没有权限的话--%>
<shiro:lacksRole name="admin">
    <a href="${ctx}/user">用户页面</a><br>
</shiro:lacksRole>
<a href="${ctx}/testShiro">测试session同步页面</a><br>

<a href="${ctx}/logout">登出</a><br>
</body>
</html>
