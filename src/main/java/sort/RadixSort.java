package sort;

public class RadixSort implements Sort {

    @Override
    public int[] sort(int[] array) {

        int[] tab = array.clone();
        int limit = maxValue(tab);

        for (int i = 0; i <= Math.log10(limit); i++) {
            countingsortForRadix(tab, i);
        }

        return tab;
    }


    private void countingsortForRadix(int[] tab, int d) {
        int[] counts = new int[10];
        int[] sorted = new int[tab.length];
        for (int i = 0; i < 10; i++) counts[i] = 0;
        for (int i = 0; i < tab.length; i++) {
            counts[(tab[i] / (int) Math.pow(10, d)) % 10]++;
        }
        for (int i = 1; i < 10; i++) counts[i] += counts[i - 1];
        for (int i = tab.length - 1; i >= 0; i--) {
            sorted[--counts[(tab[i] / (int) Math.pow(10, d)) % 10]] = tab[i];
        }
        for (int i = 0; i < tab.length; i++) {
            tab[i] = sorted[i];
        }
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
