$(document).on('click', '.submenu li a', function() {
	switch ($(this).attr('href').substring(1)) {
	case "customertable":
		fillCustomer("#cust1");
		break;
	case "modeltable":
		fillModel("#modeltable");
		break;
	case "dealertable":
		fillDealer("#dealertable");
		break;
	case "salestable":
		fillSales("#salestable");
		break;
	case "salescontribution":
		fillSalesContribution("#salescontribution");
		break;
	default:
		alert("call comes here");
	}
});


function fillCustomer(tabletag) {
	createCustomerTable(tabletag);
	getCustomer();
}

function fillModel(tabletag) {
	createModelTable(tabletag);
	getModel();
}

function fillDealer(tabletag) {
	createDealerTable(tabletag);
	getDealer();
}

function fillSales(tabletag) {
	createSalesTable(tabletag);
	getSales();
}


function fillSalesContribution(tabletag) {
	createSalesContributionTable(tabletag);
	getSalesContribution();
}



/**
 * *********************************Customer Function***********************************************************************************
 */

function createCustomerTable(tabletag) {
	var url = location.origin + '/Udemy2/SinglePageTable2.html' + ' '
			+ tabletag;
	$("#output").load(url);
}

function createModelTable(tabletag) {
	var url = location.origin + '/Udemy2/SinglePageTable2.html' + ' '
			+ tabletag;
	$("#output").load(url);
}

function createDealerTable(tabletag) {
	var url = location.origin + '/Udemy2/SinglePageTable2.html' + ' '
			+ tabletag;
	$("#output").load(url);
}

function createSalesTable(tabletag) {
	var url = location.origin + '/Udemy2/SinglePageTable2.html' + ' '
			+ tabletag;
	$("#output").load(url);
}

function createSalesContributionTable(tabletag) {
	var url = location.origin + '/Udemy2/SinglePageTable2.html' + ' '
			+ tabletag;
	$("#output").load(url);
}

/*************************************Fill Data *********************************************************************/

function getCustomer() {
	var webServiceURL = location.origin + '/Udemy2/GetCustomer';
	$.ajax({
		url : webServiceURL,
		type : 'GET',
		dataType : 'json',
		success : fillCustomerTable,
		error : CustomerError
	});
}

function fillCustomerTable(data, status, response) {

	var level1obj = data["CustomerList"];

	var table = document.getElementById("cust1");
	var colNumber = 9; // number of table columns

	var tableRef = table.getElementsByTagName('tbody')[0];
	
	$(data.CustomerList).each(function(index,value){
		var row = tableRef.insertRow(tableRef.rows.length);
		var cell1 = row.insertCell(0);
		var cell2 = row.insertCell(1);
		var cell3 = row.insertCell(2);
		var cell4 = row.insertCell(3);
		var cell5 = row.insertCell(4);
		var cell6 = row.insertCell(5);
		var cell7 = row.insertCell(6);
		var cell8 = row.insertCell(7);
		var cell9 = row.insertCell(8);


		cell1.innerHTML = value.CustomerId;
		cell2.innerHTML = value.Firstname;
		cell3.innerHTML = value.Lastname;
		cell4.innerHTML = value.Street;
		cell5.innerHTML = value.City;
		cell6.innerHTML = value.State;
		cell7.innerHTML = value.Phone;
		cell8.innerHTML = value.Email;
		cell9.innerHTML = value.Gender;

	});

}

function CustomerError(request, status, error) {
	alert('error' + request + status + error);
}
/**************************Filling up Model Table****************************************************************/

function getModel() {
	var webServiceURL = location.origin + '/Udemy2/GetModel';
	$.ajax({
		url : webServiceURL,
		type : 'GET',
		dataType : 'json',
		success : fillModelTable,
		error : ModelError
	});
}

function fillModelTable(data, status, response) {

	var level1obj = data["ModelList"];

	var table = document.getElementById("modeltable");
	var colNumber = 9; // number of table columns

	var tableRef = table.getElementsByTagName('tbody')[0];
	
	$(data.ModelList).each(function(index,value){
		var row = tableRef.insertRow(tableRef.rows.length);
		var cell1 = row.insertCell(0);
		var cell2 = row.insertCell(1);
		var cell3 = row.insertCell(2);
		

		cell1.innerHTML = value.Brand;
		cell2.innerHTML = value.Model;
		cell3.innerHTML = "Some values for future";

	});

}

function ModelError(request, status, error) {
	alert('error' + request + status + error);
}

/**************************Filling up Model Table Finished****************************************************************/

