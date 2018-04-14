package dynamicprogramming;

public class HouseRobber {
    public static void main(String[] args) {
        HouseRobber houseRobber = new HouseRobber();
        System.out.println(houseRobber.rob(new int[]{4, 1, 2, 7, 5, 3, 1}));
        System.out.println(houseRobber.rob(new int[]{1, 2, 3, 4, 5}));
    }

    private int rob(int[] ints) {

        int conmax = 0;
        int unconmax = 0;

        for (int i = 1; i <= ints.length; i++) {
            int tmp = unconmax;
            unconmax = Math.max(conmax, unconmax);
            conmax = ints[i - 1] + tmp;
        }

        return Math.max(unconmax, conmax);
    }
}
