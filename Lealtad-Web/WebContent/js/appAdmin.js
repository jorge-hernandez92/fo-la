// ------ themes ----------
var CSS_DEFAULT = 'sivale.css';
var LOGO_DEFAULT = '';
var STRING_DEFAULT = '';


// ------- Classification Campaings ----------
var COMPANY_SELECT		= 0;
var PROGRAM_SELECT		= 1;
var SUBPROGRAM_SELECT	= 2;
var BUSINESSUNIT_SELECT	= 3;
var LEVEL4_SELECT		= 4;
var LEVEL5_SELECT		= 5;

var appres = angular.module('app', [ 'ngMessages', 'daterangepicker',
		'ngTable', 'ui.router', 'ng-toggle.btn' ])

appres.run(function($rootScope) {
	$rootScope.search = {
		campaignName : STRING_DEFAULT,
		classification : STRING_DEFAULT
	};

	$rootScope.classif = {
		classification2 : STRING_DEFAULT
	};

	$rootScope.files = {
		html : '',
		excel : ''
	};
	
})

appres.controller('campaignAdminController', ['$scope', 'upload', '$filter', '$rootScope', '$http', 'NgTableParams', '$state', 
		function($scope, upload, $filter, $rootScope, $http, NgTableParams, $state) {
				    
					$scope.date = {
						startDate : moment(),
						endDate : moment()
					};

					$scope.buttonCampaig = '';
					
					$scope.rows = [];
					  
					$scope.counter = 0;
					  
					$scope.addRow = function() {
					    
						$scope.rows.push( {index : $scope.counter + 2, value : false} );
						$scope.counter++;
					}
					
					$scope.removeRow = function(index){
					    $scope.rows.splice(index, 1);
					}
					  
					$scope.uploadFile = function()
					{
						var file = $rootScope.files.html;
						console.log(file);
						
						
						var data = escape(angular.toJson($rootScope.files.html));
						
						$http({
							method : 'POST',
							url : 'uploadFileAction',
							data : 'file=' + data,
							headers : { 'Content-Type' : 'application/x-www-form-urlencoded; charset=UTF-8' }
						  }).success(function(data, status, headers, config) {
							  
						  }).error(function(data, status, headers, config) {
							  
						  });
						
					};
					
					$scope.getCampaignsAdmin = function() {

						$http.get('getCampaignsAdminAction').success(
								function(data, status, headers, config) {
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

					$scope.getCampaign = function() {

						var data = escape(angular.toJson($scope.campaign));

						$http({
									method : 'POST',
									url : 'getPublicationsAction',
									data : 'campaign=' + data,
									headers : { 'Content-Type' : 'application/x-www-form-urlencoded; charset=UTF-8' }
								})
								.success(
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
								'Content-Type' : 'application/x-www-form-urlencoded; charset=UTF-8'
							}
						}).success(
								function(data, status, headers, config) {
									$scope.attachedFiles = data.listFiles;

									$scope.tableAttachedFiles = new NgTableParams({
										count : 10
									}, {
										counts : [],
									    dataset: $scope.attachedFiles
									});

									$(".publication-html").html(data.html);

								}).error(function(data, status, headers, config) {
						});
					};
					
					$scope.updateSession = function() {
						$http.get('updateSessionAction').success(
								function(data, status, headers, config) {

									$scope.user = data.user;
									$scope.campaign = data.campaign;
									$scope.publication = data.publication;

								}).error(
								function(data, status, headers, config) {
								});
					};

					$scope.updateCampaign = function(campaign) {
						$scope.campaign = campaign;
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
					
					$scope.getFile = function(file) {
						$http.get('getFileAction?fileName='+file.fileName+'.'+file.fileExtension).success(
								function(data, status, headers, config) {

									$scope.downloadFile(file.fileName+'.'+file.fileExtension, data)
								
								}).error(function(data, status, headers, config) {
									
							});
					};
					
					$scope.updatePublication = function(publication) {
						$scope.publication = publication;
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


/************************************************************************
================================ New Campaign Start =====================
************************************************************************/
					
					$scope.select = 0;
					$scope.form = {
							campaignName : ''
					};
					
					$scope.getPublicationTypes = function() {
						
						$http.get('getPublicationTypesAction').success(
								function(data, status, headers, config) {

									$scope.selectPublicationType.availableOptions = data;
						
								}).error(
								function(data, status, headers, config) {
									
								});
					};
					
					$scope.getSelectClassList = function() {
						if($scope.select == COMPANY_SELECT)
							var action = 'getClassificationLevelAction?classificationId=-1';
						else
							var action = 'getClassificationLevelAction?classificationId='+$scope.selectCampaign.items[$scope.select-1].selectedOption.id;
						
						$http.get(action).success(
								function(data, status, headers, config) {

									switch ($scope.select) {
								    	case COMPANY_SELECT:
								    		$scope.selectCampaign.items[0].availableOptions = data;
								    		break;
								    	case PROGRAM_SELECT:
								    		$scope.selectCampaign.items[1].availableOptions = data;
								    		break;
								    	case SUBPROGRAM_SELECT:
								    		$scope.selectCampaign.items[2].availableOptions = data;
								    		break;
								    	case BUSINESSUNIT_SELECT:
								    		$scope.selectCampaign.items[3].availableOptions = data;
								    		break;
								    	case LEVEL4_SELECT:
								    		$scope.selectCampaign.items[4].availableOptions = data;
								    		break;
								    	case LEVEL5_SELECT:
								    		$scope.selectCampaign.items[5].availableOptions = data;
								    		break;
									}
						
								}).error(
								function(data, status, headers, config) {
									
								});
					};
					
					$scope.getClassCompanyList = function() {
						
						$scope.formCampaingInit();
						$scope.select = COMPANY_SELECT;
						$scope.getSelectClassList();
					};
					
					$scope.getClassProgramList = function() {
						
						$scope.select = PROGRAM_SELECT;
						$scope.getSelectClassList();
					};
					
					$scope.getClassSubProgramList = function() {
						
						$scope.select = SUBPROGRAM_SELECT;
						$scope.getSelectClassList();
					};
					
					$scope.getClassBusinessUnitList = function() {
						
						$scope.select = BUSINESSUNIT_SELECT;
						$scope.getSelectClassList();
					};
					
					$scope.getClassLevel4List = function() {
						
						$scope.select = LEVEL4_SELECT;
						$scope.getSelectClassList();
					};
					
					$scope.getClassLevel5List = function() {
						
						$scope.select = LEVEL5_SELECT;
						$scope.getSelectClassList();
					};
					
					$scope.getSelectNone = function() {
						var data = { id : '-1', name : 'Ninguno' };
						return data;
					};
					
					$scope.getBasicSelect = function() {
						var data =  [	{ id : '-1', name : 'Ninguno' },
                                    	{ id : '-2', name : 'Añadir nuevo' } ];
						return data;
					};
					
					
					$scope.changeCompany = function() {
						$scope.getClassProgramList();
						
						$scope.selectCampaign.items[1].selectedOption =	$scope.getSelectNone();
						$scope.select == COMPANY_SELECT
						$scope.selectCampaign.items[2].selectedOption =	$scope.getSelectNone();
						$scope.selectCampaign.items[3].selectedOption =	$scope.getSelectNone();
						$scope.selectCampaign.items[4].selectedOption =	$scope.getSelectNone();
						$scope.selectCampaign.items[5].selectedOption =	$scope.getSelectNone();

					};

					
					$scope.changeProgram = function() {
						$scope.selectCampaign.items[1].className = '';
						$scope.selectCampaign.items[2].className = '';
						$scope.selectCampaign.items[3].className = '';
						$scope.selectCampaign.items[4].className = '';
						$scope.selectCampaign.items[5].className = '';

						if ($scope.selectCampaign.items[1].selectedOption.name == 'Añadir nuevo') {

							$scope.selectCampaign.items[1].className = '';

							$scope.selectCampaign.items[2].availableOptions = $scope.getBasicSelect();
							$scope.selectCampaign.items[2].selectedOption =	$scope.getSelectNone();

							$scope.selectCampaign.items[3].availableOptions = $scope.getBasicSelect();
							$scope.selectCampaign.items[3].selectedOption =	$scope.getSelectNone();

							$scope.selectCampaign.items[4].availableOptions = $scope.getBasicSelect();
							$scope.selectCampaign.items[4].selectedOption =	$scope.getSelectNone();

							$scope.selectCampaign.items[5].availableOptions = $scope.getBasicSelect();
							$scope.selectCampaign.items[5].selectedOption =	$scope.getSelectNone();
							
						} else {
							
							$scope.getClassSubProgramList();
							
							$scope.selectCampaign.items[2].selectedOption =	$scope.getSelectNone();
							$scope.selectCampaign.items[3].selectedOption =	$scope.getSelectNone();
							$scope.selectCampaign.items[4].selectedOption =	$scope.getSelectNone();
							$scope.selectCampaign.items[5].selectedOption =	$scope.getSelectNone();
							
						}

					};

					$scope.changeSubProgram = function() {
						$scope.selectCampaign.items[2].className = '';
						$scope.selectCampaign.items[3].className = '';
						$scope.selectCampaign.items[4].className = '';
						$scope.selectCampaign.items[5].className = '';

						if ($scope.selectCampaign.items[2].selectedOption.name == 'Añadir nuevo') {

							$scope.selectCampaign.items[2].className = '';

							$scope.selectCampaign.items[3].availableOptions = $scope.getBasicSelect();
							$scope.selectCampaign.items[3].selectedOption =	$scope.getSelectNone();

							$scope.selectCampaign.items[4].availableOptions = $scope.getBasicSelect();
							$scope.selectCampaign.items[4].selectedOption =	$scope.getSelectNone();

							$scope.selectCampaign.items[5].availableOptions = $scope.getBasicSelect();
							$scope.selectCampaign.items[5].selectedOption = 	$scope.getSelectNone();
						
						} else {
							
							$scope.getClassBusinessUnitList();
							
							$scope.selectCampaign.items[3].selectedOption =	$scope.getSelectNone();
							$scope.selectCampaign.items[4].selectedOption =	$scope.getSelectNone();
							$scope.selectCampaign.items[5].selectedOption =	$scope.getSelectNone();
						
						}
					};

					$scope.changeBusinessUnit = function() {
						$scope.selectCampaign.items[3].className = '';
						$scope.selectCampaign.items[4].className = '';
						$scope.selectCampaign.items[5].className = '';

						if ($scope.selectCampaign.items[3].selectedOption.name == 'Añadir nuevo') {

							$scope.selectCampaign.items[3].className = '';

							$scope.selectCampaign.items[4].availableOptions = $scope.getBasicSelect();
							$scope.selectCampaign.items[4].selectedOption =	$scope.getSelectNone();

							$scope.selectCampaign.items[5].availableOptions = $scope.getBasicSelect();
							$scope.selectCampaign.items[5].selectedOption =	$scope.getSelectNone();
						} else {
							$scope.getClassLevel4List();

							$scope.selectCampaign.items[4].selectedOption =	$scope.getSelectNone();
							$scope.selectCampaign.items[5].selectedOption =	$scope.getSelectNone();
						}
					};

					$scope.changeLevel4 = function() {
						$scope.selectCampaign.items[4].className = '';
						$scope.selectCampaign.items[5].className = '';

						if ($scope.selectCampaign.items[4].selectedOption.name == 'Añadir nuevo') {

							$scope.selectCampaign.items[4].className = '';

							$scope.selectCampaign.items[5].availableOptions = $scope.getBasicSelect();
							$scope.selectCampaign.items[5].selectedOption =	$scope.getSelectNone();
							
						} else {
							
							$scope.getClassLevel5List();

							$scope.selectCampaign.items[5].selectedOption =	$scope.getSelectNone();
						}
					};

					$scope.changeLevel5 = function() {
						$scope.selectCampaign.items[5].className = '';
					};


					$scope.formCampaingInit = function(){
						
						for (i = 0; i < $scope.selectCampaign.length; i++) {
							$scope.selectCampaign.items[i].selectedOption = '';
							$scope.selectCampaign.items[i].availableOptions = '';
						}
					};
					
					$scope.selectPublicationType = {
							availableOptions : '',
							selectedOption : ''
					};
					
					$scope.selectCampaign = { items : [{availableOptions : '', selectedOption : '', className : ''},
					                                   {availableOptions : '', selectedOption : '', className : ''},
					                                   {availableOptions : '', selectedOption : '', className : ''},
					                                   {availableOptions : '', selectedOption : '', className : ''},
					                                   {availableOptions : '', selectedOption : '', className : ''},
					                                   {availableOptions : '', selectedOption : '', className : ''}],
					                          isEnabled : 	function(item) {

					                        	  				if (item.selectedOption != '') {
					                        	  					if ((item.selectedOption.name == 'Añadir nuevo' || item.selectedOption.name == 'Ninguno')
					                        	  							&& item.className == '')
					                        	  						return false;
					                        	  					return true;
					                        	  				}
					                        	  				return false;
					                          				},
					                          isNewClass : function(item) {
					                        	  				if (item.selectedOption.name == 'Añadir nuevo')
					                        	  					return true;
					                        	  				return false;
					                          				}
					                        };

					$scope.cleanSelect = function(){
						$scope.form.campaignName = '';
						$scope.date.startDate = moment();
						$scope.date.endDate = moment();
						
						$scope.selectCampaign.items[0].selectedOption = '';
						for(i = 1 ; i < $scope.selectCampaign.items.length; i++){
							$scope.selectCampaign.items[i].availableOptions =	$scope.getBasicSelect();
							$scope.selectCampaign.items[i].selectedOption =	$scope.getSelectNone();
						}
					};
					
					$scope.getCampaignForm = function(){
						
						var data = escape(angular.toJson($scope.campaign));

						$http({
								method : 'POST',
								url : 'getCampaignUpdateAction',
								data : 'campaignDetail=' + data,
								headers : { 'Content-Type' : 'application/x-www-form-urlencoded; charset=UTF-8' }
							  }).success(function(data, status, headers, config) {
								  console.log(JSON.stringify(data));
								  
								  $scope.form.campaignName = $scope.campaign.campaignName;
								  $scope.date.startDate = $scope.campaign.startDate;
								  $scope.date.endDate = $scope.campaign.endDate;
								  
								  for (i=0 ; i<$scope.selectCampaign.items.length; i++){
									  if(i < data.length){
										  $scope.selectCampaign.items[i].availableOptions	= data[i].availableOptions;
										  $scope.selectCampaign.items[i].selectedOption		= data[i].selectedOption;
									  }
									  else{
										  $scope.selectCampaign.items[i].availableOptions = $scope.getBasicSelect();
										  $scope.selectCampaign.items[i].selectedOption =	$scope.getSelectNone();
									  }
								  }
								  								  
							  }).error(function(data, status, headers, config) {
								  
							  });
												
					};
					
					$scope.newCampaignForm = function(date){
						
						var campaignForm = {
								campaignName : $scope.form.campaignName,
								startDate : date.startDate,
								endDate : date.endDate,
								classificationList : []
						};
						
						campaignForm.classificationList.push($scope.selectCampaign.items[0].selectedOption);		
				
						for (i = 1; i < $scope.selectCampaign.items.length; i++) { 
							if($scope.selectCampaign.items[i].selectedOption.id != '-2')
								campaignForm.classificationList.push($scope.selectCampaign.items[i].selectedOption);
							else {
								campaignForm.classificationList.push({ id : '-2', name : $scope.selectCampaign.items[i].className });
							}
						}
						
						var data = escape(angular.toJson(campaignForm));
						console.log(JSON.stringify(data));
						
						$http({
							method : 'POST',
							url : 'addCampaignAction',
							data : 'formNewCampaign=' + data,
							headers : {
								'Content-Type' : 'application/x-www-form-urlencoded; charset=UTF-8'
							}
						}).success(
								function(data, status, headers, config) {
									//TODO
									$state.go('home');
								}).error(function(data, status, headers, config) {
									//TODO
									$state.go('home');
						});
						
					};
					
						
					$scope.updateCampaignForm = function(date){
						
						var campaignForm = {
								campaignId : $scope.campaign.campaignId,
								campaignName : $scope.form.campaignName,
								startDate : date.startDate,
								endDate : date.endDate,
								classificationList : []
						};
						
						campaignForm.classificationList.push($scope.selectCampaign.items[0].selectedOption);		
				
						for (i = 1; i < $scope.selectCampaign.items.length; i++) { 
							if($scope.selectCampaign.items[i].selectedOption.id != '-2')
								campaignForm.classificationList.push($scope.selectCampaign.items[i].selectedOption);
							else {
								campaignForm.classificationList.push({ id : '-2', name : $scope.selectCampaign.items[i].className });
							}
						}
						
						var data = escape(angular.toJson(campaignForm));
						console.log(JSON.stringify(data));
						
						$http({
							method : 'POST',
							url : 'updateCampaignAction',
							data : 'formNewCampaign=' + data,
							headers : {
								'Content-Type' : 'application/x-www-form-urlencoded; charset=UTF-8'
							}
						}).success(
								function(data, status, headers, config) {
									//TODO
									$state.go('home');
								}).error(function(data, status, headers, config) {
									//TODO
									$state.go('home');
									
						});
						
					};
					
					$scope.deleteCampaign = function() {
						$http.get('deleteCampaignAction?campaignId='+$scope.campaign.campaignId).success(
								function(data, status, headers, config) {
									$state.go('home');
								}).error(function(data, status, headers, config) {
									$state.go('home');
							});
					};
/*********************************************************************************
=============================== New Campaign End =================================
*********************************************************************************/

				}])


appres.directive('uploaderModel', ['$parse', function ($parse) {
	return {
		restrict: 'A',
		link: function (scope, iElement, iAttrs) 
		{
			iElement.on('change', function(e)
			{
				$parse(iAttrs.uploaderModel).assign(scope, iElement[0].files[0]);
			});
		}
	};
}])

appres.service('upload', ['$http', '$q', function ($http, $q) 
{
	this.uploadFile = function(file)
	{
		//var deferred = $q.defer();
		//var formData = new FormData();
		//formData.append('file', file);
		
		var data = escape(angular.toJson(file));
		
		$http({
			method : 'POST',
			url : 'UploadFileAction',
			data : 'file=' + data,
			headers : { 'Content-Type' : 'application/x-www-form-urlencoded; charset=UTF-8' }
		  }).success(function(data, status, headers, config) {
			  
		  }).error(function(data, status, headers, config) {
			  
		  });
		
	}	
}])

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

	.state('newCampaign', {
		url : '/nueva_campaña',
		templateUrl : 'templates/newCampaign_admin.html'
	})
	
	.state('updateCampaign', {
		url : '/actualizar_campaña',
		templateUrl : 'templates/updateCampaign_admin.html'
	})
	
	.state('newPublication', {
		url : '/nueva_publicacion',
		templateUrl : 'templates/UploadFile.jsp'
	})
	
	.state('publication', {
		url : '/publicacion',
		templateUrl : 'templates/publication_admin.html'
	})
	
})
