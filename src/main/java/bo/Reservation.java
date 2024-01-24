package bo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reservation {

	private int id;
	private Restaurant restaurant;
	private Client client;
	private Table table;
	private LocalDate dateReservation;
	private LocalTime heureReservation;
	private String etat;
	private int tailleGroupe;

	public Reservation() {
		super();
	}

	public Reservation(int id, Restaurant restaurant, Client client, Table table, LocalDate dateReservation,
			LocalTime heureReservation, String etat, int tailleGroupe) {
		super();
		this.id = id;
		this.restaurant = restaurant;
		this.client = client;
		this.table = table;
		this.dateReservation = dateReservation;
		this.heureReservation = heureReservation;
		this.tailleGroupe = tailleGroupe;
		this.etat = etat;
	}

	public Reservation(Restaurant restaurant, Client client, Table table, LocalDate dateReservation,
			LocalTime heureReservation, String etat,int tailleGroupe) {
		super();
		this.restaurant = restaurant;
		this.client = client;
		this.table = table;
		this.dateReservation = dateReservation;
		this.heureReservation = heureReservation;
		this.tailleGroupe = tailleGroupe;
		this.etat = etat;
	}
	public Reservation(Restaurant restaurant, Client client, LocalDate dateReservation,
			LocalTime heureReservation,int tailleGroupe) {
		super();
		this.restaurant = restaurant;
		this.client = client;
		this.dateReservation = dateReservation;
		this.heureReservation = heureReservation;
		this.tailleGroupe = tailleGroupe;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}

	public LocalDate getDateReservation() {
		return dateReservation;
	}

	public void setDateReservation(LocalDate dateReservation) {
		this.dateReservation = dateReservation;
	}

	public LocalTime getHeureReservation() {
		return heureReservation;
	}

	public void setHeureReservation(LocalTime heureReservation) {
		this.heureReservation = heureReservation;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	
	
	public int getTailleGroupe() {
		return tailleGroupe;
	}

	public void setTailleGroupe(int tailleGroupe) {
		this.tailleGroupe = tailleGroupe;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", restaurant=" + restaurant + ", client=" + client + ", table=" + table
				+ ", dateReservation=" + dateReservation + ", heureReservation=" + heureReservation + ", etat=" + etat
				+ ", tailleGroupe=" + tailleGroupe + ", getId()=" + getId() + ", getRestaurant()=" + getRestaurant()
				+ ", getClient()=" + getClient() + ", getTable()=" + getTable() + ", getDateReservation()="
				+ getDateReservation() + ", getHeureReservation()=" + getHeureReservation() + ", getEtat()=" + getEtat()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	

}
