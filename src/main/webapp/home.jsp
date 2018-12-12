<%--
  Created by IntelliJ IDEA.
  User: jprofijt
  Date: 12-12-18
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Testing</title>
<<style type="text/css">
    #container {
        max-width: 1024px;
        height: 1024px;
        margin: auto;
    }
</style>
</head>
<body>
<div id="container"></div>
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
</body>
</html>
