package sort;

public class InsertionSort implements Sort {
    @Override
    public int[] sort(int[] array) {
        int[] toSort = array.clone();
        for (int i = 1; i < toSort.length; i++) {
            int temp = toSort[i];
            int k = i - 1;
            while (k >= 0 && toSort[k] > temp) {
                toSort[k + 1] = toSort[k];
                k--;
            }
            toSort[k + 1] = temp;
        }
        return toSort;
    }
}
