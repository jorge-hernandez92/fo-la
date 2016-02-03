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

</head>
<body class="back-image">

	<div class="container">
		<form class="form-signin back-sivale" method="post" action="login">
			<s:if test="%{error != null}">
							<div class="alert alert-danger" role="alert">
								<span class="glyphicon glyphicon-exclamation-sign"
									aria-hidden="true"></span> 
								<span class="sr-only">Error:</span>
								<s:property value="error" />
							</div>							
			</s:if>		
						
			<img src="img/logo-login.png"> <label for="inputEmail"
				class="sr-only">Usuario o Tarjeta</label> <input type="text"
				id="inputUserName" class="form-control" placeholder="Usuario o Tarjeta"
				required="" autofocus="" name="username"> <label
				for="inputPassword" class="sr-only">Password</label> <input
				type="password" id="inputPassword" class="form-control"
				placeholder="Password" required="" name="password">
			<button class="btn btn-lg btn-primary btn-block" type="submit">INICIAR
				SESIÓN</button>
		</form>
	</div>

</body>
</html>