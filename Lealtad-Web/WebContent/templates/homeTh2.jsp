<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	
<section id="banner">

<header class="header-image">
	

	<br><br><br><br>
	
		<div class="row" >

			<div class="col-xs-6 col-md-3">
				<div class="text-center" >
				 	<h3>Da clic en el logo para ver las campañas del programa</h3>					
				</div>
			</div>

		</div>
	
				
		<div class="row" style="margin-left: 10px;" data-ng-controller="getClassifications">

			<div class="col-xs-6 col-md-2">

			<br>

			<div class="col-xs-6 col-md-3" ng-repeat="class in classifications">
					<a href="#" data-ng-click="selectClassification(class)" ui-sref="campaigns" 
						class="hvr-glow" style="border: 1px solid #bfbfbf;border-radius: 10px;">
					</a>
			</div>
				
			</div>
			


		</div>
		

	<a href="#contact" class="btn btn-circle page-scroll" style="position: fixed;right: 0px;top:400px;border: 0px;"> 
		<i class="fa fa-circle animated" style="margin-top: 12px;"></i>
	</a>
	
	<a href="#transaction" class="btn btn-circle page-scroll" style="position: fixed;right: 0px;top:340px;border: 0px;"> 
		<i class="fa fa-circle animated" style="margin-top: 12px;"></i>
	</a>
	
	<a href="#banner" class="btn btn-circle page-scroll" style="position: fixed;right: 0px;top:280px;border: 0px;"> 
		<i class="fa fa-circle animated" style="margin-top: 12px;"></i>
	</a>
	
</header>



</section>

<section id="transaction">

<br><br><br>


	<div>

		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<h2 class="text-center color-default-ford" style="font-weight: bold; font-size: 40px;">
					REPORTE DE MOVIMIENTOS
				</h2>
				
				<br>
				
<!-- 				<h4 class="text-center color-gray-ford">  -->
<!-- 				Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.  -->
<!-- 				Donec ullamcorper nulla non metus auctor fringilla. Duis mollis, est non commodo luctus,  -->
<!-- 				nisi erat porttitor ligula, eget lacinia odio sem nec elit. Donec  -->
<!-- 				ullamcorper nulla non metus auctor fringilla. -->
<!-- 				</h4> -->
				
<!-- 				<br><br><br> -->
				
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
							<h4 style="color:rgb(255,255,255)"> ¿DUDAS SOBRE EL PROGRAMA <br>DE INCENTIVOS?</h4>
						</div>
			</div>
			<div class="col-xs-6 col-md-2"></div>

		</div>

		<div class="row">

			<div class="col-xs-6 col-md-3"></div>
			<div class="col-xs-6 col-md-6">
				<div class="text-center">
					<h5 style="color:rgb(180,180,180)">
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
							<h4 style="color:rgb(255,255,255)">
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
					<h5 style="color:rgb(180,180,180)">
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
  			<div class="col-md-6"><h5 class="text-center" style="color:rgb(255,255,255)">Programa 
  										administrado por Sí Vale 
  										México, S.A. de C.V. 2016 ©
  								  </h5>
  			</div>
 			<div class="col-md-3"></div>

		</div>
		
	</div>
           
    </section>