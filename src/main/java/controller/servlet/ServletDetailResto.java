package controller.servlet;

import java.io.IOException;

import bll.BLLException;
import bll.RestaurantBLL;
import bo.Restaurant;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ServletDetailResto extends HttpServlet {
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
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idResto = request.getParameter("id");
		
		int id = Integer.parseInt(idResto);
		
		Restaurant restaurant = null;
		try {
			restaurant = restaurantBll.selectById(id);
		} catch (BLLException e) {
			
			e.printStackTrace();
		}
		request.setAttribute("restaurant", restaurant);
		request.getRequestDispatcher("/WEB-INF/jsp/public/detailResto.jsp").forward(request, response);
	}

	

}
