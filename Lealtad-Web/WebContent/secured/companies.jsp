<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<div class="row title" data-ng-app="companies"
	data-ng-controller="companyController" ng-cloak>
	<div class="col-lg-12">
		<h2 class="page-header">Clientes</h2>
	</div>


	<div class="col-lg-12">	
	
		<div class="panel panel-default" data-ng-controller="allCompanies">
			<div class="panel-heading">Activar/Desactivar
				clientes
				
			<div class="input-group">
				<div class="input-group-addon">
					<i class="fa fa-search"></i>
				</div>
				<input class="form-control" type="text"
					data-ng-model="filters.myfilter" placeholder="Buscar Clientes" />
			</div>								
			</div>
						
			<div class="panel-body">
				<%-- 				<div data-ng-show="" class="alert alert-warning" role="alert"
					align="center">
					<span class="glyphicon glyphicon-exclamation-sign"
						aria-hidden="true"></span> Seleccione al menos un usuario <span
						class="sr-only">Error:</span>
				</div> --%>
								
				
				<div>
					<table data-ng-table="tableCompanies"
						class="table table-striped table-responsive table-hover" >						
							<tr data-ng-repeat="company in $data" >
								<td data-title="'Id'" header-class="'text-center'" sortable="'companyId'">{{company.companyId}}</td>
								<td data-title="'Nombre'" header-class="'text-center'" sortable="'name'" >{{company.name}}</td>
								<td data-title="'Habilitado'" header-class="'text-center'" align="center" sortable="'enable'">
									<p>
										<input ng-model="company.enable" on-type="warning"
											name="{{company.companyId}}" type="checkbox" toggle-btn
											data-ng-click="updateCompanyStatus(company)">
									</p>
								</td>
							</tr>						
					</table>
				</div>
			</div>
		</div>

	</div>
</div>