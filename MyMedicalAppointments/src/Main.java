import model.*;

import java.util.Date;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //showMenu();
        Doctor myDoctor = new Doctor("Anahi Salgado", "ana@gmail.com");
        myDoctor.addAvailableAppointment(new Date(), "4pm");
        myDoctor.addAvailableAppointment(new Date(), "10am");
        myDoctor.addAvailableAppointment(new Date(), "1pm");
        System.out.println(myDoctor);

        User user = new Doctor("Ana","ana@gmail.com"); //no se puede instanciar debido a que user es una clase abstract
        //puedo crea user de las clases hijas, en este caso la clase hija es Doctor
        user.showDataUser();

        User userPa = new Patient("Ana","ana@gmail.com");
        userPa.showDataUser();

        User user1 = new User("Juan Franco", "juanfelipe.0710@gmail.com") {
            @Override
            public void showDataUser() {
                System.out.println();
            }
        };
        user1.showDataUser();

        ISchedulable iSchedulable = new ISchedulable() {
            @Override
            public void schedulable(Date date, String time) {

            }
        };



//        for(model.Doctor.AvailableAppointment availableAppointment:myDoctor.getAvailableAppointments()){
//            System.out.println(availableAppointment.getDate()+" "+availableAppointment.getTime());
//        }

        Patient patient = new Patient("Juan", "juan@gmail.com");
        Patient patient2 = new Patient("Juana", "juana@gmail.com");
        patient = patient2;
        System.out.println(patient.getName());
        System.out.println(patient2.getName());

        System.out.println(patient);

    }
}