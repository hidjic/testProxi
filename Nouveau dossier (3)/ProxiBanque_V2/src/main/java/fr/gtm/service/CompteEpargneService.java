package fr.gtm.service;

import fr.gtm.dao.CompteEpargneDao;
import fr.gtm.domaine.Client;
import fr.gtm.domaine.CompteEpargne;

public class CompteEpargneService {

		CompteEpargneDao dao = new CompteEpargneDao();

		public boolean createCompteEpargne(CompteEpargne leCompteEpargne) {
			boolean reponse = dao.createCompteEpargne(leCompteEpargne);
			return reponse; // retour de la reponse
		}

		public CompteEpargne getCompteEpargne(Client c) {
			CompteEpargne leCompteEpargne = new CompteEpargne();
			leCompteEpargne = dao.getCompteEpargne(c);
			return leCompteEpargne;
		}

		public CompteEpargne updateCompteEpargne(CompteEpargne leCompteEpargne) {
			leCompteEpargne = dao.updateCompteEpargne(leCompteEpargne);
			return leCompteEpargne;
		}

		public boolean deleteCompteEpargne(CompteEpargne leCompteEpargne) {
			boolean reponse = dao.deleteCompteEpargne(leCompteEpargne);
			return reponse; // retour de la r�ponse
		}
}
