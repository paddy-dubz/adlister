<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%
    if(request.getMethod().equalsIgnoreCase("POST")) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if ((username.equals("admin") && password.equals("password"))) {
            session.setAttribute("username", username);
            response.sendRedirect("profile.jsp");
        } else {
            response.sendRedirect("index.jsp");
        }
    }
%>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form method="POST">
        <p>
            <label for="username">Username</label>
            <input id="username" name="username" type="text" placeholder="Enter Username">
        </p>
        <p>
            <label for="password"> Password</label>
            <input id="password" name="password" type="password" placeholder="Enter Password">
        </p>
        <p>
            <button type="submit" value="submit">Submit</button>
        </p>
    </form>
</body>
</html>
