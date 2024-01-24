package dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;

import bo.Reservation;

public class ReservationDAOjdbclmpl implements GenericDAO<Reservation> {

	private static final String TABLE_NAME = "reservations";

	private static final String DELETE = "DELETE FROM " + TABLE_NAME + " WHERE id = ?";
	private static final String UPDATE = "UPDATE " + TABLE_NAME + " ";
	private static final String INSERT = "INSERT INTO " + TABLE_NAME + " (id_client, id_restaurant, date_reservation, heure_reservation, etat, taille_groupe) VALUES (?,?,?,?,?,?)";
	private static final String SELECT_BY_ID = "SELECT FROM " + TABLE_NAME + " WHERE id = ?";
	private static final String SELECT = "SELECT * FROM " + TABLE_NAME + " ";

	private Connection cnx;
	
	public ReservationDAOjdbclmpl() throws DALException {
		cnx = ConnectionProvider.getConnection();
	}

	@Override
	public List<Reservation> selectAll() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reservation selectById(int T) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Reservation reservation) throws DALException {
		try {
			PreparedStatement ps = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, reservation.getClient().getId());
			ps.setInt(2, reservation.getRestaurant().getId());
			ps.setDate(3, Date.valueOf(reservation.getDateReservation()));
			ps.setTime(4, Time.valueOf(reservation.getHeureReservation()));
			ps.setString(5, "PENDING");
			ps.setInt(6, reservation.getTailleGroupe());
			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				int id = rs.getInt(1); 
				reservation.setId(id);
			}
		} catch (SQLException e) {
			throw new DALException("Impossible d'inserer les donnees.", e);
		}
	}

	@Override
	public void update(Reservation donnee) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int T) throws DALException {
		// TODO Auto-generated method stub
		
	}

	
}
