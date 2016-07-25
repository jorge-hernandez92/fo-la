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
<link href="css/bootstrap-intac/bootstrap.min.css" rel="stylesheet">
<link href="css/signin.css" rel="stylesheet">
<link href="css/login.css" rel="stylesheet">
<link href="css/default-fonts.css" rel="stylesheet">
<link href="css/lincoln/login-image.css" rel="stylesheet">

<!-- LOGIN CSS -->
<link rel="stylesheet" href="css/sticky-footer.css">
<link rel="stylesheet" type="text/css" href="css/normalize.css" />

<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="js/lincoln/dynamic-background-lincoln.js"></script>

</head>
<body class="back-image" id="bg">

	<div class="row">
		<div class="col-md-1"></div>
  		<div class="col-md-10">
  			<h2 class="text-center" style="font-weight: bold; font-size: 64px;">
  				Bienvenido a los Programas de Incentivos Lincoln
  			</h2>
  		</div>
 		<div class="col-md-1"></div>
	</div>
	
	<br><br><br><br>
	<br><br><br><br>
	
	<div class="row">
		<div class="col-md-4"></div>
  		<div class="col-md-4">
  			
  			<div id="imgLoginLincoln" class="jumbotron">
  			
  			<br>

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
					
					<br>
					
					<button class="btn btn-sm btn-default" type="submit">INICIAR
						SESIÓN</button>
				</form>
			</div>
  		</div>
 		<div class="col-md-4"></div>
	</div>
	
	<footer class="footerLogin">
		<div class="header_top">
			<div >
				<div class="row">
					<div class="col-md-3"></div>
					<div class="col-md-6">
						<h3 class="text-center"
							style="font-size: 14px; font-family: GothamBold; color: white;">Programa
							administrado por Sí Vale México, S.A. de C.V. 2016 ©</h3>
					</div>
					<div class="col-md-3"></div>

				</div>
			</div>
		</div>
	</footer>

</body>
</html>