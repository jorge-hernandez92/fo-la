<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<div class="navbar">
	<ol class="breadcrumb breadcrumb-arrow">
		<li class="active"><span>Inicio</span></li>
	</ol>
</div>

<div class="panel panel-default table-top-sivale">
	<!-- Default panel contents -->
	<div class="panel-heading">
		<div class="container-fluid">
			<div class="navbar-header">Mis clasificaciones de Incentivo</div>
		</div>
	</div>

	<div class="input-group">
		<div class="input-group-addon">
			<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
		</div>
		<input class="form-control" type="text"
			data-ng-model="filters.myfilter" placeholder="Buscar Clasificación" />
	</div>

	<div class="panel-body">
		<div data-ng-controller="getClassifications" ng-cloak>
			<table ng-table="tableClassifications" class="table">
				<tr ng-repeat="classification in $data">

					<td title="'Nombre de Compañia'" header-class="'text-left'"
						sortable="'companyName'">{{classification.companyName}}</td>

					<td title="'Nombre de Clasificacion'" header-class="'text-left'"
						sortable="'className'">{{classification.className}}</td>

					<td title="'Descripción'" header-class="'text-left'"
						sortable="'description'">{{classification.description}}</td>

					<td>
						<button type="button" class="btn btn-primary"
							aria-label="Left Align"
							data-ng-click="updateClassification(classification)"
							ui-sref="campaigns">Abrir</button>
					</td>

				</tr>
			</table>
		</div>
	</div>

</div>