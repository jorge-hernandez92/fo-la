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
		<div class="navbar container">
			<ol class="breadcrumb breadcrumb-arrow">
				<li><a ui-sref="home">Campañas Recientes</a></li>
				<li><a ui-sref="campaign">Publicaciones</a></li>
				<li class="active"><span>Alta de Publicaciones</span></li>
			</ol>
		</div>
		<div class="container">
			<div class="panel panel-default table-top-sivale">
				<div class="panel-heading">
					<div class="container-fluid">
						<div class="navbar-header">Datos de Publicación</div>
					</div>
				</div>
				<div class="panel-body back-sivale">

					<form action="UploadFile" method="post"
						enctype="multipart/form-data">
						<div class="text-right">

							<div class="row margin-top10">
								<div class="col-md-4">Nombre de Publicación</div>
								<div class="col-md-8">
									<input type="text" class="form-control" name="publication">
								</div>
							</div>

							<div class="row margin-top10">
								<div class="col-md-4">Tipo de Publicación</div>
								<div class="col-md-8" data-ng-controller="getPublicationTypes">
									<select class="form-control" name="selected"
										ng-options="option.name for option in selectPublicationType.availableOptions track by option.id"
										ng-model="selectPublicationType.selectedOption">
									</select>
								</div>
							</div>

							<div class="row margin-top10">
								<div class="col-md-4">Documento html</div>
								<div class="col-md-8">
									<input type="file" name="file" class="test" accept=".html">
								</div>
							</div>

							<div class="row margin-top10">
								<div class="col-md-4">Documento excel</div>
								<div class="col-md-8">
									<input type="file" name="file" class="test" accept=".xlsx">
								</div>
							</div>

							<div class="row margin-top10">
								<div class="col-md-4">Descripción</div>
								<div class="col-md-8">
									<textarea class="form-control" rows="3" name="description"></textarea>
								</div>
							</div>

							<div class="row margin-top10">
								<div class="col-md-4">Documentación anexa</div>
								<div class="col-md-8">
									<div class="row col-md-12">
										<button type="button" class="btn btn-primary left-35"
										ng-click="addRow()">Añadir Archivo</button>
									</div>
									<div class="row row col-md-12 margin-top10" ng-repeat="rowContent in rows">
										
											<div class="col-md-8">
												<input type="file" name="file" id="filestyle-{{rowContent.index}}">
											</div>
											<div class="col-md-3">
												<select class="form-control" name="filechecked">
													<option>Privado</option>
													<option>Público</option>
												</select>
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

						<div class="row margin-top10">
							<div class="col-md-4"></div>

							<div class="col-md-8 text-left">

								<button type="submit" class="btn btn-primary">Publicar</button>
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
</body>
</html>