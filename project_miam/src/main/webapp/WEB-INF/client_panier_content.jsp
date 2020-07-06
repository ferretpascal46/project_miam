<h1>Votre panier</h1>
<table>
	<thead>
		<tr>
			<td>Produit(s) choisi(s)</td>
			<td>Prix unitaire</td>
		</tr>
	</thead>
	<tbody>
		 <c:forEach items="${requestScope.produits}" var="panier">
			<tr>
				<td> ${panier.getTypeProduit()} :  ${panier.getNomProduit() }</td>
				<td></td>
				<td>quantite 1</td>
				<td>prix : ${panier.getPrix()} Eur</td>
				<td><input type="button" value="-"><input type="button"
					value="+"></td>
			</tr>
		</c:forEach>		
	</tbody>
</table>