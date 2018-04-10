package proxybanque.service;

import java.util.ArrayList;

import proxybanque.domaineentity.Client;

public interface IAudit {
	
	// propri�t�s
	public final double valeurDebitMaxParticulier = 5000;
	public final double valeurDebitMaxEntreprise = 50000;
	
	// m�thode
	public void audit(ArrayList<Client> listClient);
}
