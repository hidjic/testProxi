package proxybanque.domaineentity;


public class Agence {
	
	// propriétes
	private String numeroIdentification;
	private String dateDeCreation;
	private Gerant gerant;
//	private Conseiller conseiller;
//	private Client client;
	
	// constructors
	public Agence() {
		this.numeroIdentification = "321ZE654879";
		this.dateDeCreation = "20/08/2005";
	}
	
	public Agence(String numeroIdentification, String dateDeCreation) {
		this.numeroIdentification = numeroIdentification;
		this.dateDeCreation = dateDeCreation;
	}
	
	// getters et setters
	public String getNumeroIdentification() {
		return numeroIdentification;
	}

	public void setNumeroIdentification(String numeroIdentification) {
		this.numeroIdentification = numeroIdentification;
	}

	public String getDateDeCreation() {
		return dateDeCreation;
	}

	public void setDateDeCreation(String dateDeCreation) {
		this.dateDeCreation = dateDeCreation;
	}

	public Gerant getGerant() {
		return gerant;
	}

	public void setGerant(Gerant gerant) {
		this.gerant = gerant;
	}


}
