package proxybanque.service;

//import java.awt.desktop.SystemEventListener;
import java.util.ArrayList;
import java.util.Scanner;

import proxybanque.domaineentity.Agence;
import proxybanque.domaineentity.Client;
import proxybanque.domaineentity.Conseiller;

public class ServiceLanceur {

	// Création agence Lyon

	Agence agenceLyon = new Agence("00001", "19/05/2005");
	// Connexion conseiller
	Conseiller conseiller = new Conseiller("POGNON", "Gille", 4, agenceLyon);

	// Methode du menu principal
	/**
	 * @param listClient
	 * 
	 */
	public void menuPrincipal(ArrayList<Client> listClient, Scanner sc) {
		ServiceGerant serviceGerant = new ServiceGerant();
		ServiceConseiller service = new ServiceConseiller();
		int selection;
		Client client;
		// Scanner aa = new Scanner(System.in);
		System.out.println("Quelle action désirez vous effectuer ?");
		System.out.println("1 - Créer nouveau client");
		System.out.println("2 - Afficher liste clients");
		System.out.println("3 - Audit");
		System.out.println("4 - Quitter");
		// TODO Virement ?
		// selection = aa.nextInt();

		do {
			// Scanner aa = new Scanner(System.in);
			selection = sc.nextInt();

			switch (selection) {
			case (1):
				client = service.creerClient(conseiller, listClient, sc);
				if (client != null)
					listClient.add(client);
				break;
			case (2):
				this.afficherClients(listClient, sc);
				break;
			case (3):
				serviceGerant.audit(listClient);
				break;
			case (4):
				System.out.println("Merci d'avoir utiliser ProxyBanque, au-revoir !");
				break;
			default:
				System.out.println("Choix non reconnu");
			}
			// aa.close();
		} while (selection != 1 && selection != 2 && selection != 3 && selection != 4);
		// aa.close();
		this.menuPrincipal(listClient, sc);

	}

	/**
	 * @param listClient2
	 * 
	 */
	public void afficherClients(ArrayList<Client> listClient, Scanner sc) {
		Client client;
		int selection;
		int i;
		// ServiceConseiller service = new ServiceConseiller();
		System.out.println("Veuillez selectionner un client :");
		for (i = 0; i < listClient.size(); i++) {
			System.out.println(i + " - " + listClient.get(i));
		}
		Scanner ab = new Scanner(System.in);
		do {
			selection = ab.nextInt();

			client = listClient.get(selection);
		} while (selection < 0 && selection >= listClient.size());
		this.choixSurClient(client, listClient, sc);
		// ab.close();
	}

	// Menu secondaire après selection du client
	/**
	 * @param client
	 */
	public void choixSurClient(Client client, ArrayList<Client> listClient, Scanner sc) {
		ServiceClient serviceClient = new ServiceClient();
		ServiceCompte serviceCompte = new ServiceCompte();
		ServiceConseiller service = new ServiceConseiller();

		int selection;
		// Scanner aa = new Scanner(System.in);
		do {
			System.out.println("Quelle action désirez vous effectuer ?");
			System.out.println("0 - Retour");
			System.out.println("1 - Afficher les informations du client");
			System.out.println("2 - Modifier les informations du client");
			System.out.println("3 - Supprimer le client");
			System.out.println("4 - Faire une simulation crédit consommation");
			System.out.println("5 - Faire une simulation crédit immobilier");
			System.out.println("6 - Gestion virement");
		if(client.isRiche()==true)
			System.out.println("7 - Gestion de patrimoine");

	
			selection = sc.nextInt();

			switch (selection) {
			case (0):
				this.menuPrincipal(listClient, sc);
				break;
			case (1):
				serviceClient.afficherClient(client);
				this.choixSurClient(client, listClient, sc);
				break;
			case (2):
				service.modifierClient(serviceCompte, serviceClient, client, listClient, sc);
				break;
			case (3):
				service.supprimerClient(client, listClient, sc);
				break;
			case (4):
				System.out.println(service.simulationCreditConso());
				break;
			case (5):
				System.out.println(service.simulationCreditImmo());
				break;
			case (6):
				service.gestionVirement(client, listClient, sc);
				break;
			case (7):
				System.out.println(service.gestionPatrimoine());
				break;
			default:
				System.out.println("Choix non reconnu");
			}
		} while (selection != 0 && selection != 1 && selection != 2 && selection != 3 && selection != 4 && selection != 5 && selection != 6 && selection != 7);
		// aa.close();
		this.choixSurClient(client, listClient, sc);
	}

}