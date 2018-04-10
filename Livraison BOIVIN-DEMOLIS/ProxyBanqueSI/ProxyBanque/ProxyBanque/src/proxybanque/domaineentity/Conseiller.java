package proxybanque.domaineentity;

public class Conseiller extends Personne {
	
	// propriétés
	private Gerant gerant;
	private Client client;
	private int nombreClient;
	private Agence agence;
	
	// constructors
	public Conseiller() {
		super("Le", "Conseiller");
	}

	public Conseiller(String nom, String prenom, int nombreClient, Agence agence) {
		super(nom, prenom);
		this.nombreClient = nombreClient;
		this.agence = agence;
	}

	// getters et setters
	public Gerant getGerant() {
		return gerant;
	}

	public void setGerant(Gerant gerant) {
		this.gerant = gerant;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public int getNombreClient() {
		return nombreClient;
	}

	public void setNombreClient(int nombreClient) {
		this.nombreClient = nombreClient;
	}

	public Agence getAgence() {
		return agence;
	}

	public void setAgence(Agence agence) {
		this.agence = agence;
	}

}
	


