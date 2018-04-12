package lanceur;

import java.util.ArrayList;

import domaine.Client;
import service.ServiceClient;

public class Main {

	public static void main(String[] args) {
		String res = "";
		// id necessaire car pas d'auto incrementation en bdd
		Client c1 = new Client(9,"Boivin", "Stéphane", 35, 1);
		ServiceClient servC = new ServiceClient();
		
		// creation
//		res = servC.createNewClient(c1);
//		System.out.println(res+" de "+c1);
		
		// get client
		Client c2 = new Client(9);
		c2 = servC.getOneClient(c2);
		System.out.println(c2);
		
		// update
		c2.setNom("Toto");
		c2.setPrenom("Leouf");
		c2.setAge(20);
		c2 = servC.updateOneClient(c2);
		System.out.println(c2);
		
		// delete
//		res = servC.deleteOneClient(c2);
//		System.out.println(res);
		
		// getAll
		ArrayList<Client> listC = new ArrayList<Client>();
		listC = servC.recuperationListClient();
		System.out.println("*** Liste des clients en base de données ***");
		for(Client c : listC) {
			System.out.println(c);
		}
		
	}

}
