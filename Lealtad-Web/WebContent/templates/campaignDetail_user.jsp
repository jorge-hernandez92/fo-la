<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<div class="panel-body">
<!-- 	<div class="navbar container"> -->
<!-- 		<ol class="breadcrumb breadcrumb-arrow"> -->
<!-- 			<li><a ui-sref="campaigns">Campañas</a></li> -->
<!-- 			<li class="active"><span>Publicaciones</span></li> -->
<!-- 		</ol> -->
<!-- 	</div> -->
<!-- 	<div class="container"> -->
<!-- 		<div class="panel panel-default table-top-sivale"> -->
<!-- 			<div class="panel-heading"> -->
<!-- 				<div class="container-fluid"> -->
<!-- 					<div class="navbar-header">{{campaign.campaignName}}</div> -->
<!-- 					<div id="navbar" class="navbar-collapse collapse"> -->
<!-- 						<ul class="nav navbar-nav navbar-right">Duración -->
<!-- 							{{campaign.startDate | date:'dd/MM/yyyy'}} al {{campaign.endDate | date:'dd/MM/yyyy'}} -->
<!-- 						</ul> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</div> -->

<!-- <!-- 			<div class="input-group"> --> -->
<!-- <!-- 				<div class="input-group-addon"> --> -->
<!-- <!-- 					<span class="glyphicon glyphicon-search" aria-hidden="true"></span> --> -->
<!-- <!-- 				</div> --> -->
<!-- <!-- 				<input class="form-control" type="text" --> -->
<!-- <!-- 					data-ng-model="filters.myfilter" placeholder="Buscar Campaña" /> --> -->
<!-- <!-- 			</div> --> -->

<!-- 			<div class="panel-body"> -->
<!-- 				<div data-ng-controller="getCampaign" ng-cloak> -->
<!-- 					<table ng-table="tablePublications" class="table"> -->
<!-- 						<tr ng-repeat="publication in $data"> -->
							
<!-- 							<td title="'Tipo'" header-class="'text-left'" -->
<!-- 								sortable="'name'"><span class="label label-default">{{publication.catPublicationType.name}}</span></td> -->
							
<!-- 							<td title="'Publicacion'" header-class="'text-left'" -->
<!-- 								sortable="'name'">{{publication.name}}</td> -->

<!-- 							<td title="'Fecha de Publicacion'" header-class="'text-left'" -->
<!-- 								sortable="'publishedDate'">{{publication.publishedDate | date:'dd/MM/yyyy'}}</td> -->

<!-- 							<td title="'Descripción'" header-class="'text-left'" -->
<!-- 								sortable="'dataFilePage'">{{publication.description}}</td> -->
<!-- 							<td><a href="#" -->
<!-- 								data-ng-click="updatePublication(publication)" -->
<!-- 								ui-sref="publication"> Ver</a> -->
<!-- 						</tr> -->
<!-- 					</table> -->
<!-- 				</div> -->
<!-- 			</div> -->
			
<!-- 			<div class="container" data-ng-controller="getCampaign" ng-cloak> -->
<!-- 				<div class="row"> -->
<!-- 					<div class="col-sm-6 col-md-3" -->
<!-- 						ng-repeat="publication in publications" -->
<!-- 						style="padding-right: 0px; padding-left: 0px;"> -->
<!-- 						<div class="grid" data-toggle="tooltip" data-placement="left" -->
<!-- 							title="{{publication.description}}"> -->
<!-- 							<figure class="effect-ming"> -->
<!-- 								<img src="img/img_camp/{{getIndex()}}cam.jpg" alt="" /> -->
<!-- 								<figcaption> -->
<!-- 									<h5>{{publication.name}}</h5> -->
<!-- 									<p>{{publication.catPublicationType.name}}</p> -->
<!-- 									<p>{{publication.publishedDate | date:'dd/MM/yyyy'}}</p> -->
<!-- 									<a href="#" data-ng-click="updatePublication(publication)" -->
<!-- 										ui-sref="publication">View more</a> -->
<!-- 								</figcaption> -->
<!-- 							</figure> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</div> -->

<!-- 		</div> -->
		
		
					<!-- -.-.-.-.-.-.-.-. -->

	<div class="container">
		<h1 class="text-center">
			<font color="white">Conoce las Publicaciones</font>
		</h1>
	</div>

	<div class="container" data-ng-controller="getCampaign" ng-cloak>
			<div class="row">
				<div class="col-sm-6 col-md-3"
					ng-repeat="publication in publications"
					style="padding-right: 0px; padding-left: 0px;">
					<div class="grid" data-toggle="tooltip" data-placement="left"
						title="{{publication.description}}">
						<figure class="effect-ming">
							<img src="img/img_camp/{{getIndex()}}cam.jpg" alt="" />
							<figcaption>
								<h5>{{publication.name}}</h5>
								<p>{{publication.catPublicationType.name}}</p>
								<p>{{publication.publishedDate | date:'dd/MM/yyyy'}}</p>
								<a href="#" data-ng-click="updatePublication(publication)"
									ui-sref="publication">View more</a>
							</figcaption>
						</figure>
					</div>
				</div>
			</div>
		</div>


	</div>
</div>