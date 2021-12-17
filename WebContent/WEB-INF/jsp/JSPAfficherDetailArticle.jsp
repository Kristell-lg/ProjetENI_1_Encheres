<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- CSS -->

<link rel="stylesheet" href="css/headerFooter.css"/>
<link rel="stylesheet" href="css/AfficherProfil.css" />
<!-- FONT ECONOMICA -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" >
<link href="https://fonts.googleapis.com/css2?family=Economica&display=swap" rel="stylesheet">
<!-- ICONE DE PAGE -->
<link rel="Shortcut Icon" href="css/images/iconeOsna.png">

<title>Détail Article</title>
</head>
<body>
	<div id="main">

<%@ include file="/WEB-INF/jsp/pageAccueil/headerCO.html" %>
	
	<c:choose>
		<c:when test="${empty requestScope.erreur}">

			
			<c:if test="${!empty requestScope.article and sessionScope.utilisateur.getNo_utilisateur()==requestScope.article.getUtilisateur().getNo_utilisateur()}">
				
				<h2 id="titre">Détail Vente</h2>
			<div id="container"	>
				<h3>${requestScope.article.getNom_article()}</h3>
				<p>Description : ${requestScope.article.getDescription()}</p>
				<p>Catégorie : ${requestScope.article.getCategorie().getLibelle()}</p>
				
				<p>Meilleur Offre : ${requestScope.article.getPrix_vente()}</p>
				
				<p>Mise à prix : ${requestScope.article.getPrix_initial()}</p>
				<p>Retrait : ${requestScope.retrait.Afficher()}</p>
				<p>Vendeur : ${requestScope.article.getUtilisateur().getPseudo()}</p>
				</div>
			</c:if>
			
			<c:if test="${!empty requestScope.article and sessionScope.utilisateur.getNo_utilisateur()!=requestScope.article.getUtilisateur().getNo_utilisateur()}">
				<div id="container"	>
					<h2 id="titre">Détail Vente</h2>
					<h3 id="titre">${requestScope.article.getNom_article()}</h3>
					<p>Description : ${requestScope.article.getDescription()}</p>
					<p>Catégorie : ${requestScope.article.getCategorie().getLibelle()}</p>
					
					<p>Meilleur Offre : ${requestScope.article.getPrix_vente()}</p>
					
					<p>Mise à prix : ${requestScope.article.getPrix_initial()}</p>
					<p>Retrait : ${requestScope.retrait.Afficher()}</p>
					<p>Vendeur : ${requestScope.article.getUtilisateur().getPseudo()}</p>
					
					<form action="${pageContext.request.contextPath}/FaireEncheres" method="post">
						<input type="hidden" name="articleId" value="${requestScope.article.getNo_article()}">					
						<input type="number" name="enchere" min="0">
						<input type="submit" value="Enchérir">
					</form>
				</div>
			</c:if>
			<c:if test="${empty requestScope.article}">
				<div id="position">
					<div id="container">
					<p class="erreur">Erreur - veuillez réessayer</p>
					</div>
				</div>
			</c:if>
			
		</c:when>
		
		<c:otherwise>
		
		<h2 id="titre">Détail Vente</h2>
		
			<div id="position">
				<div id="container">
					<p class="erreur">${requestScope.erreur}</p>
				</div>
			</div>
			
			<br>
			
			<div id="container"	>
				<h3 id="titre">${requestScope.article.getNom_article()}</h3>
				<p>Description : ${requestScope.article.getDescription()}</p>
				<p>Catégorie : ${requestScope.article.getCategorie().getLibelle()}</p>
				
				<p>Meilleur Offre :</p>
				
				<p>Mise à prix : ${requestScope.article.getPrix_initial()}</p>
				<p>Retrait : ${requestScope.retrait.Afficher()}</p>
				<p>Vendeur : ${requestScope.article.getUtilisateur().getPseudo()}</p>
				
				<form action="${pageContext.request.contextPath}/FaireEncheres" method="post">
					<input type="hidden" name="articleId" value="${requestScope.article.getNo_article()}">					
					<input type="number" name="enchere" min="0">
					<input type="submit" value="Enchérir">
				</form>
			</div>
		</c:otherwise>
		
	</c:choose>
	
	<%@ include file="/WEB-INF/jsp/pageAccueil/footer.html" %>
	</div>

</body>
</html>