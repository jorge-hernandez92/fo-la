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
			<div class="panel" style="background-color: rgba(210, 210, 210, 0.15);">
				<div class="panel-heading">
					<div class="container-fluid">
						<div class="navbar-header" style="font-family:font-size: 17px;">Carga Archivos Acuse</div>
					</div>
				</div>
				<div class="panel-body back-sivale">
					<form id="newFileAcuse" action="uploadAcuseFileAction" method="post" enctype="multipart/form-data">
						<div class="text-right">
							<div class="row margin-top10">
								<div class="col-md-3">Solicitud de tarjeta Lealtad Sí Vale</div>
								<div class="col-md-6">
									<input type="file" name="xlsFileFormat" class="test" accept=".xlsx, .xlsm" required>
								</div>
							</div>
							<br>
							<div class="row margin-top10">
								<div class="col-md-3">Acuse 2</div>
								<div class="col-md-6">
									<input type="file" name="filesAcuse" class="test" required>
								</div>
							</div>
							<br>
							<div class="row margin-top10">
								<div class="col-md-3">Acuse 2</div>
								<div class="col-md-6">
									<input type="file" name="filesAcuse" class="test" required>
								</div>
							</div>
							<br>
							<div class="row margin-top10">
								<div class="col-md-3">Cargar mas archivos</div>
								<div class="col-md-6">
										<button type="button" class="btn btn-primary left-35"
										ng-click="addRow3()">Añadir Mas Archivos</button>
									<div class="row row margin-top10" ng-repeat="rowContent in rows3">
											<div class="col-md-10">
												<input type="file" name="filesAcuse" id="filestyle-{{rowContent.index}}">
											</div>
											<div class="col-md-1">
												<button type="button" class="btn btn-primary" data-ng-click="removeRow3($index)">
  													<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
												</button>
											</div>
									</div>
								</div>
							</div>
							<br>
						</div>
						<br><br>
						<div class="row margin-top10">
							<div class="col-md-4"></div>
							<div class="col-md-6 text-left">
								<button type="submit" class="btn btn-primary" form="newFileAcuse">Guardar</button>
								<button type="button" class="btn btn-primary left-35" ui-sref="home">Cancelar</button>
							</div>
						</div>
					</form>
				</div>
		</div>
	</div>
	<br><br><br>
</body>
</html>