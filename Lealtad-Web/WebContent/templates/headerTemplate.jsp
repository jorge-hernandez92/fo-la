<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!-- Brand and toggle get grouped for better mobile display -->
<div class="navbar-header">
	<button type="button" class="navbar-toggle" data-toggle="collapse"
		data-target=".navbar-ex1-collapse">
		<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
		<span class="icon-bar"></span> <span class="icon-bar"></span>
	</button>
	<a class="navbar-brand" href="login"> <img alt="Brand"
		src="img/logo-nav.png">
	</a>
</div>

<!-- Top Menu Items -->
<ul class="nav navbar-right top-nav">


	<s:if test="#session.userDetails.clientName != null">
			<li><a class="dropdown-toggle" title="<s:property value="@com.twobig.sivale.constants.CommonsConstants@CLIENT_NAME"/>"><i class="fa fa-building"></i>
					${sessionScope.userDetails.clientName} </a></li>
	</s:if>

	<s:if test="#session.userDetails.clientId != null && #session.userDetails.clientId != @com.twobig.sivale.constants.CommonsConstants@DEFAULT_COMPANY_ID">
		<li><a class="dropdown-toggle" title="<s:property value="@com.twobig.sivale.constants.CommonsConstants@CLIENT_NUMBER"/>"><i class="fa fa-building"></i>
				${sessionScope.userDetails.clientId} </a></li>
	</s:if>
	
	<s:if test="#session.userDetails.rfcClient != null">
		<li><a class="dropdown-toggle" title="<s:property value="@com.twobig.sivale.constants.CommonsConstants@RFC_CLIENT"/>"><i class="fa fa-list-alt"></i>
				${sessionScope.userDetails.rfcClient} </a></li>
	</s:if>			
		

	<s:if test="#session.userDetails.cardNumber != null">
		<li><a class="dropdown-toggle" title="<s:property value="@com.twobig.sivale.constants.CommonsConstants@CARD_NUMBER"/>"><i class="fa fa-credit-card"></i>
				${sessionScope.userDetails.cardNumber} </a></li>
	</s:if>
	<s:if test="getAverageBalance">	
		<li><a class="dropdown-toggle" title="Monto Total Gastado">
				&#36;0.00 </a></li>
	</s:if>

	<li><a class="dropdown-toggle" title="<s:property value="@com.twobig.sivale.constants.CommonsConstants@USER_NAME"/>"><i class="fa fa-user"></i>
			${sessionScope.userDetails.userName} </a></li>

	<li><s:a href="logout.action">
			<i class="fa fa-sign-in"></i> Salir</s:a></li>


</ul>


