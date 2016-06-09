<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html ng-app="app" data-ng-controller="campaignController">
<head ng-cloak>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">



<title>Lealtad-Incentivos</title>

<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/daterangepicker.min.css">
<link rel="stylesheet" href="css/ng-table.min.css">
<link rel="stylesheet" href="css/angular-carousel.css">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/sb-admin-2.css">
<link ng-href="css/{{css}}" rel="stylesheet">
<!-- links provicinales  -->
<link rel="stylesheet" href="css/sticky-footer.css">
<link rel="stylesheet" type="text/css" href="css/normalize.css" />
<link rel="stylesheet" type="text/css" href="css/set2.css" />
<link href="css/default-fonts.css" rel="stylesheet">



<!-- JS (load angular, ui-router, and our custom js file) -->
<script src="js/angular.min.js"></script>

<!-- <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular.min.js"></script> -->
<script src="js/angular-ui-router.min.js"></script>
<script src="js/ng-table.min.js"></script>
<script src="js/app.js"></script>
<script src="js/moment.min.js"></script>
<script src="js/jquery-2.1.4.min.js"></script>

<!-- bower:js -->
<script src="js/angular-messages.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/daterangepicker.min.js"></script>
<!-- endbower -->

<script src="js/angular-daterangepicker.min.js"></script>
<script src="js/hammer.min.js"></script>
<script src="js/angular-carousel.js"></script>

<!-- links provicinales  -->
<script src="js/jquery.easing.min.js"></script>
<!-- <script src="js/grayscale.js"></script> -->
<!-- <script src="js/dynamic-background-home.js"></script> -->

</head>

<body class="sivale" id="init">

	<!-- Navigation -->
	<nav id="menuTH-A" class="navbar navbar-default navbar-static-top"
		data-ng-controller="updateSession" style="font-family: 'GothamBold'; font-color: white">
		
		<ul class="nav navbar-nav">

			<li class="dropdown" id="menuTH"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#"> <i class="fa fa-bars"></i> Menu
					<i class="fa fa-caret-down"></i>
			</a>
				<ul class="dropdown-menu dropdown-user">
					<li><a href="#" ng-click="goToHome()"><i class="fa fa-home" aria-hidden="true"></i>
							Inicio </a></li>
							
					<li id="li-separator" role="separator" class="divider"></li>

					<li id="li-campaigns"><a ui-sref="campaigns">Campañas</a></li>
					
					<li id="li-campaign"><a ui-sref="campaign">Publicaciones</a></li>

				</ul></li>

		</ul>

		<ul class="nav navbar-nav navbar-right">
			<li><a> <i class="fa fa-credit-card"></i> 
					{{user.tjCardNumber}}
			</a></li>
			<li><a> <i class="fa fa-user fa-fw"></i> 
					{{user.firstName}}
			</a></li>
			<li><a href="logout"> <i class="fa fa-sign-out"></i> Salir
			</a></li>
		</ul>
	</nav>

	<div ui-view></div>

	<br><br><br>


	<footer class="footer">
		<div id="imginthefooter" class="header_top">
			<div class="container width100">
				<div class="row">
				
					<div class="col-md-3"></div>
  					<div class="col-md-6"><h3 class="text-center" style="font-size: 14px; font-family: GothamBold;color: white;">Programa administrado por Sí Vale México, S.A. de C.V. 2016 ©</h3></div>
 					<div class="col-md-3"></div>

				</div>
			</div>
		</div>
	</footer>

</body>
</html>

