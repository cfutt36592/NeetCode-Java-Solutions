class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);

        return Math.max(
            robHelper(nums, 0, nums.length - 2),
            robHelper(nums, 1, nums.length - 1)
        );
    }

    public int robHelper(int[] nums, int start, int end){
        int[] dp = new int[end - start + 1];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);
        int dpi = 2;

        for(int i = start + 2; i <= end; i++){
            dp[dpi] = Math.max(dp[dpi - 1], nums[i] + dp[dpi - 2]);
            dpi++;
        }

        return dp[dp.length - 1];
    }
}
