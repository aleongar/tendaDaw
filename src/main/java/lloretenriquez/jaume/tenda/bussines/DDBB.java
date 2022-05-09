package lloretenriquez.jaume.tenda.bussines;
import javax.xml.transform.Result;
import java.sql.*;

public class DDBB {
    private static Connection connection;
    private static Statement query;
    private static final String URL = "jdbc:postgresql://localhost:5432/tenda?user=postgres&password=1234";

    public static boolean login(String user, String password){
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL);
            query = connection.createStatement();
            String sql  = "SELECT id FROM users WHERE username = '"+user+"' AND password = '"+ password+"'";
            ResultSet result = query.executeQuery(sql);
            result.next();
            return result.getInt(1) > 0 ? true : false;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            System.err.println("No se han podido obtener datos");
        } catch (ClassNotFoundException e) {
            System.err.println("No se ha podido establecer la conexion");
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("No se ha podido cerrar la conexion");
            }
        }
        return false;
    }

}