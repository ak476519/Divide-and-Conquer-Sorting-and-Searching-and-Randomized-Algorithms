public class Count {
    int[] a;
    int sum;

    Count (int[] array) {
        a = array;
        sum = 0;
    }

    public void swap(int one, int other) {
        int tmp = a[one];
        a[one] = a[other];
        a[other] = tmp;
    }

    public int partition(int s, int e, int pivot) { //return which index pivot is at in the end;
        //swap pivot with first element;
        if (pivot != 0) swap(s, pivot);

        //start partition;
        int i = s + 1; //index of first element of the larger part;
        int j = s + 1; //index of first unchecked element;
        while (j <= e) {
            if (a[j] < a[s]) {
                swap(i, j);
                i++;
            }
            j++;
        }
        swap(i - 1, s);
        return i - 1;
    }

    public int firstAsPivot() {
        countFirst(0, a.length - 1);
        return sum;
    }

    public void countFirst(int s, int e) {
        int length = e - s + 1;
        if (length <= 1) return;
        sum += length - 1;
        int split = partition(s, e, 0);
        countFirst(s, split - 1);
        countFirst(split + 1, e);
        return;
    }

    public int lastAsPivot() {
        countLast(0, a.length - 1);
        return sum;
    }

    public void countLast(int s, int e) {
        int length = e - s + 1;
        if (length <= 1) return;
        sum += length - 1;
        int split = partition(s, e, e);
        countLast(s, split - 1);
        countLast(split + 1, e);
        return;
    }

    public int medianAsPivot() {
        countMedian(0, a.length - 1);
        return sum;
    }

    public void countMedian(int s, int e) {
        int length = e - s + 1;
        if (length <= 1) return;
        sum += length - 1;

        int pivot = 0;
        int m = (length % 2 == 0)? s + length/2 - 1 : s + length/2;
        if (a[s] > a[m]) {
            if (a[m] > a[e]) pivot = m;
            else pivot = (a[s] > a[e])? e : s;
        } else {
            if (a[m] < a[e]) pivot = m;
            else pivot = (a[s] < a[e])? e : s;
        }

        int split = partition(s, e, pivot);
        countMedian(s, split - 1);
        countMedian(split + 1, e);
        return;
    }
}
