class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        subsets(nums, 0, res, list);
        return res;
    }

    public void subsets(int[] nums, int index, List<List<Integer>> res, List<Integer> list){
        res.add(new ArrayList<>(list));

        for(int i = index; i < nums.length; i++){
            if(i > index && nums[i] == nums[i - 1]) continue;
            list.add(nums[i]);
            subsets(nums, i + 1, res, list);
            list.remove(list.size() - 1);
        }
    }
}
