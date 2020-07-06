
<div class="content page1">
	<script>
		addEventListener("load", function() {
			setTimeout(hideURLbar, 0);
		}, false);

		function hideURLbar() {
			window.scrollTo(0, 1);
		}
	</script>
	<div class="ic">group3 LDNR formation 2020</div>
	<div class="container_12">
		<div class="grid_7">
			<h2>Bienvenue à MIAM-MIAM Gourmet</h2>
			<div class="page1_block col1">
				<img src="./include/images/welcome_img.png" alt="">
				<div class="extra_wrapper">
					<!-- <p><span class="col2"><a href="http://blog.templatemonster.com/free-website-templates/" rel="nofollow"></a>
 -->
					</span> L'Equipe Groupe 3 vous présente son restaurant étoilé toulousain.
					</p>
					Tout est épuré comme pour mieux aller à l'essentiel. Nous vous
					accueillons dans une expérience culinaire unique. <a href="#"
						class="btn">more</a>
				</div>
				<div class="clear"></div>
			</div>
		</div>
		<div class="grid_5">

			<h2>Nos Spécialités</h2>
			<ul class="list">
				<li><a href="#">Poulet à la Coriandre</a></li>
				<li><a href="#">Tomate à la provinciale</a></li>
				<li><a href="#">Souris d'agneau</a></li>
				<li><a href="#">Tiramisu aux Fraises</a></li>
			</ul>

		</div>
		<div class="clear"></div>
		<div class="grid_12">
			<div class="hor_separator"></div>
		</div>
		<div class="grid_12">
			<div class="car_wrap">
				<h2>Nos Cartes</h2>
				<a href="#" class="prev"></a><a href="#" class="next"></a>
				<ul class="carousel1">
					<c:forEach items="${requestScope.produits}" var="produit">
						<li>
							<div id="cart-${produit.getIdProduit()}">
								<div class="snipcart-details">
									<form action="#" method="post">
										<a href="#"> <c:if
												test='${produit.getTypeProduit() == "PLAT" }'>
												<img class="affichage_plat" src="./include/images/plat.png"
													alt="un super plat">
											</c:if> <c:if test='${produit.getTypeProduit() == "BOISSON" }'>
												<img class="affichage_plat"
													src="./include/images/boisson.png"
													alt="une superbe boisson">
											</c:if>
										</a>

										<div class="col1 upp">
											<a href="#">${produit.getNomProduit() }</a> <b>${produit.getPrix() }</b>
										</div>
										<!-- <span> Poulet Ã  la Coriandre</span> -->
										<input type="hidden" name="idProduit"
											value="${produit.getIdProduit() }"> <input
											type="hidden" name="cmd" value="_cart"> <input
											type="hidden" name="add" value="1"> <input
											type="hidden" name="w3l_item" value="Striped Top "> <input
											type="hidden" name="amount" value="29.00"> <input
											type="hidden" name="item_name" value="Product #001" />
										<button type="submit" class="button w3l-cart"
											data-id="cart-${produit.getIdProduit()}">Ajouter au
											panier</button>
									</form>
								</div>
							</div>
						</li>
					</c:forEach>
					<li>
						<!--  <div id="cart-1">
							<div class="snipcart-details">
								<form action="#" method="post">
									<a href="#"> <img src="./include/images/page1_img1.jpg"
										alt=""></a>
									<div class="col1 upp">
										<a href="#">Poulet à la Coriandre <b>29 Eur</b>
									</div>
									<!-- <span> Poulet Ã  la Coriandre</span> -!-> <input
						type="hidden" name="cmd" value="_cart"> <input
						type="hidden" name="add" value="1"> <input type="hidden"
						name="w3l_item" value="Striped Top "> <input type="hidden"
						name="amount" value="29.00"> <input type="hidden"
						name="item_name" value="Product #001" />
						<button type="submit" class="button w3l-cart" data-id="cart-1">Ajouter
							au panier</button>
						</form>
			</div>
		</div>

		</li>-->
				</ul>
			</div>

		</div>
		<div class="clear"></div>
		<div class="bottom_block">
			<div class="grid_6">
				<h3>Follow Us</h3>
				<div class="socials">
					<a href="#"></a> <a href="#"></a> <a href="#"></a>
				</div>
				<nav>
					<ul>
						<li class="current"><a href="index.html">Accueil</a></li>
						<li><a href="index-1.html">A propos de nous</a></li>
						<li><a href="index-2.html">Menu</a></li>
						<li><a href="index-3.html">Portefeuille</a></li>
						<li><a href="index-4.html">News </a></li>
						<li><a href="index-5.html">Connexion</a></li>
					</ul>
				</nav>
			</div>
			<div class="grid_6">
				<h3>Email Updates</h3>
				<p class="col1">Rejoignez Nous</p>
				<form id="newsletter">
					<div class="success">Your subscribe request has been sent!</div>
					<label class="email"> <input type="email"
						value="Enter e-mail address"> <a href="#" class="btn"
						data-type="submit">subscribe</a> <span class="error">*This
							is not a valid email address.</span>
					</label>
				</form>
			</div>
		</div>
		<div class="clear"></div>
	</div>
</div>
<div class="wthreecartaits wthreecartaits2 cart cart box_1">
	<form action="#" method="post" class="last">
		<input type="hidden" name="cmd" value="_cart" /> <input type="hidden"
			name="display" value="1" />
		<button class="w3view-cart" type="submit" name="submit" value="">
			view cart <span class="fa fa-cart-arrow-down" aria-hidden="true"></span>
		</button>
	</form>
</div>
<div class="copyright text-center">
	<!-- <p>Â© 2017 Shopping Cart. All rights reserved | Design by  
				<a href="http://w3layouts.com">W3layouts</a>  
			</p>-->
</div>