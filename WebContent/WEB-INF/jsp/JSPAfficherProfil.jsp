<!-- @author: Luka CHOUVILLE -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Profile</title>
		<link rel="stylesheet" href="css/reset.css"> <!-- Reset le design css -->
        <link rel="stylesheet" href="css/profil.css"> <!-- Applique le nouveau design -->
	</head>
	<body>
		<fieldset>
			<div>
				<label for="Pseudo">Pseudo : </label>
				<input type="text" name="Pseudo" id="Pseudo" value="${requestScope.pseudo}" disabled/>	
			</div>
			<div>
				<label for="prenom">Prénom : </label>
				<input type="text" name="prenom" id="prenom" value="${requestScope.prenom}" disabled/>
			</div>
			<div>			
				<label for="nom">Nom : </label>
				<input type="text" name="nom" id="nom" value="${requestScope.nom}" disabled/>
			</div>
			<div>
				<label for="email">Email : </label>
				<input type="email" name="email" id="email" value="${requestScope.email}" disabled/>
			</div>
			<div>
				<label for="tel">Téléphone : </label>
				<input type="tel" name="tel" id="tel" value="${requestScope.tel}" disabled/>
			</div>
			<div>		
				<label for="rue">Rue : </label>
				<input type="text" name="rue" id="rue" value="${requestScope.rue}" disabled/>
			</div>
			<div>		
				<label for="ville">Ville : </label>
				<input type="text" name="ville" id="ville" value="${requestScope.ville}" disabled/>
			</div>
			<div>			
				<label for="codepostal">Code Postal : </label>
				<input type="text" name="codepostal" id="codepostal" value="<%=request.getAttribute("cp") %>" disabled/>
			</div>
			
<!-- 		<c:if test=""> -->
				<input type="button" value="Modifier" />
<!-- 		</c:if> -->
		</fieldset>
	</body>
</html>