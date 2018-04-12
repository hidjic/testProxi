package fr.gtm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.gtm.domaine.Client;
import fr.gtm.domaine.CompteCourant;

public class CompteCourantDao {

	private Statement connect() {
		try {
			// Chargement du driver (dans le pilote)
			Class.forName("com.mysql.jdbc.Driver");

			// Connexion a la base de donnee
			String url = "jdbc:mysql://localhost:3306/proxibanquebdd";
			String login = "root";
			String mdp = "";
			Connection connection = DriverManager.getConnection(url, login, mdp);

			// Pr�paration de la requete
			Statement stmt = connection.createStatement();
			return stmt;
		} catch (ClassNotFoundException e) {
			System.out.println("Probl�me chargement du driver !");
			e.printStackTrace();
			Statement stmt = null;
			return stmt;
		} catch (SQLException e) {
			System.out.println("Probl�me de connexion � la base de donnees !");
			e.printStackTrace();
			Statement stmt = null;
			return stmt;
		}
	}
	
	public boolean createCompteCourant(CompteCourant leCompteCourant) {
		boolean reponse = false; // Creation de la variable de sortie
		try {
			Statement stmt = this.connect(); // Connexion et preparation de la requete
			String sql = "INSERT INTO `compte`(`numCompte`,`dateCreation`, `solde`,`idTypeCompte`,`idClient`,`decouvert`) VALUES ('"
					+ leCompteCourant.getNumCompte()+ "', '" + leCompteCourant.getDateCreation() + "', '" + leCompteCourant.getSolde()+ "', '"
					+ leCompteCourant.getIdTypeCompte() + "', '" + leCompteCourant.getIdClient()+ "', '" + leCompteCourant.getDecouvert() + ");";
			int result = stmt.executeUpdate(sql); // Execution de la requete
			if (result > 0) { // Lecture des resultats
				reponse = true;
			} else {
				reponse = false;
			}
			return reponse; // retour de la r�ponse
		} catch (SQLException e) {
			System.out.println("Probl�me lors de la cr�ation de Compte Courant !");
			e.printStackTrace();
			return reponse;
		}
	}

	/**
	 * @param leClient
	 * @return
	 */
	public CompteCourant getCompteCourant(Client c) {
		CompteCourant leCompteCourant = new CompteCourant();
		try {
			Statement stmt = this.connect(); // Connexion et preparation de la requete
			String sql = "SELECT  `numCompte`, `dateCreation`, `solde`, `idTypeCompte`, `idClient`, `decouvert` FROM `compte` WHERE idClient = "
					+ c.getIdClient();
			ResultSet result = stmt.executeQuery(sql); // Execution de la requete
			if(result.first()) {
				leCompteCourant.setNumCompte(result.getString("numCompte"));// Recuperation des donnees
				leCompteCourant.setDateCreation(result.getString("dateCreation"));
				leCompteCourant.setSolde(result.getFloat("solde"));
				leCompteCourant.setIdTypeCompte(result.getInt("idTypeCompte"));
				leCompteCourant.setIdClient(result.getInt("idClient"));
				leCompteCourant.setDecouvert(result.getInt("decouvert"));
			}
			return leCompteCourant; // retour de la reponse
		} catch (SQLException e) {
			System.out.println("Probl�me lors de l'affichage du compte courant !");
			e.printStackTrace();
			return leCompteCourant;
		}
	}

	/**
	 * @param leClient
	 * @return
	 */
	public CompteCourant updateCompteCourant(CompteCourant leCompteCourant) {
		try {
			Statement stmt = this.connect(); // Connexion et preparation de la requete
			String sql = "UPDATE `compte` SET `numCompte` = '" + leCompteCourant.getNumCompte() + "', `dateCreation` = '" + leCompteCourant.getDateCreation()
					+ "', `solde` = " + leCompteCourant.getSolde() + "', `idTypeCompte` = " + leCompteCourant.getIdTypeCompte()
					+ "', `idClient` = " + leCompteCourant.getIdClient() + "', `decouvert` = " + leCompteCourant.getDecouvert()
					 + " WHERE `idClient` = "
					+ leCompteCourant.getIdClient();
			int result = stmt.executeUpdate(sql); // Execution de la requete
			if (result > 0) {
				return leCompteCourant; // retour de la reponse
			} else {
				System.out.println("Un probl�me est survenu lors de la modification du Compte Courant.");
				return leCompteCourant;// retour de la reponse
			}
		} catch (SQLException e) {
			System.out.println("Probl�me lors de la modification du Compte Courant !");
			e.printStackTrace();
			return leCompteCourant;// retour de la reponse
		}
	}

	public boolean deleteCompteCourant(CompteCourant leCompteCourant) {
		boolean reponse = false; // Creation variable de retour
		try {
			Statement stmt = this.connect(); // Connexion et preparation de la requete
			String sql = "DELETE FROM compte WHERE `idClient` = " + leCompteCourant.getIdClient();

			int result = stmt.executeUpdate(sql); // Execution de la requete
			if (result > 0) { // Lecture des resultats
				reponse = true;
			} else {
				reponse = false;
			}
			return reponse; // retour de la reponse
		} catch (SQLException e) {
			System.out.println("Probl�me lors de la suppression du Compte Courant !");
			e.printStackTrace();
			return reponse;
		}
	}

}
