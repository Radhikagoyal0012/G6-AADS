public class SubarraySumEqualsKBruteForce {
    public static int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count = 0;

        // Check all possible subarrays
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];  // sum of subarray nums[i..j]
                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int k = 3;
        System.out.println("Number of subarrays with sum " + k + " is: " + subarraySum(nums, k));
    }
}

