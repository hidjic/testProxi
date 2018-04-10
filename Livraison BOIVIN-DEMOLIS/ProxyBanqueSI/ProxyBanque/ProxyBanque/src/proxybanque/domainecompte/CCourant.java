package proxybanque.domainecompte;

//import java.text.SimpleDateFormat;
//import java.util.Date;

import proxybanque.domaineentity.Client;

public class CCourant extends Compte {
	
	// propri�t�s
	private int decouvert;
	private Carte carte;
	
	// construtors
	public CCourant() {
		super();
	}

	public CCourant(String formater, Client client) {
		super(formater, client);
		this.decouvert = 1000;
//		super.setNumeroCompte(001);
	}
	
	// getters et setters
	public Carte getCarte() {
		return carte;
	}

	public void setCarte(Carte carte) {
		this.carte = carte;
	}

	public int getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(int decouvert) {
		this.decouvert = decouvert;
	}
	
	// toString
	public String toString() {
		return super.toString(this.getNumeroCompte()) + ", a un d�couvert autoris� de " + this.decouvert + " et est associ� � une carte " +this.carte.getType();
	}
}
