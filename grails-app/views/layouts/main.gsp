<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="Grails"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />

    <asset:stylesheet src="application.css"/>
    <asset:stylesheet src="custom.css"/>

    <g:layoutHead/>
</head>
<body>

    <div class="navbar navbar-default navbar-static-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/">
		            <asset:image src="coin.svg" alt="Coin Logo"/>
                </a>
            </div>
            <div class="navbar-collapse collapse" aria-expanded="false" style="height: 0.8px;">
                <ul class="nav navbar-nav navbar-right">
                    <g:pageProperty name="page.nav" />
                </ul>
                <div class="nav navbar-nav">
                    <li class="dropdown">
                        <a href="/credits"><i class="fa fa-money" aria-hidden="true"></i> Credits</a>
                    </li>
                    <li class="dropdown">
                        <a href="/course"><i class="fa fa-graduation-cap" aria-hidden="true"></i> Courses</a>
                    </li>
                    <li class="dropdown">
                        <a href="/courseGroup"><i class="fa fa-university" aria-hidden="true"></i> Course groups</a>
                    </li>
                    <li class="dropdown">
                        <a href="/backend"><i class="fa fa-terminal" aria-hidden="true"></i> Backend</a>
                    </li>
                </div>

            </div>
        </div>
    </div>

    <g:layoutBody/>

    <div class="footer" role="contentinfo"></div>

    <div id="spinner" class="spinner" style="display:none;">
        <g:message code="spinner.alt" default="Loading&hellip;"/>
    </div>

    <asset:javascript src="application.js"/>

</body>
</html>
