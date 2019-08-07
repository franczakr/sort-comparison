package sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SortTest {
    private int[] toSort, expected;

    private void testSort(int[] toSort, int[] expected, SortTypes.SortType type) {
        int[] copy = toSort.clone();
        SortTypes types = new SortTypes();
        assertArrayEquals(expected, types.getSortAlgorithm(type).sort(toSort));
        assertArrayEquals(copy, toSort);
    }

    private void testSmall(SortTypes.SortType type) {
        toSort = new int[]{5, 1, 4, 2, 3};
        expected = new int[]{1, 2, 3, 4, 5};
        testSort(toSort, expected, type);
    }

    private void testBig(SortTypes.SortType type) {
        toSort = new int[]{615, 106, 817, 757, 13, 717, 567, 302, 383, 873, 867, 119, 797, 164, 342, 239, 644, 786, 552,
                884, 798, 213, 833, 245, 814, 681, 964, 39, 829, 619, 898, 309, 131, 997, 513, 605, 203, 500, 526, 909,
                248, 789, 739, 867, 100, 130, 883, 651, 773, 476};
        expected = new int[]{13, 39, 100, 106, 119, 130, 131, 164, 203, 213, 239, 245, 248, 302, 309, 342, 383, 476, 500,
                513, 526, 552, 567, 605, 615, 619, 644, 651, 681, 717, 739, 757, 773, 786, 789, 797, 798, 814, 817, 829,
                833, 867, 867, 873, 883, 884, 898, 909, 964, 997};
        testSort(toSort, expected, type);
    }

    private void testSortType(SortTypes.SortType type) {
        testSmall(type);
        testBig(type);
    }

    @Test
    void bubbleSortTest() {
        testSortType(SortTypes.SortType.BubbleSort);
    }

    @Test
    void insertionSortTest() {
        testSortType(SortTypes.SortType.InsertionSort);
    }

    @Test
    void selectionSortTest() {
        testSortType(SortTypes.SortType.SelectionSort);
    }

    @Test
    void heapSortTest() {
        testSortType(SortTypes.SortType.HeapSort);
    }

    @Test
    void mergeSortTest() {
        testSortType(SortTypes.SortType.MergeSort);
    }

    @Test
    void quickSortTest() {
        testSortType(SortTypes.SortType.QuickSort);
    }

    @Test
    void radixSortTest() { testSortType(SortTypes.SortType.RadixSort); }

    @Test
    void introSortTest() {
        testSortType(SortTypes.SortType.IntroSort);
    }

    @Test
    void countingSortTest() {
        testSortType(SortTypes.SortType.CountingSort);
    }
}
