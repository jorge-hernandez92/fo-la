<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<div>
 
 	<div class="container" ng-if="companyMenu">
		<div class="panel ">							
			<div class="panel-body back-sivale">
				<div class="row" data-ng-controller="getClassifications" ng-cloak>
					<div class="col-sm-6 col-md-4 back-sivale"
						ng-repeat="class in classifications">
						<div class="thumbnail">
							<div class="thumbnail2 div-sivale portfolio-box">
								<div class="thumbnail2_wrapper">
									<a href="#"
										data-ng-click="selectClassification(class)"
										ui-sref="campaigns"> <img
										src="img/company_logo/{{class.catViews.logos}}/logo.png" class="img-responsive"
										alt="">
										<div class="portfolio-box-caption">
											<div class="portfolio-box-caption-content">
												<div class="project-name">{{class.className}}</div>
											</div>
										</div>
									</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div class=" font-color-text">
	<div class="row">

		<div class="col-lg-6-user-email col-md-7">
			<div >
				<div >
						<div class="row">

							<div class="col-xs-6 col-sm-4"></div>

							<div class="col-xs-6 col-sm-1">
								<i class="fa fa-user fa-5x" aria-hidden="true"></i>
							</div>

							<div class="col-xs-6 col-sm-5">

								<div class="font-title-item">Nombre de Usuario</div>
								<div id="quickfit-user"
									title="${sessionScope.userDetails.userName}" class="huge">{{user.firstName}}
									{{user.lastName1}} {{user.lastName2}}</div>
							</div>

						</div>
					</div>
			</div>
		</div>

		<div class="col-lg-6-user-email col-md-5">
			<div >
				<div  data-ng-controller="getBalance">
						<div class="row">

							<div class="col-xs-6 col-sm-1"></div>

							<div class="col-xs-6 col-sm-1">
								<i class="fa fa-usd fa-5x" aria-hidden="true"></i>
							</div>

							<div class="col-xs-6 col-sm-7">

								<div class="font-title-item">Saldo Actual</div>
								<div class="huge">&#36;{{(balance | number:2) || '0.00'}}</div>

							</div>

							<div class="col-xs-6 col-sm-1"></div>

						</div>
					</div>
			</div>
		</div>

	</div>
	</div>
	
	<div class="container font-color-text" ng-cloak>
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