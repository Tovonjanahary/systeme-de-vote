<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>page administration</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
<link href="css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<header>
		<nav class="bg-light">
			<ul>
				<li><h3 class="">ADMINISTRATION</h3></li>
			</ul>
			<div>
				<a href="candidat.do" class="btn btn-outline-primary me-2">Liste des candidats</a>
			</div>
		</nav>
	</header>
	<main>
		<section class="container mt-4  shadow-sm p-3 row">
			<div class="col-md-6 ">
				<h3 class="text-center text-info">Ajouter un candidat</h3>
				<form action="ajoutcandidat.do" method="post" class="shadow-sm p-3">
					<div class="form-group">
						<label class="" for="nom">Nom</label>
						<input class="form-control" name="nom" type="text" required="required"/>
					</div>
					<div class="form-group">
						<label class="" for="prenom">Prenom</label>
						<input class="form-control" name="prenom" type="text" required/>
					</div>
					<div class="form-group">
						<label class="" for="email">email</label>
						<input class="form-control" name="email" type="text" required/>
					</div>
					<div class="form-group">
						<label class="" for="adresse">Adresse</label>
						<input class="form-control" name="adresse" type="text" required/>
					</div>
					<div class="form-group">
						<label class="" for="numero">Numero de telephone</label>
						<input class="form-control" name="numero" type="text" required/>
					</div>
					<div class="form-group">
						<label class="" for="cin">CIN</label>
						<input class="form-control" name="cin" type="text" required/>
					</div>
					<div class="btn-inscription">
						<button class="btn btn-primary" type="submit">valider</button>
					</div>
				</form>
			 </div>
			 <div class="col-md-6">				
			 	<h3 class="text-center text-info">liste des candidats</h3>		
				<table class="table container">
					<tr>
						<th>ID</th>
						<th>NOM</th>
						<th>PRENOM</th>
						<th>EMAIL</th>
						<th>ADRESSE</th>
						<th>CIN</th>
						<th>TELEPHONE</th>
						<th class="text-danger">ACTION</th>			
					</tr>
					<c:forEach items="${candidats}" var="p">
						<tr>
							<td>${p.id_candidat}</td>
							<td>${p.nom}</td>
							<td>${p.prenom}</td>
							<td>${p.email}</td> 
							<td>${p.adresse}</td> 	
							<td>${p.cin}</td> 	
							<td>${p.numero}</td> 	
							<td><a href="supprimercandidat.do?id=${p.id_candidat}" class="btn btn-outline-danger" onclick="return confirm('voulez-vous vraiment supprimer cet candidat?')">supprimer</a></td> 				
							<td><a href="modifiercandidat.do?id=${p.id_candidat}" class="btn btn-outline-info">modifier</a></td> 																		
						</tr>
					</c:forEach>				
				</table>
			 </div>
		</section>
	</main>
</body>
</html>