package controller.servlet;

import java.io.IOException;

import org.mindrot.jbcrypt.BCrypt;

import bll.BLLException;
import bll.ClientBLL;
import bo.Client;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

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

			String hashedPassword = BCrypt.hashpw(pass, BCrypt.gensalt());
			client = clientBll.getUserAndPassword(mail,hashedPassword);
			System.out.println(client);
				
				if (client != null){
				System.out.println("la connection est active");
					response.sendRedirect("accueil");
					
					
					client = clientBll.getHashPassword(mail);
					
					System.out.println(client);
					 HttpSession session = request.getSession();
					    session.setAttribute("client", client); 
					    

					    
					    session.setMaxInactiveInterval(30*60); 

					   
					    response.sendRedirect("accueil");
			} else {

					System.out.println("La connexion n'a pas marché");
					request.getRequestDispatcher("/WEB-INF/jsp/public/PageConnection.jsp").forward(request, response);
				}

			} catch (BLLException e) {

				e.printStackTrace();
			}


		}
	}
}









