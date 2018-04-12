package fr.gtm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import fr.gtm.domaine.*;

public class ConseillerDao {

	private Statement connect() {
		try {
			// Chargement du driver (dans le pilote)
			Class.forName("com.mysql.jdbc.Driver");

			// Connexion à la base de donnee
			String url = "jdbc:mysql://localhost:3306/proxibanquebdd";
			String login = "root";
			String mdp = "";
			Connection connection = DriverManager.getConnection(url, login, mdp);

			// Préparation de la requete
			Statement stmt = connection.createStatement();
			return stmt;
		} catch (ClassNotFoundException e) {
			System.out.println("Problème chargement du driver !");
			e.printStackTrace();
			Statement stmt = null;
			return stmt;
		} catch (SQLException e) {
			System.out.println("Problème de connexion à la base de donnée !");
			e.printStackTrace();
			Statement stmt = null;
			return stmt;
		}
	}




public boolean createConseiller(Conseiller leConseiller) {
	boolean reponse = false; // Creation de la variable de sortie
	try {
		Statement stmt = this.connect(); // Connexion et preparation de la requete
		String sql = "INSERT INTO `conseiller`(`nom`, `prenom`, `login`,`nbClient`) VALUES ('"
				+ leConseiller.getNom() + "', '" + leConseiller.getPrenom() + "', '" + leConseiller.getLogin()+ "', '"
				+ leConseiller.getPassword() + "', '"+ leConseiller.getNbClient() + ");";
		int result = stmt.executeUpdate(sql); // Exécution de la requête
		if (result > 0) { // Lecture des résultats
			reponse = true;
		} else {
			reponse = false;
		}
		return reponse; // retour de la réponse
	} catch (SQLException e) {
		System.out.println("Problème lors de la création du conseiller !");
		e.printStackTrace();
		return reponse;
	}
}

public Conseiller getConseiller(Conseiller leConseiller) {
	try {
		Statement stmt = this.connect(); // Connexion et preparation de la requete
		String sql = "SELECT  `nom`,`prenom`, `login`,`password`, `nbClient` FROM `conseiller` WHERE idConseiller = "
				+ leConseiller.getIdConseiller();
		ResultSet result = stmt.executeQuery(sql); // Exécution de la requete
		result.next();

		leConseiller.setNom(result.getString("nom"));// Recuperation des donnees
		leConseiller.setPrenom(result.getString("prenom"));
		leConseiller.setLogin(result.getString("login"));
		leConseiller.setPassword(result.getString("password"));
		leConseiller.setNbClient(result.getInt("nbClient"));
		return leConseiller; // retour de la reponse
	} catch (SQLException e) {
		System.out.println("Problème lors de la récupération du client !");
		e.printStackTrace();
		return leConseiller;
	}
}

}