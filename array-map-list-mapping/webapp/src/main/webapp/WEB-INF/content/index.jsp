<%--
  Created by IntelliJ IDEA.
  User: mak
  Date: 1/7/18
  Time: 22:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>web app</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/styles.css">
  <link rel="shortcut icon" href="${pageContext.request.contextPath}/favicon.ico" type="image/x-icon">
</head>
<body>
<h3>array</h3>
<p>1st: <s:property value="array[0]"/></p>
<ul>
  <c:forEach items="${array}" var="item">
    <li>${item}</li>
  </c:forEach>
</ul>

<h3>list</h3>
<%-- "{'l 1','l 2','; 3'}" --%>
<p>2nd: <s:property value="list[1]"/> or <s:property value="%{list.get(1)}"/></p>
<ul>
  <c:forEach items="${list}" var="item">
    <li>${item}</li>
  </c:forEach>
</ul>

<h3>map</h3>
<%-- "#{'k 1':'v 1','k 2':'v 2','k 3':'v 3'}" --%>
<p>3rd: <s:property value="%{map['k 3']}"/> or <s:property value="%{map.get('k 3')}"/></p>
<ul>
  <c:forEach items="${map}" var="pair">
    <li>(${pair}) => ${pair.key}: ${pair.value}</li>
  </c:forEach>
</ul>
</body>
</html>
