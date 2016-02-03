<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

	<!-- MODAL CONFIRMACION DE APROBACION/RECHAZO DE BUDGETS -->
	<div class="modal fade" id="modalDeleteAttachedFile" tabindex="-1" role="dialog"
		aria-labelledby="mySmallModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					
					<h4 class="modal-title">
						Confirmación de eliminacion
					</h4>
				</div>
				
				<div class="modal-body">
					<div class="row margin-top10">
						¿ Desea eliminar el archivo adjunto {{attachedFileTemp.fileName}}.{{attachedFileTemp.fileExtension}} ?
					</div>				
				</div>
				
				<div class="modal-footer">
					<p class="text-center">
						<button  type="button" class="btn btn-success" ng-click="deleteAttacherFile()"
						data-dismiss="modal">
								Eliminar
						</button>
					</p>
				</div>
			</div>
		</div>
	</div>