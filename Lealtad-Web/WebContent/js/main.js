//JSON.stringify();

var transactions; 

// Budget status
var REQUEST_EDIT 		= 1;
var REQUESTED 			= 2;
var REQUEST_DENIED 		= 3;
var REQUEST_CANCELED 	= 4;
var REQUEST_APPROVED 	= 5;

// Dispersion status
var DISPERSION_REQUESTED 	= 6;
var DISPERSION_DONE 		= 7;
var DISPERSION_DENIED 		= 8;
var DISPERSION_CANCELED 	= 9;

// Report status
var REPORT_DEFAULT = 1;
var REPORT_EDIT = 2;
var REPORT_SEND = 3;
var REPORT_REJECTED = 4;
var REPORT_CANCELED = 5;
var REPORT_APPROVED = 6;

// Conciliation status
var NO_FILTER;
var RECONCILED = '1';
var NORECONCILED = '0'; 
var countPage = 10;
var countsPage = [5,25,50,100];

var CARD_HOLDER = 'CARD_HOLDER';
var SUPERVISOR = 'SUPERVISOR';

var STATUS_ON_EDIT = '998';
var STATUS_ON_PROGRESS = '999';
var SUCCESS_CODE = '1000';
var ERROR_EVENT_NAME_DUPLICATED = '1001';
var ERROR_UNKNOWN_ERROR = '2000';

var SUCCESS = 'SUCCESS';
var ENABLE = 'ENABLE';
var DISABLE = 'DISABLE';
var ERROR = 'ERROR';

var COMPANY_ENABLE = 1; 
var COMPANY_DISABLE = 0;
var IS_ENABLE = true;


// SCREENS ENUM
var MY_TRANSACTIONS_SCREEN = 0;
var MY_BUDGET_SCREEN = 1;



var appres = angular.module('resumen', ['checklist-model','ngBootstrap','chieffancypants.loadingBar', 'ngAnimate', 'ngTable']); 
appres.controller('resumenController', function($scope, $rootScope, $http, $timeout, cfpLoadingBar, NgTableParams){	


	$scope.myFullCardHolders = [];
	$scope.selectedIdCardHolderArray = [];
	

	/************************************************
	 Select All users
	 ************************************************/
	$scope.selectAllUsers = function(booleanValue){
	  checkboxes = document.getElementsByName('checkboxCardholderHome');
	  for(var i=0, n=checkboxes.length;i<n;i++) {	    
	    if(booleanValue){
		    // Case TRUE, copy whole list.
	    	if(!checkboxes[i].checked){
	    		console.log('Checkbox Added');
	    		$scope.selectedIdCardHolderArray.push($scope.myFullCardHolders[i].cardNumber);	
	    	}else{
	    		console.log('Checkbox already checked!, no added');
	    	}
		}else{
			$scope.selectedIdCardHolderArray.pop();
		}
	    checkboxes[i].checked = booleanValue;
	  }
	  
	  console.log('Tarjetas seleccionadas: ' + $scope.selectedIdCardHolderArray);
	  
	}

	
	$scope.ranges = {			
			'Este mes': [moment().startOf('month'), moment()],
			'Último Mes': [moment().subtract(1, 'month').startOf('month'), moment()],
			'Último Bimestre': [moment().subtract(2, 'month').startOf('month'), moment()],
			'Último trimestre': [moment().subtract(3, 'month').startOf('month'), moment()],
			'4 meses atras': [moment().subtract(4, 'month').startOf('month'), moment()],
		};
	$scope.message; 	
	$scope.getBalance = function() {			
		$http.get('getBalanceAction').success(
				function(data, status, headers, config) {					 
					$scope.balance = (data);  					
				}).error(function(data, status, headers, config) {
		});
	};
	
	$scope.getAverageBalance = function() {			
		$http.get('getAverageBalanceAction').success(
				function(data, status, headers, config) {		 
					$scope.balance = data;
				}).error(function(data, status, headers, config) {
		});
	};
	
	$scope.getUsersBySupervisor = function() {			
		$http.get('getUsersBySupervisorAction').success(
				function(data, status, headers, config) {					 
					if(data != null){
						$scope.usersBySupervisor = data;
						$scope.numUsers = $scope.usersBySupervisor.length;
					}
					else{
						$scope.usersBySupervisor = [{
							firstName : 'No tiene usuarios asignados'
						}];
						$scope.numUsers = 0;
					}
					
					$scope.tableUsersBySupervisor = new NgTableParams({
				        page: 1,            
				        count: 10
				    }, {
				        total: $scope.usersBySupervisor.length,					        
				        counts: [],
				        getData: function($defer, params) {
				            $defer.resolve($scope.usersBySupervisor.slice((params.page() - 1) * params.count(), params.page() * params.count()));
				        }
				    });
					
				}).error(function(data, status, headers, config) {
		});
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
				        page: 1,            
				        count: 10
				    }, {
				        total: $scope.lastTransactions.length,					        
				        counts: [],
				        getData: function($defer, params) {
				            $defer.resolve($scope.lastTransactions.slice((params.page() - 1) * params.count(), params.page() * params.count()));
				        }
				    });
					
				}).error(function(data, status, headers, config) {
		});
	};
	
	$scope.getLastTransactionSuper = function(cardArray) {			
		$http.get('getLastTransactionSuperAction?cardHolderArray='+cardArray).success(
				function(data, status, headers, config) {		 
					$scope.lastTransactionsSuper = data;
					for ( var index in data) {
						var dateFormatTransaction = moment(data[index].transactionDate, "YYYYMMDD HHmmss");
						$scope.lastTransactionsSuper[index].transactionDate = dateFormatTransaction.format("DD/MM/YYYY hh:mm a");						
					}
					$scope.tableLastTransactionsSuper = new NgTableParams({
				        page: 1,            
				        count: 10
				    }, {
				        total: $scope.lastTransactionsSuper.length,					        
				        counts: [],
				        getData: function($defer, params) {
				            $defer.resolve($scope.lastTransactionsSuper.slice((params.page() - 1) * params.count(), params.page() * params.count()));
				        }
				    });
					
				}).error(function(data, status, headers, config) {
		});
	};
	
	
	$scope.getTrxInvoicesByStatusInit = function(){
		$scope.filterDateRange = {
				startDate: moment().startOf('month'),
				endDate: moment()
			};
		$scope.getTrxInvoicesByStatus($scope.filterDateRange.startDate,$scope.filterDateRange.endDate);
	};
	
	$scope.getTrxInvoicesByStatus = function(startDate, endDate){
		var startDateFormatTrx = moment(startDate).format('YYYYMMDD');
		var endDateFormatTrx = moment(endDate).format('YYYYMMDD');
		var startDateFormatInv = moment(startDate).format('YYYYMMDDHHmmss');
		var endDateFormatInv = moment(endDate).format('YYYYMMDDHHmmss');		
		var cardNumber;
		var host =  window.location.hostname+':8080';
		d3.json("getCardNumberAction", function(json) {			
			cardNumber = json; 			
			if(cardNumber == null)
				return;	
						
			
		$http.get('http://'+host+'/Viajes-REST/rest/d3/getTransactionsByStatus/'+cardNumber
				+'/'+startDateFormatTrx+'/'+endDateFormatTrx).success
		(function(data, status, headers, config){							
				
//			d3.json('resources/json/transactions.json', function(json) {
				var transactions = [];
				var labelData;
				var countZero = 0; 
				  $.each(data.TRANSACCIONES, function(d,i){
					  
					  if(i.num == 0) countZero++; 
					  
					  if(i.transaction == 'TRANSACCIONES CONCILIADAS') 				  
						  labelData = "Conciliadas"; 				  
					  else if(i.transaction == 'TRANSACCIONES NO CONCILIADAS')				  
						  labelData = "No Conciliadas"; 			  
						  
					  transactions.push({
				        label: labelData,		
				        value: parseInt(i.num),		        
				      })
				  })
				
				  if(countZero>=2){
					  $(".transactionsTh-chart").html(
							  '<div id="morris-donut-transactions" role="alert" style="text-align: center;">'+
								'<span class="glyphicon glyphicon-exclamation-sign"'+
									'aria-hidden="true"></span>'+ 
								'<span class="sr-only">Error:</span>'+
								' No existen transacciones en este periodo'+
							'</div>'
					  );				  
					  return;
				  }
				  
				Morris.Donut({
				element: 'morris-donut-transactions',
				data: transactions,
				colors: [
				         '#F78D1D',
				         'rgba(247, 141, 29, 0.83)',             
				       ],
				resize: true
				});
		
			}).error(function(data, status, headers, config) {});
							
			$http.get('http://'+host+'/Viajes-REST/rest/d3/getInvoicesByStatus/'+cardNumber
					+'/'+startDateFormatInv+'/'+endDateFormatInv).success
			(function(data, status, headers, config){					
				
				var invoices = [];
				var labelData;
				var countZero = 0; 
				  $.each(data.INVOICES, function(d,i){
					  
					  if(i.num == 0) countZero++; 
					  
					  if(i.invoice == 'FACTURAS CONCILIADAS') 				  
						  labelData = "Conciliadas"; 				  
					  else if(i.invoice == 'FACTURAS NO CONCILIADAS')				  
						  labelData = "No Conciliadas"; 			  
						  
					  invoices.push({
				        label: labelData,		
				        value: parseInt(i.num),		        
				      })
				  })

				  if(countZero>=2){
					  $(".invoicesTh-chart").html(
							  '<div id="morris-donut-invoices" role="alert" style="text-align: center;">'+
								'<span class="glyphicon glyphicon-exclamation-sign"'+
									'aria-hidden="true"></span>'+ 
								'<span class="sr-only">Error:</span>'+
								' No existen facturas en este periodo'+
							'</div>'
					  );				  
					  return;
				  }
				  
				Morris.Donut({
				element: 'morris-donut-invoices',
				data: invoices,
				colors: [
				         '#F78D1D',
				         'rgba(247, 141, 29, 0.83)',             
				       ],
				resize: true
				});
		
			}).error(function(data, status, headers, config) {});
				
			
		});
	};
	
	$scope.initData = function(){
		
		$scope.getMyCardHoldersAction();
		$scope.selectedIdCardHolderArray = [];
		$scope.filterDateRange = {
			startDate: moment().startOf('month'),
			endDate: moment()
		};		
		$scope.updateCharts($scope.selectedIdCardHolderArray, $scope.filterDateRange);		
	};
	
	$scope.getMyCardHoldersAction = function() {
		
		// ----  get CARDHOLDERS LIST relative to this supervisor
		$http.get('getMyCardHoldersAction').success
		(function(data, status, headers, config){
			
			$scope.myFullCardHolders = data;
			
			if(data != null){
				$scope.usersBySupervisor = data;
				$scope.numUsers = $scope.usersBySupervisor.length;
			}
			else{
				$scope.usersBySupervisor = [{
					firstName : 'No tiene usuarios asignados'
				}];
				$scope.numUsers = 0;
			}
			
			$scope.tableUsersBySupervisor = new NgTableParams({
		        page: 1,            
		        count: 10
		    }, {
		        total: $scope.usersBySupervisor.length,					        
		        counts: [],
		        getData: function($defer, params) {
		            $defer.resolve($scope.usersBySupervisor.slice((params.page() - 1) * params.count(), params.page() * params.count()));
		        }
		    });
			
		}).error(function(data, status, headers, config) {});
	}
	
	$scope.updateCharts = function(cardArray, dateRange){
		var startDateFormatTrx = moment(dateRange.startDate).format('YYYYMMDD');
		var endDateFormatTrx = moment(dateRange.endDate).format('YYYYMMDD');
		var startDateFormatInv = moment(dateRange.startDate).format('YYYYMMDDHHmmss');
		var endDateFormatInv = moment(dateRange.endDate).format('YYYYMMDDHHmmss');
		$scope.lastTransactionsSuper = [];		
		console.log(cardArray, startDateFormatTrx, endDateFormatTrx, startDateFormatInv, endDateFormatInv);
		
		if(cardArray.length < 1) return;
		
		$scope.getLastTransactionSuper(cardArray);
		//get set transactions for all cardHolders		
		$http.get('getTransactionsBySuperAction?cardHolderArray='+cardArray+'&startDateFilter='+
				startDateFormatTrx+'&endDateFilter='+endDateFormatTrx).success
		(function(data, status, headers, config){			
			var transactionsSuper = JSON.parse(data);			
			console.log(JSON.stringify(transactionsSuper));
			var transactions = [];
			var labelData;
			var countZero = 0; 
			  $.each(transactionsSuper.TRANSACCIONES, function(d,i){	  	
				  
				  if(i.num == 0) countZero++;
				  
				  if(i.transaction == 'TRANSACCIONES CONCILIADAS') 				  
					  labelData = "Conciliadas"; 				  
				  else if(i.transaction == 'TRANSACCIONES NO CONCILIADAS')				  
					  labelData = "No Conciliadas"; 			  
					  
				  transactions.push({
			        label: labelData,		
			        value: parseInt(i.num),		        
			      })
			  })
			
			  if(countZero>=2){
				  $(".transactionsS-chart").html(
						  '<div id="morris-donut-transactionsS" role="alert" style="text-align: center;">'+
							'<span class="glyphicon glyphicon-exclamation-sign"'+
								'aria-hidden="true"></span>'+ 
							'<span class="sr-only">Error:</span>'+
							' No existen transacciones en este periodo'+
						'</div>'
				  );				  
				  return;
			  }			  
			  
			Morris.Donut({
			element: 'morris-donut-transactionsS',
			data: transactions,
			colors: [
			         '#F78D1D',
			         'rgba(247, 141, 29, 0.83)',             
			       ],
			resize: true
			});
			
			
		}).error(function(data, status, headers, config) {});
		
		//get set invoices for all cardHolders
		$http.get('getInvoicesBySuperAction?cardHolderArrayInv='+cardArray+'&startDateFilterInv='+
				startDateFormatInv+'&endDateFilterInv='+endDateFormatInv).success
		(function(data, status, headers, config){	
			var invoicesSuper = JSON.parse(data);
			console.log(JSON.stringify(invoicesSuper));
			var invoices = [];
			var labelData;
			var countZero = 0;
			  $.each(invoicesSuper.INVOICES, function(d,i){	
				  
				  if(i.num == 0) countZero++;
				  
				  if(i.invoice == 'FACTURAS CONCILIADAS') 				  
					  labelData = "Conciliadas"; 				  
				  else if(i.invoice == 'FACTURAS NO CONCILIADAS')				  
					  labelData = "No Conciliadas"; 			  
					  
				  invoices.push({
			        label: labelData,		
			        value: parseInt(i.num),		        
			      })
			  })

			  if(countZero>=2){
				  $(".invoicesS-chart").html(
						  '<div id="morris-donut-invoicesS" role="alert" style="text-align: center;">'+
							'<span class="glyphicon glyphicon-exclamation-sign"'+
								'aria-hidden="true"></span>'+ 
							'<span class="sr-only">Error:</span>'+
							' No existen facturas en este periodo'+
						'</div>'
				  );				  
				  return;
			  }			  
			  
			Morris.Donut({
			element: 'morris-donut-invoicesS',
			data: invoices,
			colors: [
			         '#F78D1D',
			         'rgba(247, 141, 29, 0.83)',             
			       ],
			resize: true
			});
			
		}).error(function(data, status, headers, config) {});
	}
	
	$scope.convertToPositive = function(amount){
		if(amount==undefined)
			return 0;
		if(amount<0)
			return amount*-1;
		return amount;
	};
	
	$scope.getMessage = function(){
		alert($scope.message); 
	}
	
	$scope.start = function() {
	      cfpLoadingBar.start();
	    };

	    $scope.complete = function () {
	      cfpLoadingBar.complete();
	    }


});


//XXX Checking Controller (YEN)
var appComp = angular.module('Checking', ['ngTable','checklist-model','ngBootstrap','chieffancypants.loadingBar', 'ngAnimate', 'cgNotify']); 
var budgetAmountChecked; 

