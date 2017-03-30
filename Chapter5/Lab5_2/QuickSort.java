public class QuickSort {

    public static void sort(Comparable[] input) {
        quicksort(input, 0, input.length-1);
    }

    public static void quicksort(Comparable[] input, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int storeIndex = partition(input, leftIndex, rightIndex);
                quicksort(input, leftIndex, storeIndex - 1);
                quicksort(input, storeIndex + 1, rightIndex);
        }
    }

    private static int partition(Comparable[] input, int leftIndex, int rightIndex) {
        Comparable pivotValue = input[rightIndex];
        int storeIndex = leftIndex;
        for (int i = leftIndex; i < rightIndex; i++) {
            if (input[i].compareTo(pivotValue) < 0) {
                swap(input, i, storeIndex);
                storeIndex++;
            }
        }
        swap(input, storeIndex, rightIndex);
        return storeIndex;
    }

    private static void swap(Comparable[] input, int left, int right) {
        Comparable temp = input[left];
        input[left] = input[right];
        input[right] = temp;
    }
}