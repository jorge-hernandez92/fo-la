$(document).ready(function () {
	
	var r1 = 1;
	
	var refreshId = setInterval( function() 
    {
		
		if(r1>=4){
			r1=1;
		}
		$('.header-image').css({ backgroundImage: "url(img/ford/dynamic_background_home/" + r1 + "h.jpg)" });
		r1++;	
		
    }, 10000);

});