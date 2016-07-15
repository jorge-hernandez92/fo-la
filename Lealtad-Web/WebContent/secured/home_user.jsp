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
	<nav id="menuTH-A" class="navbar navbar-default navbar-static-top"
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
			
			<li><a> <i class="fa fa-question color-default-ford"></i> 
					Dudas o preguntas
			</a></li>
			
		</ul>
		
	</nav>
	
		<!-- Navigation -->
	<nav id="menuTH-A" class="navbar navbar-ford navbar-static-top"
		data-ng-controller="updateSession">

		<ul class="nav navbar-nav navbar-left" style=" margin-top: 0px; margin-left: 15px;">
			
			<li><a style="color: white;padding: 5px;"> 
					INICIO
			</a></li>
			
			<li><a style="color: white;padding: 5px;"> 
					| CAMPAÑAS
			</a></li>
			
			<li><a style="color: white;padding: 5px;"> 
					| PUBLICACIONES
			</a></li>
			
		</ul>
		
	</nav>

	<div ui-view></div>

	<br><br><br>
	
	<section id="contact" style="background: #333333;">
        <div class="container">
            
        

		<div class="row">

			<div class="col-xs-6 col-md-2"></div>
			<div class="col-xs-6 col-md-8">
						<div class="text-center">
							<h4 style="color:rgb(128,128,128)"> ¿DUDAS SOBRE EL PROGRAMA <br>DE INCENTIVOS?</h4>
						</div>
			</div>
			<div class="col-xs-6 col-md-2"></div>

		</div>

		<div class="row">

			<div class="col-xs-6 col-md-3"></div>
			<div class="col-xs-6 col-md-6">
				<div class="text-center">
					<h5 style="color:rgb(100,100,100)">
						Llámanos: 01 (55) 5814 9396
						de 9 a 18 hrs., lunes a viernes <br> Escríbenos
						<font style="color: rgb(44, 171, 255);"> 
							<u>atnincentivos@sivale.com.mx</u>
						</font>
					</h5>
				</div>
			</div>
			<div class="col-xs-6 col-md-3"></div>

		</div>
		
		<hr style="width: 700px;border-top: 1px solid rgb(100,100,100);">

		<div class="row">

			<div class="col-xs-6 col-md-2"></div>
			<div class="col-xs-6 col-md-8">
						<div class="text-center">
							<h4 style="color:rgb(128,128,128)">
								¿DUDAS SOBRE LAS TARJETAS SÍVALE?
							</h4>
						</div>
			</div>
			<div class="col-xs-6 col-md-2"></div>

		</div>

		<div class="row">

			<div class="col-xs-6 col-md-3"></div>
			<div class="col-xs-6 col-md-6">
				<div class="text-center">
					<h5 style="color:rgb(100,100,100)">
						Llama al servicio integral
							para tarjetabientes
						01 (55) 5814 9396 <br> cualquier día de la semana
						24 horas al día. Escribenos 
						<font style="color: rgb(44, 171, 255);">
							<u>sita@sivale.com.mx</u>
						</font>
					</h5>
				</div>
			</div>
			<div class="col-xs-6 col-md-3"></div>

		</div>
		
		<hr style="width: 700px; border-top: 1px solid rgb(100,100,100);">
		
		<div class="row">
			<div class="col-md-3"></div>
  			<div class="col-md-6"><h5 class="text-center" style="color:rgb(100,100,100)">Programa 
  										administrado por Sí Vale 
  										México, S.A. de C.V. 2016 ©
  								  </h5>
  			</div>
 			<div class="col-md-3"></div>

		</div>
		
	</div>
           
    </section>

</body>
</html>

