package controller.servlet;

import java.io.IOException;

import bll.BLLException;
import bll.ClientBLL;
import bo.Client;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ServletConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Client client;
	ClientBLL clientBll;

	@Override
	public void init() throws ServletException {
		
		super.init();
		client = new Client();
		try {
			clientBll = new ClientBLL();
		} catch (BLLException e) {
			
			e.printStackTrace();
		}
		
		}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doPost(request, response);
	}

		

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			
			String mail = request.getParameter("email");
			String pass = request.getParameter("password");

			
			if (mail == null || mail.isEmpty() || pass == null || pass.isEmpty()) {
			    
				System.out.println("Le mail ou le mot de passe n'est pas renseigné.");
			   request.getRequestDispatcher("/WEB-INF/jsp/public/PageConnection.jsp").forward(request, response);
			
			} else {
				
			   
			 try {
				client = clientBll.getPassword(mail, pass);
			} catch (BLLException e) {
				
				e.printStackTrace();
			}

			    if (client != null){
			    	System.out.println("la connection est active");
			      
			        response.sendRedirect("/ProjetFilRougeClient/src/main/java/controller/servlet/ServletAccueil.java");
			    } else {
			       
			        System.out.println("La connexion n'a pas marché");
			        request.getRequestDispatcher("/WEB-INF/jsp/public/PageConnection.jsp").forward(request, response);
			    }
			}
		}
}
			

			
			
			

			
			
	
