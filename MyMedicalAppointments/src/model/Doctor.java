package model;

import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User {
    String speciality;

    public Doctor(String name, String email) {
        super(name, email);
        System.out.println("El nombre del model.Doctor es: " +name);
        this.speciality = speciality;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
    //Comportamientos
    ArrayList<AvailableAppointment> availableAppointments = new ArrayList<>();
    public void addAvailableAppointment(Date date, String time){
        availableAppointments.add(new Doctor.AvailableAppointment(date,time));
    }
    public ArrayList<AvailableAppointment> getAvailableAppointments(){
        return availableAppointments;
    }
    //se reutiliza comortamiento de la clase user y vamos a;adir un comportamiento,
    // el de especialidad que es propio de la clase model.Doctor; estamos aprovechando la clase AvailableAppointments
    // en este caso AvailableAppointmens tiene su comportamiento to string y lo estamos a;adiendo por el .tostring.
    @Override
    public String toString() {
        return super.toString()+"\n Speciality: "+speciality+"\n Available "+ availableAppointments.toString();
    }

    @Override
    public void showDataUser() {
        System.out.println("Empleado del Hospital: Cruz Roja");
        System.out.println("Departamento:Cancerologia");
    }

    public static class AvailableAppointment{
        private int id;
        private Date date;
        private String time;

        public AvailableAppointment(Date date, String time) {
            this.date = date;
            this.time = time;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }


        @Override
        public String toString() {
            return "Available Appointments \nDate: "+date+ " \nTime: "+time;
        }
    }


}
