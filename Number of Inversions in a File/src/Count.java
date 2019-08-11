public class Count {
    int n;
    int[] a;
    Count (int numbers, int[] array) {
        n = numbers;
        a = array;
    }

    public long inversions(int s, int e) { //Start index, End index, both inclusive;
        int length = e - s + 1;
        if (length == 1) return 0;
        long total = 0;
        if (length == 2) {
            if (a[s] > a[e]) {
                int tmp = a[s];
                a[s] = a[e];
                a[e] = tmp;
                total++;
            }
            return total;
        }
        int split = s + length/2 - 1; //last index of first segment;
        total += (inversions(s, split) + inversions(split + 1, e));
        int[] sort = new int[length];
        int st = 0;
        int i = s;
        int j = split + 1;
        while (i <= split && j <= e){
            if (a[i] < a[j]) {
                sort[st++] = a[i++];
            } else {
                sort[st++] = a[j++];
                total += (split - i + 1);
            }
        }
        while (i <= split)  sort[st++] = a[i++];
        while (j <= e)  sort[st++] = a[j++];
        for (int m = s; m <= e; m++) a[m] = sort[m - s];
        return total;
    }

}
