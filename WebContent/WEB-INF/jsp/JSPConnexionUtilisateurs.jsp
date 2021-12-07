<!-- @author: Kristell -->	 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Connexion</title>
</head>
<body>
	<h1>Connexion</h1>
	<form action="/ProjetENI_1_Encheres/ServletConnexionUtilisateurs" method="post">
		<label for="pseudo">Pseudo : </label>
		<input type=text name="pseudo">
		<label for="mot_de_passe">Mot de passe : </label>
		<input type=text name="mot_de_passe">
		<input type="submit" value="Se Connecter">
	</form>
</body>
</html>