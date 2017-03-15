<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	
<br><br>

<div class="row">
			
			<br>
		
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<h2 class="text-center color-default-ford" style="font-weight: bold;">
					Estado de Cuenta General
				</h2>
				
				<br>
				
			</div>
			<div class="col-md-2"></div>
</div>

<div class="panel-body ">

	<div class="container" style="width: 1300px;">
		<div class="panel table-top-sivale">
			<div class="panel-heading">
				
				<div class="navbar container" style="width: 1300px;">

					<div class="navbar-form navbar-left padding-cero" role="search" style="padding: 0px;">
						<div class="form-group">

							<input type="text" class="form-control" placeholder="Incentivo"
								ng-model="search.campaing" style="width: 170px;">
								 
							<input type="text" class="form-control" placeholder="Participante"
								ng-model="search.thIdStars" style="width: 170px;">
								 
<!-- 							<input type="text" class="form-control" placeholder="Movimiento" -->
<!-- 								ng-model="search.movement" style="width: 170px;"> -->

<!-- 							<div class="input-group"> -->
<!-- 								<div class="input-group-btn" > -->
<!-- 									<button type="button" class="btn btn-default dropdown-toggle" -->
<!-- 										data-toggle="dropdown" aria-haspopup="true" -->
<!-- 										aria-expanded="false"> -->
<!-- 										Movimiento <span class="caret"></span> -->
<!-- 									</button> -->
<!-- 									<ul class="dropdown-menu"> -->
<!-- 										<li><a href="#">Ganado</a></li> -->
<!-- 										<li><a href="#">Dispersado</a></li> -->
<!-- 										<li><a href="#">Pendiente</a></li> -->
<!-- 									</ul> -->
<!-- 								</div> -->
<!-- 								<input type="text" id="moverm" class="form-control" disabled style="width: 170px;"  aria-label="..."> -->
								
<!-- 								<span class="input-group-addon"> <input type="checkbox" -->
<!-- 									aria-label="..." ng-click="changeMove(checkboxModel0.value)" -->
<!-- 									ng-model="checkboxModel0.value"> -->
<!-- 								</span>  -->
<!-- 							</div> -->

