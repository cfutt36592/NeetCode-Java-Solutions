class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return backtrack(nums, nums.length, target);
    }

    public int backtrack(int[] nums, int i, int target){
        if(i == 0){
            if(target == 0) return 1;
            else return 0;
        }
        else{
            return (
                backtrack(nums, i - 1, target - nums[i - 1]) +
                backtrack(nums, i - 1, target + nums[i - 1])
            );
        }
    }
}
