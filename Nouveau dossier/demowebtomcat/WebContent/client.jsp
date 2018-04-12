<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>  
<!DOCTYPE PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Bootstrap time...</title>
		<!-- css de bootstrap -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<!-- css perso -->
		<link rel="stylesheet" href="css/style.css">

		<!-- jquery de bootstrap -->
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
		
		
		<script
  src="https://code.jquery.com/jquery-3.3.1.min.js"
  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
  crossorigin="anonymous"></script>
		<!-- js perso si besoin -->
		<script src="javascript/scriptClient.js" type="text/javascript"></script>
		
	</head>
	<body>
		
		<div class="container opacityContainer">		
			
			<!-- menu -->
			<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav mr-auto">
						<li class="nav-item">
							<a class="nav-link" href="ServletIndex">Welcome</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="create.html">Create</a>
						</li>
						<li class="nav-item active testMenu">
							<a class="nav-link" href="#">Client<span class="sr-only">(current)</span></a>
						</li>
					</ul>
				</div>
			</nav>
			
			<!-- contenu de la partie central -->
			<div>
				<!-- titre -->
				<h1 class="positionTitre">G'day, client</h1>
				
				<div class="formArea">

					<form method="POST">
						<div class="form-row">
							<div class="form-group col-md-6">
								<label for="inputFirstName">First Name</label>
								<input type="text" class="form-control" id="inputFirstName" placeholder="First" name="leNom" value="<c:out value="${not empty client.nom ? client.nom : ''}"/>">
							</div>
							<div class="form-group col-md-6">
								<label for="inputLastName">Last Name</label>
								<input type="text" class="form-control" id="inputLastName" placeholder="Last Name" name="lePrenom" value="<c:out value="${not empty client.prenom ? client.prenom : ''}"/>">
							</div>
						</div>
						<div class="form-group">
							<label for="inputEmail4">Email</label>
							<input type="email" class="form-control" id="inputEmail4" placeholder="Email" name="leMail" value="<c:out value="${not empty client.email ? client.email : ''}"/>">
						</div>
						<div class="form-group">
							<label for="inputPhoneNumber">Phone Number</label>
							<input type="text" class="form-control" id="inputPhoneNumber" placeholder="Phone Number" name="lePhoneNumber" value="<c:out value="${not empty client.phoneNumber ? client.phoneNumber : ''}"/>">
						</div>
						<div class="form-group">
							<label for="inputAddress2">Address</label>
							<input type="text" class="form-control" id="inputAddress2" placeholder="Address" name="lAdresse" value="<c:out value="${not empty client.adresse ? client.adresse : ''}"/>">
						</div>

						<div id="btnUpdate" class="btn btn-primary">Update</div>
						<div id="btnDelete" class="btn btn-danger">Delete</div>

					</form>



				</div>
				
				
			</div>
			
			
		</div>
		
	</body>
</html>