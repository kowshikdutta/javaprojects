/*window.onload = function(){

}
*/

function getPrediction(sign){
var webServiceURL = location.origin + '/astro/forecastmonthly';
var element = document.getElementById('forecastform-body');

$.ajax({
	url: webServiceURL, 
	type: 'GET',
	data:{Year:2017,Month:12,Sign:sign.id},
	dataType: 'json', 
	jsonp: false,
	cache:false,
	success: function(data,status,response) {
		             var header = "<h2>" + sign.id + "   December " +  2017 + "</h2><br>";
		             if(data.Result == null){
		     		 var general = "<h2>General</h2><p>" + data.general + "</p><br>";
		     		 var finance = "<h2>Finance</h2><p>" + data.finance+ "</p><br>"; 
		     		 var health  ="<h2>Health</h2><p>" + data.health + "</p><br>";
		     		 var relationship = "<h2>Relationship</h2><p>" + data.relationship+ "</p><br>";
		     		 var family = "<h2>Family & Friends</h2><p>" + data.family + "</p><br>";
		     		 var advice = "<h2>Advice</h2><p>" + data.advice + "</p><br>";
		     		 var luckydays = "<h2>Lucky Days</h2><p>" + data.luckydays + "</p><br>";
		     		 element.innerHTML = header + general + finance + health + relationship + family + advice + luckydays;
		             } else{
		            	 element.innerHTML = header + "<h2>No Data Found </h2>";	 
		             }
	                 document.getElementById("forecastform").style.visibility="visible";}, 
	error: function(response,status,errormessage) {
	    	   element.innerHTML = "Status =" + status + errormessage;
	    	   document.getElementById("forecastform").style.visibility="visible";   
	}
});

}


function showLogin(){

document.getElementById("loginform").style.visibility="visible";

}

function processLogin(){

var userid = document.getElementById("email").value;
var password = document.getElementById("password").value

alert("User Id:" + userid + " Password: " + password);

}


function placeOrder(){

switch(event.target.id) {
    case 'content-item1':
        alert("Got a call to make free horoscope");
        break;
    case 'content-item2':
        document.getElementById("orderform").style.visibility="visible";
        break;
    case 'content-item3':
        alert("Got a call to make a marriage match");
        break;
    default:
        alert("Something wrong happened. Please check");
}

}

/******************Close any form******************************/

function closeForm(formname){
document.getElementById(formname).style.visibility="hidden";

}

/******************End of Close any form******************************/


/******************Process steps of order******************************/

function processOrder(){
switch(event.target.id) {
    case 'orderform-button-next':
        alert("Got to payment");
        break;
    case 'orderform-button-previous':
         alert("Nothing to do");
        break;
    default:
        alert("Something wrong happened. Please check");
}
}

/******************End processing of Order******************************/
/*$.ajax({
	url: webServiceURL, 
	type: 'GET',
	data:{BRAND:brand,DEALER:dealer,YEAR:year},
	dataType: 'json',           
	success: populateContribution, 
	error: contributionError
});*/