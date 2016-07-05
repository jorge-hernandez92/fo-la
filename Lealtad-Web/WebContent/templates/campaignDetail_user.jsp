<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<div class="panel-body">


	<div class="container">
		<h1 class="text-center">
			<font color="white">Da clic en la imagen para ver la publicación.</font>
		</h1>
	</div>
	
	<br><br>
	
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