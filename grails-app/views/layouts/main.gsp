<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title><g:layoutTitle default="${meta(name: 'app.name')}"/></title>
    <asset:javascript src="application"/>
    <asset:stylesheet src="application"/>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <link rel="shortcut icon" href="${asset.image(src: 'favicon.ico')}" type="image/x-icon">
    <link rel="apple-touch-icon" href="${asset.image(src: 'images', file: 'apple-touch-icon.png')}">
    <link rel="apple-touch-icon" sizes="114x114" href="${asset.image(src: 'images', file: 'apple-touch-icon-retina.png')}">
    <g:layoutHead/>
</head>

<body role="document">

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#menu-principal"
                    aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${createLink(uri: '/')}">App</a>
        </div>

        <div class="collapse navbar-collapse" id="menu-principal">
            <ul class="nav navbar-nav">
                <li role="presentation" <g:if test="${request.forwardURI == "${createLink(uri: '/')}"}">class="active"</g:if>>
                    <g:link uri="/">
                        Home
                    </g:link>
                </li>
                <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName }}">
                    <li <g:if test="${c.logicalPropertyName == controllerName}">class="active"</g:if>>
                        <g:link controller="${c.logicalPropertyName}">${c.naturalName}</g:link>
                    </li>
                </g:each>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

<div class="container-fluid">
    <g:layoutBody/>
</div>

</body>

</html>
