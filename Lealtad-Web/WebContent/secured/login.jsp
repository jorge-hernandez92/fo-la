<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	if (request.getSession().getAttribute("user") != null
			&& request.getSession(false) != null) {
		System.out.println("redireccionaodo....");
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
<link href="css/sivale.css" rel="stylesheet">
<link href="css/login.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="js/dynamic-background.js"></script>

</head>
<body class="back-image" id="bg">
	
	<div class="row">
		<div class="jumbotron " style="opacity: 0;">
		</div>
	</div>
	
	<div class="row">
		<div class="container">
			<h2>BIENVENIDO AL PROGRAMA DE INCENTIVOS FORD</h2>
			<div class="jumbotron" style="opacity: 0;"></div>
		</div>
	</div>
	
	<div class="row">
		<div class="jumbotron" style="opacity: 0;">
		</div>
	</div>
	
	<div class="row">
		<div class="jumbotron" style="opacity: 0;">
		</div>
	</div>
	
	<div class="row">
		<div class="jumbotron" style="opacity: 0;">
		</div>
	</div>
	
	<div class=" col-md-7">
		<div class="container">
			<div class="jumbotron">

				<form class="form-signin" method="post" action="login">
					<s:if test="%{error != null}">
						<div class="alert alert-danger" role="alert">
							<span class="glyphicon glyphicon-exclamation-sign"
								aria-hidden="true"></span> <span class="sr-only">Error:</span>
							<s:property value="error" />
						</div>
					</s:if>

					<div class="form-group">
						<input type="text" id="inputUserName"
							class="form-control text-center" placeholder="USUARIO"
							required="" autofocus="" name="username">
					</div>

					<div class="form-group">
						<input type="password" id="inputPassword"
							class="form-control text-center" placeholder="PASSWORD"
							required="" name="password">
					</div>

					<button class="btn btn-sm btn-default" type="submit">INICIAR
						SESIÓN</button>
				</form>

			</div>
		</div>
	</div>

	<div class="col-md-3">
		<div class="container">
			<h3>Programa administrado por</h3>
			<div class="form-group">
				<img src="img/logo-login2.png">
			</div>

		</div>
	</div>

</body>
</html>