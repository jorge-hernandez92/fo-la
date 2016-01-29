<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
</head>

<form id="updateExcel" action="UploadExcelAction" method="post" enctype="multipart/form-data">

	<!-- MODAL CONFIRMACION DE APROBACION/RECHAZO DE BUDGETS -->
	<div class="modal fade" id="modalUploadData" tabindex="-1" role="dialog"
		aria-labelledby="mySmallModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					
					<h4 class="modal-title">
						Cambio de Fuente de Datos
					</h4>
				</div>
				
				<div class="modal-body">
					<div class="row margin-top10">
						<div class="col-md-4">Documento excel</div>
						<div class="col-md-8">
							<input type="file" name="file" class="test" accept=".xlsx">
						</div>
					</div>				
				</div>
				
				<div class="modal-footer">
					<p class="text-center">
						<button  type="submit" class="btn btn-success" form="updateExcel">
								Cambiar
						</button>	
					</p>
				</div>
			</div>
		</div>
	</div>
</form>