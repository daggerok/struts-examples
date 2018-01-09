<%--
  Created by IntelliJ IDEA.
  User: mak
  Date: 1/8/18
  Time: 04:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="/struts-tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
  <title>Customers list</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/styles.css">
  <link rel="shortcut icon" href="${pageContext.request.contextPath}/favicon.ico" type="image/x-icon">
</head>
<body>
<p>
  Customers?
  <s:property value="messageToCustomers"/>
</p>
<footer>
  <p>
    <a href="${pageContext.request.contextPath}/">go home</a>
  </p>
</footer>
</body>
</html>
