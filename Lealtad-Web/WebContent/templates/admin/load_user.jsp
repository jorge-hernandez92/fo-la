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
						<div class="navbar-header" style="font-family:font-size: 17px;">Carga de usuarios</div>
					</div>
				</div>
				<div class="panel-body back-sivale">
					<form id="newPublication" action="uploadFileUserAction" method="post"
						enctype="multipart/form-data">
						<div class="text-right">							
							<div class="row margin-top10">
								<div class="col-md-3">Documento excel</div>
								<div class="col-md-6">
									<input type="file" name="files" class="test" accept=".xlsx" required>
								</div>
							</div>
							<br>
						</div>
						<br><br>
						<div class="row margin-top10">
							<div class="col-md-4"></div>
							<div class="col-md-6 text-left">
								<button type="submit" class="btn btn-primary" form="newPublication">Guardar</button>
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