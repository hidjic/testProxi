package fr.gtm.presentation;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.gtm.domaine.Client;
import fr.gtm.domaine.Conseiller;
import fr.gtm.service.ClientService;
import fr.gtm.service.ConseillerService;

/**
 * Servlet implementation class listClient
 */
public class ServletListClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Conseiller cons = new Conseiller(1,"Lepremier","Conseiller","toto","123");
		ClientService servClient = new ClientService();
		
//		cons = (Conseiller) session.getAttribute("conseiller");
		int idDelete = 0;
		String id = request.getParameter("idDelete");
		if(id != null) {
			idDelete = Integer.parseInt(id);
			if(idDelete > 0) {
				Client leClient = new Client();
				leClient.setIdClient(idDelete);
				servClient.deleteClient(leClient);
			}
		}
		
		cons.setListeClients(servClient.getAllClient(cons));
		
		cons.setNbClient(cons.getListeClients().size());
		
		session.setAttribute("listClient", cons.getListeClients());
		this.getServletContext().getRequestDispatcher("/listClient.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		this.getServletContext().getRequestDispatcher("/editionClient.jsp").forward(request, response);
		response.getWriter().append("posttopost... Served azeazeaze at: ").append(request.getContextPath());
	}

}
