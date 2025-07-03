import java.util.Arrays;
import java.util.Comparator;

public class maxLengthChainOfPairs {
    public static void main(String args[]) {
        int nums[][] = { {5,24}, {39,60}, {5,38}, {27,40}, {50,90} };

        // Sort by starting point
        Arrays.sort(nums, Comparator.comparingInt(x -> x[0]));

        int ans[][] = new int[nums.length][2];
        ans[0] = nums[0]; // first pair in the chain
        int ele = nums[0][1]; // end of the first pair
        int j = 0;

        for (int i = 1; i < nums.length; i++) {
            // Check for non-overlapping condition
            if (ele < nums[i][0]) {
                ans[++j] = nums[i];

                ele = nums[i][1]; // update end
            }
        }

        System.out.println("Maximum Length Chain of Pairs:");
        for (int i = 0; i <= j; i++) {
            System.out.println(Arrays.toString(ans[i]));
        }
    }
}
