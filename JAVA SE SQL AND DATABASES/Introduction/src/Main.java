import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection myConn = null;
        PreparedStatement myStamt = null;


        try{
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","admin");
            System.out.println("Conexion exitosa");

            String sql=("INSERT INTO employees (first_name, pa_surname) VALUES (?,?)");
            myStamt = myConn.prepareStatement(sql);
            myStamt.setString(1,"Juan");
            myStamt.setString(2,"Franco");

            int rowsAffected = myStamt.executeUpdate();
            //myRes = myStamt.executeQuery("SELECT * FROM EMPLOYEES");

            if (rowsAffected > 0){
                System.out.println("Se ha creado nuevo empleado");
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("algo salio mal");
        }
    }
}