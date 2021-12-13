<!-- @author: Kristell --->	 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="Shortcut Icon" href="css/images/iconeOsna.png">
<link rel="stylesheet" href="css/reset.css"> <!-- Reset le design css -->
<link rel="stylesheet" href="css/inscription.css"> <!-- Applique le nouveau design -->

<title>Connexion</title>
</head>

<body>
<%@ include file="/WEB-INF/jsp/pageAccueil/header.html" %>
	<h1 id="titreConnexion">Connexion</h1>
	<form action="${pageContext.request.contextPath}/Connexion" method="post">
	
	<c:choose>
	
		<c:when test="${!empty requestScope.erreur}">
			<p id="msgErreurConnexionUtilisateur">${requestScope.erreur}</p>
			<label class="LabelFormulaireConnexion" for="pseudo">Pseudo : </label>
			<input class="inputFormulaireConnexion" type=text name="pseudo" value="${requestScope.pseudoSaisi}" required>
			<label class="LabelFormulaireConnexion" for="mot_de_passe">Mot de passe : </label>
			<input class="inputFormulaireConnexion" type="password" name="mot_de_passe" required>
			<input class="inputFormulaireConnexion" type="submit" value="Se Connecter">
		</c:when>
		
		<c:otherwise>
			<label class="LabelFormulaireConnexion" for="pseudo">Pseudo : </label>
			<input class="inputFormulaireConnexion" type=text name="pseudo" required>
			<label class="LabelFormulaireConnexion" for="mot_de_passe">Mot de passe : </label>
			<input class="inputFormulaireConnexion" type="password" name="mot_de_passe" required>
			<input class="inputFormulaireConnexion" type="submit" value="Se Connecter">
		</c:otherwise>
	</c:choose>
		<p>Si vous n'êtes pas encore inscrit c'est par ici ►<button><a href="${pageContext.request.contextPath}/ServletInscriptionutilisateur">S'inscrire</a></button>
	</form>
	
	<%@ include file="/WEB-INF/jsp/pageAccueil/footer.html" %>
</body>
</html>