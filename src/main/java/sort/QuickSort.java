package sort;

public class QuickSort implements Sort {

    @Override
    public int[] sort(int[] array) {
        int[] toSort = array.clone();
        quicksort(toSort, 0, toSort.length - 1);
        return toSort;
    }


    private void quicksort(int[] tab, int left, int right) {
        int compare, j, i, tmp;
        i = (left + right) / 2;
        compare = tab[i];
        tab[i] = tab[right];
        i = left;
        j = left;
        for (; i < right; i++) {
            if (i != j && tab[i] < compare) {
                tmp = tab[j];
                tab[j] = tab[i];
                tab[i] = tmp;
                j++;
            }
            if (i == j && tab[i] < compare) j++;
        }
        tab[right] = tab[j];
        tab[j] = compare;
        if (left < j - 1) quicksort(tab, left, j - 1);
        if (right > j + 1) quicksort(tab, j + 1, right);
    }
}
