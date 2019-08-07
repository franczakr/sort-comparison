package sort;

public class HeapSort implements Sort {
    @Override
    public int[] sort(int[] array) {
        int[] toSort = array.clone();
        int[] heap = new int[toSort.length + 1];
        heap[0] = 0;
        for (int i = 1; i <= toSort.length; i++) {
            heap[0]++;
            heap[i] = toSort[i - 1];
            heapify(heap, i);
        }
        while (heap[0] > 1) {
            int temp = heap[heap[0]];
            heap[heap[0]] = heap[1];
            heap[1] = temp;
            heap[0]--;
            heapify(heap, 1);
        }
        for (int i = 0; i < toSort.length; i++) {
            toSort[i] = heap[i + 1];
        }
        return toSort;
    }


    private void heapify(int[] tab, int i) //naprawa kopca po zmianie elementu o indeksie i
    {
        //naprawa "w gore"
        while (i != 1 && tab[i] > tab[i / 2]) {
            int temp = tab[i];
            tab[i] = tab[i / 2];
            tab[i / 2] = temp;
            i = i / 2;
        }
        //naprawa "w dol"
        while ((2 * i <= tab[0] && tab[i] < tab[2 * i]) || (2 * i + 1 <= tab[0] && tab[i] < tab[2 * i + 1])) {
            if (2 * i + 1 <= tab[0] && tab[2 * i + 1] > tab[2 * i]) {
                int temp = tab[i];
                tab[i] = tab[i * 2 + 1];
                tab[i * 2 + 1] = temp;
                i = i * 2 + 1;
            } else {
                int temp = tab[i];
                tab[i] = tab[i * 2];
                tab[i * 2] = temp;
                i = i * 2;
            }
        }

    }
}
