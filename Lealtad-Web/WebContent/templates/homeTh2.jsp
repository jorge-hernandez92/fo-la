<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	
<section id="banner">

	<header>
	
		<br><br>
		
<!-- 		<div class="row"  data-ng-controller="getClassifications"> -->

<!-- 			<div class="col-xs-6 col-md-2"> -->

<!-- 			<br> -->

<!-- 			<div class="col-xs-6 col-md-3" ng-repeat="class in classifications"> -->
<!-- 					<a href="#" data-ng-click="selectClassification(class)" ui-sref="campaigns"  -->
<!-- 						class="hvr-glow" style="border: 1px solid #bfbfbf;border-radius: 10px;"> -->
<!-- 						<img ng-src="img/company_logo/{{class.catViews.logos}}/logo_b.png" style="border: 0; float: left;max-width: 200px;" /> -->
<!-- 					</a> -->
<!-- 			</div> -->
				
<!-- 			</div> -->
			
<!-- 		</div> -->
		
		
		<br><br>

		<div class="row">

			<div class="col-md-7">
				<p style="padding-left: 30px;padding-top: 40px;">
					<button type="button" class="btn btn-primary"
						style="cursor: default;font-size: 20px;color: black;background-color: #d2d2d2;border-color: #d2d2d2;min-width: 300px;">
						<b>Campañas activas </b>
					</button>
				</p>
			</div>

			<div class="col-md-5">
				<a href="#" data-toggle="modal" data-target="#myModal2"
					class="hvr-glow"
					style="border-radius: 10px; font-size: 20px; color: black;padding: 5px;"> <b>Conoce
						más sobre los programas aquí </b> <i class="fa fa-question-circle fa-3x"
					aria-hidden="true" style="color: #04a07b;"></i>

				</a>

			</div>

		</div>


		<div class="container-fluid">
			<div class="panel panel-default">
				<div class="panel-body">
					<div data-ng-controller="getCampaignsByCompany" ng-cloak>
						<table ng-table="tableCampaignByCompany" class="table">
							<tr ng-repeat="campaignsByCom in $data">

								<td title="'Nombre de Incentivo'" header-class="'text-left'">
								
									<b><a href="" data-ng-click="updateCampaign(campaignsByCom)" ui-sref="campaign">{{campaignsByCom.campaignName}}</a></b>
								
								</td>

								<td title="'Clasificación'" header-class="'text-left'">
									<span class="label label-primary" style="font-size: 100%;">{{campaignsByCom.classification[0]}}</span>
									<span class="label label-primary" style="font-size: 100%;">{{campaignsByCom.classification[1]}}</span>
									<span class="label label-primary" style="font-size: 100%;">{{campaignsByCom.classification[2]}}</span>
									<span class="label label-primary" style="font-size: 100%;">{{campaignsByCom.classification[3]}}</span>
								
								</td>

								<td title="'Inicio'" header-class="'text-left'">{{campaignsByCom.startDate | date:'dd/MM/yyyy'}}</td>

								<td title="'Fin'" header-class="'text-left'">{{campaignsByCom.endDate | date:'dd/MM/yyyy'}}</td>

							</tr>
						</table>
					</div>

				</div>
			</div>
		</div>

		<div class="row">

			<div class="col-md-6" >
				<p style="padding-left: 160px;">
					<button type="button" ui-sref="account_status" class="btn btn-home btn-lg"
						style="padding: 25px 0px;min-width: 450px;font-size: 18px;">
						
						<i class="fa fa-line-chart" aria-hidden="true" style="vertical-align: middle; padding-left: -30px;font-size: 45px;"></i>
						
						Consulta tu estado <br/>de Cuenta<br/>
						
					</button>
				</p>

			</div>

			<div class="col-md-5" data-ng-controller="getBalance">

				<p style="padding-left: 70px;">
					<button type="button" class="btn btn-home btn-lg"
						style="padding: 25px 0px; cursor: default; min-width: 450px; background-color: #04a07b;">

						<i class="fa fa-credit-card" aria-hidden="true"
							style="vertical-align: middle; padding-left: -30px; font-size: 45px;"></i>

						Saldo en tu Tarjeta<br />&#36; {{(balance | number:2) || '0.00'}}<br />

					</button>
				</p>

			</div>

		</div>
		
		<br><br><br>
		<br>
		
	</header>

</section>

<section id="transaction">

	<div>

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