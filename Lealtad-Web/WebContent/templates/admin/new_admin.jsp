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
						<div class="navbar-header" style="font-family:font-size: 17px;">Nuevo administrador</div>
					</div>
				</div>
				<div class="panel-body back-sivale">
					<form id="newAdmin" action="newAdminAction" method="post"
						enctype="multipart/form-data">
						<div class="text-right">
							<div class="row margin-top10">
								<div class="col-md-3">Nombre</div>
								<div class="col-md-6">
									<input type="text" class="form-control" name="nombre" required>
								</div>
							</div>
							<div class="row margin-top10">
								<div class="col-md-3">Apellido Paterno</div>
								<div class="col-md-6">
									<input type="text" class="form-control" name="apellidoPaterno" required>
								</div>
							</div>
							<div class="row margin-top10">
								<div class="col-md-3">Apellido Materno</div>
								<div class="col-md-6">
									<input type="text" class="form-control" name="apellidoMaterno" required>
								</div>
							</div>
							<div class="row margin-top10">
								<div class="col-md-3">Usuario</div>
								<div class="col-md-6">
									<input type="text" class="form-control" name="usuario" required>
								</div>
							</div>
							<div class="row margin-top10">
								<div class="col-md-3">Contraseña</div>
								<div class="col-md-6">
									<input type="password" class="form-control" name="password" required>
								</div>
							</div>
							<div class="row margin-top10" data-ng-controller="getAllCompanies">
								<div class="col-md-3">Compañia</div>
								<div class="col-md-6">
									<select class="form-control"
										ng-options="option.name for option in allCompanies track by option.idCompany"
 										ng-model="allCompanies.idCompany" 
										name="selectCompany" required>
									</select>
								</div>
							</div>
						</div>
						<br><br>
						<div class="row margin-top10">
							<div class="col-md-4"></div>
							<div class="col-md-6 text-left">
								<button type="submit" class="btn btn-primary" form="newAdmin">Guardar</button>
								<button type="button" class="btn btn-primary left-35" ui-sref="home">Cancelar</button>
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
	<br><br><br>
</body>
</html>