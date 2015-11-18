<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!-- MODAL CON LEYENDA DE SALDO -->
<div class="modal fade" id="modalConfirmacion" tabindex="-1"
	role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">Información</h4>
			</div>
			<div class="modal-body">
				<div class="bs-example">{{response.statusResponse}} -
					{{response.msgResponse}}</div>
			</div>
			<div class="modal-footer">
				<p class="text-center">
					<a type="button" class="btn btn-warning" data-dismiss="modal"
						href="#" data-ng-click="cleanMsg()">Aceptar</a>
				</p>
			</div>
		</div>
	</div>
</div>
<!-- MODAL CON LEYENDA DE SALDO -->