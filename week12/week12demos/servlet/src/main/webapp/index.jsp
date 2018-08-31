<%@ page import="java.time.LocalDateTime" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello world</title>
</head>
<body>
    <h1>Hello JSP world!</h1>
    <p><%= LocalDateTime.now().toString() %></p>
</body>
</html>
