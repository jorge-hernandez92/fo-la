<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>


	<!-- MODAL PARA REMOVER TRX -->
	<div class="modal fade" id="modalQuitarTrx" tabindex="-1" role="dialog"
		aria-labelledby="mySmallModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Remover Transacción</h4>
				</div>
				<div class="modal-body">
					<div class="bs-example">
						<br />
						<p>
							<span class="label label-danger">Atención</span> La transacción
							será removida del justificante.
						</p>
					</div>
				</div>
				<div class="modal-footer">
					<p class="text-center">
						<a type="button" class="btn btn-warning" data-dismiss="modal"
							data-ng-click="removeTransaccion()" href="#">Aceptar</a>
					</p>
				</div>
			</div>
		</div>
	</div>
	<!-- MODAL PARA REMOVER TRX -->
	
	<!-- MODAL AGREGAR TRANSACCION -->
	<div class="modal fade" id="modalAddTrxs" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Agregar transacciones a justificante.</h4>
				</div>
				<div class="modal-body">
					<div class="panel panel-default">
						<div class="panel-heading">
	
							<div align="center">
								<div class="input-group col-md-4">
									<div class="input-group-addon">
										<span class="glyphicon glyphicon-calendar"></span>
									</div>
									<input type="daterange" data-ng-model="budgetDateRange"
										title="busqueda de transacciones entre fechas"
										class="form-control" placeholder="Search">
									<div class="input-group-btn">
										<button class="btn btn-default button-search" type="submit"
											data-ng-click="getTransactionsBetweenDates(budgetDateRange.startDate, budgetDateRange.endDate)"
											style="padding: 9px 12px">
											<i class="glyphicon glyphicon-search"></i>
										</button>
									</div>
								</div>
							</div>
	
						</div>
						<div class="panel-body">
	
							<table data-ng-table="tableTransactionsNoBudget"
								class="table table-striped table-responsive table-hover">
								<tr data-ng-repeat="transaction in $data">
									<td data-title="'Fecha'">{{transaction.date}}</td>
									<td data-title="'Establecimiento'">{{transaction.tradeData}}</td>
									<td data-title="'Monto'">&#36;{{transaction.amount | number:2}}</td>
									<td data-title="'Monto Comprobado'"> &#36;{{(transaction.amountChecked | number:2) || '0.00'}} </td>
									<td data-title="'Factura'">
										<p>
											 <a  
				                             data-ng-repeat="invoice in transaction.invoiceList"  data-toggle="modal" 
				                             data-target="#modalDetalleFactura" data-ng-click="getInvoiceDetails(invoice.invoiceId, transaction.trxHbaseId, transaction.amountChecked, false)">
				                               <img src="img/xml.png" alt="XML" style="width:20px;height:20px">
				                             </a>     
										</p>
									</td>
									<td data-title="'Estatus'"><span
										data-ng-if="transaction.conciliationStatus == RECONCILED" class="label label-success" href="#">Conciliada</span> <span
										data-ng-if="transaction.conciliationStatus == NORECONCILED" class="label label-danger" href="#">No conciliada</span></td>
									<td data-title="'Selección'"><span class="pull-left">
											<label> <input type="checkbox"
												data-checklist-model="transactionsSelected.transaction"
												data-checklist-value="transaction">
										</label>
									</span></td>
								</tr>
							</table>							
							<br />
							<p class="text-center">
								<a type="button"
									data-ng-if="transactionsSelected.transaction.length > 0 "
									data-dismiss="modal" data-ng-click="addTransactionsToBudget()"
									class="btn btn-warning" href="#">Agregar</a> <a type="button"
									data-ng-if="transactionsSelected.transaction.length < 1 "
									data-ng-class='{ disabled: "disabled"}' data-dismiss="modal"
									data-ng-click="addTransactionsToBudget()"
									class="btn btn-warning" href="#">Agregar</a>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--TERMINA MODAL AGREGAR TRANSACCION -->
	

	<!-- MODAL PARA ENVIAR PRESUPUESTO -->
	<div class="modal fade" id="modalSendTransaction" tabindex="-1"
		role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Enviar presupuesto</h4>
				</div>
				<div class="modal-body">
					<div class="bs-example">
						<br />
						<p>
							<span class="label label-danger">Atención</span> El presupuesto
							será enviado para su revisión
						</p>
					</div>
				</div>
				<div class="modal-footer">
					<p class="text-center">
						<a type="button" class="btn btn-warning" data-dismiss="modal"
							data-toggle="modal" data-target="#modalEnviado"
							data-ng-click="changeBudgetStatus('',REPORT_SEND)" href="#">Enviar</a>
					</p>
				</div>
			</div>
		</div>
	</div>
	<!-- MODAL PARA ENVIAR PRESUPUESTO -->


	<!-- MODAL PRESUPUESTO ENVIADO -->
	<div class="modal fade" id="modalEnviado" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Justificante enviado</h4>
				</div>

				<div class="modal-body">
					<div class="bs-example">
						<br />
						<div class="alert alert-success" role="alert">El
							justificante ha sido enviado exitosamente.</div>
											
					</div>
				</div>
				<div class="modal-footer">
            		<p class="text-center">
						<a type="button" data-dismiss="modal" class="btn btn-warning"
							href="budgetDetailsAction">Aceptar</a>
					</p>
            	</div>
			</div>
		</div>
	</div>
	<!-- TERMINA PRESUPUESTO ENVIADO -->
	
	<!-- MODAL PARA ACEPTAR EL JUSTIFICANTE -->
    <div class="modal fade" id="modalAceptaJustificante" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <h4 class="modal-title" id="myModalLabel">Aprobación de presupuesto</h4>
          </div>
          <div class="modal-body">
            <div class="bs-example">
              <br/>
              <p><span class="label label-success">Atención</span> El comprobante será aprobado para la contabilidad.</p>
            </div>
            <div class="form-group">
              <label for="message-text" class="control-label">Comentarios:</label>              
              <textarea class="form-control" id="message-text" data-ng-model="commentsForBudget"></textarea>
            </div>
          </div>
          <div class="modal-footer">
            <p class="text-center">
              <a type="button" data-dismiss="modal" class="btn btn-warning"
              data-ng-disabled="commentsForBudgetIsEmpty()"
              data-ng-click="commentsForBudgetIsEmpty() || changeBudgetStatus(commentsForBudget,REPORT_APPROVED)"               
              href="#">Aceptar</a>              
            </p>            
          </div>
        </div>
      </div>
    </div><!-- MODAL PARA ACEPTAR EL JUSTIFICANTE -->

    <!-- MODAL PARA RECHAZAR EL JUSTIFICANTE -->
    <div class="modal fade" id="modalRechazaJustificante" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <h4 class="modal-title" id="myModalLabel">Rechazo de presupuesto</h4>
          </div>
          <div class="modal-body">
            <div class="bs-example">
              <br/>
              <p><span class="label label-danger">Atención</span> El comprobante será rechazado para la revisión del usuario.</p>
            </div>
            <div class="form-group">
              <label for="message-text" class="control-label">Comentarios:</label>
              <textarea class="form-control" id="message-text" data-ng-model="commentsForBudget"></textarea>  
            </div>
          </div>
          <div class="modal-footer">
            <p class="text-center">
              <a type="button" data-dismiss="modal" class="btn btn-warning"
              data-ng-disabled="commentsForBudgetIsEmpty()"
              data-ng-click="commentsForBudgetIsEmpty() || changeBudgetStatus(commentsForBudget,REPORT_REJECTED)"               
              href="#">Aceptar</a>
            </p>
          </div>
        </div>
      </div>
    </div><!-- MODAL PARA REMOVER TRX -->
    
        <!-- MODAL PARA RECHAZAR TRX -->
    <div class="modal fade" id="modalRechazarTrx" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <h4 class="modal-title" id="myModalLabel">Rechazar transacción</h4>
          </div>          
          <div class="modal-body">
            <div class="bs-example">
              <br/>
              <p><span class="label label-danger">Atención</span> La transacción será removida del presupuesto.</p>
            </div>

            <div class="form-group">
              <label for="message-text" class="control-label">Comentarios:</label>
              <textarea class="form-control" id="message-text" data-ng-model="commentsForInvoice"></textarea>
            </div>
          </div>
          <div class="modal-footer">
            <p class="text-center">
              <a type="button" data-dismiss="modal" class="btn btn-warning"
              data-ng-disabled="commentsForInvoiceIsEmpty()"
              data-ng-click="commentsForInvoiceIsEmpty() || rejectATransaction(commentsForInvoice)"               
              href="#">Aceptar</a>
            </p>
          </div>
        </div>
      </div>
    </div><!-- MODAL PARA RECHAZAR TRX -->
    
    
   	<!-- MODAL INFORMACION RECHAZO TRX -->
	<div class="modal fade" id="modalVerInfo" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
            <h4 class="modal-title" id="myModalLabel">Información</h4>
          </div>
          <div class="modal-body">
            <div class="bs-example">
              	<div class="alert alert-warning ng-binding ng-scope" role="alert">
            	{{transactionCommentSelected}}
            	</div>
            </div>
          </div>
          <div class="modal-footer">
            <p class="text-center">
              <a type="button" data-dismiss="modal" class="btn btn-warning" 
              href="#">Aceptar</a>
            </p>
          </div>
        </div>
      </div>
    </div>
	<!-- TERMINA INFORMACION RECHAZO TRX -->
	