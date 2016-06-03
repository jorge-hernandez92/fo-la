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
				
				<form class="form-horizontal">
                    <div class="form-group">
                        <label class="col-md-4 control-label">Modo de visualización</label>
                        <div class="col-md-8">
                            <select class="form-control" name="selected"
								ng-options="option.name for option in selectPublicationView.availableOptions track by option.id"
								ng-model="selectPublicationView.selectedOption">
							</select>
                        </div>
                    </div>

                    <div class="form-group" ng-if="selectPublicationView.selectedOption.id == 1">
                        <label class="col-md-4 control-label">Número de cuenta</label>
                        <div class="col-md-8">
                            <input type="text" required class="form-control" ng-model="selectPublicationView.cardNumber">
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-xs-5 col-xs-offset-4">
                            <button type="submit" class="btn btn-primary" ng-click="viewPublication()" >Visualizar</button>
                        </div>
                    </div>
                </form>

				</div>
				
			</div>
		</div>
	</div>
	