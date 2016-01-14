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
		'ngTable', 'ui.router' ]);

appres.run(function($rootScope) {
	$rootScope.search = {
		campaignName : STRING_DEFAULT,
		classification : STRING_DEFAULT
	};

	$rootScope.classif = {
		classification2 : STRING_DEFAULT
	};

});

appres.controller('campaignAdminController',
		function($scope, $filter, $rootScope, $http, NgTableParams, $state) {
				    
					$scope.date = {
						startDate : moment(),
						endDate : moment()
					};

					$scope.buttonCampaig = '';
					
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
									headers : { 'Content-Type' : 'application/x-www-form-urlencoded' }
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
					

/************************************************************************
============================== Upload File Start ========================
************************************************************************/
					function UInt8ArrayToString(uInt8Array)
					{
					    var s= "";
					    for(var i= number = 0; i < uInt8Array.byteLength; i++)
					    {
					        if( i > 0 )
					            s += ",";
					        s += uInt8Array[i];
					    }    
					    return s;
					}
					
$scope.ticketUpload = function() {

	$scope.data = 'none';

	var f = document.getElementById('file-html').files[0], r = new FileReader();
	var sizeFile = document.getElementById('file-html').files[0].size;
	var fileInput = $('.upload-file');
	var maxSize = fileInput.data('max-size');
	var nameFile = document.getElementById('file-html').files[0].name;
	
	r.onloadend = function(e) {
		var binary = "";
		var fileBytes = new Uint8Array(e.target.result);
		
		var fileBytesStr = UInt8ArrayToString(fileBytes);
		if(sizeFile>=maxSize){
			alert('el tamaño del archivo sobrepasa el limite permitido: '+(maxSize/1024)+'KB');
			return;
		}
		var length = fileBytes.byteLength;

		for (var i = 0; i < length; i++) {
			binary += String.fromCharCode(fileBytes[i]);
		}

		$scope.data = (binary).toString();
		$scope.byte = 0;
		$scope.fb = fileBytes;

		var b64encoded = btoa(String.fromCharCode.apply(
				null, fileBytes));
		 
		// CREAR JSON
		$rootScope.myData = {
			file : fileBytesStr,
			fileName: nameFile
		};

		console.log("DATA: "+JSON.stringify($rootScope.myData));
		var jsonData = escape(angular
				.toJson($rootScope.myData));

// 		$http(
// 				{
// 					method : 'POST',
// 					url : 'uploadTicketAction',
// 					data : 'ticket=' + jsonData,
// 					headers : {
// 						'Content-Type' : 'application/x-www-form-urlencoded'
// 					}
// 				}).success(
// 				function(data, status, headers, config) {
// 					$scope.items = data;					
// 					$scope.ticket.date = '';
// 					$scope.ticket.amount = '';
// 					$scope.ticket.tip = '';
// 					$scope.ticket.commerce = '';
// 					$scope.ticket.rfc = '';
// 					comment : $scope.ticket.comment = '';					
// //					$scope.downloadFile(data.pdfFileName, data.ticketPhoto);
					
// 					if(data != null && data == RESULT_SUCCESS){
// 				        var messageTemplate = '<span>El ticket: '+$rootScope.myData.fileName+' ha sido asociado correctamente.</span>';		        
// 				        notify({
// 				            messageTemplate: messageTemplate,
// 				            classes: "alert-success",
// 				            position: $scope.position,
// 				            duration: 10000
// 				        }); 
// 					}
// 					else if (data != null && data == TICKET_EXISTS) {
// 						var messageTemplate = '<span>No se pudo realizar la vinculación del ticket: '+$rootScope.myData.fileName+
// 						', ya que este archivo se encuentra ligado a otro ticket. </span>';
// 				        notify({
// 				            messageTemplate: messageTemplate,
// 				            classes: "alert-warning",
// 				            position: $scope.position,
// 				            duration: 15000
// 				        });		
// 					}
// 					else{
// 						var messageTemplate = '<span>No se pudo asociar el ticket: '+$rootScope.myData.fileName+'.</span>';		        
// 				        notify({
// 				            messageTemplate: messageTemplate,
// 				            classes: "alert-danger",
// 				            position: $scope.position,
// 				            duration: 10000
// 				        });						
// 						}

// 					$scope.refreshTransactionsTable($scope.screen);
					
// 				}).error(
// 				function(data, status, headers, config) {
// 			        var messageTemplate = '<span>Error en conexión con el servidor.</span>';		        
// 			        notify({
// 			            messageTemplate: messageTemplate,
// 			            classes: "alert-warning",
// 			            position: $scope.position,
// 			            duration: 10000
// 			        }); 
// 				});
		
	}

	r.readAsArrayBuffer(f);
};
/************************************************************************
================================ Upload File End ========================
************************************************************************/


/************************************************************************
================================ New Campaign Start =====================
************************************************************************/
					
					$scope.select = 0;
					$scope.form = {
							campaignName : ''
					};
					
					$scope.getSelectClassList = function() {
						$http.get('getClassificationLevelAction').success(
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

					$scope.getCampaignForm = function(){
						
						var campaignForm = {
								campaignName : $scope.campaign.campaignName,
								startDate : new Date("October 13, 2014 11:13:00"),
								endDate : new Date("October 13, 2014 11:13:00"),
								classificationList : []
						};
						
						$scope.form.campaignName = campaignForm.campaignName;
						campaignForm.classificationList = [ { id : '1', name : 'seleccion Company', className : '' },
						                                    { id : '2', name : 'seleccion Programa', className : '' },
						                                    { id : '3', name : 'seleccion SubPrograma', className : '' },
						                                    { id : '4', name : 'seleccion Unidad de negocio', className : '' },
						                                    { id : '5', name : 'seleccion nivel 4', className : '' },
						                                    { id : '6', name : 'seleccion nivel 5', className : '' }];
						
						$scope.date.startDate = campaignForm.startDate;
						$scope.date.endDate = campaignForm.endDate;
						
						$scope.selectCampaign.items[0].availableOptions = $scope.getHardCodeSelect();
						$scope.selectCampaign.items[1].availableOptions = $scope.getHardCodeSelect();
						$scope.selectCampaign.items[2].availableOptions = $scope.getHardCodeSelect();
						$scope.selectCampaign.items[3].availableOptions = $scope.getHardCodeSelect();
						$scope.selectCampaign.items[4].availableOptions = $scope.getHardCodeSelect();
						$scope.selectCampaign.items[5].availableOptions = $scope.getHardCodeSelect();
						
						$scope.selectCampaign.items[0].selectedOption = campaignForm.classificationList[0];
						$scope.selectCampaign.items[1].selectedOption = campaignForm.classificationList[1];
						$scope.selectCampaign.items[2].selectedOption = campaignForm.classificationList[2];
						$scope.selectCampaign.items[3].selectedOption	= campaignForm.classificationList[3];
						$scope.selectCampaign.items[4].selectedOption = campaignForm.classificationList[4];
						$scope.selectCampaign.items[5].selectedOption	= campaignForm.classificationList[5];
						
					};
					
					$scope.getHardCodeSelect  = function() {
						var data =  [	{ id : '-1', name : 'Ninguno' },
						             	{ id : '1', name : 'seleccion Company' },
	                                    { id : '2', name : 'seleccion Programa' },
	                                    { id : '3', name : 'seleccion SubPrograma' },
	                                    { id : '4', name : 'seleccion Unidad de negocio' },
	                                    { id : '5', name : 'seleccion nivel 4' },
	                                    { id : '6', name : 'seleccion nivel 5' },
                                    	{ id : '-2', name : 'Añadir nuevo' } ];
						return data;
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
								'Content-Type' : 'application/x-www-form-urlencoded'
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
								'Content-Type' : 'application/x-www-form-urlencoded'
							}
						}).success(
								function(data, status, headers, config) {
									//TODO
									$state.go('campaign');
								}).error(function(data, status, headers, config) {
									//TODO
									$state.go('campaign');
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
		templateUrl : 'templates/newPublication.html'
	})
	
});
