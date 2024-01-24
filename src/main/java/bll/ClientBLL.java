package bll;

import java.util.List;

import bo.Client;
import dal.ClientDAOjdbcImpl;
import dal.DALException;
import dal.GenericDAO;

public class ClientBLL {
	private GenericDAO<Client> dao;

	public ClientBLL() throws BLLException {
		try {
			dao = new ClientDAOjdbcImpl();
		} catch (DALException e) {
			throw new BLLException("Echec de la connexion", e);
		}
	}

	public List<Client> selectAll() throws BLLException {
		try {
			return dao.selectAll();
		} catch (DALException e) {
			throw new BLLException("Echec de la recuperation des clients", e);
		}
	}

	public Client selectById(int id) throws BLLException {
		try {
			return dao.selectById(id);
		} catch (DALException e) {
			throw new BLLException("Echec de la recuperation du client d'id " + id, e);
		}
	}

	public void insert(String nom, String prenom,String mail,String telephone,String mdp, int role) throws BLLException {

		Client client = new Client( nom,  prenom, mail, telephone, mdp, role);

		try {
			ClientDAOjdbcImpl clientDao = new ClientDAOjdbcImpl();
			clientDao.insert(client);

		} catch (DALException e) {
			throw new BLLException("Echec de l'insertion", e);
		}

	}

	public void update(Client client) throws BLLException {


		try {
			dao.update(client);
		} catch (DALException e) {
			throw new BLLException("Echec de la mise a jour", e);
		}
	}

	public void delete(int id) throws BLLException {
		try {
			dao.delete(id);
		} catch (DALException e) {
			throw new BLLException("Echec de la suppression", e);
		}
	}

	public Client getPassword( String mail, String password ) throws BLLException {
			try {
				return dao.getPassword(password, mail);
			} catch (DALException e) {
				throw new BLLException("Echec de la suppression", e);
			}
				

		}
	}