<!-- 							<div class="btn-group"> -->
<!-- 								<button type="button" id="btnRM"  class="btn btn-default">Movimiento: Todos</button> -->
<!-- 								<button type="button" class="btn btn-default dropdown-toggle" -->
<!-- 									data-toggle="dropdown" aria-haspopup="true" -->
<!-- 									aria-expanded="false"> -->
<!-- 									<span class="caret"></span> <span class="sr-only">Toggle -->
<!-- 										Dropdown</span> -->
<!-- 								</button> -->
<!-- 								<ul class="dropdown-menu"> -->
<!-- 									<li><a ng-click="moveg()" href="#">Ganado</a></li> -->
<!-- 									<li><a ng-click="moved()" href="#">Dispersado</a></li> -->
<!-- 									<li><a ng-click="movep()" href="#">Pendiente</a></li> -->
<!-- 									<li><a ng-click="movet()" href="#">Todos</a></li> -->
<!-- 								</ul> -->
<!-- 							</div> -->

							<div class="btn-group">
								<button type="button" id="btnRM"  class="btn btn-default dropdown-toggle"
									data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="false">
									Movimiento: Todos <span class="caret"></span>
								</button>
								<ul class="dropdown-menu">
									<li><a ng-click="moveg()" href="#">Ganado</a></li>
									<li><a ng-click="moved()" href="#">Dispersado</a></li>
									<li><a ng-click="movep()" href="#">Pendiente</a></li>
									<li><a ng-click="movet()" href="#">Todos</a></li>
								</ul>
							</div>

							<input type="text" class="form-control" placeholder="Observación"
								ng-model="search.observation" style="width: 170px;">

							<div class="input-group">
								<span class="input-group-addon"> <input type="checkbox"
									aria-label="..." ng-click="changeDate(checkboxModel.value)"
									ng-model="checkboxModel.value">
								</span> <input date-range-picker="" id="daterange1" name="daterange1"
									class="form-control date-picker ng-pristine ng-valid ng-isolate-scope ng-valid-required ng-touched"
									type="text" ng-model="date" required="" disabled>

							</div>

							<button class="btn btn-primary"
								ng-click="searchAccountStatus(date,checkboxModel.value)">Buscar</button>

						</div>

						<div class="btn-group">

							<div class="dropdown">
								<button class="btn btn-default dropdown-toggle" type="button"
									id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="true">
									<i class="fa fa-eye  fa-lg"></i>
								</button>
								<ul class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenu1">
									<li><a ng-click="getRMPending()" href="#">Visualizar
											reporte de pendientes</a></li>
									<li><a ng-click="getRM()" href="#">Visualizar reporte
											completo</a></li>
								</ul>
							</div>

						</div>

						<div class="btn-group">

							<div class="dropdown">
								<button class="btn btn-default dropdown-toggle" type="button"
									id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="true">
									<i class="fa fa-download  fa-lg"></i>
								</button>
								<ul class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenu1">
									<li><a ng-click="downloadRMPending1()" href="#">Descargar reporte de pendientes</a></li>
									<li><a ng-click="downloadRMPending2()" href="#">Descargar reporte completo</a></li>
								</ul>
							</div>

						</div>

					</div>
					<div class="daterangepicker dropdown-menu show-calendar opensright" style="top: 130px; left: 89.5px; right: auto; display: none;"><div class="calendar left"><div class="daterangepicker_input"><input class="input-mini active" type="text" name="daterangepicker_start" value=""><i class="fa fa-calendar glyphicon glyphicon-calendar"></i><div class="calendar-time" style="display: none;"><div></div><i class="fa fa-clock-o glyphicon glyphicon-time"></i></div></div><div class="calendar-table"><table class="table-condensed"><thead><tr><th class="prev available"><i class="fa fa-chevron-left glyphicon glyphicon-chevron-left"></i></th><th colspan="5" class="month">Dec 2015</th><th></th></tr><tr><th>Su</th><th>Mo</th><th>Tu</th><th>We</th><th>Th</th><th>Fr</th><th>Sa</th></tr></thead><tbody><tr><td class="weekend off available" data-title="r0c0">29</td><td class="off available" data-title="r0c1">30</td><td class="available" data-title="r0c2">1</td><td class="available" data-title="r0c3">2</td><td class="available" data-title="r0c4">3</td><td class="available" data-title="r0c5">4</td><td class="weekend available" data-title="r0c6">5</td></tr><tr><td class="weekend available" data-title="r1c0">6</td><td class="available" data-title="r1c1">7</td><td class="available" data-title="r1c2">8</td><td class="available" data-title="r1c3">9</td><td class="available" data-title="r1c4">10</td><td class="available" data-title="r1c5">11</td><td class="weekend available" data-title="r1c6">12</td></tr><tr><td class="weekend available" data-title="r2c0">13</td><td class="available" data-title="r2c1">14</td><td class="available" data-title="r2c2">15</td><td class="available" data-title="r2c3">16</td><td class="today available" data-title="r2c4">17</td><td class="available" data-title="r2c5">18</td><td class="weekend available" data-title="r2c6">19</td></tr><tr><td class="weekend available" data-title="r3c0">20</td><td class="available" data-title="r3c1">21</td><td class="active start-date available" data-title="r3c2">22</td><td class="in-range available" data-title="r3c3">23</td><td class="in-range available" data-title="r3c4">24</td><td class="in-range available" data-title="r3c5">25</td><td class="weekend in-range available" data-title="r3c6">26</td></tr><tr><td class="weekend in-range available" data-title="r4c0">27</td><td class="in-range available" data-title="r4c1">28</td><td class="in-range available" data-title="r4c2">29</td><td class="in-range available" data-title="r4c3">30</td><td class="in-range available" data-title="r4c4">31</td><td class="off in-range available" data-title="r4c5">1</td><td class="weekend off in-range available" data-title="r4c6">2</td></tr><tr><td class="weekend off in-range available" data-title="r5c0">3</td><td class="off in-range available" data-title="r5c1">4</td><td class="off in-range available" data-title="r5c2">5</td><td class="off in-range available" data-title="r5c3">6</td><td class="off in-range available" data-title="r5c4">7</td><td class="off in-range available" data-title="r5c5">8</td><td class="weekend off in-range available" data-title="r5c6">9</td></tr></tbody></table></div></div><div class="calendar right"><div class="daterangepicker_input"><input class="input-mini" type="text" name="daterangepicker_end" value=""><i class="fa fa-calendar glyphicon glyphicon-calendar"></i><div class="calendar-time" style="display: none;"><div></div><i class="fa fa-clock-o glyphicon glyphicon-time"></i></div></div><div class="calendar-table"><table class="table-condensed"><thead><tr><th></th><th colspan="5" class="month">Jan 2016</th><th class="next available"><i class="fa fa-chevron-right glyphicon glyphicon-chevron-right"></i></th></tr><tr><th>Su</th><th>Mo</th><th>Tu</th><th>We</th><th>Th</th><th>Fr</th><th>Sa</th></tr></thead><tbody><tr><td class="weekend off in-range available" data-title="r0c0">27</td><td class="off in-range available" data-title="r0c1">28</td><td class="off in-range available" data-title="r0c2">29</td><td class="off in-range available" data-title="r0c3">30</td><td class="off in-range available" data-title="r0c4">31</td><td class="in-range available" data-title="r0c5">1</td><td class="weekend in-range available" data-title="r0c6">2</td></tr><tr><td class="weekend in-range available" data-title="r1c0">3</td><td class="in-range available" data-title="r1c1">4</td><td class="in-range available" data-title="r1c2">5</td><td class="in-range available" data-title="r1c3">6</td><td class="in-range available" data-title="r1c4">7</td><td class="in-range available" data-title="r1c5">8</td><td class="weekend in-range available" data-title="r1c6">9</td></tr><tr><td class="weekend in-range available" data-title="r2c0">10</td><td class="in-range available" data-title="r2c1">11</td><td class="in-range available" data-title="r2c2">12</td><td class="in-range available" data-title="r2c3">13</td><td class="in-range available" data-title="r2c4">14</td><td class="in-range available" data-title="r2c5">15</td><td class="weekend in-range available" data-title="r2c6">16</td></tr><tr><td class="weekend in-range available" data-title="r3c0">17</td><td class="in-range available" data-title="r3c1">18</td><td class="in-range available" data-title="r3c2">19</td><td class="in-range available" data-title="r3c3">20</td><td class="in-range available" data-title="r3c4">21</td><td class="in-range available" data-title="r3c5">22</td><td class="weekend in-range available" data-title="r3c6">23</td></tr><tr><td class="weekend in-range available" data-title="r4c0">24</td><td class="in-range available" data-title="r4c1">25</td><td class="in-range available" data-title="r4c2">26</td><td class="in-range available" data-title="r4c3">27</td><td class="active end-date in-range available" data-title="r4c4">28</td><td class="available" data-title="r4c5">29</td><td class="weekend available" data-title="r4c6">30</td></tr><tr><td class="weekend available" data-title="r5c0">31</td><td class="off available" data-title="r5c1">1</td><td class="off available" data-title="r5c2">2</td><td class="off available" data-title="r5c3">3</td><td class="off available" data-title="r5c4">4</td><td class="off available" data-title="r5c5">5</td><td class="weekend off available" data-title="r5c6">6</td></tr></tbody></table></div></div><div class="ranges"><div class="range_inputs"><button class="applyBtn btn btn-sm btn-success" type="button" ng-click="find()">Apply</button> <button class="cancelBtn btn btn-sm btn-default" type="button">Cancel</button></div></div></div><div class="daterangepicker dropdown-menu show-calendar opensright" style="top: 206px; left: 89.5px; right: auto; display: none;"><div class="calendar left"><div class="daterangepicker_input"><input class="input-mini active" type="text" name="daterangepicker_start" value=""><i class="fa fa-calendar glyphicon glyphicon-calendar"></i><div class="calendar-time" style="display: none;"><div></div><i class="fa fa-clock-o glyphicon glyphicon-time"></i></div></div><div class="calendar-table"><table class="table-condensed"><thead><tr><th class="prev available"><i class="fa fa-chevron-left glyphicon glyphicon-chevron-left"></i></th><th colspan="5" class="month">Aug 2015</th><th></th></tr><tr><th>Su</th><th>Mo</th><th>Tu</th><th>We</th><th>Th</th><th>Fr</th><th>Sa</th></tr></thead><tbody><tr><td class="weekend off available" data-title="r0c0">26</td><td class="off available" data-title="r0c1">27</td><td class="off available" data-title="r0c2">28</td><td class="off available" data-title="r0c3">29</td><td class="off available" data-title="r0c4">30</td><td class="off available" data-title="r0c5">31</td><td class="weekend available" data-title="r0c6">1</td></tr><tr><td class="weekend available" data-title="r1c0">2</td><td class="available" data-title="r1c1">3</td><td class="available" data-title="r1c2">4</td><td class="available" data-title="r1c3">5</td><td class="available" data-title="r1c4">6</td><td class="available" data-title="r1c5">7</td><td class="weekend available" data-title="r1c6">8</td></tr><tr><td class="weekend available" data-title="r2c0">9</td><td class="available" data-title="r2c1">10</td><td class="available" data-title="r2c2">11</td><td class="available" data-title="r2c3">12</td><td class="available" data-title="r2c4">13</td><td class="available" data-title="r2c5">14</td><td class="weekend available" data-title="r2c6">15</td></tr><tr><td class="weekend available" data-title="r3c0">16</td><td class="available" data-title="r3c1">17</td><td class="available" data-title="r3c2">18</td><td class="available" data-title="r3c3">19</td><td class="available" data-title="r3c4">20</td><td class="available" data-title="r3c5">21</td><td class="weekend available" data-title="r3c6">22</td></tr><tr><td class="weekend available" data-title="r4c0">23</td><td class="available" data-title="r4c1">24</td><td class="active start-date active end-date available" data-title="r4c2">25</td><td class="off disabled" data-title="r4c3">26</td><td class="off disabled" data-title="r4c4">27</td><td class="off disabled" data-title="r4c5">28</td><td class="weekend off disabled" data-title="r4c6">29</td></tr><tr><td class="weekend off disabled" data-title="r5c0">30</td><td class="off disabled" data-title="r5c1">31</td><td class="off off disabled" data-title="r5c2">1</td><td class="off off disabled" data-title="r5c3">2</td><td class="off off disabled" data-title="r5c4">3</td><td class="off off disabled" data-title="r5c5">4</td><td class="weekend off off disabled" data-title="r5c6">5</td></tr></tbody></table></div></div><div class="calendar right"><div class="daterangepicker_input"><input class="input-mini" type="text" name="daterangepicker_end" value=""><i class="fa fa-calendar glyphicon glyphicon-calendar"></i><div class="calendar-time" style="display: none;"><div></div><i class="fa fa-clock-o glyphicon glyphicon-time"></i></div></div><div class="calendar-table"><table class="table-condensed"><thead><tr><th></th><th colspan="5" class="month">Sep 2015</th><th></th></tr><tr><th>Su</th><th>Mo</th><th>Tu</th><th>We</th><th>Th</th><th>Fr</th><th>Sa</th></tr></thead><tbody><tr><td class="weekend off off disabled" data-title="r0c0">30</td><td class="off off disabled" data-title="r0c1">31</td><td class="off disabled" data-title="r0c2">1</td><td class="off disabled" data-title="r0c3">2</td><td class="off disabled" data-title="r0c4">3</td><td class="off disabled" data-title="r0c5">4</td><td class="weekend off disabled" data-title="r0c6">5</td></tr><tr><td class="weekend off disabled" data-title="r1c0">6</td><td class="off disabled" data-title="r1c1">7</td><td class="off disabled" data-title="r1c2">8</td><td class="off disabled" data-title="r1c3">9</td><td class="off disabled" data-title="r1c4">10</td><td class="off disabled" data-title="r1c5">11</td><td class="weekend off disabled" data-title="r1c6">12</td></tr><tr><td class="weekend off disabled" data-title="r2c0">13</td><td class="off disabled" data-title="r2c1">14</td><td class="off disabled" data-title="r2c2">15</td><td class="off disabled" data-title="r2c3">16</td><td class="off disabled" data-title="r2c4">17</td><td class="off disabled" data-title="r2c5">18</td><td class="weekend off disabled" data-title="r2c6">19</td></tr><tr><td class="weekend off disabled" data-title="r3c0">20</td><td class="off disabled" data-title="r3c1">21</td><td class="off disabled" data-title="r3c2">22</td><td class="off disabled" data-title="r3c3">23</td><td class="off disabled" data-title="r3c4">24</td><td class="off disabled" data-title="r3c5">25</td><td class="weekend off disabled" data-title="r3c6">26</td></tr><tr><td class="weekend off disabled" data-title="r4c0">27</td><td class="off disabled" data-title="r4c1">28</td><td class="off disabled" data-title="r4c2">29</td><td class="off disabled" data-title="r4c3">30</td><td class="off off disabled" data-title="r4c4">1</td><td class="off off disabled" data-title="r4c5">2</td><td class="weekend off off disabled" data-title="r4c6">3</td></tr><tr><td class="weekend off off disabled" data-title="r5c0">4</td><td class="off off disabled" data-title="r5c1">5</td><td class="off off disabled" data-title="r5c2">6</td><td class="off off disabled" data-title="r5c3">7</td><td class="off off disabled" data-title="r5c4">8</td><td class="off off disabled" data-title="r5c5">9</td><td class="weekend off off disabled" data-title="r5c6">10</td></tr></tbody></table></div></div><div class="ranges"><div class="range_inputs"><button class="applyBtn btn btn-sm btn-success" type="button">Apply</button> <button class="cancelBtn btn btn-sm btn-default" type="button">Cancel</button></div></div></div><div class="daterangepicker dropdown-menu show-calendar opensright"><div class="calendar left"><div class="daterangepicker_input"><input class="input-mini" type="text" name="daterangepicker_start" value=""><i class="fa fa-calendar glyphicon glyphicon-calendar"></i><div class="calendar-time" style="display: none;"><div></div><i class="fa fa-clock-o glyphicon glyphicon-time"></i></div></div><div class="calendar-table"></div></div><div class="calendar right"><div class="daterangepicker_input"><input class="input-mini" type="text" name="daterangepicker_end" value=""><i class="fa fa-calendar glyphicon glyphicon-calendar"></i><div class="calendar-time" style="display: none;"><div></div><i class="fa fa-clock-o glyphicon glyphicon-time"></i></div></div><div class="calendar-table"></div></div><div class="ranges"><div class="range_inputs"><button class="applyBtn btn btn-sm btn-success" disabled="disabled" type="button">Apply</button> <button class="cancelBtn btn btn-sm btn-default" type="button">Clear</button></div></div></div><div class="daterangepicker dropdown-menu show-calendar opensright"><div class="calendar left"><div class="daterangepicker_input"><input class="input-mini" type="text" name="daterangepicker_start" value=""><i class="fa fa-calendar glyphicon glyphicon-calendar"></i><div class="calendar-time" style="display: none;"><div></div><i class="fa fa-clock-o glyphicon glyphicon-time"></i></div></div><div class="calendar-table"></div></div><div class="calendar right"><div class="daterangepicker_input"><input class="input-mini" type="text" name="daterangepicker_end" value=""><i class="fa fa-calendar glyphicon glyphicon-calendar"></i><div class="calendar-time" style="display: none;"><div></div><i class="fa fa-clock-o glyphicon glyphicon-time"></i></div></div><div class="calendar-table"></div></div><div class="ranges"><div class="range_inputs"><button class="applyBtn btn btn-sm btn-success" disabled="disabled" type="button">Apply</button> <button class="cancelBtn btn btn-sm btn-default" type="button">Clear</button></div></div></div><div class="daterangepicker dropdown-menu single opensright"><div class="calendar left single" style="display: block;"><div class="daterangepicker_input"><input class="input-mini" type="text" name="daterangepicker_start" value="" style="display: none;"><i class="fa fa-calendar glyphicon glyphicon-calendar" style="display: none;"></i><div class="calendar-time" style="display: none;"><div></div><i class="fa fa-clock-o glyphicon glyphicon-time" style="display: none;"></i></div></div><div class="calendar-table"></div></div><div class="calendar right" style="display: none;"><div class="daterangepicker_input"><input class="input-mini" type="text" name="daterangepicker_end" value="" style="display: none;"><i class="fa fa-calendar glyphicon glyphicon-calendar" style="display: none;"></i><div class="calendar-time" style="display: none;"><div></div><i class="fa fa-clock-o glyphicon glyphicon-time" style="display: none;"></i></div></div><div class="calendar-table"></div></div><div class="ranges" style="display: none;"><div class="range_inputs"><button class="applyBtn btn btn-sm btn-success" disabled="disabled" type="button">Apply</button> <button class="cancelBtn btn btn-sm btn-default" type="button">Clear</button></div></div></div><div class="daterangepicker dropdown-menu opensright show-calendar" style="top: 292px; left: 89.5px; right: auto; display: none;"><div class="ranges"><ul><li>Last 7 Days</li><li>Last 30 Days</li><li class="active">Custom range</li></ul><div class="range_inputs"><button class="applyBtn btn btn-sm btn-success" type="button">Apply</button> <button class="cancelBtn btn btn-sm btn-default" type="button">Cancel</button></div></div><div class="calendar left"><div class="daterangepicker_input"><input class="input-mini active" type="text" name="daterangepicker_start" value=""><i class="fa fa-calendar glyphicon glyphicon-calendar"></i><div class="calendar-time" style="display: none;"><div></div><i class="fa fa-clock-o glyphicon glyphicon-time"></i></div></div><div class="calendar-table"><table class="table-condensed"><thead><tr><th class="prev available"><i class="fa fa-chevron-left glyphicon glyphicon-chevron-left"></i></th><th colspan="5" class="month">Dec 2015</th><th></th></tr><tr><th>Su</th><th>Mo</th><th>Tu</th><th>We</th><th>Th</th><th>Fr</th><th>Sa</th></tr></thead><tbody><tr><td class="weekend off available" data-title="r0c0">29</td><td class="off available" data-title="r0c1">30</td><td class="available" data-title="r0c2">1</td><td class="available" data-title="r0c3">2</td><td class="available" data-title="r0c4">3</td><td class="available" data-title="r0c5">4</td><td class="weekend available" data-title="r0c6">5</td></tr><tr><td class="weekend available" data-title="r1c0">6</td><td class="available" data-title="r1c1">7</td><td class="available" data-title="r1c2">8</td><td class="available" data-title="r1c3">9</td><td class="available" data-title="r1c4">10</td><td class="available" data-title="r1c5">11</td><td class="weekend available" data-title="r1c6">12</td></tr><tr><td class="weekend available" data-title="r2c0">13</td><td class="available" data-title="r2c1">14</td><td class="available" data-title="r2c2">15</td><td class="active start-date available" data-title="r2c3">16</td><td class="today active end-date in-range available" data-title="r2c4">17</td><td class="available" data-title="r2c5">18</td><td class="weekend available" data-title="r2c6">19</td></tr><tr><td class="weekend available" data-title="r3c0">20</td><td class="available" data-title="r3c1">21</td><td class="available" data-title="r3c2">22</td><td class="available" data-title="r3c3">23</td><td class="available" data-title="r3c4">24</td><td class="available" data-title="r3c5">25</td><td class="weekend available" data-title="r3c6">26</td></tr><tr><td class="weekend available" data-title="r4c0">27</td><td class="available" data-title="r4c1">28</td><td class="available" data-title="r4c2">29</td><td class="available" data-title="r4c3">30</td><td class="available" data-title="r4c4">31</td><td class="off available" data-title="r4c5">1</td><td class="weekend off available" data-title="r4c6">2</td></tr><tr><td class="weekend off available" data-title="r5c0">3</td><td class="off available" data-title="r5c1">4</td><td class="off available" data-title="r5c2">5</td><td class="off available" data-title="r5c3">6</td><td class="off available" data-title="r5c4">7</td><td class="off available" data-title="r5c5">8</td><td class="weekend off available" data-title="r5c6">9</td></tr></tbody></table></div></div><div class="calendar right"><div class="daterangepicker_input"><input class="input-mini" type="text" name="daterangepicker_end" value=""><i class="fa fa-calendar glyphicon glyphicon-calendar"></i><div class="calendar-time" style="display: none;"><div></div><i class="fa fa-clock-o glyphicon glyphicon-time"></i></div></div><div class="calendar-table"><table class="table-condensed"><thead><tr><th></th><th colspan="5" class="month">Jan 2016</th><th class="next available"><i class="fa fa-chevron-right glyphicon glyphicon-chevron-right"></i></th></tr><tr><th>Su</th><th>Mo</th><th>Tu</th><th>We</th><th>Th</th><th>Fr</th><th>Sa</th></tr></thead><tbody><tr><td class="weekend off available" data-title="r0c0">27</td><td class="off available" data-title="r0c1">28</td><td class="off available" data-title="r0c2">29</td><td class="off available" data-title="r0c3">30</td><td class="off available" data-title="r0c4">31</td><td class="available" data-title="r0c5">1</td><td class="weekend available" data-title="r0c6">2</td></tr><tr><td class="weekend available" data-title="r1c0">3</td><td class="available" data-title="r1c1">4</td><td class="available" data-title="r1c2">5</td><td class="available" data-title="r1c3">6</td><td class="available" data-title="r1c4">7</td><td class="available" data-title="r1c5">8</td><td class="weekend available" data-title="r1c6">9</td></tr><tr><td class="weekend available" data-title="r2c0">10</td><td class="available" data-title="r2c1">11</td><td class="available" data-title="r2c2">12</td><td class="available" data-title="r2c3">13</td><td class="available" data-title="r2c4">14</td><td class="available" data-title="r2c5">15</td><td class="weekend available" data-title="r2c6">16</td></tr><tr><td class="weekend available" data-title="r3c0">17</td><td class="available" data-title="r3c1">18</td><td class="available" data-title="r3c2">19</td><td class="available" data-title="r3c3">20</td><td class="available" data-title="r3c4">21</td><td class="available" data-title="r3c5">22</td><td class="weekend available" data-title="r3c6">23</td></tr><tr><td class="weekend available" data-title="r4c0">24</td><td class="available" data-title="r4c1">25</td><td class="available" data-title="r4c2">26</td><td class="available" data-title="r4c3">27</td><td class="available" data-title="r4c4">28</td><td class="available" data-title="r4c5">29</td><td class="weekend available" data-title="r4c6">30</td></tr><tr><td class="weekend available" data-title="r5c0">31</td><td class="off available" data-title="r5c1">1</td><td class="off available" data-title="r5c2">2</td><td class="off available" data-title="r5c3">3</td><td class="off available" data-title="r5c4">4</td><td class="off available" data-title="r5c5">5</td><td class="weekend off available" data-title="r5c6">6</td></tr></tbody></table></div></div></div>
					
				</div>	

				<div class="row">
				<div class="col-md-4">

				</div>
				
				<div class="col-md-1">
					
				</div>
				
				<div class="col-md-7">
				
