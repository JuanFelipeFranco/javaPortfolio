public class WhileLoop {
    //variable que dice si esta prendida la lampara, en este caso la tenemos apagada
    static boolean isTurnOnLight = false;
    public static void main(String[] args) {
        //estamos atrapados en un lugar oscuro y nadie habla el mismo idioma mio, y tenemos una lampara para programar el SOS
        //llamamos la funcion (enciende o apaga la lampara el usuario), ahora va a prenderse.
        turnOnOffLight();

        int i=1;
        while(isTurnOnLight && i<=10){
            printSOS();
            i++;
        }




    }
    //funcion que va generar que muestre siempre el mensaje de SOS
    public static void printSOS(){
        System.out.println("SOS -> ...___...");
    }
    //funcion que
    public static boolean turnOnOffLight(){
        //OPERADOR TERNARIO : La variable hace una operacion () devuelve el valor1 pero si este no cumple devuelve el valor 2
        //variableConsiderada = ()?valor1:valor2;

        //si la lampara esta encendida entonces devuelve falso; en el otro caso es verdadero.
        isTurnOnLight = (isTurnOnLight)?false:true;

       /* if (isTurnOnLight){
            //si esta prendida entonces la tendremos que colocar apagada
            isTurnOnLight = false;
        }else {
            //si esta apagda la vamos a encender
            isTurnOnLight = true;
        }
        //devuelve el estado de la lampara*/
        return isTurnOnLight;
    }
}
