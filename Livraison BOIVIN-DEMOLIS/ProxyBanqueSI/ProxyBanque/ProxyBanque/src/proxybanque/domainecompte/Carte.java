package proxybanque.domainecompte;

public class Carte {
	
	// propri�t�s
	private CCourant compteCourant;
	private TypeCarte type;
	
	// constructor
	public Carte(TypeCarte type) {
		this.type = type;
	}
	
	// getters et setters
	public CCourant getCompteCourant() {
		return compteCourant;
	}
	public void setCompteCourant(CCourant compteCourant) {
		this.compteCourant = compteCourant;
	}
	public TypeCarte getType() {
		return type;
	}
	public void setType(TypeCarte type) {
		this.type = type;
	}

}
