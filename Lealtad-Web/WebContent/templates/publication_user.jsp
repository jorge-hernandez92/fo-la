<%@ page language="java" contentType="text/html; charset=utf-8"
 	pageEncoding="utf-8"%>

<div class="panel-body publication-html" data-ng-controller="getAttachedFiles">

</div>

<div class="container" data-ng-controller="getAttachedFiles">
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

<br><br><br>

