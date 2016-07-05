<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<div class="panel-body">


	<div class="container">
		<h1 class="text-center">
			<font color="white">Da clic en la imagen para ver la publicación.</font>
		</h1>
	</div>
	
	<br><br>

<!-- 	<div class="container" > -->
<!-- 		<div class="jumbotron" style="background-color: rgba(220, 220, 220, 0.35);" data-ng-controller="getCampaign" ng-cloak> -->
<!-- 			<div class="row"> -->
<!-- 				<div class="col-sm-6 col-md-3" -->
<!-- 					ng-repeat="publication in publications"> -->
<!-- 					<div class="grid" data-toggle="tooltip" data-placement="left" -->
<!-- 						title="{{publication.description}}"> -->
<!-- 						<figure class="effect-ming"> -->
<!-- 							<img ng-src="{{publication.imagePath}}" alt="" /> -->
<!-- 							<figcaption> -->
<!-- 								<h5>{{publication.name}}</h5> -->
<!-- 								<h6>{{publication.catPublicationType.name}}</h6> -->
<!-- 								<p>{{publication.publishedDate | date:'dd/MM/yyyy'}}</p> -->
<!-- 								<a href="#" data-ng-click="updatePublication(publication)" -->
<!-- 									ui-sref="publication">View more</a> -->
<!-- 							</figcaption> -->
<!-- 						</figure> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</div> -->
	
		<div class="container" style="width: 1300px;" data-ng-controller="getCampaign" ng-cloak>
			
			<ul class="caption-style-4" data-ng-controller="getCampaign" ng-cloak>
				
				<li ng-repeat="publication in publications">
					<img ng-src="{{publication.imagePath}}" alt="">
					<div class="caption">
						<div class="blur"></div>
						<div class="caption-text">
							<h1>{{publication.name}}</h1>
							<p>{{publication.catPublicationType.name}}</p>
							<p>{{publication.publishedDate | date:'dd/MM/yyyy'}}</p>
							<br>
							<button href="#" data-ng-click="updatePublication(publication)"
									ui-sref="publication" type="button" class="btn btn-campaign">DETALLES</button>
						</div>
					</div>
				</li>
				
			</ul>
			
		</div>

</div>