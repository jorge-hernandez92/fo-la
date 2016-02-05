<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

	<!-- MODAL CONFIRMACION DE APROBACION/RECHAZO DE BUDGETS -->
	<div class="modal fade" id="modalViewPublication" tabindex="-1" role="dialog"
		aria-labelledby="mySmallModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					
					<h4 class="modal-title">
						Visualización de publicación
					</h4>
				</div>
				
				<div class="modal-body">
					<div class="row margin-top10">
						<div class="col-md-4">Modo de visualización</div>
						<div class="col-md-8">
							<select class="form-control" name="selected"
								ng-options="option.name for option in selectPublicationView.availableOptions track by option.id"
								ng-model="selectPublicationView.selectedOption">
							</select>
						</div>
					</div>
					<div class="row margin-top10" ng-if="selectPublicationView.selectedOption.id == 1">
						<div class="col-md-4">Número de cuenta</div>
						<div class="col-md-8">
							<input type="text" class="form-control"
							ng-model="selectPublicationView.cardNumber">
						</div>
					</div>		
				</div>
				
				<div class="modal-footer">
					<p class="text-center">
						<button  type="button" class="btn btn-primary" ng-click="viewPublication()" 
						data-dismiss="modal">
								Visualizar
						</button>
					</p>
				</div>
			</div>
		</div>
	</div>