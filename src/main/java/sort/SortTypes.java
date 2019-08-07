package sort;

import java.lang.reflect.Constructor;
import java.util.*;
import java.util.stream.Collectors;

public class SortTypes {

    private Map<SortType, Sort> sortTypes = new HashMap<>();

    public SortTypes() {
        sortTypes.put(SortType.BubbleSort, new BubbleSort());
        for (SortType type : SortType.values()) {
            try {
                Class<?> clas = Class.forName("sort." + type);
                Constructor<?> ctor = clas.getConstructor();
                Sort sortType = (Sort) ctor.newInstance();
                sortTypes.put(type, sortType);
            } catch (Exception e) {
                System.out.println("Can't find class " + type.toString());
            }
        }
    }

    public Set<SortType> getSortTypes() {
        return sortTypes.keySet();
    }


    public Set<String> getSortNames() {
        return sortTypes.keySet().stream().map(SortType::toString).collect(Collectors.toSet());
    }

    public Sort getSortAlgorithm(SortType type) {
        return sortTypes.get(type);
    }


    public enum SortType {
        BubbleSort(1),
        InsertionSort(2),
        SelectionSort(3),
        HeapSort(4),
        MergeSort(5),
        QuickSort(6),
        CountingSort(7),
        RadixSort(8),
        IntroSort(9);

        public final int order;

        private SortType(int order) {
            this.order = order;
        }

        public String getName() {
            return this.toString().replaceAll("(.)([A-Z])", "$1 $2");
        }
    }
}

