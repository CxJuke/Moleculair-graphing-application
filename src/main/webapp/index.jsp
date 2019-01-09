<%--
  Created by IntelliJ IDEA.
  User: Jouke
  Date: 12/14/18
  Time: 13:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Molecule grapher with grappa</title>
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/d3.v3.js"></script>
    <script type="text/javascript" src="js/jsnetworkx.unminify.js"></script>
    <script src="js/hover.js"></script>


    <script src="js/formUpdater.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>

    <link rel="stylesheet" href="css/bootstrap.css">
    <script src="js/bootstrap.min.js"></script>
</head>
<body class= "bg-light">

<div class="container-fluid">
    <div class="panel-heading">
        <h1><i class="offset-5"></i><strong>Molecule Graph</strong></h1>
    </div>
    <div id="input" class="container-fluid">
        <form>
            <div class="col-12" style="align-content: center;">
                <input id="t" class="form-control form-control-lg" type="text" data-toggle="tooltip" title="Type your Molecule to be drawn here! Example: /#=1-3/(C#(H#[1-2]))/" placeholder="Molecule" style="width: 100%; align-content: center" >
            </div>
        </form>
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bd-example-modal-lg">Save Molecule</button>
    </div>

    <div class="container-fluid">
        <div id="container" class="col-12 h-75"></div>
    </div>
    <div id="input_name" class="container-fluid">
        <form action="save.molecule" method="post">
            <div class="offset-5" style="align-content: center;" >
                Molecule name:<input type="text" name="moleculename"><br>
                <input type="submit" value="Save to database">
            </div>
        </form>
    </div>

</div>

<div class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="container">
            <form class="offset-5" action="/save.molecule" method="post">
                Molecule name:<br/>
                <input type="text" name="name"><br/>
                Molecule String:<br/>
                <input type="text" name="molecule" value=$('#t')><br/>
                <input class="btn btn-primary" type="submit" value="Save">

            </form>

            </div>
        </div>
    </div>
</div>

</body>
</html>
