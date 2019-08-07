package sort;

public class CountingSort implements Sort {

    @Override
    public int[] sort(int[] array) {

        int[] tab = array.clone();
        int limit = maxValue(tab);

        int[] counts = new int[limit+1];
        int[] sorted = new int[tab.length];
        for (int i = 0; i <= limit; i++) counts[i] = 0;
        for(int number : tab) {
            counts[number]++;
        }
        for (int i = 1; i <= limit; i++) counts[i] += counts[i - 1];
        for (int i = tab.length - 1; i >= 0; i--) {
            sorted[--counts[tab[i]]] = tab[i];
        }
        return sorted;
    }

    private int maxValue(int[] array) {
        if (array == null || array.length == 0) return 0;

        int max = Integer.MIN_VALUE;
        for (int current : array) {
            max = current > max ? current : max;
        }
        return max;
    }
}
