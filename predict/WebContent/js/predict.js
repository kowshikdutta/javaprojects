function uploadFile() {
 var deliveryDate = document.getElementById("datepicker").value;
 var deliveryNumber = document.getElementById("deliverynumber").value;
 var url = window.location.protocol + "//"+ window.location.host + "/predict/predict";
 
 
 
var formdata = new FormData(document.getElementById("inputform"));
 
$.ajax({  type:"POST",
	      url:url,
	      data:formdata,
	      processData: false,
	      contentType:false,
	      success: setData,
	      error: setError
	      });
}


function setData(data,status){
		var resultobject = JSON.parse(data);
		var finaloutput = resultobject["OneSigma"] + "\n" + resultobject["TwoSigma"] + "\n"
		                  +  resultobject["ThreeSigma"];
		var finalnote = "Note: There are " + resultobject["TotalRecords"] + " records on the file. Of which " + resultobject["ValidCount"] + " records are valid. There were " + resultobject["ErrorCount"] + " error records which are not processed";
		document.getElementById("outputtext").value = finaloutput + "\n\n" + finalnote;	
}

function setError(response,status,errormessage){
	document.getElementById("outputtext").value = "Error on the server side. Error no:" + status; 
}

function pageLoad(){
	alert("This site runs on Chrome and Safari");
}

function getResult() {
	 var result = document.getElementById("outputtext").value;
	 var url = window.location.protocol + "//"+ window.location.host + "/predict/GetResult";
	 
	 alert(url);
	 window.location.href  = url;
/*	
	 $.fileDownload('url', {
	     successCallback: function (url) {
	  
	         alert('You just got a file download dialog or ribbon for this URL :' + url);
	     },
	     failCallback: function (html, url) {
	  
	         alert('Your file download just failed for this URL:' + url + '\r\n' +
	                 'Here was the resulting error HTML: \r\n' + html
	                 );
	     }
	 });*/
	}

function getError() {
	 var result = document.getElementById("outputtext").value;
	 var url = window.location.protocol + "//"+ window.location.host + "/predict/GetError";
	 
	 alert(url);
	 window.location.href  = url;

/*	 $.fileDownload('url', {
	     successCallback: function (url) {
	  
	         alert('You just got a file download dialog or ribbon for this URL :' + url);
	     },
	     failCallback: function (html, url) {
	  
	         alert('Your file download just failed for this URL:' + url + '\r\n' +
	                 'Here was the resulting error HTML: \r\n' + html
	                 );
	     }
	 }); */
	}

function reportResultSuccess(data,status){
	
}

function reportResultFailed(){
	
}

function reportErrorSuccess(){
	
}

function reportErrorFailed(){
	
}