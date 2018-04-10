package proxybanque.service;

import proxybanque.domaineentity.Client;

public class ServiceClient {

	/**
	 * @param client
	 */
	public void afficherClient(Client client) {
		System.out.println("1 - Nom : " + client.getNom());
		System.out.println("2 - Prénom : " + client.getPrenom());
		System.out.println("3 - Adresse : " + client.getAdresse());
		System.out.println("4 - Code postal : " + client.getCodePostal());
		System.out.println("5 - Ville : " + client.getVille());
		System.out.println("6 - Numéro de telephone : " + client.getTelephone());
		System.out.println("7 - Comptes : ");
		//Affichage des comptes sous condition qu'ils existent
		if (client.getCompteCourant() != null)
			System.out.println(client.getCompteCourant());
		if (client.getCompteEpargne() != null)
			System.out.println(client.getCompteEpargne());
		if (client.getCompteCourant() == null && client.getCompteEpargne() == null)
			System.out.println("Aucun compte associé");

	}
	
	/**
	 * Mets à jour la propriété du client qui le défini comme fortuné ou non
	 * @param myClient
	 */
	public void gestionBooleanRiche(Client myClient) {
		boolean isEntreprise = myClient.isEntreprise();
//		double totalSolde = (myClient.getCompteCourant().getSolde() + myClient.getCompteEpargne().getSolde());
		double totalSolde = 0;
		
		if(myClient.getCompteCourant() != null) {totalSolde += myClient.getCompteCourant().getSolde();}
		if(myClient.getCompteEpargne() != null) {totalSolde += myClient.getCompteEpargne().getSolde();}
		
		if(!isEntreprise) {
			if(totalSolde > IGestionClientFortunes.valeurIsRich) {
				myClient.setRiche(true);
			}else {
				myClient.setRiche(false);
			}
		}
	}
}
