<!-- @author: Luka CHOUVILLE -->
<!-- @update: Maxence -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Profil</title>
		<!-- CSS -->
<link rel="stylesheet" href="css/headerFooter.css"/>
<link rel="stylesheet" href="css/AfficherProfil.css" />

<!-- FONT ECONOMICAAAS -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin >
<link href="https://fonts.googleapis.com/css2?family=Economica&display=swap" rel="stylesheet">
<!-- ICONE DE PAGE -->
<link rel="Shortcut Icon" href="css/images/iconeOsna.png">
	<body>
	<div id="main">
	<%@ include file="/WEB-INF/jsp/pageAccueil/headerCO.html" %>
	<c:choose>
		<c:when test="${!empty requestScope.utilisateur}">
			<h1 id="titre">Profil de ${requestScope.utilisateur.getPseudo()}</h1>
						
						<label for="Pseudo">Pseudo : </label>
						<input type="text" name="Pseudo" id="Pseudo" value="${requestScope.utilisateur.getPseudo()}" disabled/>	
						
						<label for="prenom">Prénom : </label>
						<input type="text" name="prenom" id="prenom" value="${requestScope.utilisateur.getPrenom()}" disabled/>
						
						<label for="nom">Nom : </label>
						<input type="text" name="nom" id="nom" value="${requestScope.utilisateur.getNom()}" disabled/>
						
						<label for="email">Email : </label>
						<input type="email" name="email" id="email" value="${requestScope.utilisateur.getEmail()}" disabled/>
						
						<label for="tel">Téléphone : </label>
						<input type="tel" name="tel" id="tel" value="${requestScope.utilisateur.getTelephone()}" disabled/>
						
						<label for="rue">Rue : </label>
						<input type="text" name="rue" id="rue" value="${requestScope.utilisateur.getRue()}" disabled/>
						
						<label for="ville">Ville : </label>
						<input type="text" name="ville" id="ville" value="${requestScope.utilisateur.getVille()}" disabled/>
						
						<label for="codepostal">Code Postal : </label>
						<input type="text" name="codepostal" id="codepostal" value="${requestScope.utilisateur.getCode_postal()}" disabled/>
						
						<label for="credit">Crédit : </label>
						<input type="text" name="cerdit" id="credit" value="${requestScope.utilisateur.getCredit()}" disabled/>
					
		</c:when>
		
		<c:when test="${!empty sessionScope.utilisateur}">
			<h1 id="titre">Mon profil</h1>
			 <div id="container">
						<label for="Pseudo">Pseudo : </label>
						<input type="text" name="Pseudo" id="Pseudo" value="${sessionScope.utilisateur.getPseudo()}" disabled/>	
						
						<label for="prenom">Prénom : </label>
						<input type="text" name="prenom" id="prenom" value="${sessionScope.utilisateur.getPrenom()}" disabled/>
						
						<label for="nom">Nom : </label>
						<input type="text" name="nom" id="nom" value="${sessionScope.utilisateur.getNom()}" disabled/>
						
						<label for="email">Email : </label>
						<input type="email" name="email" id="email" value="${sessionScope.utilisateur.getEmail()}" disabled/>
						
						<br>
					    <br>
						
						<label for="tel">Téléphone : </label>
						<input type="tel" name="tel" id="tel" value="${sessionScope.utilisateur.getTelephone()}" disabled/>
						
						<br>
						<br>
						
						<label for="rue">Rue : </label>
						<input type="text" name="rue" id="rue" value="${sessionScope.utilisateur.getRue()}" disabled/>
						
						<label for="ville">Ville : </label>
						<input type="text" name="ville" id="ville" value="${sessionScope.utilisateur.getVille()}" disabled/>
						
						<label for="codepostal">Code Postal : </label>
						<input type="text" name="codepostal" id="codepostal" value="${sessionScope.utilisateur.getCode_postal()}" disabled/>
						
						<label for="credit">Crédit : </label>
						<input type="text" name="cerdit" id="credit" value="${sessionScope.utilisateur.getCredit()}" disabled/>
					
					
			<form action="${pageContext.request.contextPath}/ModifierProfil" method="get">
					<input type="submit" value="Modifier" />
			</form>
				</div>
		</c:when>
		
	</c:choose>
		<%@ include file="/WEB-INF/jsp/pageAccueil/footer.html" %>
		</div>
	</body>
</html>