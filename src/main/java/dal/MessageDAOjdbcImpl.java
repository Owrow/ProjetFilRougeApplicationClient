package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bo.Client;
import bo.Message;
import bo.Restaurant;

public class MessageDAOjdbcImpl implements GenericDAO<Message> {

	private static final String TABLE_NAME = "messages";

	private static final String SELECT_ALL = "SELECT m.id, m.message_text, c.id AS id_client, r.id AS id_restaurant FROM "
			+ TABLE_NAME
			+ " m INNER JOIN clients c ON c.id = m.id_client INNER JOIN restaurants r ON r.id = m.id_retaurant";


	private static final String INSERT = "INSERT INTO " + TABLE_NAME
			+ " (message_text, id_client, id_restaurant) VALUES (?,?,?)";

	private Connection cnx;

	public MessageDAOjdbcImpl() throws DALException {
		cnx = ConnectionProvider.getConnection();

	}

	public List<Message> selectAll() throws DALException {
		List<Message> listeMessages = new ArrayList<>();

		try {
			PreparedStatement ps = cnx.prepareStatement(SELECT_ALL);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Message message = new Message();
				Client client = new Client();
				Restaurant restaurant = new Restaurant();
				
				message.setMessage_text(rs.getString("message_text"));				
				client.setId(rs.getInt("id_client"));				
				restaurant.setId(rs.getInt("id_restaurant"));	
				
				
				message.setClient(client);
				message.setRestaurant(restaurant);

				listeMessages.add(message);

			}
		} catch (SQLException e) {
			throw new DALException("Impossible de recuperer les informations du message", e);
		}
		return listeMessages;
	}

	public Message selectById(int id) throws DALException {

		return null;
	}

	public void insert(Message message) throws DALException {
		try {
			PreparedStatement ps = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, message.getMessage_text());
			ps.setInt(2, message.getClient().getId());
			ps.setInt(3, message.getRestaurant().getId());
			
			ps.executeUpdate();
			
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()) {
				int id = rs.getInt(1);
				message.setId(id);
			}
		} catch (SQLException e) {
			throw new DALException("Impossible d'inserer un message", e);
		}

	}

	public void update(Message message) throws DALException {

	}

	public void delete(int id) throws DALException {

	}
}
