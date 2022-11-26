class Solution {
    public int missingNumber(int[] nums) {
        //sum of all in range minus sum of nums - use XOR for bit manipulation
        int res = nums.length;

        for(int i = 0; i < nums.length; i++){
            res += (i - nums[i]);
        }

        return res;
    }
}
