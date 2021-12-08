<!-- @author: Luka CHOUVILLE -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
				<input type="text" name="Pseudo" id="Pseudo" value="@pseudo" disabled/>	
			</div>
			<div>
				<label for="prenom">Prénom : </label>
				<input type="text" name="prenom" id="prenom" value="@prenom" disabled/>
			</div>
			<div>			
				<label for="nom">Nom : </label>
				<input type="text" name="nom" id="nom" value="@nom" disabled/>
			</div>
			<div>
				<label for="email">Email : </label>
				<input type="email" name="email" id="email" value="@email" disabled/>
			</div>
			<div>
				<label for="tel">Téléphone : </label>
				<input type="tel" name="tel" id="tel" value="@tel" disabled/>
			</div>
			<div>		
				<label for="rue">Rue : </label>
				<input type="text" name="rue" id="rue" value="@rue" disabled/>
			</div>
			<div>		
				<label for="ville">Ville : </label>
				<input type="text" name="ville" id="ville" value="@ville" disabled/>
			</div>
			<div>			
				<label for="codepostal">Code Postal : </label>
				<input type="text" name="codepostal" id="codepostal" value="@cp" disabled/>
			</div>
		</fieldset>
	</body>
</html>