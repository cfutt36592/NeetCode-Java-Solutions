class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        findComb(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    public void findComb(int[] candidates, int index, int target, List<Integer> current, List<List<Integer>> result){
        if(target == 0){
            result.add(new ArrayList<>(current));
        }
        else if(target < 0) return;
        else{
            for(int i = index; i < candidates.length; i++){
                if(i > index && candidates[i] == candidates[i - 1]) continue;
                current.add(candidates[i]);
                findComb(candidates, i + 1, target - candidates[i], current, result);
                current.remove(current.get(current.size() - 1));
            }
        }
    }
}
