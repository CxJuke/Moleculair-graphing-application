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
    <style type="text/css">
        #container {
            max-width: 100%;
            height: 100%;
            margin: auto;
        }
    </style>
</head>
<body>
<script src="js/formUpdater.js"></script>
<div id="dump"></div>
<form><input type="text", id="t", value="<BB> c1(H1,H2,H3)", onkeyup="o();"/></form>

<div id="container"></div>
<script src="js/sigma.min.js"></script>
<script src="js/sigma.parsers.json.min.js"></script>

<script>
    var s = new sigma('container');

    s.graph.addNode({
        id: 'c1',
        label: 'C, 2+',
        x: 0,
        y: 0,
        size: 25,
        color: '#f00'
    }).addNode({
        id: 'h11',
        label: 'H, 2+',
        x: 1,
        y:0,
        size: 15,
        color: '#e9e7ff'
    }).addNode({
        id: 'h12',
        label: 'H',
        x: -1,
        y: 0,
        size: 15,
        color: '#e9e7ff'
    }).addNode({
        id: 'h13',
        label: 'H',
        x: 0,
        y: 1,
        size: 15,
        color: '#e9e7ff'
    }).addNode({
        id: 'h14',
        label: 'H',
        x: 0,
        y: -1,
        size: 15,
        color: '#e9e7ff'
    }).addEdge({
        id: 'e0',
        // Reference extremities:
        source: 'c1',
        target: 'h11'
    }).addEdge({
        id: 'e1',
        // Reference extremities:
        source: 'c1',
        target: 'h12'
    }).addEdge({
        id: 'e2',
        // Reference extremities:
        source: 'c1',
        target: 'h13'
    }).addEdge({
        id: 'e3',
        // Reference extremities:
        source: 'c1',
        target: 'h14'
    });

    s.settings({
        scalingMode: 'inside',
        drawLabels: false,
        maxNodeSize: 50,
        scale: 100
    });
    s.refresh();

</script>

</body>
</html>
