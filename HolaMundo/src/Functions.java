public class Functions {
    public static void main(String[] args) {
        double y = 3;

        //Area de un circulo
        //pi * r2
        double area = circleArea(y);
        System.out.println("el area del circulo es "+area);

        //Area de una esfera
        // 4PI * R2
        double areaEsfera = sphereArea(y);
        System.out.println("El area de la esfera es: "+areaEsfera);

        //volumen de una esfera
        //4/3 * PI *r3
        double volumenEsfera = sphereVolumen(y);
        System.out.println("El volumen de la esfera es "+volumenEsfera);

        //monedero cambio a dolares
        System.out.println("PESOS A DOLARES: "+converToDolar(10000,"COP"));

    }

    /**
     * Descripcion: Funcion que especifica el area de un circulo
     * @param r es el radio de un circulo
     * @return devuelve el valor del area de un circulo
     * */
    public static double circleArea(double r){
        return Math.PI * Math.pow(r,2);
    }

    /**
     * Descripcion: Funcion que especifica el area de una esfera
     * @param r radio de la esfera
     * @return devuelve el area de una esfera.
     * */
    public static double sphereArea(double r){
        return 4 * Math.PI * Math.pow(r,2);
    }

    /**
     * Descripcion: Funcion que especifica el volumen de una esfera
     * @param r radio de la esfera
     * @return el valor del volumen de una esfera
     * */
    public static double sphereVolumen(double r){
        return (4/3) * Math.PI * Math.pow(r,3);
    }

    /**
     * Descripcion: Funcion que especificando su moneda convierte una cantidad de dinero a Dolares
     * @param quantity Cantidad de dinero
     * @param currency Tipo de moneda: solo acepta pesos MXN o COP
     * @return quantity Devuelve la cantidad actualizada en dolares.
     * */
    public static double converToDolar(double quantity, String currency){
        //MXN O COP
        switch (currency){
            case "MXN":
                quantity = quantity * 0.052;
                break;
            case "COP":
                quantity = quantity * 0.00031;
                break;
            default:
        }
        return quantity;
    }
}
