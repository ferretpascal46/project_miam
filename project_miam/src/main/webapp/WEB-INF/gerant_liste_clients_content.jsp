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
	<c:forEach items ="${requestScope.utilisateurs}" var="utilisateur">
		<tr>
			<td><c:out value="${requestScope.utilisateur}"/></td>
			<td>${true && true }</td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
	</c:forEach>
	</tbody>
</table>