<!-- @author: Luka CHOUVILLE -->
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
					<input type="text" name="Pseudo" id="Pseudo" maxlength="30"required/>
							
					<label for="prenom">Prénom : </label>
					<input type="text" name="prenom" id="prenom" maxlength="30"/>
							
					<label for="nom">Nom : </label>
					<input type="text" name="nom" id="nom" maxlength="30"/>
						
					<label for="mdp">*Mot de passe : </label>
					<input type="password" name="mdp" id="mdp"maxlength="30"/>
								
					<label for="mdpVerif">*Confirmation Mot de passe: </label>
					<input type="password" name="mdpVerif" id="mdpVerif" maxlength="30" required/>
				</div>
				<div class="inscription-champs">
				
					<label for="email">*Email : </label>
					<input type="email" pattern="+@+." name="email" id="email" maxlength="20" required/>
			
					<label for="tel">Téléphone : </label>
					<input type="tel" name="tel" id="tel" maxlength="15"/>
						
					<label for="rue">Rue : </label>
					<input type="text" name="rue" id="rue"maxlength="30"/>
						
					<label for="ville">Ville : </label>
					<input type="text" name="ville" id="ville"maxlength="30"/>
						
					<label for="codepostal">Code Postale : </label>
					<input type="text" name="codepostal" id="codepostal" maxlength="5" required/>
					
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