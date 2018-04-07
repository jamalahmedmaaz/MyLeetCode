package dynamicprogramming;

/**
 * Created by jamal on 8/4/18.
 */
public class MinCostClimbingStairs {
    public static void main(String[] args) {
        int[] cost = new int[]{10, 15, 20};

        int[] mem = new int[cost.length + 1];


        mem[0] = cost[0];
        mem[1] = cost[1];

        for (int i = 2; i <= cost.length; i++) {
            int costTillHere = i == cost.length ? 0 : cost[i];
            mem[i] = Math.min(mem[i - 1] + costTillHere, mem[i - 2] + costTillHere);
        }

        System.out.println(mem[cost.length]);


        int a = cost[0];
        int b = cost[1];

        int result = 0;

        for (int i = 2; i <= cost.length; i++) {
            int costTillHere = i == cost.length ? 0 : cost[i];
            result = Math.min(a + costTillHere, b + costTillHere);

            a = b;
            b = result;
        }

        System.out.println(result);
    }


}
