<!-- @author: Maxence -->
<%@ page language="java" 
			contentType="text/html; charset=UTF-8"
    		pageEncoding="UTF-8"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Supprimer Article</title>
		<!-- CSS -->
<link rel="stylesheet" href="css/headerFooter.css"/>
<link rel="stylesheet" href="css/AfficherProfil.css"> <!-- Applique le nouveau design -->

		<!-- FONT ECONOMICA -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Economica&display=swap" rel="stylesheet">
		<!-- ICONE DE PAGE -->
<link rel="Shortcut Icon" href="css/images/iconeOsna.png">

    
	</head>
	<body>
	<div id="main">
	<%@ include file="/WEB-INF/jsp/pageAccueil/headerCO.html" %>
		<form method="post" action="${pageContext.request.contextPath}/SupprimerEnchere">
		<c:if test="${!empty requestScope.msgMdpCorrespondance}">
			<p style="color:red">${requestScope.msgMdpCorrespondance}</p>
		</c:if><h1 id="titre">Supprimer Enchère</h1>
			 		<div id="container">
			
				<p>Veuillez saisir votre pseudo et mot de passe pour effectuer la suppression de l'enchère</p>
				<br>
					
						<label for="pseudo">*Pseudo : </label>
						<input type="text" name="pseudo" id="pseudo" maxlength="30" required/>
							
						<label for="mdp">*Mot de passe : </label>
						<input type="password" name="mdp" id="mdp"maxlength="30" pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$" required/>
					
					
			<!-- Bouton -->
			<br>
			<p>Attention cette suppression sera définitive</p>
				<input type="submit" value="Supprimer Enchere"/>
				<input type="reset" value="Annuler"/>
			</div>
		</form>
		
			
		<%@ include file="/WEB-INF/jsp/pageAccueil/footer.html" %>
		</div>
	</body>
</html>