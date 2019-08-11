import java.util.Scanner;
import java.io.File;

public class Driver {
    public static void main (String[] args) throws Exception {
        File file = new File("IntegerArray.txt");
        Scanner scanner = new Scanner(file);
        int n = 100000;
        int[] array = new int[n];
        int i = 0;
        while (scanner.hasNextLine()) {
            array[i++] = Integer.parseInt(scanner.nextLine());
        }
//        //This is used to check the upper bound of inversions of numbers of 1~n;
//        mostInversionArray a = new mostInversionArray(n);
//        int[] array = a.toArray();

        Count c = new Count(n, array);
        long inversions = c.inversions(0, n - 1);
        System.out.println(inversions);
    }
}
