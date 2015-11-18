<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>

	<!-- MODAL PARA AVISO DE BUDGET ENVIADO -->
	<div class="modal fade" id="modalBudgetEnviado" tabindex="-1" role="dialog"
		aria-labelledby="mySmallModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Guardando presupuesto</h4>
				</div>
				<div class="modal-body">
					<div class="bs-example">
						
						<br />
						<!-- ON PROGRESS CASE -->
						<div data-ng-show="processStatusCode == STATUS_ON_PROGRESS">
							<p><span class="label label-info">En espera</span> Procesando...</p>
						</div>
						<!-- SUCCESS CASE -->
						<div data-ng-show="processStatusCode == SUCCESS_CODE">
							<p><span class="label label-success">Terminado</span> 
								El presupuesto ha sido guardado exitosamente.
							</p>
						</div>
						<!-- ERROR CASE -->
						<div data-ng-show="processStatusCode == ERROR_EVENT_NAME_DUPLICATED">
							<p><span class="label label-danger">Error</span> 
								Ya existe un evento con ese nombre. Intente con otro nombre. 
							</p>
						</div>
						<!-- ERROR CASE -->
						<div data-ng-show="	processStatusCode != SUCCESS_CODE && 
											processStatusCode != ERROR_EVENT_NAME_DUPLICATED && 
											processStatusCode != STATUS_ON_PROGRESS">
							<p><span class="label label-danger">Error</span> 
								Error en el servicio de guardado. ErrorCode: {{processStatusCode}}
							</p>
						</div>
					</div>
				</div>
				
						
				<div class="modal-footer">
					<p class="text-center">
						
						<!-- SUCCESS CASE -->
						<a type="button" class="btn btn-warning" 
							data-ng-click="resetNewBudgetScreen()" 
							data-dismiss="modal"
							data-target="myBudgetsAction"
							href="myBudgetsAction"
							data-ng-show="processStatusCode == SUCCESS_CODE"
							>Aceptar</a>
						
						<!-- ERROR CASE -->
						<a type="button" class="btn btn-warning"
							data-ng-click="markInvalidEventName()"
							data-dismiss="modal"
							data-target="myBudgetsAction"
							href="myBudgetsAction"
							data-ng-show="processStatusCode != STATUS_ON_PROGRESS  && 
											 processStatusCode != SUCCESS_CODE"
							>Regresar</a>
							
					</p>
				</div>
			</div>
		</div>
	</div>
	<!-- MODAL PARA AVISO DE BUDGET ENVIADO -->
	