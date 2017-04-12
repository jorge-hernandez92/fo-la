<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html ng-app="app"
	data-ng-controller="campaignAdminController">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport"  content="width=device-width, initial-scale=1">
<meta http-equiv="refresh" content="<%=(session.getMaxInactiveInterval())%>; url=Ford" />
    
<title>Lealtad-Incentivos</title>

<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/daterangepicker.min.css">
<link rel="stylesheet" href="css/ng-table.min.css">
<link href="css/fileinput.css" rel="stylesheet">
<!-- <link ng-href="css/sivale.css" rel="stylesheet"> -->
<link ng-href="css/ford.css" rel="stylesheet">
<link ng-href="css/ng-toggle-btn.css" rel="stylesheet">
<link ng-href="css/angular-notify.css" rel="stylesheet">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/sb-admin-2.css">
<link rel="stylesheet" href="css/default.css">
<!-- links provicinales  -->
<link rel="stylesheet" href="css/sticky-footer.css">
<link rel="stylesheet" type="text/css" href="css/normalize.css" />
<link rel="stylesheet" type="text/css" href="css/set2.css" />
<link href="css/default-fonts.css" rel="stylesheet">

<!-- Nuevo rediseño -->
<link rel="stylesheet" type="text/css" href="css/transition-campaigns.css" />


<!-- JS (load angular, ui-router, and our custom js file) -->
<script src="js/jquery-2.1.4.min.js"></script>
<script src="js/fileinput.js" type="text/javascript"></script>
<script src="js/fileinput_locale_es.js" type="text/javascript"></script>
<script src="js/angular.js"></script>
<script src="js/angular-ui-router.min.js"></script>
<script src="js/ng-table.min.js"></script>
<script src="js/appAdmin.js"></script>
<script src="js/moment.min.js"></script>
<script src="js/bootstrap-filestyle.js"></script>
<script src="js/ng-toggle-btn.js"></script>
<script src="js/angular-notify.js"></script>
    
<!-- bower:js -->
<script src="js/angular-messages.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/daterangepicker.min.js"></script>
<!-- endbower -->
<script src="js/angular-daterangepicker.min.js"></script>
</head>
<body class="sivale" id="init">
	<nav id="menuTH-A" class="navbar navbar-default navbar-fixed-top "
		data-ng-controller="updateSession" style="max-height: 60px;background-color: #f0f0e9;">
		<div class="container">
		<ul class="nav navbar-nav">
			<li class="dropdown" id="menuTH">
				<a class="dropdown-toggle" data-toggle="dropdown" style="padding: 0px 0px;" href="#"> <img style="max-width: 200px;margin-left: 40px;margin-top: 5px;" src="img/company_logo/Ford/header1.png"> <i class="fa fa-caret-down"></i></a>
				<ul class="dropdown-menu dropdown-user">
					<li><a ui-sref="home"><i class="fa fa-home" aria-hidden="true"></i>Incentivos </a></li>
				</ul>
			</li>
		</ul>
		<ul class="nav navbar-nav navbar-right ">
			<li class="color-default-ford"><h4 style="padding-right: 90px; margin-top: 22px;margin-left: 15px;"><b>¡Bienvenido!  {{user.firstName }} {{user.lastName1}}</b></h4></li>
			<li><h4 style="padding-top: 10px;padding-right: 80px;"><a style="text-decoration: blink;" href="logout" "><i class="fa fa-power-off color-default-ford " style="vertical-align: middle;"></i>&ensp;Cerrar Sesión</a></h4></li>
		</ul> 
		</div>
	</nav>
	<br><br><br>
	<div ui-view></div>	
	<footer class="footer">
		<div  class="header_top">
			<div class="container width100">
			<div class="row">
				<div class="col-md-3">
					<a class="navbar-brand" style="padding: 0px 0px;"> <img
						style="max-width: 130px;margin-left: 15px;margin-top: 15px;"
						src="img/company_logo/Ford/logo.png">
					</a>
				</div>
				<div class="col-md-5" style="padding-top: 20px;">Copyright ©
					2017 Ford Motor Company - Todos los derechos reservados.
				</div>
				<div class="col-md-2">
					<a class="navbar-brand" style="padding: 0px 0px;"> <img
						style="max-width: 230px;margin-top: 5px;"
						src="img/company_logo/FordCredit/header.png">
					</a>
				</div>
				<div class="col-md-1">
					<a class="navbar-brand" style="padding-top: 0px;padding-left: 60px;"> <img
						style="max-width:97px; margin-left: 0px; margin-top: 5px;"
						src="img/company_logo/Lincoln/logo.png">
					</a>
				</div>
			</div>
			</div>
		</div>
	</footer>
</body>
</html>