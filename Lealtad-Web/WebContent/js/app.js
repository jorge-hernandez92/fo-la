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

appres.controller('campaignController', function($scope, $filter, $rootScope,
		$http, NgTableParams, $state) { 
	    
	$scope.css  = CSS_DEFAULT;
	$scope.logo = LOGO_DEFAULT;
	
	$scope.date = {
			startDate: moment(),
			endDate: moment()
	};
	
	$scope.companyMenu = true;
	
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

				}).error(function(data, status, headers, config) {

		});
	};


	$scope.getFile = function(file) {
		$http.get('getFileAction?fileName='+file.fileName+'.'+file.fileExtension).success(
				function(data, status, headers, config) {

					$scope.downloadFile(file.fileName+'.'+file.fileExtension, data)
				
				}).error(function(data, status, headers, config) {
					
			});
	};
	
	$scope.getClassifications = function() {
		
		$http.get('getMyClassificationsAction').success(
			function(data, status, headers, config) {
				
				$scope.classifications = data;
				$scope.css = CSS_DEFAULT;
				$scope.logo = LOGO_DEFAULT;
				$scope.classification = STRING_DEFAULT;
				$scope.companyMenu = true;
				
				if(data.length == 1){
					$scope.updateClassification($scope.classifications[0]);
					$scope.companyMenu = false;
					$state.go('transactions');
				}
				
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
	
	$scope.isAdmin = function() {			
		
		console.log('User catProfile : ' + $scope.user.catProfile );
		if ($scope.user.catProfile == 0){
			return true;
		}
		return false;
		
	};
	
	$scope.searchCampaigns = function(date) {
	    
		var searchCampaign = {
				campaignName : $rootScope.search.campaignName,
				classificationName1 : $rootScope.search.classification,
				classificationName2 : $rootScope.classif.classification2,
				startDate : date.startDate,
				endDate : date.endDate
		};
		
		$rootScope.search.campaignName = STRING_DEFAULT;
		$rootScope.search.classification = STRING_DEFAULT;
		$rootScope.classif.classification2 = STRING_DEFAULT;
		
		var data = escape(angular.toJson(searchCampaign));
		console.log(JSON.stringify(searchCampaign));

		$http({
			method : 'POST',
			url : 'searchCampaignsAction',
			data : 'searchCampaign=' + data,
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(
				function(data, status, headers, config) {
					
					console.log('data: '+JSON.stringify(data));
					
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
	
	
	$scope.downloadFile = function(name,file) {

        var octetStreamMime = 'application/octet-stream';
        var success = false;         
        var filename = name;
        var contentType =  octetStreamMime;              
        
       var fileDownload = new Uint8Array(file);
        try
        {
            // Try using msSaveBlob if supported
            console.log("Trying saveBlob method ...");
            var blob = new Blob([fileDownload], { type: contentType });
            if(navigator.msSaveBlob)
                navigator.msSaveBlob(blob, filename);
            else {
                // Try using other saveBlob implementations, if available
                var saveBlob = navigator.webkitSaveBlob || navigator.mozSaveBlob || navigator.saveBlob;
                if(saveBlob === undefined) throw "Not supported";
                saveBlob(blob, filename);
            }
            console.log("saveBlob succeeded");
            success = true;
        } catch(ex)
        {
            console.log("saveBlob method failed with the following exception:");
            console.log(ex);
        }

        if(!success)
        {
            // Get the blob url creator
            var urlCreator = window.URL || window.webkitURL || window.mozURL || window.msURL;
            if(urlCreator)
            {
                // Try to use a download link
                var link = document.createElement('a');
                if('download' in link)
                {
                    // Try to simulate a click
                    try
                    {
                        // Prepare a blob URL
                        console.log("Trying download link method with simulated click ...");
                        var blob = new Blob([fileDownload], { type: contentType });
                                                
                        
                        var url = urlCreator.createObjectURL(blob);
                        link.setAttribute('href', url);

                        // Set the download attribute (Supported in Chrome 14+ / Firefox 20+)
                        link.setAttribute("download", filename);

                        // Simulate clicking the download link
                        var event = document.createEvent('MouseEvents');
                        event.initMouseEvent('click', true, true, window, 1, 0, 0, 0, 0, false, false, false, false, 0, null);
                        link.dispatchEvent(event);
                        console.log("Download link method with simulated click succeeded");
                        success = true;

                    } catch(ex) {
                        console.log("Download link method with simulated click failed with the following exception:");
                        console.log(ex);
                    }
                }

                if(!success)
                {
                    // Fallback to window.location method
                    try
                    {
                        // Prepare a blob URL
                        // Use application/octet-stream when using window.location to force download
                        console.log("Trying download link method with window.location ...");
                        var blob = new Blob([fileDownload], { type: octetStreamMime });
                        var url = urlCreator.createObjectURL(blob);
                        window.location = url;
                        console.log("Download link method with window.location succeeded");
                        success = true;
                    } catch(ex) {
                        console.log("Download link method with window.location failed with the following exception:");
                        console.log(ex);
                    }
                }
            }
        }

        if(!success)
        {
            // Fallback to window.open method
            console.log("No methods worked for saving the arraybuffer, using last resort window.open");
            window.open(httpPath, '_blank', '');
        }    
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