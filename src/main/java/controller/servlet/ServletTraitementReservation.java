package controller.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import bll.BLLException;
import bll.CarteBLL;
import bll.CategorieBLL;
import bll.ClientBLL;
import bll.PlatBLL;
import bll.PlatCarteBLL;
import bll.RestaurantBLL;
import bll.RoleBLL;
import bo.Carte;
import bo.Categorie;
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


	public void init(ServletConfig config) throws ServletException {
		try {
			clienBll = new ClientBLL();
			restaurantBll = new RestaurantBLL();
			platBll = new PlatBLL();
			carteBll = new CarteBLL();
			platCarteBll = new PlatCarteBLL();
			roleBll = new RoleBLL();
			categorieBll = new CategorieBLL();

		} catch (BLLException e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String idRestaurantStr = request.getParameter("id_restaurant");

			int idRestaurant = Integer.parseInt(idRestaurantStr);
			
			Restaurant restaurant = new Restaurant();
			Plat plat = new Plat();
			Carte carte = new Carte();
			List<PlatCarte> platCartes = new ArrayList();
			List<Categorie> categories = new ArrayList<>();
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

		doGet(request, response);
	}

}
