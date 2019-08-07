package sort;

public class MergeSort implements Sort {

    @Override
    public int[] sort(int[] array) {
        int[] toSort = array.clone();
        mergesort(toSort, 0, toSort.length);
        return toSort;
    }

    private void mergesort(int[] tab, int start, int end) {
        if (end - start <= 1) return;
        int mid = (end + start) / 2;
        mergesort(tab, start, mid);
        mergesort(tab, mid, end);
        int[] sorted = new int[end - start];
        int leftIndex = start, rightIndex = mid, i = 0;
        while (leftIndex < mid && rightIndex < end) {
            if (tab[leftIndex] < tab[rightIndex]) {
                sorted[i] = tab[leftIndex];
                leftIndex++;
            } else {
                sorted[i] = tab[rightIndex];
                rightIndex++;
            }
            i++;
        }
        while (leftIndex < mid) {
            sorted[i] = tab[leftIndex];
            leftIndex++;
            i++;
        }
        while (rightIndex < end) {
            sorted[i] = tab[rightIndex];
            rightIndex++;
            i++;
        }
        for (i = 0; i < sorted.length; i++)
            tab[i + start] = sorted[i];
    }

}
