<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<div class="row title" data-ng-app="downloadInvoices"
	ng-controller="downloadInvoicesController" ng-cloak>
	<div class="col-lg-12">
		<h2 class="page-header">Descarga de Facturas</h2>
	</div>


	<div class="col-lg-12" align="center">

		<div class="container container-fluid container-download"
			align="center">

			<div class="panel panel-default">
				<div class="panel-heading">Descargar facturas por mes</div>
				<div class="panel-body transactionsTh-chart">
					<div class="input-group col-md-5">
					
						<div id="date" class="input-group date" datetimez ng-model="dateDownload">
							<input data-format="MM-yyyy" class="form-control" type="text"
								id="input1" name="input1"></input> <span
								class="input-group-addon add-on"> <i
								data-time-icon="icon-time" data-date-icon="icon-calendar"></i>
							</span>
							<div class="col-md-3">
								<button type="button" class="btn btn-warning" data-ng-click="downloadZIPInvoices()">
									<span class="glyphicon glyphicon-download" aria-hidden="true"></span>
									Descargar
								</button>
							</div>
						</div>
					
					</div>
				</div>
				<div class="modal-footer">
					<p class="text-center" style="font-style: italic;">
						Se decargará una archivo comprimido en ZIP con todas las facturas de su compañia para el  mes seleccionado.
					</p>
				</div>
			</div>




		</div>


	</div>

</div>