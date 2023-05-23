import java.util.ArrayList;
import java.util.List;

public class ZeroSumSubarray2 {

    public static void main(String[] args) {
        int[] array = {4, 2, -3, -1, 0, 4};

        List<int[]> subarrays = findZeroSumSubarrays(array);
        if (subarrays.isEmpty()) {
            System.out.println("No subarray with a sum of zero found.");
        } else {
            System.out.println("Subarrays with a sum of zero:");
            for (int[] subarray : subarrays) {
                for (int num : subarray) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
        }
    }

  /*method uses two nested loops to iterate over all possible subarrays. 
  It starts with an outer loop that selects the starting index of the subarray, and an inner loop that selects the ending index. 
  It calculates the sum of the elements between the selected indices and checks if the sum is zero.
  If it is, a subarray with a sum of zero is found and added to the list of subarrays.*/
    public static List<int[]> findZeroSumSubarrays(int[] array) {
        List<int[]> subarrays = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            int sum = 0;
            for (int j = i; j < array.length; j++) {
                sum += array[j];
                if (sum == 0) {
                    int[] subarray = new int[j - i + 1];
                    System.arraycopy(array, i, subarray, 0, subarray.length);
                    subarrays.add(subarray);
                }
            }
        }

        return subarrays;
    }
}
