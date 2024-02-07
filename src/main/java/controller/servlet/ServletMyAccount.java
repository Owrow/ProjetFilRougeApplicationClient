package controller.servlet;
<<<<<<< HEAD
 
import java.io.IOException;
 
=======

import java.io.IOException;

>>>>>>> 9b5eed6870d4ecf36225c6320594c52d0d4c949e
import bo.Client;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
<<<<<<< HEAD
 
=======

>>>>>>> 9b5eed6870d4ecf36225c6320594c52d0d4c949e
public class ServletMyAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Client client = (Client) request.getSession().getAttribute("client");
		if (client == null) {
			System.out.println("client pas encore connecté");
			request.getRequestDispatcher("/WEB-INF/jsp/public/PageConnection.jsp").forward(request, response);
		} else {
<<<<<<< HEAD
			System.out.println("client connecté");
=======
			System.out.println("client deja connecté");
>>>>>>> 9b5eed6870d4ecf36225c6320594c52d0d4c949e
			request.getRequestDispatcher("WEB-INF/jsp/private/myAccount.jsp").forward(request, response);
		}
	}
 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		
	}
 
}