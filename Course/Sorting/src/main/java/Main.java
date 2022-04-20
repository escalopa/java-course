import sorts.CountingSort;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        //Unsorted array
        int[] arr = new int[]{4,5,6,7,4,3,1,4,0,2,4,5,2};

        //Count sort
        System.out.println(Arrays.toString(CountingSort.sort(arr, 0, 7)));
    }
}
