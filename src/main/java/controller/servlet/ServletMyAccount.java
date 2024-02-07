package controller.servlet;
 
import java.io.IOException;
 
import bo.Client;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
 
public class ServletMyAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Client client = (Client) request.getSession().getAttribute("client");
		if (client == null) {
			System.out.println("client pas encore connecté");
			request.getRequestDispatcher("/WEB-INF/jsp/public/PageConnection.jsp").forward(request, response);
		} else {
			System.out.println("client connecté");
			request.getRequestDispatcher("WEB-INF/jsp/private/myAccount.jsp").forward(request, response);
		}
	}
 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		
	}
 
}