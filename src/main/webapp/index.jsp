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


<script type="text/javascript">
    var G = new jsnx.Graph();
    G.addNodesFrom(['H43', 'C1', 'H23', 'H21', 'H41', 'C2', 'H31', 'H33', 'H1', 'H42', 'H32', 'C4', 'C3', 'H22']);
    G.addEdgesFrom([['H43', 'C4'], ['C1', 'H1'], ['C1', 'C4'], ['C1', 'C2'], ['C1', 'C3'], ['H23', 'C2'], ['H21', 'C2'], ['H41', 'C4'], ['C2', 'H22'], ['H31', 'C3'], ['H33', 'C3'], ['H42', 'C4'], ['H32', 'C3']]);

    jsnx.draw(G, {
        element: '#container',
        withLabels: true,
        nodeStyle: {
            fill: function(d) {
                return d.data.color || '#AAA';
            }
        }
    });
</script>

</body>
</html>
