package proxybanque.service;

import java.util.ArrayList;
import java.util.Scanner;

import proxybanque.domainecompte.CCourant;
import proxybanque.domainecompte.CEpargne;
import proxybanque.domainecompte.Carte;
import proxybanque.domainecompte.Compte;
import proxybanque.domainecompte.TypeCarte;
//import proxybanque.domaineentity.Agence;
import proxybanque.domaineentity.Client;
import proxybanque.domaineentity.Conseiller;

public class ServiceConseiller implements IGestionClientFortunes {
	private int selection;
	private String nouveau;

	/**
	 * @param agenceLyon
	 * @param conseiller
	 * @return
	 */
	// méthode de création client appelée par le menu principal
	public Client creerClient(Conseiller conseiller, ArrayList<Client> listClient, Scanner sc) {
		int nbClient;
		ServiceLanceur serviceLanceur = new ServiceLanceur();
		if (conseiller.getNombreClient() <= 9) {
			ServiceCompte serviceCompte = new ServiceCompte();
			// Scanner sc = new Scanner(System.in);
			sc.nextLine();
			System.out.println("Veuillez entrer le nom du client");
			String nom = sc.nextLine();
			System.out.println("Veuillez entrer le prénom du client");
			String prenom = sc.nextLine();
			System.out.println("Veuillez entrer l'adresse du client");
			String adresse = sc.nextLine();
			System.out.println("Veuillez entrer le code postal du client");
			String codePostal = sc.nextLine();
			System.out.println("Veuillez entrer la ville du client");
			String ville = sc.nextLine();
			System.out.println("Veuillez entrer le téléphone du client");
			String telephone = sc.nextLine();

			Client client = new Client(nom, prenom, adresse, codePostal, ville, telephone, true, false);

			// incrémentation de l'attribut nbClient du conseillé
			nbClient = conseiller.getNombreClient();
			conseiller.setNombreClient(nbClient++);
			// Affectation du compte créé au client
			serviceCompte.creationCompte(serviceCompte, client, listClient);
			// sc.close();
			return client;

		} else {
			System.out.println(
					"La limite de clients de 10 par conseillé a été atteinte, veuillez supprimer un client pour pouvoir en ajouter un nouveau");
			serviceLanceur.menuPrincipal(listClient, sc);
		}
		return null;
	}

