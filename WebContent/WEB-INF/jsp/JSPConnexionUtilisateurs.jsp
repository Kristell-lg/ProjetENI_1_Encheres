<!-- @author: Kristell --->	 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- CSS  -->


<link rel="stylesheet" href="css/headerFooter.css"/>
<link rel="stylesheet" href="css/ConnexionUser.css" />
<!-- FONT ECONOMICA -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin >
<link href="https://fonts.googleapis.com/css2?family=Economica&display=swap" rel="stylesheet">
<!-- ICONE DE PAGE -->
<link rel="Shortcut Icon" href="css/images/iconeOsna.png">


<title>Connexion</title>
</head>

<body>
<div id="main">
<%@ include file="/WEB-INF/jsp/pageAccueil/header.html" %>
<div id="container">
	<h1 id="titreConnexion">Connexion</h1>
	<form action="${pageContext.request.contextPath}/Connexion" method="post">
	
	<c:choose>
	
		<c:when test="${!empty requestScope.erreur}">
		<div id="container">
			<p id="msgErreurConnexionUtilisateur">${requestScope.erreur}</p>
			<label class="LabelFormulaireConnexion" for="pseudo">Pseudo : </label>
			<input class="inputFormulaireConnexion" type=text name="pseudo" value="${requestScope.pseudoSaisi}" required>
			<label class="LabelFormulaireConnexion" for="mot_de_passe">Mot de passe : </label>
			<input class="inputFormulaireConnexion" type="password" name="mot_de_passe" required>
			<input class="inputFormulaireConnexion" type="submit" value="Se Connecter">
			</div>
		</c:when>
		
		<c:otherwise>
		<div id="container">
			<label class="LabelFormulaireConnexion" for="pseudo">Pseudo : </label>
			<input class="inputFormulaireConnexion" type=text name="pseudo" required>
			<label class="LabelFormulaireConnexion" for="mot_de_passe">Mot de passe : </label>
			<input class="inputFormulaireConnexion" type="password" name="mot_de_passe" required>
			<input class="inputFormulaireConnexion" type="submit" value="Se Connecter">
			</div>
		</c:otherwise>
	</c:choose>
	<div id="Inscrire">
		<p>Si vous n'êtes pas encore inscrit c'est par ici ►
		<button><a href="${pageContext.request.contextPath}/Inscription">S'inscrire</a></button>
		 </div>
	</form>
	</div>
	<%@ include file="/WEB-INF/jsp/pageAccueil/footer.html" %>
	</div>
</body>
</html>