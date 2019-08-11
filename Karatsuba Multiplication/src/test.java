import java.math.BigInteger;

public class test {
    public static void main (String[] args) {
        String i = "3141592653589793238462643383279502884197169399375105820974944592";
        String j = "2718281828459045235360287471352662497757247093699959574966967627";
        Calc calc = new Calc(i, j);
        System.out.println(" " + i);
        System.out.println("x" + j);
        System.out.println(calc.karatsu);
    }
}
