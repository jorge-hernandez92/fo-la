$(function() {
var host =  window.location.hostname;
var cardNumber; 
console.log('http://'+host+"/Viajes-REST/rest/d3/getInvoicesByStatus/");
d3.json("getCardNumberAction", function(json) {			
	cardNumber = json; 	
	console.log('cardnumber: '+cardNumber);
	if(cardNumber == null)
		return;

	d3.json('http://'+host+"/Viajes-REST/rest/d3/getInvoicesByStatus/"+cardNumber, function(json) {	
		var data = [];	
		var colorLabel; 
		var labelData; 
	  $.each(json.INVOICES, function(d,i){
		  if(i.invoice == 'FACTURAS CONCILIADAS'){ 
			  colorLabel = "#F0430A";
			  labelData = "Conciliadas"; 
			  }
		  else if(i.invoice == 'FACTURAS NO CONCILIADAS'){
			  colorLabel = "#FA7E55";
			  labelData = "No Conciliadas"; 
		  }
			  
	    data.push({
	        label: labelData,		
	        value: parseInt(i.num),
	        color : colorLabel
	      })
	  })
	  var pie = new d3pie("pieInvoices", {
		  "header": {
	          "title": {
	            "text": "Facturas por Estatus",
	            "fontSize": 22,
	            "font": "verdana"
	          },
	          "subtitle": {
	            "color": "#999999",
	            "fontSize": 10,
	            "font": "verdana"
	          },
	          "titleSubtitlePadding": 12
	        },
	        "footer": {
	          "text": "",
	          "color": "#999999",
	          "fontSize": 11,
	          "font": "open sans",
	          "location": "bottom-center"
	        },
	        "size": {
	          "canvasHeight": 400,
	          "canvasWidth": 450
	        },
	        
	        "data": {
		      "smallSegmentGrouping": {
		        "enabled": true
		      },
			  "content": data
	    	  },        
	        "labels": {
	          "outer": {
	            "pieDistance": 25
	          },
	          "mainLabel": {
	            "font": "monospace",
	            "fontSize": 12
	          },
	          "percentage": {
	            "color": "#ffffff", //e1e1e1
	            "font": "verdana",
	            "decimalPlaces": 0
	          },
	          "value": {
	            "color": "#e1e1e1",
	            "font": "verdana",
	            "fontSize": 11
	          },
	          "lines": {
	            "enabled": true,
	            "color": "#cccccc"
	          }
	        },
	        "tooltips": {
	          "enabled": true,
	          "type": "placeholder",
	          "string": "{label}: {value}",
	          "styles": {
	            "fadeInSpeed": 276,
	            "backgroundOpacity": 0.43
	          }
	        },
	        "effects": {
	          "pullOutSegmentOnClick": {
	            "speed": 400,
	            "size": 8
	          }
	        },
	        "callbacks": {
	          "onMouseoverSegment": null,
	          "onMouseoutSegment": null,
	          "onClickSegment": null
	        },
	
		});
	  });
	
	d3.json('http://'+host+"/Viajes-REST/rest/d3/getTransactionsByStatus/"+cardNumber, function(json) {	
		var data = [];
	  $.each(json.TRANSACCIONES, function(d,i){	  	          
		  if(i.transaction == 'TRANSACCIONES CONCILIADAS'){ 
			  colorLabel = "#93c144";
			  labelData = "Conciliadas"; 
			  }
		  else if(i.transaction == 'TRANSACCIONES NO CONCILIADAS'){
			  colorLabel = "#72925b";
			  labelData = "No Conciliadas"; 
		  }
			  
	    data.push({
	        label: labelData,		
	        value: parseInt(i.num),
	        color : colorLabel
	      })
	  })
	  var pie = new d3pie("pieTransactions", {
		  "header": {
	  		"title": {
	  			"text": "Transacciones por Estatus",
	  			"fontSize": 22,
	  			"font": "verdana"
	  		}
		  	},
		  	"size": {
	    		"canvasHeight": 400,
	    		"canvasWidth": 450
	    	},
	    	"size": {
	    		"canvasHeight": 400,
	    		"canvasWidth": 450
	    	},
	    	"data": {
	  	      "smallSegmentGrouping": {
	  	        "enabled": true
	  	      },
	  		  "content": data
	      	  },        
	    	"labels": {
	    		"outer": {
	    			"pieDistance": 25
	    		},
	    		"mainLabel": {
	    			"font": "monospace",
	    			"fontSize": 12
	    		},
	    		"percentage": {
	    			"color": "#e1e1e1",
	    			"font": "verdana",
	    			"decimalPlaces": 0
	    		},
	    		"value": {
	    			"color": "#e1e1e1",
	    			"font": "verdana",
	    			"fontSize": 11
	    		},
	    		"lines": {
	    			"enabled": true,
	    			"color": "#cccccc"
	    		}
	    	},
	    	"tooltips": {
	    		"enabled": true,
	    		"type": "placeholder",
	    		"string": "{label}: {value}",
	    		"styles": {
	    			"fadeInSpeed": 276,
	    			"backgroundOpacity": 0.43
	    		}
	    	},
	    	"effects": {
	    		"pullOutSegmentOnClick": {
	    			"speed": 400,
	    			"size": 8
	    		}
	    	},
	    	"callbacks": {
	    		"onMouseoverSegment": null,
	    		"onMouseoutSegment": null,
	    		"onClickSegment": null
	    	}
		});
	  });
	
	});



//Start Grafica de linea

var margin = {top: 20, right: 20, bottom: 30, left: 50},
width = 960 - margin.left - margin.right,
height = 500 - margin.top - margin.bottom;

var parseDate = d3.time.format("%y-%m-%d").parse;

var x = d3.time.scale().range([0, width]);
var y = d3.scale.linear().range([height, 0]);

var xAxis = d3.svg.axis().scale(x).orient("bottom");
var yAxis = d3.svg.axis().scale(y).orient("left");

var line = d3.svg.line()
.x(function(d) { return x(d.date); })
.y(function(d) { return y(d.close); });

var div = d3.select("body")
.append("div")  // declare the tooltip div
.attr("class", "tooltip")              // apply the 'tooltip' class
.style("opacity", 0);

var svg = d3.select("body").append("svg")
.attr("width", width + margin.left + margin.right)
.attr("height", height + margin.top + margin.bottom)
.append("g")
.attr("transform", "translate(" + margin.left + "," + margin.top + ")");

d3.tsv("data/data-line.tsv", function(error, data) {
data.forEach(function(d) {
d.date = parseDate(d.date);
d.close = +d.close;
});

x.domain(d3.extent(data, function(d) { return d.date; }));
y.domain(d3.extent(data, function(d) { return d.close; }));

svg.append("path")
    .attr("class", "line")
    .attr("d", line(data));

svg.selectAll("dot")
    .data(data)
    .enter().append("circle")
    .attr("r", 5)
    .attr("cx", function(d) { return x(d.date); })
    .attr("cy", function(d) { return y(d.close); })
    .attr("fill","steelblue")
// Tooltip stuff after this
    .on("mouseover", function(d) {
        div.transition()
                .duration(500)
                .style("opacity", 0);
        div.transition()
                .duration(200)
                .style("opacity", .9);
        div.html("Saldo: " + d.close)
                .style("left", (d3.event.pageX) + "px")
                .style("top", (d3.event.pageY - 50) + "px");
    });

// Add the X Axis
svg.append("g")
    .attr("class", "x axis")
    .attr("transform", "translate(0," + height + ")")
    .call(xAxis);

// Add the Y Axis
svg.append("g")
    .attr("class", "y axis")
    .call(yAxis);
});


//End Grafica de linea



}); 