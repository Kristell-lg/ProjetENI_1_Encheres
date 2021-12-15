<!-- @author Clément -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- CSS -->

<link rel="stylesheet" href="css/headerFooter.css"/>
<link rel="stylesheet" href="css/ConnexionUser.css" />
<!-- FONT ECONOMICA -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin >
<link href="https://fonts.googleapis.com/css2?family=Economica&display=swap" rel="stylesheet">
<!-- ICONE DE PAGE -->
<link rel="Shortcut Icon" href="css/images/iconeOsna.png">

<title>Detail vente</title>
</head>
<body>
		<form method="post" action="${pageContext.request.contextPath}/FaireEncheres">

<h1>Détail vente</h1>

		<p class="afficherEnchere" >${article.getNom_article()}</p>
		<p class="afficherEnchere">Description :${article.getDescription()}</p>
		<p class="afficherEnchere">Catégorie :${article.getCategorie()}</p>
		<p class="afficherEnchere">Meilleure offre :${article.getPrix_vente()}</p>
		<p class="afficherEnchere">Mise à prix:${article.getPrix_initial()}</p>
		<p class="afficherEnchere">Fin d'echère : :${article.getDate_fin_encheres()}</p>
		
			<p class="afficherEnchere">Retrait
			<a>${utilisateur.getRue()}</a><br>
			<a>${utilisateur.getCode_postal()}</a> <a>${utilisateur.getVille()}</a>
			</p>
		
		<p class="afficherEnchere">Vendeur :${utilisateur.getPseudo()}</p> <!-- comment aller chercher l'utilisateur vendeur ? -->
		
		<label class="afficherEnchere" for="ma_proposition">Ma proposition : </label>
			<input class="afficherEnchere" type="number" name="ma_proposition" required>
		
		<div class="enchere-Bouton">
				<input type="submit" value="Enchérir"/>
		</div>
	</form>
</body>
</html>