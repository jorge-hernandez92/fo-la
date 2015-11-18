<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	if (request.getSession().getAttribute("userDetails") != null
			&& request.getSession(false) != null) {
		System.out.println("redireccionaodo....");
		response.sendRedirect("login");
	}
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>Login | Si Vale</title>
<meta name="generator" content="Bootply" />
<link type="image/x-icon" rel="shortcut icon" href="img/favicon/logo.ico">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="css/bootstrapLog.min.css" rel="stylesheet">

<link href="css/sb-admin.css" rel="stylesheet">
<!--[if lt IE 9]>
			<script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
<!-- script references -->
<script src="js/jquery.js"></script>
<body>
	<!--login modal-->
	<div id="loginModal" class="modal show loginBackground" tabindex="-1"
		role="dialog" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="text-center">
						<img src="img/logo.png" style="width: 205px; height: 51px" alt="Si Vale">
					</h1>
				</div>
				<div class="modal-body">
					<form method="post" action="login"
						class="form col-md-12 center-block">
						<s:if test="%{error != null}">
							<div class="alert alert-danger" role="alert">
								<span class="glyphicon glyphicon-exclamation-sign"
									aria-hidden="true"></span> 
								<span class="sr-only">Error:</span>
								<s:property value="error" />
							</div>							
						</s:if>						
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-user"></i>
							</span> <input name="j_username" class="form-control input-lg"
								placeholder="Usuario">
						</div>
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-lock"></i>
							</span> <input name="j_password" class="form-control input-lg"
								type="password" placeholder="Contraseña">
						</div>
						<div class="form-group">

							<input type="submit" value="Ingresar"
								class="btn btn-primary btn-lg btn-block">


						</div>
					</form>
				</div>
				<div class="modal-footer modal-footer-login">
					<div class="col-md-12"></div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>