<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<header class="header-image">

<!-- 	<nav class="navbar navbar-default navbar-static-top" -->
<!-- 		data-ng-controller="updateSession" style="font-family: 'GothamBold';"> -->
		
<!-- 		<ul class="nav navbar-nav"> -->

<!-- 			<li class="dropdown" id="menuTH-Home" ><a class="dropdown-toggle" -->
<!-- 				data-toggle="dropdown" href="#"> <i class="fa fa-bars"></i> Menu -->
<!-- 					<i class="fa fa-caret-down"></i> -->
<!-- 			</a> -->
<!-- 				<ul class="dropdown-menu dropdown-user"> -->
<!-- 					<li><a href="#" ng-click="goToHome()"><i class="fa fa-home" aria-hidden="true"></i> -->
<!-- 							Inicio </a></li> -->

<!-- 				</ul></li> -->

<!-- 		</ul> -->

<!-- 		<ul class="nav navbar-nav navbar-right"> -->
<!-- 			<li><a> <i class="fa fa-credit-card"></i>  -->
<!-- 					{{user.tjCardNumber}} -->
<!-- 			</a></li> -->
<!-- 			<li><a> <i class="fa fa-user fa-fw"></i>  -->
<!-- 					{{user.firstName}} -->
<!-- 			</a></li> -->
<!-- 			<li><a href="logout"> <i class="fa fa-sign-out"></i> Salir -->
<!-- 			</a></li> -->
<!-- 		</ul> -->
<!-- 	</nav> -->
	
	<div class="headline">
		<div class="container">
<!-- 			<h1 style="font-family: 'GothamBold';font-size: 30px;"> -->
<!-- 				<font color="white">Haz clic sobre el logo para conocer las campañas del programa</font> -->
<!-- 			</h1> -->

		</div>
	</div>
	
	<br><br><br><br>
	
	<div class="container">
				
		<div class="row" data-ng-controller="getClassifications">

			<div class="col-xs-6 col-md-4"></div>
			<div class="col-xs-6 col-md-4">
				<div class="text-center" ng-repeat="class in classifications">
					
					<div class="thumbnail" >
							<div class="thumbnail2 div-sivale portfolio-box">
								<div class="thumbnail2_wrapper">
									<a href="#" data-ng-click="selectClassification(class)"
										ui-sref="campaigns"> <img
										ng-src="img/company_logo/{{class.catViews.logos}}/logo.png"
										class="img-responsive" alt="">
										<div class="portfolio-box-caption">
											<div class="portfolio-box-caption-content">
												<div class="project-name">Ver Campañas</div>
											</div>
										</div>
									</a>
								</div>
							</div>
						</div>
					
				</div>
			</div>
			<div class="col-xs-6 col-md-4"></div>

		</div>
		
	</div>


<br><br><br><br>


<!-- 	<a href="#transaction" class="btn btn-circle page-scroll"> <i -->
<!-- 		class="fa fa-angle-double-down animated"></i> -->
<!-- 	</a> -->
	
</header>

<br><br><br>

<section id="transaction">
	<div>

		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<h2 class="text-center color-default-ford" style="font-weight: bold; font-size: 40px;">
					REPORTE DE MOVIMIENTOS
				</h2>
				
				<br>
				
				<h4 class="text-center color-gray-ford"> 
				Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. 
				Donec ullamcorper nulla non metus auctor fringilla. Duis mollis, est non commodo luctus, 
				nisi erat porttitor ligula, eget lacinia odio sem nec elit. Donec 
				ullamcorper nulla non metus auctor fringilla.
				</h4>
				
				<br><br><br>
				
			</div>
			<div class="col-md-2"></div>
		</div>
		
		<br><br>

		<div class=" font-color-text">
			<div class="row">

				<div class="col-lg-6-user-email col-md-7">
					<div>
						<div>
							<div class="row">

								<div class="col-xs-6 col-sm-4"></div>

								<div class="col-xs-6 col-sm-1">
									<i class="fa fa-user fa-5x color-default-ford" aria-hidden="true"></i>
								</div>

								<div class="col-xs-6 col-sm-5">

									<div class="font-title-item">Nombre de Usuario</div>
									<div id="quickfit-user"
										title="${sessionScope.userDetails.userName}" class="huge">{{user.firstName}}
										{{user.lastName1}} {{user.lastName2}}</div>
								</div>

							</div>
						</div>
					</div>
				</div>

				<div class="col-lg-6-user-email col-md-5">
					<div>
						<div data-ng-controller="getBalance">
							<div class="row">

								<div class="col-xs-6 col-sm-1"></div>

								<div class="col-xs-6 col-sm-1">
									<i class="fa fa-usd fa-5x color-default-ford" aria-hidden="true"></i>
								</div>

								<div class="col-xs-6 col-sm-7">

									<div class="font-title-item ">Saldo Actual</div>
									<div class="huge">&#36;{{(balance | number:2) || '0.00'}}</div>

								</div>

								<div class="col-xs-6 col-sm-1"></div>

							</div>
						</div>
					</div>
				</div>

			</div>
		</div>

		<div class="container font-color-text" ng-cloak>
			<div class="panel panel-default table-top-sivale">
				<div class="panel-heading">Últimas Transacciones</div>

				<div class="panel-body back-sivale">
					<div data-ng-controller="getLastTransactionByCard" ng-cloak>
						<table data-ng-table="tableLastTransactions"
							class="table table-striped table-responsive table-hover">
							<tr data-ng-repeat="lastTransaction in $data">

								<td data-title="'Fecha'">{{lastTransaction.transactionDate}}</td>

								<td data-title="'Establecimiento'">
									{{lastTransaction.acceptorName}}</td>

								<td data-title="'Monto'">&#36;
									{{convertToPositive(lastTransaction.amount) | number:2}}</td>

							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>

<br>

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