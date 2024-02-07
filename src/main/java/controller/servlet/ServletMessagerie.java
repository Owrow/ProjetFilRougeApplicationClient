package controller.servlet;

import java.io.IOException;

import bll.BLLException;
import bll.ClientBLL;
import bll.MessageBLL;
import bll.RestaurantBLL;
import bo.Client;
import bo.Message;
import bo.Restaurant;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ServletMessagerie extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MessageBLL messageBll;
	private ClientBLL clientBll;
	private RestaurantBLL restaurantBll;

	@Override
	public void init() throws ServletException {
		super.init();
		try {
			messageBll = new MessageBLL();
			clientBll = new ClientBLL();
			restaurantBll = new RestaurantBLL();
		} catch (BLLException e) {
			e.printStackTrace();
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Client client = (Client) request.getSession().getAttribute("client");
		String restaurantStr = request.getParameter("restaurantId");
		int restaurantId = Integer.parseInt(restaurantStr);
		Restaurant restaurant = new Restaurant();
		restaurant.setId(restaurantId);
		request.setAttribute("restaurant", restaurant);
		
		if (client == null) {
			System.out.println("client pas encore connecté");
			request.getRequestDispatcher("/WEB-INF/jsp/public/PageConnection.jsp").forward(request, response);
		} else {
			System.out.println("client  connecté");
			request.getRequestDispatcher("WEB-INF/jsp/private/messagerie.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Client client = (Client) request.getSession().getAttribute("client");
		System.out.println(client);
		
		String restaurantStr = request.getParameter("restaurantId");
		String message = request.getParameter("message");
		
		int clientId = client.getId();
		
		int restaurantId = Integer.parseInt(restaurantStr);
		

		try {
			client.setId(clientId);
			Restaurant restaurant = restaurantBll.selectById(restaurantId);
			messageBll.insert(message, client, restaurant);
			request.getRequestDispatcher("/WEB-INF/jsp/public/accueil.jsp").forward(request, response);
		} catch (BLLException e) {
			e.printStackTrace();

			request.getRequestDispatcher("/WEB-INF/jsp/private/messagerie.jsp").forward(request, response);// vers une
																											// jsp
		}

	}

}
