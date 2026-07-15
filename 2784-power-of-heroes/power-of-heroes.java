import java.util.Arrays;

class Solution {
    public int sumOfPower(int[] nums) {
        long MOD = 1000000007;
        Arrays.sort(nums);
        
        long totalPower = 0;
        long minSum = 0; // Tracks the contribution of minimums for previous elements
        
        for (int num : nums) {
            long val = num;
            long square = (val * val) % MOD;
            
            // Current element acts as both max and min, or max with previous min elements
            long currentContribution = (square * ((val + minSum) % MOD)) % MOD;
            totalPower = (totalPower + currentContribution) % MOD;
            
            // Update minSum for the next iteration
            minSum = ((minSum * 2) % MOD + val) % MOD;
        }
        
        return (int) totalPower;
    }
}
