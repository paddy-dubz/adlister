<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Patrick
  Date: 12/14/16
  Time: 11:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/partials/head.jsp">
        <jsp:param name="title" value="Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="/partials/navbar.jsp"/>
<div class="container">
    <table class="table table-bordered">
        <thead>
            <c:forEach items="${ads}" var="ad">
                <tr>
                    <td>${ad.title}</td>
                    <td>${ad.description}</td>
                </tr>
            </c:forEach>
        </thead>
    </table>
</div>
</body>
</html>
