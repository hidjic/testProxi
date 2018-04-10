package proxybanque.service;

import java.util.ArrayList;

import proxybanque.domaineentity.Client;

public interface IAudit {
	
	// propriétés
	public final double valeurDebitMaxParticulier = 5000;
	public final double valeurDebitMaxEntreprise = 50000;
	
	// méthode
	public void audit(ArrayList<Client> listClient);
}