<!-- 					<button  ng-click="getRM()" type="button" class="btn btn-primary"> -->

<!-- 						<i class="fa fa-list-alt " aria-hidden="true"></i> <span -->
<!-- 							aria-hidden="true"></span>Todo -->
<!-- 					</button> -->
				
<!-- 					<button  ng-click="getRMPending()" type="button" class="btn btn-primary"> -->

<!-- 						<i class="fa fa-list-alt " aria-hidden="true"></i> <span -->
<!-- 							aria-hidden="true"></span>Pendientes -->
<!-- 					</button> -->
					
<!-- 					<button ng-click="getRMNoPending()" type="button" class="btn btn-primary"> -->

<!-- 						<i class="fa fa-list-alt " aria-hidden="true"></i> <span -->
<!-- 							aria-hidden="true"></span>Sin Pendientes -->
<!-- 					</button> -->


<!-- 					<select name="singleSelect" id="singleSelect" ng-model="data.singleSelect"> -->
<!-- 									<option value="1">1.- Reporte Pendientes</option> -->
<!-- 									<option value="2">2.- Reporte de Todo</option> -->
<!-- 								</select>  -->
					
<!-- 					<button  ng-click="downloadRMPending()" type="button" class="btn btn-primary"> -->

<!-- 						<i class="fa fa-list-alt " aria-hidden="true"></i> <span -->
<!-- 							aria-hidden="true"></span>Descargar Reporte -->
<!-- 					</button> -->

