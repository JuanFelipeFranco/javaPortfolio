public class Arrays {
    public static void main(String[] args) {
        String [] androidVersions = new String[17];
        int [] days = new int[7]; //siempre los dias de la semana son 7 dias
        String [][] cities = new String[4][2];//4*2 es el tamano maximo que le caben = 8

        int [][][] numbers = new int[2][2][2];
        int [][][][] numbers4 = new int[2][2][2][2];

        //Declarando 4 elementos o espacios de los 17 disponibles
        androidVersions[0] = "apple pie";
        androidVersions[1] = "Banana Bread";
        androidVersions[2] = "Cupcake";
        androidVersions[3] = "Donut";
        //accediendo al dato y mostrando en pantalla
        /*System.out.println(androidVersions[0]);
        System.out.println(androidVersions[1]);
        System.out.println(androidVersions[2]);
        System.out.println(androidVersions[3]);*/
        //accediendo y mostrando con ciclo for
        for (int i = 0; i < 3; i++) {
            System.out.println(androidVersions[i]);
        }

        System.out.println();
        System.out.println();

        for (int i = 0; i < androidVersions.length; i++) {
            System.out.println(androidVersions[i]);
        }

        System.out.println();
        System.out.println();

        for (int i = 0; i < days.length; i++) {
            System.out.println(days[i]);
        }

        System.out.println();
        System.out.println();
        /*
         * +-------------------------+
         * | Country   |  City       |
         * ---------------------------
         * | México    | CDMX        |
         * | Méxicp    | Guadalajara |
         * | Colombia  | Bogotá      |
         * | Colombia  | Medellín    |
         * +-------------------------+
         * */

        cities [0][0] = "Colombia";
        cities [0][1] = "Medellin";
        cities [1][0] = "Colombia";
        cities [1][1] = "Bogota";
        cities [2][0] = "Mexico";
        cities [2][1] = "Guadalajara";
        cities [3][0] = "Mexico";
        cities [3][1] = "CDMX";

        /*System.out.println(cities [0][0]);
        System.out.println(cities [0][1]);
        System.out.println(cities [1][0]);
        System.out.println(cities [1][1]);
        System.out.println(cities [2][0]);
        System.out.println(cities [2][1]);
        System.out.println(cities [  3][0]);
        System.out.println(cities [3][1]);*/

        //ciclo for anidado
        for (int  i = 0;  i < cities.length;  i++) {
            for (int j = 0; j < cities[i].length; j++) {
                System.out.println(cities[i][j]);
            }

        }

        //CICLOS GRANDES DE 4 DIMENSIONES
        String [][][][] animals = new String [2][3][2][2];
        animals [1][0][0][1] = "Monkey";

        System.out.println();
        System.out.println();
        System.out.println(animals[1][0][0][1]);

        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j <= 0 ; j++) {
                for (int k = 0; k <= 0; k++) {
                    for (int l = 0; l <= 1; l++) {
                        System.out.println(animals[i][j][k][l]);
                    }
                }
            }

        }
    }
}
