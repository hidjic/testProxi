package fr.gtm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import fr.gtm.domaine.*;

/**
 * Classe ClientDao
 * 
 * @author Stagiaire
 *
 */
public class ClientDao {

	private Statement connect() {
		try {
			// Chargement du driver (dans le pilote)
			Class.forName("com.mysql.jdbc.Driver");

			// Connexion � la base de donnee
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
			System.out.println("Probl�me de connexion � la base de donn�e !");
			e.printStackTrace();
			Statement stmt = null;
			return stmt;
		}
	}

	/**
	 * @param leClient
	 * @return
	 */
	public boolean createClient(Client leClient) {
		boolean reponse = false; // Creation de la variable de sortie
		try {
			Statement stmt = this.connect(); // Connexion et preparation de la requete
			String sql = "INSERT INTO `client`(`nom`, `prenom`, `email`, `adresse`,`codePostal`,`ville`) VALUES ('"
					+ leClient.getNom() + "', '" + leClient.getPrenom() + "', '" + leClient.getEmail() + "', '"
					+ leClient.getAdresse() + "', '" + leClient.getCodePostal() + "', '" + leClient.getVille() + ");";
			int result = stmt.executeUpdate(sql); // Ex�cution de la requ�te
			if (result > 0) { // Lecture des r�sultats
				reponse = true;
			} else {
				reponse = false;
			}
			return reponse; // retour de la r�ponse
		} catch (SQLException e) {
			System.out.println("Probl�me lors de la cr�ation du client !");
			e.printStackTrace();
			return reponse;
		}
	}

	/**
	 * @param leClient
	 * @return
	 */
	public Client getClient(Client leClient) {
		try {
			Statement stmt = this.connect(); // Connexion et preparation de la requete
			String sql = "SELECT  `email`, `adresse`, `codePostal`, `ville`,`idConseiller` FROM `client` WHERE idClient = "
					+ leClient;
			ResultSet result = stmt.executeQuery(sql); // Ex�cution de la requete
			result.next();

			leClient.setEmail(result.getString("email"));// Recuperation des donnees
			leClient.setAdresse(result.getString("adresse"));
			leClient.setCodePostal(result.getString("codePostal"));
			leClient.setVille(result.getString("ville"));
			leClient.setIdConseiller(result.getInt("idConseiller"));
			return leClient; // retour de la reponse
		} catch (SQLException e) {
			System.out.println("Probl�me lors de la r�cup�ration du client !");
			e.printStackTrace();
			return leClient;
		}
	}

	/**
	 * @param leClient
	 * @return
	 */
	public Client updateClient(Client leClient) {
		try {
			Statement stmt = this.connect(); // Connexion et preparation de la requete
			String sql = "UPDATE `client` SET `nom` = '" + leClient.getNom() + "', `prenom` = '" + leClient.getPrenom()
					+ "', `email` = " + leClient.getEmail() + "', `adresse` = " + leClient.getAdresse()
					+ "', `codePostal` = " + leClient.getCodePostal() + "', `ville` = " + leClient.getVille()
					+ ", `idConseiller` = " + leClient.getIdConseiller() + " WHERE `idClient` = "
					+ leClient.getIdClient();
			int result = stmt.executeUpdate(sql); // Execution de la requete
			if (result > 0) {
				return leClient; // retour de la reponse
			} else {
				System.out.println("Un probl�me est survenu lors de la modification du client.");
				return leClient;// retour de la reponse
			}
		} catch (SQLException e) {
			System.out.println("Probl�me lors de la modification du client !");
			e.printStackTrace();
			return leClient;// retour de la r�ponse
		}
	}

	public boolean deleteClient(Client monClient) {
		boolean reponse = false; // Cr�ation variable de retour
		try {
			Statement stmt = this.connect(); // Connexion et preparation de la requete
			String sql = "DELETE FROM client WHERE `idClient` = " + monClient.getIdClient();

			int result = stmt.executeUpdate(sql); // Ex�cution de la requ�te
			if (result > 0) { // Lecture des r�sultats
				// reponse = true;
			} else {
				// reponse = false;
			}
			return reponse; // retour de la reponse
		} catch (SQLException e) {
			System.out.println("Probl�me lors de la suppression du client !");
			e.printStackTrace();
			return reponse;
		}
	}

	public ArrayList<Client> getAllClient() {
		ArrayList<Client> listClients = new ArrayList<Client>();
		try {
			Statement stmt = this.connect(); // Connexion et preparation de la requete
			String sql = "SELECT * FROM `client`;";
			ResultSet result = stmt.executeQuery(sql); // Execution de la requete
			while (result.next()) {
				Client leClient = new Client(); // Creation de la variable de sortie
				leClient.setIdClient(result.getInt("idClient")); // Recuperation des donnees
				leClient.setNom(result.getString("nom"));
				leClient.setPrenom(result.getString("prenom"));
				leClient.setEmail(result.getString("email"));
				leClient.setAdresse(result.getString("adresse"));
				leClient.setCodePostal(result.getString("codePostal"));
				leClient.setVille(result.getString("ville"));
				leClient.setIdConseiller(result.getInt("idConseiller"));
				listClients.add(leClient);
			}
			return listClients;// retour de la reponse
		} catch (SQLException e) {
			System.out.println("Probl�me lors de la r�cup�ration des client !");
			e.printStackTrace();
			return listClients;// retour de la reponse
		}
	}
}
