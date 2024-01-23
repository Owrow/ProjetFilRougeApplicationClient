package controller.servlet;

import java.io.IOException;

import bll.BLLException;
import bll.ClientBLL;
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idClient = request.getParameter("id");
		int id = Integer.parseInt(idClient);
		try {
			clientBll.delete(id);
		} catch (BLLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("WEB-INF/jsp/public/accueil.jsp").forward(request, response);
	}

}
