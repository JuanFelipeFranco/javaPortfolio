import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection myConn = null;
        Statement myStamt = null;
        ResultSet myRes = null;

        try{
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","admin");
            System.out.println("Conexion exitosa");

            myStamt = myConn.createStatement();

            int rowsAffected = myStamt.executeUpdate("DELETE FROM employees " + "WHERE first_name='Juan'");
            System.out.println("Empleados actuales: ");
            myRes= myStamt.executeQuery("SELECT * FROM employees");

            System.out.println("Empleados despues de eliminar");
            while (myRes.next()){
                System.out.println(myRes.getString("first_name"));
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("algo salio mal");
        }
    }
}