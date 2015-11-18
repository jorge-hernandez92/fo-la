<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="/struts-tags" prefix="s"%>

	
	<!-- MODAL CON LEYENDA DE SALDO -->
	<div class="modal fade" id="modalViewInfo" tabindex="-1" role="dialog"
		aria-labelledby="mySmallModalLabel" aria-hidden="true">
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
					<div class="bs-example">						
						<p class="info-balance">
							<s:property value="balanceMessage" /> 
						</p>
					</div>
				</div>
				<div class="modal-footer">
					<p class="text-center">
						<a type="button" class="btn btn-warning" data-dismiss="modal" href="#">Aceptar</a>
					</p>
				</div>
			</div>
		</div>
	</div>
	<!-- END MODAL CON LEYENDA DE SALDO -->
	
	<!-- MODAL CON LISTA DE USUARIOS POR SUPERVISOR -->
	<div class="modal fade" id="modalViewUsers" tabindex="-1" role="dialog"
		aria-labelledby="mySmallModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				 <div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Mis usuarios asignados</h4>
				</div> 
				<div class="modal-body">
					
					
					                
              	<table data-ng-table="tableUsersBySupervisor"
					class="table table-striped table-responsive table-hover">					
					<thead>
						<tr>							
							<th style="text-align: center;">Nombre</th>
							<th style="width: 137px; text-align: center;">Número de tarjeta</th>														
						</tr>
					</thead>
					<tbody>
						<tr data-ng-repeat="user in $data">
							<td>{{user.name}}</td>	
							<td style="text-align: center;">{{user.cardNumber}}</td>
						</tr>
					</tbody>
				</table>				
				
				</div>
				<div class="modal-footer">
					<p class="text-center">
						<a type="button" class="btn btn-warning" data-dismiss="modal" href="#">Aceptar</a>
					</p>
				</div>
			</div>
		</div>
	</div>
	<!--  END MODAL CON LISTA DE USUARIOS POR SUPERVISOR -->


  


	