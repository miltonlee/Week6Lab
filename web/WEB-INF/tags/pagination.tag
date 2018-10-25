<%-- 
    Document   : pagination
    Created on : Oct 11, 2018, 12:33:52 PM
    Author     : 659159
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="login"%>

<%-- any content can be specified here e.g.: --%>

  <form method="post" action="">
            Username <input type="text" name="username" value="${username}"><br>
            Password: <input type="text" name="password"><br>
            <input type="submit" value="Login" name="submit"><br>
            <input type="checkbox" name="rem" >Remember Me<br>
        </form>
           