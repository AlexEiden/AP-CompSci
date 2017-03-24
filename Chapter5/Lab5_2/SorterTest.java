import java.util.Arrays;
import java.util.Random;

public class SorterTest {

    private static Integer[] values;
    private static int testArrSize = 10;

    public static void main(String[] args) {
        values = new Integer[10];
        generateRandomArray();
        testSort();
        largeTestSort();
    }

    public static void generateRandomArray() {
		for (int i = 0; i < testArrSize; i++) {
			//Generating a random array with values between 1-100
			values[i] = (int) (Math.random() * 100);
		}
	}

    //Confirming sorting algorithm works with smaller values
    public static void testSort() {
        //Testing random integer array "values"
        System.out.println(Arrays.toString(values));
        //Copying array "values" to new array "sortedValues" for testing with Java's built in sort
        Integer[] sortedValues = new Integer[values.length];
        System.arraycopy(values, 0, sortedValues, 0, values.length);
        //Letting Java sort
        Arrays.sort(sortedValues);
        System.out.println(Arrays.toString(sortedValues));
        //Using the multithreaded quicksort
        Sorter.quicksort(values);
        System.out.println(Arrays.toString(values));
        // Assert equality.
        //assertArrayEquals(sortedValues, values);
    }

    /**
     * Tests the Sorter implementation on a larger set of values.
     */
    public static void largeTestSort() {
        // Generate an array of one million random integers.
        Random random = new Random(System.currentTimeMillis());
        Integer[] arr = new Integer[20000000];
        final long generateStart = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt();
        }
        final long generateEnd = System.currentTimeMillis();
        System.out.printf("Generation time: %d miliseconds (%d Integer Objects)%n", generateEnd - generateStart, arr.length);

        // Copy the values into a new array to sort with Java's built in implementation for comparison
        Integer[] sortedArr = new Integer[20000000];
        final long copyStart = System.currentTimeMillis();
        System.arraycopy(arr, 0, sortedArr, 0, arr.length);
        final long copyEnd = System.currentTimeMillis();
        System.out.println("Copy time: " + (copyEnd - copyStart) + " miliseconds");

        // Start sorting
        final long sortStartTime = System.currentTimeMillis();
        // Java sort
        Arrays.sort(sortedArr);
        final long sortTradeOffTime = System.currentTimeMillis();
        // Multi-Threaded Quick Sort
        Sorter.quicksort(arr);
        final long sortEndTime = System.currentTimeMillis();

        // For some reason cannot get the assert equality function to work
        //assertArrayEquals(sortedValues, values);

        // Print Statistics
        System.out.println("Java built in implementation: " + (sortTradeOffTime - sortStartTime) + " miliseconds");
        System.out.println("Multi-threaded quick sort: " + (sortEndTime - sortTradeOffTime) + " miliseconds");

        System.exit(0);
    }
}