// ------ themes ----------
var CSS_DEFAULT = 'default.css';
var LOGO_DEFAULT = '';
var STRING_DEFAULT = '';

//STATE OF UI ROUTE

var STATE_HOME 		  = 'HOME';
var STATE_CAMPAIGNS   = 'CAMPAIGNS';   
var STATE_CAMPAIGN    = 'CAMPAIGN';
var STATE_PUBLICATION = 'PUBLICATION';
var currentState = '';
var startSession = 0; 

var appres = angular.module('app', [ 'ngMessages', 'daterangepicker',
		'ngTable', 'ui.router', 'angular-carousel' ]);

appres.run(function($rootScope) {
	$rootScope.search = {
		campaignName : STRING_DEFAULT,
		classification : STRING_DEFAULT
	};

	$rootScope.classif = {
		classification2 : STRING_DEFAULT
	};

})

appres
		.controller(
				'campaignController',
				function($scope, $filter, $rootScope, $http, NgTableParams,
						$state, Carousel) {
					
					$scope.Carousel = Carousel;

					$scope.css = CSS_DEFAULT;
					$scope.logo = LOGO_DEFAULT;

					$scope.date = {
						startDate : moment(),
						endDate : moment()
					};

					$scope.goToHome = function() {
						$scope.getClassifications();
						$state.go('home');
					}

					$scope.goToCampaigs = function() {

						if ($scope.menuCampaign && !$scope.companyMenu) {
							$state.go('campaigns');
						} else {
							$scope.getClassifications();
							$state.go('home');
						}
					}

					$scope.menuCampaign = false;
					$scope.companyMenu = false;
					
					var imageCampaignArray = [1,2,3,4,5];
					
					//funcion para colocar imagen en estado de campañas
					
					$scope.getIndex2 = function(){
						
						var indexImage = imageCampaignArray.pop();
						
						if(indexImage == null){
							imageCampaignArray.push(1,2,3,4,5);
							indexImage = imageCampaignArray.pop();
						}
						
						return indexImage; 
					}
					
					$scope.getCampaignsByCompany = function() {
						var data = angular.toJson($scope.classification);
						
						$http(
								{
									method : 'POST',
									url : 'getCampaignsByComanyAction',
									data : 'classificationCmp=' + data,
									headers : {
										'Content-Type' : 'application/x-www-form-urlencoded; charset=UTF-8'
									}
								}).success(
								function(data, status, headers, config) {
									$scope.campaignsByCom = data;
									
									//$scope.updateClassification($scope.classification);
									
									$scope.tableCampaignByCompany = new NgTableParams({
										page : 1,
										count : 5,
										filter : $scope.filters,
									}, {
										total : $scope.campaignsByCom.length,
										counts : [],
										getData : function($defer, params) {
											var filteredData = params.filter() ? $filter(
													'filter')($scope.rm,
													params.filter().myfilter)
													: $scope.campaignsByCom;

											var orderedData = params.sorting() ? $filter(
													'orderBy')(filteredData, params.orderBy())
													: $scope.campaignsByCom;

											$defer.resolve(orderedData.slice(
													(params.page() - 1) * params.count(),
													params.page() * params.count()));
										}
									});
									
									

								}).error(
								function(data, status, headers, config) {

								});
					}

					$scope.getCampaigns = function() {
						
						var data = angular.toJson($scope.classification);
						//var data = angular.toJson(1);


						$http(
								{
									method : 'POST',
									url : 'getCampaignsAction',
									data : 'classificationCmp=' + data,
									headers : {
										'Content-Type' : 'application/x-www-form-urlencoded; charset=UTF-8'
									}
								}).success(
								function(data, status, headers, config) {
									$scope.campaigns = data;
									
									//console.log($scope.campaigns[0].imageBase64);
									
									var index2;
									for (index2 = 0; index2 < $scope.campaigns.length; index2++) {
										$scope.campaigns[index2].indexImage2 = $scope.getIndex2(); 
									}
									$scope.updateClassification($scope.classification);
									
//									$scope.tableCampaign = new NgTableParams({
//										page : 1,
//										count : 5//,
//										//filter : $scope.filters,
//									}, {
//										total : $scope.publications.length,
//										counts : [],
//										getData : function($defer, params) {
//											var filteredData = params.filter() ? $filter(
//													'filter')($scope.rm,
//													params.filter().myfilter)
//													: $scope.campaigns;
//
//											var orderedData = params.sorting() ? $filter(
//													'orderBy')(filteredData, params.orderBy())
//													: $scope.campaigns;
//
//											$defer.resolve(orderedData.slice(
//													(params.page() - 1) * params.count(),
//													params.page() * params.count()));
//										}
//									});
									
									

								}).error(
								function(data, status, headers, config) {

								});
					};

					$scope.getFile = function(file) {
						$http.get(
								'getFileAction?fileName=' + file.fileName + '.'
										+ file.fileExtension).success(
								function(data, status, headers, config) {

									$scope.downloadFile(file.fileName + '.'
											+ file.fileExtension, data)

								}).error(
								function(data, status, headers, config) {

								});
					};

					$scope.getClassifications = function() {

						$http
								.get('getMyClassificationsAction')
								.success(
										function(data, status, headers, config) {

											$scope.classifications = data;

											if (data.length == 1) {
												$scope
														.updateClassification($scope.classifications[0]);
												$scope.companyMenu = false;
											} else
//												$scope
//												.updateClassification($scope.classifications[0]);
												$scope.companyMenu = true;

										})
								.error(function(data, status, headers, config) {

								});

					};

					$scope.selectClassification = function(classification) {
						$state.go('home');
						$scope.companyMenu = false;
						$scope.updateClassification(classification);
					};

					$scope.getCampaign = function() {

						var data = angular.toJson($scope.campaign);
						//var data = angular.toJson('1');

						$http(
								{
									method : 'POST',
									url : 'getPublicationsAction',
									data : 'campaign=' + data,
									headers : {
										'Content-Type' : 'application/x-www-form-urlencoded; charset=UTF-8'
									}
								})
								.success(
										function(data, status, headers, config) {
											$scope.publications = data;
											
											var index2;
											
											for (index2 = 0; index2 < $scope.publications.length; index2++) {
												$scope.publications[index2].indexImage2 = $scope.getIndex2(); 
											}
											
//											$scope.tableCampaign = new NgTableParams({
//												page : 1,
//												count : 5//,
//												//filter : $scope.filters,
//											}, {
//												total : $scope.publications.length,
//												counts : [],
//												getData : function($defer, params) {
//													var filteredData = params.filter() ? $filter(
//															'filter')($scope.rm,
//															params.filter().myfilter)
//															: $scope.publications;
//
//													var orderedData = params.sorting() ? $filter(
//															'orderBy')(filteredData, params.orderBy())
//															: $scope.publications;
//
//													$defer.resolve(orderedData.slice(
//															(params.page() - 1) * params.count(),
//															params.page() * params.count()));
//												}
//											});

										})
								.error(function(data, status, headers, config) {

								});
					};
					 

					$scope.getAttachedFiles = function() {

						var data = angular.toJson($scope.publication);
						
						$scope.loadingPublicationImage = true;
						$scope.files = false;

						$http(
								{
									method : 'POST',
									url : 'showPublicationAction',
									data : 'publication=' + data,
									headers : {
										'Content-Type' : 'application/x-www-form-urlencoded; charset=UTF-8'
									}
								})
								.success(
										function(data, status, headers, config) {
											$scope.attachedFiles = data.listFiles;
											
											$scope.imageOfPublication = data.image;
											
											//console.log(STATE_PUBLICATION);
											console.log(currentState);
											
//											if(data.image != null && currentState == STATE_PUBLICATION){
//												
//												$('body').addClass('image-th-p');
//												$('.image-th-p').css({ backgroundImage: "url("+data.image+")" });
//												
//											}
											
											$scope.loadingPublicationImage = false;
											$scope.files = true;

											$scope.tableAttachedFiles = new NgTableParams(
													{
														count : 10
													},
													{
														counts : [],
														dataset : $scope.attachedFiles
													});

											$(".publication-html").html(
													data.html);

										})
								.error(function(data, status, headers, config) {
								});
					};

					$scope.updateSession = function() {
						$http
								.get('updateSessionAction')
								.success(
										function(data, status, headers, config) {

											$scope.user = data.user;
											$scope.classification = data.classificationCmp;
											$scope.campaign = data.campaign;
											$scope.publication = data.publication;

											if ($scope.classification) {
												$scope.css = $scope.classification.catViews.colors;
												$scope.logo = 'img/company_logo/'
														+ $scope.classification.catViews.logos
														+ '/header.png';
												$scope.menuCampaign = true;
											}
											console.log(JSON.stringify(data));
											
											
											if(data.mensaje == 1){
												$('#myModal').modal('show');
											}
											
											console.log(data.mensaje);

										})
								.error(function(data, status, headers, config) {
								});
					};

					$scope.logout = function() {
						$http.get('logout').success(
								function(data, status, headers, config) {

								}).error(
								function(data, status, headers, config) {
								});
					};

					$scope.updateCampaign = function(campaign) {
						$scope.campaign = campaign;
					};

					$scope.updateClassification = function(classification) {
						$scope.menuCampaign = true;
						$scope.classification = classification;
						$scope.css = $scope.classification.catViews.colors;
						$scope.logo = 'img/company_logo/'
								+ $scope.classification.catViews.logos
								+ '/header.png';
						
						$scope.logo2 = 'img/company_logo/'
							+ $scope.classification.catViews.logos
							+ '/logo.png';
					};

					$scope.updatePublication = function(publication) {
						$scope.publication = publication;
					};

					$scope.formatDate = function(date) {
						var d = new Date(date || Date.now()), month = ''
								+ (d.getMonth() + 1), day = '' + d.getDate(), year = d
								.getFullYear();

						if (month.length < 2)
							month = '0' + month;
						if (day.length < 2)
							day = '0' + day;

						return [ month, day, year ].join(' / ');
					};

					$scope.convertToPositive = function(amount) {
						if (amount == undefined)
							return 0;
						if (amount < 0)
							return amount * -1;
						return amount;
					};

					$scope.getLastTransactionByCard = function() {

						$scope.cleanTeme();

						$http
								.get('getLastTransactionByCardAction')
								.success(
										function(data, status, headers, config) {
											$scope.lastTransactions = data;
											for ( var index in data) {
												var dateFormatTransaction = moment(
														data[index].transactionDate,
														"YYYYMMDD HHmmss");
												$scope.lastTransactions[index].transactionDate = dateFormatTransaction
														.format("DD/MM/YYYY hh:mm a");
											}
											$scope.tableLastTransactions = new NgTableParams(
													{
														count : 10
													},
													{
														counts : [],
														dataset : $scope.lastTransactions
													});

										})
								.error(function(data, status, headers, config) {
								});
					};

					$scope.getBalance = function() {
						$http.get('getBalanceAction').success(
								function(data, status, headers, config) {
									$scope.balance = (data);
								}).error(
								function(data, status, headers, config) {
								});
					};

					$scope.isAdmin = function() {

						console.log('User catProfile : '
								+ $scope.user.catProfile);
						if ($scope.user.catProfile == 0) {
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

						var data = angular.toJson(searchCampaign);
						console.log(JSON.stringify(searchCampaign));

						$http(
								{
									method : 'POST',
									url : 'searchCampaignsAction',
									data : 'searchCampaign=' + data,
									headers : {
										'Content-Type' : 'application/x-www-form-urlencoded; charset=UTF-8'
									}
								}).success(
								function(data, status, headers, config) {

									console
											.log('data: '
													+ JSON.stringify(data));

									$scope.campaigns = data;
									$scope.tableCampaigns = new NgTableParams({
										count : 10
									}, {
										counts : [],
										dataset : data
									});

								}).error(
								function(data, status, headers, config) {

								});
					};

					$scope.cleanTeme = function() {
						$scope.css = CSS_DEFAULT;
						$scope.logo = LOGO_DEFAULT;
						$scope.menuCampaign = false;
					};

					$scope.downloadFile = function(name, file) {

						var octetStreamMime = 'application/octet-stream';
						var success = false;
						var filename = name;
						var contentType = octetStreamMime;

						var fileDownload = new Uint8Array(file);
						try {
							// Try using msSaveBlob if supported
							console.log("Trying saveBlob method ...");
							var blob = new Blob([ fileDownload ], {
								type : contentType
							});
							if (navigator.msSaveBlob)
								navigator.msSaveBlob(blob, filename);
							else {
								// Try using other saveBlob implementations, if
								// available
								var saveBlob = navigator.webkitSaveBlob
										|| navigator.mozSaveBlob
										|| navigator.saveBlob;
								if (saveBlob === undefined)
									throw "Not supported";
								saveBlob(blob, filename);
							}
							console.log("saveBlob succeeded");
							success = true;
						} catch (ex) {
							console
									.log("saveBlob method failed with the following exception:");
							console.log(ex);
						}

						if (!success) {
							// Get the blob url creator
							var urlCreator = window.URL || window.webkitURL
									|| window.mozURL || window.msURL;
							if (urlCreator) {
								// Try to use a download link
								var link = document.createElement('a');
								if ('download' in link) {
									// Try to simulate a click
									try {
										// Prepare a blob URL
										console
												.log("Trying download link method with simulated click ...");
										var blob = new Blob([ fileDownload ], {
											type : contentType
										});

										var url = urlCreator
												.createObjectURL(blob);
										link.setAttribute('href', url);

										// Set the download attribute (Supported
										// in Chrome 14+ / Firefox 20+)
										link.setAttribute("download", filename);

										// Simulate clicking the download link
										var event = document
												.createEvent('MouseEvents');
										event.initMouseEvent('click', true,
												true, window, 1, 0, 0, 0, 0,
												false, false, false, false, 0,
												null);
										link.dispatchEvent(event);
										console
												.log("Download link method with simulated click succeeded");
										success = true;

									} catch (ex) {
										console
												.log("Download link method with simulated click failed with the following exception:");
										console.log(ex);
									}
								}

								if (!success) {
									// Fallback to window.location method
									try {
										// Prepare a blob URL
										// Use application/octet-stream when
										// using window.location to force
										// download
										console
												.log("Trying download link method with window.location ...");
										var blob = new Blob([ fileDownload ], {
											type : octetStreamMime
										});
										var url = urlCreator
												.createObjectURL(blob);
										window.location = url;
										console
												.log("Download link method with window.location succeeded");
										success = true;
									} catch (ex) {
										console
												.log("Download link method with window.location failed with the following exception:");
										console.log(ex);
									}
								}
							}
						}

						if (!success) {
							// Fallback to window.open method
							console
									.log("No methods worked for saving the arraybuffer, using last resort window.open");
							window.open(httpPath, '_blank', '');
						}
					};
					
					
					$scope.dudas = function(){
						$state.go('home');
						
					    $('a.page-scroll').bind('click', function(event) {
					        var $anchor = $(this);
					        console.log($anchor);
					        $('html, body').stop().animate({
					            scrollTop: $($anchor.attr('href')).offset().top
					        }, 2000, 'easeInOutExpo');
					        event.preventDefault();
					    });
					}
					
					
					$scope.getRM = function() {

						var data = angular.toJson($scope.campaign);
						
						console.log("FUNCION RM");
						
						

						$http({
									method : 'POST',
									url : 'getListRMTHAction',
									data : 'campaign=' + data,
									headers : { 'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8' }
								})
								.success(
										function(data, status, headers, config) {
											
											$scope.rm = data;
											
											$scope.ganado 	 = data[0].ganado;
											$scope.pagado 	 = data[0].pagado;
											$scope.pendiente = data[0].pendiente;
											
											console.log($scope.ganado);
											console.log($scope.pagado);
											console.log($scope.pendiente);
											
											console.log(JSON.stringify(data));
											
											$scope.tableRM = new NgTableParams({
												page : 1,
												count : 15,
												filter : $scope.filters,
											}, {
												total : $scope.rm.length,
												counts : [],
												getData : function($defer, params) {
													var filteredData = params.filter() ? $filter(
															'filter')($scope.rm,
															params.filter().myfilter)
															: $scope.rm;

													var orderedData = params.sorting() ? $filter(
															'orderBy')(filteredData, params.orderBy())
															: $scope.rm;

													$defer.resolve(orderedData.slice(
															(params.page() - 1) * params.count(),
															params.page() * params.count()));
												}
											});

										}).error(function(data, status, headers, config) {

								});
						
						
					};
					
					$scope.getRMPending = function() {
						
						var data = angular.toJson($scope.campaign);
						console.log("getRMPending");	

						$http({
									method : 'POST',
									url : 'getListRMPendingTHAction',
									data : 'campaign=' + data,
									headers : { 'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8' }
								})
								.success(
										function(data, status, headers, config) {
											
											$scope.rm = data;
											
											$scope.ganado 	 = data[0].ganado;
											$scope.pagado 	 = data[0].pagado;
											$scope.pendiente = data[0].pendiente;
											
											console.log($scope.ganado);
											console.log($scope.pagado);
											console.log($scope.pendiente);
											
											console.log(JSON.stringify(data));
											
											$scope.tableRM = new NgTableParams({
												page : 1,
												count : 15,
												filter : $scope.filters,
											}, {
												total : $scope.rm.length,
												counts : [],
												getData : function($defer, params) {
													var filteredData = params.filter() ? $filter(
															'filter')($scope.rm,
															params.filter().myfilter)
															: $scope.rm;

													var orderedData = params.sorting() ? $filter(
															'orderBy')(filteredData, params.orderBy())
															: $scope.rm;

													$defer.resolve(orderedData.slice(
															(params.page() - 1) * params.count(),
															params.page() * params.count()));
												}
											});

										}).error(function(data, status, headers, config) {

								});
						
						
					};
					
					$scope.getRMNoPending = function() {
						
						var data = angular.toJson($scope.campaign);
						console.log("getRMPending");	

						$http({
									method : 'POST',
									url : 'getListRMNoPendingTHAction',
									data : 'campaign=' + data,
									headers : { 'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8' }
								})
								.success(
										function(data, status, headers, config) {
											
											$scope.rm = data;
											
											$scope.ganado 	 = data[0].ganado;
											$scope.pagado 	 = data[0].pagado;
											$scope.pendiente = data[0].pendiente;
											
											console.log($scope.ganado);
											console.log($scope.pagado);
											console.log($scope.pendiente);
											
											console.log(JSON.stringify(data));
											
											$scope.tableRM = new NgTableParams({
												page : 1,
												count : 15,
												filter : $scope.filters,
											}, {
												total : $scope.rm.length,
												counts : [],
												getData : function($defer, params) {
													var filteredData = params.filter() ? $filter(
															'filter')($scope.rm,
															params.filter().myfilter)
															: $scope.rm;

													var orderedData = params.sorting() ? $filter(
															'orderBy')(filteredData, params.orderBy())
															: $scope.rm;

													$defer.resolve(orderedData.slice(
															(params.page() - 1) * params.count(),
															params.page() * params.count()));
												}
											});

										}).error(function(data, status, headers, config) {

								});
						
						
					};
					
					$scope.changeDate = function(value){
						console.log(value);
						
						if(value){
							
							$("#daterange1").prop('disabled', false);
						}
						else{
							$("#daterange1").prop('disabled', true);
						}
					}
					
					$scope.searchAccountStatus = function(date, stateDate) {
						
						console.log(stateDate);
						
						if(!stateDate){
							var searchAccountStatusvar = {
									campaign 			: $rootScope.search.campaing,
									//unidadDeNegocio 	: $rootScope.search.unity,
									participanteIdStars : $rootScope.search.thIdStars,
									movimiento 			: $rootScope.search.movement,
									observaciones 		: $rootScope.search.observation, 
									startDate 			: null,
									endDate 			: null
							};
						}
						else{
							var searchAccountStatusvar = {
									campaign 			: $rootScope.search.campaing,
									//unidadDeNegocio 	: $rootScope.search.unity,
									participanteIdStars : $rootScope.search.thIdStars,
									movimiento 			: $rootScope.search.movement,
									observaciones 		: $rootScope.search.observation, 
									startDate 			: date.startDate,
									endDate 			: date.endDate
							};
						}
						
						var data = angular.toJson(searchAccountStatusvar);
						console.log(JSON.stringify(searchAccountStatusvar));
						
						$http({
						method : 'POST',
						url : 'searchAccountStatusTHAction',
						data : 'searchAccountStatusvar=' + data,
						headers : {
							'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
						}
						}).success(
							function(data, status, headers, config) {
								
								$scope.rm = data;
								
								if(data.length != 0){
									
									$scope.ganado 	 = data[0].ganado;
									$scope.pagado 	 = data[0].pagado;
									$scope.pendiente = data[0].pendiente;
									
									console.log($scope.ganado);
									console.log($scope.pagado);
									console.log($scope.pendiente);
								}
								else{
									$scope.tableRM.reload();
								}
								
								console.log(JSON.stringify(data));
								
								$scope.tableRM = new NgTableParams({
									page : 1,
									count : 15,
									filter : $scope.filters,
								}, {
									total : $scope.rm.length,
									counts : [],
									getData : function($defer, params) {
										var filteredData = params.filter() ? $filter(
												'filter')($scope.rm,
												params.filter().myfilter)
												: $scope.rm;

										var orderedData = params.sorting() ? $filter(
												'orderBy')(filteredData, params.orderBy())
												: $scope.rm;

										$defer.resolve(orderedData.slice(
												(params.page() - 1) * params.count(),
												params.page() * params.count()));
									}
								});
								
							}).error(function(data, status, headers, config) {

							});
						
					};
					
					$scope.data = {
							singleSelect: '1',
						    multipleSelect: []
						   };
					
					$scope.downloadRMPending = function (){
						console.log($scope.data.singleSelect);
						
						$http({
							method : 'POST',
							url : 'getRMXLSPendingTHAction',
							data : 'reportSelectedCon=' + $scope.data.singleSelect,
							headers : {
								'Content-Type' : 'application/x-www-form-urlencoded'
							}
						})
							.success(function(data, status, headers, config) {
								var resultCode = data.resultCode;				
								if(resultCode == '100'){
									
									console.log("descargando");
									
									downloadReportFile(data.fileName+ '.xls', data.valueCode);
									
								}else{
									
									
								}
							})
							.error(function(data, status, headers, config) {
								
								
							});
						
					}
					
					
					downloadReportFile = function(name,file) {

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
		templateUrl : 'templates/homeTh2.jsp',
		controller:	
 			function($scope) {
			
			currentState = STATE_HOME;

			$('html, body').animate({
				scrollTop : $("#init").offset().top
			});
			
			$('a.page-scroll').bind('click', function(event) {
		        var $anchor = $(this);
		        console.log($anchor);
		        $('html, body').stop().animate({
		            scrollTop: $($anchor.attr('href')).offset().top
		        }, 2000, 'easeInOutExpo');
		        event.preventDefault();
		    });
			
			$('#li-home').hide();
			$('#li-campaigns').hide();
			$('#li-campaign').hide();
			$('#p-account').hide();
			
			$('#p-home').show();
			$('#p-campaigns').hide();
			$('#p-campaign').hide();
			$('#p-detail-publication').hide();
			
			$('#menu-files-publication').hide();
			
			//$('#myModal').modal('show');
			
				
		}
	})

	.state('campaigns', {
		url : '/incentivos',
		templateUrl : 'templates/campaigns_user.jsp',
		controller:	
 			function($scope) {
			
			currentState = STATE_CAMPAIGNS;

			$('html, body').animate({
				scrollTop : $("#init").offset().top
			});
			
			$('#li-home').show();
			$('#li-campaigns').hide();
			$('#li-campaign').hide();
			$('#p-account').hide();
			
			$('#p-home').hide();
			$('#p-campaigns').show();
			$('#p-campaign').hide();
			$('#p-detail-publication').hide();
			
			$('#menu-files-publication').hide();
			
			
		}
	})

	.state('campaign', {
		url : '/incentivo',
		templateUrl : 'templates/campaignDetail_user.jsp',
		controller:	
 			function($scope) {

			currentState = STATE_CAMPAIGN;

			$('html, body').animate({
				scrollTop : $("#init").offset().top
			});
			
			$('#li-home').show();
			$('#li-campaigns').show();
			$('#li-campaign').hide();
			$('#p-account').hide();
			
			$('#p-home').hide();
			$('#p-campaigns').hide();
			$('#p-campaign').show();
			$('#p-detail-publication').hide();
			
			$('#menu-files-publication').hide();
			
		}
	})

	.state('publication', {
		url : '/publicacion',
		templateUrl : 'templates/publication_user.jsp',
		controller:	
 			function($scope) {
			
			currentState = STATE_PUBLICATION;

			$('html, body').animate({
				scrollTop : $("#init").offset().top
			});
			
			$('#li-home').show();
			$('#li-campaigns').show();
			$('#li-campaign').show();
			$('#p-account').hide();
			
			$('#p-home').hide();
			$('#p-campaigns').hide();
			$('#p-campaign').hide();
			$('#p-detail-publication').show();
			
			
			$('body').css({ "display": "" });
			
		}
	})
	
	.state('account_status', {
		url : '/estado_de_cuenta',
		templateUrl : 'templates/th/account_status_th.jsp',
		controller:	
 			function($scope) {

			$('html, body').animate({
				scrollTop : $("#init").offset().top
			});
			
			$('#li-home').show();
			$('#li-campaigns').hide();
			$('#li-campaign').hide();
			$('#p-account').show();
			
			$('#p-home').hide();
			$('#p-campaigns').hide();
			$('#p-campaign').hide();
			$('#p-detail-publication').hide();
			
			$('#menu-files-publication').hide();
			
			
		}
	})
	
});

angular.bootstrap(document, [ 'app' ]);
