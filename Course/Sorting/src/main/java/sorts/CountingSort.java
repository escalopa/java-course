package sorts;

public class CountingSort {
    public static int[] sort(int[] arr, int min, int max) {

        int size = max - min + 1;

        //An array in which we save the number of repetitions of each value in the
        //incoming array
        int[] temp_array = new int[size];

        //Count reps
        for (int i = 0; i < arr.length; i++) {
            int index = arr[i] - min;
            temp_array[index]++;
        }

        //New array in which we will insert sorted values
        int[] sorted_array = new int[arr.length];

        //Insert values into array
        for (int i = 0, k = 0; i < temp_array.length; i++) {
            if (temp_array[i] != 0) {
                int value = min + i;
                sorted_array[k] = value;
                temp_array[i]--;
                i--;
                k++;
            }
        }
        return sorted_array;
    }
}

