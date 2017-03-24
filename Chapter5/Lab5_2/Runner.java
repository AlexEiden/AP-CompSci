import java.util.Random;

public class Runner {
	public static final int ARR_LEN=20000000;
	public static final int ITERATIONS=20;

    public static void main(String[] args){
		System.out.printf(
			"ARR_LEN=                   %d\n" + 
			"ITERATIONS=                %d\n",
			ARR_LEN, ITERATIONS
		);


		long timeSum= 0;
		for(int iter=0; iter<ITERATIONS; iter++){
			Random r = new Random(424242); 
			Integer[] arr = new Integer[ARR_LEN];
			for(int i = 0; i< ARR_LEN; i++){
				arr[i] = r.nextInt(Integer.MAX_VALUE);
			}

			long start = System.nanoTime(); // record start time
			
			Sorter.quicksort(arr);

			long time = System.nanoTime() - start; // record end time
			timeSum += time;

			// Verify the array is sorted
			for(int i = 1; i<arr.length; i++){
				if(arr[i].compareTo(arr[i-1]) < 0){
					System.out.printf("Sort failed at i=%d\n", i);
					break;
				}
			}
		}
		System.out.println("Average time: " + (double)(timeSum/ITERATIONS)/Math.pow(10, 9));

		System.exit(0);

    }
}