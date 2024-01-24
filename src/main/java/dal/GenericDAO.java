package dal;

import java.util.List;

import bo.Client;

public interface GenericDAO<T> {
	
	List<T> selectAll() throws DALException;
	T selectById(int T) throws DALException;
	void insert(T donnee) throws DALException;
	void update(T donnee) throws DALException;
	void delete(int T) throws DALException;
	
	

}
