<%--
  Created by IntelliJ IDEA.
  User: pkamphuis
  Date: 7-1-19
  Time: 9:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Save molecule to database</title>
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/d3.v3.js"></script>
    <script type="text/javascript" src="js/jsnetworkx.unminify.js"></script>

    <script src="js/formUpdater.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
    <h1>Save molecule to database</h1>
    <div id="input" class="container-fluid">
        <form action="save_page.jsp" method="post">
            <div class="form-group" style="align-content: center;">
                Molecule name:<br>
                <input type="text" name="moleculename"><br>
                <input type="submit" value="Save">
            </div>
        </form>
    </div>

</body>
</html>
