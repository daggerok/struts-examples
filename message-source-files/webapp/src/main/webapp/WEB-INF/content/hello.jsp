<%--
  Created by IntelliJ IDEA.
  User: mak
  Date: 1/7/18
  Time: 22:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
  <title>web app</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/styles.css">
  <link rel="shortcut icon" href="${pageContext.request.contextPath}/favicon.ico" type="image/x-icon">
</head>
<body>
<h3>Hola-la, Struts 2!</h3>
<p>message: <s:property value="message"/></p>
<footer>
  <ul>
    <li><a href="${pageContext.request.contextPath}/hello">go to ${pageContext.request.contextPath}/hello action</a></li>
    <li><a href="${pageContext.request.contextPath}/customers/list">go to ${pageContext.request.contextPath}/customers/list action</a></li>
    <li><a href="${pageContext.request.contextPath}">go home</a></li>
  </ul>
</footer>
</body>
</html>
