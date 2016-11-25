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

<body class="sivale image-Admin" id="init">

	<!-- Navigation -->
	<nav  class="navbar navbar-default navbar-static-top" data-ng-controller="updateSession" style="font-family: 'GothamBold';">
		
		<ul class="nav navbar-nav">

			<li class="dropdown" id="menuTH"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#"> <i class="fa fa-bars"></i> Menu
					<i class="fa fa-caret-down"></i>
			</a>
				<ul class="dropdown-menu dropdown-user">
					<li><a ui-sref="home"><i class="fa fa-home" aria-hidden="true"></i>
							Campañas </a></li>
							
					<li id="li-separator" role="separator" class="divider"></li>
					
					<li id="li-campaign"><a ui-sref="campaign">Publicaciones</a></li>

				</ul></li>

		</ul>

		<ul class="nav navbar-nav navbar-right">
			<li><a> <i class="fa fa-user fa-fw"></i>{{user.firstName}}
			</a></li>
			<li><a href="logout"> <i class="fa fa-sign-out"></i> Salir
			</a></li>
		</ul>
	</nav>
	
	<div ui-view></div>	

	<footer class="footer">
		<div id="imginthefooter" class="header_top">
			<div class="container width100">
				<div class="row">

					<div class="col-md-3"></div>
					<div class="col-md-6">
						<h3 class="text-center"
							style="font-size: 14px; font-family: GothamBold; color: white;">Programa
							administrado por Sí Vale México, S.A. de C.V. 2016 ©</h3>
					</div>
					<div class="col-md-3"></div>

				</div>
			</div>
		</div>
	</footer>

</body>



</html>