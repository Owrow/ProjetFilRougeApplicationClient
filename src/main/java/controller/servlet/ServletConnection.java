package controller.servlet;

import java.io.IOException;



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

		

		try {
			client = new Client();
			clientBll = new ClientBLL();

		} catch (BLLException e) {

			e.printStackTrace();
		}

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Client client = (Client) request.getSession().getAttribute("client");
		if (client == null) {
			
			System.out.println("client pas encore connecté");
			request.getRequestDispatcher("/WEB-INF/jsp/public/PageConnection.jsp").forward(request, response);
		} else {
			
			System.out.println("client deja connecté");
			response.sendRedirect("accueil");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String mail = request.getParameter("email");
		String pass = request.getParameter("password");

		if (mail == null || mail.isEmpty() || pass == null || pass.isEmpty()) {

			System.out.println("Le mail ou le mot de passe n'est pas renseigné.");
			request.getRequestDispatcher("/WEB-INF/jsp/public/PageConnection.jsp").forward(request, response);

		} 
		
			
		try {	


			client = clientBll.getHashPassword(mail);
			
			if(client == null) {
				System.out.println("aucun client en base avec cet email");
				request.getRequestDispatcher("/WEB-INF/jsp/public/PageInscription.jsp").forward(request, response);
			}
			
			if(pass.equals(client.getMdp())) {
				System.out.println("mdp correcte");
				HttpSession session = request.getSession();
				session.setAttribute("client", client);
				session.setMaxInactiveInterval(30 * 60);
				response.sendRedirect("accueil");
			} else {

				System.out.println("mdp incorrecte");
				request.getRequestDispatcher("/WEB-INF/jsp/public/PageConnection.jsp").forward(request, response);

			}

		} catch (BLLException e) {

			e.printStackTrace();
		}


	}
}
