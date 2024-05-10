package org.exaple.felipe.main;

import org.exaple.felipe.model.Employee;
import org.exaple.felipe.repository.EmployeeRepository;
import org.exaple.felipe.repository.Repository;
import org.exaple.felipe.util.DatabaseConnection;


import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println("--------LISTANDO TODOS------------");
        Repository<Employee> repository = new EmployeeRepository();

        repository.findAll().forEach(System.out::println);

        System.out.println("--------Buscando por ID--------------");
        System.out.println(repository.getById(2));

        /*Employee employee = new Employee();
        employee.setFirst_name("America");
        employee.setPa_surname("Lopez");
        employee.setMa_surname("Villa");
        employee.setEmail("ame@example.com");
        employee.setSalary(3000F);
        employee.setCurp("AMEC234Y91JOLPSDET");

        Employee employee2 = new Employee();
        employee2.setFirst_name("juan ca");
        employee2.setPa_surname("galindo");
        employee2.setMa_surname("li");
        employee2.setEmail("jgl@example.com");
        employee2.setSalary(4000F);
        employee2.setCurp("AMEC234Y91JOLPSDET");

        try (Connection myConn = DatabaseConnection.getInstance()){
            //autocommit en falso
            if(myConn.getAutoCommit()){
                myConn.setAutoCommit(false);
            }

            try{
                //we create an instance of employeeRepository
                Repository<Employee> repository = new EmployeeRepository(myConn);
                //find all employees and then show them on the console
                repository.findAll().forEach(System.out::println);
                //we do two operations for modify data of the table
                System.out.println("---------Insertar  un nuevo cliente");
                repository.save(employee);
                //find all employees and we see the change
                repository.findAll().forEach(System.out::println);
                //insert other employee
                System.out.println("---------Insertar  un nuevo cliente");
                repository.save(employee2);
                //find all emloyees and we see the change
                repository.findAll().forEach(System.out::println);
                myConn.commit();
            } catch (SQLException e){
                myConn.rollback();
                throw new RuntimeException(e);
            }

        }*/


        /*SwingApp app = new SwingApp();
        app.setVisible(true);*/

        /*try (Connection myConn = DatabaseConnection.getInstance()){
            Repository<Employee> repository = new EmployeeRepository();
            System.out.println("-----------LISTANDO EMPLEADOS--------");
            repository.findAll().forEach(System.out::println);
            System.out.println("--------------------GET BY ID------------------");
            System.out.println(repository.getById(3));
            *//*System.out.println("--------------------INSERTANO EMPLEADO------------------");
            Employee employee = new Employee();
            employee.setFirst_name("Juan");
            employee.setPa_surname("Franco");
            employee.setMa_surname("Rosas");
            employee.setEmail("juan@gmail.com");
            employee.setSalary((float) 5000);
            repository.save(employee);
            System.out.println("-----------LISTANDO EMPLEADOS ACTUALES--------");
            repository.findAll().forEach(System.out::println);*//*
            *//*System.out.println("--------------------ACTUALIZANDO EMPLEADO------------------");
            Employee employee = new Employee();
            employee.setId(6);
            employee.setFirst_name("Juan Felipe");
            employee.setPa_surname("Franco");
            employee.setMa_surname("Rosas");
            employee.setEmail("juan@gmail.com");
            employee.setSalary((float) 5000);
            repository.save(employee);*//*
            System.out.println("----------- ELIMINANDO EMPLEADO --------");
            repository.delete(7);
            System.out.println("-----------LISTANDO EMPLEADOS ACTUALES--------");
            repository.findAll().forEach(System.out::println);

        }*/


 }
}
