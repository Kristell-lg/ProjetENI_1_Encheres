<!-- @author: Luka CHOUVILLE -->
<!-- @update: Kristell -->
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
		<link rel="Shortcut Icon" href="css/images/iconeOsna.png">
		<link rel="stylesheet" href="css/reset.css"> <!-- Reset le design css -->
        <link rel="stylesheet" href="css/inscription.css"> <!-- Applique le nouveau design -->
    
	</head>
	<body>
	<%@ include file="/WEB-INF/jsp/pageAccueil/header.html" %>
	
		<form method="post" action="${pageContext.request.contextPath}/Inscription">
		
		<c:if test="${!empty requestScope.erreur}">
			<p style="color:red">${requestScope.erreur}</p>
		</c:if>
		
			<fieldset class="inscription">
				<div class="inscription-champs">
					<div>
						<label for="pseudo">*Pseudo : </label>
						<input type="text" name="pseudo" id="pseudo" pattern="^[a-zA-Z0-9_]*$" value="${requestScope.pseudo}" maxlength="30" required/>
					</div>
					<div>		
						<label for="prenom">*Prénom : </label>
						<input type="text" name="prenom" id="prenom" maxlength="30" value="${requestScope.prenom}" required/>
					</div>
					<div>	
						<label for="nom">*Nom : </label>
						<input type="text" name="nom" id="nom" maxlength="30" value="${requestScope.nom}" required/>
					</div>
					<div>
						<label for="mdp">*Mot de passe : </label>
						<input type="password" name="mdp" id="mdp"maxlength="30" pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$" required/>
						<p style="color:grey;font-size: 0.7em;" class="formatMdp">Au moins 8 caractères avec une lettre minuscule, une lettre majuscule, un chiffre et un caractère spécial</p>	
					</div>
					<div>			
						<label for="mdpVerif">*Confirmation Mot de passe: </label>
						<input type="password" name="mdpVerif" id="mdpVerif" maxlength="30" pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$" required/>
					</div>
				</div>
				<div class="inscription-champs">
					<div>
						<label for="email">*Email : </label>
						<input type="email" pattern="+@+." name="email" id="email" value="${requestScope.email}"maxlength="20" required/>
					</div>
					<div>
						<label for="tel">Téléphone : </label>
						<input type="tel" name="tel" id="tel" maxlength="10" pattern="^((\+)33|0)[1-9](\d{2}){4}$" value="${requestScope.tel}"required/>
					</div>
					<div>
						<label for="rue">*Rue : </label>
						<input type="text" name="rue" id="rue"maxlength="30" value="${requestScope.rue}" required/>
					</div>
					<div>
						<label for="ville">*Ville : </label>
						<input type="text" name="ville" id="ville"maxlength="30" value="${requestScope.ville}" required/>
					</div>
					<div>	
						<label for="codepostal">*Code Postal : </label>
						<input type="text" name="codepostal" id="codepostal" pattern="^(([0-8][0-9])|(9[0-5]))[0-9]{3}$" value="${requestScope.codepostal}" maxlength="5" required/>
					</div>
				</div>
			</fieldset>
			<!-- Bouton -->
			<div class="inscription-Bouton">
				<input type="submit" value="Créer"/>
			</div>
		</form>
		
		<form action="${pageContext.request.contextPath}/Accueil">
			<input type="submit" value="Annuler"/>
		</form>
		
		<%@ include file="/WEB-INF/jsp/pageAccueil/footer.html" %>
		
	</body>
</html>