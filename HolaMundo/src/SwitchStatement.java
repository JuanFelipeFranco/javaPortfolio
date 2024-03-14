public class SwitchStatement {
    public static void main(String[] args) {
        String colorModeSelected = "Dark";

        switch (colorModeSelected){
            case "Light":
                System.out.println("seleccionaste Light Mode");
                break;
            case "Night": //Ambar
                System.out.println("Seleccionaste Night Mode");
                break;
            case "Blue Dark": //Ambar
                System.out.println("Seleccionaste Blue Dark Mode");
                break;
            case "Dark": //Ambar
                System.out.println("Seleccionaste Dark Mode");
                break;
            default:
                System.out.println("selecciona una opcion correcta");
                break;
        }
    }
}
