<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<div class="panel-body ">

	<div class="container">
		<h1 class="text-center">
			<font color="white">Campañas Recientes</font>
		</h1>
	</div>
	
	<div class="navbar container">

		<div class="navbar-form navbar-left padding-cero" role="search">
			<div class="form-group">
				<input type="text" class="form-control" placeholder="Nombre" ng-model="search.campaignName">
				<input type="text" class="form-control" placeholder="Clasificación" ng-model="search.classification">
				<input date-range-picker="" id="daterange1" name="daterange1" class="form-control date-picker ng-pristine ng-valid ng-isolate-scope ng-valid-required ng-touched" type="text" ng-model="date" required="">
				<button class="btn btn-primary" ng-click="searchCampaigns(date)">Buscar</button>
				<button type="button" class="btn btn-primary " ui-sref="newCampaign" ng-click="cleanSelect()">
  							<span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span> Añadir Campaña
						</button>
			</div>
		</div>
		<div class="daterangepicker dropdown-menu show-calendar opensright" style="top: 130px; left: 89.5px; right: auto; display: none;"><div class="calendar left"><div class="daterangepicker_input"><input class="input-mini active" type="text" name="daterangepicker_start" value=""><i class="fa fa-calendar glyphicon glyphicon-calendar"></i><div class="calendar-time" style="display: none;"><div></div><i class="fa fa-clock-o glyphicon glyphicon-time"></i></div></div><div class="calendar-table"><table class="table-condensed"><thead><tr><th class="prev available"><i class="fa fa-chevron-left glyphicon glyphicon-chevron-left"></i></th><th colspan="5" class="month">Dec 2015</th><th></th></tr><tr><th>Su</th><th>Mo</th><th>Tu</th><th>We</th><th>Th</th><th>Fr</th><th>Sa</th></tr></thead><tbody><tr><td class="weekend off available" data-title="r0c0">29</td><td class="off available" data-title="r0c1">30</td><td class="available" data-title="r0c2">1</td><td class="available" data-title="r0c3">2</td><td class="available" data-title="r0c4">3</td><td class="available" data-title="r0c5">4</td><td class="weekend available" data-title="r0c6">5</td></tr><tr><td class="weekend available" data-title="r1c0">6</td><td class="available" data-title="r1c1">7</td><td class="available" data-title="r1c2">8</td><td class="available" data-title="r1c3">9</td><td class="available" data-title="r1c4">10</td><td class="available" data-title="r1c5">11</td><td class="weekend available" data-title="r1c6">12</td></tr><tr><td class="weekend available" data-title="r2c0">13</td><td class="available" data-title="r2c1">14</td><td class="available" data-title="r2c2">15</td><td class="available" data-title="r2c3">16</td><td class="today available" data-title="r2c4">17</td><td class="available" data-title="r2c5">18</td><td class="weekend available" data-title="r2c6">19</td></tr><tr><td class="weekend available" data-title="r3c0">20</td><td class="available" data-title="r3c1">21</td><td class="active start-date available" data-title="r3c2">22</td><td class="in-range available" data-title="r3c3">23</td><td class="in-range available" data-title="r3c4">24</td><td class="in-range available" data-title="r3c5">25</td><td class="weekend in-range available" data-title="r3c6">26</td></tr><tr><td class="weekend in-range available" data-title="r4c0">27</td><td class="in-range available" data-title="r4c1">28</td><td class="in-range available" data-title="r4c2">29</td><td class="in-range available" data-title="r4c3">30</td><td class="in-range available" data-title="r4c4">31</td><td class="off in-range available" data-title="r4c5">1</td><td class="weekend off in-range available" data-title="r4c6">2</td></tr><tr><td class="weekend off in-range available" data-title="r5c0">3</td><td class="off in-range available" data-title="r5c1">4</td><td class="off in-range available" data-title="r5c2">5</td><td class="off in-range available" data-title="r5c3">6</td><td class="off in-range available" data-title="r5c4">7</td><td class="off in-range available" data-title="r5c5">8</td><td class="weekend off in-range available" data-title="r5c6">9</td></tr></tbody></table></div></div><div class="calendar right"><div class="daterangepicker_input"><input class="input-mini" type="text" name="daterangepicker_end" value=""><i class="fa fa-calendar glyphicon glyphicon-calendar"></i><div class="calendar-time" style="display: none;"><div></div><i class="fa fa-clock-o glyphicon glyphicon-time"></i></div></div><div class="calendar-table"><table class="table-condensed"><thead><tr><th></th><th colspan="5" class="month">Jan 2016</th><th class="next available"><i class="fa fa-chevron-right glyphicon glyphicon-chevron-right"></i></th></tr><tr><th>Su</th><th>Mo</th><th>Tu</th><th>We</th><th>Th</th><th>Fr</th><th>Sa</th></tr></thead><tbody><tr><td class="weekend off in-range available" data-title="r0c0">27</td><td class="off in-range available" data-title="r0c1">28</td><td class="off in-range available" data-title="r0c2">29</td><td class="off in-range available" data-title="r0c3">30</td><td class="off in-range available" data-title="r0c4">31</td><td class="in-range available" data-title="r0c5">1</td><td class="weekend in-range available" data-title="r0c6">2</td></tr><tr><td class="weekend in-range available" data-title="r1c0">3</td><td class="in-range available" data-title="r1c1">4</td><td class="in-range available" data-title="r1c2">5</td><td class="in-range available" data-title="r1c3">6</td><td class="in-range available" data-title="r1c4">7</td><td class="in-range available" data-title="r1c5">8</td><td class="weekend in-range available" data-title="r1c6">9</td></tr><tr><td class="weekend in-range available" data-title="r2c0">10</td><td class="in-range available" data-title="r2c1">11</td><td class="in-range available" data-title="r2c2">12</td><td class="in-range available" data-title="r2c3">13</td><td class="in-range available" data-title="r2c4">14</td><td class="in-range available" data-title="r2c5">15</td><td class="weekend in-range available" data-title="r2c6">16</td></tr><tr><td class="weekend in-range available" data-title="r3c0">17</td><td class="in-range available" data-title="r3c1">18</td><td class="in-range available" data-title="r3c2">19</td><td class="in-range available" data-title="r3c3">20</td><td class="in-range available" data-title="r3c4">21</td><td class="in-range available" data-title="r3c5">22</td><td class="weekend in-range available" data-title="r3c6">23</td></tr><tr><td class="weekend in-range available" data-title="r4c0">24</td><td class="in-range available" data-title="r4c1">25</td><td class="in-range available" data-title="r4c2">26</td><td class="in-range available" data-title="r4c3">27</td><td class="active end-date in-range available" data-title="r4c4">28</td><td class="available" data-title="r4c5">29</td><td class="weekend available" data-title="r4c6">30</td></tr><tr><td class="weekend available" data-title="r5c0">31</td><td class="off available" data-title="r5c1">1</td><td class="off available" data-title="r5c2">2</td><td class="off available" data-title="r5c3">3</td><td class="off available" data-title="r5c4">4</td><td class="off available" data-title="r5c5">5</td><td class="weekend off available" data-title="r5c6">6</td></tr></tbody></table></div></div><div class="ranges"><div class="range_inputs"><button class="applyBtn btn btn-sm btn-success" type="button" ng-click="find()">Apply</button> <button class="cancelBtn btn btn-sm btn-default" type="button">Cancel</button></div></div></div><div class="daterangepicker dropdown-menu show-calendar opensright" style="top: 206px; left: 89.5px; right: auto; display: none;"><div class="calendar left"><div class="daterangepicker_input"><input class="input-mini active" type="text" name="daterangepicker_start" value=""><i class="fa fa-calendar glyphicon glyphicon-calendar"></i><div class="calendar-time" style="display: none;"><div></div><i class="fa fa-clock-o glyphicon glyphicon-time"></i></div></div><div class="calendar-table"><table class="table-condensed"><thead><tr><th class="prev available"><i class="fa fa-chevron-left glyphicon glyphicon-chevron-left"></i></th><th colspan="5" class="month">Aug 2015</th><th></th></tr><tr><th>Su</th><th>Mo</th><th>Tu</th><th>We</th><th>Th</th><th>Fr</th><th>Sa</th></tr></thead><tbody><tr><td class="weekend off available" data-title="r0c0">26</td><td class="off available" data-title="r0c1">27</td><td class="off available" data-title="r0c2">28</td><td class="off available" data-title="r0c3">29</td><td class="off available" data-title="r0c4">30</td><td class="off available" data-title="r0c5">31</td><td class="weekend available" data-title="r0c6">1</td></tr><tr><td class="weekend available" data-title="r1c0">2</td><td class="available" data-title="r1c1">3</td><td class="available" data-title="r1c2">4</td><td class="available" data-title="r1c3">5</td><td class="available" data-title="r1c4">6</td><td class="available" data-title="r1c5">7</td><td class="weekend available" data-title="r1c6">8</td></tr><tr><td class="weekend available" data-title="r2c0">9</td><td class="available" data-title="r2c1">10</td><td class="available" data-title="r2c2">11</td><td class="available" data-title="r2c3">12</td><td class="available" data-title="r2c4">13</td><td class="available" data-title="r2c5">14</td><td class="weekend available" data-title="r2c6">15</td></tr><tr><td class="weekend available" data-title="r3c0">16</td><td class="available" data-title="r3c1">17</td><td class="available" data-title="r3c2">18</td><td class="available" data-title="r3c3">19</td><td class="available" data-title="r3c4">20</td><td class="available" data-title="r3c5">21</td><td class="weekend available" data-title="r3c6">22</td></tr><tr><td class="weekend available" data-title="r4c0">23</td><td class="available" data-title="r4c1">24</td><td class="active start-date active end-date available" data-title="r4c2">25</td><td class="off disabled" data-title="r4c3">26</td><td class="off disabled" data-title="r4c4">27</td><td class="off disabled" data-title="r4c5">28</td><td class="weekend off disabled" data-title="r4c6">29</td></tr><tr><td class="weekend off disabled" data-title="r5c0">30</td><td class="off disabled" data-title="r5c1">31</td><td class="off off disabled" data-title="r5c2">1</td><td class="off off disabled" data-title="r5c3">2</td><td class="off off disabled" data-title="r5c4">3</td><td class="off off disabled" data-title="r5c5">4</td><td class="weekend off off disabled" data-title="r5c6">5</td></tr></tbody></table></div></div><div class="calendar right"><div class="daterangepicker_input"><input class="input-mini" type="text" name="daterangepicker_end" value=""><i class="fa fa-calendar glyphicon glyphicon-calendar"></i><div class="calendar-time" style="display: none;"><div></div><i class="fa fa-clock-o glyphicon glyphicon-time"></i></div></div><div class="calendar-table"><table class="table-condensed"><thead><tr><th></th><th colspan="5" class="month">Sep 2015</th><th></th></tr><tr><th>Su</th><th>Mo</th><th>Tu</th><th>We</th><th>Th</th><th>Fr</th><th>Sa</th></tr></thead><tbody><tr><td class="weekend off off disabled" data-title="r0c0">30</td><td class="off off disabled" data-title="r0c1">31</td><td class="off disabled" data-title="r0c2">1</td><td class="off disabled" data-title="r0c3">2</td><td class="off disabled" data-title="r0c4">3</td><td class="off disabled" data-title="r0c5">4</td><td class="weekend off disabled" data-title="r0c6">5</td></tr><tr><td class="weekend off disabled" data-title="r1c0">6</td><td class="off disabled" data-title="r1c1">7</td><td class="off disabled" data-title="r1c2">8</td><td class="off disabled" data-title="r1c3">9</td><td class="off disabled" data-title="r1c4">10</td><td class="off disabled" data-title="r1c5">11</td><td class="weekend off disabled" data-title="r1c6">12</td></tr><tr><td class="weekend off disabled" data-title="r2c0">13</td><td class="off disabled" data-title="r2c1">14</td><td class="off disabled" data-title="r2c2">15</td><td class="off disabled" data-title="r2c3">16</td><td class="off disabled" data-title="r2c4">17</td><td class="off disabled" data-title="r2c5">18</td><td class="weekend off disabled" data-title="r2c6">19</td></tr><tr><td class="weekend off disabled" data-title="r3c0">20</td><td class="off disabled" data-title="r3c1">21</td><td class="off disabled" data-title="r3c2">22</td><td class="off disabled" data-title="r3c3">23</td><td class="off disabled" data-title="r3c4">24</td><td class="off disabled" data-title="r3c5">25</td><td class="weekend off disabled" data-title="r3c6">26</td></tr><tr><td class="weekend off disabled" data-title="r4c0">27</td><td class="off disabled" data-title="r4c1">28</td><td class="off disabled" data-title="r4c2">29</td><td class="off disabled" data-title="r4c3">30</td><td class="off off disabled" data-title="r4c4">1</td><td class="off off disabled" data-title="r4c5">2</td><td class="weekend off off disabled" data-title="r4c6">3</td></tr><tr><td class="weekend off off disabled" data-title="r5c0">4</td><td class="off off disabled" data-title="r5c1">5</td><td class="off off disabled" data-title="r5c2">6</td><td class="off off disabled" data-title="r5c3">7</td><td class="off off disabled" data-title="r5c4">8</td><td class="off off disabled" data-title="r5c5">9</td><td class="weekend off off disabled" data-title="r5c6">10</td></tr></tbody></table></div></div><div class="ranges"><div class="range_inputs"><button class="applyBtn btn btn-sm btn-success" type="button">Apply</button> <button class="cancelBtn btn btn-sm btn-default" type="button">Cancel</button></div></div></div><div class="daterangepicker dropdown-menu show-calendar opensright"><div class="calendar left"><div class="daterangepicker_input"><input class="input-mini" type="text" name="daterangepicker_start" value=""><i class="fa fa-calendar glyphicon glyphicon-calendar"></i><div class="calendar-time" style="display: none;"><div></div><i class="fa fa-clock-o glyphicon glyphicon-time"></i></div></div><div class="calendar-table"></div></div><div class="calendar right"><div class="daterangepicker_input"><input class="input-mini" type="text" name="daterangepicker_end" value=""><i class="fa fa-calendar glyphicon glyphicon-calendar"></i><div class="calendar-time" style="display: none;"><div></div><i class="fa fa-clock-o glyphicon glyphicon-time"></i></div></div><div class="calendar-table"></div></div><div class="ranges"><div class="range_inputs"><button class="applyBtn btn btn-sm btn-success" disabled="disabled" type="button">Apply</button> <button class="cancelBtn btn btn-sm btn-default" type="button">Clear</button></div></div></div><div class="daterangepicker dropdown-menu show-calendar opensright"><div class="calendar left"><div class="daterangepicker_input"><input class="input-mini" type="text" name="daterangepicker_start" value=""><i class="fa fa-calendar glyphicon glyphicon-calendar"></i><div class="calendar-time" style="display: none;"><div></div><i class="fa fa-clock-o glyphicon glyphicon-time"></i></div></div><div class="calendar-table"></div></div><div class="calendar right"><div class="daterangepicker_input"><input class="input-mini" type="text" name="daterangepicker_end" value=""><i class="fa fa-calendar glyphicon glyphicon-calendar"></i><div class="calendar-time" style="display: none;"><div></div><i class="fa fa-clock-o glyphicon glyphicon-time"></i></div></div><div class="calendar-table"></div></div><div class="ranges"><div class="range_inputs"><button class="applyBtn btn btn-sm btn-success" disabled="disabled" type="button">Apply</button> <button class="cancelBtn btn btn-sm btn-default" type="button">Clear</button></div></div></div><div class="daterangepicker dropdown-menu single opensright"><div class="calendar left single" style="display: block;"><div class="daterangepicker_input"><input class="input-mini" type="text" name="daterangepicker_start" value="" style="display: none;"><i class="fa fa-calendar glyphicon glyphicon-calendar" style="display: none;"></i><div class="calendar-time" style="display: none;"><div></div><i class="fa fa-clock-o glyphicon glyphicon-time" style="display: none;"></i></div></div><div class="calendar-table"></div></div><div class="calendar right" style="display: none;"><div class="daterangepicker_input"><input class="input-mini" type="text" name="daterangepicker_end" value="" style="display: none;"><i class="fa fa-calendar glyphicon glyphicon-calendar" style="display: none;"></i><div class="calendar-time" style="display: none;"><div></div><i class="fa fa-clock-o glyphicon glyphicon-time" style="display: none;"></i></div></div><div class="calendar-table"></div></div><div class="ranges" style="display: none;"><div class="range_inputs"><button class="applyBtn btn btn-sm btn-success" disabled="disabled" type="button">Apply</button> <button class="cancelBtn btn btn-sm btn-default" type="button">Clear</button></div></div></div><div class="daterangepicker dropdown-menu opensright show-calendar" style="top: 292px; left: 89.5px; right: auto; display: none;"><div class="ranges"><ul><li>Last 7 Days</li><li>Last 30 Days</li><li class="active">Custom range</li></ul><div class="range_inputs"><button class="applyBtn btn btn-sm btn-success" type="button">Apply</button> <button class="cancelBtn btn btn-sm btn-default" type="button">Cancel</button></div></div><div class="calendar left"><div class="daterangepicker_input"><input class="input-mini active" type="text" name="daterangepicker_start" value=""><i class="fa fa-calendar glyphicon glyphicon-calendar"></i><div class="calendar-time" style="display: none;"><div></div><i class="fa fa-clock-o glyphicon glyphicon-time"></i></div></div><div class="calendar-table"><table class="table-condensed"><thead><tr><th class="prev available"><i class="fa fa-chevron-left glyphicon glyphicon-chevron-left"></i></th><th colspan="5" class="month">Dec 2015</th><th></th></tr><tr><th>Su</th><th>Mo</th><th>Tu</th><th>We</th><th>Th</th><th>Fr</th><th>Sa</th></tr></thead><tbody><tr><td class="weekend off available" data-title="r0c0">29</td><td class="off available" data-title="r0c1">30</td><td class="available" data-title="r0c2">1</td><td class="available" data-title="r0c3">2</td><td class="available" data-title="r0c4">3</td><td class="available" data-title="r0c5">4</td><td class="weekend available" data-title="r0c6">5</td></tr><tr><td class="weekend available" data-title="r1c0">6</td><td class="available" data-title="r1c1">7</td><td class="available" data-title="r1c2">8</td><td class="available" data-title="r1c3">9</td><td class="available" data-title="r1c4">10</td><td class="available" data-title="r1c5">11</td><td class="weekend available" data-title="r1c6">12</td></tr><tr><td class="weekend available" data-title="r2c0">13</td><td class="available" data-title="r2c1">14</td><td class="available" data-title="r2c2">15</td><td class="active start-date available" data-title="r2c3">16</td><td class="today active end-date in-range available" data-title="r2c4">17</td><td class="available" data-title="r2c5">18</td><td class="weekend available" data-title="r2c6">19</td></tr><tr><td class="weekend available" data-title="r3c0">20</td><td class="available" data-title="r3c1">21</td><td class="available" data-title="r3c2">22</td><td class="available" data-title="r3c3">23</td><td class="available" data-title="r3c4">24</td><td class="available" data-title="r3c5">25</td><td class="weekend available" data-title="r3c6">26</td></tr><tr><td class="weekend available" data-title="r4c0">27</td><td class="available" data-title="r4c1">28</td><td class="available" data-title="r4c2">29</td><td class="available" data-title="r4c3">30</td><td class="available" data-title="r4c4">31</td><td class="off available" data-title="r4c5">1</td><td class="weekend off available" data-title="r4c6">2</td></tr><tr><td class="weekend off available" data-title="r5c0">3</td><td class="off available" data-title="r5c1">4</td><td class="off available" data-title="r5c2">5</td><td class="off available" data-title="r5c3">6</td><td class="off available" data-title="r5c4">7</td><td class="off available" data-title="r5c5">8</td><td class="weekend off available" data-title="r5c6">9</td></tr></tbody></table></div></div><div class="calendar right"><div class="daterangepicker_input"><input class="input-mini" type="text" name="daterangepicker_end" value=""><i class="fa fa-calendar glyphicon glyphicon-calendar"></i><div class="calendar-time" style="display: none;"><div></div><i class="fa fa-clock-o glyphicon glyphicon-time"></i></div></div><div class="calendar-table"><table class="table-condensed"><thead><tr><th></th><th colspan="5" class="month">Jan 2016</th><th class="next available"><i class="fa fa-chevron-right glyphicon glyphicon-chevron-right"></i></th></tr><tr><th>Su</th><th>Mo</th><th>Tu</th><th>We</th><th>Th</th><th>Fr</th><th>Sa</th></tr></thead><tbody><tr><td class="weekend off available" data-title="r0c0">27</td><td class="off available" data-title="r0c1">28</td><td class="off available" data-title="r0c2">29</td><td class="off available" data-title="r0c3">30</td><td class="off available" data-title="r0c4">31</td><td class="available" data-title="r0c5">1</td><td class="weekend available" data-title="r0c6">2</td></tr><tr><td class="weekend available" data-title="r1c0">3</td><td class="available" data-title="r1c1">4</td><td class="available" data-title="r1c2">5</td><td class="available" data-title="r1c3">6</td><td class="available" data-title="r1c4">7</td><td class="available" data-title="r1c5">8</td><td class="weekend available" data-title="r1c6">9</td></tr><tr><td class="weekend available" data-title="r2c0">10</td><td class="available" data-title="r2c1">11</td><td class="available" data-title="r2c2">12</td><td class="available" data-title="r2c3">13</td><td class="available" data-title="r2c4">14</td><td class="available" data-title="r2c5">15</td><td class="weekend available" data-title="r2c6">16</td></tr><tr><td class="weekend available" data-title="r3c0">17</td><td class="available" data-title="r3c1">18</td><td class="available" data-title="r3c2">19</td><td class="available" data-title="r3c3">20</td><td class="available" data-title="r3c4">21</td><td class="available" data-title="r3c5">22</td><td class="weekend available" data-title="r3c6">23</td></tr><tr><td class="weekend available" data-title="r4c0">24</td><td class="available" data-title="r4c1">25</td><td class="available" data-title="r4c2">26</td><td class="available" data-title="r4c3">27</td><td class="available" data-title="r4c4">28</td><td class="available" data-title="r4c5">29</td><td class="weekend available" data-title="r4c6">30</td></tr><tr><td class="weekend available" data-title="r5c0">31</td><td class="off available" data-title="r5c1">1</td><td class="off available" data-title="r5c2">2</td><td class="off available" data-title="r5c3">3</td><td class="off available" data-title="r5c4">4</td><td class="off available" data-title="r5c5">5</td><td class="weekend off available" data-title="r5c6">6</td></tr></tbody></table></div></div></div>
	</div>
	
