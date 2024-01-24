package bll;

import java.time.LocalDate;
import java.time.LocalTime;

import bo.Client;
import bo.Reservation;
import bo.Restaurant;
import bo.Table;
import dal.DALException;
import dal.GenericDAO;
import dal.ReservationDAOjdbclmpl;

public class ReservationBLL {

	private GenericDAO<Reservation> dao;

	public ReservationBLL() throws BLLException {
		try {
			dao = new ReservationDAOjdbclmpl();
		} catch (DALException e) {
			throw new BLLException("Echec de la connexion", e);
		}
	}
	
	public Reservation insert(Client client,Restaurant restaurant,LocalDate dateReservation, LocalTime heureReservation, int tailleGroupe) throws BLLException {
		Reservation reservation = new Reservation(restaurant,client, dateReservation,heureReservation,tailleGroupe);
		BLLException blleException = new BLLException();
		
		try {
			dao.insert(reservation);
		} catch (DALException e) {
			throw new BLLException("Echec de l'insertion", e);
		}
		
		return reservation;
		
	}
	
	
}
