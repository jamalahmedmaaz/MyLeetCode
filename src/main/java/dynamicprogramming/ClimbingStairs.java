package dynamicprogramming;

public class ClimbingStairs {
    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();

        System.out.println(climbingStairs.climbStairs(101));
    }

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        return myClimStairs(n, dp);
    }

    private int myClimStairs(int n, int[] dp) {
        if (n < 0) {
            return 0;
        }

        if (n == 0) {
            return 1;
        }

        if (dp[n] != 0) {
            return dp[n];
        } else {
            dp[n] = myClimStairs(n - 1, dp) + myClimStairs(n - 2, dp);
            return dp[n];
        }
    }
}