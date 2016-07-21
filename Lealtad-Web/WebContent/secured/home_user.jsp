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

<!-- Nuevo rediseño -->
<link rel="stylesheet" type="text/css" href="css/transition-campaigns.css" />

<!-- ESTILO DEL CLIENTE  -->
<link rel="stylesheet" type="text/css" href="css/ford/ford-style.css" />


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
<script src="js/dynamic-background-home.js"></script>

</head>

<body class="sivale" id="init">

	<!-- Navigation -->
	<nav id="menuTH-A" class="navbar navbar-default navbar-fixed-top"
		data-ng-controller="updateSession">
		
			<div class="navbar-header">
				<a class="navbar-brand" > <img style="max-width:250px; margin-left: 15px;" src="img/company_logo/Ford/logo.png">
				</a>
			</div>

		<ul class="nav navbar-nav navbar-right" style=" margin-top: 15px;">
			
			<li><a> <i class="fa fa-user color-default-ford"></i> 
					{{user.firstName}}
			</a></li>
			
			<li><a> <i class="fa fa-credit-card color-default-ford"></i> 
					{{user.tjCardNumber}}
			</a></li>
			
			<li><a href="logout"> <i class="fa fa-sign-out color-default-ford"></i> 
					Salir
			</a></li>
			
			<li><a href="#contact" class="page-scroll" ng-click="dudas()" > <i class="fa fa-question color-default-ford"></i> 
					Dudas o preguntas
			</a></li>
			
		</ul>
		
	</nav>
	
		<!-- Navigation -->
	<nav id="menuTH-A" class="navbar navbar-ford navbar-fixed-top"
		data-ng-controller="updateSession" style="margin-top: 65px;">

		<ul class="nav navbar-nav navbar-left" style=" margin-top: 0px; margin-left: 15px;">
			
			<li id="li-home"><a  href="#" ng-click="goToHome()"  style="color: white;padding: 5px;"> INICIO  </a></li>
			
			<li id="li-campaigns"><a ui-sref="campaigns" style="color: white;padding: 5px;"> | CAMPAÑAS      </a></li>
			
			<li id="li-campaign"><a  ui-sref="campaign" style="color: white;padding: 5px;"> | PUBLICACIONES  </a></li>	
			
		</ul>
		
			<p id="p-home" class="navbar-text" style="font-weight: bold;margin-top: 5px;margin-left: 5px;margin-right: 5px;">INICIO</p>
			
			<p id="p-campaigns" class="navbar-text" style="font-weight: bold;margin-top: 5px;margin-left: 5px;margin-right: 5px;">| CAMPAÑAS</p>
			
			<p id="p-campaign" class="navbar-text" style="font-weight: bold;margin-top: 5px;margin-left: 5px;margin-right: 5px;">| PUBLICACIONES</p>
			
			<p id="p-detail-publication" class="navbar-text" style="font-weight: bold;margin-top: 5px;margin-left: 5px;margin-right: 5px;">| DETALLE DE PUBLICACIÓN</p>
		
	</nav>
	
	<nav style="display:none; margin-top: 95px;" id="menu-files-publication" class="navbar navbar-info-file navbar-fixed-top"
		data-ng-controller="updateSession">

		<ul class="nav navbar-nav navbar-left" style=" margin-top: 0px; margin-left: 500px;">
			
			<li><a href="#"  style="color: black; padding: 5px;"> 
			
				NO OLVIDES CONSULTAR LOS ARCHIVOS ADJUNTOS 
				<i class="fa fa-download color-default-ford"></i>

			</a></li>
			
		</ul>
		
	</nav>
	
	<br><br><br><br>

	<div ui-view></div>
	
	
</body>
</html>

