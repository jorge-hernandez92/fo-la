$(document).ready(function () {
	
	var r1 = 1;
	var r2 = 1;
	
	var refreshId = setInterval( function() 
    {
		while(r1 == r2){
			r2 = Math.floor((Math.random() * 3) + 1);
		}
		r1 = r2;
		
		$('#bg').css({ backgroundImage: "url(img/lincoln/dynamic_background/" + r1 + ".jpg)" });
		
    }, 5000);

});