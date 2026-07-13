public class minJumps {
    public static int MinJumps(int[] nums) {
        int n = nums.length;

        if (n <= 1)
            return 0;

        if (nums[0] == 0)
            return -1;

        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            if (i == currentEnd) {
                if (farthest == currentEnd)
                    return -1;   // Cannot move further

                jumps++;
                currentEnd = farthest;

                if (currentEnd >= n - 1)
                    return jumps;
            }
        }

        return currentEnd >= n - 1 ? jumps : -1;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 3, 1, 1, 4};
        int[] nums2 = {1, 0, 1, 0};
        int[] nums3 = {1, 2, 3};

        System.out.println("Minimum jumps for nums1: " + MinJumps(nums1)); // Expected 2
        System.out.println("Minimum jumps for nums2: " + MinJumps(nums2)); // Expected -1
        System.out.println("Minimum jumps for nums3: " + MinJumps(nums3)); // Expected 2
    }
}
