package fr.eni.projetEncheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projetEncheres.bo.Encheres;

/**
*@authorLukaCHOUVILLE
*EncheresDAOJDBCImpl
*/

public class EncheresDAOJdbcImpl implements EncheresDAO{

private static final String SELECT_TOUT="SELECT*FROMENCHERES";
private static final String INSERTENCHERE="INSERTINTOENCHERES(no_utilisateur,no_article,date_enchere,montant_enchere)VALUES(?,?,?,?)";
private static final String SELECT_ENCHERES_id="SELECT*FROMENCHERESwhereno_utilisateur=?";

//Selectionnerl'ensembledesencheres
public List<Encheres>selectionner()throws DALException{

List<Encheres>EncheresListe=new ArrayList<Encheres>();
Statement statementEncheres=null;
ResultSet resultEncheres=null;

try(Connection cnx=ConnectionProvider.getConnection()){
statementEncheres=cnx.createStatement();
resultEncheres=statementEncheres.executeQuery(SELECT_TOUT);

while(resultEncheres.next()){
Encheres enchere=new Encheres(resultEncheres.getInt("no_utilisateur"),resultEncheres.getInt("no_article"),
LocalDate.parse(resultEncheres.getString("date_enchere")),resultEncheres.getInt("montant_enchere"));
EncheresListe.add(enchere);
}
}catch(SQLException e){
throw new DALException("Echec Connection/Requete:",e);
}
finally{

try{
statementEncheres.close();
resultEncheres.close();
}catch(SQLException e){
throw new DALException("Echec Fermeture Connection:",e);
}
}

return EncheresListe;
}


public void ajoutEnchere(Encheres enchere)throws DALException{
	System.out.println("4");
	
	try(Connection c=ConnectionProvider.getConnection();
				PreparedStatement stmt=c.prepareStatement(INSERTENCHERE)){
		
		
			stmt.setInt(1,enchere.getNo_utilisateur());
			stmt.setInt(2,enchere.getNo_article());
		stmt.setDate(3,java.sql.Date.valueOf(enchere.getDate_enchere()));
			stmt.setInt(4,enchere.getMontant_enchere());
			
			stmt.executeUpdate();
	
}catch(SQLException e){
			//TODOAuto-generatedcatchblock
			e.printStackTrace();
		}
	
	
	
}

public List<Encheres>selectionner_id(int no_utilisateur)throws DALException{

List<Encheres>EncheresListe=new ArrayList<Encheres>();
Statement statementEncheres=null;
ResultSet resultEncheres=null;

try(Connection cnx=ConnectionProvider.getConnection()){
statementEncheres=cnx.createStatement();
resultEncheres=statementEncheres.executeQuery(SELECT_ENCHERES_id);

while(resultEncheres.next()){
Encheres enchere=new Encheres(resultEncheres.getInt("no_utilisateur"),resultEncheres.getInt("no_article"),
LocalDate.parse(resultEncheres.getString("date_enchere")),resultEncheres.getInt("montant_enchere"));
EncheresListe.add(enchere);
}
}catch(SQLException e){
throw new DALException("EchecConnection/Requete:",e);
}
finally{

try{
statementEncheres.close();
resultEncheres.close();
}catch(SQLException e){
throw new DALException("EchecFermetureConnection:",e);
}
}

return EncheresListe;
}
}