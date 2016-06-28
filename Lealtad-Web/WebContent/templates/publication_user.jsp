<%@ page language="java" contentType="text/html; charset=utf-8"
 	pageEncoding="utf-8"%>


<div class="panel-body back-sivale">
	
	<div class="container">
		<div class="panel panel-default table-top-sivale">
			<div class="panel-heading">
				<div class="container-fluid">
					<div class="navbar-header">{{campaign.campaignName}}</div>
					<div id="navbar" class="navbar-collapse collapse">
						<ul class="nav navbar-nav navbar-right">

						</ul>
					</div>
				</div>
			</div>

			<div class="panel-body back-sivale">
				<div class="row">
					<div>
						<div class="col-md-2">
							<div class="panel panel-default table-top-sivale">
								<div class="panel-heading">
									<div class="container-fluid">Archivos</div>
								</div>
								<div class="back-sivale" data-ng-controller="getAttachedFiles">

									<table ng-table="tableAttachedFiles" class="table">
										<tr ng-repeat="file in $data">

											<td header-class="'text-left'">
												<a href="#"
												data-ng-click="getFile(file)"
												>{{file.fileName}}</a>
											</td>
	
										</tr>
									</table>
								</div>
							</div>
						</div>

						<div class="col-md-10">
							<div class="panel panel-default table-top-sivale">
								<div class="panel-heading">
									<div class="container-fluid"><span class="label label-default">{{publication.catPublicationType.name}}</span> {{publication.name}}</div>
								</div>
								<div class="panel-body back-sivale publication-html"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

