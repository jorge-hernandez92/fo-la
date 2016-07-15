<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	
<header class="header-image-publications">
	
	<div class="headline">
		<div class="container">
		
<!-- 			<h1 style="font-family: 'GothamBold';font-size: 30px;"> -->
<!-- 			<br><br><br><br><br><br><br><br> -->
<!-- 				<font color="white">CAMPAÑAS</font> -->
<!-- 			</h1> -->

		</div>
	</div>
	
	<br><br>
	<br><br>
	<br><br>
	<br><br>
	
</header>

<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-10">
				<h2 class="text-center color-default-ford" style="font-weight: bold; font-size: 40px;">
					PUBLICACIONES
				</h2>
			</div>
			<div class="col-md-1"></div>
</div>

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