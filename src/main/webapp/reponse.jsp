<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>page d'authentification</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
<link href="css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<%@include file="header.jsp" %>
	
	<section class="container mt-4 inscription shadow-sm p-3">
		<h3 class="lead text-center alert alert-danger">Reconnecter vous pour confirmer votre choix</h3>
		<c:if test=" ${!empty error}"><p><c:out value="${error}"/></p></c:if>
		<form action="reconnecter.do" method="post">
			<div class="form-group">
				<label class="" for="nom">Nom</label>
				<input class="form-control" name="nom" type="text" required="required"/>
			</div>
			<div class="form-group">
				<label class="" for="password">password</label>
				<input class="form-control" name="password" type="password" required/>
			</div>
			<div class="btn-inscription">
				<button class="btn btn-primary" type="submit">reconnecter</button>
			</div>
		</form>
		
	</section>
</body>
</html>