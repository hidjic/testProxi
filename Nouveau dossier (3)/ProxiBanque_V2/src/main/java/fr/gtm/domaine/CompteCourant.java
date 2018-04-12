package fr.gtm.domaine;

/**
 * Classe CompteCourant heritee de la classe Compte
 * @author Stagiaire
 *
 */
public class CompteCourant extends Compte {
	
	// Attributs
	
	private int decouvert;
	
     //Construteurs
	/**
	 * Constructeur par defaut (autorisation de decouvert fixee a 1000 euros)
	 */
	public CompteCourant() {
		super();
		this.decouvert = 1000;
	}

	/**
	 * Constructeur complet
	 */
	public CompteCourant(String numCompte, float solde, String dateCreation,int decouvert) {
		super(numCompte,solde,dateCreation);
		this.decouvert = 1000;
	}

	// Getters/Setters
	
	public int getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(int decouvert) {
		this.decouvert = decouvert;
	}
	
	
	
	
	
	
}
