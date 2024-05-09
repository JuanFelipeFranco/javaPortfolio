package org.exaple.felipe.view;

import org.exaple.felipe.model.Employee;
import org.exaple.felipe.repository.EmployeeRepository;
import org.exaple.felipe.repository.Repository;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class SwingApp extends JFrame {
    private final Repository<Employee> employeeRepository;
    private final JTable employeeTable;

    public SwingApp(){
        //configurar la ventana
        setTitle("Gestion de Empleados");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,230);

        //Crear una tabla para mostrar los empleados
        employeeTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(employeeTable);
        add(scrollPane, BorderLayout.CENTER);

        //Crear botones para acciones
        JButton agregarButton = new JButton("Agregar");
        JButton actualizarButton = new JButton("Actualizar");
        JButton eliminarButton = new JButton("Eliminar");

        //Configurar el panel de botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(agregarButton);
        buttonPanel.add(actualizarButton);
        buttonPanel.add(eliminarButton);
        add(buttonPanel, BorderLayout.SOUTH);

        //Establecer estilos para los botones
        agregarButton.setBackground(new Color(46,204,113));
        agregarButton.setForeground(Color.WHITE);
        agregarButton.setFocusPainted(false);

        actualizarButton.setBackground(new Color(52,152,219));
        actualizarButton.setForeground(Color.WHITE);
        actualizarButton.setFocusPainted(false);

        eliminarButton.setBackground(new Color(231,76,60));
        eliminarButton.setForeground(Color.WHITE);
        eliminarButton.setFocusPainted(false);

        //Crear el objeto Repository para acceder a la base de datos
        employeeRepository = new EmployeeRepository();

        //cargar los empleados iniciales en la tabla
        refreshEmployeeTable();

        //Agregar actionListener para los botones
        agregarButton.addActionListener(e -> {
            try{
                agregarEmpleado();
            } catch (SQLException ex){
                throw new RuntimeException(ex);
            }
        });

        actualizarButton.addActionListener(e -> actualizarEmpleado());

        eliminarButton.addActionListener(e -> eliminarEmpleado());




    }


}
