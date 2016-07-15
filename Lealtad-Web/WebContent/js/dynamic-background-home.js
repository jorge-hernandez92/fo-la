$(document).ready(function () {
	
	var r1 = 1;
	var r2 = 1;
	
	var refreshId = setInterval( function() 
    {
		while(r1 == r2){
			r2 = Math.floor((Math.random() * 2) + 1);
		}
		r1 = r2;
		
		$('.header-image').css({ backgroundImage: "url(img/ford/dynamic_background_home/" + r1 + "h.jpg)" });
		
		//rl(../img/ford/dynamic_background_home/
		
		//console.log(r1);
		
    }, 5000);

});