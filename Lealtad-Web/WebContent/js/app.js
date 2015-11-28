
var appres = angular.module('app', ['ngTable', 'ui.router']); 
appres.controller('campaignController', function($scope, $filter, $rootScope, $http, NgTableParams){	
	
	$scope.filters = {
            myfilter: ''
        };
	
	$scope.getCampaigns = function() {		
		

		$http.get('getCampaignsAction').success(
				function(data, status, headers, config) {		 
					$scope.campaigns = data;
				
					//$scope.tableLastTransactions = new NgTableParams({}, { dataset: data});
					
				
					$scope.tableCampaigns = new NgTableParams({
				        page: 1,            
				        count: 10,
				        filter: $scope.filters,
				    }, {
				        total: $scope.campaigns.length,
				        counts: [],
				        getData: function($defer, params) {
				        	var filteredData = params.filter() ?
                                    $filter('filter')($scope.campaigns, params.filter().myfilter) :
                                    	$scope.campaigns;
                                    
		                    var orderedData = params.sorting() ?
		                                        $filter('orderBy')(filteredData, params.orderBy()) : 
		                                        	$scope.campaigns;
				        	
				            $defer.resolve(orderedData.slice((params.page() - 1) * params.count(), params.page() * params.count()));
				        }
				    });
					
				}).error(function(data, status, headers, config) {
					
		});
	};
	
	
	$scope.getCampaign = function() {	
		
		var data = escape(angular.toJson($scope.campaign));
		console.log(JSON.stringify(data));
		
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
	
	
	$scope.updateCampaign = function(campaign) {
		$scope.campaign = campaign;
		
		//$http.get('saveSessionAction?campaignId='+$scope.campaign.campaignId).success
		//(function(data, status, headers, config){});

	};
	
});

appres.config(function($stateProvider, $urlRouterProvider) {
    
    $urlRouterProvider.otherwise('/home');
    
    $stateProvider
        
        // HOME STATES AND NESTED VIEWS ========================================
        .state('home', {
            url: '/home',
            templateUrl: 'templates/campaigns_user.html'
        })
        
		.state('campaign', {
            url: '/campaña',
            templateUrl: 'templates/campaignDetail_user.html'
        })
        
});