<div class="login-page">
	<h1>Se connecter</h1>
	<div class="form">
		<form action="connexionForm" method="post">
			<p id= erreurLogin>${requestScope.message}</p>
			<input type="text" name="email"
				placeholder="Adresse mail de l'utilisateur" /> <input
				type="password" name="password" placeholder="Mot de passe" />
			<button>Connexion</button>
			<p class="message">
				Vous n'avez pas de compte?<a href="inscription"> Inscrivez-vous</a>
			</p>
		</form>
	</div>
</div>