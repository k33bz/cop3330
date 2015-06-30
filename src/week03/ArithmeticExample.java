package week03;

/**
 * 
 * @author scottl
 * 
 */
public class ArithmeticExample
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        // Addition
        int x = 5;
        int y = 3;
        int sum = 0;

        sum = x + y; // equals 8

        // Subtraction
        int diff = 0;
        diff = x - y; // equals 2

        // Division
        int div = 0;
        div = x / y; // equals 1

        double dbDiv = 0.0;
        dbDiv = (double)x / y; // equals 1.6666666666666667

        // Multiplication
        int product = 0;
        product = x * y; // equals 15

        // Modulo
        int mod = 0;
        mod = x % y; // equals 2

        System.out.print("Sum: ");
        System.out.println(sum);

        System.out.print("Diff: ");
        System.out.println(diff);

        System.out.print("Div: ");
        System.out.println(div);

        System.out.print("Double Div: ");
        System.out.println(dbDiv);

        System.out.print("Product: ");
        System.out.println(product);

        System.out.print("Modulo: ");
        System.out.println(mod);
    }

}
