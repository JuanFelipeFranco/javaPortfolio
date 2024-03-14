public class DataTypes {
    public static void main(String[] args) {
        int n = 1234567890;
        long nL = 12345678901L ;

        double nD = 123.456789123456;
        float nF = 123.456F;

        var salary = 1000; //int
        //pension es el 3% del salario y lo descuentan
        var pension = salary * 0.03; //double
        var totalSalary = salary - pension;
        System.out.println(salary);
        System.out.println(pension);
        System.out.println(totalSalary);

        var employeeName = "Juan Franco";
        System.out.println(employeeName);

    }
}
