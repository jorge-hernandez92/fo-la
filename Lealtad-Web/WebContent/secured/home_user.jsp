<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html ng-app="app" data-ng-controller="campaignController">
<head ng-cloak>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="refresh" content="<%=(session.getMaxInactiveInterval())%>; url=Ford" />

<title>Ford-Incentivos</title>

<!-- <!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
    <link href="css/non-responsive.css" rel="stylesheet">

<link rel="stylesheet" href="css/daterangepicker.min.css">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/sb-admin-2.css">

<!-- ESTILO DEL CLIENTE  -->
<link rel="stylesheet" type="text/css" href="css/ford/ford-style.css" />


<!-- JS (load angular, ui-router, and our custom js file) -->
<script src="js/angular.min.js"></script>

<!-- <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular.min.js"></script> -->
<script src="js/angular-ui-router.min.js"></script>
<script src="js/ng-table.min.js"></script>
<script src="js/app.js"></script>
<script src="js/moment.min.js"></script>
<script src="js/jquery-2.1.4.min.js"></script>

<!-- bower:js -->
<script src="js/angular-messages.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/daterangepicker.min.js"></script>
<!-- endbower -->

<script src="js/angular-daterangepicker.min.js"></script>
<script src="js/hammer.min.js"></script>
<script src="js/angular-carousel.js"></script>

<!-- links provicinales  -->
<script src="js/jquery.easing.min.js"></script>
<!-- <script src="js/grayscale.js"></script> -->
<script src="js/dynamic-background-home.js"></script>

</head>

<body class="sivale" id="init">
<div class="container" style="padding: 0px;">

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog modal-lg" role="document" style="overflow-y: scroll; max-height:85%;  margin-top: 50px; margin-bottom:50px;">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel" style="text-align: center;">AVISO DE PRIVACIDAD</h4>
      </div>
      <div class="modal-body"><p style="text-align: justify;">Ford Motor Company, S.A. de C.V. (Ford), con domicilio en Circuito Guillermo Gonz&aacute;lez Camarena N&uacute;mero 1500, Colonia Centro de Ciudad Santa Fe, Delegaci&oacute;n &Aacute;lvaro Obreg&oacute;n, C.P. 01210, Ciudad de M&eacute;xico, M&eacute;xico, es responsable del tratamiento de sus datos personales. La informaci&oacute;n de nuestros clientes y clientes potenciales es tratada de forma estrictamente confidencial y es tan importante como su seguridad al conducir nuestros veh&iacute;culos, por lo que hacemos un esfuerzo permanente para salvaguardarla.</p>
