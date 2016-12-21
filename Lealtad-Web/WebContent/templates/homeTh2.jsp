<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	
<section id="banner">

<!-- <header > -->
	

<!-- 	<br><br> -->
	
<!-- 		<div class="row" > -->

<!-- 			<div class="col-xs-6 col-md-3"> -->
<!-- 				<div class="text-center" > -->
<!-- 				 	<h3>Promociones en las que participas</h3>					 -->
<!-- 				</div> -->
<!-- 			</div> -->

<!-- 		</div> -->
	
<!-- 		<br> -->
				
<!-- 		<div class="row"  data-ng-controller="getClassifications"> -->

<!-- 			<div class="col-xs-6 col-md-2"> -->

<!-- 			<div class="col-xs-6 col-md-3" ng-repeat="class in classifications" style="margin-left: 80px;"> -->
<!-- 					<a href="#" data-ng-click="selectClassification(class)" ui-sref="campaigns"  -->
<!-- 						class="hvr-glow" style="border: 1px solid #bfbfbf;border-radius: 10px;"> -->
<!-- <!-- 						<img ng-src="img/company_logo/{{class.catViews.logos}}/header.png" style="border: 0; float: left;max-width: 200px;"  --> -->
<!-- <!-- 						/> --> -->
<!-- 						{{class.catViews.messages}} -->
<!-- 					</a> -->
<!-- 			</div> -->
				
<!-- 			</div> -->
			
<!-- 		</div> -->

<!-- <!-- 	<a href="#contact" class="btn btn-circle page-scroll" style="position: fixed;right: 0px;top:400px;border: 0px;">  --> -->
<!-- <!-- 		<i class="fa fa-circle animated" style="margin-top: 12px;"></i> --> -->
<!-- <!-- 	</a> --> -->
	
<!-- <!-- 	<a href="#transaction" class="btn btn-circle page-scroll" style="position: fixed;right: 0px;top:340px;border: 0px;">  --> -->
<!-- <!-- 		<i class="fa fa-circle animated" style="margin-top: 12px;"></i> --> -->
<!-- <!-- 	</a> --> -->
	
<!-- <!-- 	<a href="#banner" class="btn btn-circle page-scroll" style="position: fixed;right: 0px;top:280px;border: 0px;">  --> -->
<!-- <!-- 		<i class="fa fa-circle animated" style="margin-top: 12px;"></i> --> -->
<!-- <!-- 	</a> --> -->
	
<!-- </header> -->

	<header>
		<br><br><br>
		<div class="row">
		
			<div class="col-md-4">
				<p style="padding-left: 30px;">
					<button type="button" class="btn btn-home btn-lg" style="padding: 10px 70px;cursor: default;">Promocionesen las que participas
						
						<i class="fa fa-star-o" aria-hidden="true" style="vertical-align: middle; padding-left: 30px;font-size: 30px;"></i>
						
					</button>
				</p>
			</div>
			
			<div class="col-md-3">
			
			</div>
			
			<div class="col-md-4" data-ng-controller="getBalance">
				<p style="padding-left: 30px;">
					<button type="button" class="btn btn-primary btn-lg"
						style="padding: 30px 70px; background-color: rgb(4, 160, 123);cursor: default;min-width: 450px;">
						
						<i class="fa fa-credit-card" aria-hidden="true" style="vertical-align: middle; padding-left: -30px;font-size: 30px;"></i>
						
						Saldo en tu Tarjeta: &#36; {{(balance | number:2) || '0.00'}}
						
					</button>
				</p>
			</div>
			
		</div>
		<br>
		
		<div class="row" data-ng-controller="getClassifications">
			<div class="col-md-4">
			
				<div class="col-xs-6 col-md-6" ng-repeat="class in classifications"
					style="margin-left: 10px;">
					<a href="#" data-ng-click="selectClassification(class)"
						ui-sref="campaigns" class="hvr-glow"
						style="border: 1px solid #bfbfbf; border-radius: 10px;">
						<b>{{class.catViews.messages}} </b></a>
				</div>
			
			</div>
			
			<div class="col-md-3">
			
			</div>
			
			<div class="col-md-4">
				<p style="padding-left: 30px;">
					<button type="button" ui-sref="account_status" class="btn btn-primary btn-lg"
						style="padding: 30px 70px; background-color: rgb(4, 160, 123);min-width: 450px;">
						
						<i class="fa fa-line-chart" aria-hidden="true" style="vertical-align: middle; padding-left: -30px;font-size: 30px;"></i>
						
						
						Consulta tu estado de Cuenta
						
					</button>
				</p>
			</div>
			
		</div>
		
		
