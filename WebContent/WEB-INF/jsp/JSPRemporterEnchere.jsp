<!-- @Author Maxence -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Enchère terminée</title>
</head>
  <body>
  <%@ include file="/WEB-INF/jsp/pageAccueil/header.html" %>
        <!--Cette JSP est une notification a déstination du vendeur pour avoir les informations concernant le détail de la vente réalisée-->

<!--USER a remporter la vente (TITRE)-->
<!-- <p class="affichageArticle">${article.getUtilisateur().getPseudo()}</p>-->
<!--Nom du produit (TEXTE) -->
<h3> ${requestScope.article.getNom_article()} </h3>
<!--DESCRIPTION DU PRODUIT -->
<p class="affichageArticle">Description : ${requestScope.article.getDescription()}</p>
<!--MEILLEUR OFFRE-->
<p class="affichageArticle">Meilleure offre :${article.getPrix_vente()}</p>
<!--MISE A PRIX INITIAL-->
<p class="affichageArticle">Prix de vente :${article.getPrix_initial()}</p>
<!--DATE FIN DE L'ENCHERE-->
<p class="affichageArticle">Fin des enchères :${article.getDate_fin_encheres()}</p>
<!--RETRAIT (ADRESSE)-->
<p class="affichageArticle">Retrait
<a>${utilisateur.getRue()}</a><br>
<a>${utilisateur.getCode_postal()}</a> <a>${utilisateur.getVille()}</a>
</p>
<!-- VENDEUR (NOM DU VENDEUR)-->
<p class="affichageArticle">Vendeur :</p><a href="/ProjetENI_1_Encheres/ServletConnexionUtilisateurs">${article.getUtilisateur().getPseudo()}</a>
<!--BONTON RETRAIT EFFECTUE-->
<button><a href="#">Retrait effectué</a></button>
<!--IMAGE DU PRODUIT -->
<img src="" alt="Image de l'enchere remportée">
<%@ include file="/WEB-INF/jsp/pageAccueil/footer.html" %>
</body>
</html>