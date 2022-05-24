<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>page d'inscription</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
<link href="css/style.css" rel="stylesheet" type="text/css"/>
<style>
	footer{
	display:flex;
	align-items:flex-start;
	justify-content: space-around;
	}
	footer p{
		border-top:1px solid #777;
		width: 900px;
		text-align:center;
		padding-top:20px;
	}
</style>
</head>
<body>
	<%@include file="header.jsp" %>
	<section class="container mt-4 inscription shadow-sm p-3">
		<h3 class="lead text-center">Inscrivez vous pour pouvoir voter !!!</h3>
		<form action="inscription.do" method="post">
			<div class="form-group">
				<label class="" for="nom">Nom</label>
				<input class="form-control" name="nom" type="text" required="required"/>
			</div>
			<div class="form-group">
				<label class="" for="nom">Prenom</label>
				<input class="form-control" name="prenom" type="text" required/>
			</div>
			<div class="form-group">
				<label class="" for="nom">Adresse</label>
				<input class="form-control" name="adresse" type="text" required/>
			</div>
			<div class="form-group">
				<label class="" for="nom">Numero de telephone</label>
				<input class="form-control" name="numero" type="text" required/>
			</div>
			<div class="form-group">
				<label class="" for="nom">CIN</label>
				<input class="form-control" name="cin" type="text" required/>
			</div>
			<div class="form-group">
				<label class="" for="password">Mot de passe</label>
				<input class="form-control" name="password" type="password" required/>
			</div>
			<div class="btn-inscription">
				<button class="btn btn-primary" type="submit">S'inscrire</button>
			</div>
		</form>
	</section>
	<div class="mt-5">
	<footer class="p-4 mt-4 lead">
		<p>Copyright @Tovonjanahary 2022</p>
	</footer>
</div>
</body>
</html>