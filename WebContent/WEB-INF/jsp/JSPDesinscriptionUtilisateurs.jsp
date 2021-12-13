<!-- @author: Clément Corcuff -->

<%@ page language="java" 
			contentType="text/html; charset=UTF-8"
    		pageEncoding="UTF-8"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Désinscription</title>
		<link rel="stylesheet" href="css/reset.css"> <!-- Reset le design css -->
        <link rel="stylesheet" href="css/inscription.css"> <!-- Applique le nouveau design -->
    
	</head>
	<body>
		<form method="post" action="${pageContext.request.contextPath}/Desinscription">
		<c:if test="${!empty requestScope.msgMdpCorrespondance}">
			<p style="color:red">${requestScope.msgMdpCorrespondance}</p>
		</c:if>
			<fieldset class="desinscription">
				<div class="desinscription-champs">
				<p>Veuillez saisir votre pseudo et mot de passe pour effectuer la suppression de votre compte</p>
				<p>Cette suppression sera définitive</p>
					<div>
						<label for="pseudo">*Pseudo : </label>
						<input type="text" name="pseudo" id="pseudo" maxlength="30" required/>
					</div>
					<div>		
						<label for="mdp">*Mot de passe : </label>
						<input type="password" name="mdp" id="mdp"maxlength="30" pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$" required/>
						<p style="color:grey;font-size: 0.7em;" class="formatMdp">Au moins 8 caractères avec une lettre minuscule, une lettre majuscule, un chiffre et un caractère spécial</p>	
					</div>
					</div>
			</fieldset>
			<!-- Bouton -->
			<div class="desinscription-Bouton">
				<input type="submit" value="Se désinscrire"/>
				<input type="reset" value="Annuler"/>
			</div>
		</form>
	</body>
</html>