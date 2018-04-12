package service;

import java.util.ArrayList;

import dao.ClientDao;
import domaine.Client;

public class ServiceClient {
	
	private ClientDao cDao = new ClientDao();
	
	public String createNewClient(Client c) {
		String res = "";
		boolean insert = false;
		insert = this.cDao.createClient(c);
		res = insert ? "insert ok" : "problem insert";
		return res;
	}
	
	public Client getOneClient(Client c) {
		c = this.cDao.getClient(c);
		return c;
	}
	
	public Client updateOneClient(Client c) {
		c = this.cDao.updateClient(c);
		return c;
	}
	
	public String deleteOneClient(Client c) {
		boolean delete = false;
		String res = "";
		delete = this.cDao.deleteClient(c);
		res = delete ? "suppression ok" : "probleme lors de la suppression";
		return res;
	}
	
	public ArrayList<Client> recuperationListClient(){
		ArrayList<Client> listC = new ArrayList<Client>();
		listC = this.cDao.listClient();
		return listC;
	}
	
}
