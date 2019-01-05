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
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Molecule grapher with grappa</title>
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/d3.v3.js"></script>
    <script type="text/javascript" src="js/jsnetworkx.js"></script>

    <script src="js/formUpdater.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="js/bootstrap.min.js"></script>
<body>
<div id="input" class="container-fluid">
<form>
    <div class="form-group" style="align-content: center;">
<input id="t" class="form-control form-control-lg" type="text" placeholder="Molecule" style="width: 100%; align-content: center">
    </div>

</form>
</div>
<div class="container-fluid">
    <div class="panel-heading">
        <h2><i class="fa fa-map-marker red"></i><strong>Molecule asdf Graph</strong></h2>
    </div>
    <div class="panel-body-map">
        <div id="container" style="height:80vh;"></div>
    </div>

</div>


</body>
</html>
