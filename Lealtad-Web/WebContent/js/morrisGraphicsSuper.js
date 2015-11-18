$(function() {
	var host =  window.location.hostname+':8080';
	var supervisorId;	
	
	d3.json("getUserIdAction", function(json) {			
		supervisorId = json; 			
		if(supervisorId == null)
			return;	
	
//		d3.json('http://'+host+'/Viajes-REST/rest/d3/getTransactionsBySupervisor/'+supervisorId, function(json) {
		d3.json('resources/json/transactions.json', function(json) {
			var transactions = [];
			var labelData;
			var countZero = 0; 
			  $.each(json.TRANSACCIONES, function(d,i){	  	
				  
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
						  '<div role="alert" style="text-align: center;">'+
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
	
		});
	
		
//		d3.json('http://'+host+'/Viajes-REST/rest/d3/getInvoicesBySupervisor/'+supervisorId, function(json) {
		d3.json('resources/json/invoices.json', function(json) {
			
			var invoices = [];
			var labelData;
			var countZero = 0;
			  $.each(json.INVOICES, function(d,i){	
				  
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
						  '<div role="alert" style="text-align: center;">'+
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
	
		});
				
//		d3.json('http://'+host+'/Viajes-REST/rest/d3/getTransactionsSumBySupervisor/'+supervisorId, function(json) {
		d3.json('resources/json/saldoS.json', function(json) {
			var balance = [];
			
			  $.each(json.TRANSACTIONS_SUM, function(d,i){	  	          
				  var dateFormatTransaction = moment(i.date, "YYYYMMDD");
				  
				  balance.push({
			        y: dateFormatTransaction.format("DD/MM/YYYY"),
			        a: parseInt(i.amount),
			      })
			  })
			  if(balance == ''){				  
				  $(".average-balance-chart").html(
						  '<div role="alert" style="text-align: center;">'+
							'<span class="glyphicon glyphicon-exclamation-sign"'+
								'aria-hidden="true"></span>'+ 
							'<span class="sr-only">Error:</span>'+
							' No existen datos a desplegar'+
						'</div>'
				  );
				  return;
			  }
			Morris.Line({
				  hoverCallback: function(index, options, content) {
				    var data = options.data[index];
				    $(".morris-hover").html(
				    		'<div class="morris-hover-row-label">'+data.y+'</div>'+
				    		'<div class="morris-hover-point" style="color: #0b62a4">'+options.labels+': $'+(data.a).toFixed(2).replace(/(\d)(?=(\d{3})+\.)/g, '$1,')+'</div>');
				  },
				  element: 'morris-line-chartS',
				  data: balance,
				  xkey: 'y',
				  ykeys: ['a'],
				  labels: ['gasto']
				});
			
			});
			
		
	});	
});