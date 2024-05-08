import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection myConn = null;
        Statement myStamt = null;
        ResultSet myRes =null;

        try{
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","admin");
            System.out.println("Conexion exitosa");

            myStamt = myConn.createStatement();
            
            myRes = myStamt.executeQuery("SELECT * FROM EMPLOYEES");

            while (myRes.next()){
                System.out.println(myRes.getString("first_name"));
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("algo salio mal");
        }
    }
}