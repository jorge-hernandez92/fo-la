$(document).ready(function () {
	
	var r1 = 1;
	var r2 = 1;
	
	var refreshId = setInterval( function() 
    {
		while(r1 == r2){
			r2 = Math.floor((Math.random() * 2) + 1);
		}
		r1 = r2;
		
		$('#bg').css({ backgroundImage: "url(img/dynamic_background/" + r1 + ".jpg)" });
//		console.log(r1);
    }, 5000);

});