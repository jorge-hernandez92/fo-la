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
<link href="css/default-fonts.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="js/dynamic-background.js"></script>

</head>
<body class="back-image" id="bg">

	<div class="row">
		<div class="col-md-1"></div>
  		<div class="col-md-10"><h2 class="text-center" style="font-weight: bold; font-size: 64px;">BIENVENIDO A LOS PROGRAMAS DE INCENTIVOS</h2></div>
 		<div class="col-md-1"></div>
	</div>
	
	<br><br><br><br>
	<br><br><br><br>
	<br>
	
	<div class="row">
		<div class="col-md-4"></div>
  		<div class="col-md-4">
  			
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
 		<div class="col-md-4"></div>
	</div>
	
	<div class="row">
		<div class="col-md-3"></div>
 		<div class="col-md-3"></div>
	</div>

</body>
</html>