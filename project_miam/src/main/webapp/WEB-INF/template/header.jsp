<header>
	<div class="container_12">
		<div class="grid_12">
			<h1>
				<a href="<c:url value='/index' />"><img
					src="./include/images/logo.png" alt="EXTERIOR"></a>
			</h1>

			<div class="menu_block">
				<nav class="">
					<ul class="sf-menu">
						<li <c:if test="${requestScope.page == 'index'}">class="current"</c:if>><a href="<c:url value='/index' />">Accueil</a></li>
						<!--  <li class="with_ul"><a href="<c:url value='/index_1' />">Nous</a>
							<ul>
								<li><a href="#"> Accueil</a></li>
								<li><a href="#">Good rest</a></li>
								<li><a href="#">Services</a></li>

							</ul></li>-->


						<c:choose>
							<c:when test="${empty sessionScope.user}">
								<li <c:if test="${requestScope.page == 'inscription'}">class="current"</c:if>><a href="<c:url value='/inscription' />">S'inscrire</a></li>
								<li <c:if test="${requestScope.page == 'connexion'}">class="current"</c:if>><a href="<c:url value='/connexionForm' />">Connexion</a></li>

							</c:when>
							<c:otherwise>
								<c:if test='${sessionScope.user.getRole()=="CLIENT" }'>
									<li <c:if test="${requestScope.page == 'panier'}">class="current"</c:if>><a href="<c:url value='/panier' />">votre Panier </a></li>
								</c:if>

								<c:if test='${sessionScope.user.getRole()=="GERANT" }'>

									<li <c:if test="${requestScope.page == 'inscriptionGerant'}">class="current"</c:if>><a href="<c:url value="/creation_gerant" />">Creer
											un nouveau gérant</a></li>
									<li <c:if test="${requestScope.page == 'listeClient'}">class="current"</c:if>><a href="<c:url value='/listeClient' />">Liste des
											clients</a></li>
									<li <c:if test="${requestScope.page == 'modificationCarte'}">class="current"</c:if>><a href="<c:url value='/modification_carte' />">Modifications
											des plats</a></li>
								</c:if>
																
								<li>									
									<a href="<c:url value="/deconnexion" />">Déconnexion</a>
									<span id="user">${sessionScope.user.getRole()} : ${sessionScope.user.getAdresseMail()}</span>
								</li>


							</c:otherwise>
						</c:choose>

					</ul>
				</nav>
				<div class="clear"></div>
			</div>
			<div class="clear"></div>
		</div>
	</div>

</header>