/**************************Filling up Dealer Table****************************************************************/

function getDealer() {
	var webServiceURL = location.origin + '/Udemy2/GetDealer';
	$.ajax({
		url : webServiceURL,
		type : 'GET',
		dataType : 'json',
		success : fillDealerTable,
		error : DealerError
	});
}

function fillDealerTable(data, status, response) {

	var level1obj = data["DealerList"];

	var table = document.getElementById("dealertable");


	var tableRef = table.getElementsByTagName('tbody')[0];
	
	$(data.DealerList).each(function(index,value){
		var row = tableRef.insertRow(tableRef.rows.length);
		var cell1 = row.insertCell(0);
		var cell2 = row.insertCell(1);
		var cell3 = row.insertCell(2);
		var cell4 = row.insertCell(3);
		var cell5 = row.insertCell(4);
		var cell6 = row.insertCell(5);
		

		cell1.innerHTML = value.DLRID;
		cell2.innerHTML = value.DLRNAME;
		cell3.innerHTML = value.DLRADDRESS;
		cell4.innerHTML = value.DLRCONTACT;
		cell5.innerHTML = value.DLRPHONE;
		cell6.innerHTML = value.DLRMAIL;
		
			});

}

function DealerError(request, status, error) {
	alert('error' + request + status + error);
}

/**************************Filling up Dealer Table Finished****************************************************************/

/**************************Filling up Sales Table****************************************************************/

function getSales() {
	var webServiceURL = location.origin + '/Udemy2/GetSales';
	$.ajax({
		url : webServiceURL,
		type : 'GET',
		dataType : 'json',
		success : fillSalesTable,
		error : SalesError
	});
}

function fillSalesTable(data, status, response) {

	var level1obj = data["SalesList"];
	var table = document.getElementById("salestable");
	var tableRef = table.getElementsByTagName('tbody')[0];
	
	$(data.SalesList).each(function(index,value){
		var row = tableRef.insertRow(tableRef.rows.length);
		var cell1 = row.insertCell(0);
		var cell2 = row.insertCell(1);
		var cell3 = row.insertCell(2);
		var cell4 = row.insertCell(3);
		var cell5 = row.insertCell(4);
		var cell6 = row.insertCell(5);
		var cell7 = row.insertCell(6);
		

		cell1.innerHTML = value.CUSTOMERID;
		cell2.innerHTML = value.DLRID;
		cell3.innerHTML = value.VIN;
		cell4.innerHTML = value.SALESDATE;
		cell5.innerHTML = value.MODEL;
		cell6.innerHTML = value.SALESPRICE;
		cell7.innerHTML = value.CURRENCY;
			});

}

function SalesError(request, status, error) {
	alert('error' + request + status + error);
}

/**************************Filling up Sales Table Finished****************************************************************/

/**************************Filling up SalesContribution Table****************************************************************/

function getSalesContribution() {
	var webServiceURL = location.origin + '/Udemy2/GetContribution';
	$.ajax({
		url : webServiceURL,
		type : 'GET',
		dataType : 'json',
		success : fillSalesContributionTable,
		error : SalesContributionError
	});
}

function fillSalesContributionTable(data, status, response) {

	var table = document.getElementById("salescontributiontable");
	var tableRef = table.getElementsByTagName('tbody')[0];
	var dataarray = [];
	dataarray.push(['Model','Sales']);
	
	$(data.SALESCONTRIBUTIONLIST).each(function(index,value){
		var row = tableRef.insertRow(tableRef.rows.length);
		var cell1 = row.insertCell(0);
		var cell2 = row.insertCell(1);
		var cell3 = row.insertCell(2);
		var cell4 = row.insertCell(3);
			

		cell1.innerHTML = value.BRAND;
		cell2.innerHTML = value.MODEL;
		cell3.innerHTML = value.SALESPRICE;
		cell4.innerHTML = value.CURRENCY;
		dataarray.push([value.MODEL,value.SALESPRICE]);
		});
	
	drawChart(dataarray);


}

function SalesContributionError(request, status, error) {
	alert('error' + request + status + error);
}

function drawChart(dataarray){
	var data = google.visualization.arrayToDataTable(dataarray);
	var options = {
			title: 'Sales by Model',
			is3D: true,
			backgroundColor:'#CCCCFF',
			fontSize: 10,
			chartArea:{left:0,top:40,width:'100%',height:'100%'}
			
	};
	var chart = new google.visualization.PieChart(document.getElementById('chartarea'));
	chart.draw(data, options);
}

/**************************Filling up Sales Contribution Table Finished****************************************************************/