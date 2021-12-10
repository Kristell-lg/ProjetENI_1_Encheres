<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Détail Article</title>
</head>
<body>
	<c:choose>
		<c:when test="${empty requestScope.erreur}">
			<form action="/ProjetENI_1_Encheres/ServletAfficherArticle" method="post">
			<input type="number" name="idArticle" min="0">
			<input type="submit">
			</form>
			
			<c:if test="${!empty requestScope.article}">
				<h2>Détail Vente</h2>
				<h3>${requestScope.article.getNom_article()}</h3>
				<p>Description : ${requestScope.article.getDescription()}</p>
				<p>Catégorie : ${requestScope.article.getCategorie().getLibelle()}</p>
				<p>Meilleur Offre : A REMPLIR AVEC ENCHERES</p>
				<p>Mise à prix : ${requestScope.article.getPrix_initial()}</p>
				<p>Retrait : A REMPLIR AVEC RETRAIT</p>
				<p>Vendeur : ${requestScope.article.getUtilisateur().getPseudo()}</p>
				<form action="" method="post">
					<input type="number" name="enchere" min="0">
					<input type="submit" value="Enchérir">
				</form>
			</c:if>
			
		</c:when>
		
		<c:otherwise>
			<p>${requestScope.erreur}</p>
		</c:otherwise>
		
	</c:choose>
	
	
</body>
</html>