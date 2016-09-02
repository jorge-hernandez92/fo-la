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
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<h2 class="text-center color-default-ford" style="font-weight: bold; font-size: 40px;">
					Listado de Publicaciones de la Campaña/Promoción
				</h2>
				
				<br>
				
<!-- 				<h4 class="text-center color-gray-ford">  -->
<!-- 				Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.  -->
<!-- 				Donec ullamcorper nulla non metus auctor fringilla. Duis mollis, est non commodo luctus,  -->
<!-- 				nisi erat porttitor ligula, eget lacinia odio sem nec elit. Donec  -->
<!-- 				ullamcorper nulla non metus auctor fringilla. -->
<!-- 				</h4> -->
				
			</div>
			<div class="col-md-2"></div>
</div>

<div class="panel-body">
	<br><br>
		<div class="container" style="width: 1300px;" data-ng-controller="getCampaign" ng-cloak>
			<ul class="caption-style-4" data-ng-controller="getCampaign" ng-cloak>
				<li ng-repeat="publication in publications">
					<img ng-src="{{publication.imagePath}}" alt="">
					<div class="caption">
						<div class="blur"></div>
						<div class="caption-text">
							<h1>{{publication.name}}</h1>
							<br>
							<h3>{{publication.catPublicationType.name}}</h3>
							<br>
							<p>{{publication.publishedDate | date:'dd/MM/yyyy'}}</p>
							<br><br><br><br><br><br>
							<button href="#" data-ng-click="updatePublication(publication)"
									ui-sref="publication" type="button" class="btn btn-campaign btn-lg">DETALLES</button>
						</div>
					</div>
				</li>
			</ul>
		</div>
</div>


<br><br><br>
<br><br><br>
<br><br><br>


	<footer class="footerTH">
		<div>
			<div >
				<div class="row">
					<div class="col-md-3"></div>
					<div class="col-md-6">
					<hr style="border-top: 2px solid rgb(100,100,100);">
						<h3 class="text-center"
							style="font-size: 14px; font-family: GothamBold; color:rgb(100,100,100);">Programa
							administrado por Sí Vale México, S.A. de C.V. 2016 ©</h3>
					</div>
					<div class="col-md-3"></div>

				</div>
			</div>
		</div>
	</footer>