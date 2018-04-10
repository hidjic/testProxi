package proxybanque.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import proxybanque.domainecompte.CCourant;
import proxybanque.domainecompte.CEpargne;
import proxybanque.domainecompte.Carte;
import proxybanque.domainecompte.TypeCarte;
import proxybanque.domaineentity.Client;

public class ServiceCompte {
//	private int selection;
//	private int solde;
//	private char choix;
//	private Carte carte;

	/**
	 * @param serviceCompte
	 * @param client
	 */
	// Création du compte appelée par la création client
	public void creationCompte(ServiceCompte serviceCompte, Client client, ArrayList<Client> listClient) {
		int selection;
//		ServiceLanceur serviceLanceur = new ServiceLanceur();
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Quel type de compte voulez vous assigner ?");
			System.out.println("1 - Compte courant");
			System.out.println("2 - Compte épargne");
			System.out.println("3 - Compte courant et compte épargne");
			
			selection = sc.nextInt();

			switch (selection) {
			case (1):
				serviceCompte.creationCompteCourant(client);
				break;
			case (2):
				serviceCompte.creationCompteEpargne(client);
				break;
			case (3):
				serviceCompte.creationCompteCourant(client);
				serviceCompte.creationCompteEpargne(client);
				break;
			default:
				System.out.println("Choix non reconnu");
			}
		} while (selection != 1 && selection != 2 && selection != 3);
//		serviceLanceur.menuPrincipal(listClient);
//		sc.close();
	}

	/**
	 * @param client
	 */
	private void creationCompteCourant(Client client) {
		int selection;
		Scanner tv = new Scanner(System.in);
//		Carte carte = null;
		// Formatage de la date de création du compte
		SimpleDateFormat formater = null;
		Date today = new Date();
		formater = new SimpleDateFormat("dd/MM/yy");
		CCourant compteCourant = new CCourant(formater.format(today), client);
		System.out.println("Compte courant créé");
		System.out.println("Quel type de carte voulez vous assigner à ce compte ?");
		System.out.println("1 - " + TypeCarte.ELECTRON);
		System.out.println("2 - " + TypeCarte.PREMIER);
		do {
			selection = tv.nextInt();
			if (selection == 1)
				compteCourant.setCarte(new Carte(TypeCarte.ELECTRON));
			else if (selection == 2)
				compteCourant.setCarte(new Carte(TypeCarte.PREMIER));
			else
				System.out.println("Choix non reconnu, veuillez recommencer");
		} while (selection != 1 && selection != 2);
		client.setCompteCourant(compteCourant);
//		tv.close();
	}

	/**
	 * @param client
	 */
	private void creationCompteEpargne(Client client) {
		SimpleDateFormat formater = null;
		Date today = new Date();
		formater = new SimpleDateFormat("dd/MM/yy");
		CEpargne compteEpargne = new CEpargne(formater.format(today), client);
		System.out.println("Compte épargne créé");
		client.setCompteEpargne(compteEpargne);

	}

	/**
	 * @param serviceCompte
	 * @param client
	 */
	public void modifierCompte(ServiceCompte serviceCompte, Client client, ArrayList<Client> listClient,Scanner sc) {
		int selection;
//		Scanner cs = new Scanner(System.in);
		ServiceLanceur serviceLanceur = new ServiceLanceur();
		// Déclaration d'un boolean permettant de modifier la bouble do while sous
		// condition
		boolean securite;
		do {
			securite = true;
			System.out.println("Quel modification voulez vous effectuer ?");
			System.out.println("1 - Retour menu");

			System.out.println("2 - Supprimer compte");
			System.out.println("3 - ajout compte");
			// Selon les comptes du client le choix proposé change
			if (client.getCompteCourant() != null && client.getCompteEpargne() == null)
				System.out.println("4 - modifier le découvert autorisé");
			else if (client.getCompteCourant() == null && client.getCompteEpargne() != null)
				System.out.println("4 - modifier le taux d'intéret");
			else {
				// Changement d'affectation du boolean
				securite = false;
				System.out.println("4 - modifier le découvert autorisé");
				System.out.println("5 - modifier le taux d'intéret");
			}

//			Scanner sc = new Scanner(System.in);
//			selection = sc.nextInt();
			selection = sc.nextInt();

			switch (selection) {
			case (1):
				serviceLanceur.choixSurClient(client, listClient,sc);
				break;
			case (2):
				serviceCompte.supprimerCompte(serviceCompte, client);
				break;
			case (3):
				serviceCompte.ajoutCompte(serviceCompte, client, listClient,sc);
				break;
			case (4):
				// Selon les comptes du client le choix proposé change

				if (client.getCompteCourant() != null && client.getCompteEpargne() == null) {
					System.out.println("Veuillez entrer un nouveau découvert autorisé");
					int nouveau = sc.nextInt();
					client.getCompteCourant().setDecouvert(nouveau);
				} else if (client.getCompteCourant() == null && client.getCompteEpargne() != null) {
					System.out.println("Veuillez entrer un nouveau taux d'intéret");
					int nouveau = sc.nextInt();
					client.getCompteEpargne().setTaux(nouveau);
				} else {
					System.out.println("Veuillez entrer un nouveau découvert autorisé");
					int nouveau = sc.nextInt();
					client.getCompteCourant().setDecouvert(nouveau);
				}
				break;
			case (5):
				if (client.getCompteCourant() != null && client.getCompteEpargne() != null) {
					System.out.println("Veuillez entrer un nouveau taux d'intéret");

					int nouveau = sc.nextInt();
					client.getCompteEpargne().setTaux(nouveau);
				}
				break;
			default:
				System.out.println("Choix non reconnu");
			}
			// Les conditions de sortie de la boucle change en fonction des choix proposés
			// précédement

			if (securite == true && selection != 1 && selection != 2 && selection != 3 && selection != 4)
				selection = 6;
		} while (selection != 1 && selection != 2 && selection != 3 && selection != 4 && selection != 5);
		this.modifierCompte(serviceCompte, client, listClient,sc);
//		cs.close();
	}

	/**
	 * @param serviceCompte
	 * @param client
	 */
	public void supprimerCompte(ServiceCompte serviceCompte, Client client) {
		int selection;
		// Déclaration d'un boolean permettant de modifier la bouble do while sous
		// condition
		boolean securite;
		Scanner up = new Scanner(System.in);

		do {
			securite = true;
			System.out.println("Quel compte voulez vous supprimer ?");
			// Selon les comptes du client le choix proposé change

			if (client.getCompteCourant() != null && client.getCompteEpargne() == null)
				System.out.println("1 - " + client.getCompteCourant());
			else if (client.getCompteCourant() == null && client.getCompteEpargne() != null)
				System.out.println("1 - " + client.getCompteEpargne());
			else {
				// Changement d'affectation du boolean

				securite = false;
				System.out.println("1 - " + client.getCompteCourant());
				System.out.println("2 - " + client.getCompteEpargne());
			}
			selection = up.nextInt();

			switch (selection) {
			case (1):
				// Selon les comptes du client le choix proposé change

				if (client.getCompteCourant() != null)
					client.setCompteCourant(null);
				else if (client.getCompteCourant() == null && client.getCompteEpargne() != null)
					client.setCompteEpargne(null);
				break;
			case (2):
				if (client.getCompteCourant() != null && client.getCompteEpargne() != null)
					client.setCompteEpargne(null);
				break;
			default:
				System.out.println("Choix non reconnu");
			}
			// Les conditions de sortie de la boucle change en fonction des choix proposés
			// précédement

			if (securite == true && selection != 1)
				selection = 3;
		} while (selection != 1 && selection != 2);
		System.out.println("Compte supprimé");
//		up.close();
	}

	/**
	 * @param serviceCompte
	 * @param client
	 */
	public void ajoutCompte(ServiceCompte serviceCompte, Client client, ArrayList<Client> listClient,Scanner sc) {
		sc.nextLine();
//		Scanner sc = new Scanner(System.in);
		// Si le client a déjà deux comptes, il ne peut pas en ajouter
		if (client.getCompteCourant() == null || client.getCompteEpargne() == null) {
			// Les choix proposés changent en fonction des comptes possédés

			if (client.getCompteCourant() == null) {
				System.out.println("Voulez vous ajouter un nouveau compte courant ? O/N");
				char choix = sc.nextLine().charAt(0);
				while (choix != 'O' && choix != 'N') {
					System.out.println("Choix non reconnu, recommencez");
					choix = sc.nextLine().charAt(0);
				}
				if (choix == 'O')
					serviceCompte.creationCompteCourant(client);
			}
			if (client.getCompteEpargne() == null) {
				System.out.println("Voulez vous ajouter un nouveau compte épargne ? O/N");
				char choix = sc.nextLine().charAt(0);
				while (choix != 'O' && choix != 'N') {
					System.out.println("Choix non reconnu, recommencez");
					choix = sc.nextLine().charAt(0);
				}
				if (choix == 'O')
					serviceCompte.creationCompteEpargne(client);

			}
		} else
			System.out.println("Il n'est pas possible d'ajouter de nouveau compte");
		serviceCompte.modifierCompte(serviceCompte, client, listClient,sc);
//		sc.close();
	}

	/**
	 * Retourne le nouveau solde du compte à débiter
	 * @param somme
	 * @param solde
	 * @return le nouveau solde
	 */
	public static double debiter(double somme, double solde) {
		double newSolde;
		newSolde = solde - somme;
		return newSolde;
	}
	
	/**
	 * Retourne le nouveau solde du compte à créditer
	 * @param somme
	 * @param solde
	 * @return le nouveau solde
	 */
	public static double crediter(double somme, double solde) {
		double newSolde;
		newSolde = solde + somme;
		return newSolde;
	}
}
