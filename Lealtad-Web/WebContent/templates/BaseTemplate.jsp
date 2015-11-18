<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>


<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<meta http-equiv="refresh" content="<%=(session.getMaxInactiveInterval())%>; url=login" />
<link type="image/x-icon" rel="shortcut icon" href="img/favicon/logo.ico">
<title><tiles:insertAttribute name="title" ignore="true" /> - Si Vale</title>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap-combined.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css">
<link href="css/angular-notify.css" rel="stylesheet">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/daterangepicker-bs3.css">
<link href="css/loading-bar.css" rel="stylesheet" />
<link href="css/ng-toggle-btn.css" rel="stylesheet">



<!-- Custom Fonts -->
<link rel="stylesheet"
	href="css/font-awesome.min.css">

<link rel="stylesheet" href="css/ng-table.min.css"/>
<link href="css/morris.css" rel="stylesheet">
<link href="css/sb-admin.css" rel="stylesheet">
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
       <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
<script src="js/jquery.js"></script>
<script src="js/d3.min.js"></script>
<script src="js/d3pie.min.js"></script>

<script src="js/raphael-min.js"></script>
<script src="js/jquery-1.11.3.min.js"></script>



     

     
    <style type="text/css">
		.css-form input.ng-invalid.ng-touched {
		  background-color: #FA787E;
		}
		
		.css-form input.ng-valid.ng-touched {
		  background-color: #78FA89;
		}
	</style>
	    
</head>

<body>

	<div id="wrapper">
		<!-- Navigation -->
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<tiles:insertAttribute name="header" />
			<tiles:insertAttribute name="menu" />
		</nav>

		<div id="page-wrapper">
						
			<div class="container-fluid">
			
				<tiles:insertAttribute name="body" />
			</div>
			<!-- /.container-fluid -->
			

		</div>
		<!-- /#page-wrapper -->
		<tiles:insertAttribute name="banner" />
	</div>

	<!-- /#wrapper -->
	<%-- <tiles:insertAttribute name="footer" /> --%>
	
		
	
	<script src="js/jquerySizzelejs.js"></script>			
	<script  src="js/bootstrap-datetimepicker.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/angular.js"></script>
	<%-- <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.23/angular.min.js"></script> --%>
	<script src="js/angular-animate.min.js"></script>
	
	<script src="js/angular-notify.js"></script>
	<script src="js/ng-toggle-btn.js"></script>
	<script src="js/bootstrap-datepicker.js"></script>
	<script src="js/moment.js"></script>
	<script src="js/daterangepicker.js"></script>				
	<script src="js/ng-bs-daterangepicker.js"></script>
	<!-- loadingbar -->
    <script src="js/loading-bar.js"></script>
    <script src="js/morris-0.4.1.min.js"></script>
    
	
	<script src="js/jquery.js"></script>
	<script src="js/checklist-model.js"></script>	
	<script src="js/ng-table.min.js"></script>
	<script src="js/jquery.quickfit.js" type="text/javascript" charset="utf-8"></script>
	 
			
	<script src="js/active.js"></script>			
	<script src="js/siVale.js"></script>
	<%-- <script src="js/additional-functions.js"></script> --%>
	
</body>
</html>
