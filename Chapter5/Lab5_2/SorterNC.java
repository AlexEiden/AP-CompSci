import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Sorter {

    // Number of threads to use for sorting
    private static final int N_THREADS = Runtime.getRuntime().availableProcessors();

    // Multiple to use when determining when to fall back.
    private static final int FALLBACK = 2;

    // Thread pool used for executing sorting Runnables.
    private static Executor pool = Executors.newFixedThreadPool(N_THREADS);


    public static <T extends Comparable<T>> void quicksort(T[] input) {
        final AtomicInteger count = new AtomicInteger(1);
        pool.execute(new QuicksortRunnable<T>(input, 0, input.length - 1, count)); //Will execute on a new thread in the pool at the given time
        try {
            synchronized (count) {
                count.wait(); //.wait inherited from Object class
            }
        } catch (InterruptedException e) { //just in case
            e.printStackTrace();
        }
    }

    private static class QuicksortRunnable<T extends Comparable<T>> implements Runnable {
        //The array being sorted.
        private final T[] values;
        //The starting index of the section of the array to be sorted.
        private final int left;
        //The ending index of the section of the array to be sorted.
        private final int right;
        //The number of threads currently executing.
        private final AtomicInteger count;

        public QuicksortRunnable(T[] values, int left, int right, AtomicInteger count) {
            this.values = values;
            this.left = left;
            this.right = right;
            this.count = count;
        }

        @Override
        public void run() {
            quicksort(left, right);
            synchronized (count) {
                // AtomicInteger.getAndDecrement() returns the old value. If the old value is 1, then we know that the actual value is 0.
                if (count.getAndDecrement() == 1)
                    count.notify();
            }
        }

        private void quicksort(int pLeft, int pRight) {
            if (pLeft < pRight) {
                int storeIndex = partition(pLeft, pRight);
                if (count.get() >= FALLBACK * N_THREADS) {
                    quicksort(pLeft, storeIndex - 1);
                    quicksort(storeIndex + 1, pRight);
                } else {
                    count.getAndAdd(2);
                    pool.execute(new QuicksortRunnable<T>(values, pLeft, storeIndex - 1, count));
                    pool.execute(new QuicksortRunnable<T>(values, storeIndex + 1, pRight, count));
                }
            }
        }

        private int partition(int pLeft, int pRight) {
            T pivotValue = values[pRight];
            int storeIndex = pLeft;
            for (int i = pLeft; i < pRight; i++) {
                if (values[i].compareTo(pivotValue) < 0) {
                    swap(i, storeIndex);
                    storeIndex++;
                }
            }
            swap(storeIndex, pRight);
            return storeIndex;
        }

        private void swap(int left, int right) {
            T temp = values[left];
            values[left] = values[right];
            values[right] = temp;
        }
    }
}