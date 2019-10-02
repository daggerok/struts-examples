<%--
  Created by IntelliJ IDEA.
  User: mkostromin
  Date: 10/3/19
  Time: 12:30 am
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hola!</title>
</head>
<body>
<s:form action="send-message">
    <s:textfield name="body" label="Message Body" autofocus="" />
    <s:submit />
</s:form>
<s:property value="message" />
</body>
</html>
