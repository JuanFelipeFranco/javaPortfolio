package org.exaple.felipe.main;

import org.exaple.felipe.model.Employee;
import org.exaple.felipe.repository.EmployeeRepository;
import org.exaple.felipe.repository.Repository;
import org.exaple.felipe.util.DatabaseConnection;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        try (Connection myConn = DatabaseConnection.getInstance()){
            Repository<Employee> repository = new EmployeeRepository();
            System.out.println("-----------LISTANDO EMPLEADOS--------");
            repository.findAll().forEach(System.out::println);
            System.out.println("--------------------GET BY ID------------------");
            System.out.println(repository.getById(3));
            /*System.out.println("--------------------INSERTANO EMPLEADO------------------");
            Employee employee = new Employee();
            employee.setFirst_name("Juan");
            employee.setPa_surname("Franco");
            employee.setMa_surname("Rosas");
            employee.setEmail("juan@gmail.com");
            employee.setSalary((float) 5000);
            repository.save(employee);
            System.out.println("-----------LISTANDO EMPLEADOS ACTUALES--------");
            repository.findAll().forEach(System.out::println);*/
            System.out.println("--------------------ACTUALIZANDO EMPLEADO------------------");
            Employee employee = new Employee();
            employee.setId(6);
            employee.setFirst_name("Juan Felipe");
            employee.setPa_surname("Franco");
            employee.setMa_surname("Rosas");
            employee.setEmail("juan@gmail.com");
            employee.setSalary((float) 5000);
            repository.save(employee);
            System.out.println("-----------LISTANDO EMPLEADOS ACTUALES--------");
            repository.findAll().forEach(System.out::println);

        }


 }
}
