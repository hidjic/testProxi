package fr.gtm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.gtm.domaine.CompteCourant;
import fr.gtm.domaine.CompteEpargne;

public class CompteEpargneDao {
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
			System.out.println("Problème de connexion à la base de donnees !");
			e.printStackTrace();
			Statement stmt = null;
			return stmt;
		}
	}
	
	public boolean createCompteEpargne(CompteEpargne leCompteEpargne) {
		boolean reponse = false; // Creation de la variable de sortie
		try {
			Statement stmt = this.connect(); // Connexion et preparation de la requete
			String sql = "INSERT INTO `compte`(`numCompte`,`dateCreation`, `solde`,`idTypeCompte`,`idClient`,`taux`) VALUES ('"
					+ leCompteEpargne.getNumCompte()+ "', '" + leCompteEpargne.getDateCreation() + "', '" + leCompteEpargne.getSolde()+ "', '"
					+ leCompteEpargne.getIdTypeCompte() + "', '" + leCompteEpargne.getIdClient()+ "', '" + leCompteEpargne.getTauxRemuneration() + ");";
			int result = stmt.executeUpdate(sql); // Exécution de la requête
			if (result > 0) { // Lecture des resultats
				reponse = true;
			} else {
				reponse = false;
			}
			return reponse; // retour de la réponse
		} catch (SQLException e) {
			System.out.println("Problème lors de la création de Compte Epargne !");
			e.printStackTrace();
			return reponse;
		}
	}

	/**
	 * @param leClient
	 * @return
	 */
	public CompteEpargne getCompteEpargne(CompteEpargne leCompteEpargne) {
		try {
			Statement stmt = this.connect(); // Connexion et preparation de la requete
			String sql = "SELECT  `numCompte`, `dateCreation`, `solde`, `idTypeCompte`, `idClient`, `decouvert` FROM `compte` WHERE idClient = "
					+ leCompteEpargne.getIdClient();
			ResultSet result = stmt.executeQuery(sql); // Exécution de la requete
			result.next();

			leCompteEpargne.setNumCompte(result.getString("numCompte"));// Recuperation des donnees
			leCompteEpargne.setDateCreation(result.getString("dateCreation"));
			leCompteEpargne.setSolde(result.getFloat("solde"));
			leCompteEpargne.setIdTypeCompte(result.getInt("idTypeCompte"));
			leCompteEpargne.setIdClient(result.getInt("idClient"));
			leCompteEpargne.setTauxRemuneration(result.getInt("taux"));
			return leCompteEpargne; // retour de la reponse
		} catch (SQLException e) {
			System.out.println("Problème lors de l'affichage du compte Epargne !");
			e.printStackTrace();
			return leCompteEpargne;
		}
	}

	/**
	 * @param leClient
	 * @return
	 */
	public CompteEpargne updateCompteEpargne(CompteEpargne leCompteEpargne) {
		try {
			Statement stmt = this.connect(); // Connexion et preparation de la requete
			String sql = "UPDATE `compte` SET `numCompte` = '" + leCompteEpargne.getNumCompte() + "', `dateCreation` = '" + leCompteEpargne.getDateCreation()
					+ "', `solde` = " + leCompteEpargne.getSolde() + "', `idTypeCompte` = " + leCompteEpargne.getIdTypeCompte()
					+ "', `idClient` = " + leCompteEpargne.getIdClient() + "', `decouvert` = " + leCompteEpargne.getTauxRemuneration()
					 + " WHERE `idClient` = "
					+ leCompteEpargne.getIdClient();
			int result = stmt.executeUpdate(sql); // Execution de la requete
			if (result > 0) {
				return leCompteEpargne; // retour de la reponse
			} else {
				System.out.println("Un problème est survenu lors de la modification du Compte Epargne.");
				return leCompteEpargne;// retour de la reponse
			}
		} catch (SQLException e) {
			System.out.println("Problème lors de la modification du Compte Epargne !");
			e.printStackTrace();
			return leCompteEpargne;// retour de la reponse
		}
	}

	public boolean deleteCompteEpargne(CompteEpargne leCompteEpargne) {
		boolean reponse = false; // Création variable de retour
		try {
			Statement stmt = this.connect(); // Connexion et preparation de la requete
			String sql = "DELETE FROM compte WHERE `idClient` = " + leCompteEpargne.getIdClient();

			int result = stmt.executeUpdate(sql); // Execution de la requete
			if (result > 0) { // Lecture des resultats
				reponse = true;
			} else {
				reponse = false;
			}
			return reponse; // retour de la reponse
		} catch (SQLException e) {
			System.out.println("Problème lors de la suppression du Compte Epargne !");
			e.printStackTrace();
			return reponse;
		}
	}

}
