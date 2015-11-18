<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
	
    <div data-ng-controller="conciliacionController">    
    <!-- MODAL DETALLE FACTURA-->

	<div class="modal fade" id="modalDetalleFactura" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Detalle de Factura</h4>
				</div>
				<div class="modal-body">
					<!--Formulario Alta Justificante-->
					<div class="bs-example">

						<table class="table table-striped">
							<tbody>
								<tr>
									<td>Comercio:</td>
									<td>{{invoiceSelected.name || 'Sin comercio'}}</td>
								</tr>
								<tr>
									<td>RFC:</td>
									<td>{{invoiceSelected.issuerRfc || 'Sin RFC'}}</td>
								</tr>
								<tr>
									<td>Fecha:</td>
									<td>{{invoiceSelected.invoiceDate}}</td>
								</tr>
								<tr>
									<td>Monto:</td>
									<td>&#36;{{invoiceSelected.amount | number:2}}</td>
								</tr>
								<tr>
									<td>Ajuste(propina):</td>
									<td>&#36;{{(invoiceSelected.tip | number:2) || (0 |
										number:2)}}</td>
								</tr>
								<tr>
									<td>Monto Total:</td>
									<td>&#36;{{(invoiceSelected.totalAmount | number:2) ||
										(invoiceSelected.amount | number:2)}}</td>
								</tr>
								<tr data-ng-if="invoiceSelected.comment != undefined">
									<td>Comentarios:</td>
									<td>{{invoiceSelected.comment}}</td>
								</tr>


								<tr
									data-ng-if="invoiceSelected.pdfFile || invoiceSelected.xmlFile">
									<td>Factura:</td>
									<td><a data-ng-if="invoiceSelected.pdfFile"
										data-ng-click="downloadFile(invoiceSelected.pdfFileName,invoiceSelected.pdfFile)"
										href="#"> <img src="img/icons/pdf-icon.png" alt="XML">
									</a> <a data-ng-if="invoiceSelected.xmlFile"
										data-ng-click="downloadFile(invoiceSelected.xmlFileName,invoiceSelected.xmlFile)"
										href="#"> <img src="img/icons/xml-icon.png" alt="pdf">
									</a></td>
								</tr>
								<tr data-ng-if="invoiceSelected.ticketPhoto">
									<td>Ticket:</td>
										<td>
											<a  data-ng-click="downloadFile(invoiceSelected.ticketPhotoName,invoiceSelected.ticketPhoto)"
												href="#"> <img src="img/icons/png-icon.png" alt="png">
											</a>
										</td>
								</tr>

							</tbody>
						</table>
						<br />

						<s:if test="disassociateInvoicesOfTransaction">
							<p data-ng-if="disassociateInvoiceBool == true"
								class="text-center">
								<a type="button" class="btn btn-warning"
									data-ng-disabled="enableDisable(budgetSelected.reportStatus)"
									data-dismiss="modal"
									data-ng-click="enableDisable(budgetSelected.reportStatus) ||disassociateInvoice(invoiceSelected.invoiceId, (invoiceSelected.totalAmount || invoiceSelected.amount), invoiceSelected.amount)"
									href="#">Desvincular</a>
							</p>
						</s:if>

					</div>
				</div>
			</div>
		</div>
	</div>
	<!--TERMINA MODAL DETALLE FACTURA-->

	<!--
	Agregar el campo de propina y ajustar este campo donde se requiere para sumarlo con el monto de la factura y luego con el de la transaccion 
	para obtener el nuevo monto comprobado y enviarlo al servicio para actualizarlo en el registro. 
	-->
	<!-- MODAL CONCILIAR TRANSACCION #1 -->
	<div class="modal fade" id="modalConciliarTransaccion" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Conciliación Manual</h4>
				</div>
				<div class="modal-body">

					<ul class="nav nav-tabs" role="tablist">
						<li class="active"><a href="#tabFacturasGral" role="tab"
							data-toggle="tab">Facturas</a></li>
						<li><a href="#tabTicketsGral" role="tab" data-toggle="tab">Ticket</a></li>
					</ul>

					<div class="tab-content">
						<!-- TAB Facturas -->
						<div role="tabpanel" class="tab-pane active" id="tabFacturasGral">


							<!--TABLA DE FACTURAS MISMO USUARIO-->
							<table data-ng-table="tableInvoicesNoBudget"
								class="table table-striped table-responsive table-hover">
																							
								<tr data-ng-repeat="invoiceNoBudget in $data">
																
									<td data-title="'Comercio'">{{invoiceNoBudget.name}}</td>
									<td data-title="'Fecha'">{{invoiceNoBudget.invoiceDate}}</td>
									<td data-title="'RFC Emisor'">{{invoiceNoBudget.issuerRfc}}
										<span class="label label-danger">Sugerida</span>
									</td>
									<td id="monto_G01" data-title="'Monto'">&#36;{{invoiceNoBudget.amount
										| number:2}}</td>
									<td style="width: 150px" data-title="'Propina'">
										<div class="input-group">
											<span class="input-group-addon">$</span>

											<!-- Cambiar el invoiceNoBudget.amount por el campo de propina de la factura  -->
											<input type="number" class="form-control" string-to-number
												data-ng-model="(invoiceNoBudget.tip)" />

										</div>
									</td>
									<!-- Cambiare el numero 10 por el campo de propina de la factura -->
									<td style="width: 80px" id="total_G01" data-title="'Total'">&#36;{{(getAmountTotalInvoice((invoiceNoBudget.amount),(invoiceNoBudget.tip),
										invoiceNoBudget.invoiceId) | number:2)}}</td>
									<td style="width: 40px" data-title="'Asociar'"><input
										type="radio" style="vertical-align: up; margin: 0px;"
										name="radioFactura"
										data-ng-click="setInvoiceIdSelected(invoiceNoBudget.invoiceId,invoiceNoBudget.tip,invoiceNoBudget.amount)">
									</td>	
								</tr>
							</table>
							<div data-ng-if="!thereInvoicesSugguested" role="alert" style="text-align: center;">
								<p><span class="glyphicon glyphicon-exclamation-sign"
										aria-hidden="true"></span> 
									<span class="sr-only">Error:</span>
									 No existen facturas sugeridas a mostrar.
								</p>
							</div>								
							<!--TERMINA TABLA DE FACTURAS MISMO USUARIO-->

							<!-- ACORDEON PARA TABLA DE MAS FACTURAS-->
							<div class="panel-group" id="accordion" role="tablist"
								aria-multiselectable="true">

								<div class="panel panel-default">
									<div class="panel-heading" role="tab" id="headingTwo">
										<h3 class="panel-title panel-title-accordeon link-more-invoces">
											<a class="collapsed " data-toggle="collapse"
												data-parent="#accordion" href="#collapseTwo"
												aria-expanded="false" aria-controls="collapseTwo"> Ver
												resto de facturas </a>
										</h3>
									</div>
									<div id="collapseTwo" class="panel-collapse collapse"
										role="tabpanel" aria-labelledby="headingTwo">
										<div class="panel-body">

											<table data-ng-table="tableMoreInvoicesNoBudget"
												class="table table-striped table-responsive table-hover">
												<tr data-ng-repeat="invoiceNoBudget in $data">
													<td data-title="'Comercio'">{{invoiceNoBudget.name}}</td>
													<td data-title="'Fecha'">{{invoiceNoBudget.invoiceDate}}</td>
													<td data-title="'RFC Emisor'">{{invoiceNoBudget.issuerRfc}}</td>
													<td style="width: 80px" id="monto_G01" data-title="'Monto'">&#36;{{invoiceNoBudget.amount
														| number:2}}</td>
													<td style="width: 150px" data-title="'Propina'">
														<div class="input-group">
															<span class="input-group-addon">$</span>

															<!-- Cambiar el invoiceNoBudget.amount por el campo de propina de la factura  -->
															<input type="number" class="form-control"
																data-ng-model="invoiceNoBudget.tip" />

														</div>
													</td>
													<!-- Cambiare el numero 10 por el campo de propina de la factura -->
													<td style="width: 80px" id="total_G01" data-title="'Total'">&#36;{{(getAmountTotalInvoice((invoiceNoBudget.amount),(invoiceNoBudget.tip),
														invoiceNoBudget.invoiceId) | number:2)}}</td>
													<td style="width: 40px" data-title="'Asociar'"><input
														type="radio" style="vertical-align: up; margin: 0px;"
														name="radioFactura"
														data-ng-click="setInvoiceIdSelected(invoiceNoBudget.invoiceId,invoiceNoBudget.tip,invoiceNoBudget.amount)">
													</td>
												</tr>
											</table>
											<div data-ng-if="!thereMoreInvoices" role="alert" style="text-align: center;">
												<p><span class="glyphicon glyphicon-exclamation-sign"
														aria-hidden="true"></span> 
													<span class="sr-only">Error:</span>
													 No existen facturas a mostrar.
												</p>
											</div>	
										</div>
									</div>
								</div>
							</div>
							<!-- TERMINA ACORDEON PARA TABLA DE MAS FACTURAS-->

							<!-- ACORDEON PARA TABLA DE FACTURAS DE OTROS USUARIOS-->
							<s:if test="getInvoicesOtherUsers">
								<div class="panel-group" id="accordion" role="tablist"
									aria-multiselectable="true">
									<div class="panel panel-default">
										<div class="panel-heading" role="tab" id="headingThree">
											<h3 class="panel-title panel-title-accordeon">
												<a class="collapsed" data-toggle="collapse"
													data-parent="#accordion" href="#collapseThree"
													aria-expanded="false" aria-controls="collapseThree">
													Ver facturas de otros usuarios </a>
											</h3>
										</div>
										<div id="collapseThree" class="panel-collapse collapse"
											role="tabpanel" aria-labelledby="headingThree">
											<div class="panel-body">
												<div class="panel-heading">
													<div align="center">
														<div class="input-group col-md-4">
															<div class="input-group-addon">
																<span class="glyphicon glyphicon-calendar"></span>
															</div>
															<input type="daterange" data-ng-model="invoiceDateRange"
																title="busqueda de facturas entre fechas"
																class="form-control" placeholder="Search">
															<div class="input-group-btn">
																<button class="btn btn-default button-search"
																	type="submit"
																	data-ng-click="getInvoicesNoTransactionOtherUsers(invoiceDateRange.startDate, invoiceDateRange.endDate)"
																	style="padding: 9px 12px">
																	<i class="glyphicon glyphicon-search"></i>
																</button>
															</div>
														</div>
													</div>
												</div>

												<table data-ng-table="tableInvoicesNoTransactionOtherUsers"
													class="table table-striped table-responsive table-hover">
													<tr data-ng-repeat="invoiceNoBudget in $data">
														<td data-title="'Comercio'">{{invoiceNoBudget.name}}</td>
														<td data-title="'Fecha'">{{invoiceNoBudget.invoiceDate}}</td>
														<td data-title="'RFC Emisor'">{{invoiceNoBudget.issuerRfc}}</td>
														<td style="width: 80px" id="monto_G01"
															data-title="'Monto'">&#36;{{invoiceNoBudget.amount |
															number:2}}</td>
														<td style="width: 150px" data-title="'Propina'">
															<div class="input-group">
																<span class="input-group-addon">$</span>

																<!-- Cambiar el invoiceNoBudget.amount por el campo de propina de la factura  -->
																<input type="number" class="form-control"
																	data-ng-model="invoiceNoBudget.tip" />

															</div>
														</td>
														<!-- Cambiare el numero 10 por el campo de propina de la factura -->
														<td style="width: 80px" id="total_G01"
															data-title="'Total'">&#36;{{(getAmountTotalInvoice((invoiceNoBudget.amount),(invoiceNoBudget.tip),
															invoiceNoBudget.invoiceId) | number:2)}}</td>
														<td style="width: 40px" data-title="'Asociar'"><input
															type="radio" style="vertical-align: up; margin: 0px;"
															name="radioFactura"
															data-ng-click="setInvoiceIdSelected(invoiceNoBudget.invoiceId,invoiceNoBudget.tip,invoiceNoBudget.amount)">
														</td>
													</tr>
												</table>
											</div>
										</div>
									</div>
								</div>
								<!-- TERMINA ACORDEON PARA TABLA DE FACTURAS DE OTROS USUARIOS-->
							</s:if>


							<!--<h3>Tabla de Comentarios</h3>-->
							<table class="table">
								<thead>
								</thead>
								<tbody>
									<tr>
										<td style="width: 120px;">Comentarios:</td>
										<td colspan="6"><textarea class="form-control"
												id="message-text" data-ng-model="comments"></textarea></td>
									</tr>
								</tbody>
							</table>

							<p class="text-center" id="alertaPropinaTicketGral"
								data-ng-if="isTipMax" style="color: red; font-size: 120%">Propina
								máxima de {{tip*100}}&#37;</p>


							<p class="text-center" id="alertaPropinaFacGral"
								style="color: red; font-size: 120%"></p>

							<s:if test="reconcileATransaction">
								<p class="text-center">
									<a type="button" data-dismiss="modal" class="btn btn-warning"
										data-ng-disabled="enableDisable(budgetSelected.reportStatus) || (radioIsCheck() || commentsIsEmpty() || isTipMax)"
										data-ng-click="((radioIsCheck() || commentsIsEmpty()) || enableDisable(budgetSelected.reportStatus)) || isTipMax || reconcileInvoiceSelected()"
										href="#">Vincular</a>
								</p>
							</s:if>

						</div>
						<!-- Termina TAB Facturas -->
						
						
						<!-- TAB Tickets -->
											
						<div role="tabpanel" class="tab-pane" id="tabTicketsGral">
						<form name="ticketForm" novalidate >	
							<table class="table">
								<thead>
									<tr>
										<td colspan="6"><h5>Ingresa datos de ticket</h5></td>
									</tr>
								</thead>
								<tbody>
									<tr style="height: 75px;">
										<td style="width: 100px;">Fecha:</td>
										<td style="width: 200px;">
											<div class="input-group">
												<div class="input-group date" id="datetimepicker1">
													<input type="text" class="form-control"
														data-provide="datepicker" data-ng-model="ticket.date" required>
													<span class="input-group-addon"> <span
														class="glyphicon glyphicon-calendar"></span>
													</span>
												</div>
											</div>
										</td>
										<td style="width: 100px;">Ticket:</td>
										<td style="width: 200px;"><input class="upload-file" data-max-size="245760" id="file" type="file"
											name="file" required></td>
									</tr>
									<tr style="height: 75px;">
										<td>Monto:</td>
										<td>
											<div class="input-group">
												<span class="input-group-addon">$</span> <input type="number"
													class="form-control"
													data-ng-model="ticket.amount" required>
											</div>
										</td>
										<td>Propina:</td>
										<td>
											<div class="input-group">
												<span class="input-group-addon">$</span> <input type="number"
													class="form-control"													
													data-ng-model="ticket.tip" required>
											</div>
										</td>
 										<td>Total:</td> 
 										<td id="total_ticket_gral">&#36;{{getAmountTotalTicket(ticket.amount,ticket.tip) | number : 2}}</td> 
										
									</tr>
									<tr style="height: 75px;">
										<td>Comentarios:</td>
										<td colspan="5"><textarea class="form-control"
												id="message-text" data-ng-model="ticket.comment" required></textarea></td>
									</tr>
								</tbody>
							</table>
							
							<p class="text-center" id="alertaPropinaTicketGral"
								data-ng-if="isTipTicketMax" style="color: red; font-size: 120%">Propina
								máxima de {{tip*100}}&#37;</p>							
							<p class="text-center">
								<a type="button" class="btn btn-warning" data-dismiss="modal"
									data-ng-disabled="ticketForm.$invalid || isTipTicketMax" 
									data-ng-click="ticketForm.$invalid || isTipTicketMax || ticketUpload()">Vincular</a>
							</p>
						</form>
						</div>						
						<!-- Termina TAB Tickets -->
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--MODAL CONCILIAR TRANSACCION -->
</div>

