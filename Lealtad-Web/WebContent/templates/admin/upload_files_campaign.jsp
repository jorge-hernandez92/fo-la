<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
</head>
<body>

	<div class="panel-body back-sivale">
		<div class="container">
			<div class="panel" style="background-color: rgba(210, 210, 210, 0.15);">
				<div class="panel-heading">
					<div class="container-fluid">
						<div class="navbar-header" style="font-family:font-size: 17px;">Datos de Incentivo</div>
					</div>
				</div>
				<div class="panel-body back-sivale">

					<form id="newPublication" action="uploadFileCampaingAction" method="post"
						enctype="multipart/form-data">
						<div class="text-right">

							<div class="row margin-top10">
								<div class="col-md-3">Nombre de Incentivo</div>
								<div class="col-md-6">
									<input type="text" class="form-control" name="nombreIncentivo" required>
								</div>
							</div>					
							
							
							<div class="row margin-top10"
						data-ng-controller="getClassCompanyList">
						<div class="col-md-3">Compañia</div>
						<div class="col-md-6">
							<select class="form-control"
								ng-options="option.name for option in selectCampaign.items[0].availableOptions track by option.id"
								ng-model="selectCampaign.items[0].selectedOption"
								ng-change="changeCompany()" name="incentivo" required>
							</select>
						</div>
					</div>

					<div class="row margin-top10"
						ng-if="selectCampaign.isEnabled(selectCampaign.items[0])">
						<div class="col-md-3">Programa</div>
						<div class="col-md-6">
							<select class="form-control"
								ng-options="option.name for option in selectCampaign.items[1].availableOptions track by option.id"
								ng-model="selectCampaign.items[1].selectedOption"
								ng-change="changeProgram()" name="programa">
							</select>
						</div>
						<div class="col-md-3"
							ng-if="selectCampaign.isNewClass(selectCampaign.items[1])">
							<input ng-model="selectCampaign.items[1].className" type="text"
								class="form-control" placeholder="Nombre"
								aria-describedby="basic-addon1">
						</div>
					</div>

					<div class="row margin-top10"
						ng-if="selectCampaign.isEnabled(selectCampaign.items[1])">
						<div class="col-md-3">Subprograma</div>
						<div class="col-md-6">
							<select class="form-control"
								ng-options="option.name for option in selectCampaign.items[2].availableOptions track by option.id"
								ng-model="selectCampaign.items[2].selectedOption"
								ng-change="changeSubProgram()" name="subprograma">
							</select>
						</div>
						<div class="col-md-3"
							ng-if="selectCampaign.isNewClass(selectCampaign.items[2])">
							<input ng-model="selectCampaign.items[2].className" type="text"
								class="form-control" placeholder="Nombre"
								aria-describedby="basic-addon1">
						</div>
					</div>

					<div class="row margin-top10"
						ng-if="selectCampaign.isEnabled(selectCampaign.items[2])">
						<div class="col-md-3">Unidad de negocio</div>
						<div class="col-md-6">
							<select class="form-control"
								ng-options="option.name for option in selectCampaign.items[3].availableOptions track by option.id"
								ng-model="selectCampaign.items[3].selectedOption"
								ng-change="changeBusinessUnit()" name="unidadDeNegocio">
							</select>
						</div>
						<div class="col-md-3"
							ng-if="selectCampaign.isNewClass(selectCampaign.items[3])">
							<input ng-model="selectCampaign.items[3].className" type="text"
								class="form-control" placeholder="Nombre"
								aria-describedby="basic-addon1">
						</div>
					</div>

					
							
<!-- 							<div class="row margin-top10"> -->
<!-- 								<div class="col-md-3">Imagen de Campaña</div> -->
<!-- 								<div class="col-md-6"> -->
<!-- 									<input type="file" name="files" class="test" accept="image/*" required> -->
<!-- 								</div> -->
<!-- 							</div> -->
							
							
							<div class="row margin-top10">
								<div class="col-md-3">Documento excel</div>
								<div class="col-md-6">
									<input type="file" name="xlsFile" class="test" accept=".xlsx" required>
								</div>
							</div>

							<br>
							
							<div class="row margin-top10">
								<div class="col-md-3">Información de Campaña</div>
								<div class="col-md-6">
										<button type="button" class="btn btn-primary left-35"
										ng-click="addRow2()">Añadir Archivo</button>
									<div class="row row margin-top10" ng-repeat="rowContent in rows2">
											<div class="col-md-10">
												<input type="file" name="filesImage" id="filestyle-{{rowContent.index}}">
											</div>
											<div class="col-md-1">
												<button type="button" class="btn btn-primary" data-ng-click="removeRow2($index)">
  													<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
												</button>
											</div>
									</div>
								</div>
							</div>

							<div class="row margin-top10">
								<div class="col-md-3">Documentación anexa</div>
								<div class="col-md-6">
										<button type="button" class="btn btn-primary left-35"
										ng-click="addRow()">Añadir Archivo</button>
									<div class="row row margin-top10" ng-repeat="rowContent in rows">
										
											<div class="col-md-10">
												<input type="file" name="files" id="filestyle-{{rowContent.index}}">
											</div>
											
											<div class="col-md-1">
												<button type="button" class="btn btn-primary" data-ng-click="removeRow($index)">
  													<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
												</button>
											</div>
									</div>
								</div>
							</div>
						</div>
						
						<br><br>

						<div class="row margin-top10">
							<div class="col-md-4"></div>

							<div class="col-md-6 text-left">

								<button type="submit" class="btn btn-primary" form="newPublication">Guardar</button>
								<button type="button" class="btn btn-primary left-35" ui-sref="campaign">Cancelar</button>

							</div>
						</div>

						<script type="text/javascript">
							// nultiple initialize
							$('.test').filestyle({
								buttonName : 'btn-primary'
							});
						</script>
						
					</form>
				</div>

			</div>
		</div>
	</div>
	
	<br><br><br>
	
</body>
</html>