<p>&nbsp;</p>
<p><strong>DATOS QUE SE RECABAN</strong></p>
<p style="text-align: justify;">Los datos personales que tratar&aacute; Ford son: nombre, edad, domicilio, correo electr&oacute;nico, tel&eacute;fono (fijo y/o celular), si es usuario de redes sociales, g&eacute;nero, gustos y preferencias; as&iacute; como tambi&eacute;n, de resultar aplicable,&nbsp; n&uacute;mero de serie (VIN, por sus siglas en ingl&eacute;s), modelo, a&ntilde;o y color de su veh&iacute;culo.</p>
<p>&nbsp;</p>
<p><strong>FINALIDADES DEL TRATAMIENTO DE LOS DATOS PERSONALES</strong></p>
<p style="text-align: justify;">M&aacute;s que una pol&iacute;tica, en Ford tenemos la filosof&iacute;a de mantener una relaci&oacute;n estrecha y activa con nuestros clientes y clientes potenciales. En este sentido, Ford tratar&aacute; sus datos personales para las siguientes finalidades:</p>
<p><strong><span style="text-decoration: underline;">&nbsp;I.&nbsp;</span><u><strong>P</strong>ara el caso de clientes:</u></strong></p>
<ol style="list-style-type: lower-alpha;">
<li><strong><u>Finalidades necesarias para el mantenimiento de la relaci&oacute;n con el Cliente:</u></strong>
<ul>
<li>Proveerle un bien y/o servicio;</li>
<li>Mantener actualizados nuestros registros para poder responder a sus consultas;</li>
<li>Hacer v&aacute;lida la garant&iacute;a de su veh&iacute;culo;</li>
<li>Informarle acerca de llamados a revisi&oacute;n de su veh&iacute;culo.</li>
</ul>
</li>
<li>&nbsp;<strong><u>Finalidades distintas:</u></strong>
<ul>
<li>Realizar actividades de mercadeo y promoci&oacute;n;</li>
<li>Ofrecerle nuestros productos, servicios e informaci&oacute;n de nuestros socios de negocios;</li>
<li>An&aacute;lisis estad&iacute;sticos y de mercado;</li>
<li>Invitarlo a eventos;</li>
<li>Hacer de su conocimiento nuestras promociones y lanzamientos.</li>
</ul>
</li>
</ol>
<p style="text-align: justify;">En caso de que nuestros clientes no deseen que Ford d&eacute; tratamiento a sus datos personales para las finalidades previstas en el inciso b) anterior, tendr&aacute;n un plazo de 5 (cinco) d&iacute;as para manifestar su negativa mediante escrito debidamente firmado, enviado al Comit&eacute; de Protecci&oacute;n de Datos Personales de Ford v&iacute;a correo electr&oacute;nico a la siguiente direcci&oacute;n: <a href="mailto:privacy1@ford.com">privacy1@ford.com</a>; &nbsp;o bien, presentado en d&iacute;as h&aacute;biles en horario de 10:00 a 17:00 hrs., en el domicilio de Ford se&ntilde;alado al inicio de este Aviso de Privacidad.</p>
<p>&nbsp;</p>
<p><strong><u>II. Para el caso de clientes potenciales:</u></strong></p>
<ul>
<li>Realizar actividades de mercadeo y promoci&oacute;n;</li>
<li>Ofrecerle nuestros productos, servicios e informaci&oacute;n de nuestros socios de negocios;</li>
<li>An&aacute;lisis estad&iacute;sticos y de mercado;</li>
<li>Mantener actualizados nuestros registros para poder responder a sus consultas;</li>
<li>Invitarle a eventos;</li>
<li>Hacer de su conocimiento nuestras promociones y lanzamientos.</li>
</ul>
<p><strong>&nbsp;</strong></p>
<p><strong>MEDIDAS PARA PROTEGER LOS DATOS PERSONALES</strong></p>
<p style="text-align: justify;">Para prevenir el acceso no autorizado de sus datos personales y con el fin de asegurar que la informaci&oacute;n sea utilizada para los fines establecidos en este Aviso de Privacidad, Ford ha establecido procedimientos f&iacute;sicos, electr&oacute;nicos y administrativos, utilizando tecnolog&iacute;as avanzadas que limitan el uso o divulgaci&oacute;n de sus datos, lo que permite que &eacute;stos sean tratados de forma adecuada. Estos procedimientos son evaluados y revisados constantemente por el &Aacute;rea de Control Interno de Ford, a fin de controlar el uso y divulgaci&oacute;n de sus datos personales.</p>
<p><strong>&nbsp;</strong></p>
<p><strong>TRANSFERENCIA DE DATOS PERSONALES</strong></p>
<p style="text-align: justify;">Con el fin de proveerle un servicio o un bien, as&iacute; como hacer v&aacute;lida&nbsp; la garant&iacute;a de su veh&iacute;culo, realizar actividades de promoci&oacute;n, realizar an&aacute;lisis estad&iacute;sticos y de mercadeo, as&iacute; como para &nbsp;hacerle llegar informaci&oacute;n de nuestros socios de negocios, Ford podr&aacute; transferir sus datos personales tanto dentro como fuera de los Estados Unidos Mexicanos a sociedades subsidiarias, afiliadas o relacionadas con Ford, sus Distribuidores Autorizados y/o sus terceros proveedores de servicios con quienes tiene una relaci&oacute;n jur&iacute;dica, as&iacute; como a autoridades competentes.</p>
<p>&nbsp;</p>
<p style="text-align: justify;">No ser&aacute; necesario el consentimiento de los clientes o clientes potenciales de Ford cuando las transferencias se realicen a sociedades del mismo grupo de Ford o cuando dicha transferencia sea necesaria para prestarle un bien o servicio,&nbsp; mantener actualizados nuestros registros, para responder a sus consultas, hacer v&aacute;lida la garant&iacute;a de su veh&iacute;culo o hacerle llamados para revisi&oacute;n de su veh&iacute;culo derivado de la relaci&oacute;n comercial.</p>
<p>&nbsp;</p>
<p style="text-align: justify;">Respecto a la transferencia de los datos personales de clientes potenciales a terceros prestadores de servicios, le informamos que si Usted no manifiesta su negativa, mediante el env&iacute;o de solicitud firmada por el Titular, dirigida al correo electr&oacute;nico: <a href="mailto:privacy1@ford.com">privacy1@ford.com</a>, o bien presentada en d&iacute;as h&aacute;biles en horario de 10:00 a 17:00 hrs; en el domicilio de Ford se&ntilde;alado al inicio de este Aviso de Privacidad, en un plazo de cinco d&iacute;as naturales contados a partir de la puesta a disposici&oacute;n del presente Aviso de Privacidad, entenderemos que nos ha otorgado su consentimiento para &nbsp;dicha transferencia.</p>
<p>&nbsp;</p>
<p><strong>SOLICITUD DE ACCESO, RECTIFICACI&Oacute;N, CANCELACI&Oacute;N U OPOSICI&Oacute;N DE DATOS PERSONALES Y REVOCACI&Oacute;N DEL CONSENTIMIENTO (SOLICITUD ARCO)</strong></p>
<p style="text-align: justify;">Todos sus datos personales son tratados de acuerdo a la legislaci&oacute;n aplicable y vigente en el pa&iacute;s (Estados Unidos Mexicanos), por ello le informamos que usted tiene en todo momento el derecho de acceder a los datos personales que posee Ford y a los detalles del tratamiento de los mismos, as&iacute; como de rectificarlos en caso de ser inexactos o incompletos; cancelarlos cuando resulten ser excesivos o innecesarios para las finalidades que justificaron su obtenci&oacute;n; y oponerse a su tratamiento para los fines previstos en este Aviso de Privacidad, a trav&eacute;s del Comit&eacute; de Protecci&oacute;n de Datos Personales de Ford, mediante el env&iacute;o de solicitud firmada por el Titular, dirigida al correo electr&oacute;nico: <a href="mailto:privacy1@ford.com">privacy1@ford.com</a>; &nbsp;o bien presentada en d&iacute;as h&aacute;biles en horario de 10:00 a 17:00 hrs; en el domicilio de Ford se&ntilde;alado al inicio de este Aviso de Privacidad que contenga cuando menos la siguiente informaci&oacute;n:</p>
<ul>
<li>Nombre completo del titular de los datos.</li>
<li>Domicilio del titular de los datos y/o direcci&oacute;n de correo electr&oacute;nico para comunicar respuesta a solicitud.</li>
<li>Documentos oficiales que acrediten identidad y/o autorizaci&oacute;n para representarlo en la solicitud (Credencial de Elector vigente otorgada por el Instituto Nacional Electoral &ldquo;INE&rdquo; o Pasaporte vigente).</li>
<li>Descripci&oacute;n de los datos personales sobre los que se pretende ejercer alg&uacute;n derecho ARCO.</li>
<li>El n&uacute;mero de serie (VIN por sus siglas en ingl&eacute;s) de su autom&oacute;vil (en caso de ser aplicable).</li>
<li>Cualquier otro elemento que permita la localizaci&oacute;n de los datos personales y la atenci&oacute;n a su solicitud.</li>
</ul>
<p style="text-align: justify;">&nbsp;A trav&eacute;s de estos canales, &nbsp;en su solicitud usted podr&aacute; especificar el medio por el cual desea recibir respuesta a la misma, ya que en caso de no contar con esta especificaci&oacute;n de su parte, Ford establecer&aacute; el canal que considere pertinente para hacerle llegar la contestaci&oacute;n a su requerimiento.</p>
<p>&nbsp;</p>
<p><strong>MECANISMOS Y PROCEDIMIENTOS PARA LA REVOCACI&Oacute;N DE CONSENTIMIENTO</strong></p>
<p style="text-align: justify;">En cualquier momento, los clientes o clientes potenciales podr&aacute;n solicitar la revocaci&oacute;n del consentimiento que han otorgado para el tratamiento de sus datos personales, comunicando dicha solicitud al Comit&eacute; de Protecci&oacute;n de Datos Personales de Ford mediante el env&iacute;o de solicitud firmada por el Titular, dirigida al correo electr&oacute;nico: <a href="mailto:privacy1@ford.com">privacy1@ford.com</a>, &nbsp;o bien, presentada en d&iacute;as h&aacute;biles en horario de 10:00 a 17:00 hrs. en el domicilio de Ford se&ntilde;alado al inicio de este Aviso de Privacidad. En cualquier caso, dicha solicitud deber&aacute; detallar claramente los datos respecto de los cuales se revoca su consentimiento.</p>
<p>&nbsp;</p>
<p><strong>OPCIONES Y MEDIOS PARA LIMITAR EL USO O DIVULGACI&Oacute;N DE SUS DATOS PERSONALES</strong></p>
<p style="text-align: justify;">Nuestros clientes y clientes potenciales tienen la posibilidad de limitar el uso o divulgaci&oacute;n de sus datos personales o negarse a la transferencia de los mismos, a trav&eacute;s del Comit&eacute; de Protecci&oacute;n de Datos Personales de Ford, mediante el env&iacute;o de solicitud firmada por el Titular, dirigida al correo electr&oacute;nico: <a href="mailto:privacy1@ford.com">privacy1@ford.com</a>, o bien, presentada en d&iacute;as h&aacute;biles en horario de 10:00 a 17:00 hrs. en el domicilio de Ford se&ntilde;alado al inicio de este Aviso de Privacidad, precisando fehacientemente la limitaci&oacute;n deseada al uso de sus datos personales.</p>
<p style="text-align: justify;">Si usted desea dejar de recibir mensajes promocionales, puede solicitarlo a trav&eacute;s del Comit&eacute; de Protecci&oacute;n de Datos Personales de Ford, mediante el env&iacute;o de solicitud firmada por el Titular, dirigida al correo electr&oacute;nico: <a href="mailto:privacy1@ford.com">privacy1@ford.com</a>, o bien, presentada en d&iacute;as h&aacute;biles en horario de 10:00 a 17:00 hrs. en el domicilio de Ford se&ntilde;alado al inicio de este Aviso de Privacidad.</p>
<p><strong>&nbsp;</strong></p>
<p><strong>MECANISMOS PARA RECABAR DATOS PERSONALES DE MANERA AUTOM&Aacute;TICA EN MEDIOS REMOTOS O LOCALES DE COMUNICACI&Oacute;N ELECTR&Oacute;NICA</strong></p>
<p style="text-align: justify;">La p&aacute;gina de internet de Ford (<a href="http://www.ford.mx">www.ford.mx</a>), al igual que otros sitios y micro sitios propiedad de Ford, &nbsp;utilizan "cookies" para su funcionamiento, lo que a su vez nos permite obtener datos personales del Titular que nos contacta por dicho medio.&nbsp; Los clientes y clientes potenciales que naveguen por nuestros sitios de internet pueden optar por desactivar la funcionalidad de las "cookies" dentro de su buscador, tomando en consideraci&oacute;n que posiblemente no podr&aacute; visualizar todo el contenido de dichas p&aacute;ginas de internet. Para obtener m&aacute;s informaci&oacute;n acerca de la forma en que se pueden desactivar las &ldquo;cookies&rdquo;&nbsp; por favor dir&iacute;jase a la <u>Pol&iacute;tica de Privacidad</u> de Ford.</p>
<p>&nbsp;</p>
<p><strong>MODIFICACIONES AL AVISO DE PRIVACIDAD </strong></p>
<p style="text-align: justify;">Este Aviso de Privacidad podr&aacute; ser modificado de tiempo en tiempo por Ford. Dichas modificaciones le ser&aacute;n oportunamente informadas a trav&eacute;s de su p&aacute;gina en internet <a href="http://www.ford.mx">www.ford.mx</a>, o cualquier otro medio de comunicaci&oacute;n oral, impreso, electr&oacute;nico o mediante el uso de cualquier otra tecnolog&iacute;a, que Ford determine para tal efecto.</p>
<p>&nbsp;</p>
<p style="text-align: right;">Fecha de &uacute;ltima actualizaci&oacute;n: Enero 31, 2017</p>
					
					</div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Aceptar</button>
      </div>
    </div>
  </div>