<!-- 						<li class="dropdown"><a href="#" class="dropdown-toggle" -->
<!-- 							data-toggle="dropdown" role="button" aria-haspopup="true" -->
<!-- 							aria-expanded="false"> <i class="fa fa-download  fa-2x"></i></a> -->
<!-- 							<ul class="dropdown-menu dropdown-menu-left"> -->
<!-- 								<li><a href="#" ng-click="downloadStaticXLSFile()">Reporte -->
<!-- 										de Pendientes</a></li> -->
<!-- 								<li><a href="#" ng-click="getFormatoAcuseFCMAction()">Reporte -->
<!-- 										Completo</a></li> -->
<!-- 							</ul></li> -->

<!-- 						<div class="btn-group"> -->

<!-- 							<div class="dropdown"> -->
<!-- 								<button class="btn btn-default dropdown-toggle" type="button" -->
<!-- 									id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" -->
<!-- 									aria-expanded="true"> -->
<!-- 									<i class="fa fa-eye  fa-2x"></i> -->
<!-- 								</button> -->
<!-- 								<ul class="dropdown-menu" aria-labelledby="dropdownMenu1"> -->
<!-- 									<li><a ng-click="getRMPending()" href="#">Visualizar reporte de pendientes</a></li> -->
<!-- 									<li><a ng-click="getRM()" href="#">Visualizar reporte completo</a></li> -->
<!-- 								</ul> -->
<!-- 							</div> -->

