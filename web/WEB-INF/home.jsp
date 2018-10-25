<%-- 
    Document   : home
    Created on : Sep 30, 2018, 5:36:19 PM
    Author     : 659159
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix=“sait" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Home Page</h1>
        <div>
            <h3>Hello ${welcome}</h3>
        </div>
        <div>
            <a href="login?logout">Log Out</a>
        </div>
    </body>
</html>
