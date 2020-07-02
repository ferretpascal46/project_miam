<h1>Bienvenue dans la modification de votre carte</h1>
<p>
<span class="col2">Pour ajouter un plat</span><br>
<form method="POST" action="<c:url value="produit" />">
    <fieldset>
        <legend>Ajouter un plat</legend>
          <label for="nomProduit">Plat <span class="requis">*</span></label>
        <input type="text" id="nomProduit" name="nomProduit" value="<c:out value="${requestScope.produit.nomProduit}" />" size="20" maxlength="60" />
</fieldset>       
</form>    
<span class="col2">Ajouter une boisson</span>
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