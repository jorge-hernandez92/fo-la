var appres = angular.module('app', [ 'ngTable', 'ui.router' ]);
appres.controller('campaignController', function($scope, $filter, $rootScope,
		$http, NgTableParams) {

	$scope.css = 'sivale.css';
	$scope.logo = '';
	
	$scope.filters = {
		myfilter : ''
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

					$scope.tableCampaigns = new NgTableParams({
						page : 1,
						count : 10,
						filter : $scope.filters,
					}, {
						total : $scope.campaigns.length,
						counts : [],
						getData : function($defer, params) {
							var filteredData = params.filter() ? $filter(
									'filter')($scope.campaigns,
									params.filter().myfilter)
									: $scope.campaigns;

							var orderedData = params.sorting() ? $filter(
									'orderBy')(filteredData, params.orderBy())
									: $scope.campaigns;

							$defer.resolve(orderedData.slice(
									(params.page() - 1) * params.count(),
									params.page() * params.count()));
						}
					});

				}).error(function(data, status, headers, config) {

		});
	};

				
	$scope.getClassifications = function() {

		$http.get('getMyClassificationsAction').success(
			function(data, status, headers, config) {
				
				$scope.classifications = data;
				$scope.css = 'sivale.css';
				$scope.logo = '';
				
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
						$scope.logo = $scope.classification.catViews.logos;
					}
					console.log(JSON.stringify(data));
					
				}).error(function(data, status, headers, config) {
		});
	};
	
	$scope.logout = function() {		
		console.log('into logout function js');
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
		$scope.logo = $scope.classification.catViews.logos;
	};

	$scope.updatePublication = function(publication) {
		$scope.publication = publication;
	};

	$scope.formatDate = function(date) {
//		var f_date = new Date(date);
//		return f_date;
		var d = new Date(date || Date.now()),
        month = '' + (d.getMonth() + 1),
        day = '' + d.getDate(),
        year = d.getFullYear();

    if (month.length < 2) month = '0' + month;
    if (day.length < 2) day = '0' + day;

    return [month, day, year].join(' / ');
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
});