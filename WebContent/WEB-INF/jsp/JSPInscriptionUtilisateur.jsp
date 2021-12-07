<%@ page language="java" 
			contentType="text/html; charset=UTF-8"
    		pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="css/reset.css"> <!-- Reset le design css -->
        <link rel="stylesheet" href="css/inscription.css"> <!-- Applique le nouveau design -->
    
	</head>
	<body>
		<form method="post" action="/TPRechercherNombre/ServletRechercherNombre">
			<div class="inscription">
				<div class="inscription-champs">
					<label for="Pseudo">*Pseudo : </label>
					<input type="text" name="Pseudo" id="Pseudo" required/>
							
					<label for="prenom">Prénom : </label>
					<input type="text" name="prenom" id="prenom"/>
							
					<label for="nom">Nom : </label>
					<input type="text" name="nom" id="nom"/>
						
					<label for="email">*Email : </label>
					<input type="email" name="email" id="email" required/>
			
					<label for="mdp">*Mot de passe : </label>
					<input type="password" name="mdp" id="mdp"/>
				</div>
				<div class="inscription-champs">
					<label for="tel">Téléphone : </label>
					<input type="tel" name="tel" id="tel"/>
						
					<label for="rue">Rue : </label>
					<input type="text" name="rue" id="rue"/>
						
					<label for="ville">Ville : </label>
					<input type="text" name="ville" id="ville"/>
						
					<label for="codepostal">Code Postale : </label>
					<input type="text" name="codepostal" id="codepostal" required/>
								
					<label for="mdpVerif">*Confirmation Mot de passe: </label>
					<input type="password" name="mdpVerif" id="mdpVerif" required/>
				</div>
			</div>
			<!-- Bouton -->
			<div class="inscription-Bouton">
				<input type="submit" value="Créer"/>
				<input type="reset" value="Annuler"/>
			</div>
		</form>
	</body>
</html>

<!-- @Author Luka CHOUVILLE -->