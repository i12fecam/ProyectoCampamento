package Data.DAO.Common;


import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Driver;
/**
 * A class to manage the MySQL connection (general methods and configuration).
 * @author Aurora Ramirez
 * @author Jose Raul Romero
 * */

public class
ConexionBD {

    protected Connection connection = null;


    public Connection getConnection(String url, String user, String password){

        try{
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, user, password);
            System.out.println("Database connection successfully opened!");
        }
        catch (SQLException e) {
            System.err.println("Connection to MySQL has failed!");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return this.connection;
    }

    // We can include here other methods to encapsulate CRUD commands...

    public void closeConnection() {
        try {
            if(this.connection != null && !this.connection.isClosed()) {
                this.connection.close();
                System.out.println("Database connection successfully closed!");
            }
        } catch (SQLException e) {
            System.err.println("Error while trying to close the connection.");
            e.printStackTrace();
        }
    }
}
