public class subarraySum {
    public static int maxSubarraySum(int[] arr) {
        int maxSoFar = arr[0];   // best sum found so far
        int currentMax = arr[0]; // best sum ending at current position

        for (int i = 1; i < arr.length; i++) {
            // Either extend the previous subarray or start fresh from current element
            currentMax = Math.max(arr[i], currentMax + arr[i]);
            maxSoFar = Math.max(maxSoFar, currentMax);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Maximum Subarray Sum is: " + maxSubarraySum(arr));
    }
}
