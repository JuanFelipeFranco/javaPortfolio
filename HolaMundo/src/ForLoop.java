public class ForLoop {
    static boolean isTurnOnLight = false;

    public static void main(String[] args) {
        //el usuario prende la luz con la funcion invocada a continuacion.
        turnOnOffLight();
        //usamos el for i, donde inicia en 0 y va hasta 10 veces la repeticion de printSOS
        for (int i = 0; i <= 10; i++) {
            printSOS();
        }
    }
    public static void printSOS(){
            System.out.println("SOS -> ...___...");
    }
    public static boolean turnOnOffLight(){
            isTurnOnLight = (isTurnOnLight)?false:true;
            return isTurnOnLight;
    }
}
