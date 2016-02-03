<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="es" ng-app="app"
	data-ng-controller="campaignAdminController">
<head ng-cloak>

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

<!-- JS (load angular, ui-router, and our custom js file) -->
<script src="js/jquery-2.1.4.min.js"></script>
<script src="js/fileinput.js" type="text/javascript"></script>
<script src="js/fileinput_locale_es.js" type="text/javascript"></script>
<script src="js/angular.min.js"></script>
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

<body class="back-sivale">

	<header id="header" data-ng-controller="updateSession">
		<div class="header_top">
			<div class="container width100">
				<div class="row back-gray">
					<div class="col-sm-6">
						<div class="contactinfo">
							<div class="div-fit-img2">
<!-- 								<img src="img/logo-header.png" ui-sref="#"> -->
								<img src="img/company_logo/Ford/header.png" ui-sref="#">
							</div>
						</div>
					</div>
					<div class="col-sm-6">

						<div class="shop-menu pull-right">
							<ul class="nav navbar-nav margin-top10">
											
								<li></span><span class="glyphicon glyphicon-user span-header">
											{{user.firstName}} </a></li>
								
								<li></span><a href="logout"><span
										class="glyphicon glyphicon-log-out"> Salir</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="header-middle">
			<div class="container width100">
				<div class="row">
					<div class="col-sm-4">
						<div class="logo pull-left">
							<div class="row">

								<div class="col-md-2">
<!-- 									<div id="o-wrapper"> -->
<!-- 										<a id="c-button--slide-left" href="#" class="toggle" -->
<!-- 											role="button" title="Navigation" data-toggle="tooltip" -->
<!-- 											data-placement="left"><i class="ion-navicon"></i></a> -->
<!-- 									</div> -->
								</div>
								
								<div class="col-md-10">
<!-- 									<div class="div-fit-img"> -->
<!-- 										<img src={{logo}} ui-sref="#" ng-if="logo"> -->
<!-- 									</div> -->
								</div>
							</div>
						</div>

					</div>
					<div class="col-sm-8">
						<div class="shop-menu pull-right">
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>

	<div class="row">

		<div class="col-md-10">
			<div ui-view></div>
		</div>
		<div class="col-md-2">
			<div class="panel-body back-sivale">
				<div class="containerBanner">
<!-- 					<img src="img/banner_sivale.gif"> -->
					<img src="img/banner_ford.jpg">
				</div>
			</div>
		</div>

	</div>

</body>
</html>