<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

		<div id="carousel-examplee" class="carousel slide" data-ride="carousel" >
		
		<ol class="carousel-indicators" >			
			<li data-target="#/incentivos#carousel-examplee" data-slide-to="$index" ng-class="{'active': $index == 0}" ng-repeat="imageBase64 in lastCampaign.listImageBase64" ></li>
		</ol>
		
		
		<div class="carousel-inner" role="listbox"  data-ng-controller="getLastCampaign" ng-cloak>


			<div class="item"  ng-class="{active:!$index}" ng-repeat="imageBase64 in lastCampaign.listImageBase64" >
				<img ng-src="{{imageBase64}}" alt="...">

				<div class="carousel-caption">

				<div class="list-group" >
					<a class="list-group-item active text-center">ARCHIVOS ANEXOS</a> <a
						class="list-group-item" href="#" ng-repeat="file in lastCampaign.listTAttachedFile" ng-if="file != null && file.isPublic == null"
						data-ng-click="getFileCampaign(file, lastCampaign)">{{file.fileName}}</a>
				</div>

				<h3>{{lastCampaign.campaignName}}</h3>
					<p>{{lastCampaign.startDate | date:'dd/MM/yyyy'}} -
						{{lastCampaign.endDate | date:'dd/MM/yyyy'}}</p>
						
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

