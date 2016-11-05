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
				
				<div class="col-md-3">
					
				</div>
				
				<div class="col-md-5">
				
				</div>
				
				</div>
			</div>

			<div class="panel-body back-sivale">
			
				<div data-ng-controller="getCampaign" ng-cloak>
					<table ng-table="tablePublications" class="table">
						<tr ng-repeat="publication in $data">
							
							<td title="'Compañia'" header-class="'text-left'"
								sortable="'name'"></td>

							<td title="'Programa'" header-class="'text-left'"
								sortable="'publishedDate'"></td>
								
							<td title="'Subprograma'" header-class="'text-left'"
								sortable="'publishedDate'"></td>
								
							<td title="'Unidad de Negocio'" header-class="'text-left'"
								sortable="'publishedDate'"></td>
							
							<td title="'N4'" header-class="'text-left'"
								sortable="'publishedDate'"></td>
								
							<td title="'Campaña'" header-class="'text-left'"
								sortable="'publishedDate'"></td>		
							
							<td title="'Fecha Inicio'" header-class="'text-left'"
								sortable="'publishedDate'"></td>
								
							<td title="'Fecha Fin'" header-class="'text-left'"
								sortable="'publishedDate'"></td>
								
							<td title="'Movimientos'" header-class="'text-left'"
								sortable="'publishedDate'"></td>
								
							<td title="'Monto'" header-class="'text-left'"
								sortable="'publishedDate'"></td>
								
						</tr>
					</table>
				</div>
				
				<hr>
				
				<div class="navbar padding15">

					<div class="row">
					
						<div class="col-sm-3">
							<h5><strong>Total ganado: </strong></h5>
						</div>
						
						<div class="col-sm-3">
							<h5><strong>Total pagado: </strong></h5>
						</div>
						
						<div class="col-sm-3">
							<h5><strong>Pendiente: </strong></h5>
						</div>
						
						<div class="col-sm-3">
							<h5><strong>Observaciones: </strong></h5>
						</div>
						
					</div>


					<button type="button" class="btn btn-primary"
						ui-sref="campaign">

						<i class="fa fa-list-alt " aria-hidden="true"></i> <span
							aria-hidden="true"></span>Salir
					</button>

				</div>
				
			</div>
			
		</div>
	</div>
</div>