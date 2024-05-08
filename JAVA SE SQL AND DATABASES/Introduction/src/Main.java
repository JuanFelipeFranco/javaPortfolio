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

            int rowsAffected = myStamt.executeUpdate("UPDATE employees " + "SET email = 'juanfelipefrancor@example.com' " + "WHERE first_name='Juan'");

            myRes= myStamt.executeQuery("SELECT * FROM employees ORDER BY pa_surname");

            while (myRes.next()){
                System.out.println(myRes.getString("first_name") + "," + myRes.getString("email"));
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("algo salio mal");
        }
    }
}