<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test Connexion</title>
</head>
<body>
	<p>Hello ${sessionScope.pseudoSession}</p>
	<p>Tu as ${sessionScope.credit} points</p>
	<a href="/ProjetENI_1_Encheres/ServletDeconnexion">deconnexion</a>
</body>
</html>