<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<div class="container" style="padding: 0px;">	
	<br>
	<div class="row">
		<div class="col-md-6">
		<!-- 	FORD CREDIT -->
			<div class="jumbotron" ng-if="userStatus.tjCodigoProcedencia==3" style="background-color: white;">
				<h3 style="text-align: center;">
					<strong>Datos participante: </strong>
				</h3>
				<br>
				<br>
				<div class="row">
					<div class="col-md-6 text-right">
						<strong>Nombre:</strong>
					</div>
					<div class="col-md-6">{{userStatus.firstName}}
						{{userStatus.lastName1}} {{userStatus.lastName1}}</div>
				</div>
				<br>
				<div class="row">
					<div class="col-md-6 text-right">
						<strong>BID:</strong>
					</div>
					<div class="col-md-6">{{userStatus.tjBid}}</div>
				</div>
				<br>
				<div class="row">
					<div class="col-md-6 text-right">
						<strong>Razón Social :</strong>
					</div>
					<div class="col-md-6">{{userStatus.tjRazonSocial}}</div>
				</div>
				<br>
				<div class="row">
					<div class="col-md-6 text-right">
						<strong>Clave STARS:</strong>
					</div>
					<div class="col-md-6">{{userStatus.tjStars}}</div>
				</div>
				<br>
				<div class="row">
					<div class="col-md-6 text-right">
						<strong>Tarjeta Activa:</strong>
					</div>
					<div class="col-md-6">{{userStatus.tjCardNumber}}</div>
				</div>
				<br>
				<div class="row">
					<div class="col-md-6 text-right">
						<strong>Acuse Ford Credit:</strong>
					</div>
					<div class="col-md-6">
						<span ng-if="userStatus.tjAcuseFordCredit==true">SÍ</span> <span
							ng-if="userStatus.tjAcuseFordCredit==false || userStatus.tjAcuseFordCredit==null">NO</span>
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-md-6 text-right">
						<strong>eCAPS:</strong>
					</div>
					<div class="col-md-6">{{userStatus.tjEcaps}}</div>
				</div>
				<br>
				<div class="row">
					<div class="col-md-6 text-right">
						<strong>Carta doble perfil:</strong>
					</div>
					<div class="col-md-6">
						<span ng-if="userStatus.tjCartaDoblePerfil==true">SÍ</span> <span
							ng-if="userStatus.tjCartaDoblePerfil==false || userStatus.tjCartaDoblePerfil==null">NO</span>
					</div>
				</div>
			</div>

			<div class="jumbotron" ng-if="userStatus.tjCodigoProcedencia==2" style="background-color: white;">
				<h3 style="text-align: center;">
					<strong>Datos participante: </strong>
				</h3>
				<br>
				<br>
				<div class="row">
					<div class="col-md-6 text-right">
						<strong>Nombre:</strong>
					</div>
					<div class="col-md-6">{{userStatus.firstName}}
						{{userStatus.lastName1}} {{userStatus.lastName1}}</div>
				</div>
				<br>
				<div class="row">
					<div class="col-md-6 text-right">
						<strong>BID:</strong>
					</div>
					<div class="col-md-6">{{userStatus.tjBid}}</div>
				</div>
				<br>
				<div class="row">
					<div class="col-md-6 text-right">
						<strong>Razón Social :</strong>
					</div>
					<div class="col-md-6">{{userStatus.tjRazonSocial}}</div>
				</div>
				<br>
				<div class="row">
					<div class="col-md-6 text-right">
						<strong>Clave STARS:</strong>
					</div>
					<div class="col-md-6">{{userStatus.tjStars}}</div>
				</div>
				<br>
				<div class="row">
					<div class="col-md-6 text-right">
						<strong>Tarjeta Activa:</strong>
					</div>
					<div class="col-md-6">{{userStatus.tjCardNumber}}</div>
				</div>
				<br>
				<div class="row">
					<div class="col-md-6 text-right">
						<strong>Identificación:</strong>
					</div>
					<div class="col-md-6">
						<span ng-if="userStatus.tjIdentificacion==true">SÍ</span> <span
							ng-if="userStatus.tjIdentificacion==false || userStatus.tjIdentificacion==null">NO</span>
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-md-6 text-right">
						<strong>Acuse Ford:</strong>
					</div>
					<div class="col-md-6">
						<span ng-if="userStatus.tjAcuseFordLincoln==true">SÍ</span> <span
							ng-if="userStatus.tjAcuseFordLincoln==false || userStatus.tjAcuseFordLincoln==null">NO</span>
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-md-6 text-right">
						<strong>Inscrito en el programa:</strong>
					</div>
					<div class="col-md-6">
						<span ng-if="userStatus.tjInscritoEnPrograma==true">SÍ</span> <span
							ng-if="userStatus.tjInscritoEnPrograma==false || userStatus.tjInscritoEnPrograma==null">NO</span>
					</div>
				</div>
			</div>

			<!-- 	FORD VENTAS -->


			<div class="jumbotron" ng-if="userStatus.tjCodigoProcedencia==1" style="background-color: white;">
				<h3 style="text-align: center;">
					<strong>Datos participante: </strong>
				</h3>
				<br>
				<br>
				<div class="row">
					<div class="col-md-6 text-right">
						<strong>Nombre:</strong>
					</div>
					<div class="col-md-6">{{userStatus.firstName}}
						{{userStatus.lastName1}} {{userStatus.lastName1}}</div>
				</div>
				<br>
				<div class="row">
					<div class="col-md-6 text-right">
						<strong>BID:</strong>
					</div>
					<div class="col-md-6">{{userStatus.tjBid}}</div>
				</div>
				<br>
				<div class="row">
					<div class="col-md-6 text-right">
						<strong>Razón Social :</strong>
					</div>
					<div class="col-md-6">{{userStatus.tjRazonSocial}}</div>
				</div>
				<br>
				<div class="row">
					<div class="col-md-6 text-right">
						<strong>Clave STARS:</strong>
					</div>
					<div class="col-md-6">{{userStatus.tjStars}}</div>
				</div>
				<br>
				<div class="row">
					<div class="col-md-6 text-right">
						<strong>Tarjeta Activa:</strong>
					</div>
					<div class="col-md-6">{{userStatus.tjCardNumber}}</div>
				</div>
				<br>
				<div class="row">
					<div class="col-md-6 text-right">
						<strong>Acuse Ford:</strong>
					</div>
					<div class="col-md-6">
						<span ng-if="userStatus.tjAcuseFordLincoln==true">SÍ</span> <span
							ng-if="userStatus.tjAcuseFordLincoln==false || userStatus.tjAcuseFordLincoln==null">NO</span>
					</div>
				</div>
				<br>
				<br>
			</div>

		</div>
		<div class="col-md-6">
			<div class="jumbotron" style="background-color: white;">
			<br><br><br><br>
			<h3 style="text-align: center;"><strong>Estatus participante: </strong></h3>
			<br><br>
				<div class="row">
					<div class="col-md-12 text-center"><strong>{{userStatus.tjEstatusGeneral}}</strong></div>
				</div>
			</div>
		</div>
	</div>


	<div class="container" data-ng-controller="getUserStatus" style="padding: 0px 300px;">
