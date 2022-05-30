<%--
  Created by IntelliJ IDEA.
  User: konstantinstaykov
  Date: 5/29/22
  Time: 10:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.example.demo.HelloHelper" %>
<html>
<head>
    <title>JSP Example</title>
</head>
<body>
<h1>
    <jsp:useBean id="helper" class="com.example.demo.HelloHelper"
                 scope="application"/>
    <%=helper.getGreeting(request.getLocale())%>${param.name}
</h1>
</body>
</html>
