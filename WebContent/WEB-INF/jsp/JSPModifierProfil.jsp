<!-- @author: Luka CHOUVILLE -->
<%@ page language="java" 
			contentType="text/html; charset=UTF-8"
    		pageEncoding="UTF-8"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Modifier mon profil</title>
	<!-- CSS -->

<link rel="stylesheet" href="css/headerFooter.css"/>
<link rel="stylesheet" href="css/AfficherProfil.css"> <!-- Applique le nouveau design -->

	<!-- FONT ECONOMICAA -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin >
<link href="https://fonts.googleapis.com/css2?family=Economica&display=swap" rel="stylesheet">
	<!-- ICONE DE PAGE -->
<link rel="Shortcut Icon" href="css/images/iconeOsna.png">
		
    
	</head>
	<body>
	<div id="main">
	<%@ include file="/WEB-INF/jsp/pageAccueil/header.html" %>
		<form method="post" action="${pageContext.request.contextPath}/ModifierProfil">
		<c:if test="${!empty requestScope.erreur}">
			<p style="color:red">${requestScope.erreur}</p>
		</c:if>
		
		
		<c:choose>
			 <c:when test="${!empty sessionScope.utilisateur}">
			 		<h1 id="titre">Modification du profil</h1>
			 		<div id="container">
				<div class="inscription-champs">
					<div>
						<label for="pseudo">Pseudo : </label>
						<input type="text" name="pseudo" id="pseudo" value="${sessionScope.utilisateur.getPseudo()}" maxlength="30" />
					</div>
					<div>		
						<label for="prenom">Prénom : </label>
						<input type="text" name="prenom" id="prenom"  value="${sessionScope.utilisateur.getPrenom()}" maxlength="30" />
					</div>
					<div>	
						<label for="nom">Nom : </label>
						<input type="text" name="nom" id="nom" value="${sessionScope.utilisateur.getNom()}" maxlength="30" />
					</div>
					<div>
						<label for="mdp">Mot de passe actuel : </label>
						<input type="password" name="exmdp" id="mdp"   maxlength="30" pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$" required/>
						<p style="color:grey;font-size: 0.7em;" class="formatMdp">Au moins 8 caractères avec une lettre minuscule, une lettre majuscule, un chiffre et un caractère spécial</p>	
					</div>
					<div>
						<label for="mdp">Nouveau Mot de passe : </label>
						<input type="password" name="mdp" id="mdp"maxlength="30" pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$" />
						<p style="color:grey;font-size: 0.7em;" class="formatMdp">Au moins 8 caractères avec une lettre minuscule, une lettre majuscule, un chiffre et un caractère spécial</p>	
					</div>
					<div>			
						<label for="mdpVerif">Confirmation Mot de passe: </label>
						<input type="password" name="mdpVerif" id="mdpVerif" maxlength="30" pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$" />
					</div>
				</div>
				<div class="inscription-champs">
					
						<label for="email">Email : </label>
						<input type="email" pattern="+@+." name="email" id="email" value="${sessionScope.utilisateur.getEmail()}" maxlength="20" />
					
						<label for="tel">Téléphone : </label>
						<input type="tel" name="tel" id="tel" value="${sessionScope.utilisateur.getTelephone()}" maxlength="15"/>
					
						<label for="rue">*Rue : </label>
						<input type="text" name="rue" id="rue" value="${sessionScope.utilisateur.getRue()}" maxlength="30" />
					
						<label for="ville">*Ville : </label>
						<input type="text" name="ville" id="ville" value="${sessionScope.utilisateur.getVille()}" maxlength="30" />
					
						<label for="codepostal">*Code Postal : </label>
						<input type="text" name="codepostal" id="codepostal" value="${sessionScope.utilisateur.getCode_postal()}" maxlength="5" />
					
			 </c:when>
			 
			 <c:otherwise>
			 	<p>Erreur</p>
			</c:otherwise>
		</c:choose>
		
			<!-- Bouton -->
			
				<input type="submit" value="Enregistrer"/>
			
		</form>
		
			<form action="${pageContext.request.contextPath}/Desinscription">
				<input type="submit" value="Supprimer le compte"/>
			</form>
		
	</body>
	
</html>