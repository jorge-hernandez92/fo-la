<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	
	<br><br><br>


<section id="carousel-home">

	<div style="text-align: center;">
		<h1>Dudas o Preguntas</h1>
	</div>

	<div class="panel panel-default" style="padding-left: 100px;border-color: white;padding-right: 100px;">

		<div class="panel-body">

			<div class="panel-group" id="accordion" role="tablist"
				aria-multiselectable="true">
				<div class="panel panel-default">
					<div class="panel-heading" role="tab" id="headingOne">
						<h4 class="panel-title">
							<a role="button" data-toggle="collapse" data-parent="#accordion"
								href="#/preguntas#collapseOne" aria-expanded="true"
								aria-controls="collapseOne">1.	¿Cómo participo en el programa de incentivos?</a>
						</h4>
					</div>
					<div id="collapseOne" class="panel-collapse collapse in"
						role="tabpanel" aria-labelledby="headingOne">
						<div class="panel-body">

							Éste es el proceso de inscripción al programa:

							<ul>
								<br>
								<li>Solicitar al coordinador de entrenamiento en tu
									distribuidor el registro en STARS con un puesto elegible
									(asesor de venta, asesor de conauto, gerente de ventas, F&I)</li>
								<br>

								<li>Tramitar tarjeta Lealtad Sí Vale (en caso de no contar
									con ella);Para solicitar una tarjeta nueva se debe llenar
									correctamente el formato de solicitud que se describe a
									continuación y entregarlo en original anexando copia legible y
									vigente de IFE/INE en atención a Silvia Camarena o Leonardo
									Aguilar en las oficinas de Ford Motor Company ubicada en
									Guillermo González Camarena 1500 4to piso, Santa fe, Álvaro
									Obregón,01210 Ciudad de México, D.F., <br> <br> Los
									campos que componen la solicitud son los siguientes: <br>
									<br>

									<ul>
										<li>Fecha</li>
										<li>Tipo de seguridad</li>
										<li>Razón Social del Distribuidor</li>
										<li>BID</li>
										<li>Nombre del solicitante</li>
										<li>Email</li>
										<li>Puesto del solicitante</li>
										<li>Teléfono</li>
										<li>Área</li>
										<li>Clave STARS</li>
										<li>Usuario eCAPS</li>
										<li>Firma del Solicitante (igual que en INE)</li>
										<li>Firma del Representante Legal del distribuidor (igual
											que en INE)</li>
											
										
										
									</ul>
									<br>
									Nota: La información deberá coincidir con la registrada en la base STARS
									<br>
									
									<br>

								</li>
								
								
								<li>Una vez que la solicitud sea aprobada, se entregará un paquete que incluye una tarjeta de Lealtad Sí Vale y dos formatos de acuse que deberán ser llenados y enviados, en original, a la dirección antes mencionada </li>
							</ul>

						</div>
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading" role="tab" id="headingTwo">
						<h4 class="panel-title">
							<a class="collapsed" role="button" data-toggle="collapse"
								data-parent="#accordion" href="#/preguntas#collapseTwo"
								aria-expanded="false" aria-controls="collapseTwo">2.	¿Cuál es el formato de solicitud de tarjeta Lealtad Sí Vale?</a>
						</h4>
					</div>
					<div id="collapseTwo" class="panel-collapse collapse"
						role="tabpanel" aria-labelledby="headingTwo">
						<div class="panel-body">
							<ul>
								<li><a href="#" ng-click="downloadStaticXLSFile()">Solicitud de Tarjetas</a></li>
							</ul>
						</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading" role="tab" id="headingThree">
						<h4 class="panel-title">
							<a class="collapsed" role="button" data-toggle="collapse"
								data-parent="#accordion" href="#/preguntas#collapseThree"
								aria-expanded="false" aria-controls="collapseThree">3.		¿Cuáles son los formatos de acuse?</a>
						</h4>
					</div>
					<div id="collapseThree" class="panel-collapse collapse"
						role="tabpanel" aria-labelledby="headingThree">
						<div class="panel-body">
							<ul>
								<li><a href="#" ng-click="getFormatoAcuseFCMAction()">Formato Acuse FCM 2016</a><br><br></li> 
								<li><a href="#" ng-click="getFormatoAcuse2016FORDAction()">Formato Acuse FORD 2016</a></li>
							</ul>

						</div>
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading" role="tab" id="heading44">
						<h4 class="panel-title">
							<a class="collapsed" role="button" data-toggle="collapse"
								data-parent="#accordion" href="#/preguntas#collapse44"
								aria-expanded="false" aria-controls="collapseThree">4.	¿Cómo puedo saber estatus de mi solicitud?</a>
						</h4>
					</div>
					<div id="collapse44" class="panel-collapse collapse"
						role="tabpanel" aria-labelledby="heading44">
						<div class="panel-body">Consulta el módulo Acuses y solicitudes </div>
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading" role="tab" id="heading55">
						<h4 class="panel-title">
							<a class="collapsed" role="button" data-toggle="collapse"
								data-parent="#accordion" href="#/preguntas#collapse55"
								aria-expanded="false" aria-controls="collapseThree">5.	¿Quiero saber cuándo se activará mi tarjeta?</a>
						</h4>
					</div>
					<div id="collapse55" class="panel-collapse collapse"
						role="tabpanel" aria-labelledby="heading55">
						<div class="panel-body">Consulta el módulo Acuses y solicitudes </div>
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading" role="tab" id="heading66">
						<h4 class="panel-title">
							<a class="collapsed" role="button" data-toggle="collapse"
								data-parent="#accordion" href="#/preguntas#collapse66"
								aria-expanded="false" aria-controls="collapseThree">6.	¿Cómo puedo consultar el saldo de una tarjeta Sí Vale?</a>
						</h4>
					</div>
					<div id="collapse66" class="panel-collapse collapse"
						role="tabpanel" aria-labelledby="heading66">
						<div class="panel-body">

							<ol>
								<li>Llama al <u>58 14 93 93</u> (Cd de México) o al <u>01 800 881 93 93</u> (Interior de la república)*<br><br></li>
								<li>Consulta la página web de Si Vale www.sivale.mx "Operación en Línea", y selecciona como usuario Tarjetahabiente (en esta opción también se pueden consultar los movimientos de 6 meses a la fecha)<br><br></li>
								<li>Consulta la APP de Sí vale en tu celular (descargable en Play Store o Apple Store) ingresa tu número de tarjeta y contraseña (en esta opción también se pueden consultar los últimos 5 movimientos)<br><br></li>
								<li>Envía un mensaje de texto desde tu celular al número <u>21616</u>, con la palabra sí vale seguida  del tu número de tarjeta Por ejemplo: Sivale <u>5349260300000000</u>*<br><br></li>
								
							</ol>
							
							* La consulta de saldos vía mensaje de texto y vía telefónica tienen costo

						</div>
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading" role="tab" id="heading77">
						<h4 class="panel-title">
							<a class="collapsed" role="button" data-toggle="collapse"
								data-parent="#accordion" href="#/preguntas#collapse77"
								aria-expanded="false" aria-controls="collapseThree">7.	¿Cuáles son las razones posibles por las que no recibo el depósito de mis incentivos?</a>
						</h4>
					</div>
					<div id="collapse77" class="panel-collapse collapse"
						role="tabpanel" aria-labelledby="heading77">
						<div class="panel-body">

							<ol>
								<li>No cuentas con una tarjeta lealtad Sí Vale<br><br></li>
								<li>Aún no regresas tu formato de acuse de Ford Motor Company con firma en original<br><br></li>
								<li>Tu tarjeta Lealtad Sí Vale aún no está activa (se activa 48 hrs después de que recibimos tus acuses en Ford Motor Company)<br><br></li>
								<li>Has excedido el monto límite mensual de $40,000.00 de incentivos que se pueden depositar en tu tarjeta Lealtad Sí Vale</li>
							</ol>

						</div>
					</div>
				</div>

				<div class="panel panel-default">
					<div class="panel-heading" role="tab" id="heading88">
						<h4 class="panel-title">
							<a class="collapsed" role="button" data-toggle="collapse"
								data-parent="#accordion" href="#/preguntas#collapse88"
								aria-expanded="false" aria-controls="collapseThree">8.	¿Dónde puedo consultar los esquemas de incentivos del mes?</a>
						</h4>
					</div>
					<div id="collapse88" class="panel-collapse collapse"
						role="tabpanel" aria-labelledby="heading88">
						<div class="panel-body">

							<ul>
								<li>En la plataforma FMC Dealer<br><br></li>
								<li>Mediante los correos electrónicos que Ford envía en la primera semana de cada mes (en caso de no estés 
								recibiendo dichos mails es necesario que acudas con tu coordinador de 
								entrenamiento para actualizar tu dirección de correo en STARS) </li>
							</ul>

						</div>
					</div>
				</div>

				<div class="panel panel-default">
					<div class="panel-heading" role="tab" id="heading99">
						<h4 class="panel-title">
							<a class="collapsed" role="button" data-toggle="collapse"
								data-parent="#accordion" href="#/preguntas#collapse99"
								aria-expanded="false" aria-controls="collapseThree">9.	¿Dónde puedo consultar mi estado de cuenta del mes?</a>
						</h4>
					</div>
					<div id="collapse99" class="panel-collapse collapse"
						role="tabpanel" aria-labelledby="heading99">
						<div class="panel-body">En el módulo estados de cuenta</div>
					</div>
				</div>

				<div class="panel panel-default">
					<div class="panel-heading" role="tab" id="heading10">
						<h4 class="panel-title">
							<a class="collapsed" role="button" data-toggle="collapse"
								data-parent="#accordion" href="#/preguntas#collapse10"
								aria-expanded="false" aria-controls="collapseThree">10.	¿Con quién puedo revisar dudas específicas de incentivos?</a>
						</h4>
					</div>
					<div id="collapse10" class="panel-collapse collapse"
						role="tabpanel" aria-labelledby="heading10">
						<div class="panel-body">
							<ul>
								<li>Extensión de garantía, Paola Vallejo <u>pvallej2@ford.com</u><br><br></li>
								<li>Ford Credit , Itzel Garrido <u>igarrid2@ford.com</u><br><br></li>
								<li>Altas de eCAPS <u>slfocus@ford.com</u><br><br></li>
								<li>Servicio y Refacciones, Leonardo Aguilar
									<u>laguil26@ford.com</u><br><br></li>
								<li>Ford Elite Silvia Camarena <u>scamare1@ford.com</u></li>

							</ul>
						</div>
					</div>
				</div>
			</div>

		</div>

	</div>

</section>

