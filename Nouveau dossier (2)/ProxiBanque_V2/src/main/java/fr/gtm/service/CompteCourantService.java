package fr.gtm.service;


import fr.gtm.dao.CompteCourantDao;
import fr.gtm.domaine.Client;
import fr.gtm.domaine.CompteCourant;

public class CompteCourantService {

		CompteCourantDao dao = new CompteCourantDao();

		public boolean createCompteCourant(CompteCourant leCompteCourant) {
			boolean reponse = dao.createCompteCourant(leCompteCourant);
			return reponse; // retour de la reponse
		}

		public CompteCourant getCompteCourant(Client c) {
			CompteCourant leCompteCourant = new CompteCourant();
			leCompteCourant = dao.getCompteCourant(c);
			return leCompteCourant;
		}

		public CompteCourant updateCCompteCourant(CompteCourant leCompteCourant) {
			leCompteCourant = dao.updateCompteCourant(leCompteCourant);
			return leCompteCourant;
		}

		public boolean deleteCompteCourant(CompteCourant leCompteCourant) {
			boolean reponse = dao.deleteCompteCourant(leCompteCourant);
			return reponse; // retour de la r�ponse
		}
}
