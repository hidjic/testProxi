package proxybanque.service;

import java.util.ArrayList;

import proxybanque.domaineentity.Client;

public class ServiceGerant implements IAudit {
	
	/* (non-Javadoc)
	 * @see proxybanque.service.IAudit#audit(java.util.ArrayList)
	 */
	public void audit(ArrayList<Client> listClient) {
//		ServiceConseiller servC = new ServiceConseiller();
//		ArrayList<Client> listClient = new ArrayList<Client>();
		ArrayList<Client> listClientAudit = new ArrayList<Client>();
		ArrayList<Client> listEntrepriseAudit = new ArrayList<Client>();
		
//		listClient = servC.createClientList();
		double solde = 0;
		for(Client c : listClient) {
			solde = 0;
			if(!c.isEntreprise()) {
				if(c.getCompteCourant() != null) {solde += c.getCompteCourant().getSolde();}
				if(c.getCompteEpargne() != null) {solde += c.getCompteEpargne().getSolde();}
				if(solde < (-IAudit.valeurDebitMaxParticulier)) {
					listClientAudit.add(c);
				}
			}
			if(c.isEntreprise()) {
				if(c.getCompteCourant() != null) {solde += c.getCompteCourant().getSolde();}
				if(c.getCompteEpargne() != null) {solde += c.getCompteEpargne().getSolde();}
				if(solde < (-IAudit.valeurDebitMaxEntreprise)) {
					listEntrepriseAudit.add(c);
				}
			}
		}
		affichageClientAudit(listClientAudit,listEntrepriseAudit);
	}
	
	/**
	 * Permet d'afficher la liste des client qui ont dépassé les limites autorisé par l'audit
	 * @param listClient
	 * @param listEntreprise
	 */
	private void affichageClientAudit(ArrayList<Client> listClient,ArrayList<Client> listEntreprise) {
		double solde = 0;
		System.out.println("");
		System.out.println("*** Affichage des clients dépassant les limites de l'audit ***");
		System.out.println(listClient.size()+" client(s) est/sont débiteur de plus de "+IAudit.valeurDebitMaxParticulier+" euros.");
		if(listClient.size() > 0) {
			for(Client c : listClient) {
				solde = 0;
				if(c.getCompteCourant() != null) {solde += c.getCompteCourant().getSolde();}
				if(c.getCompteEpargne() != null) {solde += c.getCompteEpargne().getSolde();}
				System.out.println("Nom : "+c.getNom()+" "+c.getPrenom()+", solde total : "+solde+" euros.");
			}
		}
		System.out.println("");
		System.out.println(listClient.size()+" entreprise(s) est/sont débiteur de plus de "+IAudit.valeurDebitMaxEntreprise+" euros.");
		if(listClient.size() > 0) {
			for(Client cE: listEntreprise) {
				solde = 0;
				if(cE.getCompteCourant() != null) {solde += cE.getCompteCourant().getSolde();}
				if(cE.getCompteEpargne() != null) {solde += cE.getCompteEpargne().getSolde();}
				System.out.println("Nom : "+cE.getNom()+" "+cE.getPrenom()+", solde total : "+solde+" euros.");
			}
		}
	}

	
}
