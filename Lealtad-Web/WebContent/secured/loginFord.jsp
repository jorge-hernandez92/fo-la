<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	if (request.getSession().getAttribute("user") != null
			&& request.getSession(false) != null) {
		////logger.info("redireccionaodo....");
		response.sendRedirect("login");
	}
%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Login</title>

<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/signin.css" rel="stylesheet">
<link href="css/login.css" rel="stylesheet">
<link href="css/default-fonts.css" rel="stylesheet">
<link href="css/ford/login-image.css" rel="stylesheet">

<!-- LOGIN CSS -->
<link rel="stylesheet" href="css/sticky-footer.css">
<link rel="stylesheet" type="text/css" href="css/normalize.css" />
<link rel="stylesheet" href="css/font-awesome.min.css">


<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="js/ford/dynamic-background-ford.js"></script>

</head>
<body class="back-image" id="bg">
	<nav class="navbar navbar-menu-ford navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" > <img style="max-width:170px; margin-top: -7px;" src="img/company_logo/Ford/header.png">
				</a>
			</div>
		</div>
	</nav>
	<br><br>
	<div class="row">
		<div class="col-md-1"></div>
  		<div class="col-md-10"><h2 class="text-center" style="font-weight: bold; font-size: 40px;">¡Bienvenido a tus programas de incentivos!</h2></div>
 		<div class="col-md-1"></div>
	</div>
	<br><br><br><br>
	<div class="row">
  		<div class="col-md-4 center-block">
  			<div  class="jumbotron" style="background: rgba(49, 49, 49, 0.0);">
  			<br><br>
				<form class="form-inline" role="form" method="post" action="Ford">
					<s:if test="%{error != null}">
						<div class="alert alert-danger" role="alert">
							<span class="glyphicon glyphicon-exclamation-sign"
 								aria-hidden="true"></span> <span class="sr-only">Error:</span>
 							<s:property value="error" />
						</div>
					</s:if>
					<div class="input-group" style="width: 230px;">
						<input type="text" id="inputUserName" class="form-control" placeholder="Usuario"
							required="" autofocus="" name="username">
					</div>
					<br><br>
					<div class="input-group" style="width: 230px;">
						<input type="password" id="inputPassword" class="form-control" placeholder="Contraseña"
							required="" name="password">
					</div>
					<br><br>
					<button class="btn btn-sm btn-login" type="submit" style="width: 230px;border-radius: 0px;">INICIAR
						SESIÓN</button>
				</form>
				<br>
			</div>
  		</div>
	</div>
	<footer class="footerLogin">
		<div class="header_top">
			<div >
				<div class="row">		
					<div class="col-md-12">
						<br><br><br><br>
						<h3 class="text-center"
							style="font-size: 14px; font-family: GothamBold; color: white;margin-bottom: 0px;">Plataforma elaborada y administrada 
							por Sí Vale México, S.A. de C.V., para uso exclusivo de Ford Motor Company de México, 
							S.A. de C.V. y sus filiales.</h3>
							<h3 class="text-center"
							style="font-size: 14px; font-family: GothamBold; color: white;margin-top: 0px;">Copyright ©2016 Ford Motor Company</h3>
					</div>
				</div>
			</div>
		</div>
	</footer>
</body>
</html>