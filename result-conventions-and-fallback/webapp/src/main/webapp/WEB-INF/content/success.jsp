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
  <link rel="stylesheet" href="./styles.css">
  <link rel="shortcut icon" href="./favicon.ico" type="image/x-icon">
</head>
<body>
<h3><%= this.getClass()
            .getSimpleName()
            .replaceAll("_002d", " ")
            .replaceAll("_", " ") %> - <s:property value="message" /></h3>
<footer>
  <ul>
    <li><a href="${pageContext.request.contextPath}/">go to ./ action</a></li>
    <li><a href="${pageContext.request.contextPath}/second-index">go to ./second-index action</a></li>
    <li><a href="${pageContext.request.contextPath}/blah/blah-blah">type whatever else to go to fallback</a></li>
  </ul>
</footer>
</body>
</html>
