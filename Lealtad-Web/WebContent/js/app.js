// ------ themes ----------
var CSS_DEFAULT		= 'sivale.css';
var LOGO_DEFAULT	= '';


//------ Filter ----------
var FILTER_INIT	= '';



var appres = angular.module('app', [ 'ngTable', 'ui.router', 'ngMessages', 'daterangepicker' ]);
appres.controller('campaignController', function($scope, $filter, $rootScope,
		$http, NgTableParams) { 
	    
	$scope.css  = CSS_DEFAULT;
	$scope.logo = LOGO_DEFAULT;
	
	$scope.filters = {
		myfilter : FILTER_INIT
	};
	
	$rootScope.date = {
			startDate: moment(),
			endDate: moment()
	};
    
	$scope.getCampaigns = function() {

		var data = escape(angular.toJson($scope.classification));
		console.log(JSON.stringify(data));

		$http({
			method : 'POST',
			url : 'getCampaignsAction',
			data : 'classificationCmp=' + data,
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(
				function(data, status, headers, config) {
					$scope.campaigns = data;
					console.log(JSON.stringify(data));
					
					$scope.tableCampaigns = new NgTableParams({
						count : 10
					}, {
						counts : [],
					    dataset: data
					});
					
//					$scope.tableCampaigns = new NgTableParams({
//						page : 1,
//						count : 10,
//						filter : $scope.filters,
//					}, {
//						total : $scope.campaigns.length,
//						counts : [],
//						getData : function($defer, params) {
//							var filteredData = params.filter() ? $filter(
//									'filter')($scope.campaigns,
//									params.filter().myfilter)
//									: $scope.campaigns;
//
//							var orderedData = params.sorting() ? $filter(
//									'orderBy')(filteredData, params.orderBy())
//									: $scope.campaigns;
//
//							$defer.resolve(orderedData.slice(
//									(params.page() - 1) * params.count(),
//									params.page() * params.count()));
//						}
//					});
//
//				}).error(function(data, status, headers, config) {

		});
	};

				
	$scope.getClassifications = function() {

		$http.get('getMyClassificationsAction').success(
			function(data, status, headers, config) {
				
				$scope.classifications = data;
				$scope.css = CSS_DEFAULT;
				$scope.logo = LOGO_DEFAULT;

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

	$scope.getAttachedFiles = function() {

		var data = escape(angular.toJson($scope.publication));

		$http({
			method : 'POST',
			url : 'showPublicationAction',
			data : 'publication=' + data,
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(
				function(data, status, headers, config) {
					$scope.attachedFiles = data.filesList;

					$scope.tableAttachedFiles = new NgTableParams({
						page : 1,
						count : 10,
						filter : $scope.filters,
					}, {
						total : $scope.attachedFiles.length,
						counts : [],
						getData : function($defer, params) {
							var filteredData = params.filter() ? $filter(
									'filter')($scope.attachedFiles,
									params.filter().myfilter)
									: $scope.attachedFiles;

							var orderedData = params.sorting() ? $filter(
									'orderBy')(filteredData, params.orderBy())
									: $scope.attachedFiles;

							$defer.resolve(orderedData.slice(
									(params.page() - 1) * params.count(),
									params.page() * params.count()));
						}
					});

					$(".publication-html").html(data.html);

				}).error(function(data, status, headers, config) {
		});
	};
	
	$scope.updateSession = function() {			
		$http.get('updateSessionAction').success(
				function(data, status, headers, config) {					 
					
					$scope.user = data.user;
					$scope.classification = data.classificationCmp;
					$scope.campaign = data.campaign;
					$scope.publication = data.publication;
					
					if($scope.classification){
						$scope.css = $scope.classification.catViews.colors;
						$scope.logo = 'img/company_logo/' + $scope.classification.catViews.logos + '/header.png';
					}
					console.log(JSON.stringify(data));
					
				}).error(function(data, status, headers, config) {
		});
	};
	
	$scope.logout = function() {		
		$http.get('logout').success(
				function(data, status, headers, config) {					 
					
				}).error(function(data, status, headers, config) {
		});
	};

	$scope.updateCampaign = function(campaign) {
		$scope.campaign = campaign;
	};

	$scope.updateClassification = function(classification) {
		$scope.classification = classification;
		$scope.css = $scope.classification.catViews.colors;
		$scope.logo = 'img/company_logo/' + $scope.classification.catViews.logos + '/header.png';
	};

	$scope.updatePublication = function(publication) {
		$scope.publication = publication;
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
	
	$scope.getLastTransactionByCard = function() {			
		$http.get('getLastTransactionByCardAction').success(
				function(data, status, headers, config) {		 
					$scope.lastTransactions = data;
					for ( var index in data) {
						var dateFormatTransaction = moment(data[index].transactionDate, "YYYYMMDD HHmmss");
						$scope.lastTransactions[index].transactionDate = dateFormatTransaction.format("DD/MM/YYYY hh:mm a");						
					}
					$scope.tableLastTransactions = new NgTableParams({            
				        count: 10
				    }, {
				        counts: [],
				        dataset: $scope.lastTransactions
				    });
					
				}).error(function(data, status, headers, config) {
		});
	};
	
	$scope.getBalance = function() {			
		$http.get('getBalanceAction').success(
				function(data, status, headers, config) {					 
					$scope.balance = (data);  					
				}).error(function(data, status, headers, config) {
		});
	};
	
	$scope.find = function() {			
		alert($scope.date.startDate);
	};
	
});

appres.config(function($stateProvider, $urlRouterProvider) {

	$urlRouterProvider.otherwise('/home');
	$stateProvider

	.state('home', {
		url : '/home',
		templateUrl : 'templates/classCampaign.html'
	})

	.state('campaigns', {
		url : '/campañas',
		templateUrl : 'templates/campaigns_user.html'
	})

	.state('campaign', {
		url : '/campaña',
		templateUrl : 'templates/campaignDetail_user.html'
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

angular.bootstrap(document, ['app']);