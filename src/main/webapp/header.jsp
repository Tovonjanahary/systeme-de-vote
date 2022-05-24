<header>
	<nav class="bg-light">
		<ul class="authentification">
			<li><a href="accueil.do">Accueil</a></li>
			<li><a href="candidat.do">Vote</a></li>
			<li>A propos</li>
		</ul>
		<c:if  test="${!empty sessionScope.nom}">
			<div>
				<span>Bienvenu: <a>${sessionScope.nom }</a></span>
				<a href="deconnexion.do" class="btn btn-outline-primary" onclick="confirm('se deconnecter ?')">se Deconnecter</a>
			</div>
		</c:if>
		<c:if test="${empty sessionScope.nom}">
			<div>
				<a href="connexion.do" class="btn btn-primary">Se connecter</a>
				<a href="inscrire.do" class="btn btn-outline-primary me-2">S'inscrire</a>
			</div>
		</c:if>
	</nav>
</header>