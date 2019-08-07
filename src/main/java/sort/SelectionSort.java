package sort;

public class SelectionSort implements Sort {
    @Override
    public int[] sort(int[] array) {
        int[] toSort = array.clone();
        for (int i = 0; i < toSort.length; i++) {
            int min = toSort[i], minIndeks = i;
            for (int j = i + 1; j < toSort.length; j++) {
                if (toSort[j] < min) {
                    min = toSort[j];
                    minIndeks = j;
                }
            }
            toSort[minIndeks] = toSort[i];
            toSort[i] = min;
        }
        return toSort;
    }
}
