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
            repository.findAll().forEach(System.out::println);
            System.out.println("--------------------GET BY ID------------------");
            System.out.println(repository.getById(3));
        }


 }
}
