<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<link ng-href="css/sivale.css" rel="stylesheet">
<title>Upload File Page</title>
</head>
<body>
<!-- <h3>Select File to Upload</h3> -->
<!-- "input-control -->
<%-- <s:form action="UploadFile" method="post" enctype="multipart/form-data"> --%>
<%-- <s:file label="File" name="file" cssClass="file"></s:file> --%>
<%-- <s:submit value="Upload" cssClass="file"></s:submit> --%>
<%-- </s:form> --%>



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

		<form action="UploadFile" method="post" enctype="multipart/form-data">
				<div class="text-right">

					<div class="row margin-top10">
						<div class="col-md-4">Nombre de Publiccion</div>
						<div class="col-md-8">
							<input type="text" class="form-control" name="publication">
						</div>
					</div>

					<div class="row margin-top10">
						<div class="col-md-4">Tipo de Publicación</div>
						<div class="col-md-8">
							<select class="form-control">
								<option>Teaser</option>
								<option>Avance</option>
								<option>Cierre</option>
								<option>Premiación</option>
							</select>
						</div>
					</div>

					<div class="row margin-top10">
						<div class="col-md-4">Documento html</div>
						<div class="col-md-8">
							<input type="file" name="file" class="test">
						</div>
					</div>

					<div class="row margin-top10">
						<div class="col-md-4">Documento</div>
						<div class="col-md-8">
							<input type="file" name="file" class="test">
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
							<button type="button" class="btn btn-primary left-35" ng-click="addRow()">Añadir Archivo</button>
							<div class="col-md-8" ng-repeat="rowContent in rows">
								<input type="file" name="file" id="filestyle-{{rowContent}}">
							</div>
						</div>
					</div>
				</div>


				<div class="row margin-top10">
					<div class="col-md-4"></div>

					<div class="col-md-8 text-left">

						<button type="submit" class="btn btn-success">Publicar</button>
						<button type="button" class="btn btn-danger left-35">Cancelar</button>

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