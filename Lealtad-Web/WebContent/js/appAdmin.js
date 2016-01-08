// ------ themes ----------
var CSS_DEFAULT = 'sivale.css';
var LOGO_DEFAULT = '';

var STRING_DEFAULT = '';

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

})

appres
		.controller(
				'campaignAdminController',
				function($scope, $filter, $rootScope, $http, NgTableParams,
						$state) {

					$scope.date = {
						startDate : moment(),
						endDate : moment()
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

						$http(
								{
									method : 'POST',
									url : 'getPublicationsAction',
									data : 'campaign=' + data,
									headers : {
										'Content-Type' : 'application/x-www-form-urlencoded'
									}
								})
								.success(
										function(data, status, headers, config) {
											$scope.publications = data;
											console.log(JSON.stringify(data));

											$scope.tablePublications = new NgTableParams(
													{
														page : 1,
														count : 10,
														filter : $scope.filters,
													},
													{
														total : $scope.publications.length,
														counts : [],
														getData : function(
																$defer, params) {
															var filteredData = params
																	.filter() ? $filter(
																	'filter')
																	(
																			$scope.publications,
																			params
																					.filter().myfilter)
																	: $scope.publications;

															var orderedData = params
																	.sorting() ? $filter(
																	'orderBy')
																	(
																			filteredData,
																			params
																					.orderBy())
																	: $scope.publications;

															$defer
																	.resolve(orderedData
																			.slice(
																					(params
																							.page() - 1)
																							* params
																									.count(),
																					params
																							.page()
																							* params
																									.count()));
														}
													});

										})
								.error(function(data, status, headers, config) {

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
================================ New Campaign Start =====================
************************************************************************/
					
					$scope.newClassificationlevel = {
						program : '',
						subProgram : '',
						businessUnit : '',
						level4 : '',
						level5 : ''
					};

					
					$scope.getClassCompanyList = function() {
						
						$http.get('getClassificationLevelAction').success(
								function(data, status, headers, config) {

									$scope.selectCompany.availableOptions = data;
								}).error(
								function(data, status, headers, config) {
									
								});
					};
					
					$scope.getClassProgramList = function() {
						
						$http.get('getClassificationLevelAction').success(
								function(data, status, headers, config) {

									$scope.selectProgram.availableOptions = data;
								}).error(
								function(data, status, headers, config) {
									
								});
					};
					
					$scope.getClassSubProgramList = function() {
						
						$http.get('getClassificationLevelAction').success(
								function(data, status, headers, config) {

									$scope.selectSubProgram.availableOptions = data;
								}).error(
								function(data, status, headers, config) {
									
								});
					};
					
					$scope.getClassBusinessUnitList = function() {
						
						$http.get('getClassificationLevelAction').success(
								function(data, status, headers, config) {

									$scope.selectBusinessUnit.availableOptions = data;
								}).error(
								function(data, status, headers, config) {
									
								});
					};
					
					$scope.getClassLevel4List = function() {
						
						$http.get('getClassificationLevelAction').success(
								function(data, status, headers, config) {

									$scope.selectLevel4.availableOptions = data;
								}).error(
								function(data, status, headers, config) {
									
								});
					};
					
					$scope.getClassLevel5List = function() {
						
						$http.get('getClassificationLevelAction').success(
								function(data, status, headers, config) {

									$scope.selectLevel5.availableOptions = data;
								}).error(
								function(data, status, headers, config) {
									
								});
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
						
						$scope.selectProgram.selectedOption =	$scope.getSelectNone();
						$scope.selectSubProgram.selectedOption =	$scope.getSelectNone();
						$scope.selectBusinessUnit.selectedOption =	$scope.getSelectNone();
						$scope.selectLevel4.selectedOption =	$scope.getSelectNone();
						$scope.selectLevel5.selectedOption =	$scope.getSelectNone();

					}

					$scope.changeProgram = function() {
						$scope.newClassificationlevel.program = '';
						$scope.newClassificationlevel.subProgram = '';
						$scope.newClassificationlevel.businessUnit = '';
						$scope.newClassificationlevel.level4 = '';
						$scope.newClassificationlevel.level5 = '';

						if ($scope.selectProgram.selectedOption.name == 'Añadir nuevo') {

							$scope.newClassificationlevel.program = '';

							$scope.selectSubProgram.availableOptions = $scope.getBasicSelect();
							$scope.selectSubProgram.selectedOption =	$scope.getSelectNone();

							$scope.selectBusinessUnit.availableOptions = $scope.getBasicSelect();
							$scope.selectBusinessUnit.selectedOption =	$scope.getSelectNone();

							$scope.selectLevel4.availableOptions = $scope.getBasicSelect();
							$scope.selectLevel4.selectedOption =	$scope.getSelectNone();

							$scope.selectLevel5.availableOptions = $scope.getBasicSelect();
							$scope.selectLevel5.selectedOption =	$scope.getSelectNone();
							
						} else {
							
							$scope.getClassSubProgramList();
							
							$scope.selectSubProgram.selectedOption =	$scope.getSelectNone();
							$scope.selectBusinessUnit.selectedOption =	$scope.getSelectNone();
							$scope.selectLevel4.selectedOption =	$scope.getSelectNone();
							$scope.selectLevel5.selectedOption =	$scope.getSelectNone();
							
						}

					}

					$scope.changeSubProgram = function() {
						$scope.newClassificationlevel.subProgram = '';
						$scope.newClassificationlevel.businessUnit = '';
						$scope.newClassificationlevel.level4 = '';
						$scope.newClassificationlevel.level5 = '';

						if ($scope.selectSubProgram.selectedOption.name == 'Añadir nuevo') {

							$scope.newClassificationlevel.subProgram = '';

							$scope.selectBusinessUnit.availableOptions = $scope.getBasicSelect();
							$scope.selectBusinessUnit.selectedOption =	$scope.getSelectNone();

							$scope.selectLevel4.availableOptions = $scope.getBasicSelect();
							$scope.selectLevel4.selectedOption =	$scope.getSelectNone();

							$scope.selectLevel5.availableOptions = $scope.getBasicSelect();
							$scope.selectLevel5.selectedOption = 	$scope.getSelectNone();
						
						} else {
							
							$scope.getClassBusinessUnitList();
							
							$scope.selectBusinessUnit.selectedOption =	$scope.getSelectNone();
							$scope.selectLevel4.selectedOption =	$scope.getSelectNone();
							$scope.selectLevel5.selectedOption =	$scope.getSelectNone();
						
						}
					}

					$scope.changeBusinessUnit = function() {
						$scope.newClassificationlevel.businessUnit = '';
						$scope.newClassificationlevel.level4 = '';
						$scope.newClassificationlevel.level5 = '';

						if ($scope.selectBusinessUnit.selectedOption.name == 'Añadir nuevo') {

							$scope.newClassificationlevel.businessUnit = '';

							$scope.selectLevel4.availableOptions = $scope.getBasicSelect();
							$scope.selectLevel4.selectedOption =	$scope.getSelectNone();

							$scope.selectLevel5.availableOptions = $scope.getBasicSelect();
							$scope.selectLevel5.selectedOption =	$scope.getSelectNone();
						} else {
							$scope.getClassLevel4List();

							$scope.selectLevel4.selectedOption =	$scope.getSelectNone();
							$scope.selectLevel5.selectedOption =	$scope.getSelectNone();
						}
					}

					$scope.changeLevel4 = function() {
						$scope.newClassificationlevel.level4 = '';
						$scope.newClassificationlevel.level5 = '';

						if ($scope.selectLevel4.selectedOption.name == 'Añadir nuevo') {

							$scope.newClassificationlevel.level4 = '';

							$scope.selectLevel5.availableOptions = $scope.getBasicSelect();
							$scope.selectLevel5.selectedOption =	$scope.getSelectNone();
							
						} else {
							
							$scope.getClassLevel5List();

							$scope.selectLevel5.selectedOption =	$scope.getSelectNone();
						}
					}

					$scope.changeLevel5 = function() {
						$scope.newClassificationlevel.level5 = '';
					}

					$scope.isEnabledProgram = function() {
						if ($scope.selectCompany.selectedOption != '')
							return true;
						return false;
					};

					$scope.isEnabledSubProgram = function() {
						if (!$scope.isEnabledProgram())
							return false;

						if ($scope.selectProgram.selectedOption != '') {
							if (($scope.selectProgram.selectedOption.name == 'Añadir nuevo' || $scope.selectProgram.selectedOption.name == 'Ninguno')
									&& $scope.newClassificationlevel.program == '')
								return false;
							return true;
						}
						return false;
					};

					$scope.isEnabledBusinessUnit = function() {
						if (!$scope.isEnabledSubProgram())
							return false;

						if ($scope.selectSubProgram.selectedOption != '') {
							if (($scope.selectSubProgram.selectedOption.name == 'Añadir nuevo' || $scope.selectSubProgram.selectedOption.name == 'Ninguno')
									&& $scope.newClassificationlevel.subProgram == '')
								return false;
							return true;
						}
						return false;
					};

					$scope.isEnabledLevel4 = function() {
						if (!$scope.isEnabledBusinessUnit())
							return false;

						if ($scope.selectBusinessUnit.selectedOption != '') {
							if (($scope.selectBusinessUnit.selectedOption.name == 'Añadir nuevo' || $scope.selectBusinessUnit.selectedOption.name == 'Ninguno')
									&& $scope.newClassificationlevel.businessUnit == '')
								return false;
							return true;
						}
						return false;
					};

					$scope.isEnabledLevel5 = function() {
						if (!$scope.isEnabledLevel4())
							return false;

						if ($scope.selectLevel4.selectedOption != '') {
							if (($scope.selectLevel4.selectedOption.name == 'Añadir nuevo' || $scope.selectLevel4.selectedOption.name == 'Ninguno')
									&& $scope.newClassificationlevel.level4 == '')
								return false;
							return true;
						}
						return false;
					};

					$scope.isNewProgram = function() {
						if ($scope.selectProgram.selectedOption.name == 'Añadir nuevo')
							return true;
						return false;
					};

					$scope.isNewSubProgram = function() {
						if ($scope.selectSubProgram.selectedOption.name == 'Añadir nuevo')
							return true;
						return false;
					}

					$scope.isNewBusinessUnit = function() {
						if ($scope.selectBusinessUnit.selectedOption.name == 'Añadir nuevo')
							return true;
						return false;
					}

					$scope.isNewLevel4 = function() {
						if ($scope.selectLevel4.selectedOption.name == 'Añadir nuevo')
							return true;
						return false;
					}

					$scope.isNewLevel5 = function() {
						if ($scope.selectLevel5.selectedOption.name == 'Añadir nuevo')
							return true;
						return false;
					}

					
					$scope.selectCompany = {
						availableOptions : '',
						selectedOption : ''
					};

					$scope.selectProgram = {
						availableOptions : '',
						selectedOption : ''
					};

					$scope.selectSubProgram = {
						availableOptions : '',
						selectedOption : ''
					};

					$scope.selectBusinessUnit = {
						availableOptions : '',
						selectedOption : ''
					};

					$scope.selectLevel4 = {
						availableOptions : '',
						selectedOption : ''
					};

					$scope.selectLevel5 = {
						availableOptions : '',
						selectedOption : ''
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

	.state('publication', {
		url : '/publicacion',
		templateUrl : 'templates/publication_user.html'
	})

	.state('newCampaign', {
		url : '/campañas',
		templateUrl : 'templates/newCampaign_admin.html'
	})
});
