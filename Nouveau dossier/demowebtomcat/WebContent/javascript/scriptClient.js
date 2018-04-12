window.onload = function(){
	console.log("onload...");
	document.getElementById('btnUpdate').onclick = updateClient;
	document.getElementById('btnDelete').onclick = deleteClient;
}

function deleteClient(){
	console.log("test delete btn...");
	console.log(document.URL);
	var url = document.URL;
	var idClient = url.split('=')[1];
	console.log(idClient);
//	var endUrl = url.lastIndexOf('/');
//	console.log(endUrl);
//	var newUrl = url.slice(0,endUrl);
//	console.log(newUrl);
//	window.location.replace(newUrl+"/ServletClient?delete="+idClient);
	
	
	$.ajax({
		  type: "POST",
		  url: "ServletClient",
		  deleteClient: idClient,
		  success: function(){
			  console.log("success..");
		  }
		});
}

function updateClient(){
	console.log("test update btn...");
}
