package proxybanque.domainecompte;

//import java.text.SimpleDateFormat;
//import java.util.Date;

import proxybanque.domaineentity.Client;

public abstract class Compte {

	// propri�t�s
	private int numeroCompte;
	private double solde;
	private String dateOuverture;
	private Client client;

	// constructors
	public Compte() {
		this.numeroCompte = (int) (Math.random() * 10000);
		this.solde = 12;
		this.dateOuverture = "lundi";
		this.client = new Client();
	}

	public Compte(String date, Client client) {
		this.solde = 0;
		this.dateOuverture = date;
		this.client = client;
		this.numeroCompte = (int) (Math.random() * 10000);

	}

	// getters et setters
	public int getNumeroCompte() {
		return numeroCompte;
	}

	public void setNumeroCompte(int numeroCompte) {
		this.numeroCompte = numeroCompte;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public String getDateOuverture() {
		return dateOuverture;
	}

	public void setDateOuverture(String dateOuverture) {
		this.dateOuverture = dateOuverture;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	// toString
	public String toString(int numeroCompte) {
		return "Le compte de num�ro " + this.numeroCompte + " a pour solde " + this.solde + " euros, a �t� cr�� le "
				+ this.dateOuverture;
	}
}
