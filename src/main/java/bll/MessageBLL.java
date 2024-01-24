package bll;

import java.util.List;

import bo.Client;
import bo.Message;
import bo.Restaurant;
import dal.DALException;
import dal.GenericDAO;
import dal.MessageDAOjdbcImpl;

public class MessageBLL {
	private GenericDAO<Message> dao;

	public MessageBLL() throws BLLException {
		try {
			dao = new MessageDAOjdbcImpl();
		} catch (DALException e) {
			throw new BLLException("Echec de la connexion", e);
		}
	}

	public List<Message> selectAll() throws BLLException {
		try {
			return dao.selectAll();
		} catch (DALException e) {
			throw new BLLException("Echec de la recuperation des messages", e);
		}
	}

	public Message selectById(int id) throws BLLException {
		try {
			return dao.selectById(id);
		} catch (DALException e) {
			throw new BLLException("Echec de la recuperation du message d'id " + id, e);
		}
	}

	public void insert(String message_text, Client client, Restaurant restaurant) throws BLLException {

		Message message = new Message(message_text, client, restaurant);

		try {
			MessageDAOjdbcImpl messageDao = new MessageDAOjdbcImpl();
			messageDao.insert(message);

		} catch (DALException e) {
			throw new BLLException("Echec de l'insertion du message", e);
		}

	}

	public void update(Message message) throws BLLException {
		try {
			dao.update(message);
		} catch (DALException e) {
			throw new BLLException("Echec de la mise a jour", e);
		}
	}

	public void delete(int id) throws BLLException {
		try {
			dao.delete(id);
		} catch (DALException e) {
			throw new BLLException("Echec de la suppression du message", e);
		}
	}

}
