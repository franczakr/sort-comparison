package sort;

public class BubbleSort implements Sort {

    @Override
    public int[] sort(int[] array) {
        int[] result = array.clone();
        boolean sorted;

        for (int i = 0; i < result.length; i++) {
            sorted = true;
            for (int j = 1; j < result.length - i; j++) {
                if (result[j] < result[j - 1]) {
                    int temp = result[j];
                    result[j] = result[j - 1];
                    result[j - 1] = temp;
                    sorted = false;
                }
            }
            if (sorted) break;
        }
        return result;
    }

}
