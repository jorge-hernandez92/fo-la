<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	
<div class="container" style="padding: 0px;">
<div id="carousel-examplee" class="carousel slide" data-ride="carousel" data-ng-controller="getLastCampaign" style="margin-top: 10px;">
	<ol class="carousel-indicators">
		<li data-target="#/incentivos#carousel-examplee" data-slide-to="$index" ng-class="{'active': $index == 0}"ng-repeat="imageBase64 in lastCampaign.listImageBase64" style="background-color: #1b394e;"></li>
	</ol>
	<div class="carousel-inner" role="listbox"
		data-ng-controller="getLastCampaign" ng-cloak style="height: 550px;">
		<div class="item" ng-class="{active:!$index}"
			ng-repeat="imageBase64 in lastCampaign.listImageBase64">
			<img ng-src="{{imageBase64}}" alt="...">
		</div>
	</div>
	<!-- Controls -->
	<a class="left carousel-control" href="#/incentivos#carousel-examplee"
		role="button" data-slide="prev"> <span
		class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span> <span
		class="sr-only">Previous</span>
	</a> <a class="right carousel-control"
		href="#/incentivos#carousel-examplee" role="button" data-slide="next">
		<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
		<span class="sr-only">Next</span>
	</a>
	
	<div class="list-group" style="position: absolute;bottom: 30px;">
		<a class="list-group-item active text-center"
			style="background-color: #1b394e; color: white;">ARCHIVOS ANEXOS</a>
		<a class="list-group-item" href="#"
			ng-repeat="file in lastCampaign.listTAttachedFile"
			ng-if="file != null && file.isPublic == null"
			data-ng-click="getFileCampaign(file, lastCampaign)"
			style="background-color: rgb(44, 92, 125); color: white;">{{file.fileName}}</a>
	</div>
</div>
</div>

