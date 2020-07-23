package algo;

public class Search {

    int binarySearch(int[] a, int val, int l, int r) {
        while (l < r) {
            int m = l + (r - l) / 2; //避免overflow
            if (a[m] == val) { // f(m)
                return m;
            }
            if (a[m] > val) { // g(m)
                r = m;
            } else {
                l = m + 1;
            }
        }
        return -1; // not found
    }
}
