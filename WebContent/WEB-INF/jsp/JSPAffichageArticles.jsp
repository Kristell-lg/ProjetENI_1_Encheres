<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.time.format.DateTimeFormatter" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="Shortcut Icon" href="css/images/iconeOsna.png">
<title>Catalogue Articles</title>
</head>
<body>
<%@ include file="/WEB-INF/jsp/pageAccueil/header.html" %>
	<c:choose>
		<c:when test="${empty requestScope.erreur}">
			<p class="affichageArticle">Bonjour ${sessionScope.utilisateur.getPseudo()} !</p>
			<p class="affichageArticle">Crédit : ${sessionScope.utilisateur.getCredit()} points</p>
			<a class="affichageArticle" href="/ProjetENI_1_Encheres/ServletCreationArticles">Mettre en vente un article</a>
			<a class="affichageArticle" href="/ProjetENI_1_Encheres/Profil">Mon Profil</a>
			<a class="affichageArticle" href="/ProjetENI_1_Encheres/Deconnexion">Déconnexion</a>
		</c:when>
		
		<c:otherwise>
			<p id="msgErreurConnexionUtilisateur">${requestScope.erreur}</p>
		</c:otherwise>
		
	</c:choose>	
	
	<h1>Catalogue des articles</h1>
	
		<c:choose>
		
			<c:when test="${!empty articlesListe}">
				
				<form action="${pageContext.request.contextPath}/Accueil" method="post">
						<label for="categorie">Catégorie:</label>
			
						<select name="categorie" id="categorie">
						    <option value=0>--Choisir une catégorie--</option>
						    <option value=1>Informatique</option>
						    <option value=2>Ameublement</option>
						    <option value=3>Vêtement</option>
						    <option value=4>Sport et Loisirs</option>
						</select>
						
						<label for="categorie">Achats :</label>
			
						<select name="categorie" id="categorie">
						    <option value=0>--Choisir dans mes achats--</option>
						    <option value=1>Enchères ouvertes</option>
						    <option value=2>Mes enchères en cours</option>
						    <option value=3>Mes enchères remportées</option>
						</select>
						
						<label>  OU  </label>
						<label for="categorie">Mes ventes :</label>
			
						<select name="categorie" id="categorie">
						    <option value=0>--Choisir dans mes ventes--</option>
						    <option value=1>Mes vente en cours</option>
						    <option value=2>Ventes non débutées</option>
						    <option value=3>Mes ventes terminées</option>
						</select>
						<input type="submit" value="Valider">
					</form>
			
			
			
				<c:forEach var="article" items="${articlesListe}">
				
					<form action="${pageContext.request.contextPath}/AfficherArticle" method="post">
						<input type="hidden" name="idArticle" value="${article.getNo_article()}">
						<button type="submit">${article.getNom_article()}</button>
					</form>	
					
					<p class="affichageArticle">Fin des enchères :${article.getDate_fin_encheres().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))}</p>
					<p class="affichageArticle">Prix initial :${article.getPrix_initial()}</p>
					<p class="affichageArticle">Vendeur :</p>
					
					<form action="${pageContext.request.contextPath}/Profil" method="post">
						<input type="hidden" name="idProfil" value="${article.getUtilisateur().getNo_utilisateur()}">
						<button type="submit">${article.getUtilisateur().getPseudo()}</button>
					</form>	
					
					<p class="affichageArticle">-----------------------------------------------</p>
					
				</c:forEach>
				
			</c:when>
			
			<c:otherwise>
				<p class="affichageArticle">
					Aucun article n'est disponible
				</p>
			</c:otherwise>
			
		</c:choose>	
		
		<h1>Catalogue des enchères</h1>
		
		<c:choose>
			<c:when test="${!empty EncheresListe}">
			<c:forEach var="enchereListe" items="${articlesListe}">
				
					<form action="${pageContext.request.contextPath}/AfficherArticle" method="post">
						<input type="hidden" name="idArticle" value="${article.getNo_article()}">
						<button type="submit">${article.getNom_article()}</button>
					</form>	
					
					<p class="affichageArticle">Fin des enchères :${article.getDate_fin_encheres().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))}</p>
					<p class="affichageArticle">Prix initial :${article.getPrix_initial()}</p>
					<p class="affichageArticle">Vendeur :${article.getUtilisateur().getPseudo()}</p>
					
					<form action="${pageContext.request.contextPath}/Profil" method="post">
						<input type="hidden" name="idProfil" value="${article.getUtilisateur().getNo_utilisateur()}">
						<button type="submit">${article.getUtilisateur().getPseudo()}</button>
					</form>	
					
					<p class="affichageArticle">-----------------------------------------------</p>
					
				</c:forEach>
				
			
			<c:otherwise>
				<p class="affichageArticle">
					Aucune enchère n'est disponible
				</p>
			</c:otherwise>
			</c:when>
			
			</c:choose>	

<%@ include file="/WEB-INF/jsp/pageAccueil/footer.html" %>
</body>
</html>