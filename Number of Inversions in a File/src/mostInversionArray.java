public class mostInversionArray {
    int n;
    int[] array;
    mostInversionArray(int number) {
        array = new int[number];
        n = number;
    }

    public int[] toArray() {
        for (int i = 0; i < array.length; i++) {
            array[i] = n;
            n--;
        }
        return array;
    }
}
