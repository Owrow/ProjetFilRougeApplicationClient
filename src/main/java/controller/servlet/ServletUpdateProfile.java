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
	
	
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Client client = (Client) request.getSession().getAttribute("client");
		if (client == null) {
			System.out.println("client pas encore connecté");
			request.getRequestDispatcher("/WEB-INF/jsp/public/PageConnection.jsp").forward(request, response);
		} else {
			System.out.println("client  connecté");
			request.getRequestDispatcher("WEB-INF/jsp/private/updateProfile.jsp").forward(request, response);
		}
	}
	
// Etape 1 : recuperer les parametres	
	// Etape 2 : passage dans le bon type	
	// Etape 3 : exploitation des parametres par le bll
	// Etape 4 : ajout des attributs a la requete	
	// Etape 5 : redirection vers la jsp
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  String clientStr = request.getParameter("id");
	  System.out.println("parse de id" + clientStr );
	    int clientId = Integer.parseInt(clientStr);
	    
	    try {
	        
	        Client client = clientBll.selectById(clientId);	        
	       
	        String nomClient = request.getParameter("nom");
	        String prenomClient = request.getParameter("prenom");
	        String mailClient = request.getParameter("mail");
	       
	        String telClient = request.getParameter("telephone");
	        
	        client.setNom(nomClient);
	        client.setPrenom(prenomClient);
	        client.setMail(mailClient);
	       
	        client.setTelephone(telClient);
	        
	        client.setId(clientId);
	        
	        System.out.println("client à jour" + client );
	        clientBll.update(client);
	        System.out.println("client après update" + client );
	         request.getRequestDispatcher("/WEB-INF/jsp/private/updateProfile.jsp").forward(request, response);
	    
	    } catch (BLLException e) {
	      e.printStackTrace();
	       
	      
	    }
	}


}
