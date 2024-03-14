import java.sql.SQLOutput;

public class  MathematicOperations {
    public static void main(String[] args) {
        double x = 2.1;
        double y = 3;

        System.out.println(Math.PI);
        System.out.println(Math.E);

        //Devuelve un entero hacia arriba
        System.out.println(Math.ceil(x));//redondear hacia arriba

        //Devuelve un entero hacia abajo
        System.out.println(Math.floor(x));

        //Devuelve un numero elevado a otro en este caso x elevado a la y
        System.out.println(Math.pow(x,y));

        //devuelve el dato mayor y menor
        System.out.println(Math.max(x,y));
        System.out.println(Math.min(x,y));

        //devuelve la raiz cuadrada
        System.out.println(Math.sqrt(y));

        //Area de un circulo
        //pi * r2
        System.out.println(Math.PI * Math.pow(y,2));

        //Area de una esfera
        // 4PI * R2
        System.out.println(4 * Math.PI * Math.pow(y,2));

        //volumen de una esfera
        //4/3 * PI *r3
        System.out.println((4/3) * Math.PI * Math.pow(y,3));

    }
}
