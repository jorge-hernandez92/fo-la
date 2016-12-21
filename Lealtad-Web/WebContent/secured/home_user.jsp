<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html ng-app="app" data-ng-controller="campaignController">
<head ng-cloak>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="refresh" content="<%=(session.getMaxInactiveInterval())%>; url=Ford" />



<title>Lealtad-Incentivos</title>

<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/daterangepicker.min.css">
<link rel="stylesheet" href="css/ng-table.min.css">
<link rel="stylesheet" href="css/angular-carousel.css">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/sb-admin-2.css">

<link ng-href="css/{{css}}" rel="stylesheet">
<!-- links provicinales  -->
<link rel="stylesheet" href="css/sticky-footer.css">
<link rel="stylesheet" type="text/css" href="css/normalize.css" />
<!-- -----------------------------------------------------------------------------<link rel="stylesheet" type="text/css" href="css/set2.css" /> -->
<link href="css/default-fonts.css" rel="stylesheet">

<!-- Nuevo rediseño -->
<link rel="stylesheet" type="text/css" href="css/transition-campaigns.css" />

<!-- ESTILO DEL CLIENTE  -->
<link rel="stylesheet" type="text/css" href="css/ford/ford-style.css" />

<!-- ESTILO DE BOTONES DE INICIO DE PROGRAMAS -->
<!-- ESTILO DE BOTONES DE INICIO DE PROGRAMAS -->
<!-- ESTILO DE BOTONES DE INICIO DE PROGRAMAS -->
<!-- ESTILO DE BOTONES DE INICIO DE PROGRAMAS -->
<!-- ESTILO DE BOTONES DE INICIO DE PROGRAMAS -->
<link rel="stylesheet" type="text/css" href="css/style_button_home_th/hover.css" />
<link rel="stylesheet" type="text/css" href="css/style_button_home_th/demo-page.css" />


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

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog modal-lg" role="document" style="overflow-y: scroll; max-height:85%;  margin-top: 50px; margin-bottom:50px;">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">AVISO DE PRIVACIDAD DE SÍ VALE MÉXICO</h4>
      </div>
      <div class="modal-body">AVISO DE PRIVACIDAD DE SÍ VALE MÉXICO,
					S.A. DE C.V. (ANTES PRESTACIONES UNIVERSALES, S.A. DE C.V.) Sí Vale
					México, S.A. DE C.V. (Antes Prestaciones Universales, S.A. de C.V.)
					(En lo sucesivo “Sí Vale”), con domicilio en Av. Paseo de la
					Reforma 284, Piso 23, C.P. 06600, Colonia Juárez, Delegación
					Cuauhtémoc, Ciudad de México, y portal de internet www.sivale.mx
					(Sitio Web), es responsable del uso, manejo y protección, de sus
					datos personales y al respecto le informamos lo siguiente: ¿Para
					qué fines utilizaremos sus datos personales? Los datos personales
					que recabamos de usted los utilizaremos para las siguientes
					finalidades que son necesarias para el servicio que solicita:<br> <br>

					<ul>
						<li>Integración y actualización de expedientes de conformidad
							con las leyes aplicables.</li>

						<li>Hacer cumplir nuestros términos y condiciones así como la
							operación, funcionamiento y administración de nuestros productos.
						</li>

						<li>Servicio de consulta de saldos a través de cadenas
							comerciales al momento de realizar una transacción (sujeto a
							disponibilidad del servicio).</li>
						<br>

					</ul>

					De manera adicional utilizaremos su información personal para las
					siguientes finalidades secundarias, que no son necesarias para el
					servicio solicitado, pero que nos permiten y facilitan brindarle
					una mejor atención y servicio:<br> <br>

					<ul>

						<li>Fines estadísticos, mejora de nuestros productos,
							servicios, operación, actividades, e incluso respecto de la
							actualización de contenidos publicados en nuestro Sitio Web.</li>

						<li>Realizar estudios internos sobre hábitos de consumo.</li>

						<li>Proporcionar orientación, asesoría y venta sobre los
							productos y servicios que ofrecemos.</li>

						<li>Fines publicitarios, promocionales, telemarketing,
							transaccionales, administración del Sitio Web, desarrollo de
							nuevos productos y servicios, encuestas de servicio, calidad y
							satisfacción de nuestros clientes, análisis de uso de productos,
							para el envío de avisos acerca de productos y servicios operados
							por las empresas afiliadas a “SÍ VALE” y/o por sus subsidiarias.
						</li>

						<li>Envío de ofertas promocionales a nombre de “SÍ VALE” ya
							sea por cuenta propia o de un tercero, cumpliendo con el
							resguardo de la información de datos personales, aún los
							sensibles, con el principal objetivo de ofrecer productos y
							servicios en beneficio de los usuarios ya sean operados por “SÍ
							VALE”, por sus empresas afiliadas o por terceros (proveedores de
							servicios).</li>
						<br>

					</ul>

					En caso de que no desee que sus datos
					personales sean tratados para las finalidades antes descritas,
					cuenta con 5 días hábiles a partir de que haya contratado nuestros
					servicios para poder manifestar su negativa a través de los medios
					de contacto proporcionados en el presente Aviso. La negativa para
					el uso de sus datos personales para estas finalidades no podrá ser
					un motivo para que le neguemos los servicios y productos que
					actualmente presta a sus usuarios. ¿Qué datos personales
					utilizaremos para estos fines? <br> <br>

					<ul>
						<li>Para llevar a cabo las finalidades descritas en el
							presente Aviso de Privacidad, utilizaremos los siguientes datos
							personales: 
						</li><br>
					</ul>

					Datos de identificación: nombre
					completo, dirección, teléfono de casa, celular y/o de trabajo,
					correo electrónico, estado civil, nombre del cónyuge, concubinario
					(a) o pareja en convivencia, en su caso, firma, firma electrónica,
					Registro Federal de Contribuyentes (RFC), Clave Única de Registro
					Poblacional (CURP), lugar y fecha de nacimiento, edad, nombres de
					familiares (cuando aplique). ¿Con quién compartimos su información
					personal y para qué fines? <br> 
					
					“SÍ VALE” podrá transferir sus datos
					personales a terceros cuando la transferencia: (i) esté prevista en
					una Ley o Tratado en los que México sea parte; (ii) sea efectuada a
					sociedades controladoras, subsidiarias o afiliadas, o a cualquier
					sociedad del mismo grupo que opere bajo los mismos procesos y
					políticas internas, así como a sus asociadas; (iii) sea necesaria
					por virtud de un contrato, celebrado o por celebrar entre “SÍ VALE”
					y un tercero, en interés del titular; (iv) sea necesaria o
					legalmente exigida para la salvaguarda de un interés público, o
					para la procuración o administración de justicia; (v) sea precisa
					para el reconocimiento, ejercicio o defensa de un derecho en un
					proceso judicial; y, (vi) sea precisa para el mantenimiento o
					cumplimiento de una relación jurídica entre “SÍ VALE” y el titular.
					En caso de transferencia de los datos personales, ésta siempre se
					llevará a cabo a través de figuras e instrumentos legales que
					brinden el nivel de protección y medidas de seguridad adecuados
					para dichos datos. <br>
					
					¿Cuál es el medio y procedimiento para ejercer
					sus derechos de acceder, rectificar o cancelar sus datos
					personales, u oponerse a su uso, así como para revocar su
					consentimiento y/o limitar el uso o divulgación de sus datos
					personales? Usted tiene derecho a conocer qué datos personales
					tenemos de usted, para qué los utilizamos y las condiciones del uso
					que les damos (Acceso). Asimismo, es su derecho solicitar la
					corrección de su información personal en caso de que esté
					desactualizada, sea inexacta o incompleta (Rectificación); que la
					eliminemos de nuestros registros o bases de datos cuando considere
					que la misma no está siendo utilizada adecuadamente (Cancelación);
					así como oponerse al uso de sus datos personales para fines
					específicos (Oposición). Estos derechos se conocen como derechos
					ARCO. De la misma forma usted puede revocar el consentimiento que,
					en su caso, nos haya otorgado y/o limitar el uso o divulgación de
					sus datos personales. <br>
					
					Es importante que tenga en cuenta que no en
					todos los casos podremos darle una respuesta favorable a su
					solicitud, debido a que es posible que por alguna obligación legal
					requiramos seguir tratando sus datos personales. <br>
					
					Si usted o su representante legal desea ejercer sus Derechos ARCO, deberá
					completar el “Formato de Solicitud para ejercer los Derechos ARCO,
					Revocación del consentimiento y/o Limitación de Uso o divulgación
					de datos personales” (en lo sucesivo la “Solicitud”) que se
					encuentra disponible en el Sitio Web de “SÍ VALE” y enviarlo por
					correo electrónico al Responsable de Datos Personales a la
					dirección datospersonales@sivale.com.mx. Para poder atender su
					solicitud, usted o su representante deberán acreditar correctamente
					su identidad y acompañarla con copia de alguna de las
					identificaciones oficiales vigentes, así como de la documentación
					que considere sustente su petición. <br>
					
					En caso de que la información proporcionada en la Solicitud 
					recibida sea errónea o insuficiente,
					o bien no se acompañen los documentos de acreditación
					correspondientes, “SÍ VALE”, dentro de los 5 días hábiles
					posteriores a la recepción de la solicitud, le solicitará
					información adicional para atender su petición. Usted contará con
					10 días hábiles contados a partir del día siguiente en que lo haya
					recibido para dar respuesta y aportar los elementos o documentos
					necesarios. De no dar respuesta en dicho plazo, se tendrá por no
					presentada la solicitud correspondiente. “SÍ VALE” cuenta con un
					plazo máximo de 20 días hábiles contados desde la fecha en que se
					recibió la solicitud, a efecto de que, si resulta procedente, haga
					efectiva la misma dentro de los 15 días hábiles siguientes a que se
					comunique la respuesta. La respuesta se dará vía electrónica a la
					dirección de correo que se especifique en la Solicitud. El uso de
					tecnologías de rastreo en nuestro portal de internet Le informamos
					que en nuestra página de internet utilizamos cookies u otras
					tecnologías de rastreo, a través de las cuales es posible
					identificar el navegador que ha sido utilizado por usted durante la
					sesión. <br>
					
					Usted podrá desactivar el almacenamiento de Cookies o
					ajustar su explorador de Internet para que le sea informado antes
					de que las Cookies se almacenen en su computadora. Las Cookies
					pueden ser depuradas por usted de forma manual en cuanto usted lo
					decida. <br>
					¿Cómo puede conocer los cambios en este Aviso de Privacidad?<br> 
					
					El presente Aviso de Privacidad puede sufrir
					modificaciones, cambios o actualizaciones derivadas de nuevos
					requerimientos legales; de nuestras propias necesidades por los
					productos o servicios que ofrecemos; de nuestras prácticas de
					privacidad; de cambios en nuestro modelo de negocio, o por otras
					causas, que en su momento serán informadas al usuario. <br>
					
					“SÍ VALE” se reserva el derecho de efectuar en cualquier momento modificaciones
					al presente Aviso de Privacidad, para la atención de
					actualizaciones legislativas o jurisprudenciales, políticas
					internas, nuevos requerimientos para la prestación u ofrecimiento
					de nuestros servicios o productos y prácticas del mercado. <br>
					
					Estas modificaciones estarán disponibles a través de los siguientes
					medios: (i) anuncios visibles en nuestros establecimientos o
					centros de atención a clientes; (ii) trípticos o folletos
					disponibles en nuestras oficinas; (iii) en nuestro Sitio Web,
					sección “Aviso de Privacidad”; (iv) a través del servicio
					Interactive Voice Response o de cualquier medio de contacto que
					utilice para nuestros servicios; (v) o se las haremos llegar al
					correo electrónico que nos haya proporcionado. Si usted considera
					que su derecho ha sido lesionado ó presume que en el tratamiento de
					sus datos personales existe alguna violación a las disposiciones
					previstas en la Ley Federal de Protección de Datos Personales en
					Posesión de los Particulares, podrá interponer la queja o denuncia
					correspondiente ante el IFAI, para mayor información visite
					www.ifai.org.mx. Si usted está interesado en ejercer sus derechos
					ARCO, descargue aquí la Solicitud y envíela debidamente completada,
					al correo datospersonales@sivale.com.mx.
					
					</div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Aceptar</button>
      </div>
    </div>
  </div>
