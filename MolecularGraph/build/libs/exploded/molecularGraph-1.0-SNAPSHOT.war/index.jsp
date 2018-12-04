<%--
  Created by IntelliJ IDEA.
  User: pkamphuis
  Date: 4-12-18
  Time: 13:31
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
        <title>Molecular graph</title>
    </head>
    <body class="alert-dark">
    <div class="text-md-center">
        <h1 class="alert-dark">Type certain syntax to draw molecule</h1>
        <form action = "main.jsp" method = "POST">
            Certain syntax: <input type = "text" name = "Certain syntax">
            <br/>
            <input type = "submit" value = "Draw" />
        </form>
    </div>
    </body>
</html>
