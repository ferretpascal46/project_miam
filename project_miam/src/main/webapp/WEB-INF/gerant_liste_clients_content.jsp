<h1>Liste de vos clients</h1>

${requestScope.toto}

<table>
<thead>
	<tr>
		<th>Nom Prenom</th>
		<th>Email</th>
		<th>Adresse</th>
		<th>Téléphone</th>
		<th>date création compte</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach items ="${requestScope.utilisateurs}" var="client">
		<tr>
			<td><c:out value="${client.key.getNom() }${ client.key.getPrenom()} "/></td>
			<td><c:out value="${client.value}"/></td>
			<td><c:out value="${client.key.getNumeroRue()} ${ client.key.getRue()} ${ client.key.getComplement()}"/></td>
			<td><c:out value="${client.key.getTelephone()}"/></td>
			<td><c:out value="${client.key.getDateCreation()}"/></td>
		</tr>
	</c:forEach>
	</tbody>
</table>