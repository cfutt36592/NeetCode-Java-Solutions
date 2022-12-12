class Solution {
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums, 0, nums.length);
        
        int n = nums.length;
        
        if (pivot == -1)
            return binarySearch(nums, 0, n - 1, target);
        
        if (nums[pivot] == target)
            return pivot;
        if (nums[0] <= target)
            return binarySearch(nums, 0, pivot - 1, target);
        return binarySearch(nums, pivot + 1, n - 1, target);
    }
    
    public int findPivot(int nums[], int low, int high){
        if (high < low)
            return -1;
        if (high == low)
            return low;
        
        int mid =  low + (high - low)/2;
        
        if (mid < high && nums[mid] > nums[mid + 1] && nums.length>1)
            return mid;
        if (mid > low && nums[mid] < nums[mid - 1] && nums.length>1)
            return (mid - 1);
        if (nums[low] >= nums[mid])
            return findPivot(nums, low, mid - 1);
        return findPivot(nums, mid + 1, high);
    }
    
    public int binarySearch(int arr[], int low, int high, int key){
        if (high < low)
            return -1;
 
        /* low + (high - low)/2; */
        int mid = (low + high) / 2;
        if (key == arr[mid])
            return mid;
        if (key > arr[mid])
            return binarySearch(arr, (mid + 1), high, key);
        return binarySearch(arr, low, (mid - 1), key);
    }
}
