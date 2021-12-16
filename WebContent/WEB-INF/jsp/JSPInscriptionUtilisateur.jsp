<!-- @author: Luka CHOUVILLE -->
<!-- @update: Kristell -->
<!-- @update Maxence  -->
<%@ page language="java" 
			contentType="text/html; charset=UTF-8"
    		pageEncoding="UTF-8"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Inscription</title>
		<!-- CSS  -->
<link rel="stylesheet" href="css/headerFooter.css"/>
<link rel="stylesheet" href="css/AfficherProfil.css">
		<!-- FONT ECONOMICA -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin >
<link href="https://fonts.googleapis.com/css2?family=Economica&display=swap" rel="stylesheet">
		<!-- ICONE DE PAGE -->
<link rel="Shortcut Icon" href="css/images/iconeOsna.png">

    
	</head>
	<body>
	<div id="main">
	<%@ include file="/WEB-INF/jsp/pageAccueil/header.html" %>
	
	<h1 id="titre">Inscription</h1>
			 		<div id="container">
		<form method="post" action="${pageContext.request.contextPath}/Inscription">
		
		<c:if test="${!empty requestScope.erreur}">
			<p style="color:red">${requestScope.erreur}</p>
		</c:if>
		
			<label for="pseudo">*Pseudo : </label>
						<input type="text" name="pseudo" id="pseudo" value="${requestScope.pseudo}" maxlength="30" required/>
							
						<label for="prenom">*Prénom : </label>
						<input type="text" name="prenom" id="prenom" maxlength="30" value="${requestScope.prenom}" required/>
					
						<label for="nom">*Nom : </label>
						<input type="text" name="nom" id="nom" maxlength="30" value="${requestScope.nom}" required/>
					
						<label for="mdp">*Mot de passe : </label>
						<input type="password" name="mdp" id="mdp"maxlength="30" pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$" required/>
						<p style="color:grey;font-size: 0.7em;" class="formatMdp">Au moins 8 caractères avec une lettre minuscule, une lettre majuscule, un chiffre et un caractère spécial</p>	
								
						<label for="mdpVerif">*Confirmation Mot de passe: </label>
						<input type="password" name="mdpVerif" id="mdpVerif" maxlength="30" pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$" required/>
					
				
						<label for="email">*Email : </label>
						<input type="email" pattern="+@+." name="email" id="email" value="${requestScope.email}"maxlength="50" required/>
					
						<br>
						<br>
						
						<label for="tel">Téléphone : </label>
						<input type="tel" name="tel" id="tel" maxlength="10" pattern="^((\+)33|0)[1-9](\d{2}){4}$" value="${requestScope.tel}"required/>
						
						<br>
						<br>
						
						<label for="rue">*Rue : </label>
						<input type="text" name="rue" id="rue"maxlength="30" value="${requestScope.rue}" required/>
					
						<label for="ville">*Ville : </label>
						<input type="text" name="ville" id="ville"maxlength="30" value="${requestScope.ville}" required/>
						
						<label for="codepostal">*Code Postal : </label>
						<input type="text" name="codepostal" id="codepostal" pattern="^(([0-8][0-9])|(9[0-5]))[0-9]{3}$" value="${requestScope.codepostal}" maxlength="5" required/>
					
			<!-- Bouton -->
				<input type="submit" value="Créer"/>
		
		<form action="${pageContext.request.contextPath}/Accueil">
			<input type="submit" value="Annuler"/>
		</form>
		</div>
		<%@ include file="/WEB-INF/jsp/pageAccueil/footer.html" %>
		</div>
	</body>
</html>