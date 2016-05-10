<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<div class="panel-body">
<!-- 	<div class="navbar container"> -->
<!-- 		<ol class="breadcrumb breadcrumb-arrow"> -->
<!-- 			<li><a ui-sref="campaigns">Campañas</a></li> -->
<!-- 			<li><a ui-sref="campaign">Publicaciones</a></li> -->
<!-- 			<li class="active"><span>{{publication.name}}</span></li> -->
<!-- 		</ol> -->
<!-- 	</div> -->
	
	<div class="container">
		<div class="panel panel-default table-top-sivale">

			<div > 
				<div class="row">
					<div>
						<div >
							<div >
<!-- 								<div class="panel-heading"> -->
<!-- 									<div class="container-fluid">Archivos</div> -->
<!-- 								</div> -->
								<div  data-ng-controller="getAttachedFiles">

<!-- 									<table ng-table="tableAttachedFiles" class="table"> -->
<!-- 										<tr ng-repeat="file in $data"> -->

<!-- 											<td header-class="'text-left'"> -->
<!-- 												<a href="#" -->
<!-- 												data-ng-click="getFile(file)" -->
<!-- 												>{{file.fileName}}</a> -->
<!-- 											</td> -->
	
<!-- 										</tr> -->
<!-- 									</table> -->
								</div>
							</div>
						</div>

						<div>
							<div class="">
								<div class="publication-html"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>