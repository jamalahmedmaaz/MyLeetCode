package dynamicprogramming;

public class HouseRobberII {

    public static void main(String[] args) {
        HouseRobberII houseRobberII = new HouseRobberII();
        System.out.println(houseRobberII.rob(new int[]{1, 2, 3, 4, 5}));
        System.out.println(houseRobberII.rob(new int[]{1}));
        System.out.println(houseRobberII.rob(new int[]{1, 2}));
        System.out.println(houseRobberII.rob(new int[]{1, 2, 2}));
        System.out.println(houseRobberII.rob(new int[]{1, 2, 3}));
        System.out.println(houseRobberII.rob(new int[]{2, 1, 1, 1}));
    }

    public int rob(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            if (nums[0] > nums[1]) {
                return nums[0];
            } else {
                return nums[1];
            }
        }

        int uncon = 0;
        int con = 0;


        // Consider first element and dont consider the last element in the array.
        for (int i = 1; i <= nums.length - 1; i++) {
            int tmp = uncon;
            uncon = Math.max(uncon, con);
            con = nums[i - 1] + tmp;
        }

        int uncon1 = 0;
        int con1 = 0;

        // Consider the last element and dont consider the first element of the array.
        for (int i = 2; i <= nums.length; i++) {
            int tmp = uncon1;
            uncon1 = Math.max(uncon1, con1);
            con1 = nums[i - 1] + tmp;
        }


        return Math.max(Math.max(uncon, con), Math.max(uncon1, con1));
    }
}