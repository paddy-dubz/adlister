<%--
  Created by IntelliJ IDEA.
  User: Patrick
  Date: 12/13/16
  Time: 9:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%! int counter = 0; %>
<% counter += 1; %>
<html>
<head>
    <title>Hello world from JSP</title>
</head>
<body>
<%@include file="navigation.jsp"%>
    <h1>Hello ${param.name}</h1>
    <%= counter %>

<h3>Names</h3>
<c:forEach var="names" items="${names}">
    <p>${names}</p>
</c:forEach>
</body>
</html>
