package proxybanque.domaineentity;

public abstract class Personne {
	
	// propriétés
	private String nom;
	private String prenom;
	
	// constructors
	public Personne() {
		this.nom = "PersonneSansNom";
	}
	
	public Personne(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}
	
	// getters et setters
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

}
