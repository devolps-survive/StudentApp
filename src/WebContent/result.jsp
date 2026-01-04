<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Result</title>
</head>
<body>

<h2>Operation Result</h2>

<%
    String message = (String) request.getAttribute("message");
    if (message != null) {
%>
    <p style="color:green;"><%= message %></p>
<%
    }
%>

<a href="StudentServlet">View Students</a><br><br>
<a href="register.html">Back to Registration</a>

</body>
</html>
