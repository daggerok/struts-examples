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
<h3>Adding data</h3>
<s:form>
  <s:textfield name="newData" type="text" placeholder="Enter data value"/>
  <s:submit type="submit" value="Submit"/>
</s:form>

<h3>Current</h3>
<p><s:property value="newData"/></p>

<footer>
  <ul>
    <li><a href="./find-all">view</a></li>
    <li><a href="./submit-data">add</a></li>
    <li><a href="./">home</a></li>
  </ul>
</footer>
</body>
</html>
