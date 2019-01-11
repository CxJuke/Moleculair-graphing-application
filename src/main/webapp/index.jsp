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
    <script src="js/stringFormatter.js"></script>





    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="js/bootstrap.min.js"></script>
    <script src="js/formUpdater.js"></script>
    <script>
        var mol_old = ''
        var status = 'true'
    </script>
</head>
<body>

<div class="container-fluid">
    <div class="panel-heading">
        <h1><i class="offset-5"></i><strong>Molecule Graph</strong></h1>
    </div>
        <form>
            <div class="form-group row">
                <div class="col-sm-12">
                    <input id="t" class="form-control form-control-lg" type="text" placeholder="Begin building your molecule...">
                    <div class="invalid-feedback">
                        When building, make sure to separate each finished molecule with spaces & check if all brackets are closed. Click <a id="help">here</a> for more help
                    </div>
                </div>
            </div>

        </form>

    <div class="container-fluid">
        <div id="mainContainer" class="col-12 h-75">
        </div>
    </div>
    <button type="button" class="btn btn-primary col-lg-1" style="float: none;margin: 0 auto;" data-toggle="modal" data-target=".bd-example-modal-lg">Save Molecule</button>

</div>

<div class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="container">
            <form action="/save.molecule" method="post">
                <div class="form-group">
                    <label for="moleculeName">Name for molecule</label>
                    <input type="text" class="form-control" id="moleculeName" aria-describedby="namingHelp" placeholder="Molecule name">
                    <small id="namingHelp" class="form-text text-muted">Name the molecule you want to save. Make sure that this name describes the molecule correctly</small>
                </div>
                <div class="form-group">
                    <label for="SaveMolecule">Molecule build string that will be saved</label>
                    <input type="text" class="form-control" id="SaveMolecule" value="" readonly>
                </div>
                <input class="btn btn-primary" type="submit" value="Save">
            </form>

            </div>
        </div>
    </div>
</div>
<div id="scripts" hidden>

</div>
<div id="scripts2" hidden></div>

</body>
</html>
