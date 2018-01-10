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
<h3>tracking data</h3>
<s:form>
  <s:textfield name="latest" type="number"/>
  <s:submit value="add"/>
</s:form>
<h3>latest: <s:property value="latest" /></h3>
<h3>total: <s:property value="trackingData.total" /></h3>
<h3>goal: <s:property value="trackingData.goal" /></h3>
<s:if test="%{trackingData.total > trackingData.goal}">
  <%--
    will be executed automatically
    as sood expression will be evaluated as true
    and value will be reset.
  --%>
  <s:property value="resetTotal()" />
</s:if>
<footer>
  <ul>
    <li><a href="${pageContext.request.contextPath}">go home</a></li>
  </ul>
</footer>
</body>
</html>
