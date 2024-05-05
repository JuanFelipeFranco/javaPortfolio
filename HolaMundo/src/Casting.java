public class Casting {
    public static void main(String[] args) {
        //En un ano ubica 30 perros; cuantos perros ubica al mes.
        double monthlyDogs = 30.0/12.0;
        System.out.println(monthlyDogs);

        //Estimacion
        int estimatedMonthlyDogs = (int) monthlyDogs;
        System.out.println(estimatedMonthlyDogs);

        //Exactitud
        int a = 30;
        int b = 12;

        System.out.println((double)a/b);

        double c = (double) a/b;
        System.out.println(c);



    }
}
