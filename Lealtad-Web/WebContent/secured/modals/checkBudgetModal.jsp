<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>


	<!-- MODAL CONFIRMACION DE APROBACION/RECHAZO DE BUDGETS -->
	<div class="modal fade" id="modalConfirmCheckBudgets" tabindex="-1" role="dialog"
		aria-labelledby="mySmallModalLabel" aria-hidden="true">
		
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					
					<h4 class="modal-title" id="myModalLabel" 
						data-ng-show="myControllerStatus == STATUS_ON_EDIT || 
									myControllerStatus == STATUS_ON_PROGRESS">
						Confirme Operación
					</h4>
					
					<h4 class="modal-title" id="myModalLabel" 
						data-ng-show="myControllerStatus != STATUS_ON_EDIT && 
								myControllerStatus != STATUS_ON_PROGRESS">
						Resultado de Operación
					</h4>
				</div>
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				<div class="modal-body">
				
				
			
			
					<br />
				
				
				
					<div class="bs-example" data-ng-if="confirmation == approveBudgets && myControllerStatus == STATUS_ON_EDIT">
						<br />
						<p><span class="label label-warning">Atención!</span> 
								¿Está seguro que desea aprobar todos los presupuestos seleccionados?</p>
					</div>
					
					<div class="bs-example" data-ng-if="confirmation == denyBudgets && myControllerStatus == STATUS_ON_EDIT">
						<br />
						<p><span class="label label-warning">Atención!</span> 
								¿Está seguro que desea rechazar todos los presupuestos seleccionados?</p>
					</div>
					
					
					
					
					
					
						<!-- ON PROGRESS CASE -->
						<div data-ng-show="myControllerStatus == STATUS_ON_PROGRESS">
							<p><span class="label label-info">En espera</span> Procesando...</p>
						</div>
						<!-- SUCCESS CASE -->
						<div data-ng-show="myControllerStatus == SUCCESS_CODE">
							<p><span class="label label-success">Terminado</span> 
								Los presupuestos han sido actualizados exitosamente.
							</p>
						</div>
						<!-- ERROR CASE -->
						<div data-ng-show="myControllerStatus != STATUS_ON_EDIT &&
											myControllerStatus != STATUS_ON_PROGRESS &&
											myControllerStatus != SUCCESS_CODE">
							<p><span class="label label-danger">Error</span> 
								Error en el servicio de guardado. ErrorCode: {{myControllerStatus}}
							</p>
						</div>
					
				</div>
				
				
				
				
				
				<div class="modal-footer">
					<p class="text-center">
					
						<a  type="button" class="btn btn-success"
							data-ng-if="confirmation == approveBudgets  && myControllerStatus == STATUS_ON_EDIT" 
							data-ng-click="checkBudgets(approveBudgets)">
								Aprobar
						</a>
						
						<a  type="button" class="btn btn-danger"
							data-ng-if="confirmation == denyBudgets && myControllerStatus == STATUS_ON_EDIT" 
							data-ng-click="checkBudgets(denyBudgets)">
								Rechazar
						</a>
						
						<a  type="button" class="btn btn-default"
							data-ng-show="  myControllerStatus != STATUS_ON_EDIT && 
											myControllerStatus != STATUS_ON_PROGRESS"
							data-ng-click="finishAndRedirect()"
							data-target="otherBudgetsAction"
							href="otherBudgetsAction" 
							data-dismiss="modal">
							Aceptar
						</a>
							
					</p>
				</div>
			</div>
		</div>
	</div>
	<!-- MODAL PARA AVISO DE BUDGET ENVIADO -->
	