	/**
	 * @param serviceCompte
	 * @param serviceClient
	 * @param client
	 */
	public void modifierClient(ServiceCompte serviceCompte, ServiceClient serviceClient, Client client,
			ArrayList<Client> listClient, Scanner sc) {
		ServiceLanceur serviceLanceur = new ServiceLanceur();
		// Appelle de la méthode afficher
		serviceClient.afficherClient(client);
		// Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Quel paramètre client voulez vous modifier ?");

			selection = sc.nextInt();
			Scanner cs = new Scanner(System.in);

			switch (selection) {
			case (1):
				System.out.println("Veuillez rentrer le nouveau nom");
				nouveau = cs.nextLine();
				client.setNom(nouveau);
				serviceLanceur.choixSurClient(client, listClient, sc);

				break;
			case (2):
				System.out.println("Veuillez rentrer le nouveau prénom");
				nouveau = cs.nextLine();
				client.setPrenom(nouveau);
				serviceLanceur.choixSurClient(client, listClient, sc);

				break;

			case (3):
				System.out.println("Veuillez rentrer la nouvelle adresse");
				nouveau = cs.nextLine();
				client.setAdresse(nouveau);
				serviceLanceur.choixSurClient(client, listClient, sc);

				break;

			case (4):
				System.out.println("Veuillez rentrer le nouveau code postal");
				nouveau = cs.nextLine();
				client.setCodePostal(nouveau);
				serviceLanceur.choixSurClient(client, listClient, sc);

				break;

			case (5):
				System.out.println("Veuillez rentrer la nouvelle ville");
				nouveau = cs.nextLine();
				client.setVille(nouveau);
				serviceLanceur.choixSurClient(client, listClient, sc);

				break;

			case (6):
				System.out.println("Veuillez rentrer le nouveau numéro de téléphone");
				nouveau = cs.nextLine();
				client.setTelephone(nouveau);
				serviceLanceur.choixSurClient(client, listClient, sc);

				break;
			case (7):
				serviceCompte.modifierCompte(serviceCompte, client, listClient, sc);
				serviceLanceur.choixSurClient(client, listClient, sc);
				break;

			default:
				System.out.println("Choix non reconnu");
			}
		} while (selection != 1 && selection != 2 && selection != 3 && selection != 4 && selection != 5
				&& selection != 6 && selection != 7);
		// sc.close();
	}

	/**
	 * @return
	 */
	public ArrayList<Client> createClientList() {
		// Carte carte = null;
		ArrayList<Client> listClient = new ArrayList<Client>();
		// ServiceConseiller servC = new ServiceConseiller();
		Client c1 = new Client("Gaillard", "Pierre", "1 cours Lafayette", "69006", "Lyon", "0123456789", false, false);
		CCourant cc1 = new CCourant("12/12/2012", c1);
		cc1.setCarte(new Carte(TypeCarte.ELECTRON));
		cc1.setSolde(-8000);

		CEpargne ce1 = new CEpargne("21/08/2013", c1);
		ce1.setSolde(1000);
		c1.setCompteCourant(cc1);
		c1.setCompteEpargne(ce1);

		Client c2 = new Client("Barbier", "Paul", "2 cours Lafayette", "69006", "Lyon", "0134567892", false, false);
		CEpargne ce2 = new CEpargne("21/08/2013", c1);
		ce2.setSolde(100000);
		c2.setCompteEpargne(ce2);

		Client c3 = new Client("Agostini", "Jean", "20 cours Lafayette", "69006", "Lyon", "0134567892", true, false);
		CCourant cc3 = new CCourant("12/12/2012", c1);
		cc3.setCarte(new Carte(TypeCarte.PREMIER));
		cc3.setSolde(100000);
		CEpargne ce3 = new CEpargne("21/08/2013", c1);
		ce3.setSolde(800000);
		c3.setCompteCourant(cc3);
		c3.setCompteEpargne(ce3);

		Client c4 = new Client("Raoult", "Alain", "18 cours Lafayette", "69006", "Lyon", "0134567892", false, false);
		CCourant cc4 = new CCourant("12/12/2012", c1);
		cc4.setCarte(new Carte(TypeCarte.ELECTRON));
		cc4.setSolde(2500);
		CEpargne ce4 = new CEpargne("21/08/2013", c1);
		ce4.setSolde(8000);
		c4.setCompteCourant(cc4);
		c3.setCompteEpargne(ce4);

		Client c5 = new Client("Fabre", "Valérie", "150 cours Lafayette", "69006", "Lyon", "0134567892", false, true);
		CCourant cc5 = new CCourant("12/12/2012", c1);
		cc5.setCarte(new Carte(TypeCarte.PREMIER));
		cc5.setSolde(100000);
		CEpargne ce5 = new CEpargne("21/08/2013", c1);
		ce5.setSolde(300000);
		c5.setCompteCourant(cc5);
		c5.setCompteEpargne(ce5);

		Client c6 = new Client("Domingues", "Laurence", "87 cours Lafayette", "69006", "Lyon", "0134567892", false,
				false);
		CCourant cc6 = new CCourant("12/12/2012", c1);
		cc6.setCarte(new Carte(TypeCarte.ELECTRON));
		cc6.setSolde(500);
		c6.setCompteCourant(cc6);

		Client c7 = new Client("Bouyer", "Louis", "65 cours Lafayette", "69006", "Lyon", "0134567892", true, false);
		CEpargne ce7 = new CEpargne("21/08/2013", c1);
		ce7.setSolde(700000);
		c7.setCompteEpargne(ce7);

		Client c8 = new Client("Franck", "David", "42 cours Lafayette", "69006", "Lyon", "0134567892", false, true);
		CCourant cc8 = new CCourant("12/12/2012", c1);
		cc8.setCarte(new Carte(TypeCarte.ELECTRON));
		cc8.setSolde(100000);
		c8.setCompteCourant(cc8);

		Client c9 = new Client("Kieffer", "Nolwen", "15 cours Lafayette", "69006", "Lyon", "0134567892", false, true);
		CCourant cc9 = new CCourant("12/12/2012", c1);
		cc9.setCarte(new Carte(TypeCarte.PREMIER));
		cc9.setSolde(-61000);
		c9.setCompteCourant(cc9);

		listClient.add(c1);
		listClient.add(c2);
		listClient.add(c3);
		listClient.add(c4);
		listClient.add(c5);
		listClient.add(c6);
		listClient.add(c7);
		listClient.add(c8);
		listClient.add(c9);

		return listClient;
	}

	/**
	 * @param client
	 * @param listClient
	 * @param sc
	 */
	public void supprimerClient(Client client, ArrayList<Client> listClient, Scanner sc) {
		ServiceLanceur serviceLanceur = new ServiceLanceur();
		listClient.remove(client);
		System.out.println("Client supprimé");
		serviceLanceur.menuPrincipal(listClient, sc);
	}

	// public String virement(double somme, CCourant myCCDebiter, CCourant
	// myCCCrediter) {
	// // virement refusé car solde insuffisant
	// if ((myCCDebiter.getSolde() - somme) < (-myCCDebiter.getDecouvert())) {
	// return "Opération refusé : autorisation découvert insuffisant";
	// } else { // le virement est accepté
	// ServiceCompte servC = new ServiceCompte();
	// myCCDebiter.setSolde(servC.debiter(somme, myCCDebiter.getSolde()));
	// myCCCrediter.setSolde(servC.crediter(somme, myCCCrediter.getSolde()));
	// return "Le virement est accepté";
	// }
	// }
	//
	// public String virement(double somme, CEpargne myCEDebiter, CEpargne
	// myCECrediter) {
	// // virement refusé car solde insuffisant
	// if ((myCEDebiter.getSolde() - somme) < 0) {
	// return "Opération refusé : solde négatif interdit";
	// } else { // le virement est accepté
	// ServiceCompte servC = new ServiceCompte();
	// myCEDebiter.setSolde(servC.debiter(somme, myCEDebiter.getSolde()));
	// myCECrediter.setSolde(servC.crediter(somme, myCECrediter.getSolde()));
	// return "Le virement est accepté";
	// }
	// }

	/**
	 * @param somme
	 * @param myCCDebiter
	 * @param myCECrediter
	 * @return
	 */
	public String virement(double somme, CCourant myCCDebiter, CEpargne myCECrediter) {
		// virement refusé car solde insuffisant
		if ((myCCDebiter.getSolde() - somme) < (-myCCDebiter.getDecouvert())) {
			return "Opération refusé : autorisation découvert insuffisant";
		} else { // le virement est accepté
			ServiceCompte servC = new ServiceCompte();
			myCCDebiter.setSolde(servC.debiter(somme, myCCDebiter.getSolde()));
			myCECrediter.setSolde(servC.crediter(somme, myCECrediter.getSolde()));
			return "Le virement est accepté";
		}
	}

	/**
	 * @param somme
	 * @param myCEDebiter
	 * @param myCCCrediter
	 * @return
	 */
	public String virement(double somme, CEpargne myCEDebiter, CCourant myCCCrediter) {
		// virement refusé car solde insuffisant
		if ((myCEDebiter.getSolde() - somme) < 0) {
			return "Opération refusé : solde négatif interdit";
		} else { // le virement est accepté
			ServiceCompte servC = new ServiceCompte();
			myCEDebiter.setSolde(servC.debiter(somme, myCEDebiter.getSolde()));
			myCCCrediter.setSolde(servC.crediter(somme, myCCCrediter.getSolde()));
			return "Le virement est accepté";
		}
	}

	/**
	 * @param somme
	 * @param myCCDebiter
	 * @param iban
	 * @return
	 */
	public String virement(double somme, CCourant myCCDebiter, String iban) {
		ServiceCompte servC = new ServiceCompte();
		myCCDebiter.setSolde(servC.debiter(somme, myCCDebiter.getSolde()));
		return "Le virement est accepté";
	}

	/**
	 * @param somme
	 * @param myCEDebiter
	 * @param iban
	 * @return
	 */
	public String virement(double somme, CEpargne myCEDebiter, String iban) {
		ServiceCompte servC = new ServiceCompte();
		myCEDebiter.setSolde(servC.debiter(somme, myCEDebiter.getSolde()));
		return "Le virement est accepté";
	}

	/**
	 * @param somme
	 * @param iban
	 * @param myCECrediter
	 * @return
	 */
	public String virement(double somme, String iban, CEpargne myCECrediter) {
		ServiceCompte servC = new ServiceCompte();
		myCECrediter.setSolde(servC.crediter(somme, myCECrediter.getSolde()));
		return "Le virement est accepté";
	}

	/**
	 * @param somme
	 * @param iban
	 * @param myCCCrediter
	 * @return
	 */
	public String virement(double somme, String iban, CCourant myCCCrediter) {
		ServiceCompte servC = new ServiceCompte();
		myCCCrediter.setSolde(servC.crediter(somme, myCCCrediter.getSolde()));
		return "Le virement est accepté";
	}

	public String simulationCreditConso() {
		return "Au vue de votre situation, vous pouvez obtenir un crédit à la consomation de 10 000€ à 10% remboursable sur 48 mois.";
	}

	public String simulationCreditImmo() {
		return "Au vue de votre situation, vous pouvez obtenir un crédit immobilier de 500 000€ à 15%; remboursable 360 mois.";
	}

	@Override
	public String gestionPatrimoine() {
		return "Nous vous proposons des placements non toxique sur les bourses de Paris, New-York et Tokyo.";
	}

	// Méthode permettant le virement compte à compte
	/**
	 * @param client
	 * @param listClient
	 * @param sc
	 */
	public void gestionVirement(Client client, ArrayList<Client> listClient, Scanner sc) {
		ServiceLanceur serviceLanceur = new ServiceLanceur();
		Scanner rr = new Scanner(System.in);
		Scanner rv = new Scanner(System.in);

		ServiceClient serviceClient = new ServiceClient();
		double selection;
		double solde;
		char choix;
		// Rappel des comptes utilisateurs
		System.out.println("Compte(s) :");
		if (client.getCompteCourant() != null)
			System.out.println(client.getCompteCourant());
		if (client.getCompteEpargne() != null)
			System.out.println(client.getCompteEpargne());
		if (client.getCompteCourant() == null && client.getCompteEpargne() == null)
			System.out.println("Aucun compte associé");

		// Si le client possède deux comptes, il lui est possible de faire un virement
		// entre ses deux comptes
		if (client.getCompteCourant() != null && client.getCompteEpargne() != null) {
			System.out.println("Voulez faire un virement entre vos comptes ? O/N");
			choix = rv.nextLine().charAt(0);
			while (choix != 'O' && choix != 'N') {
				selection = rr.nextDouble();
				System.out.println("Choix non reconnu, veuillez recommencer");
			}
			// Le choix du compte à débiter va déterminer la méthode virement à appeler
			if (choix == 'O') {
				System.out.println("selectionner le compte à débiter");
				System.out.println("1 - " + client.getCompteCourant());
				System.out.println("2 - " + client.getCompteEpargne());
				selection = rr.nextInt();
				while (selection != 1 && selection != 2) {
					selection = rr.nextDouble();
					System.out.println("Choix non reconnu, veuillez recommencer");
				}
				System.out.println("Quelle est la somme du virement à effectuer ?");
				solde = rr.nextDouble();
				if (selection == 1)
					System.out.println(this.virement(solde, client.getCompteCourant(), client.getCompteEpargne()));
				else
					System.out.println(this.virement(solde, client.getCompteEpargne(), client.getCompteCourant()));

			} else
				// Si l'utilisateur veut faire un virement vers le compte d'un autre client ou
				// si il veut faire un virement sans posseder deux comptes
				this.gestionVirementExterieur(client);
		} else
			this.gestionVirementExterieur(client);
		serviceClient.gestionBooleanRiche(client);
		serviceLanceur.choixSurClient(client, listClient, sc);
	}

	/**
	 * @param client
	 */
	private void gestionVirementExterieur(Client client) {
		int selection;
		int choix;
		double solde;
		String iban;
		Scanner rr = new Scanner(System.in);
		Scanner rv = new Scanner(System.in);
		Scanner rt = new Scanner(System.in);

		System.out.println("Voulez vous réaliser sur votre solde :");
		System.out.println("1 - Un débit");
		System.out.println("2 - Un crédit");
		choix = rr.nextInt();
		while (choix != 1 && choix != 2) {
			selection = rr.nextInt();
			System.out.println("Choix non reconnu, veuillez recommencer");
		}
		System.out.println("De quel montant ?");
		solde = rv.nextDouble();

		System.out.println("Veuillez rentrer l'iban du compte cible");
		iban = rt.nextLine();
		// Si le client possède deux comptes il doit choisir lequel utiliser, sinon son
		// unique compte est sélectionné d'office
		if (client.getCompteCourant() != null && client.getCompteEpargne() != null) {
			System.out.println("Sur quel compte voulez vous effectuer l'oppération ?");
			System.out.println("1 - Votre compte courant avec un solde de " + client.getCompteCourant().getSolde());
			System.out.println("2 - Votre compte épargne avec un solde de " + client.getCompteEpargne().getSolde());
			selection = rr.nextInt();
			while (selection != 1 && selection != 2) {
				selection = rr.nextInt();
				System.out.println("Choix non reconnu, veuillez recommencer");
			}

			if (selection == 1 && choix == 1)
				System.out.println(this.virement(solde, client.getCompteCourant(), iban));
			if (selection == 1 && choix == 2)
				System.out.println(this.virement(solde, iban, client.getCompteCourant()));
			if (selection == 2 && choix == 1)
				System.out.println(this.virement(solde, client.getCompteEpargne(), iban));
			if (selection == 2 && choix == 2)
				System.out.println(this.virement(solde, iban, client.getCompteEpargne()));
		}else {
			// Selon le compte du client, la méthode virement appelée ne sera pas la même
			if (client.getCompteCourant() != null) {
				if (choix == 1)
					System.out.println(this.virement(solde, client.getCompteCourant(), iban));
				else
					System.out.println(this.virement(solde, iban, client.getCompteCourant()));
			}
			if (client.getCompteEpargne() != null) {
				if (choix == 1)
					System.out.println(this.virement(solde, client.getCompteEpargne(), iban));
				else
					System.out.println(this.virement(solde, iban, client.getCompteEpargne()));
			}
		}
	}
}
