<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>


<!-- MODAL PARA REMOVER TRX -->
<div class="modal fade" id="modalTh" tabindex="-1" role="dialog"
	aria-labelledby="mySmallModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">Asiginacion de
					Tarjeta</h4>
			</div>
			<div class="modal-body">
				<div class="form-group" align="center">

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
							<td data-title="'Asignar'"
								data-ng-click="selectCard(th.cardNumber)"><a href="#"
								data-dismiss="modal">Asignar</a></td>
						</tr>
					</table>
				</div>
			</div>
			<div class="modal-footer">
				<p class="text-center">
					<a type="button" class="btn btn-warning" data-dismiss="modal"
						href="#">Aceptar</a>
				</p>
			</div>
		</div>
	</div>
</div>