</div>

	<!-- Navigation -->
	<nav id="menuTH-A" class="navbar navbar-default navbar-fixed-top" style="background-color: white;"
		data-ng-controller="updateSession">
		
			<div class="navbar-header">
				<a class="navbar-brand" style="padding: 0px 0px;"> <img style="max-width:170px; margin-left: 15px;" src="img/company_logo/Ford/logo1.png">
				</a>
			</div>

		<ul class="nav navbar-nav navbar-right" style=" margin-top: 15px;">
			
			<li><a> <i class="fa fa-user color-default-ford"></i> 
					{{user.firstName}}
			</a></li>
			
			<li><a> <i class="fa fa-credit-card color-default-ford"></i> 
					{{user.tjCardNumber}}
			</a></li>
			
			<li><a href="#contact" class="page-scroll" ng-click="dudas()" > <i class="fa fa-question color-default-ford"></i> 
					Dudas o preguntas
			</a></li>
			
			<li><a href="#contact" data-toggle="modal" data-target="#myModal" > <i class="fa fa-exclamation-triangle color-default-ford"></i> 
					Aviso
			</a></li>
			
			<li><a href="logout"> <i class="fa fa-sign-out color-default-ford"></i> 
					Salir
			</a></li>
			
		</ul>
		
	</nav>
	
		<!-- Navigation -->
	<nav id="menuTH-A" class="navbar navbar-ford navbar-fixed-top"
		data-ng-controller="updateSession" style="margin-top: 65px;">

		<ul class="nav navbar-nav navbar-left" style=" margin-top: 0px; margin-left: 15px;">
			
			<li id="li-home"><a  href="#" ng-click="goToHome()"  style="color: white;padding: 5px;color: #C0C0C0;"> INICIO  </a></li>
			
			<li id="li-campaigns"><a ui-sref="campaigns" style="color: white;padding: 5px;color: #C0C0C0;"> | INCENTIVOS      </a></li>
			
			<li id="li-campaign"><a  ui-sref="campaign" style="color: white;padding: 5px;color: #C0C0C0;"> | PUBLICACIONES  </a></li>	
			
		</ul>
		
			<p id="p-home" class="navbar-text" style="font-weight: bold;margin-top: 5px;margin-left: 5px;margin-right: 5px;color: #C0C0C0;">INICIO</p>
			
			<p id="p-campaigns" class="navbar-text" style="font-weight: bold;margin-top: 5px;margin-left: 5px;margin-right: 5px;color: #C0C0C0;">| INCENTIVOS</p>
			
			<p id="p-campaign" class="navbar-text" style="font-weight: bold;margin-top: 5px;margin-left: 5px;margin-right: 5px;color: #C0C0C0;">| PUBLICACIONES</p>
			
			<p id="p-detail-publication" class="navbar-text" style="font-weight: bold;margin-top: 5px;margin-left: 5px;margin-right: 5px;color: #C0C0C0;">| DETALLE DE PUBLICACIÓN</p>
			
			<p id="p-account" class="navbar-text" style="font-weight: bold;margin-top: 5px;margin-left: 5px;margin-right: 5px;color: #C0C0C0;">| ESTADO DE CUENTA</p>
		
	</nav>
	
	<nav style="display:none; margin-top: 95px;" id="menu-files-publication" class="navbar navbar-info-file navbar-fixed-top"
		data-ng-controller="updateSession">
		<ul class="nav navbar-nav navbar-left" style=" margin-top: 0px; margin-left: 500px;">
			<li><a href="#"  style="color: black; padding: 5px;"> 
				NO OLVIDES CONSULTAR LOS ARCHIVOS ADJUNTOS 
				<i class="fa fa-download color-default-ford"></i>
			</a></li>
		</ul>
	</nav>

<!-- 	<div class="alert alert-info navbar-fixed-top" -->
<!-- 		style="position: fixed; margin-top: 95px;"> -->
<!-- 		<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a> -->
<!-- 		<strong>Success!</strong> This alert box could indicate a successful -->
<!-- 		or positive action. -->
<!-- 	</div> -->

	<br><br><br><br>
	


	<div ui-view></div>


	
</body>
</html>

