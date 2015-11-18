<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>


<div class="collapse navbar-collapse navbar-ex1-collapse">
	<ul class="nav navbar-nav side-nav">



		<!-- ***************************  CARDHOLDER  MENU OPTIONS *************************** -->

		<s:if test="getBalance">

			<li class="menu homeTh"
				onclick="location.href='<s:url action="homeAction"/>';"><span>
					<img class="manImg" src="img/menu/inicio.jpg"></img> <a
					class="menu" href="#">Inicio </a>
			</span></li>

		</s:if>		

		<s:if test="viewMyConciliation">
			<li class="menu myConciliation"
				onclick="location.href='<s:url action="myTransactionsAction"/>';">
				<span> <img class="manImg" src="img/menu/miConciliacion.jpg"></img>
					<a class="menu" href="#" style="white-space: nowrap;">Conciliación</a>
			</span>
			</li>
		</s:if>

		<s:if test="getBudgets">
			<li class="menu myBudgets"
				onclick="location.href='<s:url action="myBudgetsAction"/>';"><span>
					<img class="manImg" src="img/menu/comprobacion.jpg"></img> <a
					class="menu" href="#" style="white-space: nowrap;">Solicitudes</a>
			</span></li>
		</s:if>

		<s:if test="getBudgets">
			<li class="menu myChecking"
				onclick="location.href='<s:url action="checkingAction"/>';"><span>
					<img class="manImg" src="img/menu/comprobacion.jpg"></img> <a
					class="menu" href="#" style="white-space: nowrap;">Comprobación</a>
			</span></li>
		</s:if>




		<!-- ***************************  SUPERVISOR MENU OPTIONS *************************** -->

		<s:if test="getAverageBalance">

			<li class="menu homeSuper"
				onclick="location.href='<s:url action="homeSuperAction"/>';"><span>
					<img class="manImg" src="img/menu/inicio.jpg"></img> <a
					class="menu" href="#">Inicio </a>
			</span></li>

		</s:if>	

		<s:if test="viewOtherConciliation">
			<li class="menu conciliation"
				onclick="location.href='<s:url action="otherTransactionsAction"/>';">
				<span> <img class="manImg"
					src="img/menu/otrasConciliaciones.jpg"></img> <a class="menu"
					href="#">Conciliación</a>
			</span>
			</li>
		</s:if>
		
		<s:if test="approveDeniedRequests">
			<li class="menu otherBudgets"
				onclick="location.href='<s:url action="otherBudgetsAction"/>';">
				<span> <img class="manImg" src="img/menu/comprobacion.jpg"></img>
					<a class="menu" href="#">Presupuestos</a>
			</span>
			</li>
		</s:if>
		

		<s:if test="getEvents">
			<li class="menu Checking"
				onclick="location.href='<s:url action="checkingSuperAction"/>';"><span>
					<img class="manImg" src="img/menu/comprobacion.jpg"></img> <a
					class="menu" href="#">Comprobación</a>
			</span></li>
		</s:if>


		<!-- ***************************  ADMIN MENU OPTIONS *************************** -->

		<s:if test="createNewUsers">
			<li class="menu users"
			onclick="location.href='<s:url action="redirectToUsers"/>';"><span>
				<img class="manImg" src="img/menu/configuracion.jpg"></img> <a
				href="#" class="menu">Usuarios</a>
		</span></li>
		</s:if>
		
		<s:if test="enableDisableCompanies">
			<li class="menu companies"
			onclick="location.href='<s:url action="companiesAction"/>';"><span>
				<img class="manImg" src="img/menu/configuracion.jpg"></img> <a
				href="#" class="menu">Clientes</a>
		</span></li>
		</s:if>		
		
		<s:if test="downloadSetInvoices">
			<li class="menu donwloadInvoices"
			onclick="location.href='<s:url action="downloadInvoicesAction"/>';"><span>
				<img class="manImg" src="img/menu/comprobacion.jpg"></img> <a
				href="#" class="menu">Descargas</a>
		</span></li>
		</s:if>	

		<s:if test="viewReports">
			<li class="menu reportsClient"
				onclick="location.href='<s:url action="reportsAction"/>';"><span>
					<img class="manImg" src="img/menu/reportes.jpg"></img> <a
					class="menu" href="#">Reportes</a>
			</span></li>
		</s:if>


		<s:if test="viewReportsSiVale">
			<li class="menu reportsSivale"
				onclick="location.href='<s:url action="reportsAction"/>';">
				<span> <img class="manImg" src="img/menu/reportes.jpg"></img>
					<a class="menu" href="#">Reportes</a>
			</span>
			</li>
		</s:if>

		

	</ul>
</div>

