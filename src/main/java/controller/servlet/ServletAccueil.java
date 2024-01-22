package controller.servlet;

import java.io.IOException;

import bll.BLLException;
import bll.RestaurantBLL;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ServletAccueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RestaurantBLL restaurantBll;
  
	@Override
	public void init() throws ServletException {
		super.init();
		try {
			restaurantBll = new RestaurantBLL();
		} catch (BLLException e) {
			e.printStackTrace();
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setAttribute("restaurants", restaurantBll.selectAll());
		} catch (BLLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/WEB-INF/jsp/public/accueil.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

