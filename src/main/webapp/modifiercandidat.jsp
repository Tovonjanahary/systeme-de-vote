<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifier un candidat</title>
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
	<div class="">
		<h3 class="text-center text-info">modifier un candidat</h3>
		<form action="updatecandidat.do" method="post" class="shadow-sm p-3 inscription">			
			<div class="form-group">
				<label class="control-label" for="id">ID:</label>
				<input type="hidden" class="form-control" name="id" value="${candidat.id_candidat}"/>
				<label class="fw-bold">${candidat.id_candidat}</label>
			</div>
			<div class="form-group">
				<label class="" for="nom">Nom</label>
				<input class="form-control" name="nom" type="text" required="required" value="${candidat.nom }"/>
			</div>
			<div class="form-group">
				<label class="" for="nom">Prenom</label>
				<input class="form-control" name="prenom" type="text" required  value="${candidat.prenom }"/>
			</div>
			<div class="form-group">
				<label class="" for="nom">email</label>
				<input class="form-control" name="email" type="text" required  value="${candidat.email }"/>
			</div>
			<div class="form-group">
				<label class="" for="nom">Adresse</label>
				<input class="form-control" name="adresse" type="text" required  value="${candidat.adresse }"/>
			</div>
			<div class="form-group">
				<label class="" for="nom">Numero de telephone</label>
				<input class="form-control" name="numero" type="text" required  value="${candidat.numero }"/>
			</div>
			<div class="form-group">
				<label class="" for="nom">CIN</label>
				<input class="form-control" name="cin" type="text" required  value="${candidat.cin }"/>
			</div>
			<div class="btn-inscription">
				<button class="btn btn-primary" type="submit">valider</button>
			</div>
		</form>
	 </div>
</body>
</html>