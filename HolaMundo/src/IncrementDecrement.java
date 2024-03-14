public class IncrementDecrement {
    public static void main(String[] args) {
        int lives = 5;
        lives = lives -1;
        System.out.println(lives); //4

        lives--;//Decremento
        System.out.println(lives); //3

        lives++;//Incremento
        System.out.println(lives); //4

        //PREFIJA
        //gana un regalo por ganar una vida
        int gift = 100 + lives++; //posfijo
        //en este caso lo que hace en posfijo es tomar la variable como esta (4) obtiene el dato primero
        System.out.println(gift);
        System.out.println(lives);

        //en este caso en prefijo ya obtiene el dato incrementado.
        int gif = 100 + ++lives;//prefijo
        System.out.println(gif);
        System.out.println(lives);

    }
}
