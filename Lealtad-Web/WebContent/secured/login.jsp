<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
			<img src="img/logo-login.png"> <label for="inputEmail"
				class="sr-only">Usuario o Tarjeta</label> <input type="text"
				id="inputUserName" class="form-control" placeholder="Id Usuario"
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