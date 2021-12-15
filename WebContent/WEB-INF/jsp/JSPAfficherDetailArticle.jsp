<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="Shortcut Icon" href="css/images/iconeOsna.png">
<title>Détail Article</title>
</head>
<body>
<%@ include file="/WEB-INF/jsp/pageAccueil/header.html" %>
	
	<c:choose>
		<c:when test="${empty requestScope.erreur}">
			<form action="${pageContext.request.contextPath}/AfficherArticle" method="post">
			<input type="number" name="idArticle" min="0">
			<input type="submit">
			</form>
			
			<c:if test="${!empty requestScope.article and sessionScope.utilisateur.getNo_utilisateur()==requestScope.article.getUtilisateur().getNo_utilisateur()}">
				
				<h2>Détail Vente</h2>
				<h3>${requestScope.article.getNom_article()}</h3>
				<p>Description : ${requestScope.article.getDescription()}</p>
				<p>Catégorie : ${requestScope.article.getCategorie().getLibelle()}</p>
				
				<p>Meilleur Offre :</p>
				
				<p>Mise à prix : ${requestScope.article.getPrix_initial()}</p>
				<p>Retrait : ${requestScope.retrait.Afficher()}</p>
				<p>Vendeur : ${requestScope.article.getUtilisateur().getPseudo()}</p>
				
			</c:if>
			
			<c:if test="${!empty requestScope.article and sessionScope.utilisateur.getNo_utilisateur()!=requestScope.article.getUtilisateur().getNo_utilisateur()}">
				
				<h2>Détail Vente</h2>
				<h3>${requestScope.article.getNom_article()}</h3>
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
				
			</c:if>
			<c:if test="${empty requestScope.article}">
				<p>Erreur - veuillez réessayer</p>
			</c:if>
			
		</c:when>
		
		<c:otherwise>
			<p>${requestScope.erreur}</p>
			
			<h2>Détail Vente</h2>
				<h3>${requestScope.article.getNom_article()}</h3>
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
			
		</c:otherwise>
		
	</c:choose>
	
	<%@ include file="/WEB-INF/jsp/pageAccueil/footer.html" %>
</body>
</html>