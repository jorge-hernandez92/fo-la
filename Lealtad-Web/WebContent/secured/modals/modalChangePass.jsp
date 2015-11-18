<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!-- MODAL CON LEYENDA DE SALDO -->
<div class="modal fade" id="modalChangePass" tabindex="-1" role="dialog"
	aria-labelledby="mySmallModalLabel" aria-hidden="true">


	<form name="pass_form" novalidate data-ng-submit="editPassword()">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Editar Password</h4>
				</div>
				<div class="modal-body">

					<div>
						<li data-ng-show="isSuccessChangePass">Se cambio
							correctamente el password.</li>
					</div>

					<br /> <br />

					<div class="form-group">
						<label class="control-label col-sm-2">Password: </label>
						<div class="col-sm-10">
							<input data-ng-model="newPass" class="form-control"
								name="newPass" type="password" placeholder="Enter Password"
								required>
							<div class="error"
								data-ng-show="pass_form.newPass.$dirty && pass_form.newPass.$invalid">
								<small class="error"
									data-ng-show="pass_form.newPass.$error.required"> Tu
									password es requerido. </small>
							</div>
						</div>
						<br /> <br />

						<div class="form-group">
							<label class="control-label col-sm-2">Confirmacion
								Password: </label>
							<div class="col-sm-10">
								<input type="password" name="newConfirmPassword"
									data-ng-model="newConfirmPassword" data-compare-to="newPass"
									class="form-control" placeholder="Confirm Password" required />

								<div class="error"
									data-ng-show="pass_form.newConfirmPassword.$dirty && pass_form.newConfirmPassword.$invalid">
									<small class="error"
										data-ng-show="pass_form.newConfirmPassword.$error.required && pass_form.newConfirmPassword.$invalid">
										La confirmacion de tu password es requerido. </small> <small
										class="error"
										data-ng-show="pass_form.newConfirmPassword.$invalid && !pass_form.newConfirmPassword.$error.required">
										Las confirmacion de tu contrasena no es correcta, favor de
										verificarla. </small>

								</div>
							</div>
						</div>
					</div>
				</div>
				<br /> <br />
				<div class="modal-footer">
					<p class="text-center" align="center">
						<button type="submit" data-ng-disabled="pass_form.$invalid"
							style="width: 290px;" class="btn btn-primary btn-lg btn-block">Guardar</button>
					</p>
				</div>
			</div>
		</div>
	</form>
</div>
<!-- MODAL CON LEYENDA DE SALDO -->