<!-- 	<div class="jumbotron"> -->
<!-- 			<div class="row"> -->
<!-- 				<div class="col-md-1"></div> -->
<!-- 				<div class="col-md-4 text-right">Nombre:</div> -->
<!-- 				<div class="col-md-7">{{userStatus.firstName}} {{userStatus.lastName1}} {{userStatus.lastName1}}</div> -->
<!-- 			</div> -->
<!-- 			<br> -->
<!-- 			<div class="row"> -->
<!-- 				<div class="col-md-1"></div> -->
<!-- 				<div class="col-md-4 text-right">BID:</div> -->
<!-- 				<div class="col-md-7">{{userStatus.tjBid}}</div> -->
<!-- 			</div> -->
<!-- 			<br> -->
<!-- 			<div class="row"> -->
<!-- 				<div class="col-md-1"></div> -->
<!-- 				<div class="col-md-4 text-right">Razón Social :</div> -->
<!-- 				<div class="col-md-7">{{userStatus.tjRazonSocial}}</div> -->
<!-- 			</div> -->
<!-- 			<br> -->
<!-- 			<div class="row"> -->
<!-- 				<div class="col-md-1"></div> -->
<!-- 				<div class="col-md-4 text-right">Tarjeta Activa:</div> -->
<!-- 				<div class="col-md-7">{{userStatus.tjCardNumber}}</div> -->
<!-- 			</div> -->
<!-- 			<br> -->
<!-- 			<div class="row"> -->
<!-- 				<div class="col-md-1"></div> -->
<!-- 				<div class="col-md-4 text-right">Identificación:</div> -->
<!-- 				<div  class="col-md-7"> -->
<!-- 					<span ng-if="userStatus.tjIdentificacion==true">SÍ</span> -->
<!-- 					<span ng-if="userStatus.tjIdentificacion==false || userStatus.tjIdentificacion==null">NO</span>	 -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<br> -->
<!-- 			<div class="row"> -->
<!-- 				<div class="col-md-1"></div> -->
<!-- 				<div class="col-md-4 text-right">Acuse Ford:</div> -->
<!-- 				<div class="col-md-7"> -->
<!-- 					<span ng-if="userStatus.tjAcuseFordLincoln==true">SÍ</span> -->
<!-- 					<span ng-if="userStatus.tjAcuseFordLincoln==false || userStatus.tjAcuseFordLincoln==null">NO</span> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<br> -->
<!-- 			<div class="row"> -->
<!-- 				<div class="col-md-1"></div> -->
<!-- 				<div class="col-md-4 text-right">Inscrito en el programa:</div> -->
<!-- 				<div class="col-md-7"> -->
<!-- 					<span ng-if="userStatus.tjInscritoEnPrograma==true">SÍ</span> -->
<!-- 					<span ng-if="userStatus.tjInscritoEnPrograma==false || userStatus.tjInscritoEnPrograma==null">NO</span> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<br> -->
<!-- 			<div class="row"> -->
<!-- 				<div class="col-md-1"></div> -->
<!-- 				<div class="col-md-4 text-right">Acuse Ford Credit:</div> -->
<!-- 				<div class="col-md-7"> -->
<!-- 					<span ng-if="userStatus.tjAcuseFordCredit==true">SÍ</span> -->
<!-- 					<span ng-if="userStatus.tjAcuseFordCredit==false || userStatus.tjAcuseFordCredit==null">NO</span> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<br> -->
<!-- 			<div class="row"> -->
<!-- 				<div class="col-md-1"></div> -->
<!-- 				<div class="col-md-4 text-right">eCaps:</div> -->
<!-- 				<div class="col-md-7">{{userStatus.tjEcaps}}</div> -->
<!-- 			</div> -->
<!-- 			<br> -->
<!-- 			<div class="row"> -->
<!-- 				<div class="col-md-1"></div> -->
<!-- 				<div class="col-md-4 text-right">Carta doble perfil:</div> -->
<!-- 				<div class="col-md-7"> -->
<!-- 					<span ng-if="userStatus.tjCartaDoblePerfil==true">SÍ</span> -->
<!-- 					<span ng-if="userStatus.tjCartaDoblePerfil==false || userStatus.tjCartaDoblePerfil==null">NO</span> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 	</div> -->
	
		
		
					<!-- 	FORD SERVIVIO -->
	

			
</div>
</div>






