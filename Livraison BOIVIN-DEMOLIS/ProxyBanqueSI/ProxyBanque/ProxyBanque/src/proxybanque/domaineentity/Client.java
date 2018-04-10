package proxybanque.domaineentity;

import proxybanque.domainecompte.CCourant;
import proxybanque.domainecompte.CEpargne;

public class Client extends Personne {
	
	// propriétes
	private String adresse;
	private String codePostal;
	private String ville;
	private String telephone;
	private boolean riche;
	private boolean entreprise;
	private Agence agence;
	private Conseiller conseiller;
	private CEpargne compteEpargne;
	private CCourant compteCourant;

	// constructors
	public Client() {
		super();
	}

	public Client(String nom, String prenom, String adresse, String codePostal, String ville, String telephone, boolean riche, boolean entreprise) {
		super(nom, prenom);
		this.adresse=adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.telephone = telephone;
		this.riche = riche;
		this.entreprise = entreprise;
		this.agence= new Agence();
		this.conseiller = new Conseiller();
	}
	
	// getters et setters
	public String getAdresse() {
		return adresse;
	}
	
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public String getCodePostal() {
		return codePostal;
	}
	
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	
	public String getVille() {
		return ville;
	}
	
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	public String getTelephone() {
		return telephone;
	}
	
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public boolean isRiche() {
		return riche;
	}
	
	public void setRiche(boolean riche) {
		this.riche = riche;
	}
	
	public boolean isEntreprise() {
		return entreprise;
	}
	
	public void setEntreprise(boolean entreprise) {
		this.entreprise = entreprise;
	}
	
	public Agence getAgence() {
		return agence;
	}
	
	public void setAgence(Agence agence) {
		this.agence = agence;
	}
	
	public Conseiller getConseiller() {
		return conseiller;
	}
	
	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}
	
	public CEpargne getCompteEpargne() {
		return compteEpargne;
	}
	
	public void setCompteEpargne(CEpargne compteEpargne) {
		this.compteEpargne = compteEpargne;
	}
	
	public CCourant getCompteCourant() {
		return compteCourant;
	}
	
	public void setCompteCourant(CCourant compteCourant) {
		this.compteCourant = compteCourant;
	}
	
	// toString
	public String toString() {
		return this.getNom() + ", " + this.getPrenom();
	}
}
