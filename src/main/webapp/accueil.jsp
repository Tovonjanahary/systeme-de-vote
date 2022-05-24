<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>page d'accueil</title>
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
	<main>
		<section class="container mt-5 accueil">
			<div class="">
				<a class="btn btn-primary" href="candidat.do">VOTER VOTRE CANDIDAT</a>
				<br/>
				<h3 class="publicite mt-5 lead">
					<div>Participer pour le</div>
					<div class="text-danger display-4">bien de notre patrie</div>			
				</h3>
			</div>
			<div>
				<img src="photo/vote-png-icon-455870.png" alt="sary_fanehoana_vote"/>
			</div>
		</section>
	</main>
	<div class="mt-5 ">
		<footer class="p-4 mt-4 lead">
			<p>Copyright @Tovonjanahary 2022</p>
		</footer>
	</div>
</body>
</html>