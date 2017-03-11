<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

		<div id="carousel-examplee" class="carousel slide" data-ride="carousel" >
		
<!-- 			Indicators -->
		<ol class="carousel-indicators" >			
			<li data-target="#/incentivos#carousel-examplee" data-slide-to="$index" ng-class="{'active': $index == 0}" ng-repeat="campaign in campaigns" ></li>
		</ol>

		<!-- Wrapper for slides -->
		<div class="carousel-inner" role="listbox"  data-ng-controller="getCampaigns" ng-cloak>


			<div class="item"  ng-class="{active:!$index}" ng-repeat="campaign in campaigns">
				<img ng-src="{{campaign.imageBase64}}" alt="...">

				<div class="carousel-caption">
					<h3>{{campaign.campaignName}}</h3>
					<p>{{campaign.startDate | date:'dd/MM/yyyy'}} -
						{{campaign.endDate | date:'dd/MM/yyyy'}}</p>
				</div>

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

