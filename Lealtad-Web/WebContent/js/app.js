
var appres = angular.module('app', ['ngTable', 'ui.router']); 
appres.controller('campaingController', function($scope, $filter, $rootScope, $http, NgTableParams){	
	
	$scope.filters = {
            myfilter: ''
        };
	
	$scope.getCampaings = function() {			
		$http.get('getCampaingsAction').success(
				function(data, status, headers, config) {		 
					$scope.campaings = data;
				
					//$scope.tableLastTransactions = new NgTableParams({}, { dataset: data});
					
				
					$scope.tableCampaings = new NgTableParams({
				        page: 1,            
				        count: 10,
				        filter: $scope.filters,
				    }, {
				        total: $scope.campaings.length,
				        counts: [],
				        getData: function($defer, params) {
				        	var filteredData = params.filter() ?
                                    $filter('filter')($scope.campaings, params.filter().myfilter) :
                                    	$scope.campaings;
                                    
		                    var orderedData = params.sorting() ?
		                                        $filter('orderBy')(filteredData, params.orderBy()) : 
		                                        	$scope.campaings;
				        	
				            $defer.resolve(orderedData.slice((params.page() - 1) * params.count(), params.page() * params.count()));
				        }
				    });
					
				}).error(function(data, status, headers, config) {
					
		});
	};
	
	
	$scope.getCampaing = function() {			
		$http.get('getPubliationsAction').success(
				function(data, status, headers, config) {		 
					$scope.publications = data;
				
					$scope.tablePublications = new NgTableParams({
				        page: 1,            
				        count: 10,
				        filter: $scope.filters,
				    }, {
				        total: $scope.publications.length,
				        counts: [],
				        getData: function($defer, params) {
				        	var filteredData = params.filter() ?
                                    $filter('filter')($scope.publications, params.filter().myfilter) :
                                    	$scope.publications;
                                    
		                    var orderedData = params.sorting() ?
		                                        $filter('orderBy')(filteredData, params.orderBy()) : 
		                                        	$scope.publications;
				        	
				            $defer.resolve(orderedData.slice((params.page() - 1) * params.count(), params.page() * params.count()));
				        }
				    });
					
				}).error(function(data, status, headers, config) {
					
		});
	};
});









appres.config(function($stateProvider, $urlRouterProvider) {
    
    $urlRouterProvider.otherwise('/home');
    
    $stateProvider
        
        // HOME STATES AND NESTED VIEWS ========================================
        .state('home', {
            url: '/home',
            templateUrl: 'templates/campaings_user.html'
        })
        
		.state('campaing', {
            url: '/campaña',
            templateUrl: 'templates/campaingDetail_user.html'
        })
        
});