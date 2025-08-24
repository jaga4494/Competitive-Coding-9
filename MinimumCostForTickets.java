class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        if (days == null || days.length == 0) {
            return 0;
        }

        int dp[] = new int[days[days.length - 1] + 1];
        int daysIndex = 0;

        for (int i = 1; i < dp.length; ++i) {

            if (i == days[daysIndex]) {
                int cost1 = costs[0] + dp[Math.max(i - 1, 0)];
                int cost2 = costs[1] + dp[Math.max(i - 7, 0)];
                int cost3 = costs[2] + dp[Math.max(i - 30, 0)];

                dp[i] = Math.min(cost1, Math.min(cost2, cost3));
                ++daysIndex;
            } else {
                dp[i] = dp[i - 1];
            }

            
        }

        return dp[dp.length - 1];
    }
}