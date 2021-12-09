<!-- @author: Kristell -->	 
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
	<h1>Connexion</h1>
	<form action="${pageContext.request.contextPath}/ServletConnexionUtilisateurs" method="post">
	
	<c:choose>
	
		<c:when test="${!empty requestScope.msgErreurConnexion}">
			<p>${requestScope.msgErreurConnexion}</p>
			<label for="pseudo">Pseudo : </label>
			<input type=text name="pseudo" value="${requestScope.pseudoSaisi}" required>
			<label for="mot_de_passe">Mot de passe : </label>
			<input type="password" name="mot_de_passe" required>
			<input type="submit" value="Se Connecter">
		</c:when>
		
		<c:otherwise>
			<label for="pseudo">Pseudo : </label>
			<input type=text name="pseudo" required>
			<label for="mot_de_passe">Mot de passe : </label>
			<input type="password" name="mot_de_passe" required>
			<input type="submit" value="Se Connecter">
		</c:otherwise>
		
	</c:choose>
		
	</form>
</body>
</html>