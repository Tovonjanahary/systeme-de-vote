<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>A propos du candidat</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
<link href="css/style.css" rel="stylesheet" type="text/css"/>
<style>
	.accueil {
		display:flex;
		align-items:center;
		justify-content: space-around;
	}
	.publicite{
		display:flex;
		flex-direction:column;
		justify-content:center;
	}
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
		<h3 class="text-center mt-3">Bienvenue dans ma page</span></h3>
		<h6 class="text-center lead text-danger">Votez pour moi :)</h6>
		<p>Candidat numero : ${candidat.id_candidat}</p>
		<p>Nom: ${candidat.nom}</p>
		<p>Prenom: ${candidat.prenom}</p>
		<p>Adresse: ${candidat.adresse}</p>
		<p>Me contacter sur Email: ${candidat.email}</p>
		<p>Numero de Telephone: ${candidat.numero} </p>
		<p>nombre de vote: ${count.id_candidat}</p>
		
		<c:if  test="${empty sessionScope.nom && empty sessionScope.prenom }">
			<div class="alert alert-info">veuillez vous <span><a href="inscrire.do" class="text-danger lead">inscrire</a></span> pour pouvoir voter !!!</div>
		</c:if>
		
		<c:if test="${candidat.id_candidat == sessionScope.id_candidat}">
			<p class="alert alert-success">merci d'avoir voter pour moi :)</p>
		</c:if>
		
		<c:if test="${!empty sessionScope.nom}">
			<c:if test="${candidat.id_candidat != sessionScope.id_candidat}">
				<form action="voter.do" method="get">
					<input type="hidden" name="id_candidat" value="${candidat.id_candidat}"/>
					<input type="hidden" name="id_utilisateur" value="${sessionScope.id_utilisateur}"/>
					<button class="btn btn-outline-primary" type="submit">Votez pour moi</button>		
				</form>
			</c:if>
		</c:if>
	</section>
	<div class="mt-5">
	<footer class="p-4 mt-4 lead">
		<p>Copyright @Tovonjanahary 2022</p>
	</footer>
</div>
</body>
</html>