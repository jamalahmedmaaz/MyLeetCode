package dynamicprogramming;

public class MaximumSubarray {
    public static void main(String[] args) {
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        System.out.println(maximumSubarray.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maximumSubarray.maxSubArray(new int[]{-2, -1}));

    }

    public int maxSubArray(int[] nums) {

        int[][] mem = new int[nums.length][nums.length];

        int max = 0;
        boolean result = false;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {

                int previous = 0;
                if (j != 0) {
                    previous = mem[i][j - 1];
                }
                mem[i][j] = previous + nums[j];
                if (max < mem[i][j]) {
                    max = mem[i][j];
                    result = true;
                }
            }
        }

       /* for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                System.out.print(mem[i][j] + " ");
            }
            System.out.println();
        }*/

        if (!result) {
            int highestValue = Integer.MIN_VALUE;
            for (int num : nums) {
                if (highestValue < num) {
                    highestValue = num;
                    max = highestValue;
                }
            }
        }

        return max;
    }
}
