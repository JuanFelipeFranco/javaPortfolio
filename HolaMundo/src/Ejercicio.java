public class Ejercicio {
    public static void main(String[] args) {
        System.out.println("My Family es:");
        String novia = "Lina Andrea Barrero Varela";
        String perro = "Coffee";
        String yo = "Juan Felipe Franco";

        //edades
        int edadLina = 30;
        int edadCoffee = 3;
        int edadFelipe = 27;

        System.out.println("Soy "+ novia + " y tengo "+edadLina+" anos");
        System.out.println("Soy "+ perro + " soy el perro de la casa y tengo "+edadCoffee+" anos");
        System.out.println("Soy "+ yo + " y tengo "+edadFelipe+" anos");

        char c = 'z';//conviertelo a int
        int zi = c;
        System.out.println(zi);

        int i = 250; //conviertelo a long y luego de long a short
        long iL = i;
        short iS = (short) iL;
        System.out.println(iL);
        System.out.println(iS);

        double d = 301.067; //conviertelo a long
        long dL = (long) d;
        System.out.println(dL);

        int i2 = 100; //súmale 5000.66 y conviertelo a float
        float i2D = i2 + 5000.66F;
        System.out.println(i2D);

        int i3 = 737; //multiplícalo por 100 y conviertelo a byte
        int i4 = i3 * 100;
        byte iB = (byte) i4;
        System.out.println(i4);
        System.out.println(iB);

        double d2 = 298.638; //divídelo entre 25 y conviertelo a long
        double d3 = d2/25;
        long d4 = (long) d3;
        System.out.println(d3);
        System.out.println(d4);

        /*Ejercicio 3

        Se debe tener descargados los JDKs en los cuales se compilará.

                Se tiene que configurar los JAVA_HOME en función de la versión que se utilizará.

                En el sistema operativo puede ser mac o windows, el procedimiento es el mismo.
*/
    }
}
