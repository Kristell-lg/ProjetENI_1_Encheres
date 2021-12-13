<!-- @author: Luka CHOUVILLE -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Profil</title>
		<link rel="stylesheet" href="css/reset.css"> <!-- Reset le design css -->
        <link rel="stylesheet" href="css/profil.css"> <!-- Applique le nouveau design -->
	</head>
	<body>
	<%@ include file="/WEB-INF/jsp/pageAccueil/header.html" %>
	<c:choose>
	
		<c:when test="${!empty sessionScope.utilisateur}">
			<h2>Mon profil</h2>
				<fieldset>
					<div>
						<label for="Pseudo">Pseudo : </label>
						<input type="text" name="Pseudo" id="Pseudo" value="${sessionScope.utilisateur.getPseudo()}" disabled/>	
					</div>
					<div>
						<label for="prenom">Prénom : </label>
						<input type="text" name="prenom" id="prenom" value="${sessionScope.utilisateur.getPrenom()}" disabled/>
					</div>
					<div>			
						<label for="nom">Nom : </label>
						<input type="text" name="nom" id="nom" value="${sessionScope.utilisateur.getNom()}" disabled/>
					</div>
					<div>
						<label for="email">Email : </label>
						<input type="email" name="email" id="email" value="${sessionScope.utilisateur.getEmail()}" disabled/>
					</div>
					<div>
						<label for="tel">Téléphone : </label>
						<input type="tel" name="tel" id="tel" value="${sessionScope.utilisateur.getTelephone()}" disabled/>
					</div>
					<div>		
						<label for="rue">Rue : </label>
						<input type="text" name="rue" id="rue" value="${sessionScope.utilisateur.getRue()}" disabled/>
					</div>
					<div>		
						<label for="ville">Ville : </label>
						<input type="text" name="ville" id="ville" value="${sessionScope.utilisateur.getVille()}" disabled/>
					</div>
					<div>			
						<label for="codepostal">Code Postal : </label>
						<input type="text" name="codepostal" id="codepostal" value="${sessionScope.utilisateur.getCode_postal()}" disabled/>
					</div>
					<div>			
						<label for="credit">Crédit : </label>
						<input type="text" name="cerdit" id="credit" value="${sessionScope.utilisateur.getCredit()}" disabled/>
					</div>
					
			<form action="${pageContext.request.contextPath}/ModifierProfil" method="get">
					<input type="submit" value="Modifier" />
			</form>
				</fieldset>
		</c:when>
		
		<c:otherwise>
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
			</fieldset>
		</c:otherwise>
	</c:choose>
		<%@ include file="/WEB-INF/jsp/pageAccueil/footer.html" %>
	</body>
</html>