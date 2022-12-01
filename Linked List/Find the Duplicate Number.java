class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        boolean first = true;
        while(first || slow != fast){
            if(first) first = false;
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast) break;
        }

        int slow2 = nums[0];
        while(slow2 != slow){
            slow2 = nums[slow2];
            slow = nums[slow];
            if(slow2 == slow) return slow;
        }
        return slow;
    }
}