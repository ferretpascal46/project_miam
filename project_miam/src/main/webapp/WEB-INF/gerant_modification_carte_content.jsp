<h1>Bienvenue dans la modification de votre carte</h1>

<form method="POST" action="modification_carte" />
<table>
	<tr>
		<th>Ajouter un plat</th>
		<th></th>
		<th></th>
		<th></th>
	</tr>
	<tr>
		<td><label for="nomProduit"> Nom du plat </label></td>
		<td><input type="text" id="nomProduit" name="nomProduit"
			size="20" maxlength="60" /></td>
		<td><label for="prixProduit">Prix du plat </label></td>
		<td><input type="text" id="prixProduit" name="prixProduit"
			size="20" maxlength="60" /></td>
	</tr>
	<tr>
		<th>Ajouter une boisson</th>
		<th></th>
		<th></th>
		<th></th>
	</tr>
	<tr>
		<td><label for="nomBoisson">Nom de la boisson </label></td>
		<td><input type="text" id="nomBoisson" name="nomBoisson"
			size="20" maxlength="60" /></td>
		<td><label for="prixBoisson">Prix de la boisson </label></td>
		<td><input type="text" id="prixBoisson" name="prixBoisson"
			size="20" maxlength="60" /></td>
	</tr>
</table>

<br />

<input type="submit" value="Ajouter" />
<br>
<br>
<br>
<br>
<h2>Liste des plats et boissons proposés</h2>

<table>
	<tr>

		<th>Plat</th>
		<th>Prix</th>
		<th></th>
		<th></th>
	</tr>
	<c:forEach items="${requestScope.produits}" var="produit">
		<tr>
			<td>${produit.getNomProduit() }</td>
			<td>${produit.getPrix() }</td>
			<td><input type="button" value="Modifier"></td>
			<td><input type="button" value="Supprimer"></td>
		<tr>
	</c:forEach>
</table>