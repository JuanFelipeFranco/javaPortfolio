import javax.swing.*;

/*Creamos un programa que solicita al usuario su genero, su estatura en cm por ventana y por ultimo
el programa genera el peso idea dependiendo su genero y estatura
* */
public class DoWhile3Loop {
    public static void main(String[] args) {
        String genero = "";
//en este caso el genero esta para que sea M O F si es diferente a esto va volver a generarse la ventana y solo se va quitar si se digita M O F
        do{
            genero = JOptionPane.showInputDialog("Introduce tu genero (M/F)");

        }while(genero.equalsIgnoreCase("M")==false && genero.equalsIgnoreCase("F")==false);
    //equalsignorecase es usado para evaluar que sea igual dos palabras ignorando si es mayuscula o minuscula.
        int altura = Integer.parseInt(JOptionPane.showInputDialog("Introduce altura en cm"));
    //showInputDialog trata el dato que ingresamos en ventana como texto por ende usamos metodo Integer.ParseInt para transformarlo a numero entero.
        int pesoideal = 0;

        if (genero.equalsIgnoreCase("M")){
            pesoideal=altura-110;
        } else if (genero.equalsIgnoreCase("F")) {
            pesoideal=altura-120;
        }
        System.out.println("tu peso ideal es: "+pesoideal+ " KG");
    }


}
