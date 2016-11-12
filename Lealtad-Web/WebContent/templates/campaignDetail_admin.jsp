<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>

<div class="panel-body back-sivale">
	<div class="container">
		<div class="panel panel-grisT table-top-sivale">
			<div class="panel-heading">
				<div class="row">
				<div class="col-md-4">
					<div class="navbar-header" style="font-family: cursive;font-size: 17px;">{{campaign.campaignName}}</div>

				</div>
				<div class="col-md-3">
					
					<button type="button" class="btn btn-primary" ui-sref="updateCampaign">
  							
  							<i class="fa fa-pencil" aria-hidden="true"></i>
  							
  							<span aria-hidden="true"></span>Editar Campaña
  							
					</button>
					
				</div>
				<div class="col-md-5" style="font-family: cursive;font-size: 17px;">
					Duración {{campaign.startDate | date:'dd/MM/yyyy'}} al {{campaign.endDate | date:'dd/MM/yyyy'}}
				</div>
				</div>
			</div>

			<div class="panel-body back-sivale">
				<div data-ng-controller="getCampaign" ng-cloak>
					<table ng-table="tablePublications" class="table">
						<tr ng-repeat="publication in $data">
							
							<td title="'Tipo'" header-class="'text-left'"
								sortable="'name'"><span class="label label-default">{{publication.catPublicationType.name}}</span></td>
							
							<td title="'Publicación'" header-class="'text-left'"
								sortable="'name'">{{publication.name}}</td>

							<td title="'Fecha de Publicación'" header-class="'text-left'"
								sortable="'publishedDate'">{{publication.publishedDate | date:'dd/MM/yyyy'}}</td>

							<td><a href="#" ui-sref="publication" data-ng-click="updatePublication(publication)"
							>Visualizar</a>
								
							<td><a href="#"
								data-ng-click="updatePublication(publication)"
								ui-sref="updatePublication">Editar</a>
							
							<td title="'Activar'" header-class="'text-left'">
								<input ng-model="publication.isEnable"
								name="{{publication.publicationId}}" type="checkbox" ng-change="updateStatusPublication(publication)"
								toggle-btn on-type="warning">
								
								
						</tr>
					</table>
				</div>
				
				<div class="navbar-right padding15">
					
					<button type="button" class="btn btn-primary"
						ui-sref="newPublication">

						<i class="fa fa-plus" aria-hidden="true"></i> <span
							aria-hidden="true"></span>Añadir Publicación
					</button>
				
					<button type="button" class="btn btn-primary"
						ui-sref="uploadRMFile">

						<i class="fa fa-plus" aria-hidden="true"></i> <span
							aria-hidden="true"></span>Añadir Reporte de Movimientos
					</button>
					
				</div>
				
			</div>
		</div>
	</div>
</div>