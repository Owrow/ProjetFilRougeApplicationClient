package controller.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import bll.BLLException;
import bll.CarteBLL;
import bll.CategorieBLL;
import bll.ClientBLL;
import bll.PlatBLL;
import bll.PlatCarteBLL;
import bll.ReservationBLL;
import bll.RestaurantBLL;
import bll.RoleBLL;
import bo.Carte;
import bo.Categorie;
import bo.Client;
import bo.Plat;
import bo.PlatCarte;
import bo.Restaurant;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class ServletTraitementReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClientBLL clienBll;
	private RestaurantBLL restaurantBll;
	private PlatBLL platBll;
	private CarteBLL carteBll;
	private PlatCarteBLL platCarteBll;
	private RoleBLL roleBll;
	private CategorieBLL categorieBll;
	private ReservationBLL reservationBll;


	public void init(ServletConfig config) throws ServletException {
		try {
			clienBll = new ClientBLL();
			restaurantBll = new RestaurantBLL();
			platBll = new PlatBLL();
			carteBll = new CarteBLL();
			platCarteBll = new PlatCarteBLL();
			roleBll = new RoleBLL();
			categorieBll = new CategorieBLL();
			reservationBll = new ReservationBLL();

		} catch (BLLException e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Client client = (Client) request.getSession().getAttribute("client");
		System.out.println(client);
		
			String idRestaurantStr = request.getParameter("id_restaurant");

			int idRestaurant = Integer.parseInt(idRestaurantStr);
			
			Restaurant restaurant = new Restaurant();
			Plat plat = new Plat();
			Carte carte = new Carte();
			List<PlatCarte> platCartes = new ArrayList();
			List<Categorie> categories = new ArrayList<>();
			
			for (Categorie current : categories) {
				System.out.println(current);
			}
			
			
			Categorie categorie = new Categorie();
		

			try {

				restaurant = restaurantBll.selectById(idRestaurant);
				int idCarte = restaurant.getCarte().getId();
				carte = carteBll.selectById(idCarte);
				platCartes = platCarteBll.selectByPlatCarte(idCarte);
				categories = categorieBll.selectAll();
				
				
				
			} catch (BLLException e) {
				e.printStackTrace();
			}
			
			request.setAttribute("restaurant", restaurant);
			request.setAttribute("carte", carte);
			request.setAttribute("platCartes", platCartes);
			request.setAttribute("categorie", categorie);
			request.setAttribute("categories", categories);
			

			request.getRequestDispatcher("/WEB-INF/jsp/private/reservation.jsp").forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			Client client = (Client) request.getSession().getAttribute("client");
		
			String restaurantIdStr = request.getParameter("restaurantId");
			String dateReservationStr = request.getParameter("date");
			String heureReservationStr = request.getParameter("creneau");
			String tailleGroupeStr = request.getParameter("tailleGroupe");
						
			int restaurantId = Integer.parseInt(restaurantIdStr);
			Restaurant restaurant = new Restaurant();
			restaurant.setId(restaurantId);
			
			LocalDate dateReservation = LocalDate.parse(dateReservationStr);
			LocalTime heureReservation = LocalTime.parse(heureReservationStr);
			int tailleGroupe = Integer.parseInt(tailleGroupeStr);
			
			try {
				reservationBll.insert(client, restaurant, dateReservation, heureReservation, tailleGroupe);
			} catch (BLLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.getRequestDispatcher("/WEB-INF/jsp/private/reservationEnvoyee.jsp").forward(request, response);
		
	}

}
