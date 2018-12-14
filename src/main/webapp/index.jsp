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
            max-width: 600px;
            height: 600px;
            margin: auto;
        }
    </style>
</head>
<body>

<div id="container">
    <script src="js/sigma.min.js"></script>
    <script src="js/sigma.parsers.json.min.js"></script>
    <script>
        sigma.parsers.json('data/data.json', {
            container: 'container',
            settings: {
                defaultNodeColor: '#000000'
            }
        });
    </script>
</div>

</body>
</html>
