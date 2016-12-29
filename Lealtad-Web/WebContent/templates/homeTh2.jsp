<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	
<section id="banner">

	<header>
		<br><br><br>
		<div class="row">
		
			<div class="col-md-4">
				<p style="padding-left: 30px;">
					<button type="button" class="btn btn-primary btn-lg" style="cursor: default;background-color: #3f6fb7;font-size: 28px;color: black;">Promocionesen las que participas
						<i class="fa fa-star-o" aria-hidden="true" style="vertical-align: middle; padding-left: 30px;font-size: 45px;"></i>
					</button>
				</p>
			</div>
			
			<div class="col-md-3">
			
			</div>
			
			<div class="col-md-4" data-ng-controller="getBalance">
				<p style="padding-left: 30px;">
					<button type="button" class="btn btn-home btn-lg"
						style="padding: 30px 0px; cursor: default;min-width: 450px;background-color: #04a07b;">
						
						<i class="fa fa-credit-card" aria-hidden="true" style="vertical-align: middle; padding-left: -30px;font-size: 45px;"></i>
						
						Saldo en tu Tarjeta<br/>&#36; {{(balance | number:2) || '0.00'}}<br/>
						
					</button>
				</p>
			</div>
			
		</div>
		<br>
		
		<div class="row" data-ng-controller="getClassifications">
			<div class="col-md-4">
			
				<div class="col-xs-6 col-md-6" ng-repeat="class in classifications" style="margin-left: 10px;">
					<a href="#" data-ng-click="selectClassification(class)"
						ui-sref="campaigns" class="hvr-glow"
						style="border: 1px solid #bfbfbf; border-radius: 10px;font-size: 20px;color: black;">
						<b>{{class.catViews.messages}} </b></a>
				</div>
			
			</div>
			
			<div class="col-md-3">
			
			</div>
			
			<div class="col-md-4">
				<p style="padding-left: 30px;">
					<button type="button" ui-sref="account_status" class="btn btn-home btn-lg"
						style="padding: 30px 0px;min-width: 450px;font-size: 18px;">
						
						<i class="fa fa-line-chart" aria-hidden="true" style="vertical-align: middle; padding-left: -30px;font-size: 45px;"></i>
						
						Consulta tu estado <br/>de Cuenta<br/>
						
					</button>
				</p>
			</div>
			
		</div>
		
	</header>


</section>



<section id="transaction">

<br><br><br><br>

	<div>
		<div class="row">
		<div class="col-md-6" style="margin-left: 25px;">
			<a href="#" data-toggle="modal" data-target="#myModal2"
						 class="hvr-glow"
						style="border-radius: 10px;font-size: 28px;color: black;">
						<b>Conoce más sobre los programas aquí </b>
						<i class="fa fa-question-circle" aria-hidden="true" style="vertical-align: middle; padding-left: -30px;font-size: 45px;"></i>
						
						</a>
		</div></div>
		
		<hr style="border-top: 20px solid rgb(63, 111, 183);">

		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<h2 class="text-center color-default-ford" style="font-weight: bold; font-size: 35px;">
					Movimientos de mi Tarjeta
				</h2>
				
				<br>				
			</div>
			<div class="col-md-2"></div>
		</div>
		
		<br><br>

		<div class="container font-color-text" style="width: 1170px;" ng-cloak >
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
  			<div class="col-md-6"><h5 class="text-center" style="color:rgb(255,255,255)">Plataforma elaborada y administrada 
							por Sí Vale México, S.A. de C.V., para uso exclusivo de Ford Motor Company de México, 
							S.A. de C.V. y sus filiales. Copyright ©2016 Ford Motor Company. 
  								  </h5>
  			</div>
 			<div class="col-md-3"></div>

		</div>
		
	</div>
           
    </section>