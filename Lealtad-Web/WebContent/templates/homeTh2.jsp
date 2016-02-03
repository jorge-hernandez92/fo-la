<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<div class="panel-body back-sivale" ng-controller="getClassifications">
 
	<div class="container">
	<div class="row">

		<div class="col-lg-6-user-email col-md-6">
			<div class="panel panel-green">
				<div class="panel-heading">
					<div class="row">
						<div class="col-xs-3">
							<img class="manImg" src="img/home/usuario.png"></img>
						</div>
						<div class="col-xs-9 text-right">
							<div class="font-title-item">Nombre de Usuario</div>
							<div id="quickfit-user"
								title="${sessionScope.userDetails.userName}"
								class="huge font-size-email">{{user.firstName}} {{user.lastName1}} {{user.lastName2}}</div>
								
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="col-lg-6-user-email col-md-6">
			<div class="panel panel-green">
				<div class="panel-heading" data-ng-controller="getBalance">
					<div class="row">
						<div class="col-xs-3">
							<img class="manImg" src="img/home/monto.png"></img>
						</div>
						<div class="col-xs-9 text-right">
							<div class="font-title-item">Saldo Actual</div>
							<div class="huge">&#36;{{(balance | number:2) || '0.00'}}</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
	</div>
	
	<div class="container" ng-cloak>
			<div class="panel panel-default table-top-sivale">
				<div class="panel-heading">Últimas Transacciones</div>

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