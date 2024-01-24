package controller.servlet;

import java.io.IOException;

import bll.BLLException;
import bll.ClientBLL;
import bo.Client;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ServletUpdateProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClientBLL clientBll;
	
	@Override
	public void init() throws ServletException {
		super.init();
		try {
			clientBll = new ClientBLL();
		} catch (BLLException e) {
			e.printStackTrace();
		}
	}
	
	// Etape 1 : recuperer les parametres	
	// Etape 2 : passage dans le bon type	
	// Etape 3 : exploitation des parametres par le bll
	// Etape 4 : ajout des attributs a la requete	
	// Etape 5 : redirection vers la jsp
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idClient = request.getParameter("id");		
		int id = Integer.parseInt(idClient);		
		
		try {
			Client client = clientBll.selectById(id);			
			request.setAttribute("client", client);
		} catch (BLLException e) {
			e.printStackTrace();
		}			
			
		request.getRequestDispatcher("WEB-INF/jsp/private/updateProfile.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idClient = request.getParameter("id");
		String nomClient = request.getParameter("nom");
		String prenomClient = request.getParameter("prenom");
		String mailClient = request.getParameter("mail");
		String telClient = request.getParameter("telephone");
		
		int id = Integer.parseInt(idClient);
		
		try {
			Client clientToUpdate = clientBll.selectById(id);
			clientToUpdate.setNom(nomClient);
			clientToUpdate.setPrenom(prenomClient);
			clientToUpdate.setMail(mailClient);
			clientToUpdate.setTelephone(telClient);
			clientBll.update(clientToUpdate);
			response.sendRedirect("details?id=" + id);
			
		} catch (BLLException e) {			
			request.setAttribute("erreur", e);
			request.getRequestDispatcher("/WEB-INF/jsp/rpivate/updateProfilejsp").forward(request, response);
		}		
		
		
	}

}
