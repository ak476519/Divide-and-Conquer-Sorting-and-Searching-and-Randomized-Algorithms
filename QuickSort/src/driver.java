import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class driver {
    public static void main (String[] args) throws FileNotFoundException {
        File file = new File("QuickSort.txt");
        Scanner sc = new Scanner(file);
        int number = 10000;
        int[] array = new int[number];
        int i = 0;
        while (sc.hasNextLine()) array[i++] = Integer.parseInt(sc.nextLine());

        Count first = new Count(Arrays.copyOf(array, array.length));
        System.out.println("First element as pivot: " + first.firstAsPivot());
        Count last = new Count(Arrays.copyOf(array, array.length));
        System.out.println("Last element as pivot: " + last.lastAsPivot());
        Count median = new Count(Arrays.copyOf(array, array.length));
        System.out.println("Median element as pivot: " + median.medianAsPivot());
    }
}
