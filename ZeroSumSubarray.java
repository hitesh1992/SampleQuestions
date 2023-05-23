import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZeroSumSubarray {

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

  /*method finds all the subarrays whose elements sum to zero. 
  It uses a Map to keep track of the cumulative sum of elements encountered so far. If the same sum is encountered again, it means there is a subarray with a sum of zero. 
  The program then creates a new subarray starting from the previous occurrence of the sum and ending at the current index */
    public static List<int[]> findZeroSumSubarrays(int[] array) {
        List<int[]> subarrays = new ArrayList<>();
        Map<Integer, Integer> sumMap = new HashMap<>();
        int sum = 0;

        // Add an initial sum of zero at index -1 to handle subarrays starting from the beginning
        sumMap.put(0, -1);

        for (int i = 0; i < array.length; i++) {
            sum += array[i];

            if (sumMap.containsKey(sum)) {
                int startIndex = sumMap.get(sum) + 1;
                int endIndex = i;
                int[] subarray = new int[endIndex - startIndex + 1];
                System.arraycopy(array, startIndex, subarray, 0, subarray.length);
                subarrays.add(subarray);
            } else {
                sumMap.put(sum, i);
            }
        }

        return subarrays;
    }
}
