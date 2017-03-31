<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<div class="container" style="padding: 0px;">
	<section id="carousel-home">
	<div id="carousel-example-generic" class="carousel slide"
		data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#carousel-example-generic" data-slide-to="0"
				class="active"></li>
			<li data-target="#carousel-example-generic" data-slide-to="1"></li>
			<li data-target="#carousel-example-generic" data-slide-to="2"></li>
		</ol>
		<!-- Wrapper for slides -->
		<div class="carousel-inner" role="listbox" style="height: 470px;">
			<div class="item active">
				<img
					src="img/home_th/h1.jpg"
					alt="...">
				<div class="carousel-caption"></div>
			</div>
			<div class="item">
				<img
					src="img/home_th/h2.jpeg"
					alt="...">
				<div class="carousel-caption"></div>
			</div>
			<div class="item">
				<img
					src="img/home_th/h3.jpg"
					alt="...">
				<div class="carousel-caption"></div>
			</div>
		</div>
		<!-- Controls -->
		<a class="left carousel-control" href="#carousel-example-generic"
			role="button" data-slide="prev"> <span
			class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#carousel-example-generic"
			role="button" data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>
</section>
<section id="op-home" style="background-color: #1b394e;">
	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-5">
			<div style="text-align: center;">
				<h2>
					<a style="text-decoration: blink;color: white;" href="#" ui-sref="account_status"> <i class="fa fa-usd"
						aria-hidden="true"
						style="vertical-align: middle; padding-left: -30px; font-size: 45px;"></i>
						Estado de Cuenta
					</a>
				</h2>
			</div>
		</div>
		<div class="col-md-5">
			<div style="text-align: center;">
				<h2>
					<a style="text-decoration: blink;color: white;" href="#" ui-sref="transactions"> <i
						class="fa fa-credit-card" aria-hidden="true"
						style="vertical-align: middle; padding-left: -30px; font-size: 45px;"></i>
						Saldo
					</a>
				</h2>
			</div>
		</div>
		<div class="col-md-1"></div>
	</div>
	<br>
</section>
</div>


