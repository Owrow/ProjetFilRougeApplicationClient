package controller.servlet;

import java.io.IOException;

import bll.BLLException;
import bll.MessageBLL;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ServletMessagerie extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MessageBLL messageBll;
	
	@Override
	public void init() throws ServletException {
		super.init();
		try {
			messageBll = new MessageBLL();
		} catch (BLLException e) {
			e.printStackTrace();
		}

	}
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.getRequestDispatcher("WEB-INF/jsp/private/messagerie.jsp").forward(request, response);
	}

//	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		String sujet = request.getParameter("sujet");
//		String message = request.getParameter("message");
//		
//		Message newMessage = null;
//		try {
//			newMessage = messageBll.insert(sujet, message);
//			response.sendRedirect("details?id=" + newMessage.getId());
//		} catch (BLLException e) {
//			request.setAttribute("erreur", e);
//			request.getRequestDispatcher("/WEB-INF/jsp/private/messagerie.jsp").forward(request, response);// vers une jsp
//		}
//		
//	}

}
