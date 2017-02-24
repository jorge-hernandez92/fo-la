<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	
<br><br>

		<div id="carousel-examplee" class="carousel slide" data-ride="carousel" >
		
			<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#/incentivos#carousel-examplee" data-slide-to="0"
				class="active"></li>
			<li data-target="#/incentivos#carousel-examplee" data-slide-to="1"></li>
			<li data-target="#/incentivos#carousel-examplee" data-slide-to="2"></li>
		</ol>

		<!-- Wrapper for slides -->
		<div class="carousel-inner" role="listbox" style="height: 550px;"  data-ng-controller="getCampaigns" ng-cloak>

			<div class="item active" >

			<div>
				<h3>{{campaigns[0].campaignName}}</h3>
				<p>{{campaigns[0].startDate | date:'dd/MM/yyyy'}} -
					{{campaign.endDate | date:'dd/MM/yyyy'}}</p>
			</div>
			<img
					ng-src="{{campaigns[0].imageBase64}}"
					alt="..." >

				
				</div>

			<div class="item" >
			<div >
					<h3>{{campaigns[1].campaignName}}</h3>
					<p>{{campaigns[1].startDate | date:'dd/MM/yyyy'}} -
									{{campaign.endDate | date:'dd/MM/yyyy'}}</p>
				</div>
				<img
					ng-src="{{campaigns[1].imageBase64}}"
					alt="..." >
				
			</div>
			
			<div class="item" >
			<div class="">
					<h3>{{campaigns[2].campaignName}}</h3>
					<p>{{campaigns[2].startDate | date:'dd/MM/yyyy'}} -
									{{campaign.endDate | date:'dd/MM/yyyy'}}</p>
				</div>
				<img
					ng-src="{{campaigns[2].imageBase64}}"
					alt="..." >
				
			</div>

		</div>
		


		<!-- Controls -->
		<a class="left carousel-control" href="#/incentivos#carousel-examplee"
			role="button" data-slide="prev"> <span
			class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span> <span
			class="sr-only">Previous</span>
		</a> 
		<a class="right carousel-control" href="#/incentivos#carousel-examplee"
			role="button" data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>

<div class="panel-body ">
	
		<div class="container" style="width: 1300px;" data-ng-controller="getCampaigns" ng-cloak>
			<ul class="caption-style-4">
				<li ng-repeat="campaign in campaigns | filter:search:strict">
					<img ng-src="{{campaign.imageBase64}}" alt="">
					<div class="caption">
						<div class="blur"></div>
						<div class="caption-text">
							<h1>{{campaign.campaignName}}</h1>
							<br>
							<h3>{{campaign.classification[0]}}</h3>
							<br>
							<p>{{campaign.startDate | date:'dd/MM/yyyy'}} -
									{{campaign.endDate | date:'dd/MM/yyyy'}}</p>
							<br><br><br><br><br><br>
							<button href="#" data-ng-click="updateCampaign(campaign)"
									ui-sref="campaign" type="button" class="btn btn-campaign btn-lg">DETALLES</button>
						</div>
					</div>
				</li>
			</ul>
		</div>
</div>

