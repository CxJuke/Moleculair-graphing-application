<%--
  Created by IntelliJ IDEA.
  User: pkamphuis
  Date: 4-12-18
  Time: 13:31
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>3 Boxes</title>
    <meta name="description" content="">
    <meta name="author" content="ink, cookbook, recipes">
    <meta name="HandheldFriendly" content="True">
    <meta name="MobileOptimized" content="320">
    <meta name="mobile-web-app-capable" content="yes">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">

    <!-- Place favicon.ico and apple-touch-icon(s) here  -->

    <link rel="shortcut icon" href="img/favicon.ico">

    <link rel="apple-touch-icon" href="img/touch-icon-iphone.png">
    <link rel="apple-touch-icon" sizes="76x76" href="img/touch-icon-ipad.png">
    <link rel="apple-touch-icon" sizes="120x120" href="img/touch-icon-iphone-retina.png">
    <link rel="apple-touch-icon" sizes="152x152" href="img/touch-icon-ipad-retina.png">
    <link rel="apple-touch-startup-image" href="img/splash.320x460.png" media="screen and (min-device-width: 200px) and (max-device-width: 320px) and (orientation:portrait)">
    <link rel="apple-touch-startup-image" href="img/splash.768x1004.png" media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:portrait)">
    <link rel="apple-touch-startup-image" href="img/splash.1024x748.png" media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:landscape)">

    <!-- load Ink's CSS -->
    <link rel="stylesheet" type="text/css" href="css/ink-flex.min.css">
    <link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">

    <!-- load Ink's CSS for IE8 -->
    <!--[if lt IE 9 ]>
    <link rel="stylesheet" href="css/ink-ie.min.css" type="text/css" media="screen" title="no title" charset="utf-8">
    <![endif]-->

    <!-- test browser flexbox support and load legacy grid if unsupported -->
    <script type="text/javascript" src="js/modernizr.js"></script>
    <script type="text/javascript">
        Modernizr.load({
            test: Modernizr.flexbox,
            nope : 'css/ink-legacy.min.css'
        });
    </script>

    <!-- load Ink's javascript files -->
    <script type="text/javascript" src="js/holder.js"></script>
    <script type="text/javascript" src="js/ink-all.min.js"></script>
    <script type="text/javascript" src="js/autoload.js"></script>


    <style type="text/css">

        body {
            background: #ededed;
        }

        header h1 small:before  {
            content: "|";
            margin: 0 0.5em;
            font-size: 1.6em;
        }

        footer {
            background: #ccc;
        }

    </style>

</head>

<body>

<div class="ink-grid">

    <!--[if lt IE 9 ]>
    <div class="ink-alert basic" role="alert">
        <button class="ink-dismiss">&times;</button>
        <p>
            <strong>You are using an outdated Internet Explorer version.</strong>
            Please <a href="http://browsehappy.com/">upgrade to a modern browser</a> to improve your web experience.
        </p>
    </div>
    <![endif]-->

    <!-- Add your site or application content here -->

    <header class="vertical-space">
        <h1>Molecular graphing<small>Graphing with GRAPPA</small></h1>
    </header>
    <div class="column-group gutters">
        <div class="all-100">
            <h2>Type a sequence to begin drawing</h2>
            <form class="ink-form" action = "main.jsp" method = "POST">
                <label class="ink-label">
                <input type = "text" name = "Certain syntax">
            </label>
            </form>
            <img src="js/holder.js/1650x928/auto/ink" alt="">
        </div>
    </div>
</div>
<footer class="clearfix">
    <div class="ink-grid">
        <ul class="unstyled inline half-vertical-space">
            <li class="active"><a href="#">About</a></li>
            <li><a href="#">Sitemap</a></li>
            <li><a href="#">Contacts</a></li>
        </ul>
        <p class="note">Identification of the owner of the copyright, either by name, abbreviation, or other designation by which it is generally known.</p>
    </div>
</footer>
</body>
</html>
