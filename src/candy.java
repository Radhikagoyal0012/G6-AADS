import java.util.Arrays;

public class candy {
    public static int Candy(int[] nums) {
        int n = nums.length;

        if (n == 0) return 0;

        int[] candies = new int[n];

        // Every child gets at least one candy
        Arrays.fill(candies, 1);

        // Left to right
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Right to left
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        int sum = 0;
        for (int c : candies) {
            sum += c;
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] ratings1 = {1, 0, 2};
        int[] ratings2 = {1, 2, 2};
        int[] ratings3 = {1, 3, 4, 5, 2};

        System.out.println("Total candies for ratings1: " + Candy(ratings1)); // Expected 5
        System.out.println("Total candies for ratings2: " + Candy(ratings2)); // Expected 4
        System.out.println("Total candies for ratings3: " + Candy(ratings3)); // Expected 11
    }
}
