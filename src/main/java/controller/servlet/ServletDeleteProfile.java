package controller.servlet;

import java.io.IOException;

import bll.BLLException;
import bll.ClientBLL;
import bo.Client;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ServletDeleteProfile extends HttpServlet {
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
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Client client = (Client) request.getSession().getAttribute("client");
		if (client == null) {
				request.getRequestDispatcher("/WEB-INF/jsp/public/PageConnection.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("WEB-INF/jsp/private/validationSuppression.jsp").forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String idClient = req.getParameter("id");
		int id = Integer.parseInt(idClient);
		try {
			
			clientBll.delete(id);
		} catch (BLLException e) {
			e.printStackTrace();
		}
		resp.sendRedirect("deconnexion");
		
	}

}
