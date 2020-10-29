package config.bd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaBd {   
    public Connection getConnection() throws SQLException{
        Connection cn = null;
        try {
            Class.forName(driver).newInstance();
            cn = DriverManager.getConnection(url, user, password);

        } catch (ClassNotFoundException 
                | InstantiationException 
                | IllegalAccessException ex) {
       
            throw new SQLException(ex.getMessage());
        }
        return cn;
    }
                                                          //NOMBRE DE LA BASE DE DATOS
    private final String url = "jdbc:mysql://localhost:3306/academicoPOO";
    private final String driver = "com.mysql.jdbc.Driver";
    private final String user = "root";
    private final String password = "";
                                    //CLAVE
}
