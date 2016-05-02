<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html ng-app="app" data-ng-controller="campaignController">
<head ng-cloak>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

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

<!-- JS (load angular, ui-router, and our custom js file) -->
<script src="js/angular.min.js"></script>
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
<script src="js/grayscale.js"></script>
<script src="js/dynamic-background-home.js"></script>

</head>

<body class="sivale" id="init" >

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" data-ng-controller="updateSession">
            <div class="navbar-header" data-ng-controller="getClassifications" ng-cloak>
			<a class="navbar-brand"> 
			<img alt="Brand" src="img/ford-elite.png">
			</a>
		</div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-nav navbar-right">            
				<li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-bars"></i>  Menu  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="#"><i class="fa fa-home" aria-hidden="true"></i> Inicio </a>
                        </li>
                        <li><a href="#"><i class="fa fa-list" aria-hidden="true"></i> Campañas </a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a >
                        <i class="fa fa-credit-card"></i>
                        <span class="span-header">{{user.tjCardNumber}}</span>
                    </a>
                </li>
                <li >
                    <a >
                        <i class="fa fa-user fa-fw" ></i>
                        <span class="span-header">{{user.firstName}}</span>
                    </a>
                </li>
                <li >
                    <a href="logout">
                        <i class="fa fa-sign-out"></i>
                         Salir
                    </a>
                </li>
            </ul>
        </nav>
        
    <!-- Full Width Image Header -->
    <header  class="header-image">
        <div class="headline">
            <div class="container">
                <h1><font color="white">Elige el programa de Incentivos</font></h1>
                
            </div>
        </div>
		<a href="#transaction" class="btn btn-circle page-scroll"> 
			<i class="fa fa-angle-double-down animated"></i>
		</a>
	</header>


    <!-- Transaction Section -->
	<section id="transaction">
	
			<div ui-view></div>
		
	</section>

	<!-- Infp Section -->
	<section id="transaction2">
		<div class="container  font-color-text">
		
			<div class="row">
				
				<div class="col-xs-6 col-md-2"></div>
				<div class="col-xs-6 col-md-8">
					<div class="panel panel-gris">
						<div class="panel-heading">
							<div class="text-center">
								<h2>¿DUDAS SOBRE EL PROGRAMA DE
								INCENTIVOS?</h2>
							</div>
						</div>
					</div>
				</div>
				<div class="col-xs-6 col-md-2"></div>
				
			</div>

			<div class="row">

				<div class="col-xs-6 col-md-3"></div>
				<div class="col-xs-6 col-md-6">
					<div class="text-center">
						<h3>
							<font color="black"> Llámanos </font><br> 01 (55) 5814 9396<br> de 9 a 18 hrs.,
							lunes a viernes
						</h3>
					</div>
				</div>
				<div class="col-xs-6 col-md-3"></div>

			</div>

			<div class="row">

				<div class="col-xs-6 col-md-3"></div>
				<div class="col-xs-6 col-md-6">
					<div class="text-center">
						<h3>
							<font color="black"> O escríbenos </font><br> atnincentivos@sivale.com.mx
						</h3>
					</div>
				</div>
				<div class="col-xs-6 col-md-3"></div>

			</div>
			
			<div class="row">
				
				<div class="col-xs-6 col-md-2"></div>
				<div class="col-xs-6 col-md-8">
					<div class="panel panel-gris">
						<div class="panel-heading">
							<div class="text-center">
								<h2>¿DUDAS SOBRE LAS TARJETAS SIVALE?</h2>
								
							</div>
						</div>
					</div>
				</div>
				<div class="col-xs-6 col-md-2"></div>
				
			</div>
			
			<div class="row">

				<div class="col-xs-6 col-md-3"></div>
				<div class="col-xs-6 col-md-6">
					<div class="text-center">
						<h3><font color="black">Llama al servicio integral
							<br> para tarjetabientes</font><br> 
							01 (55) 5814 9396 <br> cualquier dia de la semana <br> 24 horas al dia
						</h3>
					</div>
				</div>
				<div class="col-xs-6 col-md-3"></div>

			</div>
			
			<div class="row">

				<div class="col-xs-6 col-md-3"></div>
				<div class="col-xs-6 col-md-6">
					<div class="text-center">
						<h3>
							<font color="black"> O escribenos </font><br> sita@sivale.com.mx
						</h3>
					</div>
				</div>
				<div class="col-xs-6 col-md-3"></div>

			</div>
			
			
			<div class="row">

				<div class="col-xs-6 col-md-4"></div>
				<div class="col-xs-6 col-md-4">
					<div class="text-center">
						<img src="img/t-lealtad.png" alt="..." class="img-rounded">
					</div>
				</div>
				<div class="col-xs-6 col-md-4"></div>

			</div>
			
			<br><br>
			

		</div>
	</section>

		<footer>
		<div id="imginthefooter" class="header_top">
			<div class="container width100" >
				<div class="row" >
					<div class="col-sm-3"></div>
					
					<div class="col-sm-2">
						<div class="contactinfo">
							<div class="div-fit-img2">
							<br>
								<img src="img/logo-header.png">
							</div>
						</div>
					</div>
					<div class="col-sm-4">
							<p>
								<font color="white">
									</br> Sí­ Vale México, S.A. de CV. </br> Av. Paseo de la Reforma No. 284,
									Piso 23. Col. Juárez, </br> Del. Cuauhtémoc, C.P. 06600, México, D.F.
									</br></br> SíVale 2016 
								</font>
							</p>						
					</div>
					<div class="col-sm-3"></div>
				</div>
			</div>
		</div>
	</footer>

</body>
</html>

