<%@ page language="java" contentType="text/html; charset=utf-8"
 	pageEncoding="utf-8"%>

<div data-ng-controller="getAttachedFiles" >

<div class="sk-fading-circle" ng-show="loadingPublicationImage" >
	<div class="sk-circle1 sk-circle"></div>
	<div class="sk-circle2 sk-circle"></div>
	<div class="sk-circle3 sk-circle"></div>
	<div class="sk-circle4 sk-circle"></div>
	<div class="sk-circle5 sk-circle"></div>
	<div class="sk-circle6 sk-circle"></div>
	<div class="sk-circle7 sk-circle"></div>
	<div class="sk-circle8 sk-circle"></div>
	<div class="sk-circle9 sk-circle"></div>
	<div class="sk-circle10 sk-circle"></div>
	<div class="sk-circle11 sk-circle"></div>
	<div class="sk-circle12 sk-circle"></div>
</div>

<div class="panel-body publication-html" >

</div>

<div class="container"  ng-show="files">
		<div class="row" style="color: white;">
		<div class="col-md-3"></div>
		<div class="col-md-6">
			<div class="list-group" data-ng-controller="getAttachedFiles">
				<a  class="list-group-item active text-center">Archivos Adjuntos</a>
					<a  class="list-group-item" 
					href="#" ng-repeat="file in attachedFiles"  
					data-ng-click="getFile(file)">{{file.fileName}}</a>				
			</div>
		</div>

		<div class="col-md-3">
			<div class="col-md-2"></div>
		</div>
	
	</div>
  
</div>
</div>

<br><br><br>

