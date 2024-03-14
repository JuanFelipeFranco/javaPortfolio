package model;

import java.util.Date;

public interface ISchedulable {
    //al principio recibe un metodo en este caso el return es void que es vacio en un principio y va recibir una fecha y una hora.
    void schedulable(Date date, String time);
}