appComp.controller('checkingController', function($scope, $rootScope,NgTableParams, $http,$timeout, cfpLoadingBar) {	
	
	$rootScope.REQUESTED = REQUESTED;
	$rootScope.REQUEST_DENIED = REQUEST_DENIED;
	$rootScope.REQUEST_APPROVED = REQUEST_APPROVED;
	$rootScope.DISPERSION_REQUESTED = DISPERSION_REQUESTED;
	$rootScope.REPORT_DEFAULT = REPORT_DEFAULT;
	$rootScope.REPORT_EDIT = REPORT_EDIT;
	$rootScope.REPORT_SEND = REPORT_SEND; 	
	$rootScope.REPORT_APPROVED = REPORT_APPROVED; 	
	$rootScope.REPORT_REJECTED = REPORT_REJECTED;
	$rootScope.NORECONCILED = NORECONCILED;
	$rootScope.RECONCILED = RECONCILED;
	$rootScope.REPORT_CANCELED = REPORT_CANCELED;
	$scope.commentsForBudget = '';
	
	$scope.MY_TRANSACTIONS_SCREEN = MY_TRANSACTIONS_SCREEN;
	$scope.MY_BUDGET_SCREEN = MY_BUDGET_SCREEN;

	
	$scope.setCommentForBudgetToEmpty = function(){
		$scope.commentsForBudget = null;  
	}; 
	
	$scope.commentsForBudgetIsEmpty = function() {			
		if(!$scope.commentsForBudget)		
			return true;
		else
			return false;
	};
	
	$scope.commentsForInvoiceIsEmpty = function(){		
		if(!$scope.commentsForInvoice)
			return true;
		else 
			return false;
	};
	
	$scope.budgetDateRange = {
			startDate: moment('2013-10-25'),
			endDate: moment('2013-10-27')
		};
	
	$scope.getEventsByUser = function() {
		var budgetOrReport = 1; 
		$http.get('getEventsByUserAction?budgetOrReport='+budgetOrReport).success(
				function(data, status, headers, config){						
					
					var eventReports = data;
					$scope.tableReports = new NgTableParams({
				        page: 1,            
				        count: 10
				    }, {
				        total: eventReports.length,					        
				        counts: [],
				        getData: function($defer, params) {
				            $defer.resolve(eventReports.slice((params.page() - 1) * params.count(), params.page() * params.count()));
				        }
				    });					
					
				}).error(function(data, status, headers, config) {				
			});
	};
	
	$scope.getEventsReportsByUser = function() {
		var budgetOrReport = 0; 
		$http.get('getEventsByUserAction?budgetOrReport='+budgetOrReport).success(
				function(data, status, headers, config){						
					
					var eventBudgets = data;
					$scope.tableEventBudgets = new NgTableParams({
				        page: 1,            
				        count: 10
				    }, {
				        total: eventBudgets.length,					        
				        counts: [],
				        getData: function($defer, params) {
				            $defer.resolve(eventBudgets.slice((params.page() - 1) * params.count(), params.page() * params.count()));
				        }
				    });					
					
				}).error(function(data, status, headers, config) {				
			});
	};	
	
	$scope.setEventIdSelected = function(eventId) {
		$http.get('setEventIdSelectedAction?eventIdSel='+eventId).success(
				function(data, status, header, config){					
				}).error(function(data, status, headers, config){			
		});
	};	
	
	$scope.setEventDetailsSelected = function(eventIdSelected, eventAmountSelected, eventDescriptionSelection,reports){				
		$scope.eventAmountSelected = eventAmountSelected; 
		$scope.eventDescriptionSelection = eventDescriptionSelection;		
		$scope.usersBudgets = reports;		
		$scope.tableUsersBudgets = new NgTableParams({
	        page: 1,            
	        count: 10
	    }, {
	        total: $scope.usersBudgets.length,
	        counts: [],
	        getData: function($defer, params) {
	            $defer.resolve($scope.usersBudgets.slice((params.page() - 1) * params.count(), params.page() * params.count()));
	        }
	    });		
		
	}; 
	
	$scope.getAmountCheckedApprovedTotal = function(){
		//cambiar el valor 10, por el campo de propina de la factura
		var amountTotalChecked = 0;
		if($scope.usersBudgets==undefined)
			return amountTotalChecked; 
		
		for (var i = 0;  i < $scope.usersBudgets.length; i++) {
			var userBudget = $scope.usersBudgets[i];		
			if(userBudget.reportStatus == REPORT_APPROVED && userBudget.checkedAmount != undefined){
				amountTotalChecked += userBudget.checkedAmount; 
			}
		}
		return amountTotalChecked; 
	}
	
	$scope.getAmountApprovedTotal = function(){
		//cambiar el valor 10, por el campo de propina de la factura
		var amountTotalChecked = 0;		
		if($scope.usersBudgets==undefined)
			return amountTotalChecked; 
		
		for (var i = 0;  i < $scope.usersBudgets.length; i++) {
			var userBudget = $scope.usersBudgets[i];			
			if(userBudget.approvedRequestAmount)
				amountTotalChecked += userBudget.approvedRequestAmount; 			
		}
		return amountTotalChecked; 
	}	
	
	$scope.getBudgetsByCardNumber = function() {			
		$http.get('getbudgetsByCardNumberAction').success(
			function(data, status, headers, config){						
				var budgets = [];
				var reports = [];
				var i = 0;
				var j = 0;
				
				for ( var index in data) {		
					
//					if(data[index].status >= REQUEST_APPROVED){
//						if(data[index].reportStatus >= REPORT_EDIT && data[index].reportStatus <= REPORT_APPROVED){						
//							reports[j] = data[index];
//							j++;
//						}
//					}
					
					if(data[index].reportStatus != REPORT_DEFAULT){						
						reports[j] = data[index];
						j++;
					}
					
					
					if(data[index].status >= REQUESTED  && data[index].status <= REQUEST_APPROVED ){						
						budgets[i] = data[index];
						i++;
					}

				}
				
				$scope.tableBudgets = new NgTableParams({
			        page: 1,            
			        count: 10
			    }, {
			        total: budgets.length,			        
			        counts: [],			        
			        getData: function($defer, params) {
			            $defer.resolve(budgets.slice((params.page() - 1) * params.count(), params.page() * params.count()));
			        }
			    });
				
				$scope.tableReports = new NgTableParams({
			        page: 1,            
			        count: 10
			    }, {
			        total: reports.length,			        
			        counts: [],			        
			        getData: function($defer, params) {
			            $defer.resolve(reports.slice((params.page() - 1) * params.count(), params.page() * params.count()));
			        }
			    });
				
			}).error(function(data, status, headers, config) {				
		});
	};
	$scope.getTransactionsByBudget = function() {
				
		$http.get('getTransactionsByBudgetAction').success(
				function(data, status, headers, config){																	
					transactions = data;
					for (var i = 0; i < data.length; i++) {
						var dateFormatTransaction = moment(data[i].date, "YYYYMMDD");
						transactions[i].date = dateFormatTransaction.format("DD/MM/YYYY");
						transactions[i].amountChecked = "0";
						if(data[i].invoiceList == undefined){							
							continue; 
						}
						for (var j = 0; j < data[i].invoiceList.length; j++) {							
							var dateFormatInvoice = moment(data[i].invoiceList[j].invoiceDate, "YYYYMMDDHHmmss");
							transactions[i].invoiceList[j].invoiceDate = dateFormatInvoice.format("DD/MM/YYYY h:mm a");
							transactions[i].amountChecked = parseFloat(transactions[i].amountChecked) + parseFloat(transactions[i].invoiceList[j].totalAmount || transactions[i].invoiceList[j].amount);
						}
					}
					$rootScope.tableTransactions = new NgTableParams({
				        page: 1,            
				        count: 10
				    }, {
				        total: transactions.length,
				        counts: [],
				        getData: function($defer, params) {						        	
				        	params.total(transactions.length);
				            $defer.resolve(transactions.slice((params.page() - 1) * params.count(), params.page() * params.count()));
				        }
				    });
				}).error(function(data, status, headers, config) {				
		});
		

	}; 
	
	$scope.setBudgetIdSelected = function(budgetIdSelected, cardNumberSelected, userNameSelected) {
		$http.get('setBudgetIdSelectedAction?budgetSelectedId=' + budgetIdSelected+'&cardNumberSelected='+cardNumberSelected+'&userNameSelected='+userNameSelected).success(
				function(data, status, header, config){					
				}).error(function(data, status, headers, config){			
		});
	};
	

	$scope.setOnlyBudgetIdSelected = function(budgetIdSelected) {
		$http.get('setBudgetIdSelectedAction?budgetSelectedId=' + budgetIdSelected).success(
				function(data, status, header, config){					
				}).error(function(data, status, headers, config){			
		});
	}; 
	
	
	$scope.getBudgetDetailsSelected = function() {		
		$http.get('getBudgetDetailsSelectedAction').success(
				function(data, status, header, config){						
					$rootScope.budgetSelected = data;					
				}).error(function(data, status, headers, config){						
		});		
	}; 	
	
	$scope.setTransactionIdToRemove = function(transactionIdRemove, amountCheckedTransaction) {
		$scope.transactionIdtoRemove = transactionIdRemove;
		$scope.amountCheckedTransaction = amountCheckedTransaction;
	};	
	
	$scope.removeTransaccion = function() {
		var newBudgetAmountChecked = parseFloat(budgetAmountChecked) - parseFloat($scope.amountCheckedTransaction);
		if(newBudgetAmountChecked < 0) newBudgetAmountChecked = 0;
		$http.get('removeTransactionBudgetAction?transactionIdToRemove='+$scope.transactionIdtoRemove+'&newBudgetAmountChecked='+newBudgetAmountChecked).success(
				function(data, status, header, config){	
					transactions = data;
					for (var i = 0; i < data.length; i++) {
						var dateFormatTransaction = moment(data[i].date, "YYYYMMDD");
						transactions[i].date = dateFormatTransaction.format("DD/MM/YYYY");
						transactions[i].amountChecked = "0";
						if(data[i].invoiceList == undefined){							
							continue; 
						}
						for (var j = 0; j < data[i].invoiceList.length; j++) {							
							var dateFormatInvoice = moment(data[i].invoiceList[j].invoiceDate, "YYYYMMDDHHmmss");
							transactions[i].invoiceList[j].invoiceDate = dateFormatInvoice.format("DD/MM/YYYY h:mm a");
							transactions[i].amountChecked = parseFloat(transactions[i].amountChecked) + parseFloat(transactions[i].invoiceList[j].totalAmount || transactions[i].invoiceList[j].amount);
						}
					}
					$rootScope.tableTransactions.reload();
				}).error(function(data, status, headers, config){			
		});	
		$rootScope.tableTransactions = new NgTableParams({
	        page: 1,
	        count: 10
	    }, {
	        total: transactions.length,	 
	        counts: [],
	        getData: function($defer, params) {		        	
	        	params.total(transactions.length);		        	
	            $defer.resolve(transactions.slice((params.page() - 1) * params.count(), params.page() * params.count()));
	        }
	    });
		$rootScope.getTotalAmountChecked();
		console.log('new budget amount checked: ['+budgetAmountChecked+']'); 
		$http.get('updateBudgetAmountCheckedAction?newBudgetAmountChecked='+budgetAmountChecked).success(
				function(data, status, header, config){	
				}).error(function(data, status, headers, config) {});
	};		
	
	$scope.setTransactionIdToReject = function(transactionIdReject){
		$scope.transactionIdToReject = transactionIdReject; 	
		$scope.commentsForInvoice = null; 
	}
	
	$scope.rejectATransaction = function(rejectComment){
		$http.get('rejectATransactionAction?transactionIdToReject='+$scope.transactionIdToReject+'&rejectComment='+rejectComment).success(				
				function(data, status, headers, config){												
					transactions = data;
					for (var i = 0; i < data.length; i++) {
						var dateFormatTransaction = moment(data[i].date, "YYYYMMDD");
						transactions[i].date = dateFormatTransaction.format("DD/MM/YYYY");
						transactions[i].amountChecked = "0";
						if(data[i].invoiceList == undefined){							
							continue; 
						}
						for (var j = 0; j < data[i].invoiceList.length; j++) {							
							var dateFormatInvoice = moment(data[i].invoiceList[j].invoiceDate, "YYYYMMDDHHmmss");
							transactions[i].invoiceList[j].invoiceDate = dateFormatInvoice.format("DD/MM/YYYY h:mm a");
							transactions[i].amountChecked = parseFloat(transactions[i].amountChecked) + parseFloat(transactions[i].invoiceList[j].totalAmount || transactions[i].invoiceList[j].amount);
						}
					}
					$rootScope.tableTransactions.reload();
					$rootScope.transactionsSelected = {
							transaction: []
						};
				}).error(function(data, status, headers, config) {				
			});
		$rootScope.tableTransactions = new NgTableParams({
	        page: 1,
	        count: 10
	    }, {
	        total: transactions.length,
	        counts: [],
	        getData: function($defer, params) {	
	        	
	        	params.total(transactions.length);		        	
	            $defer.resolve(transactions.slice((params.page() - 1) * params.count(), params.page() * params.count()));
	        }
	    });
		
		$rootScope.getTotalAmountChecked();
		console.log('new budget amount checked: ['+budgetAmountChecked+']'); 
		$http.get('updateBudgetAmountCheckedAction?newBudgetAmountChecked='+budgetAmountChecked).success(
				function(data, status, header, config){	
				}).error(function(data, status, headers, config) {});			
	}; 
	
	$scope.changeBudgetStatus = function(commentForBudget, newBudgetStatusSelected) {
		console.log('comentario: '+commentForBudget+' - Nuevo Estatus: '+newBudgetStatusSelected); 
		console.log('lista de transacciones cuando se envia presupuesto: '+JSON.stringify($rootScope.tableTransactions));
		var transactionIds = [];
		if(newBudgetStatusSelected==REPORT_SEND){
			for (var int = 0; int < $rootScope.tableTransactions.data.length; int++){
				console.log('transaccion limpiada: '+JSON.stringify($rootScope.tableTransactions.data[int]));
				transactionIds[int] = $rootScope.tableTransactions.data[int].trxHbaseId;
			}
		}
		
		console.log('Transacciones a limpiar = '+transactionIds); 
		$http.get('changeBudgetStatusAction?&newBudgetStatus='+newBudgetStatusSelected+'&budgetComment='+commentForBudget+'&transactionIds='+transactionIds).success(				
				function(data, status, header, config){						
					$rootScope.budgetSelected = data;
					$rootScope.tableTransactions.reload();
					$scope.getTransactionsByBudget();
				}).error(function(data, status, headers, config){			
		});

		
	};	
	
	$scope.getTransactionsNoBudgetBetweenDates = function(startDateBudget, endDateBudget) {						
				
		$http.get('getTransactionsNoBudgetBetweenDatesAction?startDateBudget='+startDateBudget+'&endDateBudget='+endDateBudget).success(				
				function(data, status, headers, config){																										
					$scope.budgetDateRange.startDate = moment($rootScope.budgetSelected.startDate); 
					$scope.budgetDateRange.endDate = moment($rootScope.budgetSelected.endDate);					
					var transactionsNoBudget = data;	
					console.log('TRANSACTIONS ENTRE FECHAS: '+JSON.stringify(data));				
					
					for (var i = 0; i < data.length; i++) {
						var dateFormatTransaction = moment(data[i].date, "YYYYMMDD");
						transactionsNoBudget[i].date = dateFormatTransaction.format("DD/MM/YYYY");
						transactionsNoBudget[i].amountChecked = "0";
						if(data[i].invoiceList == undefined){
							continue; 
						}
						for (var j = 0; j < data[i].invoiceList.length; j++) {							
							var dateFormatInvoice = moment(data[i].invoiceList[j].invoiceDate, "YYYYMMDDHHmmss");
							transactionsNoBudget[i].invoiceList[j].invoiceDate = dateFormatInvoice.format("DD/MM/YYYY h:mm a");
							transactionsNoBudget[i].amountChecked = parseFloat(transactionsNoBudget[i].amountChecked) + parseFloat(transactionsNoBudget[i].invoiceList[j].totalAmount || transactionsNoBudget[i].invoiceList[j].amount);
						}
					}
					
					$rootScope.transactionsSelected = {
						transaction: []		
					}; 					
					
					$scope.tableTransactionsNoBudget = new NgTableParams({
				        page: 1,            
				        count: 10
				    }, {
				        total: transactionsNoBudget.length,
				        counts: [],
				        getData: function($defer, params) {
				        	params.total(transactionsNoBudget.length);	
				            $defer.resolve(transactionsNoBudget.slice((params.page() - 1) * params.count(), params.page() * params.count()));
				        }
				    });
					
				}).error(function(data, status, headers, config) {			
			});
		
	}; 
	$scope.getTransactionsBetweenDates = function(startDate, endDate){		
		var startDateFormat = moment(startDate).format('DD/MM/YYYY');
		var endDateFormat = moment(endDate).format('DD/MM/YYYY');		
		$http.get('getTransactionsNoBudgetBetweenDatesAction?startDateBudget='+startDateFormat+'&endDateBudget='+endDateFormat).success(				
				function(data, status, headers, config){								
					var transactionsNoBudget = data;
					
					for (var i = 0; i < data.length; i++) {
						var dateFormatTransaction = moment(data[i].date, "YYYYMMDD");
						transactionsNoBudget[i].date = dateFormatTransaction.format("DD/MM/YYYY");
						transactionsNoBudget[i].amountChecked = "0";
						if(data[i].invoiceList == undefined){
							continue; 
						}
						for (var j = 0; j < data[i].invoiceList.length; j++) {							
							var dateFormatInvoice = moment(data[i].invoiceList[j].invoiceDate, "YYYYMMDDHHmmss");
							transactionsNoBudget[i].invoiceList[j].invoiceDate = dateFormatInvoice.format("DD/MM/YYYY h:mm a");
							transactionsNoBudget[i].amountChecked = parseFloat(transactionsNoBudget[i].amountChecked) + parseFloat(transactionsNoBudget[i].invoiceList[j].totalAmount || transactionsNoBudget[i].invoiceList[j].amount);
						}
					}
					
					$rootScope.transactionsSelected = {
						transaction: []		
					}; 
					$scope.tableTransactionsNoBudget.reload();
					
					$scope.tableTransactionsNoBudget = new NgTableParams({
				        page: 1,            
				        count: 10
				    }, {
				        total: transactionsNoBudget.length,
				        counts: [],
				        getData: function($defer, params) {
				        	params.total(transactionsNoBudget.length);	
				            $defer.resolve(transactionsNoBudget.slice((params.page() - 1) * params.count(), params.page() * params.count()));
				        }
				    });	
					
				}).error(function(data, status, headers, config) {			
			});
		
		
	};
	
	$scope.setTransactionCommentSelected = function(transactionComment){		
		$scope.transactionCommentSelected = transactionComment; 
	}; 	

	$scope.isAmountMax = function(invoices, transactionAmount){
		var invoicesAmount = 0;	
		if(invoices==undefined){
			return true; 
		}
			
		for (var i = 0; i < invoices.length; i++) {
			invoicesAmount += Number(invoices[i].amount); 
		}
		if(invoicesAmount>=transactionAmount){			
			return false;
		}		
		return true;
	}; 
	
	$rootScope.getTotalAmountChecked = function(){		
		if(transactions==undefined){
			budgetAmountChecked = 0;
			return 0;			
		}
		
	    var total = 0;	    	    
	    for(var i = 0; i < transactions.length; i++){
	        var transaction = transactions[i];
	        if(transaction.amountChecked == undefined || (transaction.comment!=undefined && transaction.comment))
	        	total += 0; 
	        else
	        	total += Number(transaction.amountChecked); 
	    }	    
	    budgetAmountChecked = total; 
	    return total;
	};
	
	$scope.enableDisable = function(budgetStatusSelected){			
		if(budgetStatusSelected == undefined)
			return false;
		
		if(budgetStatusSelected== $rootScope.REPORT_APPROVED || budgetStatusSelected == $rootScope.REPORT_SEND)
			return true; 
		if(budgetStatusSelected == $rootScope.REPORT_REJECTED || budgetStatusSelected == $rootScope.REPORT_EDIT)
			return false;
	};
	
	$scope.getTotalApprovedAmount = function(amount){
		if(!amount || amount == undefined)
			return 0; 
		return amount;
	};	
});

