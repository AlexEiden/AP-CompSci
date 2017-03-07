import java.util.*;

public class Lab51_1 {

    public static Comparable[] merge(Comparable[] ar1, Comparable[] ar2) {
        int arr[][] = new int[ar1.length][2];
        if (ar1.length != ar2.length) {
            throw new IllegalArgumentException("you done goofed; lengths of arrays are not equal");
        }
        for (int i = 0; i < ar1.length; i++) {
            arr[i][0] = ar1[i];
            arr[i][1] = ar2[i];
        }
        return arr;
    }

    public static Comparable[] mergeSort(Comparable[] ar) {
        if (ar.length <= 1) { //base case
            return ar
        }

        int i = ar.length/2;
        Comparable[] leftArray = Arrays.copyOfRange(ar, 0, i-1); //copyOfRange does not work, use given method
        Comparable[] rightArray = Arrays.copyOfRange(ar, i, ar.length-1);

        mergeSort(leftArray);
        mergeSort(rightArray);

        merge(leftArray, rightArray)


    }
}