<!-- 						</div> -->

<!-- 						<div class="btn-group"> -->

<!-- 							<div class="dropdown"> -->
<!-- 								<button class="btn btn-default dropdown-toggle" type="button" -->
<!-- 									id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" -->
<!-- 									aria-expanded="true"> -->
<!-- 									<i class="fa fa-download  fa-2x"></i> -->
<!-- 								</button> -->
<!-- 								<ul class="dropdown-menu" aria-labelledby="dropdownMenu1"> -->
<!-- 									<li><a href="#">Descargar reporte de pendientes</a></li> -->
<!-- 									<li><a href="#">Descargar reporte completo</a></li> -->
<!-- 								</ul> -->
<!-- 							</div> -->

<!-- 						</div> -->


						<!-- 						<button type="button" class="btn btn-primary" -->
<!-- 						ui-sref="home"> -->

<!-- 						<i class="fa fa-list-alt " aria-hidden="true"></i> <span -->
<!-- 							aria-hidden="true"></span>Salir -->
<!-- 					</button> -->
					
					
				</div>
				
				</div>
			</div>

			<div class="panel-body back-sivale">
			
				<div data-ng-controller="getRMPending" ng-cloak>
					<table ng-table="tableRM" class="table">
						<tr ng-repeat="rms in $data">
							
							<td title="'Compañia'" header-class="'text-left'"
								sortable="'name'">{{rms.compania}}</td>
								
							<td title="'Unidad de Negocio'" header-class="'text-left'"
								sortable="'publishedDate'">{{rms.unidadDeNegocio}}</td>
								
							<td title="'Incentivo'" header-class="'text-left'"
								sortable="'nombreCampaign'">{{rms.campaignName}}</td>
								
