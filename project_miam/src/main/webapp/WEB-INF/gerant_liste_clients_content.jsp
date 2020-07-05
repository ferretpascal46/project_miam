<h1>Liste de vos clients</h1>

${requestScope.toto}

<table class="table1">
<thead>
	<tr>
		<th>Nom Prenom</th>
		<th>Email</th>
		<th>Adresse</th>
		<th>Téléphone</th>
		<th>Date de la création du compte</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach items ="${requestScope.utilisateurs}" var="client">
		<tr>
			<td class="colonne1"><c:out value="${client.key.getNom() } ${ client.key.getPrenom()} "/></td>
			<td class="colonne2"><c:out value="${client.value}"/></td>
			<td class="colonne3"><c:out value="${client.key.getNumeroRue()} ${ client.key.getRue()} ${ client.key.getComplement()} ${client.key.getVille()} ${client.key.getCodePostal()}" /></td>
			<td class="colonne4"><c:out value="${client.key.getTelephone()}"/></td>
			<td class="colonne5"><c:out value="${client.key.getDateCreation()}"/></td>
		</tr>
	</c:forEach>
	</tbody>
</table>