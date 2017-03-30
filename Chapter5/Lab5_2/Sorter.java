/* This is a header:
    Name: Alex
    Teacher name: Ms. Tompsett
    Class: AP CompSci
    Lab: Lab5.2

    Yay for headers
    P.S. There is a pretty huge biliography at the end of this... I think I'm missing a few of the sources I used because I used so many, but most are there
*/

// O. M. G. I spent SO MANY FREAKING HOURS ON THIS IT ISN'T EVEN FUNNY. But I learned a lot about numerous types of multithreading!
// Executor pools are used here as to allow Java to handle what threads do what to an extent
// Ah I also figured since I'm spending so much time on this, might as well make useful comments, and hell, javadoc this too. @PARAM FTW

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger; // Much faster than using syncronized numbers

public class Sorter {

    // Number of threads to use for sorting
    private static final int N_THREADS = Runtime.getRuntime().availableProcessors();
    // Multiple to use when determining when to fall back. 2 because each time the quicksort method is used two threads are used, so we need to make sure that 2 threads are availible
    private static final int FALLBACK = 2;
    // Thread pool used for executing sorting Runnables.
    private static Executor pool = Executors.newFixedThreadPool(N_THREADS);

    /**
     * Main method used for sorting from clients. Input is sorted in place using multiple threads.
     * @param input The array to sort.
     * @param <T>   The type of the objects being sorted, must extend Comparable. Using generics just makes testing easier while still being compatible with Comparable objects.
     * Hell, it's based off of Comparable due to it extending Comparable
     */
    public static <T extends Comparable<T>> void quicksort(T[] input) {
        final AtomicInteger count = new AtomicInteger(1); //Atomic integers allow values to be handled amongst numerous threads
        pool.execute(new QuicksortRunnable<T>(input, 0, input.length - 1, count)); //Will execute on a new thread in the pool at the given time
        //try_catch block isn't really necessary, but meh something else I picked up on the way!
        try {
            synchronized (count) {
                count.wait(); //.wait inherited from Object class (never thought using the Object class would come in handy)
            }
        } catch (InterruptedException e) { //just in case
            e.printStackTrace();
        }
    }

    /**
     * This sorts a section of an array using quicksort. This isn't technically recursive since it is just creating new
     * runnables and handing them off to the ThreadPoolExecutor, but hey, it works.
     * @param <T> The type of the objects being sorted, must extend Comparable.
     */
    // Static nested class! It can be accessed without instantiating the outer class which keeps things simple, yay!
    private static class QuicksortRunnable<T extends Comparable<T>> implements Runnable { // putting the subclass in the main class just keeps the code simpler since only one file uses it anyways
        // The array being sorted.
        private final T[] values;
        // The starting index of the section of the array to be sorted.
        private final int left;
        // The ending index of the section of the array to be sorted.
        private final int right;
        // The number of threads currently executing.
        private final AtomicInteger count;

        /**
         * Default constructor; this sets the variables to be used by the runnable object
         * @param values The array to sort.
         * @param left   The starting index of the section of the array to be sorted.
         * @param right  The ending index of the section of the array to be sorted.
         * @param count  The number of currently executing threads.
         */
        public QuicksortRunnable(T[] values, int left, int right, AtomicInteger count) {
            this.values = values;
            this.left = left;
            this.right = right;
            this.count = count;
        }

        /**
         * This is the thread's run logic. When the current thread completes its assigned task it checks the other threads.
         * Then the count object is notified allowing quicksort (in the main class) to stop blocking new threads.
         */
        @Override
        public void run() {
            quicksort(left, right);
            synchronized (count) {
                // AtomicInteger.getAndDecrement() returns the old value. If the old value is 1, then we know that the actual value is 0. (kinda like var--)
                if (count.getAndDecrement() == 1)
                    count.notify();
            }
        }

        /**
         * Method which actually does the sorting. Falls back on recursion if there are a certain number of queued/running tasks.
         * @param leftIndex  The left index of the sub array to sort.
         * @param rightIndex The right index of the sub array to sort.
         */
        private void quicksort(int leftIndex, int rightIndex) {
            if (leftIndex < rightIndex) {
                int storeIndex = partition(leftIndex, rightIndex);
                if (count.get() >= FALLBACK * N_THREADS) {
                    quicksort(leftIndex, storeIndex - 1);
                    quicksort(storeIndex + 1, rightIndex);
                } else {
                    count.getAndAdd(2);
                    pool.execute(new QuicksortRunnable<T>(values, leftIndex, storeIndex - 1, count));
                    pool.execute(new QuicksortRunnable<T>(values, storeIndex + 1, rightIndex, count));
                }
            }
        }

        /**
         * Partitions the portion of the array between indexes left and right, inclusively, by moving all elements less
         * than values[pivotIndex] before the pivot, and the equal or greater elements after it.
         * @param leftIndex
         * @param rightIndex
         * @return The final index of the pivot value.
         */
        private int partition(int leftIndex, int rightIndex) {
            T pivotValue = values[rightIndex];
            int storeIndex = leftIndex;
            for (int i = leftIndex; i < rightIndex; i++) {
                if (values[i].compareTo(pivotValue) < 0) {
                    swap(i, storeIndex);
                    storeIndex++;
                }
            }
            swap(storeIndex, rightIndex);
            return storeIndex;
        }

        /**
         * Simple swap method.
         * @param left  The index of the first value to swap with the second value.
         * @param right The index of the second value to swap with the first value.
         */
        private void swap(int left, int right) {
            T temp = values[left];
            values[left] = values[right];
            values[right] = temp;
        }
    }
}


/*
Bibliography:
QuickSort: https://www.youtube.com/watch?v=SLauY6PpjW4
           https://www.cs.usfca.edu/~galles/visualization/ComparisonSort.html
           https://en.wikipedia.org/wiki/Quicksort
           https://www.youtube.com/watch?v=aQiWF4E8flQ – didn't like this one too much...
Interface Executor: http://docs.oracle.com/javase/7/docs/api/java/util/concurrent/Executor.html
Atomic Integer: http://stackoverflow.com/questions/4818699/practical-uses-for-atomicinteger
                https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/atomic/AtomicInteger.html
Nested Classes: http://docs.oracle.com/javase/tutorial/java/javaOO/nested.html
                http://www.tutorialspoint.com/java/java_innerclasses.htm
Generics: http://www.tutorialspoint.com/java/java_generics.htm
*/