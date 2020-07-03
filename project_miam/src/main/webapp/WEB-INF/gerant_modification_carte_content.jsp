<h1>Bienvenue dans la modification de votre carte</h1>
<p>
<span class="col2">Pour ajouter un plat ou une boisson</span><br>
<form method="POST" action="<c:url value="produit" />">
    <fieldset>
        <legend>Ajouter un plat:</legend><br>
          <label for="nomProduit">Nom du plat </label>
        <input type="text" id="nomProduit" name="nomProduit" value="<c:out value="${requestScope.produit.nomProduit}" />" size="20" maxlength="60" />
  <label for="prix">Prix du plat </label>
        <input type="text" id="prix" name="prix" value="<c:out value="${requestScope.produit.prix}" />" size="20" maxlength="60" />
</fieldset>   
<br/>
<fieldset>
        <legend>Ajouter une boisson:</legend><br>
          <label for="nomProduit">Nom de la boisson </label>
        <input type="text" id="nomProduit" name="nomProduit" value="<c:out value="${requestScope.produit.nomProduit}" />" size="20" maxlength="60" />
<label for="prix">Prix de la boisson </label>
        <input type="text" id="prix" name="prix" value="<c:out value="${requestScope.produit.prix}" />" size="20" maxlength="60" />
</fieldset>      
</form>    
 <input type="submit" value="Ajouter" class="sansLabel" />
</p>
<p>
<span class="col2">Liste des plats proposés</span> <br>
<table>
<tr>
<td>Plat:</td>
<td><a href="#">${nomProduit}</a></td>
<td>Prix:</td>
<td><a href="#">${prix}</a></td>
<td><input type="button" value="Modifier"></td>
<td><input type="button" value="Supprimer"></td>
</tr>
</table>
<span class="col2">Liste des boissons proposées</span>
<table>
<tr>
<td>Boisson:</td>
<td><a href="#">${nomProduit}</a></td>
<td>Prix:</td>
<td><a href="#">${prix}</a></td>
<td><input type="button" value="Modifier"></td>
<td><input type="button" value="Supprimer"></td>
</tr>
</table>
</p>