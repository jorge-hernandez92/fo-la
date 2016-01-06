// ------ themes ----------
var CSS_DEFAULT		= 'sivale.css';
var LOGO_DEFAULT	= '';

var STRING_DEFAULT	= '';

var appres = angular.module('app', ['ngMessages', 'daterangepicker','ngTable', 'ui.router']);

appres.run(function($rootScope) {
	$rootScope.search = {
			campaignName: STRING_DEFAULT,
			classification: STRING_DEFAULT
	};
	
	$rootScope.classif = {
		classification2: STRING_DEFAULT
	};
	
})			

appres.controller('campaignAdminController', function($scope, $filter, $rootScope,
		$http, NgTableParams, $state) { 
	
	$scope.date = {
			startDate: moment(),
			endDate: moment()
	};
	
	$scope.newProgram = {
			name : ''
	};
	
	$scope.newSubProgram = {
			name : ''
	};
	
	$scope.newBusinessUnit = {
			name : ''
	};
	
	$scope.changeProgram = function(){
		
		
		if( $scope.selectProgram.selectedOption.name = 'Añadir nuevo' ){
			
			$scope.newProgram.name = '';
			
			$scope.selectSubProgram.availableOptions = 	[ {id: '-2', name: 'Ninguno'}, 
			                                           	  {id: '-1', name: 'Añadir nuevo'} ];
			$scope.selectSubProgram.selectedOption = {id: '-2', name: 'Ninguno'};
		
			$scope.selectBusinessUnit.availableOptions = [ {id: '-2', name: 'Ninguno'},
			                                               {id: '-1', name: 'Añadir nuevo'} ];
			$scope.selectBusinessUnit.selectedOption = {id: '-2', name: 'Ninguno'};
		}
	}
	
	$scope.changeSubProgram = function(){
		
		if( $scope.selectSubProgram.selectedOption.name = 'Añadir nuevo' ){
			$scope.newSubProgram.name = '';
			
			$scope.selectBusinessUnit.availableOptions = [ {id: '-2', name: 'Ninguno'},
			                                               {id: '-1', name: 'Añadir nuevo'} ];
			$scope.selectBusinessUnit.selectedOption = {id: '-2', name: 'Ninguno'};
		}
	}
	
	$scope.changeBusinessUnit = function(){
		$scope.newBusinessUnit.name = '';
	}
	
	$scope.selectCompany = {
		     availableOptions: [
		       {id: '100', name: 'Option A'},
		       {id: '26', name: 'Option B'},
		       {id: '38', name: 'Option C'}
		     ],
		     selectedOption: '' //This sets the default value of the select in the ui
	};
	
	$scope.show = function(){
		//alert($scope.selectCompany.selectedOption.name);
	};
	
	$scope.selectProgram = {
		     availableOptions: [
		       {id: '1', name: 'Option A'},
		       {id: '2', name: 'Option B'},
		       {id: '3', name: 'Option C'},
		       {id: '-1', name: 'Añadir nuevo'}
		     ],
		     selectedOption: '' //This sets the default value of the select in the ui
	};
	
	$scope.isEnabledProgram = function(){
		if($scope.selectCompany.selectedOption != '')
			return true;
		return false;
	};
	
	$scope.isNewProgram = function() {
		if($scope.selectProgram.selectedOption.name == 'Añadir nuevo')
			return true;
		return false;
	};
	
	$scope.selectSubProgram = {
		     availableOptions: [
		       {id: '1', name: 'Option A'},
		       {id: '2', name: 'Option B'},
		       {id: '3', name: 'Option C'},
		       {id: '-1', name: 'Añadir nuevo'}
		     ],
		     selectedOption: '' //This sets the default value of the select in the ui
	};
	
	$scope.isEnabledSubProgram = function(){
		if($scope.selectProgram.selectedOption != ''){
			if($scope.selectProgram.selectedOption.name == 'Añadir nuevo' && $scope.newProgram.name == '')
				return false;
			return true;
		}
		return false;
	};
	
	$scope.isNewSubProgram = function() {
		if($scope.selectSubProgram.selectedOption.name == 'Añadir nuevo')
			return true;
		return false;
	}
	
	$scope.selectBusinessUnit = {
		     availableOptions: [
		       {id: '1', name: 'Option A'},
		       {id: '2', name: 'Option B'},
		       {id: '3', name: 'Option C'},
		       {id: '-1', name: 'Añadir nuevo'}
		     ],
		     selectedOption: '' //This sets the default value of the select in the ui
	};
	
	$scope.isEnabledBusinessUnit = function(){
		if($scope.selectSubProgram.selectedOption != ''){
			if($scope.selectSubProgram.selectedOption.name == 'Añadir nuevo' && $scope.newSubProgram.name == '')
				return false;
			return true;
		}
		return false;
	};
	
	$scope.isNewBusinessUnit = function() {
		if($scope.selectBusinessUnit.selectedOption.name == 'Añadir nuevo')
			return true;
		return false;
	}
	
	$scope.getCampaignsAdmin = function() {
		
		$http.get('getCampaignsAdminAction').success(
				function(data, status, headers, config) {		 
					$scope.campaigns = data;
					
					$scope.tableCampaigns = new NgTableParams({
						count : 10
					}, {
						counts : [],
					    dataset: data
					});
					
				}).error(function(data, status, headers, config) {
		});
	};
	
	$scope.getCampaign = function() {

		var data = escape(angular.toJson($scope.campaign));

		$http({
			method : 'POST',
			url : 'getPublicationsAction',
			data : 'campaign=' + data,
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(
				function(data, status, headers, config) {
					$scope.publications = data;
					console.log(JSON.stringify(data));

					$scope.tablePublications = new NgTableParams({
						page : 1,
						count : 10,
						filter : $scope.filters,
					}, {
						total : $scope.publications.length,
						counts : [],
						getData : function($defer, params) {
							var filteredData = params.filter() ? $filter(
									'filter')($scope.publications,
									params.filter().myfilter)
									: $scope.publications;

							var orderedData = params.sorting() ? $filter(
									'orderBy')(filteredData, params.orderBy())
									: $scope.publications;

							$defer.resolve(orderedData.slice(
									(params.page() - 1) * params.count(),
									params.page() * params.count()));
						}
					});

				}).error(function(data, status, headers, config) {

		});
	};
	
	$scope.updateSession = function() {			
		$http.get('updateSessionAction').success(
				function(data, status, headers, config) {					 
					
					$scope.user = data.user;
					$scope.campaign = data.campaign;
					$scope.publication = data.publication;
					
					
				}).error(function(data, status, headers, config) {
		});
	};
	
	$scope.updateCampaign = function(campaign) {
		$scope.campaign = campaign;
	};
	
	$scope.formatDate = function(date) {
		var d = new Date(date || Date.now()),
        month = '' + (d.getMonth() + 1),
        day = '' + d.getDate(),
        year = d.getFullYear();

    if (month.length < 2) month = '0' + month;
    if (day.length < 2) day = '0' + day;

    return [month, day, year].join(' / ');
	};
	
	$scope.convertToPositive = function(amount){
		if(amount==undefined)
			return 0;
		if(amount<0)
			return amount*-1;
		return amount;
	};
	
});

appres.config(function($stateProvider, $urlRouterProvider) {

	$urlRouterProvider.otherwise('/home');
	$stateProvider

	.state('home', {
		url : '/home',
		templateUrl : 'templates/campaigns_admin.html'
	})

	.state('campaign', {
		url : '/campaña',
		templateUrl : 'templates/campaignDetail_admin.html'
	})

	.state('publication', {
		url : '/publicacion',
		templateUrl : 'templates/publication_user.html'
	})
	
	.state('transactions', {
		url : '/transacciones',
		templateUrl : 'templates/homeTh.html'
	})
});
