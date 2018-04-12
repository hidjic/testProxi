<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ProxiBanque</title>

<!-- cdn pour utilisation de bootstrap -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
	integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"
	integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm"
	crossorigin="anonymous"></script>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"
	integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ"
	crossorigin="anonymous"></script>

<!-- css ajouter -->
<link rel="stylesheet" href="css/style.css">

</head>
<body>

	<!-- container central -->
	<div class="container">
	
		<!-- menu -->
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item">
						<a class="nav-link" href="ServletListClient">Liste des clients</a>
					</li>
					<li class="nav-item active">
						<a class="nav-link" href="#">Liste des comptes<span class="sr-only">(current)</span></a>
					</li>
				</ul>
			</div>
		</nav>
		
		<!-- contenu de la page -->
		<div class="form-row positionHautPage">
			<div class="clientArea col-sm-6">
				<label><h3>Client</h3></label></br>
				<label><h5>Nom : </h5></label><span>TOTO</span></br>
				<label><h5>Pr�nom : </h5></label><span>Toto</span></br>
			</div>
			
			<div class="creationCompteArea text-right col-sm-6">
				<label><h5>Cr�ation d'un nouveau compte : </h5></label>
				<button type="button" class="btn btn-primary">Cr�er</button>
			</div>
		</div>
		
		<table class="table">
		  <thead>
		    <tr>
		      <th scope="col">#</th>
		      <th scope="col">Num�ro compte</th>
		      <th scope="col">Date cr�ation</th>
		      <th scope="col">Type</th>
		      <th scope="col">Solde</th>
		    </tr>
		  </thead>
		  <tbody>
		    <tr>
		      <th scope="row">1</th>
		      <td>987654</td>
		      <td>02/02/2016</td>
		      <td>Courant</td>
		      <td>1200</td>      
		    </tr>
		    <tr>
		      <th scope="row">2</th>
		      <td>987655</td>
		      <td>02/02/2016</td>
		      <td>Epargne</td>
		      <td>321321.00</td>
		    </tr>
		    <tr>
		      <th scope="row">3</th>
		      <td>987656</td>
		      <td>02/02/2016</td>
		      <td>Epargne</td>
		      <td>32100.00</td>
		    </tr>
		  </tbody>
		</table>
		
		
		

	</div>

</body>
</html>