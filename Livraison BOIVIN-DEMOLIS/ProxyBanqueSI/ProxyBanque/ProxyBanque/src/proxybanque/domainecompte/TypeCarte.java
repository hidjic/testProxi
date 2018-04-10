package proxybanque.domainecompte;

public enum TypeCarte {
	
	// enumération
	ELECTRON ("Visa Electron"),
	PREMIER("Visa Premier");
	
	private String name ="";
	
	private TypeCarte(String name) {
		this.name = name;
	}
	public String toString() {
		return name;
	}
}
