<h1>Votre panier</h1>
<table>
	<thead>
		<tr>
			<td>Produit(s) choisi(s)</td>
			<td>Prix unitaire</td>
		</tr>
	</thead>
	<tbody>
		 <c:forEach items="${sessionScope.panier}" var="panier">
			<tr>
				<td> ${panier.getIdProduit() }</td>
				<td></td>
				<td>quantite 1</td>
				<td>+ Prix final</td>
				<td><input type="button" value="-"><input type="button"
					value="+"></td>
			</tr>
		</c:forEach>		
	</tbody>
</table>