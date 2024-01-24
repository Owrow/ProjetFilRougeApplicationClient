package controller.servlet;

import java.io.IOException;

import org.mindrot.jbcrypt.BCrypt;

import bll.BLLException;
import bll.ClientBLL;
import bll.RoleBLL;
import bo.Client;
import bo.Role;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class ServletInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Client clientSignIn;
	private ClientBLL clientBll;
	private Role role;
	private RoleBLL roleBll;



	@Override
	public void init() throws ServletException {

		try {
			clientBll = new ClientBLL();
			role = new Role();
			clientSignIn = new Client();
			roleBll = new RoleBLL();


		} catch (BLLException e) {
			e.printStackTrace();
		}

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String nameSignIn       = request.getParameter("nom");
		String firstNameSignIn  = request.getParameter("prenom");
		String mailSignIn       = request.getParameter("mail");
		String telSignIn        = request.getParameter("telephone");
		String passSignIn       = request.getParameter("password");
		String confirPassSignIn = request.getParameter("confirmPass");

		if (passSignIn != null && passSignIn.equals(confirPassSignIn)) {

			try {

				String hashedPassword = BCrypt.hashpw(confirPassSignIn, BCrypt.gensalt());
				clientBll.insert(nameSignIn, firstNameSignIn, telSignIn, mailSignIn, hashedPassword, 1);
				System.out.println("Client Ajouter");

			} catch (BLLException e) {
				e.printStackTrace();
			}
				} else {
			
					System.out.println("Les mots de passe ne correspondent pas, renvoyez l'erreur à l'utilisateur"); 

		}


		request.getRequestDispatcher("/WEB-INF/jsp/public/PageInscription.jsp").forward(request, response);
	
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
