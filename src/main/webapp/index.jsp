<%--
  Created by IntelliJ IDEA.
  User: Jouke
  Date: 12/14/18
  Time: 13:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Molecule grapher with grappa</title>
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/d3.v3.js"></script>
    <script type="text/javascript" src="js/jsnetworkx.js"></script>

    <script src="js/formUpdater.js"></script>
    <style type="text/css">
        #container {
            max-width: 100%;
            height: 100%;
            margin: auto;
        }
    </style>
</head>
<body>

<div id="dump"></div>
<form><input type="text", id="t", value="<BB> c1(H1,H2,H3)"/></form>

<div id="container"></div>


</body>
</html>
