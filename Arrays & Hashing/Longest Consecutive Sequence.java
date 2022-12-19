class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        int max = 0;

        for(int n : nums) set.add(n);
        for(int n : nums){
            if(!set.contains(n - 1)){
                int count = 1;
                while(set.contains(n+1)){
                    n++;
                    count++;
                }
                max = Math.max(max, count);
            }
        }
        
        return max;
    }
}
