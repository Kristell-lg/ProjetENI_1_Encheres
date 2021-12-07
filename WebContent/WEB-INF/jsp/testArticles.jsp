<%@page import="fr.eni.projetEncheres.bo.Articles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test Article</title>
</head>
<body>
	<h1>Gestion Article</h1>
	<h2>Ajout Article</h2>

	<%
	if (request.getAttribute("retour") != null) { // conditon pour ne pas passser par la au premier envoi
	%>
	<p><%=request.getAttribute("retour")%></p>

	<%
	if (request.getAttribute("article") != null) {
		Articles s = (Articles) request.getAttribute("article");
	%>
	<p>
	<%=s.getNom_article()%> <%=s.getDescription()%><br> 
		Date de début d'enchères :<%=s.getDate_debut_encheres()%>
		Date de fin d'enchères <%=s.getDate_fin_encheres()%>
		prix initial : <%=s.getPrix_initial()%><br>
		
	</p>


	<form method="post" action="AjoutArticle">

		<label for="nom_article"> Nom :</label> <input type="text"
			id="nom_article" name="nom_article" placeholder="Article"> <label
			for="description"> description :</label> <input type="text"
			id="description" name="description" placeholder="description">
		<label for="date_debut_encheres"> Date début encheres :</label> <input
			type="date" id="date_debut_encheres" name="date_debut_encheres">
		<label for="date_fin_encheres"> mdp :</label> <input type="date"
			id="date_fin_encheres" name="date_fin_encheres"> 	
		<label
			for="prix_initial"> prix_initial :</label> 
			<input type="number"
			id="prix_initial" name="prix_initial"> 
		<label
			for="prix_vente"> prix_vente :</label> 
			<input type="number"
			id="prix_vente" name="prix_vente"> 
		<label
			for="no_utilisateur"> no_utilisateur :</label> 
			<input type="number"
			id="no_utilisateur" name="no_utilisateur"> 
			
			<input
			type="submit"> 
			
	</form>

</body>
</html>