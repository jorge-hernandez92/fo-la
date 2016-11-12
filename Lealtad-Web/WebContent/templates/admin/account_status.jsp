<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>

<div class="panel-body back-sivale">
	<div class="container" style="width: 1300px;">
		<div class="panel panel-grisT table-top-sivale">
			<div class="panel-heading">
				<div class="row">
				<div class="col-md-4">
					<div class="navbar-header" style="font-family: cursive;font-size: 17px;">Estado de Cuenta</div>

				</div>
				
				<div class="col-md-4">
					
				</div>
				
				<div class="col-md-4">
				
					<button  ng-click="getRMPending()" type="button" class="btn btn-primary">

						<i class="fa fa-list-alt " aria-hidden="true"></i> <span
							aria-hidden="true"></span>Pendientes
					</button>
					
					<button ng-click="getRMNoPending()" type="button" class="btn btn-primary">

						<i class="fa fa-list-alt " aria-hidden="true"></i> <span
							aria-hidden="true"></span>Sin Pendientes
					</button>
				
					<button type="button" class="btn btn-primary"
						ui-sref="home">

						<i class="fa fa-list-alt " aria-hidden="true"></i> <span
							aria-hidden="true"></span>Salir
					</button>
				</div>
				
				</div>
			</div>

			<div class="panel-body back-sivale">
			
				<div data-ng-controller="getRM" ng-cloak>
					<table ng-table="tableRM" class="table">
						<tr ng-repeat="rms in $data">
							
							<td title="'Compañia'" header-class="'text-left'"
								sortable="'name'">{{rms.compania}}</td>

<!-- 							<td title="'Programa'" header-class="'text-left'" -->
<!-- 								sortable="'programa'">{{rms.programa}}</td> -->
								
<!-- 							<td title="'Subprograma'" header-class="'text-left'" -->
<!-- 								sortable="'subprograma'">{{rms.subprograma}}</td> -->
								
							<td title="'Unidad de Negocio'" header-class="'text-left'"
								sortable="'publishedDate'">{{rms.unidadDeNegocio}}</td>
							
<!-- 							<td title="'N4'" header-class="'text-left'" -->
<!-- 								sortable="'publishedDate'">{{rms.N4}}</td> -->
								
							<td title="'Campaña'" header-class="'text-left'"
								sortable="'nombreCampaign'">{{rms.campaignName}}</td>
								
							<td title="'Participante'" header-class="'text-left'"
								sortable="'participante'">{{rms.idStars}}</td>
								
							<td title="'Nombre'" header-class="'text-left'"
								sortable="'nombre'">{{rms.nombre}}</td>
								
							<td title="'BID'" header-class="'text-left'"
								sortable="'bid'">{{rms.bid}}</td>	
							
							<td title="'Fecha Inicio'" header-class="'text-left'"
								sortable="'startDate'">{{rms.startDate | date:'dd/MM/yyyy'}}</td>
								
							<td title="'Fecha Fin'" header-class="'text-left'"
								sortable="'endDate'">{{rms.endDate | date:'dd/MM/yyyy'}}</td>
								
							<td title="'Movimientos'" header-class="'text-left'"
								sortable="'movements'">{{rms.movements}}</td>
								
							<td title="'Monto'" header-class="'text-left'"
								sortable="'monto'">{{rms.monto}}</td>
								
							<td title="'Observaciones'" header-class="'text-left'"
								sortable="'monto'">{{rms.observaciones}}</td>
								
						</tr>
					</table>
				</div>
				
				<hr>
				
				<div class="navbar padding15">

					<div class="row">
					
						<div class="col-sm-2"></div>
						
						<div class="col-sm-2"></div>
						
						<div class="col-sm-2"></div>
					
						<div class="col-sm-2">
							<h5><strong>Total ganado: {{ganado}}</strong></h5>
						</div>
						
						<div class="col-sm-2">
							<h5><strong>Total pagado: {{pagado}}</strong></h5>
						</div>
						
						<div class="col-sm-2">
							<h5><strong>Pendiente: {{pendiente}}</strong></h5>
						</div>
						
					</div>

				</div>
				
			</div>
			
		</div>
	</div>
</div>