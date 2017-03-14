<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>		
		
<section id="transaction">

		<br><br><br>

	<div style="text-align: center;">
		<h1>Últimos movimientos de tu tarjeta</h1>
	</div>
	
	<br>


	
	<br><br>
	
	<div class="row">

			<div class="col-md-6" >
				<p style="padding-left: 160px;">
					<button type="button" ui-sref="account_status" class="btn btn-home btn-lg"
						style="padding: 25px 0px;min-width: 450px;font-size: 18px;background-color: #2d96cd;border-color: #2d96cd;">
						
						<i class="fa fa-line-chart" aria-hidden="true" style="vertical-align: middle; padding-left: -30px;font-size: 45px;"></i>
						
						Consulta tu estado <br/>de Cuenta<br/>
						
					</button>
				</p>

			</div>

			<div class="col-md-5" data-ng-controller="getBalance">

				<p style="padding-left: 70px;">
					<button type="button" class="btn btn-home btn-lg"
						style="padding: 25px 0px; cursor: default; min-width: 450px; background-color: #2d96cd;border-color: #2d96cd;">

						<i class="fa fa-credit-card" aria-hidden="true"
							style="vertical-align: middle; padding-left: -30px; font-size: 45px;"></i>

						Saldo en tu Tarjeta<br />&#36; {{(balance | number:2) || '0.00'}}<br />

					</button>
				</p>

			</div>

		</div>
		
		<br>
		
			<div>

		<div class="container font-color-text" style="width: 1090px;" ng-cloak >
			<div class="panel panel-default table-top-sivale">
				<div class="panel-heading" style="background-color: #2d96cd;"></div>

				<div class="panel-body back-sivale">
					<div data-ng-controller="getLastTransactionByCard" ng-cloak>
						<table data-ng-table="tableLastTransactions"
							class="table table-striped table-responsive table-hover">
							<tr data-ng-repeat="lastTransaction in $data">

								<td data-title="'Fecha'">{{lastTransaction.transactionDate}}</td>

								<td data-title="'Establecimiento'">
									{{lastTransaction.acceptorName}}</td>

								<td data-title="'Monto'">&#36;
									{{convertToPositive(lastTransaction.amount) | number:2}}</td>

							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
		
	</div>
	
</section>