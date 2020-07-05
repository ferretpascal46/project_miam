 	<!-- main -->
	 	<div class="main-w3layouts wrapper">
		<h1>Inscription</h1>
		<div class="main-agileinfo">
			<div class="agileits-top">
				<form action="inscription" method="post">
					<input class="text" type="text" name="nomUser" placeholder="Nom" required="">
					<input class="text" type="text" name="prenomUser" placeholder="Prenom" required="">
					<input class="text" type="number" name="numRue" placeholder="Numero rue" required="">
					<input class="text" type="text" name="rue" placeholder="Rue" required="">
					<input class="text" type="text" name="complementAdresse" placeholder="Complement Adresse">
					<input class="text" type="number" name="codePostale" placeholder="Code Postale" required="">
					<input class="text" type="text" name="Ville" placeholder="ville" required="">
					<input class="text" type="tel" name="Telephone" placeholder="Téléphone" required="">
					<input class="text email" type="email" name="email" placeholder="Email" required="">
					<input class="text" type="password" name="password" placeholder="Mot de passe" required="">
					<input class="text w3lpass" type="password" name="password" placeholder="Confirmer le mot de passe" required="">
					<div class="wthree-text">
						<label class="anim">
							<input type="checkbox" class="checkbox" required="">
							<span>J'accepte les conditions d'utilisation</span>
						</label>
						<div class="clear"> </div>
					</div>
					<p id= messageInscription>${requestScope.message}</p>
					<input type="submit" name="formSoumis" value="Inscription">
				</form>
				<p>Vous avez un compte ? <a href="connexionForm">Connectez vous</a></p>
			</div>
		</div>
	</div>