package fr.gtm.service;
import java.util.ArrayList;

import fr.gtm.dao.*;
import fr.gtm.domaine.*;


public class ClientService {

	ClientDao dao = new ClientDao();

	public boolean createClient(Client leClient) {
		boolean reponse = dao.createClient(leClient);
		return reponse; // retour de la reponse
	}

	public Client getClient(Client leClient) {
		leClient = dao.getClient(leClient);
		return leClient;
	}

	public Client updateClient(Client leClient) {
		leClient = dao.updateClient(leClient);
		return leClient;
	}

	public boolean deleteClient(Client leClient) {
		boolean reponse = dao.deleteClient(leClient);
		return reponse; // retour de la réponse
	}

	public ArrayList<Client> getAllClient() {
		ArrayList<Client> listClients = dao.getAllClient();
		return listClients;
	}
}


