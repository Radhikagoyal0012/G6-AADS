import java.util.*;

public class shortestSubarray {
    public static int shortestsubarray(int[] nums, int k) {
        int n = nums.length;
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        int result = n + 1;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int j = 0; j <= n; j++) {
            while (!deque.isEmpty() && prefix[j] - prefix[deque.peekFirst()] >= k) {
                result = Math.min(result, j - deque.pollFirst());
            }
            while (!deque.isEmpty() && prefix[j] <= prefix[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(j);
        }
        return result <= n ? result : -1;
    }

    public static void main(String[] args) {
        int[] nums = {2, -1, 2};
        int k = 3;
        int ans = shortestsubarray(nums, k);
        System.out.println("Shortest subarray length with sum ≥ " + k + " is: " + ans);
    }
}