<!-- 							<td title="'Participante'" header-class="'text-left'" -->
<!-- 								sortable="'participante'">{{rms.idStars}}</td> -->
								
<!-- 							<td title="'Nombre'" header-class="'text-left'" -->
<!-- 								sortable="'nombre'">{{rms.nombre}}</td> -->
								
<!-- 							<td title="'BID'" header-class="'text-left'" -->
<!-- 								sortable="'bid'">{{rms.bid}}</td>	 -->
							
							<td title="'Inicio de La Promoción'" header-class="'text-left'"
								sortable="'startDate'">{{rms.startDate | date:'dd/MM/yyyy'}}</td>
								
							<td title="'Fin de La Promoción'" header-class="'text-left'"
								sortable="'endDate'">{{rms.endDate | date:'dd/MM/yyyy'}}</td>
								
							<td title="'Movimientos'" header-class="'text-left'"
								sortable="'movements'">{{rms.movements}}</td>
								
							<td title="'Monto'" header-class="'text-left'"
								sortable="'monto'">{{rms.monto | currency}}</td>
								
							<td title="'Observaciones'" header-class="'text-left'"
								sortable="'monto'">{{rms.observaciones}}</td>
								
						</tr>
					</table>
				</div>
				
				<hr>
				
				<div class="navbar padding15">

					<div class="row">
					
						<div class="col-sm-2"></div>
						
						<div class="col-sm-2"></div>
						
						<div class="col-sm-2"></div>
					
						<div class="col-sm-2">
							<h5><strong>Total ganado: {{ganado | currency}}</strong></h5>
						</div>
						
						<div class="col-sm-2">
							<h5><strong>Total pagado: {{pagado | currency}}</strong></h5>
						</div>
						
						<div class="col-sm-2">
							<h5><strong>Pendiente: {{pendiente | currency}}</strong></h5>
						</div>
						
					</div>

				</div>
				
			</div>
			
		</div>
	</div>
	
	
	
</div>


<br><br><br>