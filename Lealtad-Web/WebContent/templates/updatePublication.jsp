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
				<li class="active"><span>Edición de Publicaciones</span></li>
			</ol>
		</div>
		<div class="container">
			<div class="panel panel-default table-top-sivale">
				<div class="panel-heading">
					<div class="container-fluid">
						<div class="navbar-header">Datos de Publicación</div>
					</div>
				</div>
				<form id="updatePublicationGral" action="UpdatePublicationAction" method="post"
						enctype="multipart/form-data">
				<div class="back-sivale">

						<table class="table">
							<tr>
								<td>
								<div class="row margin-top10">
									<div class="col-md-4 text-right">Nombre de Publicación</div>
									<div class="col-md-8">
										<input type="text" class="form-control" name="publication"
											ng-model="publication.name">
									</div>
								</div>

								<div class="row margin-top10">
									<div class="col-md-4 text-right">Tipo de Publicación</div>
									<div class="col-md-8"
										data-ng-controller="getPublicationTypesUpdate">
										<select class="form-control" name="selected"
											ng-options="option.name for option in selectPublicationType.availableOptions track by option.id"
											ng-model="selectPublicationType.selectedOption">
										</select>
									</div>
								</div>

								<div class="row margin-top10">
									<div class="col-md-4 text-right">Documento html</div>
									<div class="col-md-8">
										<div class="row">
											<div class="col-md-8">{{publication.templateFilePath}}</div>
											<div class="col-md-4">
												<button type="button" class="btn btn-primary left-35"
													data-toggle="modal" data-target="#modalUploadTemplate">Reemplazar
													Archivo</button>
											</div>
										</div>
										<!-- 									<input type="file" name="file" class="test"> -->
									</div>
								</div>

								<div class="row margin-top10">
									<div class="col-md-4 text-right">Documento excel</div>
									<div class="col-md-8">
										<div class="row">
											<div class="col-md-8">{{publication.dataFilePath}}</div>
											<div class="col-md-4">
												<button type="button" class="btn btn-primary left-35"
													data-toggle="modal" data-target="#modalUploadData">Reemplazar
													Archivo</button>
											</div>
										</div>
										<!-- 									<input type="file" name="file" class="test"> -->
									</div>
								</div>

								<div class="row margin-top10">
									<div class="col-md-4 text-right">Descripción</div>
									<div class="col-md-8">
										<textarea class="form-control" rows="3" name="description"
											ng-model="publication.description"></textarea>
									</div>
								</div>

								</td>
							</tr>
							<tr>
								<td>
								<div class="row margin-top10">
									<div class="col-md-4 text-right">Documentación anexa</div>
									<div class="col-md-8"
										data-ng-controller=getAttachedFilesByPublication>
										<div class="row col-md-12 margin-bottom10 padding-cero"
											ng-repeat="attachedFile in updateAttachedFiles">

											<div class="col-md-8">
												{{attachedFile.fileName}}.{{attachedFile.fileExtension}}</div>
											<div class="col-md-3">
												<select class="form-control"
													ng-options="option.name for option in attachedFile.options track by option.id"
													ng-model="attachedFile.selected"
													data-toggle="modal" ng-change="changeAttachedFileStatus(attachedFile, $index)">
												</select>
											</div>
											<div class="col-md-1">
												<button type="button" class="btn btn-primary" ng-click="updateAttachedFile(attachedFile, $index)"
												data-toggle="modal" data-target="#modalDeleteAttachedFile">
<!-- 													data-ng-click="removeAttachedFile($index)"> -->
													<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
												</button>
											</div>
										</div>
									</div>
									<jsp:include page="modals/deleteAttachedFileConfirm.html"/>
									<jsp:include page="modals/changeAttachedFileConfirme.html"/>
								</div>
								</td>
							</tr>
							<tr>
								<td>
								<div class="row margin-top10">
									<div class="col-md-4 text-right"></div>
									<div class="col-md-8">
										<div class="row col-md-12 text-right padding-cero">
<!-- 											<button type="button" class="btn btn-primary" ui-sref="newCampaign" ng-click="cleanSelect()"> -->
<%--   												<span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span> Añadir Campaña --%>
<!-- 											</button> -->
											<button type="button" class="btn btn-primary left-35"
												ng-click="addRow()">Añadir Archivo</button>
										</div>
										<div class="row row col-md-12 margin-top10 padding-cero"
											ng-repeat="rowContent in rows">

											<div class="col-md-8">
												<input type="file" name="file"
													id="filestyle-{{rowContent.index}}">
											</div>
											<div class="col-md-3">
												<select class="form-control" name="filechecked">
													<option>Privado</option>
													<option>Público</option>
												</select>
											</div>
											<div class="col-md-1">
												<button type="button" class="btn btn-primary"
													data-ng-click="removeRow($index)">
													<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
												</button>
											</div>
										</div>
									</div>
								</div>
								</td>
							</tr>
						</table>

						<div class="row margin-top10">
							<div class="col-md-4"></div>

							<div class="col-md-8 text-left">

								<button type="submit" class="btn btn-primary" form="updatePublicationGral">Actualizar</button>
								<button type="button" class="btn btn-primary left-35"
									ng-click="deletePublication()">Eliminar</button>

							</div>
						</div>

						<script type="text/javascript">
							// nultiple initialize
							$('.test').filestyle({
								buttonName : 'btn-primary'
							});
						</script>
				</div>
				</form>
			</div>
		</div>
	</div>
	
		<jsp:include page="modals/uploadTemplateModal.jsp" />
		<jsp:include page="modals/uploadDataModal.jsp" />
</body>
</html>