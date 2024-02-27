package dal;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionProvider {
	
   
    private static final String CONTEXT_NAME = "sevDriver";
	
    public static Connection getConnection() {
        try {
            Context context = new InitialContext();
          
            DataSource dataSource = (DataSource) context.lookup("java:comp/env/" + CONTEXT_NAME);
            return dataSource.getConnection();
        } catch (NamingException | SQLException e) {
            e.printStackTrace();
            return null; 
        }
    } 
}
