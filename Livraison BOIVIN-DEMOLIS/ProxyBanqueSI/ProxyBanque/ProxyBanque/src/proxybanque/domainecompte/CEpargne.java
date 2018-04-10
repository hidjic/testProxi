package proxybanque.domainecompte;

import proxybanque.domaineentity.Client;

public class CEpargne extends Compte {
	
	// propri�t�
	private double taux;
	
	// constructor
	public CEpargne(String formater, Client client) {
		super(formater, client);
		this.taux = 3;
//		super.setNumeroCompte(001);
	}
	
	// getter et setter
	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}
	
	// toString
	public String toString() {
		return super.toString(this.getNumeroCompte()) + " et a un taux d'�pargne de " + this.taux +"%";
	}
}