// XXX Conciliation Controller (YEN)
appComp.controller('conciliacionController', function($scope,$rootScope, NgTableParams, $http, notify) {
	
	$rootScope.REQUESTED = REQUESTED;
	$rootScope.REQUEST_DENIED = REQUEST_DENIED;
	$rootScope.REQUEST_APPROVED = REQUEST_APPROVED;
	$rootScope.DISPERSION_REQUESTED = DISPERSION_REQUESTED;
	$rootScope.REPORT_EDIT = REPORT_EDIT;
	$rootScope.REPORT_SEND = REPORT_SEND; 	
	$rootScope.REPORT_APPROVED = REPORT_APPROVED; 	
	$rootScope.REPORT_REJECTED = REPORT_REJECTED;
	$rootScope.REPORT_CANCELED = REPORT_CANCELED;
	$rootScope.RECONCILED = RECONCILED;
	$rootScope.NORECONCILED = NORECONCILED;
	$scope.comments;
	$scope.invoicesNoTransaction = '';
	$scope.isTipMax = false;
	$scope.isTipTicketMax = false;
	$scope.invoiceDateRange = {
			startDate: moment(),
			endDate: moment()
		};
	
	
	

	/************************************************
	 
	 ************************************************/
	$scope.refreshTransactionsOnBudget = function(){
		//ejecución si se viene de la pantalla de comprobación.
		$rootScope.tableTransactions.reload();
		$scope.getTransactionsByBudget();	 					 				
		$rootScope.getTotalAmountChecked();	 				
		console.log('new budget amount checked: ['+budgetAmountChecked+']'); 
		$http.get('updateBudgetAmountCheckedAction?newBudgetAmountChecked='+budgetAmountChecked).success(
				function(data, status, header, config){	
				}).error(function(data, status, headers, config) {});	
		
	};
	
	
	/************************************************
	 
	 ************************************************/
	$scope.refreshTransactionsTable = function(screen){
		
		console.log("Generica de reload table: " +  screen);
		
		if(screen == MY_TRANSACTIONS_SCREEN){
			console.log("screen == MY_TRANSACTIONS_SCREEN");
			$rootScope.getMyTransactionsByPeriod();
		}
		
		if(screen == MY_BUDGET_SCREEN){
			console.log("screen == MY_BUDGET_SCREEN");
			$scope.refreshTransactionsOnBudget();
		}
		
	};
	
	$rootScope.addTransactionsToBudget = function() {
		var transactionIds = []; 
		for (var int = 0; int < $rootScope.transactionsSelected.transaction.length; int++) {			
			transactionIds[int] = $rootScope.transactionsSelected.transaction[int].trxHbaseId;
			budgetAmountChecked += (parseFloat($rootScope.transactionsSelected.transaction[int].amountChecked) || 0); 
		}		
		$http.get('addTransactionsToBudgetAction?transactionsSelected='+transactionIds+'&newBudgetAmountChecked='+budgetAmountChecked).success(				
				function(data, status, headers, config){												
					transactions = data;
					for (var i = 0; i < data.length; i++) {
						var dateFormatTransaction = moment(data[i].date, "YYYYMMDD");
						transactions[i].date = dateFormatTransaction.format("DD/MM/YYYY");
						transactions[i].amountChecked = "0";
						if(data[i].invoiceList == undefined){							
							continue; 
						}
						for (var j = 0; j < data[i].invoiceList.length; j++) {							
							var dateFormatInvoice = moment(data[i].invoiceList[j].invoiceDate, "YYYYMMDDHHmmss");
							transactions[i].invoiceList[j].invoiceDate = dateFormatInvoice.format("DD/MM/YYYY h:mm a");
							transactions[i].amountChecked = parseFloat(transactions[i].amountChecked) + parseFloat(transactions[i].invoiceList[j].totalAmount || transactions[i].invoiceList[j].amount);
						}
					}
					$rootScope.tableTransactions.reload();
					$rootScope.transactionsSelected = {
							transaction: []							
						};
				}).error(function(data, status, headers, config) {				
			});
		$rootScope.tableTransactions = new NgTableParams({
	        page: 1,
	        count: 10
	    }, {
	        total: transactions.length,
	        counts: [],
	        getData: function($defer, params) {	
	        	
	        	params.total(transactions.length);		        	
	            $defer.resolve(transactions.slice((params.page() - 1) * params.count(), params.page() * params.count()));
	        }
	    });
		$rootScope.getTotalAmountChecked();
		console.log('new budget amount checked: ['+budgetAmountChecked+']'); 
		$http.get('updateBudgetAmountCheckedAction?newBudgetAmountChecked='+budgetAmountChecked).success(
				function(data, status, header, config){	
				}).error(function(data, status, headers, config) {});		
	};
	
	$rootScope.getInvoiceDetails = function(invoiceId, transactionIdSelected, transactionCheckedAmount, transactionAmount, disassociateInvoiceBool) {																	
		$rootScope.transactionIdSelected = transactionIdSelected;
		$rootScope.transactionCheckedAmount = (transactionCheckedAmount || 0); 		
		$rootScope.disassociateInvoiceBool = disassociateInvoiceBool;
		$rootScope.transactionAmountOrig = transactionAmount;
				
		$http.get('getInvoiceWithAttachmentsAction?invoiceId='+invoiceId).success(
				function(data, status, header, config){					
					
					var invoiceAttachment = data;
					var dateFormatInvoice = moment(invoiceAttachment.invoiceDate, "YYYYMMDDhhmmss");					
					invoiceAttachment.invoiceDate = dateFormatInvoice.format("DD/MM/YYYY h:mm a"); 
					console.log("invoice attachment: "+JSON.stringify(invoiceAttachment));
					$rootScope.invoiceSelected = invoiceAttachment;
					
				}).error(function(data, status, headers, config) {});
		
		
		
		
	}; 
//	cambiar el invoiceAmountCheckedSelected por el monto total de la factura(amountCkecked + propina)
	$rootScope.disassociateInvoice = function(invoiceIdSelected, invoiceTotalAmountSelected, invoiceTotalAmount){		
		var newTransactionAmountChecked = parseFloat($rootScope.transactionCheckedAmount - invoiceTotalAmountSelected); 
		var newBudgetCheckedAmount = parseFloat(budgetAmountChecked) - parseFloat(invoiceTotalAmountSelected);
		if(newBudgetCheckedAmount < 0) newBudgetCheckedAmount = 0;
		
		 var flagConciliation; 
		 if(newTransactionAmountChecked >= $rootScope.transactionAmountOrig)
			 flagConciliation = "1";			 		 
		 else
			 flagConciliation = "0";
		
		$http.get('disassociateInvoiceAction?NoReconcInvoiceIdSelected='+invoiceIdSelected+'&noReconcTransactionIdSelected='+$rootScope.transactionIdSelected+
				'&noReconcNewTransactionAmountChecked='+newTransactionAmountChecked+'&noReconcInvoiceTotalAmount='+invoiceTotalAmount+
				'&newBudgetAmountChecked='+newBudgetCheckedAmount+'&flagConciliation='+flagConciliation).success(				
				function(data, status, header, config){
					$scope.refreshTransactionsTable($scope.screen);
				}).error(function(data, status, headers, config){});			

	};
	
//	$scope.getInvoicesBetweenDates = function(startDate, endDate,viewInvoiceOtherUsers){
//		var startDateFormat = moment(startDate).format('DD/MM/YYYY');
//		var endDateFormat = moment(endDate).format('DD/MM/YYYY');
//		$scope.invoiceIdSelected = undefined; 
//		$scope.comments = '';
//		
//		$http.get('getInvoicesNoBudgetBetweenDatesAction?transactionStartDate='+startDateFormat+'&transactionEndDate='+endDateFormat).success(
//				function(data, status, headers, config){																
//					$scope.invoicesNoTransaction = data;
//					for (var i = 0; i < data.length; i++) {						
//						var dateFormatInvoice = moment(data[i].invoiceDate, "YYYYMMDDHHmmss");
//						$scope.invoicesNoTransaction[i].invoiceDate = dateFormatInvoice.format("DD/MM/YYYY h:mm a");
//					}
//					$scope.tableInvoicesNoBudget.reload();
//					$rootScope.tableInvoicesNoBudget= new NgTableParams({
//				        page: 1,            
//				        count: 10
//				    }, {
//				        total: $scope.invoicesNoTransaction.length,
//				        counts: ($scope.invoicesNoTransaction.length>countPage) ? countsPage : [],
//				        getData: function($defer, params) {
//				        	
//				        	params.total($scope.invoicesNoTransaction.length);
//				            $defer.resolve($scope.invoicesNoTransaction.slice((params.page() - 1) * params.count(), params.page() * params.count()));
//				        }
//				    });	
//					$rootScope.tableInvoicesNoBudget.reload();
//				}).error(function(data, status, headers, config) {				
//			});	
//		
//		if(viewInvoiceOtherUsers){
//		$http.get('getInvoicesNoTransBetweenDatesOtherUsersAction?budgetStartDate='+$scope.transactionStartDate+'&budgetEndDate='+$scope.transactionEndDate).success(
//				function(data, status, headers, config){																
//					$scope.invoicesNoTransactionOtherUser = data;
//					for (var i = 0; i < data.length; i++) {						
//						var dateFormatInvoice = moment(data[i].invoiceDate, "YYYYMMDDHHmmss");
//						$scope.invoicesNoTransactionOtherUser[i].invoiceDate = dateFormatInvoice.format("DD/MM/YYYY h:mm a");
//					}
//					$scope.tableInvoicesNoTransactionOtherUsers.reload();
//					$rootScope.tableInvoicesNoTransactionOtherUsers= new NgTableParams({
//				        page: 1,            
//				        count: 10
//				    }, {
//				        total: $scope.invoicesNoTransactionOtherUser.length,
//				        counts: ($scope.invoicesNoTransactionOtherUser.length>countPage) ? countsPage : [],
//				        getData: function($defer, params) {
//				        	
//				        	params.total($scope.invoicesNoTransactionOtherUser.length);
//				            $defer.resolve($scope.invoicesNoTransactionOtherUser.slice((params.page() - 1) * params.count(), params.page() * params.count()));
//				        }
//				    });	
//					$rootScope.tableInvoicesNoTransactionOtherUsers.reload();
//				}).error(function(data, status, headers, config) {				
//			});
//		}
//		
//		
//	
//		
//		
//	}
	
	$rootScope.getInvoicesNoTransaction = function(transaction,transactionId,transactionAmountChecked,screen,
			transactionStartDate, transactionEndDate) {
				
		console.log('Input Level#1 screen: ' + screen);
		$scope.screen = angular.copy(screen);
		$scope.transactionId = transactionId;
		$scope.transactionAmountChecked = (transactionAmountChecked || 0); 		
		$scope.transactionStartDate = transactionStartDate || moment().format('DD/MM/YYYY');
		$scope.transactionEndDate = transactionEndDate || moment().format('DD/MM/YYYY'); 	
		$scope.invoiceIdSelected = undefined; 
		$scope.comments = '';
		if(transactionStartDate){
			$scope.invoiceDateRange.startDate = moment($rootScope.budgetSelected.startDate); 
			$scope.invoiceDateRange.endDate = moment($rootScope.budgetSelected.endDate);
		}else{
			$scope.invoiceDateRange.startDate = moment(); 
			$scope.invoiceDateRange.endDate = moment();
		}
		$scope.transactionAmount = transaction.amount;
			
		
		console.log("monto transaccion comprobado: "+$scope.transactionAmountChecked);
		var transactionSend = angular.copy(transaction);
		
		delete transactionSend["$$hashKey"];
		for ( var index in transactionSend.invoiceList) 
			delete transaction.invoiceList[index]["$$hashKey"];
		
		var dateFormatTransaction = moment(transactionSend.date, "DD/MM/YYYY");				
		transactionSend.date = dateFormatTransaction.format("YYYYMMDD");
		
		console.log("fecha 1a : "+$scope.transactionStartDate);
		console.log("fecha 1b : "+$scope.transactionEndDate);
		
		$http.get('getInvoicesNoBudgetBetweenDatesAction?transactionStartDate='+$scope.transactionStartDate+'&transactionEndDate='+$scope.transactionEndDate+'&transaction='+JSON.stringify(transactionSend)).success(
				function(data, status, headers, config){																
					$scope.invoicesNoTransaction = data;
					
					var transactionSugg = [];
					var contSugg = 0; 					
					var transactionMore = [];
					var contMore = 0;
					$scope.thereInvoicesSugguested = false;
					$scope.thereMoreInvoices = false;
					
					for (var i = 0; i < data.length; i++) {						
						var dateFormatInvoice = moment(data[i].invoiceDate, "YYYYMMDDHHmmss");
						$scope.invoicesNoTransaction[i].invoiceDate = dateFormatInvoice.format("DD/MM/YYYY h:mm a");
						if($scope.invoicesNoTransaction[i].suggested == true){
							transactionSugg[contSugg] = $scope.invoicesNoTransaction[i];
							contSugg++;							
						}
						else{
							transactionMore[contMore] = $scope.invoicesNoTransaction[i];
							contMore++;
						}
							
					}
					
					if(transactionSugg.length>0)
						$scope.thereInvoicesSugguested = true;
					
					if(transactionMore.length>0)
						$scope.thereMoreInvoices = true;
					
					$rootScope.tableInvoicesNoBudget= new NgTableParams({
				        page: 1,            
				        count: 10
				    }, {
				        total: transactionSugg.length,
				        counts: [],
				        getData: function($defer, params) {
				        	
				        	params.total(transactionSugg.length);
				            $defer.resolve(transactionSugg.slice((params.page() - 1) * params.count(), params.page() * params.count()));
				        }
				    });
					
					$rootScope.tableMoreInvoicesNoBudget= new NgTableParams({
				        page: 1,            
				        count: 10
				    }, {
				        total: transactionMore.length,
				        counts: [],
				        getData: function($defer, params) {
				        	
				        	params.total(transactionMore.length);
				            $defer.resolve(transactionMore.slice((params.page() - 1) * params.count(), params.page() * params.count()));
				        }
				    });
					
					$rootScope.tableInvoicesNoBudget.reload();
					
					$http.get('getTipByClientAction').success(
						function(data, status, headers, config){
							if(data == null || data == undefined)
								$scope.tip = 0;
							else
								$scope.tip = parseFloat(data) / 100;
							$scope.isTipMax = false;
							$scope.isTipTicketMax = false;
					}).error(function(data, status, headers, config) {				
					});	
					
				}).error(function(data, status, headers, config) {				
			});			
		
	};	
	
	$rootScope.getInvoicesNoTransactionOtherUsers = function(startDate,endDate){
		console.log('buscando de otros usuarios');
		$http.get('getInvoicesNoTransBetweenDatesOtherUsersAction?budgetStartDate='+(moment(startDate).format('DD/MM/YYYY'))+'&budgetEndDate='+(moment(endDate).format('DD/MM/YYYY'))).success(
				function(data, status, headers, config){																
					$scope.invoicesNoTransactionOtherUser = data;
					for (var i = 0; i < data.length; i++) {						
						var dateFormatInvoice = moment(data[i].invoiceDate, "YYYYMMDDHHmmss");
						$scope.invoicesNoTransactionOtherUser[i].invoiceDate = dateFormatInvoice.format("DD/MM/YYYY h:mm a");
					}
					$rootScope.tableInvoicesNoTransactionOtherUsers= new NgTableParams({
				        page: 1,            
				        count: 10
				    }, {
				        total: $scope.invoicesNoTransactionOtherUser.length,
				        counts: [],
				        getData: function($defer, params) {
				        	
				        	params.total($scope.invoicesNoTransactionOtherUser.length);
				            $defer.resolve($scope.invoicesNoTransactionOtherUser.slice((params.page() - 1) * params.count(), params.page() * params.count()));
				        }
				    });	
					$rootScope.tableInvoicesNoTransactionOtherUsers.reload();
				}).error(function(data, status, headers, config) {				
			});
	}; 

	
	$scope.setInvoiceIdSelected = function(invoiceIdSelected,tip,amount) {
		$scope.invoiceIdSelected = invoiceIdSelected;
		$scope.invoiceTip = tip;
		$scope.getAmountTotalInvoice(amount,tip,invoiceIdSelected);
	};
	
	$scope.reconcileInvoiceSelected = function() {				
		var newTransactionAmountChecked; 				
		var transactionUserSelected = false; 
		var reconciliationTip; 
		var reconciliationTotalAmount; 
		//cambiar el valor 10, por el campo de propina de la factura
		for (var i = 0;  i < $scope.invoicesNoTransaction.length; i++) {
			var invoice = $scope.invoicesNoTransaction[i];		
			if(invoice.invoiceId == $scope.invoiceIdSelected){
				transactionUserSelected = true;				
				reconciliationTip = (invoice.tip || 0);
				reconciliationTotalAmount = parseFloat(invoice.amount) + parseFloat(reconciliationTip); 				
			}
		}
		if(!transactionUserSelected){
			for (var i = 0;  i < $scope.invoicesNoTransactionOtherUser.length; i++) {
				var invoice = $scope.invoicesNoTransactionOtherUser[i];
				if(invoice.invoiceId == $scope.invoiceIdSelected){
					reconciliationTip = (invoice.tip || 0);
					reconciliationTotalAmount = parseFloat(invoice.amount) + parseFloat(reconciliationTip); 
					
				}
			}
		}
		newTransactionAmountChecked = parseFloat($scope.transactionAmountChecked) + parseFloat(reconciliationTotalAmount);
		 var newbudgetAmountChecked = parseFloat(budgetAmountChecked) + parseFloat(reconciliationTotalAmount);
		 var flagConciliation; 
		 if(newTransactionAmountChecked >= $scope.transactionAmount)
			 flagConciliation = "1";			 		 
		 else
			 flagConciliation = "0";
		 
	 	$http.get('reconcileInvoiceSelectedAction?reconcileTransactionId='+$scope.transactionId+'&reconcileInvoiceId='+
	 			$scope.invoiceIdSelected+'&newTransactionAmountChecked='+newTransactionAmountChecked+'&reconciliationComment='+$scope.comments+
	 			'&reconciliationTip='+reconciliationTip+'&reconciliationTotalAmount='+reconciliationTotalAmount+'&newBudgetAmountChecked='+newbudgetAmountChecked+
	 			'&flagConciliation='+flagConciliation).success(
	 			function(data,status, header, config) {
	 				$scope.refreshTransactionsTable($scope.screen);
				}).error(function(data,status,header,config){});
	 				 			
	}; 
	
	
	$scope.radioIsCheck = function() {		
		if($scope.invoiceIdSelected == undefined || $scope.invoiceIdSelected == null){			
			return true;
		}
		else {	
			return false;
		} 
	}; 
	
	$scope.commentsIsEmpty = function() {				
		if(!$scope.comments)		
			return true;
		else
			return false;
	};
	
	$scope.getAmountTotalInvoice = function(amount,propina,invoiceIdsel){
		$scope.invoiceTip = propina;
		var MaxTip = parseFloat(amount) + (parseFloat(amount) * $scope.tip);
		var newInvoiceTotalAmount; 				
		//console.log('datosss: '+amount+' '+$scope.invoiceTip+' '+invoiceIdsel+ ' '+ $scope.invoiceIdSelected)
		if($scope.invoiceTip == undefined)
			newInvoiceTotalAmount = parseFloat(amount);
		else
			newInvoiceTotalAmount = parseFloat(amount)+parseFloat($scope.invoiceTip);
		
		if($scope.invoiceIdSelected != undefined){		
			if($scope.invoiceIdSelected==invoiceIdsel){				
				if(parseFloat(newInvoiceTotalAmount) > parseFloat(MaxTip))
					$scope.isTipMax = true;
				else $scope.isTipMax = false;
			}
		}
		//console.log('isTipMax: '+$scope.isTipMax)
		return newInvoiceTotalAmount
	};
	
	$scope.getAmountTotalTicket = function(tickectAmount,ticketTip){
		
		var MaxTip = parseFloat(tickectAmount) + (parseFloat(tickectAmount) * $scope.tip);
		var newInvoiceTotalAmount;
		if(!ticketTip)
			newInvoiceTotalAmount = parseFloat(tickectAmount);
		else
			newInvoiceTotalAmount = parseFloat(tickectAmount)+parseFloat(ticketTip);
					
		if(parseFloat(newInvoiceTotalAmount) > parseFloat(MaxTip))
			$scope.isTipTicketMax = true;
		else $scope.isTipTicketMax = false;
					
		return newInvoiceTotalAmount
	};	
	
	$rootScope.downloadAttachment = function(invoiceId, name, type){
		
		$http.get('getInvoiceWithAttachmentsAction?invoiceId='+invoiceId).success(
			function(data, status, header, config){					
				
				var invoiceAttachment = data;
				var file;
				if(type=='pdf') file = invoiceAttachment.pdfFile;
				if(type=='xml') file = invoiceAttachment.xmlFile;
				if(type=='png') file = invoiceAttachment.ticketPhoto;
				
				$scope.downloadFile(name, file)
				
			}).error(function(data, status, headers, config) {});		
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




/***********************************************************
 * FILE UPLOAD- BIGOTES
 **********************************************************/

$scope.ticketUpload = function() {

	$scope.data = 'none';

	var f = document.getElementById('file').files[0], r = new FileReader();
	var sizeFile = document.getElementById('file').files[0].size;
	var fileInput = $('.upload-file');
	var maxSize = fileInput.data('max-size');
	var nameFile = document.getElementById('file').files[0].name;
	
	r.onloadend = function(e) {
		var binary = "";
		var fileBytes = new Uint8Array(e.target.result);	
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

		var newTransactionAmountChecked = parseFloat($scope.transactionAmountChecked)
				+ parseFloat($scope.ticket.amount)
				+ parseFloat($scope.ticket.tip);

		var flagConciliation; 
		 if(newTransactionAmountChecked >= $scope.transactionAmount)
			 flagConciliation = "1";			 		 
		 else
			 flagConciliation = "0";
		 
		// CREAR JSON
		$rootScope.myData = {
			date : $scope.ticket.date,
			file : fileBytes+'',
			amount : $scope.ticket.amount,
			tip : $scope.ticket.tip,
			comment : $scope.ticket.comment,
			transactionId : $scope.transactionId,
			newTrxAmount : newTransactionAmountChecked,
			fileName: nameFile,
			conciliationTrxFlag : flagConciliation
		};
		console.log("DATA: "+JSON.stringify($rootScope.myData));
		console.log('TrxHbaseId : '+$scope.transactionId); 
		var jsonData = escape(angular
				.toJson($rootScope.myData));

		$http(
				{
					method : 'POST',
					url : 'uploadTicketAction',
					data : 'ticket=' + jsonData,
					headers : {
						'Content-Type' : 'application/x-www-form-urlencoded'
					}
				}).success(
				function(data, status, headers, config) {
					$scope.items = data;					
					$scope.ticket.date = '';
					$scope.ticket.amount = '';
					$scope.ticket.tip = '';
					comment : $scope.ticket.comment = '';					
//					$scope.downloadFile(data.pdfFileName, data.ticketPhoto);
					
					if(data != null && data && data.pdfFileName != null && data.pdfFileName){
				        var messageTemplate = '<span>El ticket: '+data.pdfFileName+' ha sido asociado correctamente.</span>';		        
				        notify({
				            messageTemplate: messageTemplate,
				            classes: "alert-success",
				            position: $scope.position,
				            duration: 10000
				        }); 
					}
					else{
						var messageTemplate = '<span>No se pudo asociar el ticket.</span>';		        
				        notify({
				            messageTemplate: messageTemplate,
				            classes: "alert-danger",
				            position: $scope.position,
				            duration: 10000
				        });						
						}

					$scope.refreshTransactionsTable($scope.screen);
					
				}).error(
				function(data, status, headers, config) {
			        var messageTemplate = '<span>Error en conexión con el servidor.</span>';		        
			        notify({
			            messageTemplate: messageTemplate,
			            classes: "alert-warning",
			            position: $scope.position,
			            duration: 10000
			        }); 
				});
		
	}

	r.readAsArrayBuffer(f);
};
	
});
 

//XXX My Concilitation Controller Bookmark
/************************************************
 * 
 * Angular Controller for MY CONCILIACION 
 * 
 ************************************************/
appComp.controller('myConciliationController', ['$scope', '$log', '$rootScope', '$http', 'NgTableParams', '$timeout', 'cfpLoadingBar', 
                                                function($scope, $log, $rootScope, $http, NgTableParams, $timeout, cfpLoadingBar) {

	// Budget Status
	$scope.REQUESTED = REQUESTED;
	$scope.REQUEST_DENIED = REQUEST_DENIED;
	$scope.REQUEST_APPROVED = REQUEST_APPROVED;
	$scope.DISPERSION_REQUESTED = DISPERSION_REQUESTED;
	$scope.REPORT_EDIT = REPORT_EDIT;
	$scope.REPORT_SEND = REPORT_SEND; 	
	$scope.REPORT_APPROVED = REPORT_APPROVED; 	
	$scope.REPORT_REJECTED = REPORT_REJECTED;
	$scope.NORECONCILED = NORECONCILED;
	$scope.RECONCILED = RECONCILED;
	$scope.REPORT_CANCELED = REPORT_CANCELED;
	$scope.CARD_HOLDER = CARD_HOLDER;
	$scope.SUPERVISOR = SUPERVISOR;

	// Transaction Status 
	$scope.RECONCILED = RECONCILED;
	$scope.NORECONCILED = NORECONCILED;
	$scope.NO_FILTER = NO_FILTER;
	
	$rootScope.MY_TRANSACTIONS_SCREEN = MY_TRANSACTIONS_SCREEN;
	$rootScope.MY_BUDGET_SCREEN = MY_BUDGET_SCREEN;


	$scope.budgetDateRange = {
			startDate: moment(),
			endDate: moment()
		};
	 
	$scope.ticketDate = moment();
	
	$scope.trxPeriod = 0;
	$scope.myInvoicesPeriod = 0;
	
	$scope.updateMonthLabelsArray = [];
	$scope.monthsArray = []; // nameLabel, index
	$scope.selectedMonth = {}; // nameLabel, index
	
	$scope.myTransactionsTableData = [];
	$scope.myInvoicesTableData = [];
	
	$scope.search = {};
	$scope.selectedStatusLabel = 'Todas';
	$scope.conciliationFilter = [
	                             { value: NO_FILTER,
	                               label: 'Todas' 
	                             },
	                             { value: RECONCILED,
		                           label: 'Conciliadas' 
		                         },
		                         { value: NORECONCILED,
		                           label: 'No conciliadas' 
		                         }   
	                             ];

	/************************************************
	 Initilization data arrays for menus
	 ************************************************/
	$scope.initData = function() {
		// Get the array of months available for the screen.
		$scope.getMonthsLabelsArrary();
		 
	};
	
	/************************************************
	 Update Conciliation Status Filter
	 ************************************************/
	$scope.updateStatusFilter = function(status){
		
		$scope.selectedStatusLabel = status.label;
		
		if(status.value != NO_FILTER){
			$scope.search.conciliationStatus = status.value;
		}else{
			$scope.search.conciliationStatus = '';
		}
	}
	/************************************************
	 Update Months Labels
	 ************************************************/
	$scope.getMonthsLabelsArrary = function() {
			
		// ----  get EVENTS LIST relative to the company
		$http.get('getMonthsLabelsAction').success
		(function(data, status, headers, config){
			
			$scope.monthsArray  = data;
			
			$scope.selectedMonth = $scope.monthsArray[0];
			
			$scope.trxPeriod = 0;
			$scope.myInvoicesPeriod = 0;
			
			
		}).error
		(function(data, status, headers, config) {
				}
		);
		 
	};

	/************************************************
	 Update trxPeriod Value
	 ************************************************/
	$scope.updateTrxPeriod = function(period) {

		//Update period Value
		$scope.trxPeriod = period;

		// Update Period object (to be displayed)
		$scope.selectedMonth = $scope.monthsArray[period];
		
		// Execute HTTP get method
		$rootScope.getMyTransactionsByPeriod();
		 
	};
	
	/************************************************
	 Update invoicesPeriod Value
	 ************************************************/
	$scope.updateInvoicesPeriod = function(period) {
		 
		//Update period Value
		$scope.myInvoicesPeriod = period;
		
		// Update Period object (to be displayed)
		$scope.selectedMonth = $scope.monthsArray[period];
		
		// Execute HTTP get method
		$scope.getMyInvoicesByPeriod();
		 
	};
	
	
	/************************************************
	 Get Transactions By Period
	 ************************************************/
	$rootScope.getMyTransactionsByPeriod = function() {		
		
		// Variable local para el manejo del arreglo.
		var transactions = [];
		
		console.log("EJECUCION DE ACTUALIZACION DE TABLA DE TRX");
		
		$http.get('getTransactionsByPeriodAction?period='+$scope.trxPeriod
				+'&userProfile=CARD_HOLDER').success(
				function(data, status, headers, config){
					
					// Carga a la variable Local
					transactions = angular.copy(data);
					// transactions = data;
					
					// Reset para la variable de TransactionSelected
					$scope.transactionsSelected = {
						idSelected: []		
					}; 
					
					var dateFormatter;
					var dateFormatInvoice;

					for (var i = 0; i < transactions.length; i++) {
						dateFormatter = moment(transactions[i].date, "YYYYMMDD");
						transactions[i].date = dateFormatter.format("DD/MM/YYYY");
						transactions[i].amountChecked = "0";
						if(transactions[i].invoiceList == undefined){							
							continue; 
						}
						for (var j = 0; j < transactions[i].invoiceList.length; j++) {							
							dateFormatInvoice = moment(transactions[i].invoiceList[j].invoiceDate, "YYYYMMDDHHmmss");
							transactions[i].invoiceList[j].invoiceDate = dateFormatInvoice.format("DD/MM/YYYY h:mm a");
							transactions[i].amountChecked = parseFloat(transactions[i].amountChecked) + parseFloat(transactions[i].invoiceList[j].totalAmount || transactions[i].invoiceList[j].amount);
						}
						
						// Actualiza el status de conciliación de cada transacción. 
						if(transactions[i].amountChecked >= transactions[i].amount){
							transactions[i].conciliationStatus = $scope.RECONCILED;
						}else{
							transactions[i].conciliationStatus = $scope.NORECONCILED;
						}
						
					}
					
					// Carga a la variable global del controller.
					$scope.myTransactionsTableData = angular.copy(transactions);
					
					// Actualizar la tabla
					$scope.tableTransactions.reload();
					
				}).error(function(data, status, headers, config) {			
			});
		

		$scope.tableTransactions = new NgTableParams({
	        page: 1,            
	        count: 10
	    }, {
	        total: $scope.myTransactionsTableData.length, // length of data
	        counts: ($scope.myTransactionsTableData.length>countPage) ? countsPage : [],
	        getData: function($defer, params) {
	        	params.total($scope.myTransactionsTableData.length);	
	            $defer.resolve($scope.myTransactionsTableData.slice((params.page() - 1) * params.count(), params.page() * params.count()));
	        }
	    });

	}; 
	

	/************************************************
	 Get My Invoices By Period
	 ************************************************/
	$scope.getMyInvoicesByPeriod = function() {		
//		var invoices = '';
		$http.get('getInvoicesByPeriodAction?period='+$scope.myInvoicesPeriod
				+'&userProfile=CARD_HOLDER').success(
				function(data, status, headers, config){																
					
					$scope.myInvoicesTableData = angular.copy(data);
					
					for (var i = 0; i < $scope.myInvoicesTableData.length; i++) {						
						var dateFormatInvoice = moment($scope.myInvoicesTableData[i].invoiceDate, "YYYYMMDDHHmmss");
						$scope.myInvoicesTableData[i].invoiceDate = dateFormatInvoice.format("DD/MM/YYYY h:mm a");
					}
					
					$scope.invoicesSelected = {
						idSelected: []		
					}; 
					
					$scope.tableMyInvoices.reload();	
					
				}).error(function(data, status, headers, config) {			
			});
		
		$scope.tableMyInvoices = new NgTableParams({
	        page: 1,            
	        count: 10
	    }, {
	        total: $scope.myInvoicesTableData.length, // length of data
	        counts: ($scope.myInvoicesTableData.length>countPage) ? countsPage : [],
	        getData: function($defer, params) {
	        	params.total($scope.myInvoicesTableData.length);	
	            $defer.resolve($scope.myInvoicesTableData.slice((params.page() - 1) * params.count(), params.page() * params.count()));
	        }
	    });

	}; 
	
	 
}]);



//XXX MY NEW BUDGET controller Bookmark
/************************************************
 * 
 * Angular Controller for MY NEW BUDGET 
 * 
 ************************************************/
appComp.controller('myNewBudgetController', ['$scope', '$log', '$rootScope', '$http', 'NgTableParams', '$timeout', 'cfpLoadingBar',
                                             function($scope, $log, $rootScope, $http, NgTableParams, $timeout, cfpLoadingBar) {
	
	// Get Constants
	$rootScope.REQUEST_EDIT = REQUEST_EDIT;
	$rootScope.REQUESTED = REQUESTED;
	$rootScope.REQUEST_DENIED = REQUEST_DENIED;
	$rootScope.REQUEST_APPROVED = REQUEST_APPROVED;
	$rootScope.DISPERSION_REQUESTED = DISPERSION_REQUESTED;
	$rootScope.REPORT_EDIT = REPORT_EDIT;
	$rootScope.REPORT_SEND = REPORT_SEND; 	
	$rootScope.REPORT_APPROVED = REPORT_APPROVED; 	
	$rootScope.REPORT_REJECTED = REPORT_REJECTED;
	$rootScope.NORECONCILED = NORECONCILED;
	$rootScope.RECONCILED = RECONCILED;
	$rootScope.REPORT_CANCELED = REPORT_CANCELED;

	$rootScope.STATUS_ON_PROGRESS = STATUS_ON_PROGRESS;
	$rootScope.SUCCESS_CODE = SUCCESS_CODE;
	$rootScope.ERROR_EVENT_NAME_DUPLICATED = ERROR_EVENT_NAME_DUPLICATED;
	$rootScope.ERROR_UNKNOWN_ERROR = ERROR_UNKNOWN_ERROR;
	
	// for other screen data initialization.
	$scope.budgetDateRange = {
			startDate: moment(),
			endDate: moment()
		};
	
	// for data initialization.
	$scope.dateRange = {
			startDate: moment(),
			endDate: moment()
		};
	
	
	
	
	// Events to be loaded on select picker.
	$scope.myPrevEvents = [];
	
	// My main structure on the FORM
	$scope.newBudget = {
			event : {
				name : '',
				description: ''
			},
			amount: '',
			budgetId:'',
			status: REQUEST_EDIT
	};
	
	
	// Flow control FLAGS
	$scope.isNewEvent = true;
	$scope.isNewBudget = true;
	$scope.isEditableBudget = true;
	
	// New budget FORM data.
	$scope.myUserName   = '';
	$scope.myCardNumber = '';
	$scope.eventAmount = 0;
	
	// Budget from a selected event
	$scope.myBudgetArray = [];
	$scope.myBudget = {};
	
	// Process status 
	$scope.processStatus = 'Editando';
	$scope.processStatusCode = '';
	

	/************************************************
	 Initilization data arrays for menus
	 ************************************************/
	$scope.initData = function() {

		console.log('initData - function');
		
		console.log('rootScope.REQUEST_DENIED = ' + $rootScope.REQUEST_DENIED);
		console.log('REQUEST_DENIED = ' + REQUEST_DENIED);
		
		
		
		// ----  get User name.
		$http.get('getUserNameAction').success
		(function(data, status, headers, config){
			
					$scope.myUserName  = data;
					
				}).error
		(function(data, status, headers, config) {
				}
		);
		
		// ----  get user data
		$http.get('getUserCardNumberAction').success
		(function(data, status, headers, config){
			
					$scope.myCardNumber = data;
					
				}).error
		(function(data, status, headers, config) {
				}
		);

		
		
		
		
		
		// ----  get EVENTS LIST relative to the company
		
		//XXX Funcionalidad deshabilitada a peticion del cliente.
		
//		$http.get('getApplicableEventsByCardholderAction').success
//		(function(data, status, headers, config){
//			
//					$scope.allEvents = angular.copy(data);
//					$scope.myPrevEvents = [];
//					
//					var isMyEvent = false;
//
//					$scope.allEvents.forEach(function (event, index, array) {
//						
//						isMyEvent = false;
//											
//						event.budgets.forEach(function (budget, index, array) {
//							if(budget.cardHolderId.cardNumber == $scope.myCardNumber){
//								console.log('MyEvent: ' + event.eventId + ' on budget: '+ budget.budgetId);
//								isMyEvent = true;
//								return;
//							}
//						});
//						
//						if(!isMyEvent){
//							console.log('Agregado a Otros Eventos');
//							$scope.myPrevEvents.push(event);
//						}
//					});
//					
//				}).error
//		(function(data, status, headers, config) {
//				}
//		);
		

		
		
		
		$scope.newBudget = {
				event : {
					name : '',
					description: ''
				},
				amount: '',
				budgetId:'',
				status: REQUEST_EDIT
		};
		
	};
	

	/************************************************
	 Update value of Event AMOUNT
	 ************************************************/
	$scope.updateEventAmount = function() {
		
		var tempAmount = 0;
		for (var index = 0; index < $scope.newBudget.budgets.length; index++) {
			console.log("Objeto actual" + $scope.newBudget.budgets[index]);			
			tempAmount += parseFloat($scope.newBudget.budgets[index].amount);
		}
		
		$scope.eventAmount = tempAmount;
	};
	
	/************************************************
	 RESET All SCREEN (My NEW BUDGET)
	 ************************************************/
	$scope.resetNewBudgetScreen = function() {
		
		$scope.isNewEvent = true;

		$scope.newBudget = {
				event : {
					name : '',
					description: ''
				},
				amount: '',
				budgetId:'',
				status: REQUEST_EDIT
		};
		window.location.replace('myBudgetsAction');
	};
	
	
	
	/************************************************
	 RESET All SCREEN (My NEW BUDGET)
	 ************************************************/
	$scope.markInvalidEventName = function() {
		
		$scope.newBudgetForm.f_destino.$invalid = true;
	};
	
	
	/************************************************
	 RESET EVENT from the List
	 ************************************************/
	$scope.resetEvent = function() {

		$scope.newBudget = {
				event : {
					name : '',
					description: ''
				},
				amount: '',
				budgetId:''
		};
		
		$scope.isNewEvent = true;
		$scope.isNewBudget = true;
		$scope.isEditableBudget = true;
	};
		

	/************************************************
	 Set EVENT from the List
	 ************************************************/
	$scope.getEventFromList = function(event) {
		
		$scope.newBudget.event = angular.copy(event);
		$scope.isNewEvent = false;
		
		// Set Budget by selected Event
		$scope.getMyBudgetBySelectedEvent(event.eventId);
		

//		$scope.newBudget.event.budgets.forEach(function (item, index, array) {
//			var position = $scope.myCardHolders.indexOf(item.user);
//			var removedItem = $scope.myCardHolders.splice(position, 1);
//			
//			// If this event has already a budget for me
//			if(){
//				// Then update the data of this budget already exist.
//				$scope.isNewBudget = false;
//				$newBudget.amount
//			}
//		});
		
		
		
	};
	

	/************************************************
	 Get my existent budget by selected Event
	 ************************************************/
	$scope.getMyBudgetBySelectedEvent = function(eventId) {
		
		

		$http.get('getMyBudgetByEventIdAction?'
				+ 'EventId=' + eventId).success(
			function(data, status, headers, config){
				
				$scope.myBudgetArray = data;
				$scope.myBudget = $scope.myBudgetArray[0];
				
				$scope.newBudget.amount = $scope.myBudget.approvedRequestAmount;
				
				// Validation to know if is a new Budget
				if( $scope.myBudget.budgetId == null){
					
					// $scope.myBudget.status = REQUEST_EDIT;
					// $scope.newBudget.status = REQUEST_EDIT;
					$scope.isNewBudget = true;
					$scope.isEditableBudget = true;
										
				}else{
					
					$scope.isNewBudget = false;
					
					// Set BudgetId
					$scope.newBudget.budgetId = $scope.myBudget.budgetId 

					//TODO Update EDIT OPTION fro editable case.
					// Validation to know if is an EDITABLE Budget
					if( $scope.myBudget.status == REQUESTED
//							|| $scope.myBudget.status == REQUEST_EDIT
							|| $scope.myBudget.status == REQUEST_DENIED 
							){
						
						$scope.isEditableBudget = true;
					}else{
						$scope.isEditableBudget = false;
					}
				}
				
			}).error(
			function(data, status, headers, config) {
				
			
			}
		);
		
		
	}
	
	
	/************************************************
	 Save MY NEW BUDGETS
	 ************************************************/
	$scope.saveNewBudget = function() {
		
		// Case of new event. Take the data from the date picker.
		if($scope.isNewBudget){
			$scope.newBudget.event.startDate = moment($scope.dateRange.startDate).format('MM/DD/YYYY');
			$scope.newBudget.event.endDate   = moment($scope.dateRange.endDate).format('MM/DD/YYYY');
		}
		
		$scope.processStatusCode = STATUS_ON_PROGRESS;
		
		$http.get('saveMyNewBudgetAction?'
				+ 'myNewBudgetEventId=' + $scope.newBudget.event.eventId
				+ '&myNewBudgetEventName=' + $scope.newBudget.event.name 
				+ '&myNewBudgetEventDescription=' + $scope.newBudget.event.description
				+ '&myNewBudgetStartDate=' + $scope.newBudget.event.startDate
				+ '&myNewBudgetEndDate=' + $scope.newBudget.event.endDate
				+ '&myNewBudgetEventCreatorId=' + $scope.newBudget.event.creatorId
				+ '&myNewBudgetAmount=' + $scope.newBudget.amount
				+ '&myNewBudgetId=' + $scope.newBudget.budgetId
				).success
		(function(data, status, headers, config){
			
			console.log('Result Message: ' + data);
			
			// Save Error Code
			$scope.processStatusCode = data; 
			console.log('Result Message: ' + $scope.processStatusCode);
			
			if(data == SUCCESS_CODE){
				
				// SUCCESS 
				console.log('Result Message: ' + $scope.processStatusCode);
				$scope.processStatus = 'Exitoso';

			}else if(data == ERROR_EVENT_NAME_DUPLICATED){
				
				// ERROR EVENT NAME DUPLICATED 
				console.log('Result Message: ' + $scope.processStatusCode);
			}else{
				
				// OTRO ERROR
				$scope.processStatusCode = ERROR_UNKNOWN_ERROR;
				console.log('Result Message: ' + $scope.processStatusCode);
			}
			
			
				}).error
		(function(data, status, headers, config) {
			
				}
		);
	};

}]);


//XXX OTHER CONCILIATION CONTROLLER BOOKMARK
/************************************************
 * 
 * Angular Controller for OTHER USERS CONCILIATION 
 * 
 ************************************************/
appComp.controller('otherConciliationController', ['$scope', '$log', '$rootScope', '$http', 'NgTableParams', '$timeout', 'cfpLoadingBar',
                                                   function($scope, $log, $rootScope, $http, NgTableParams, $timeout, cfpLoadingBar) {
	
	// Budget Status
	$scope.REQUESTED = REQUESTED;
	$scope.REQUEST_DENIED = REQUEST_DENIED;
	$scope.REQUEST_APPROVED = REQUEST_APPROVED;
	$scope.DISPERSION_REQUESTED = DISPERSION_REQUESTED;	
	$scope.REPORT_EDIT = REPORT_EDIT;
	$scope.REPORT_SEND = REPORT_SEND; 	
	$scope.REPORT_APPROVED = REPORT_APPROVED; 	
	$scope.REPORT_REJECTED = REPORT_REJECTED;
	$scope.NORECONCILED = NORECONCILED;
	$scope.RECONCILED = RECONCILED;
	$scope.REPORT_CANCELED = REPORT_CANCELED;

	// Transaction Status 
	$scope.RECONCILED = RECONCILED;
	$scope.NORECONCILED = NORECONCILED;
	$scope.NO_FILTER = NO_FILTER;

	// User profile
	$scope.CARD_HOLDER = CARD_HOLDER;
	$scope.SUPERVISOR = SUPERVISOR;
	
	// Enum for screens
	$scope.TRX_SCREEN = 0;
	$scope.INVOICES_SCREEN = 1;
	
	
	
	$scope.budgetDateRange = {
			startDate: moment(),
			endDate: moment()
		};
	
	$scope.search = {};
	$scope.selectedStatusLabel = 'Todas';
	$scope.conciliationFilter = [
	                             { value: NO_FILTER,
	                               label: 'Todas' 
	                             },
	                             { value: RECONCILED,
		                           label: 'Conciliadas' 
		                         },
		                         { value: NORECONCILED,
		                           label: 'No conciliadas' 
		                         }   
	                             ];
	
	
	$scope.trxPeriod = 0;
	$scope.otherInvoicesPeriod = 0;
	
	$scope.updateMonthLabelsArray = [];
	$scope.monthsArray = []; // nameLabel, index
	$scope.selectedMonth = {}; // nameLabel, index
	
	
	$scope.myFullCardHolders = [];
	$scope.selectedIdCardHolderArray = [];
	
	// ====== TABLES DATA (TO BE DISPLAYED) =======
	$scope.transactions = [];
	$scope.invoices = [];
		
	/************************************************
	 Initilization data arrays for menus
	 ************************************************/
	$scope.initData = function() {
		
		// Get the array of months available for the screen.
		$scope.getMonthsLabelsArrary();
		
		// Get array of cardholders for this supervisor.
		$scope.getMyCardHoldersAction();
		
		// $scope.selectedIdCardHolderArray = [];
		 
	};
	
	/************************************************
	 Select All users
	 ************************************************/
	$scope.selectAllUsers = function(booleanValue, screen){
		
		if(screen == $scope.TRX_SCREEN){
			checkboxes = document.getElementsByName('checkboxCardholderTrx');
		}else{
			checkboxes = document.getElementsByName('checkboxCardholderInvoices');
		}
	  
	  for(var i=0, n=checkboxes.length;i<n;i++) {	    
	    if(booleanValue){
		    // Case TRUE, copy whole list.
	    	if(!checkboxes[i].checked){
	    		console.log('Checkbox Added');
	    		$scope.selectedIdCardHolderArray.push($scope.myFullCardHolders[i].cardNumber);	
	    	}else{
	    		console.log('Checkbox already checked!, no added');
	    	}
		}else{
			$scope.selectedIdCardHolderArray.pop();
		}
	    checkboxes[i].checked = booleanValue;
	  }
	  
	  console.log('Tarjetas seleccionadas: ' + $scope.selectedIdCardHolderArray);
	  
	}
	
	
	/************************************************
	 Update Conciliation Status Filter
	 ************************************************/
	$scope.updateStatusFilter = function(status){
		
		$scope.selectedStatusLabel = status.label;
		
		if(status.value != NO_FILTER){
			$scope.search.conciliationStatus = status.value;
		}else{
			$scope.search.conciliationStatus = '';
		}
	}
	
	/************************************************
	 Update Months Labels
	 ************************************************/
	$scope.getMonthsLabelsArrary = function() {
			
		// ----  get EVENTS LIST relative to the company
		$http.get('getMonthsLabelsAction').success
		(function(data, status, headers, config){
			
			$scope.monthsArray  = data;
			
			$scope.selectedMonth = $scope.monthsArray[0];
			
			$scope.trxPeriod = 0;
			$scope.otherInvoicesPeriod = 0;
			
			
		}).error
		(function(data, status, headers, config) {
				}
		);
		 
	};


	/************************************************
	 Update Months Labels
	 ************************************************/
	$scope.getMyCardHoldersAction = function() {
	
			// ----  get CARDHOLDERS LIST relative to this supervisor
			$http.get('getMyCardHoldersAction').success
			(function(data, status, headers, config){
				
				$scope.myFullCardHolders = data;
		
				
					}).error
			(function(data, status, headers, config) {
					}
			);
	}

//	/************************************************
//	 Update Selected Card holder from picker
//	 ************************************************/
//	$scope.updateSelectedCardHolders = function(cardHolder) {
//	
//		$scope.selectedCardHolder = angular.copy(cardHolder);
//	
//	};
	
	/************************************************
	 Update trxPeriod Value
	 ************************************************/
	$scope.updateTrxPeriod = function(period) {

		// Update period Value
		$scope.trxPeriod = period;

		// Update Period object (to be displayed)
		$scope.selectedMonth = $scope.monthsArray[period];
		
		// Execute HTTP get method
		$scope.getOtherTransactionsByPeriod();
		 
	};
	
	/************************************************
	 Update invoicesPeriod Value
	 ************************************************/
	$scope.updateInvoicesPeriod = function(period) {
		
		// Update period Value
		$scope.otherInvoicesPeriod = period;
		
		// Update Period object (to be displayed)
		$scope.selectedMonth = $scope.monthsArray[period];
		
		// Execute HTTP get method
		$scope.getOtherInvoicesByPeriod();
		 
	};
	
	
	/************************************************
	 Get OTHER Transactions By Period
	 ************************************************/
	$scope.getOtherTransactionsByPeriod = function() {		
		
		if($scope.selectedIdCardHolderArray.length > 0){
		
			$http.get('getTransactionsByPeriodAction?period='+$scope.trxPeriod
					+'&userProfile=SUPERVISOR'
					+'&cardNumbersList=' + $scope.selectedIdCardHolderArray).success(
							
				function(data, status, headers, config){
					
					// Variable local para almacenar transacciones
					var transactionsLocal = [];
					
					// Carga a la variable Local
					transactionsLocal = angular.copy(data);
					// transactions = data;
					
					// Reset para la variable de TransactionSelected
					$scope.transactionsSelected = {
						idSelected: []		
					};
					
					var dateFormatter;
					var dateFormatInvoice;

					for (var i = 0; i < transactionsLocal.length; i++) {
						dateFormatter = moment(transactionsLocal[i].date, "YYYYMMDD");
						transactionsLocal[i].date = dateFormatter.format("DD/MM/YYYY");
						transactionsLocal[i].amountChecked = "0";
						if(transactionsLocal[i].invoiceList == undefined){							
							continue; 
						}
						for (var j = 0; j < transactionsLocal[i].invoiceList.length; j++) {							
							dateFormatInvoice = moment(transactionsLocal[i].invoiceList[j].invoiceDate, "YYYYMMDDHHmmss");
							transactionsLocal[i].invoiceList[j].invoiceDate = dateFormatInvoice.format("DD/MM/YYYY h:mm a");
							transactionsLocal[i].amountChecked = parseFloat(transactionsLocal[i].amountChecked) + parseFloat(transactionsLocal[i].invoiceList[j].totalAmount || transactionsLocal[i].invoiceList[j].amount);
						}
						
						// Actualiza el status de conciliación de cada transacción. 
						if(transactionsLocal[i].amountChecked >= transactionsLocal[i].amount){
							transactionsLocal[i].conciliationStatus = $scope.RECONCILED;
						}else{
							transactionsLocal[i].conciliationStatus = $scope.NORECONCILED;
						}
						
					}
					
					// Carga a la variable global del controller.
					$scope.transactions = angular.copy(transactionsLocal);
					
					// Actualizar la tabla
					$scope.tableTransactions.reload();
					
				}).error(function(data, status, headers, config) {			
					
				});
			
			
				$scope.tableTransactions = new NgTableParams({
			        page: 1,            
			        count: 10
			    }, {
			        total: $scope.transactions.length, // length of data
			        counts: [],
			        getData: function($defer, params) {
			        	params.total($scope.transactions.length);	
			            $defer.resolve($scope.transactions.slice((params.page() - 1) * params.count(), params.page() * params.count()));
			        }
			    });
		}
	}; 
	

	/************************************************
	 Get OTHER Invoices By Period
	 ************************************************/
	$scope.getOtherInvoicesByPeriod = function() {
		
		if($scope.selectedIdCardHolderArray.length > 0){
		
			$http.get('getInvoicesByPeriodAction?period='+$scope.otherInvoicesPeriod
					+'&userProfile=SUPERVISOR'
					+'&cardNumbersList=' + $scope.selectedIdCardHolderArray).success(
	
					function(data, status, headers, config){																
	
						//$scope.invoices = data;	
						
						$scope.invoices = angular.copy(data);
						
						for (var i = 0; i < $scope.invoices.length; i++) {						
							var dateFormatInvoice = moment($scope.invoices[i].invoiceDate, "YYYYMMDDHHmmss");
							$scope.invoices[i].invoiceDate = dateFormatInvoice.format("DD/MM/YYYY h:mm a");
						}
						
						$scope.invoicesSelected = {
							idSelected: []		
						}; 
						
						 $scope.tableOtherInvoices.reload();
						
					}).error(function(data, status, headers, config) {			
				});
			$scope.tableOtherInvoices = new NgTableParams({
		        page: 1,            
		        count: 10
		    }, {
		        total: $scope.invoices.length, // length of data
		        counts: [],
		        getData: function($defer, params) {
		        	params.total($scope.invoices.length);	
		            $defer.resolve($scope.invoices.slice((params.page() - 1) * params.count(), params.page() * params.count()));
		        }
		    });
		}

	}; 
	 
}]);

// XXX Check budgets controller bookmark
/************************************************
 * 
 * Angular Controller for CHECK BUDGETS 
 * checkBudgetsController 
 * 
 ************************************************/
appComp.controller('checkBudgetsController', ['$scope', '$log', '$rootScope', '$http', 'NgTableParams', '$timeout', 'cfpLoadingBar',
                                                function($scope, $log, $rootScope, $http, NgTableParams, $timeout, cfpLoadingBar) {

	$scope.budgetDateRange = {
			startDate: moment(),
			endDate: moment()
		};
	
	// Get Constants
	$scope.REQUEST_EDIT = REQUEST_EDIT;
	$scope.REQUESTED = REQUESTED;
	$scope.REQUEST_DENIED = REQUEST_DENIED;
	$scope.REQUEST_APPROVED = REQUEST_APPROVED;
	$scope.DISPERSION_REQUESTED = DISPERSION_REQUESTED;
	$scope.REPORT_EDIT = REPORT_EDIT;
	$scope.REPORT_SEND = REPORT_SEND; 	
	$scope.REPORT_APPROVED = REPORT_APPROVED; 	
	$scope.REPORT_REJECTED = REPORT_REJECTED;
	$scope.NORECONCILED = NORECONCILED;
	$scope.RECONCILED = RECONCILED;
	$scope.REPORT_CANCELED = REPORT_CANCELED;
	
	$rootScope.STATUS_ON_EDIT = STATUS_ON_EDIT;
	$rootScope.STATUS_ON_PROGRESS = STATUS_ON_PROGRESS;
	$rootScope.SUCCESS_CODE = SUCCESS_CODE;
	$rootScope.ERROR_EVENT_NAME_DUPLICATED = ERROR_EVENT_NAME_DUPLICATED;
	$rootScope.ERROR_UNKNOWN_ERROR = ERROR_UNKNOWN_ERROR;
	
	
	$scope.myControllerStatus;
	
	// Auxiliar structure to be sent
	$scope.auxBudgetSet = {
			event : {
				name : '',
				description: ''
			},
			budgets: []
	};
	
	// Main structure to be displayed
	$scope.checkBudget = {
			event : {
				name : '',
				description: ''
			},
			budgets: []
	};
	
		
	$scope.approveBudgets = true;
	$scope.denyBudgets = false;
	$scope.confirmation = $scope.denyBudgets;
	
	$scope.isEventOnEdit = false;
	$scope.isEditedEvent = false;
	
	$scope.selectedBudgetsArray = [];
	
	/************************************************
	 Initilization data arrays for menus
	 ************************************************/
	$scope.initData = function() {

		console.log('InitData - function');
		
		// Status of the current session. Initial es ON_EDIT.
		$scope.myControllerStatus = $rootScope.STATUS_ON_EDIT;
		
		// Get Event Details and Budgets array from the ACTION
		$scope.getEventDetails();
		
		$scope.isEventOnEdit = false;
		$scope.isEditedEvent = false;
		
		$scope.selectedBudgetsArray = [];
		
	};
	
	/************************************************
	 GET DATA TO BE DISPLAYED FROM THE LAST SCREEN  
	 ************************************************/
	$scope.getEventDetails = function() {		
		$http.get('getEventDetailsAction').success(
				function(data, status, header, config){	
					var event = data;										
					$http.get('getUsersBudgetsByEventAction?eventIdSelected='+event.eventId).success(
							function(data, status, headers, config){						
								var budgets = data;																							
								$scope.checkBudget = {
										event: event,
										budgets: budgets
									};
								
								
								
								var approvedAmount = 0;
								var requestedAmount = 0;
								
								$scope.checkBudget.budgets.forEach(function (item, index, array) {
									
									if(item.status == $scope.REQUESTED){
										requestedAmount += item.approvedRequestAmount;
									}
									
									if(item.status == $scope.REQUEST_APPROVED){
										approvedAmount += item.approvedRequestAmount;
									}
								
								});
								
								$scope.checkBudget.event.approvedAmount = approvedAmount;
								$scope.checkBudget.event.requestedAmount = requestedAmount;
								
							}).error(function(data, status, headers, config) {				
						});								
				}).error(function(data, status, headers, config){						
		});		
	};
	

	/************************************************
	 Update value of Event AMOUNT
	 ************************************************/
	$scope.updateEventAmount = function() {
		
		var tempAmount = 0;
		for (var index = 0; index < $scope.checkBudget.budgets.length; index++) {
			console.log("Objeto actual" + $scope.checkBudget.budgets[index]);			
			tempAmount += parseFloat($scope.checkBudget.budgets[index].amount);
		}
		
		$scope.eventAmount = tempAmount;
	};
	
	/************************************************
	 RESET All SCREEN (OTHER BUDGETS)
	 ************************************************/
	$scope.resetCheckBudgetsScreen = function() {

		$scope.eventAmount = 0;
		
		// Main structure to be displayed
		$scope.checkBudget = {
				event : {
					name : '',
					description: ''
				},
				budgets: []
		};
		
		// Auxiliar structure to be sent
		$scope.auxBudgetSet = {
				event : {
					name : '',
					description: ''
				},
				budgets: []
		};
		
		window.location.replace('otherBudgetsAction');
	};

	/************************************************
	 ASK FOR CHECK BUDGETS CONFIRMATION
	 ************************************************/
	$scope.askConfirmation = function(checkingOption) {
		
		if(checkingOption == $scope.approveBudgets){
			console.log("QUIERE APROBAR BUDGETS");
			$scope.confirmation = $scope.approveBudgets;
		}else{
			console.log("QUIERE RECHAZAR BUDGETS");
			$scope.confirmation = $scope.denyBudgets;
			
		}

	};
	
	/************************************************
	 UPDATE BUDGETS STATUS VALUE 
	 ************************************************/
	$scope.checkBudgets = function(inputStatus) {
		
		var status;
		var empty = ' ';
		
		if(inputStatus == $scope.approveBudgets){
			console.log("BUDGETS APROBADOS");
			status = $scope.REQUEST_APPROVED;
		}else{
			console.log("BUDGETS RECHAZADOS");
			status = $scope.REQUEST_DENIED;
		}
		
		// Update Status of BUDGETS
		$scope.selectedBudgetsArray.forEach(function (item, index, array) {
			// Update Status  
			item.status = status;
		});
		
		
		// Prepare data to be sent
		$scope.transformDataStructure();
		
		// Send data to be updated
		$scope.sendCheckedBudgets();
	};
	
	/************************************************
	 FINSH & REDIRECT to  otherBudgetsAction
	 ************************************************/
	$scope.finishAndRedirect = function() {
		// Redirect to main action
		window.location.replace('otherBudgetsAction');
		
	};
	

	/************************************************
	 TRANSFORM DATA SET  
	 ************************************************/
	$scope.transformDataStructure = function() {
		
		// Copy EVENT data
		$scope.auxBudgetSet.event.eventId		= $scope.checkBudget.event.eventId;
		$scope.auxBudgetSet.event.name			= $scope.checkBudget.event.name;
		$scope.auxBudgetSet.event.description	= $scope.checkBudget.event.description;
		$scope.auxBudgetSet.event.amount		= $scope.checkBudget.event.amount;
		$scope.auxBudgetSet.event.startDate		= $scope.checkBudget.event.startDate;
		$scope.auxBudgetSet.event.endDate		= $scope.checkBudget.event.endDate;
		
		var nextBudget = {};
		// Copy BUDGETS data
		$scope.selectedBudgetsArray.forEach(function (item, index, array) {
		
			nextBudget.budgetId = item.budgetId;
			nextBudget.userId = item.cardHolderId.userId;
			// nextBudget.aaaaaa = item.userName;
			nextBudget.cardNumber = item.cardNumber;
			// - - - - - - - - - - - - - - - -
			nextBudget.startDate = item.startDate;
			nextBudget.endDate = item.endDate;
			// nextBudget.aaaaaa = item.approvedRequestDate;
			
			nextBudget.status = item.status;
			nextBudget.reportStatus = item.reportStatus;
			nextBudget.amount = item.approvedRequestAmount;
			
			$scope.auxBudgetSet.budgets.push(nextBudget);
		});
	
	}
	
	/************************************************
	 HTTP POST - SEND BUDGETS TO BE UPDATED 
	 ************************************************/
	$scope.sendCheckedBudgets = function() {
		
		var data = escape(angular.toJson($scope.auxBudgetSet));
		
		$scope.myControllerStatus = $rootScope.STATUS_ON_PROGRESS;

		$http({
			method : 'POST',
			url : 'sendCheckedBudgetsAction',
			data : 'dataJson=' + data,
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			// $scope.items = data;
			
			
			console.log('Result Message: ' + data);
			
			// Save Error Code
			$scope.myControllerStatus = data; 
			
			console.log('Result Message: ' + $scope.myControllerStatus);
			
			if(data == SUCCESS_CODE){
				
				// SUCCESS 
				console.log('Result Message: ' + $scope.myControllerStatus);
				$scope.processStatus = 'Exitoso';

			}else{
				// ERROR
				$scope.myControllerStatus = ERROR_UNKNOWN_ERROR;
				console.log('Result Message: ' + $scope.myControllerStatus);
			}
			
		}).error(function(data, status, headers, config) {
			// alert("Error :: "+data);
		});		
	};
	
}]);


//XXX EDIT event & budgets controller bookmark
/************************************************
 * 
 * Angular Controller for EDIT EVENT & BUDGETS 
 * editBudgetsController 
 * 
 ************************************************/
appComp.controller('editBudgetsController', ['$scope', '$log', '$rootScope', '$http', 'NgTableParams', '$timeout', 'cfpLoadingBar',
                                                function($scope, $log, $rootScope, $http, NgTableParams, $timeout, cfpLoadingBar) {

	$scope.eventDateRange = {
			startDate: moment(),
			endDate: moment()
		};
	
	// Get Constants
	$scope.REQUEST_EDIT = REQUEST_EDIT;
	$scope.REQUESTED = REQUESTED;
	$scope.REQUEST_DENIED = REQUEST_DENIED;
	$scope.REQUEST_APPROVED = REQUEST_APPROVED;
	$scope.DISPERSION_REQUESTED = DISPERSION_REQUESTED;
	$scope.REPORT_EDIT = REPORT_EDIT;
	$scope.REPORT_SEND = REPORT_SEND; 	
	$scope.REPORT_APPROVED = REPORT_APPROVED; 	
	$scope.REPORT_REJECTED = REPORT_REJECTED;
	$scope.NORECONCILED = NORECONCILED;
	$scope.RECONCILED = RECONCILED;
	$scope.REPORT_CANCELED = REPORT_CANCELED;
	
	$rootScope.STATUS_ON_EDIT = STATUS_ON_EDIT;
	$rootScope.STATUS_ON_PROGRESS = STATUS_ON_PROGRESS;
	$rootScope.SUCCESS_CODE = SUCCESS_CODE;
	$rootScope.ERROR_EVENT_NAME_DUPLICATED = ERROR_EVENT_NAME_DUPLICATED;
	$rootScope.ERROR_UNKNOWN_ERROR = ERROR_UNKNOWN_ERROR;
	
	
	$scope.myControllerStatus;
	
	// Auxiliar structure to be sent
	$scope.auxBudgetSet = {
			event : {
				name : '',
				description: ''
			},
			budgets: []
	};
	
	// Main structure to be displayed
	$scope.editBudget = {
			event : {
				name : '',
				description: ''
			},
			budgets: []
	};
	
	$scope.selectedBudgetsArray = [];
	
	/************************************************
	 Initilization data arrays for menus
	 ************************************************/
	$scope.initData = function() {

		console.log('InitData - function');
		
		// Status of the current session. Initial is ON_EDIT.
		$scope.myControllerStatus = $rootScope.STATUS_ON_EDIT;
		
		// Get Event Details and Budgets array from the ACTION
		$scope.getBudgetDetails();
		
	};
	
	/************************************************
	 GET DATA TO BE DISPLAYED FROM THE LAST SCREEN  
	 ************************************************/
	$scope.getBudgetDetails = function() {
		
		$http.get('getBudgetDetailsSelectedAction?').success(
			function(data, status, headers, config){						
				
				console.log('EditBudget = ' + data);
				
				$scope.editBudget.event = angular.copy(data.event);
				
				$scope.editBudget.budgets.push(data);
				
				$scope.eventDateRange = {
						startDate: $scope.editBudget.event.startDate,
						endDate: $scope.editBudget.event.endDate
				};
				
				$scope.editBudget.event.isEditable;
				
			}).error(function(data, status, headers, config) {				
		});
		
		
	};
		
	/************************************************
	 UPDATE BUDGETS STATUS VALUE 
	 ************************************************/
	$scope.saveBudgets = function() {
		
		// Prepare data to be sent
		$scope.transformDataStructure();
		
		// Send data to be updated
		$scope.sendUpdatedBudgets();
	};
	
	/************************************************
	 FINSH & REDIRECT to  otherBudgetsAction
	 ************************************************/
	$scope.finishAndRedirect = function() {
		// Redirect to main action
		window.location.replace('myBudgetsAction');
		
	};
	

	/************************************************
	 TRANSFORM DATA SET  
	 ************************************************/
	$scope.transformDataStructure = function() {
		
		// Copy EVENT data
		$scope.auxBudgetSet.event.eventId		= $scope.editBudget.event.eventId;
		$scope.auxBudgetSet.event.name			= $scope.editBudget.event.name;
		$scope.auxBudgetSet.event.description	= $scope.editBudget.event.description;
		$scope.auxBudgetSet.event.amount		= $scope.editBudget.event.amount;		
//		$scope.auxBudgetSet.event.startDate		= $scope.editBudget.event.startDate;
//		$scope.auxBudgetSet.event.endDate		= $scope.editBudget.event.endDate;
		$scope.auxBudgetSet.event.startDate		= $scope.eventDateRange.startDate;
		$scope.auxBudgetSet.event.endDate		= $scope.eventDateRange.endDate;
		
		var nextBudget = {};
		
		// Copy BUDGETS data
		$scope.editBudget.budgets.forEach(function (item, index, array) {
		
			nextBudget.budgetId = item.budgetId;
			nextBudget.userId = item.cardHolderId.userId;
			// nextBudget.aaaaaa = item.userName;
			nextBudget.cardNumber = item.cardNumber;
			// - - - - - - - - - - - - - - - -
			
//			nextBudget.startDate = item.startDate;
//			nextBudget.endDate = item.endDate;
			nextBudget.startDate = $scope.auxBudgetSet.event.startDate;
			nextBudget.endDate = $scope.auxBudgetSet.event.endDate;

			// nextBudget.aaaaaa = item.approvedRequestDate;
			
			nextBudget.status = item.status;
			nextBudget.reportStatus = item.reportStatus;
			nextBudget.amount = item.approvedRequestAmount;
			
			$scope.auxBudgetSet.budgets.push(nextBudget);
		});
	
	}
	
	/************************************************
	 HTTP POST - SEND UPDATED BUDGETS TO BE SAVED 
	 ************************************************/
	$scope.sendUpdatedBudgets = function() {
		
		var data = escape(angular.toJson($scope.auxBudgetSet));
		
		$scope.myControllerStatus = $rootScope.STATUS_ON_PROGRESS;

		$http({
			method : 'POST',
			url : 'sendUpdatedBudgetsAction',
			data : 'dataJson=' + data,
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			// $scope.items = data;
			
			
			console.log('Result Message: ' + data);
			
			// Save Error Code
			$scope.myControllerStatus = data; 
			
			console.log('Result Message: ' + $scope.myControllerStatus);
			
			if(data == SUCCESS_CODE){
				
				// SUCCESS 
				console.log('Result Message: ' + $scope.myControllerStatus);
				$scope.processStatus = 'Exitoso';

			}else{
				// ERROR
				$scope.myControllerStatus = ERROR_UNKNOWN_ERROR;
				console.log('Result Message: ' + $scope.myControllerStatus);
			}
			
		}).error(function(data, status, headers, config) {
			// alert("Error :: "+data);
		});		
	};
	
}]);



//XXX OTHER USERS NEW BUDGET Bookmark
/************************************************
 * 
 * Angular Controller for OTHER USERS NEW BUDGET 
 * 
 ************************************************/
appComp.controller('otherNewBudgetController', ['$scope', '$log', '$rootScope', '$http', 'NgTableParams', '$timeout', 'cfpLoadingBar',
                                                function($scope, $log, $rootScope, $http, NgTableParams, $timeout, cfpLoadingBar) {

	$scope.budgetDateRange = {
			startDate: moment(),
			endDate: moment()
		};
	
	$scope.myPrevEvents = [];
	$scope.newBudget = {
			event : {
				name : '',
				description: ''
			},
			budgets: []
	};
	
	$scope.auxBudgetSet = {
			event : {
				name : '',
				description: ''
			},
			budgets: []
	};
	
	
	$scope.budgetArray = [];
	
	$scope.eventAmount = 0;
	$scope.isNewEvent = true;
	$scope.isDataReady = false;
	

	$scope.myCardHolders = [];
	$scope.myFullCardHolders = [];

	/************************************************
	 Initilization data arrays for menus
	 ************************************************/
	$scope.initData = function() {

		console.log('initData - function');
		// ----  get EVENTS LIST relative to this supervisor
		$http.get('getSupervisorEventsAction').success
		(function(data, status, headers, config){
					$scope.myPrevEvents = data;
				}).error
		(function(data, status, headers, config) {
				}
		);
		
		// ----  get CARDHOLDERS LIST relative to this supervisor
		$http.get('getMyCardHoldersAction').success
		(function(data, status, headers, config){
			$scope.myFullCardHolders = data;

			$scope.updateVisibleCardHolders();
			
				}).error
		(function(data, status, headers, config) {
				}
		);
		
	};
	
	
	/************************************************
	 Update visible card holders list
	 ************************************************/
	$scope.updateVisibleCardHolders = function() {
		console.log('updateVisibleCardholders');
		
		// Copy myFullCardholders to myCardholders
		$scope.myCardHolders = angular.copy($scope.myFullCardHolders);
		
		$scope.newBudget.budgets.forEach(function (item, index, array) {
			var position = $scope.myCardHolders.indexOf(item.user);
			var removedItem = $scope.myCardHolders.splice(position, 1);
		
		});

	};

	/************************************************
	 Update value of Event AMOUNT
	 ************************************************/
	$scope.updateEventAmount = function() {
		
		var tempAmount = 0;
		for (var index = 0; index < $scope.newBudget.budgets.length; index++) {
			console.log("Objeto actual" + $scope.newBudget.budgets[index]);			
			tempAmount += parseFloat($scope.newBudget.budgets[index].amount);
		}
		
		$scope.eventAmount = tempAmount;
	};
	
	/************************************************
	 RESET All SCREEN (OTHER NEW BUDGET)
	 ************************************************/
	$scope.resetNewBudgetScreen = function() {
		
		$scope.eventAmount = 0;
		
		$scope.isNewEvent = true;

		$scope.newBudget = {
				event : {
					name : '',
					description: ''
				},
				budgets: []
		};
		
		$scope.auxBudgetSet = {
				event : {
					name : '',
					description: ''
				},
				budgets: []
		};
		
		$scope.updateVisibleCardHolders();
		
		window.location.replace('checkingAction');
	};
		
	
	/************************************************
	 RESET EVENT from the List
	 ************************************************/
	$scope.resetEvent = function() {
		$scope.newBudget.event = {};
		$scope.isNewEvent = true;
	};
		
	/************************************************
	 Set EVENT from the List
	 ************************************************/
	$scope.getEventFromList = function(event) {
		$scope.newBudget.event = angular.copy(event);
		$scope.eventAmount = $scope.newBudget.event.amount;
		$scope.isNewEvent = false;
	};
	
	/************************************************
	 Get User from the List
	 ************************************************/
	$scope.addUser = function(user) {
		
		var newUserFlag = true;	
		
		$scope.newBudget.budgets.forEach(function (item, index, array) {
			  if(item.user.cardNumber == user.cardNumber){
				  console.log("Usuario ya enlistado" );
				  newUserFlag = false;
				  return;
			  }
			});
						
		if(newUserFlag){
			t_budget = {
					user: {},
					startDate: '',
					endDate: '',
					amount: '',
					userId: user.userId,
					cardNumber: user.cardNumber
				};
			t_budget.user = angular.copy(user);
			$scope.newBudget.budgets.push(t_budget);
			
			var position = $scope.myCardHolders.indexOf(user);
			var removedItem = $scope.myCardHolders.splice(position, 1);
		}
	};
	
	/************************************************
	 Remove BUDGET
	 ************************************************/
	$scope.removeBudget = function(budget) {
		
		var position = $scope.newBudget.budgets.indexOf(budget);
		
		// Remove element from the array
		$scope.newBudget.budgets.splice(position, 1); 
		
		$scope.updateEventAmount();
		
		$scope.myCardHolders.push(budget.user);
				
	};
	


	/************************************************
	  TRANASFORM FROM '$scope.newBudget' TO '$scope.auxBudgetSet' 
	 ************************************************/
	$scope.transformNewBudget = function() {

		// Update Event amount
		$scope.newBudget.event.amount = angular.copy($scope.eventAmount);
		
		// Coping Event data - - - - - - - - - - - -
		$scope.auxBudgetSet.event.eventId 		= $scope.newBudget.event.eventId;
		$scope.auxBudgetSet.event.name 			= $scope.newBudget.event.name;
		$scope.auxBudgetSet.event.description 	= $scope.newBudget.event.description;
		$scope.auxBudgetSet.event.startDate		= $scope.newBudget.event.startDate;
		$scope.auxBudgetSet.event.endDate 		= $scope.newBudget.event.endDate;
		$scope.auxBudgetSet.event.amount 		= angular.copy($scope.eventAmount);
		

		// Coping Budgets Array - - - - - - - - - -
		var budget = {};
		
		$scope.newBudget.budgets.forEach(function (item, index, array) {
			
			budget.userId = item.userId;
			budget.cardNumber = item.cardNumber;
			budget.amount = item.amount;
			
			$scope.auxBudgetSet.budgets.push(angular.copy(budget));
		
		});
	};
	

//	/************************************************
//	 Save TRANASFORM NEW BUDGET DATA 
//	 ************************************************/
//	$scope.transformNewBudget = function() {
//
//		// Update Event amount
//		$scope.newBudget.event.amount = angular.copy($scope.eventAmount);
//		
//		$scope.newBudget.budgets.forEach(function (item, index, array) {
//			
//			// Set event 
//			item.event = angular.copy($scope.newBudget.event);
//			item.startDate = angular.copy($scope.newBudget.event.startDate);
//			item.endDate = angular.copy($scope.newBudget.event.endDate);
//			item.card = angular.copy(item.user.cardNumber);
//			
//			$scope.budgetArray.push(angular.copy(item));
//			$scope.budgetArray[$scope.budgetArray.length -1].user = {};			
//		});
//	};
	
	

	/************************************************
	 Save TRANASFORM NEW BUDGET DATA 
	 ************************************************/
	$scope.sendNewBudget = function() {
		
		var data = escape(angular.toJson($scope.auxBudgetSet));

		$http({
			method : 'POST',
			url : 'saveOtherNewBudgetsAction',
			data : 'dataJson=' + data,
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			// $scope.items = data;
		}).error(function(data, status, headers, config) {
			// alert("Error :: "+data);
		});		
	};
	
	/************************************************
	 ONLY FOR TEST PURPOSES -- Execute a hardcoded Marshaller Action 
	 ************************************************/
	$scope.testMarshallerAction = function() {
		
		// ONLY FOR TESTING -------
		$http.get('testMarshallerAction').success
		(function(data, status, headers, config){
			
			
				}).error
		(function(data, status, headers, config) {
				}
		);	
	};
	

	/************************************************
	 Save NEW BUDGETS
	 ************************************************/
	$scope.saveNewBudget = function() {
		
		// Only for testing purposes.
//		$scope.testMarshallerAction
		
		// Right functions -------------
		$scope.transformNewBudget(); 
		
		$scope.sendNewBudget();
		
	};
	
}]);

	/***************************************************
	 * Download set invoices as ZIP
	 **************************************************/

/*******************************************************************************
 * USERS
 ******************************************************************************/

var myApp = angular.module('users', [ 'ngTable', 'checklist-model',
		'ngBootstrap' ]);

myApp.controller('usersController', function($scope, $rootScope, $http,
		NgTableParams) {

	$scope.searchTh = '';
	$scope.selectedProfile = '';
	$scope.selectedCompany = '';

	$rootScope.response = null;

	$rootScope.thSelected = {
		idSelected : []
	};

	$rootScope.myData = {

	};

	$rootScope.cardSelected = '';
	$rootScope.clientSelected = -1;
	$rootScope.catProfileId = 0;
	$rootScope.category = null;
	$rootScope.categorySelected = null;

	$http.get('getCategoryFromSession').success(
			function(data, status, headers, config) {
				console.log(data);
				$rootScope.category = data;

				if (data >= 90) {
					$scope.categoryShow = true;
				} else {
					$scope.categoryShow = false;
				}
			}).error(function(data, status, headers, config) {
	});

	$scope.filterByProfile = function(category, profileId, profile) {

		$rootScope.categorySelected = category;
		$rootScope.catProfileId = profileId;
		$scope.selectedProfile = profile;

		/ TARJETAHABIENTE /
		if ($rootScope.categorySelected >= 0
				&& $rootScope.categorySelected < 30) {
			$scope.thVisible = false;
			$scope.clientVisible = true;
			$scope.thAssign = false;
			$rootScope.clientSelected = 0;
			$rootScope.cardSelected = null;

			/ SUPERVISOR /
		} else if ($rootScope.categorySelected >= 30
				&& $rootScope.categorySelected < 60) {
			$scope.thVisible = true;
			$scope.clientVisible = true;
			$scope.thAssign = true;
			$scope.showCards();
			$rootScope.clientSelected = 0;
			$rootScope.cardSelected = null;

			/ ADMIN CLIENTE /
		} else if ($rootScope.categorySelected >= 60
				&& $rootScope.categorySelected < 90) {
			$scope.thVisible = false;
			$scope.clientVisible = true;
			$scope.thAssign = true;
			$rootScope.clientSelected = 0;
			$rootScope.cardSelected = null;

			/ ADMIN SI VALE /
		} else if ($rootScope.categorySelected >= 90) {
			$scope.thVisible = false;
			$scope.clientVisible = false;
			$scope.thAssign = false;
			$rootScope.clientSelected = -1;
			$rootScope.cardSelected = null;
		}

	};

	$scope.selectClient = function(clientId, clientName) {

		$rootScope.clientSelected = clientId;
		$scope.selectedCompany = clientName;
		$scope.getCardsByCompany($rootScope.clientSelected);
	};

	$scope.getCardsByCompany = function(company) {
		$http.get('getCardsByCompany?companySelected=' + company).success(
				function(data, status, headers, config) {
					$scope.tarjetas = data;

					$scope.tableUsers = new NgTableParams({
						page : 1,
						count : 10
					}, {
						total : $scope.tarjetas.length,
						counts : [],
						getData : function($defer, params) {
							params.total($scope.tarjetas.length);
							$defer.resolve($scope.tarjetas.slice(
									(params.page() - 1) * params.count(),
									params.page() * params.count()));
						}
					});

				}).error(function(data, status, headers, config) {
		});
	};

	$scope.getCards = function() {
		$http.get('getCardsAction').success(
				function(data, status, headers, config) {
					$scope.tarjetas = data;
					$scope.tableUsers = new NgTableParams({
						page : 1,
						count : 10
					}, {
						total : $scope.tarjetas.length,
						counts : [],
						getData : function($defer, params) {
							params.total($scope.tarjetas.length);
							$defer.resolve($scope.tarjetas.slice(
									(params.page() - 1) * params.count(),
									params.page() * params.count()));
						}
					});

				}).error(function(data, status, headers, config) {
		});
	};

	$scope.selectCard = function(cardNumber) {
		console.log(cardNumber);
		$rootScope.cardSelected = cardNumber;
	};
	$scope.showCards = function() {
		if ($rootScope.category >= 90) {
			$scope.getCardsByCompany($rootScope.clientSelected);
		} else {
			$scope.getCards();
		}
	};

	$scope.cleanMsg = function() {
		$rootScope.response = null;
	};

	$scope.cleanForm = function() {

		$scope.username = null;
		$scope.pass = null;
		$scope.name = null;
		$scope.email = null;
		$rootScope.thSelected.idSelected = [];
		$rootScope.catProfileId = null;
		$rootScope.cardSelected = -1;
		$rootScope.clientSelected = 0;
		$scope.selectedCompany = '';
		$scope.selectedProfile = '';
		$scope.clientVisible = false;
		$scope.thAssign = false;
		$scope.thVisible = false;
		$scope.signup_form.$setPristine();
	};

	$scope.insertUser = function() {
		$rootScope.myData = {
			username : $scope.username,
			password : $scope.pass,
			name : $scope.name,
			email : $scope.email,
			th : $rootScope.thSelected.idSelected,
			profileId : $rootScope.catProfileId,
			cardSelected : $rootScope.cardSelected,
			company : $rootScope.clientSelected
		};

		var data = escape(angular.toJson($rootScope.myData));

		$http({
			method : 'POST',
			url : 'createUserAction',
			data : 'user=' + data,
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$rootScope.response = data;

			if ($scope.response.statusResponse == 'SUCCESS') {
				$scope.cleanForm();
			}

		}).error(function(data, status, headers, config) {
		});
	};
});

myApp.controller('getProfiles', function($scope, $http) {
	$http.get('getProfilesAction').success(
			function(data, status, headers, config) {
				$scope.perfiles = data;
			}).error(function(data, status, headers, config) {
	});
});

myApp.controller('getCategory', function($scope, $http) {
	$http.get('getCategoryFromSession').success(
			function(data, status, headers, config) {
				$scope.category = data;

				if (data >= 90) {
					$scope.categoryShow = true;
				} else {
					$scope.categoryShow = false;
				}
			}).error(function(data, status, headers, config) {
	});
});

myApp.controller('getClients', function($scope, $http) {
	$http.get('getClientAction').success(
			function(data, status, headers, config) {
				$scope.clients = data;
			}).error(function(data, status, headers, config) {
	});
});

myApp.directive("compareTo", function() {

	return {

		require : "ngModel",

		scope : {

			confirmPassword : "=compareTo"

		},

		link : function(scope, element, attributes, modelVal) {

			modelVal.$validators.compareTo = function(val) {

				var validation = scope.confirmPassword;
				console.log(val == validation);

				return val == validation;

			};
		}

	};

});

/*******************************************************************************
 * MAIN USERS
 ******************************************************************************/

myApp.controller('mainUsers',
		function($scope, $rootScope, $http, NgTableParams) {

			$scope.searchTh = '';
			$scope.selectedProfile = '';
			$scope.selectedCompany = '';

			$rootScope.response = null;

			$rootScope.thSelected = {
				idSelected : []
			};

			$rootScope.myData = {

			};

			$rootScope.userSelected = null;
			$rootScope.clientSelected = -1;
			$rootScope.catProfileId = 0;
			$rootScope.userCategory = null;
			$rootScope.categorySelected = null;

			$http.get('getCategoryFromSession').success(
					function(data, status, headers, config) {

						$rootScope.userCategory = data;
						console.log($rootScope.userCategory);

						/** ** LOADING TABLE TO SEARCH USER*** */
						$scope.loadTable();

					}).error(function(data, status, headers, config) {
			});

			$scope.loadTable = function() {
				/** ** LOADING TABLE TO SEARCH USER*** */
				if ($rootScope.userCategory >= 90) {
					$scope.getUserDetails();
				} else {
					$scope.getUserClientDetails();
				}
			};

			$scope.getUserDetails = function() {
				$http.get('getUserDetailsAction').success(
						function(data, status, headers, config) {
							$scope.tarjetas = data;
							$scope.tableUsers = new NgTableParams({
								page : 1,
								count : 10
							}, {
								total : $scope.tarjetas.length,
								counts : [],
								getData : function($defer, params) {
									params.total($scope.tarjetas.length);
									$defer.resolve($scope.tarjetas.slice(
											(params.page() - 1)
													* params.count(), params
													.page()
													* params.count()));
								}
							});

						}).error(function(data, status, headers, config) {
				});
			};

			$scope.getUserClientDetails = function() {
				$http.get('getUserDetailsClientAction').success(
						function(data, status, headers, config) {
							$scope.tarjetas = data;
							$scope.tableUsers = new NgTableParams({
								page : 1,
								count : 10
							}, {
								total : $scope.tarjetas.length,
								counts : [],
								getData : function($defer, params) {
									params.total($scope.tarjetas.length);
									$defer.resolve($scope.tarjetas.slice(
											(params.page() - 1)
													* params.count(), params
													.page()
													* params.count()));
								}
							});

						}).error(function(data, status, headers, config) {
				});
			};

			$scope.selectUser = function(user) {
				$http.get('redirectEditUserAction?userSelected=' + user.userId)
						.success(function(data, status, headers, config) {

						}).error(function(data, status, headers, config) {
						});
			};

			$scope.deleteUser = function(userId) {
				$http.get('deleteUserAction?userSelected=' + userId).success(
						function(data, status, headers, config) {
							$rootScope.response = data;
							$scope.loadTable();

						}).error(function(data, status, headers, config) {
				});
			};
		});

/*******************************************************************************
 * EDIT USERS
 ******************************************************************************/
myApp
		.controller(
				'editUsers',
				function($scope, $rootScope, $http, NgTableParams) {

					$scope.searchTh = '';
					$scope.selectedProfile = '';
					$scope.selectedCompany = '';
					$scope.categoryShow = false;
					$rootScope.userSelected = null;

					$rootScope.response = null;

					$rootScope.thSelected = {
						idSelected : []
					};

					$rootScope.myData = {

					};

					$rootScope.clientSelected = -1;
					$rootScope.catProfileId = 0;
					$rootScope.userCategory = null;
					$rootScope.categorySelected = null;
					$scope.isAdminGral = false;
					$scope.clientVisible = false;

					$http.get('getCategoryFromSession').success(
							function(data, status, headers, config) {
								$rootScope.userCategory = data;

								if ($rootScope.userCategory >= 90) {
									$scope.isAdminGral = true;
								} else {
									$scope.isAdminGral = false;
								}

							}).error(function(data, status, headers, config) {
					});

					$http
							.get('loadUserSelected')
							.success(
									function(data, status, headers, config) {

										$rootScope.userSelected = data[0];

										$scope.username = $rootScope.userSelected.user;
										$scope.name = $rootScope.userSelected.name;
										$scope.pass = $rootScope.userSelected.password;
										$scope.email = $rootScope.userSelected.email;
										$scope.selectedProfile = $rootScope.userSelected.profile;

										/*
										 * Asignar profileId que trae asignado.
										 * 
										 */
										$rootScope.catProfileId = $rootScope.userSelected.catProfile;

										/*
										 * Asignar clientId que tiene asignado.
										 * 
										 */
										$rootScope.clientSelected = $rootScope.userSelected.company;

										/*
										 * Si es un Admin general y se cambia a
										 * cualquier otro perfil se coloca el
										 * letrero default de los clientes
										 */

										if ($rootScope.userSelected.profileCategory >= 90) {
											$scope.selectedCompany = '';
										} else {
											$scope.selectedCompany = $rootScope.userSelected.company
													+ " - "
													+ $rootScope.userSelected.companyName;
										}
										$scope.clientVisible = $scope
												.validateComboClientVisible($rootScope.userSelected.profileCategory);

										/**
										 * CARGAR TABLA DE TH EN CASO DE QUE SEA
										 * SUPERVISOR*
										 */
										if ($rootScope.userSelected.profileCategory >= 30
												&& $rootScope.userSelected.profileCategory < 60) {
											$scope.thVisible = true;
											$scope
													.getCardsByCompany($rootScope.userSelected.company);
										}

									}).error(
									function(data, status, headers, config) {
									});

					$scope.filterByProfile = function(category, profileId,
							profile) {

						$rootScope.categorySelected = category;
						$rootScope.catProfileId = profileId;
						$scope.selectedProfile = profile;

						if ($rootScope.categorySelected >= 30
								&& $rootScope.categorySelected < 60) {
							$scope.thVisible = true;
							$scope.clientVisible = true;
							$scope.thAssign = true;
							$scope
									.getCardsByCompany($rootScope.userSelected.company);
							$rootScope.cardSelected = null;

							/ ADMIN CLIENTE /
						} else if ($rootScope.categorySelected >= 60
								&& $rootScope.categorySelected < 90) {
							$scope.thVisible = false;
							$scope.clientVisible = true;
							$scope.thAssign = true;
							$rootScope.cardSelected = null;

							/ ADMIN SI VALE /
						} else if ($rootScope.categorySelected >= 90) {
							$scope.thVisible = false;
							$scope.clientVisible = false;
							$scope.thAssign = false;
							$rootScope.clientSelected = -1;
							$rootScope.cardSelected = null;
						}
					};

					$scope.validateComboClientVisible = function(
							profileSelectedId) {

						if (profileSelectedId >= 90) {
							return false;
						} else {
							return true;
						}
					};

					$scope.selectClient = function(clientId, clientName) {

						$rootScope.clientSelected = clientId;
						$scope.selectedCompany = clientName;
						$scope.getCardsByCompany($rootScope.clientSelected);
					};

					$scope.getCardsByCompany = function(company) {
						$http
								.get(
										'getCardsByCompanyEdit?companySelected='
												+ company
												+ "&userSelected="
												+ $rootScope.userSelected.userId)
								.success(
										function(data, status, headers, config) {
											$scope.tarjetas = data.unSelectedUsers;

											$scope.tableUsers = new NgTableParams(
													{
														page : 1,
														count : 10
													},
													{
														total : $scope.tarjetas.length,
														counts : [],
														getData : function(
																$defer, params) {
															params
																	.total($scope.tarjetas.length);
															$defer
																	.resolve($scope.tarjetas
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

											$scope.selectedUsers = data.selectedUsers;

											$scope.selectedUsersTable = new NgTableParams(
													{
														page : 1,
														count : 10
													},
													{
														total : $scope.selectedUsers.length,
														counts : [],
														getData : function(
																$defer, params) {
															params
																	.total($scope.selectedUsers.length);
															$defer
																	.resolve($scope.selectedUsers
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

					$scope.getCards = function() {
						$http
								.get('getCardsAction')
								.success(
										function(data, status, headers, config) {
											$scope.tarjetas = data;
											$scope.tableUsers = new NgTableParams(
													{
														page : 1,
														count : 10
													},
													{
														total : $scope.tarjetas.length,
														counts : [],
														getData : function(
																$defer, params) {
															params
																	.total($scope.tarjetas.length);
															$defer
																	.resolve($scope.tarjetas
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

					$scope.updateUser = function() {
						$rootScope.myData = {
							username : $scope.username,
							password : $scope.pass,
							name : $scope.name,
							email : $scope.email,
							th : $rootScope.thSelected.idSelected,
							profileId : $rootScope.catProfileId,
							cardSelected : $rootScope.cardSelected,
							company : $rootScope.clientSelected
						};

						var data = escape(angular.toJson($rootScope.myData));

						$http(
								{
									method : 'POST',
									url : 'editUserAction',
									data : 'user=' + data,
									headers : {
										'Content-Type' : 'application/x-www-form-urlencoded'
									}
								})
								.success(
										function(data, status, headers, config) {
											$rootScope.response = data;
											console.log($rootScope.response);

											if ($scope.response.statusResponse == 'SUCCESS') {
												$scope.cleanForm();
											}

										})
								.error(function(data, status, headers, config) {
								});
					};

					$scope.deleteUser = function(userId) {

						$http
								.get(
										'deleteUserSupAction?userSelected='
												+ userId)
								.success(
										function(data, status, headers, config) {
											$rootScope.response = data;
											$scope
													.getCardsByCompany($rootScope.userSelected.company);

										})
								.error(function(data, status, headers, config) {
								});
					};

					$scope.isSuccessChangePass = false;
					$scope.editPassword = function() {

						$rootScope.myData = {
							password : $scope.newPass
						};

						var data = escape(angular.toJson($rootScope.myData));

						$http(
								{
									method : 'POST',
									url : 'editPasswordAction',
									data : 'user=' + data,
									headers : {
										'Content-Type' : 'application/x-www-form-urlencoded'
									}
								})
								.success(
										function(data, status, headers, config) {

											$scope.response = data;

											if ($scope.response.statusResponse == 'SUCCESS') {
												$scope.newPass = null;
												$scope.newConfirmPassword = null;
												$scope.isSuccessChangePass = true;
												$scope.pass_form.$setPristine();
											}

										})
								.error(function(data, status, headers, config) {
								});

					};

					$scope.cleanMsgSuccess = function() {
						$scope.isSuccessChangePass = false;
					};

					$scope.cleanForm = function() {

						$scope.username = null;
						$scope.pass = null;
						$scope.confirmPassword = null;
						$scope.newPass = null;
						$scope.newConfirmPassword = null;
						$scope.name = null;
						$scope.email = null;
						$rootScope.thSelected.idSelected = [];
						$rootScope.catProfileId = null;
						$rootScope.cardSelected = -1;
						$rootScope.clientSelected = 0;
						$scope.selectedCompany = '';
						$scope.selectedProfile = '';
						$scope.clientVisible = false;
						$scope.thAssign = false;
						$scope.thVisible = false;
						$scope.signup_form.$setPristine();
					};

				});
myApp.controller('getClients', function($scope, $http) {
	$http.get('getClientAction').success(
			function(data, status, headers, config) {
				$scope.clients = data;
			}).error(function(data, status, headers, config) {
	});
});

myApp.controller('getProfiles', function($scope, $http) {
	$http.get('getProfilesAction').success(
			function(data, status, headers, config) {
				$scope.perfiles = data;
			}).error(function(data, status, headers, config) {
	});
});

/*******************************************************************************
 * REPORTES
 ******************************************************************************/

var reportsApp = angular.module('reports', [ 'ngTable', 'checklist-model',
                                     		'ngBootstrap' ]);

reportsApp.controller('reportsController', function($scope, $rootScope, $http,
		NgTableParams) {
	
	$rootScope.url = null;

    $http.get('getReportWithTicket').success(
    		function(data, status, headers, config) {
    			$rootScope.url = data;
    			console.log(data);
    			}).error(function(data, status, headers, config) {
    				
    			});
    });


/*******************************************************************************
 * COMPANIES
 ******************************************************************************/

var companiesApp = angular.module('companies', [ 'ngTable', 'checklist-model',
		'ngBootstrap', 'ng-toggle.btn', 'cgNotify']);

companiesApp.controller('companyController', function($scope,  $filter, $rootScope, $http,
		NgTableParams, notify) {		
	var count = 0;
	$scope.SUCCESS = SUCCESS;
	$scope.ENABLE = ENABLE;
	$scope.DISABLE = DISABLE;
	$scope.ERROR = ERROR;
    $scope.filters = {
            myfilter: ''
        };
	
	$scope.allCompanies = function() {	
		$http.get('getCompaniesAction').success(
				function(data, status, headers, config) {		 
					$scope.companies = data;					
					
					for ( var index in data) 
						$scope.companies[index].enable = (data[index].isEnable==COMPANY_ENABLE) ? IS_ENABLE : !IS_ENABLE;					
					
					$scope.tableCompanies = new NgTableParams({
				        page: 1,            
				        count: 10,
				        filter: $scope.filters,
				    }, {
				        total: $scope.companies.length,
				        counts: [],
				        getData: function($defer, params) {
				        	var filteredData = params.filter() ?
                                    $filter('filter')($scope.companies, params.filter().myfilter) :
                                    	$scope.companies;
                                    
		                    var orderedData = params.sorting() ?
		                                        $filter('orderBy')(filteredData, params.orderBy()) : 
		                                        	$scope.companies;
				        	
				            $defer.resolve(orderedData.slice((params.page() - 1) * params.count(), params.page() * params.count()));
				        }
				    });
					
				}).error(function(data, status, headers, config) {
		});
	};

	$scope.updateCompanyStatus = function(company) {
		count++;
		if (count == 2) {
			count = 0;
			company.isEnable = (company.isEnable) ? COMPANY_DISABLE : COMPANY_ENABLE;
			
			var data = escape(angular.toJson(company));
			$http({
				method : 'POST',
				url : 'updateCompanyAction',
				data : 'company=' + data,
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			}).success(function(data, status, headers, config) {
				if(data && data == SUCCESS){
					if(!company.isEnable)
						$scope.result = {
								status : DISABLE,
								message : 'El cliente '+company.companyId+' '+company.name+' ha sido desactivado',
								classes : "alert-danger"
						}
					else
						$scope.result = {
								status : ENABLE,
								message : 'El cliente '+company.companyId+' '+company.name+' ha sido activado',
								classes : "alert-success"
						}					
				}
				if(!data || data == ERROR){					
					$scope.result = {
							status : ERROR,
							message : 'No se ha podido realizar la operación.',
							classes : "alert-warning"
					}
				}								
		        var messageTemplate = '<span>'+$scope.result.message+'</span>';		        
		        notify({
		            messageTemplate: messageTemplate,
		            classes: $scope.result.classes,
		            position: $scope.position,
		            duration: 10000
		        }); 		        		
			}).error(function(data, status, headers, config) {
			});
			
			
			
		}
	}

});

var downloadInv = angular.module('downloadInvoices', [ 'ngTable', 'checklist-model',
                                         		'ngBootstrap', 'ng-toggle.btn', 'cgNotify']);

downloadInv.controller('downloadInvoicesController', function($scope,  $filter, $rootScope, $http,
		NgTableParams, notify) {
	$scope.dateDownload = moment();
	
	$scope.downloadZIPInvoices = function(){						
		var date = moment($scope.dateDownload);
		var nameDate = moment($scope.dateDownload);
		date = date.format("YYYYMMDDHHmmss");
		var nameDate = nameDate.format("YYYY-MMMM");
		$http.get('downloadFileAction?dateDownload='+date).success(
			function(data, status, headers, config) {
				if(data.pdfFile){
					var messageTemplate = '<span>Descargando facturas de '+nameDate+'...</span>';
			        notify({
			            messageTemplate: messageTemplate,
			            classes: "alert-success",
			            position: $scope.position,
			            duration: 3000
			        });
			        $scope.downloadFileZIP('facturas_'+nameDate+'.zip', data.pdfFile);
				}
				else{
					var messageTemplate = '<span>No existen facturas para el periodo:'+nameDate+' </span>';		        
			        notify({
			            messageTemplate: messageTemplate,
			            classes: "alert-danger",
			            position: $scope.position,
			            duration: 5000
			        });
				}
			}).error(function(data, status, headers, config) {
		        var messageTemplate = '<span>Error en conexión con el servidor.</span>';		        
		        notify({
		            messageTemplate: messageTemplate,
		            classes: "alert-warning",
		            position: $scope.position,
		            duration: 10000
		        }); 
			});	
	};
	
	$scope.downloadFileZIP = function(name,file) {

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

downloadInv.directive('datetimez', function() {
    return {
        restrict: 'A',
        require : 'ngModel',
        link: function(scope, element, attrs, ngModelCtrl) {
          element.datetimepicker({
           format: "MM-yyyy",
           viewMode: "months", 
            minViewMode: "months",
              pickTime: false,
          }).on('changeDate', function(e) {
            ngModelCtrl.$setViewValue(e.date);
            scope.$apply();
          });
        }
    };
});


