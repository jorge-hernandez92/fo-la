<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<div class="row">
	<div class="col-lg-12">
		<h2 class="page-header">Administracion de Usuarios</h2>
		<ol class="breadcrumb">
			<li><i class="fa fa-home"></i> <a href="homeAction">Inicio</a></li>
			<li><i class="fa fa-home"></i> <a href="redirectToMainUsers">Usuarios</a></li>
			<li class="active"><i class="fa fa-file-text-o"></i> Agregar
				Usuarios</li>
		</ol>
	</div>
</div>

<div data-ng-app="users">
	<!-- <h3 align="center">Lista de eventos comprobados </h3> -->
	<div data-ng-controller="usersController">

		<div class="panel panel-default">
			<div class="panel-body" align="center">
				<div class="input-group col-md-8">

					<form name="signup_form" novalidate data-ng-submit="insertUser()">

						<div class="form-group">
							<label class="control-label col-sm-2" for="username">Username:
							</label>
							<div class="col-sm-10">
								<input type="text" placeholder="Enter Username" name="username"
									class="form-control" data-ng-model="username" required />
								<div class="error"
									data-ng-show="signup_form.username.$dirty && signup_form.username.$invalid">
									<small class="error"
										data-ng-show="signup_form.name.$error.required"> Tu
										nombre de usuario es requerido. </small>
								</div>
							</div>
						</div>

						<br /> <br /> <br />

						<div class="form-group">
							<label class="control-label col-sm-2">Password: </label>
							<div class="col-sm-10">
								<input name="pass" data-ng-model="pass" class="form-control"
									type="password" placeholder="Enter Password" required>
								<div class="error"
									data-ng-show="signup_form.pass.$dirty && signup_form.pass.$invalid">
									<small class="error"
										data-ng-show="signup_form.pass.$error.required"> Tu
										password es requerido. </small>
								</div>
							</div>
						</div>


						<br /> <br />
						<div class="form-group">
							<label class="control-label col-sm-2">Confirmacion
								Password: </label>
							<div class="col-sm-10">
								<input type="password" name="confirmPassword"
									placeholder="Confirm Password" data-ng-model="confirmPassword"
									data-compare-to="pass" class="form-control" required />

								<div class="error"
									data-ng-show="signup_form.confirmPassword.$dirty && signup_form.confirmPassword.$invalid">
									<small class="error"
										data-ng-show="signup_form.confirmPassword.$error.required && signup_form.confirmPassword.$invalid">
										La confirmacion de tu password es requerido. </small> <small
										class="error"
										data-ng-show="signup_form.confirmPassword.$invalid && !signup_form.confirmPassword.$error.required">
										Las confirmacion de tu contrasena no es correcta, favor de
										verificarla. </small>

								</div>
							</div>
						</div>

						<br /> <br />

						<div class="form-group">
							<label class="control-label col-sm-2" for="name">Name: </label>
							<div class="col-sm-10">
								<input type="text" placeholder="Enter Your Name" name="name"
									data-ng-model="name" class="form-control" required />
								<div class="error"
									data-ng-show="signup_form.name.$dirty && signup_form.name.$invalid">
									<small class="error"
										data-ng-show="signup_form.name.$error.required"> Tu
										nombre es requerido. </small>
								</div>
							</div>
						</div>

						<br /> <br />

						<div class="form-group">
							<label class="control-label col-sm-2" for="email">Email:
							</label>
							<div class="col-sm-10">
								<input type="email" placeholder="Enter an Email" name="email"
									data-ng-model="email" class="form-control" required />
								<div class="error-container"
									data-ng-show="signup_form.email.$dirty && signup_form.email.$invalid">
									<small class="error"
										data-ng-show="signup_form.email.$error.required"> Tu
										email es requerido. </small> <small class="error"
										data-ng-show="signup_form.email.$error.email"> No es
										un formato valido de correo electronico. Por favor ingresa uno
										correcto. </small>
								</div>
							</div>
						</div>

						<br /> <br />

						<!-- 						<div class="form-group" data-ng-show="thAssign" align="left"> -->
						<!-- 							<a data-ng-click="showCards()" href="#" data-toggle="modal" -->
						<%-- 								data-target="#modalTh">Asignar tarjeta </a> <br /> <span>Tarjeta --%>
						<%-- 								Asignada: {{cardSelected}}</span> --%>
						<!-- 						</div> -->
						<br />

						<div class="form-group" align="left">
							<label class="control-label col-sm-2">PERFIL: </label>
							<div class="col-sm-10" data-ng-controller="getProfiles">
								<button class="btn btn-default dropdown-toggle" type="button"
									id="dropdownMenuPeriodo" data-toggle="dropdown"
									aria-expanded="true" style="width: 225px;" required>

									<span data-ng-if="selectedProfile.length == 0">Selecciona
										un Perfil</span> <span data-ng-if="selectedProfile.length > 0">{{selectedProfile}}</span>


									<span class="caret"></span>
								</button>
								<ul class="dropdown-menu" role="menu"
									aria-labelledby="dropdownMenu1">
									<li role="presentation" data-ng-repeat="perf in perfiles"><a
										role="menuitem" tabindex="-1"
										data-ng-click="filterByProfile(perf.category , perf.catProfileId , perf.profile)">{{perf.profile}}</a></li>
								</ul>

							</div>
						</div>
						<br /> <br />
						<div class="form-group" align="left"
							data-ng-show="categoryShow && clientVisible">
							<label class="control-label col-sm-2">CLIENTE: </label>
							<div class="col-sm-10" data-ng-controller="getClients">
								<button class="btn btn-default dropdown-toggle" type="button"
									id="dropdownMenuPeriodo" data-toggle="dropdown"
									aria-expanded="true" style="width: 225px;">

									<span data-ng-if="selectedCompany.length <= 0">Selecciona
										un Cliente</span> <span data-ng-if="selectedCompany.length > 0">{{selectedCompany}}</span>

									<span class="caret"></span>
								</button>
								<ul class="dropdown-menu" role="menu"
									aria-labelledby="dropdownMenu1">
									<li role="presentation" data-ng-repeat="cli in clients"><a
										role="menuitem" tabindex="-1"
										data-ng-click="selectClient(cli.companyId , cli.name)">{{cli.companyId}}
											- {{cli.name}}</a></li>
								</ul>
							</div>
						</div>

						<br /> <br />
						<div class="form-group" align="center" data-ng-show="thVisible">

							<div class="input-group">
								<div class="input-group-addon">
									<i class="fa fa-search"></i>
								</div>
								<input type="text" class="form-control"
									placeholder="Buscar Tarjetahabientes" data-ng-model="searchTh">
							</div>

							<table class="table table-striped table-responsive table-hover"
								data-ng-table="tableUsers">

								<tr data-ng-repeat="th in $data | filter:searchTh">
									<td data-title="'Nombre'">{{th.name}}</td>
									<td data-title="'Tarjeta'">{{th.cardNumber}}</td>
									<td data-title="'Selección'"><span class="pull-left">
											<input type="checkbox"
											data-checklist-model="thSelected.idSelected"
											data-checklist-value="th.userId">
									</span></td>
								</tr>
							</table>
						</div>

						<div class="form-group" align="center">
							<button type="submit" data-ng-disabled="signup_form.$invalid"
								style="width: 290px;" class="btn btn-primary btn-lg btn-block"
								data-toggle="modal" data-target="#modalConfirmacion">Guardar</button>

						</div>
					</form>
				</div>
			</div>
		</div>
		<jsp:include page="modals/thModal.jsp" />
		<jsp:include page="modals/modalConfirmacion.jsp" />
	</div>
</div>