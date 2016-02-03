<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

	<!-- MODAL CONFIRMACION DE APROBACION/RECHAZO DE BUDGETS -->
	<div class="modal fade" id="modalChangeAttachedFile" tabindex="-1" role="dialog"
		aria-labelledby="mySmallModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					
					<h4 class="modal-title">
						Confirmación
					</h4>
				</div>
				
				<div class="modal-body">
					<div class="row margin-top10">
						<div ng-if="attachedFileTemp.isPublic">
							¿ Desea cambiar el archivo {{attachedFileTemp.fileName}}.{{attachedFileTemp.fileExtension}} como púlico ?
						</div>
						<div ng-if="!attachedFileTemp.isPublic">
							¿ Desea cambiar el archivo {{attachedFileTemp.fileName}}.{{attachedFileTemp.fileExtension}} como privado ?
						</div>
					</div>				
				</div>
				
				<div class="modal-footer">
					<p class="text-center">
						<button  type="button" class="btn btn-primary" ng-click="updateAttacherFile()" 
						data-dismiss="modal">
								Cambiar
						</button>
					</p>
				</div>
			</div>
		</div>
	</div>