<!-- 	<div class="container" data-ng-controller="getCampaignsAdmin" ng-cloak> -->
<!-- 		<div class="jumbotron" -->
<!-- 			style="background-color: rgba(220, 220, 220, 0.35);" -->
<!-- 			data-ng-controller="getCampaignsAdmin" ng-cloak> -->
<!-- 			<div class="row"> -->
<!-- 				<div class="col-sm-6 col-md-3" -->
<!-- 					ng-repeat="campaign in campaigns | filter:search:strict "> -->
<!-- 					<div class="grid" data-toggle="tooltip" data-placement="left" -->
<!-- 						title="{{campaign.classification}}"> -->
<!-- 						<figure class="effect-ming"> -->
<!-- 							<img ng-src="img/img_camp/{{campaign.indexImage2}}cam.jpg" alt="" /> -->
<!-- 							<figcaption> -->
<!-- 								<h5>{{campaign.campaignName}}</h5> -->
<!-- 								<p>{{campaign.classification[0]}}</p> -->
<!-- 								<p>{{campaign.startDate | date:'dd/MM/yyyy'}} - -->
<!-- 									{{campaign.endDate | date:'dd/MM/yyyy'}}</p> -->
<!-- 								<a href="#" data-ng-click="updateCampaign(campaign)" -->
<!-- 									ui-sref="campaign">View more</a> -->
<!-- 							</figcaption> -->
<!-- 						</figure> -->
<!-- 					</div> 	 -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</div> -->
	
	<div class="container" style="width: 1300px;" data-ng-controller="getCampaignsAdmin" ng-cloak>
			
			<ul class="caption-style-4" >
				
				<li ng-repeat="campaign in campaigns | filter:search:strict">
					<img ng-src="{{campaign.imageBase64}}" alt="">
					<div class="caption">
						<div class="blur"></div>
						<div class="caption-text">
							<h1>{{campaign.campaignName}}</h1>
							<p>{{campaign.classification[0]}}</p>
							<p>{{campaign.startDate | date:'dd/MM/yyyy'}} -
									{{campaign.endDate | date:'dd/MM/yyyy'}}</p>
							<br>
							<button href="#" data-ng-click="updateCampaign(campaign)"
									ui-sref="campaign" type="button" class="btn btn-campaign">DETALLES</button>
						</div>
					</div>
				</li>
				
			</ul>
			
		</div>

		<br><br>
	
	<div class="container  font-color-text">

		<div class="row">

			<div class="col-xs-6 col-md-2"></div>
			<div class="col-xs-6 col-md-8">
					
			<div class="panel-group" id="accordion" role="tablist"
			aria-multiselectable="true">
			<div class="panel panel-infoP">
				<div class="panel-heading" role="tab" id="headingOne">
					<h4 class="panel-title">
						<a role="button" data-toggle="collapse" data-parent="#accordion"
							href="#collapseOne" aria-expanded="false"
							aria-controls="collapseOne"> 
								<div class="text-center">
							<h4>¿DUDAS SOBRE EL PROGRAMA DE INCENTIVOS?</h4>
						</div>
							</a>
					</h4>
				</div>
				<div id="collapseOne" class="panel-collapse collapse"
					role="tabpanel" aria-labelledby="headingOne">
					<div class="panel-body">
						<div class="text-center">
							<h4>
								<font color="black"> Llámanos </font><br> 01 (55) 5814
								9396<br> de 9 a 18 hrs., lunes a viernes
							</h4>
						</div>

						<div class="text-center">
							<h4>
								<font color="black"> O escríbenos </font><br>
										atnincentivos@sivale.com.mx
							</h4>
						</div>

					</div>
				</div>
			</div>
			<div class="panel panel-infoP">
				<div class="panel-heading" role="tab" id="headingTwo">
					<h4 class="panel-title">
						<a class="collapsed" role="button" data-toggle="collapse"
							data-parent="#accordion" href="#collapseTwo"
							aria-expanded="false" aria-controls="collapseTwo">
							<div class="text-center">
								<h4>¿DUDAS SOBRE LAS TARJETAS SÍVALE?</h4>
							</div> 
							
							</a>
					</h4>
				</div>
				<div id="collapseTwo" class="panel-collapse collapse"
					role="tabpanel" aria-labelledby="headingTwo">
					<div class="panel-body">

								<div class="text-center">
									<h4>
										<font color="black">Llama al servicio integral <br>
											para tarjetabientes
										</font><br> 01 (55) 5814 9396 <br> cualquier día de la
										semana <br> 24 horas al día
									</h4>
								</div>

								<div class="text-center">
									<h4>
										<font color="black"> O escribenos </font><br>
										sita@sivale.com.mx
									</h4>
								</div>
					</div>
				</div>
			</div>
		</div>
			</div>
			<div class="col-xs-6 col-md-2"></div>
		</div>

		<br>
		<br>		
		<br>		
		<br>
		<br>

	</div>
	
</div>
