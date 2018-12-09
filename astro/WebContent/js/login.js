function checkLogin(){
	var webServiceURL = location.origin + '/astro/processlogin';
	var vuserid = document.getElementById("email").value;
	var vpassword = document.getElementById("password").value;

	$.ajax({
		url: webServiceURL, 
		type: 'POST',
		data:{userid:vuserid,password:vpassword},        
		success: processLogin, 
		error: processLoginServerError
	});
	
}

function processLogin(data, status, request){
//	alert("Received Data" + data);
	switch(data){
	case 'Customer':
		window.location.assign(location.origin + '/astro/customer.html');
		break;
	case 'Astrologer':
		window.location.assign(location.origin + '/astro/astrologer.html');
		break;
	default:
		alert("Some issue");
	
	}
}

function processLoginServerError(data,status,request){
	alert("Some server error" + request.toString() + status);
}

function signIn(){
	document.getElementById("loginform-create").style.display = "none";
	document.getElementById("loginform-login").style.display = "block";
	
}

function signUp(){
	document.getElementById("loginform-create").style.display = "block";
	document.getElementById("loginform-login").style.display = "none";
	
}