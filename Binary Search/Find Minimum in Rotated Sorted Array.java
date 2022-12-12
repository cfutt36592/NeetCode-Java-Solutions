class Solution {
    public int findMin(int[] nums) {
        return binarySearch(nums, 0, nums.length-1);
    }
    
    public int binarySearch(int[] nums, int low, int high){
        if(low > high)return nums[0];
        if(low == high)return nums[low];
        
        int mid = low + (high - low) / 2;
        
        if(mid < high && nums[mid] > nums[mid + 1])
            return nums[mid+1];
        if(mid > low && nums[mid] < nums[mid - 1])
            return nums[mid];
        
        if(nums[mid] < nums[high])
            return binarySearch(nums, low, mid - 1);
        return binarySearch(nums, mid + 1, high);
    }
}