<!-- 		<div class="row" data-ng-controller="getClassifications"> -->
<!-- 			<div class="col-xs-6 col-md-2"> -->

<!-- 				<div class="col-xs-6 col-md-3" ng-repeat="class in classifications" -->
<!-- 					style="margin-left: 80px;"> -->
<!-- 					<a href="#" data-ng-click="selectClassification(class)" -->
<!-- 						ui-sref="campaigns" class="hvr-glow" -->
<!-- 						style="border: 1px solid #bfbfbf; border-radius: 10px;"> -->
<!-- 						{{class.catViews.messages}} </a> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</div> -->
	</header>


</section>

<section id="transaction">

<br><br><br>


	<div>
	
<!-- 		<div class="row"> -->
<!-- 			<div class="col-md-3"></div> -->
<!-- 			<div class="col-md-6"> -->
				
<!-- 				<button type="button" ui-sref="account_status" class="btn btn-default btn-lg btn-block" style="border-color: rgb(63, 111, 183);color: rgb(63, 111, 183);font-size: 20px;font-weight: bold;">  -->
<!-- 					Consulta tu Estado de Cuenta aquí  -->
					
<!-- 					<i class="fa fa-list-alt" aria-hidden="true" style="vertical-align: middle; padding-left: 30px;font-size: 50px;""></i> -->
<!-- 				</button> -->
				
<!-- 				<br> -->
<!-- 				<br> -->
				
<!-- 			</div> -->
<!-- 			<div class="col-md-3"></div> -->
<!-- 		</div> -->

		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<h2 class="text-center color-default-ford" style="font-weight: bold; font-size: 40px;">
					Movimientos de mi Tarjeta
				</h2>
				
				<br>				
			</div>
			<div class="col-md-2"></div>
		</div>
		
		<br><br>

<!-- 		<div class=" font-color-text"> -->
<!-- 			<div class="row"> -->

<!-- 				<div class="col-lg-6-user-email col-md-7"> -->
<!-- 					<div> -->
<!-- 						<div> -->
<!-- 							<div class="row"> -->

<!-- 								<div class="col-xs-6 col-sm-4"></div> -->

<!-- 								<div class="col-xs-6 col-sm-1"> -->
<!-- 									<i class="fa fa-user fa-5x color-default-ford" aria-hidden="true"></i> -->
<!-- 								</div> -->

<!-- 								<div class="col-xs-6 col-sm-5"> -->

<!-- 									<div class="font-title-item">Nombre de Usuario</div> -->
<!-- 									<div id="quickfit-user" -->
<%-- 										title="${sessionScope.userDetails.userName}" class="huge">{{user.firstName}} --%>
<!-- 										{{user.lastName1}} {{user.lastName2}}</div> -->
<!-- 								</div> -->

<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 				</div> -->

<!-- 				<div class="col-lg-6-user-email col-md-5"> -->
<!-- 					<div> -->
<!-- 						<div data-ng-controller="getBalance"> -->
<!-- 							<div class="row"> -->

<!-- 								<div class="col-xs-6 col-sm-1"></div> -->

<!-- 								<div class="col-xs-6 col-sm-1"> -->
<!-- 									<i class="fa fa-usd fa-5x color-default-ford" aria-hidden="true"></i> -->
<!-- 								</div> -->

<!-- 								<div class="col-xs-6 col-sm-7"> -->

<!-- 									<div class="font-title-item ">Saldo Actual</div> -->
<!-- 									<div class="huge">&#36;{{(balance | number:2) || '0.00'}}</div> -->

<!-- 								</div> -->

<!-- 								<div class="col-xs-6 col-sm-1"></div> -->

<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 				</div> -->

<!-- 			</div> -->
<!-- 		</div> -->

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
  			<div class="col-md-6"><h5 class="text-center" style="color:rgb(255,255,255)">Plataforma elaborada y administrada 
							por Sí Vale México, S.A. de C.V., para uso exclusivo de Ford Motor Company de México, 
							S.A. de C.V. y sus filiales. Copyright ©2016 Ford Motor Company. 
  								  </h5>
  			</div>
 			<div class="col-md-3"></div>

		</div>
		
	</div>
           
    </section>