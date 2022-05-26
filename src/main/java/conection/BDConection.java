package conection;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class BDConection {

    Connection conn = null;

    public static final String DATABASE_NAME = "bdjescriba";
    public static final String DATABASE_USER = "root";
    public static final String DATABASE_PASSWORD = "";
    public static final String DATABASE_URL = "jdbc:mysql://localhost:3306/" + DATABASE_NAME;

    public Connection getConnection() {
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
            System.out.println("Conexion exitosa");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos : " + e.getMessage());
        }
        return conn;
    }

    public void closeConnection() {
        try {
            conn.close();
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error al cerrar la conexion : " + e.getMessage());
        }
    }

}
