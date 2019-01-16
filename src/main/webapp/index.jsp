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
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-3-typeahead/4.0.1/bootstrap3-typeahead.min.js"></script>
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
            <div class="form-row">
                <div class="col-sm-10">

                    <label class="sr-only" for="t">Molecule String</label>
                    <input id="t" class="form-control" type="text" placeholder="Begin building your molecule..." autocomplete="off">
                    <div class="invalid-feedback col-sm-12">
                        When building, make sure to separate each finished molecule with spaces & check if all brackets are closed. Click <a href="#" data-toggle="modal" data-target="#help" id="#help">here</a> for more help
                    </div>
                </div>
                    <div class="col-1 text-center">
                        <button type="button" class="btn btn-primary" style="width: 90%" data-toggle="modal" data-target=".bd-example-modal-lg">Save</button>
                    </div>
                <div class="col-1 text-center">
                    <button type="button" class="btn btn-primary" style="width: 90%" data-toggle="modal" data-target="#help">Help</button>
                </div>
                </div>
            <div class="container-fluid">
                <button class="btn btn-sm" data-toggle="collapse" data-target="#demo"><span class="fas fa-search"></span>Prebuild molecules</button>
                <div id="demo" class="collapse form-row">
                    <div class="col-sm-10">
                        <h1>hallo</h1>

                    </div>
                </div>
                </div>
            </div>
        </form>

    <div class="container-fluid">
        <div id="mainContainer" class="col-12 h-75">

        </div>
    </div>


<div>
    <div class="input-group">
        <input type="text" data-provide="typeahead" class="form-control typeahead border-primary" name="query" id="query" placeholder="search..." autocomplete="off">
    </div>
</div>

<div class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="container">
            <form action="save.molecule" method="post">
                <div class="form-group">
                    <label for="moleculeName">Name for molecule</label>
                    <input type="text" class="form-control" name="moleculeName" id="moleculeName" aria-describedby="namingHelp" placeholder="Molecule name">
                    <small id="namingHelp" class="form-text text-muted">Name the molecule you want to save. Make sure that this name describes the molecule correctly</small>
                </div>
                <div class="form-group">
                    <label for="SaveMolecule">Molecule build string that will be saved</label>
                    <input type="text" class="form-control" name="SaveMolecule" id="SaveMolecule" value="" readonly>
                </div>
                <input id="savingMolecule" class="btn btn-primary" type="submit" value="Save">
            </form>

            </div>
        </div>
    </div>
</div>

<div class="modal fade bd-example-modal-lg" id="help" tabindex="-1" role="dialog" aria-labelledby="helpLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="container">
                <h1 class="modal-title" id="exampleModalLabel">How to build a molecule?</h1>
                <div class="modal-body">
                    <p><strong>Build graphs from string definition: </strong><br>

                        Grappa allows constructing a graph using a linear sequence of tokens,
                        the grappa string. A token can be a node name, a definition of a series
                        of nodes or a special character/directive. The principle behind the
                        grappa string is that the graph is extended from an active node. A new
                        node is connected to the active node. Using @ the active node can be
                        switched, and using () branches can be specified on an active node. A
                        complete description of the grappa minilanguage is given below: <br><br>

                        <strong>Grappa string Rules:</strong><br>

                        <strong>name</strong>        : add node with name, with edge to active node
                        (none at start, active parent at start of branch) <br><br>
                        <strong>-name</strong>       : remove node with name <br><br>

                        <strong>@name</strong>       : select name as active node <br><br>

                        <strong>(</strong>: set active node as active parent (start branching) <br><br>

                        <strong>,</strong>           : switch to new branch at active parent <br><br>

                        <strong>)</strong>           : set active parent to active node <br><br>

                        <strong>=nameB</strong>      : rename active node (keep edges) <br><br>

                        <strong>{attr=val}</strong>  : set attribute on active node (can be
                        attributes like:  element, charge, valence, stubs
                        element is set to FIRST LETTER of name,
                        unless speicfied as attribute
                        attribute chiral has tuple of three nodes,
                        which define chirality according to right-hand rule <br><br>

                        <strong>!X</strong>          : connect active node to node X, which _must_ be present
                        already. Otherwise, using a name that is already there is an
                        error <br><br>

                        <strong>&lt;NAME&gt;</strong>      : include brick with given name <br><br>

                        <strong><':NAME></strong>    : include brick with given name and add ' as suffix to nodes <br><br>

                        <strong>&lt;NAME@X>;</strong>    : include brick with given name and add edge between active
                        node and node 'X' of brick <br><br>

                        <strong>/#=1-20/C#(H#[1-2])/</strong> : Expand by repetion and substitution according to
                        range specified <br><br>

                        <strong>(/#=A-D/C#(H#[1-3]),/)</strong> : Expand to multiple branches
                    </p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>
</div>


</body>
</html>




