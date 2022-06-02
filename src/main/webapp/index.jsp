<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<br/>
<a href="home">MainServlet</a>
<form action="home" method="post">
    <p>
       Name: <input type="text" name="name">
    </p>
    <p>
        <input type="submit" value="Enter Name">
    </p>
</form>
</body>
</html>