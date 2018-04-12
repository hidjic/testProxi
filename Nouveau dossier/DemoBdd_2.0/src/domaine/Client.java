package domaine;

public class Client {
	
	private int id;
	private String nom;
	private String prenom;
	private int age;
	private int idConseiller;
	
	// constructeur vide
	public Client() {
		super();
	}
	// constructeur pour la creation
	public Client(int id,String nom, String prenom, int age, int idConseiller) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.idConseiller = idConseiller;
	}
	// constructeur pour update
	public Client(int id) {
		super();
		this.id = id;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getIdConseiller() {
		return idConseiller;
	}
	public void setIdConseiller(int idConseiller) {
		this.idConseiller = idConseiller;
	}



	public String toString() {
		return "Client : id = "+this.getId()+",nom = "+this.getNom()+", prenom = "+this.getPrenom()+", age = "+this.getAge()+", idConseiller = "+this.getIdConseiller();
	}
	
}
