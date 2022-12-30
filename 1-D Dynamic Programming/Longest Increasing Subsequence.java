class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null) return 0;
        int[] dp = new int[nums.length];
        dp[nums.length-1] = 1;
        int max = 1;

        for(int i = nums.length-2; i>=0; i--){
            dp[i] = 1;
            for(int j = i; j<nums.length; j++){
                if(nums[i] < nums[j]){
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        
        return max;
    }
}
