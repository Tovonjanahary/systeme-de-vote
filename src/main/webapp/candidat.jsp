<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>page d'accueil</title>
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
	<main class="mt-4">
		<h2 class="text-center lead">liste des candidats</h2>
		<section class="container d-flex justify-content-around mt-4">
			<c:forEach items="${candidats}" var="l">
				<div class="shadow-lg p-4 mt-4">		
					<c:if test="${l.id_candidat == sessionScope.id_candidat}">
						<p class="alert alert-success">merci d'avoir voter pour moi :)</p>
					</c:if>
					<p>candidat numero: ${l.id_candidat}</p>
					<p>Nom: ${l.nom}</p>
					<td> Prenom: ${l.prenom}</p>
					<a class="btn  btn-outline-primary" href="detailcandidat.do?id=${l.id_candidat}">Afficher plus d'information</a>		
				</div>
			</c:forEach>
		</section>
	</main>
	<div class="mt-5">
	<footer class="p-4 mt-4 lead">
		<p>Copyright @Tovonjanahary 2022</p>
	</footer>
</div>
</body>
</html>