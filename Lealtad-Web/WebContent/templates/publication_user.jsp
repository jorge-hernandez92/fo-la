<%@ page language="java" contentType="text/html; charset=utf-8"
 	pageEncoding="utf-8"%>
 	
 	
<!-- <header class="header-image-publication"> -->
	
<!-- 	<div class="headline"> -->
<!-- 		<div class="container"> -->
<!-- 		</div> -->
<!-- 	</div> -->
	
<!-- 	<br><br> -->
<!-- 	<br><br> -->
<!-- 	<br><br> -->
<!-- 	<br><br> -->
	
<!-- </header> -->

<!-- <div class="panel-body back-sivale"> -->

<!-- 	<div class="container"> -->
<!-- 		<div class="panel panel-default table-top-sivale"> -->
<!-- 			<div class="panel-heading"> -->
<!-- 				<div class="container-fluid"> -->
<!-- 					<div class="navbar-header">{{campaign.campaignName}}</div> -->
<!-- 					<div id="navbar" class="navbar-collapse collapse"> -->
<!-- 						<ul class="nav navbar-nav navbar-right"> -->

<!-- 						</ul> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</div> -->

<!-- 			<div class="panel-body back-sivale"> -->
<!-- 				<div class="row"> -->
<!-- 					<div> -->
<!-- 						<div class="col-md-2"> -->
<!-- 							<div class="panel panel-default table-top-sivale"> -->
<!-- 								<div class="panel-heading"> -->
<!-- 									<div class="container-fluid">Archivos</div> -->
<!-- 								</div> -->
<!-- 								<div class="back-sivale" data-ng-controller="getAttachedFiles"> -->

<!-- 									<table ng-table="tableAttachedFiles" class="table"> -->
<!-- 										<tr ng-repeat="file in $data"> -->

<!-- 											<td header-class="'text-left'"><a href="#" -->
<!-- 												data-ng-click="getFile(file)">{{file.fileName}}</a> -->
<!-- 											</td> -->

<!-- 										</tr> -->
<!-- 									</table> -->
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 						</div> -->

<!-- 						<div class="col-md-10"> -->
<!-- 							<div class="panel panel-default table-top-sivale"> -->
<!-- 								<div class="panel-heading"> -->
<!-- 									<div class="container-fluid"> -->
<!-- 										<span class="label label-default">{{publication.catPublicationType.name}}</span> -->
<!-- 										{{publication.name}} -->
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 								<div class="panel-body back-sivale publication-html"></div> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</div> -->
<!-- </div> -->

<div data-ng-controller="getAttachedFiles">

	<br>
	
	<div class="panel-body publication-html"></div>

	<div class="container" ng-show="files">
		<div class="row" style="color: white;">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<div class="list-group" data-ng-controller="getAttachedFiles">
					<a class="list-group-item active text-center">ARCHIVOS ANEXOS</a>
					<a class="list-group-item" href="#"
						ng-repeat="file in attachedFiles" data-ng-click="getFile(file)">{{file.fileName}}</a>
				</div>
			</div>

			<div class="col-md-3">
				<div class="col-md-2"></div>
			</div>

		</div>

	</div>
</div>


<br><br><br>
<br><br><br>
<br><br><br>


	<footer class="footerTH">
		<div>
			<div >
				<div class="row">
					<div class="col-md-3"></div>
					<div class="col-md-6">
					<hr style="border-top: 2px solid rgb(100,100,100);">
						<h3 class="text-center"
							style="font-size: 14px; font-family: GothamBold; color:rgb(100,100,100);">Plataforma elaborada y administrada 
							por Sí Vale México, S.A. de C.V., para uso exclusivo de Ford Motor Company de México, 
							S.A. de C.V. y sus filiales.</h3>
					</div>
					<div class="col-md-3"></div>
				</div>
			</div>
		</div>
	</footer>