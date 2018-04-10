package proxybanque.presentation;

import java.util.ArrayList;
import java.util.Scanner;

//import java.util.Date;
//import java.util.Scanner;
//
//import proxybanque.domainecompte.CCourant;
//import proxybanque.domaineentity.Agence;
import proxybanque.domaineentity.Client;
import proxybanque.service.ServiceConseiller;
import proxybanque.service.ServiceLanceur;

public class lanceur {

	public static void main(String[] args) {
//		boolean riche;
		ServiceLanceur serviceLanceur = new ServiceLanceur();
		ServiceConseiller service = new ServiceConseiller ();
		ArrayList<Client> listClient = service.createClientList();
		
		Scanner sc = new Scanner(System.in);

		System.out.println("ProxyBanque");
		System.out.println("----------------");

		serviceLanceur.menuPrincipal(listClient,sc);
		
//		sc.close();

	}

}
