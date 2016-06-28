<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	
<!-- 	<div ng-controller="triggerModal" > -->
<%-- 	<jsp:include page="modals/viewPublication.jsp" /> --%>

<!-- <div class="sk-fading-circle" ng-show="loadingPublicationImage" > -->
<!-- 	<div class="sk-circle1 sk-circle"></div> -->
<!-- 	<div class="sk-circle2 sk-circle"></div> -->
<!-- 	<div class="sk-circle3 sk-circle"></div> -->
<!-- 	<div class="sk-circle4 sk-circle"></div> -->
<!-- 	<div class="sk-circle5 sk-circle"></div> -->
<!-- 	<div class="sk-circle6 sk-circle"></div> -->
<!-- 	<div class="sk-circle7 sk-circle"></div> -->
<!-- 	<div class="sk-circle8 sk-circle"></div> -->
<!-- 	<div class="sk-circle9 sk-circle"></div> -->
<!-- 	<div class="sk-circle10 sk-circle"></div> -->
<!-- 	<div class="sk-circle11 sk-circle"></div> -->
<!-- 	<div class="sk-circle12 sk-circle"></div> -->
<!-- </div> -->

<!-- <div class="panel-body publication-html" > -->

<!-- </div> -->

<!-- <div class="container"  ng-show="files"> -->
<!-- 		<div class="row" style="color: white;"> -->
<!-- 		<div class="col-md-3"></div> -->
<!-- 		<div class="col-md-6"> -->
<!-- 			<div class="list-group" > -->
<!-- 				<a  class="list-group-item active text-center">Archivos Adjuntos</a> -->
<!-- 					<a  class="list-group-item"  -->
<!-- 					href="#" ng-repeat="file in attachedFiles"   -->
<!-- 					data-ng-click="getFile(file)">{{file.fileName}}</a>				 -->
<!-- 			</div> -->
<!-- 		</div> -->

<!-- 		<div class="col-md-3"> -->
<!-- 			<div class="col-md-2"></div> -->
<!-- 		</div> -->
	
<!-- 	</div> -->
  
<!-- </div> -->
<!-- </div> -->

<!-- <br> -->

<div class="panel-body back-sivale" ng-controller="triggerModal">
	<jsp:include page="modals/viewPublication.jsp" />
	
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
								<div class="back-sivale" >

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
								<div class="panel-body back-sivale publication-html" style="background-color: rgb(92, 92, 92);"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>