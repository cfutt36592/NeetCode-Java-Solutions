class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 1) return nums[0];

        int res = nums[0];
        int max = 1;
        int min = 1;

        for(int n : nums){
            int a = n * max;
            int b = n * min;
            max = Math.max(Math.max(a,b), n);
            min = Math.min(Math.min(a,b), n);
            res = Math.max(res, max);
        }
        return res;
    }
}
