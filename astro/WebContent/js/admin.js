function setForecast(source){

	document.getElementById("mainform").style.visibility="visible";
	
}

function closeForm(){
	document.getElementById("mainform").style.visibility="hidden";
}


function saveForecast(){
	var e1 = document.getElementById("mainform-selector-Year");
    var year = e1.options[e1.selectedIndex].value;
    var e2 = document.getElementById("mainform-selector-Month");
    var month = e2.options[e2.selectedIndex].value;
    var e3 = document.getElementById("mainform-selector-Sign");
    var sign = e3.options[e3.selectedIndex].value;
    var vgeneral      = document.getElementById("mainform-textarea-General").value;
    var vfinance      = document.getElementById("mainform-textarea-Finance").value;
    var vhealth       = document.getElementById("mainform-textarea-Health").value;
    var vrelationship = document.getElementById("mainform-textarea-Relationship").value;
    var vfamily = document.getElementById("mainform-textarea-Family").value;
    var vadvice = document.getElementById("mainform-textarea-Advice").value;
    var vluckydays    = document.getElementById("mainform-textarea-Luckydays").value;
    
    var webServiceURL   = location.origin + '/astro/forecastmonthly';
    var monthlyforecast = JSON.stringify({general:vgeneral,finance:vfinance,health:vhealth,family:vfamily,relationship:vrelationship,advice:vadvice,luckydays:vluckydays});
 //   console.log(monthlyforecast);

    $.ajax({
    	url: webServiceURL, 
    	type: 'POST',
        data:{Year:year,Month:month,Sign:sign,forecast:monthlyforecast},
    	dataType: 'text', 
    	success: function(data,status,response) {alert("Rows updated: "+ data);}, 
    	error: function(response,status,errormessage) {alert(errormessage + "I am from error");}
    });
	
}