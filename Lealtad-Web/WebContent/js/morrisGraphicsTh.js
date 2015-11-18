$(function() {
	var host =  window.location.hostname+':8080';
	var cardNumber;	
	
	d3.json("getCardNumberAction", function(json) {			
		cardNumber = json; 			
		if(cardNumber == null)
			return;	
	
		d3.json('http://'+host+'/Viajes-REST/rest/d3/getTransactionsByStatus/'+cardNumber, function(json) {
//		d3.json('resources/json/transactions.json', function(json) {
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
				  $(".transactionsTh-chart").html(
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
			element: 'morris-donut-transactions',
			data: transactions,
			colors: [
			         '#F78D1D',
			         'rgba(247, 141, 29, 0.83)',             
			       ],
			resize: true
			});
	
		});
	
		
		d3.json('http://'+host+'/Viajes-REST/rest/d3/getInvoicesByStatus/'+cardNumber, function(json) {
//		d3.json('resources/json/invoices.json', function(json) {
			
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
				  $(".invoicesTh-chart").html(
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
			element: 'morris-donut-invoices',
			data: invoices,
			colors: [
			         '#F78D1D',
			         'rgba(247, 141, 29, 0.83)',             
			       ],
			resize: true
			});
	
		});				
			
		
	});	
});