</div>
	<!-- Navigation -->
	<nav id="menuTH-A" class="navbar navbar-default navbar-fixed-top "
		data-ng-controller="updateSession" style="max-height: 60px;background-color: white;">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" style="padding: 0px 0px;" ui-sref="home"> <img style="max-width: 200px;margin-left: 90px;margin-top: 5px;" src="img/company_logo/Ford/header1.png">
				</a>
			</div>
		<ul class="nav navbar-nav navbar-right ">
			<li class="color-default-ford"><h4 style="padding-right: 90px; margin-top: 22px;margin-left: 15px;"><b>¡Bienvenido!  {{user.firstName }} {{user.lastName1}}</b></h4></li>
			<li><h4 style="padding-top: 10px;padding-right: 80px;"><a style="text-decoration: blink;" href="logout" "><i class="fa fa-power-off color-default-ford " style="vertical-align: middle;"></i>&ensp;Cerrar Sesión</a></h4></li>
		</ul> 
		</div>
	</nav>
	<nav id="menuTH-A" class="navbar navbar-fixed-top"
		data-ng-controller="updateSession" style="margin-top: 50px;">
		<div class="container" style="background-color: #2d96cd;">
		<ul class="nav navbar-nav navbar-left " data-ng-controller="getClassificationsCam">
			<li class="dropdown"><a href="#" class="dropdown-toggle" style="color: white;padding-top: 15px;background-color: #1B394E;height: 60px;padding-left: 40px;width: 320px;"
				data-toggle="dropdown" role="button" aria-haspopup="true"
				aria-expanded="false"> <i class="fa fa-angle-double-down   fa-2x color-white-ford" style="vertical-align: sub;"></i>
					Ford Elite / Lincoln Premier<span class="caret"></span></a>
				<ul class="dropdown-menu" style="width: 320px;" ng-repeat="class in classifications">
					<li><a href="#" data-ng-click="selectClassification(class)" ui-sref="campaigns" style="padding-left: 60px;">
						{{class.className}}
					</a></li>
				</ul>
			</li>
		</ul>
		<ul class="nav navbar-nav navbar-right ">
			<li ><a class="color-white-ford" href="#" style="margin-right: 50px;" ui-sref="user_status"><i
					class="fa fa-user-circle fa-2x color-white-ford" style="padding-left: 12px;padding-top: 6px;"></i> <br />&nbsp;Estatus
			</a></li>
			<li class="dropdown"><a class="color-white-ford" href="#" class="dropdown-toggle " style="margin-right: 50px;"
				data-toggle="dropdown" role="button" aria-haspopup="true"
				aria-expanded="false"> <i class="fa fa-cloud-download  fa-2x color-white-ford " style="padding-left: 15px;padding-top: 6px;"></i>
					<br /> Archivos<span class="caret"></span></a>
				<ul class="dropdown-menu" data-ng-controller="getListAcuseFiles">
					<li><a href="#" ng-repeat="fileAcuse in listAcuseFiles" data-ng-click="getFileAcuse(fileAcuse)">{{fileAcuse.fileName}}</a></li>
				</ul>
			</li>
			<li ><a ui-sref="contac" class="color-white-ford" href="#" style="margin-right: 50px;"><i
					class="fa fa-child  fa-2x color-white-ford" style="padding-left: 16px;padding-top: 6px;"></i> <br />Contacto
			</a></li>
			<li ><a class="color-white-ford" href="#" style="margin-right: 80px;" ui-sref="questions"><i
					class="fa fa-question-circle fa-2x color-white-ford" style="padding-left: 22px;padding-top: 6px;"></i> <br />&nbsp;Preguntas
			</a></li>
		</ul>
		</div>
	</nav>
	<br><br><br><br>
	<br>
	<div ui-view></div>
		<section id="contact">
			<div class="row">
				<div class="col-md-3">
					<a class="navbar-brand" style="padding: 0px 0px;"> <img
						style="max-width: 130px;margin-left: 15px;margin-top: 15px;"
						src="img/company_logo/Ford/logo.png">
					</a>
				</div>
				<div class="col-md-5" style="padding-top: 20px;">Copyright ©
					2017 Ford Motor Company - Todos los derechos reservados.
				</div>
				<div class="col-md-2">
					<a class="navbar-brand" style="padding: 0px 0px;"> <img
						style="max-width: 230px;margin-top: 5px;"
						src="img/company_logo/FordCredit/header.png">
					</a>
				</div>
				<div class="col-md-1">
					<a class="navbar-brand" style="padding-top: 0px;padding-left: 60px;"> <img
						style="max-width:97px; margin-left: 0px; margin-top: 5px;"
						src="img/company_logo/Lincoln/logo.png">
					</a>
				</div>
			</div>
		</section>
	</div>
</body>
</html>

