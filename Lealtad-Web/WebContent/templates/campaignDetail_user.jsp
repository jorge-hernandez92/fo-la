<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<div class="panel-body">


	<div class="container">
		<h1 class="text-center">
			<font color="white">Conoce las Publicaciones</font>
		</h1>
	</div>
	
	<br><br><br><br>

	<div class="container" >
		<div class="jumbotron" style="background-color: rgba(220, 220, 220, 0.35);" data-ng-controller="getCampaign" ng-cloak>
			<div class="row">
				<div class="col-sm-6 col-md-3"
					ng-repeat="publication in publications"
					style="padding-right: 0px; padding-left: 0px;">
					<div class="grid" data-toggle="tooltip" data-placement="left"
						title="{{publication.description}}">
						<figure class="effect-ming">
							<img ng-src="img/img_camp/{{publication.indexImage2}}cam.jpg" alt="" />
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